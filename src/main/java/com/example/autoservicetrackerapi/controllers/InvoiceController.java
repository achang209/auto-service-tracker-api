package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.*;
import com.example.autoservicetrackerapi.models.ui.InvoiceRequest;
import com.example.autoservicetrackerapi.models.ui.InvoiceResponse;
import com.example.autoservicetrackerapi.services.FileStorageServiceImpl;
import com.example.autoservicetrackerapi.services.InvoiceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Autowired
    private FileStorageServiceImpl fileStorageService;

    @GetMapping("invoices")
    public List<InvoiceResponse> getInvoices () {

        List<InvoiceDto> invoices = invoiceService.getInvoices();
        List<InvoiceResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : invoices) {
            InvoiceResponse invoiceResponse = new InvoiceResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceResponse);
            returnValue.add(invoiceResponse);
        }
        return returnValue;
    }

    @GetMapping("downloadFile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=\"%s\"", resource.getFilename()))
                .body(resource);
    }

    @PostMapping("invoices")
    public InvoiceResponse createInvoice(@RequestParam String invoice, @RequestParam MultipartFile file) throws IOException {

        InvoiceRequest invoiceRequest = new ObjectMapper().readValue(invoice, InvoiceRequest.class);
        invoiceRequest.setFile(file);

        InvoiceDto invoiceDto = new InvoiceDto();
        BeanUtils.copyProperties(invoiceRequest, invoiceDto);
        InvoiceDto createdInvoice = invoiceService.createInvoice(invoiceDto);

        InvoiceResponse returnValue = new InvoiceResponse();
        BeanUtils.copyProperties(createdInvoice, returnValue);

        return returnValue;

    }
}
