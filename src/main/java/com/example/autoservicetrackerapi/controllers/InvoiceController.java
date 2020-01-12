package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.Invoice;
import com.example.autoservicetrackerapi.models.InvoiceDao;
import com.example.autoservicetrackerapi.services.FileService;
import com.example.autoservicetrackerapi.services.FileStorageServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private FileService fileService;

    @Autowired
    private FileStorageServiceImpl fileStorageService;

    @GetMapping("invoices")
    public List<Invoice> getInvoices () {
        return (List<Invoice>) invoiceDao.findAll();
    }

    @GetMapping("downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        Resource resource = fileService.loadFileAsResource(fileName);
        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", resource.getFilename()))
                .body(resource);
    }

    @PostMapping("invoices")
    public void addInvoice(@RequestParam String invoice, @RequestParam MultipartFile file) throws IOException {
        fileStorageService.store(file);
        String fileDownloadUri = fileService.getFileDownloadUri(file);
        Invoice invoiceObj = new ObjectMapper().readValue(invoice, Invoice.class);
        invoiceObj.setFilePath(fileDownloadUri);
        invoiceDao.save(invoiceObj);
    }
}
