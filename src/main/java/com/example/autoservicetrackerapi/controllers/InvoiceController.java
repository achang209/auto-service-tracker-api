package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.Invoice;
import com.example.autoservicetrackerapi.models.InvoiceDao;
import com.example.autoservicetrackerapi.services.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private FileService fileService;

    @GetMapping("invoices")
    public List<Invoice> getInvoices () {
        return (List<Invoice>) invoiceDao.findAll();
    }

    @PostMapping("invoices")
    public void addInvoice(@RequestParam String invoice, @RequestParam MultipartFile file) throws IOException {
        fileService.uploadFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(fileService.getFileName(file)).toUriString();
        Invoice invoiceObj = new ObjectMapper().readValue(invoice, Invoice.class);
        invoiceObj.setFilePath(fileDownloadUri);
        invoiceDao.save(invoiceObj);
    }
}
