package com.example.autoservicetrackerapi.controller;

import com.example.autoservicetrackerapi.model.*;
import com.example.autoservicetrackerapi.model.ui.InvoiceDetailsRequest;
import com.example.autoservicetrackerapi.model.ui.InvoiceDetailsResponse;
import com.example.autoservicetrackerapi.service.FileStorageServiceImpl;
import com.example.autoservicetrackerapi.service.InvoiceServiceImpl;
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
    public List<InvoiceDetailsResponse> getInvoices () {

        List<InvoiceDto> invoices = invoiceService.getInvoices();
        List<InvoiceDetailsResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : invoices) {
            InvoiceDetailsResponse invoiceDetailsResponse = new InvoiceDetailsResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceDetailsResponse);
            returnValue.add(invoiceDetailsResponse);
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
    public InvoiceDetailsResponse createInvoice(@RequestParam String invoice, @RequestParam MultipartFile file) throws IOException {

        InvoiceDetailsRequest invoiceDetailsRequest = new ObjectMapper().readValue(invoice, InvoiceDetailsRequest.class);
        invoiceDetailsRequest.setFile(file);

        InvoiceDto invoiceDto = new InvoiceDto();
        BeanUtils.copyProperties(invoiceDetailsRequest, invoiceDto);
        InvoiceDto createdInvoice = invoiceService.createInvoice(invoiceDto);

        InvoiceDetailsResponse returnValue = new InvoiceDetailsResponse();
        BeanUtils.copyProperties(createdInvoice, returnValue);

        return returnValue;

    }
}
