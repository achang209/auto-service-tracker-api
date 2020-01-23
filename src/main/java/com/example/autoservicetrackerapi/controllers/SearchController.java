package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.InvoiceDto;
import com.example.autoservicetrackerapi.models.ui.InvoiceResponse;
import com.example.autoservicetrackerapi.services.InvoiceServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    @Autowired
    private InvoiceServiceImpl invoiceService;


    @GetMapping("provider")
    public List<InvoiceResponse> searchInvoicesByProvider(@RequestParam String name) {
        List<InvoiceDto> retrievedInvoices = invoiceService.searchInvoicesByProvider(name);
        List<InvoiceResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : retrievedInvoices) {
            InvoiceResponse invoiceResponse = new InvoiceResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceResponse);
            returnValue.add(invoiceResponse);
        }
        return returnValue;
    }

    @GetMapping("service")
    public List<InvoiceResponse> searchInvoicesByService(@RequestParam String name) {
        List<InvoiceDto> retrievedInvoices = invoiceService.searchInvoicesByService(name);
        List<InvoiceResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : retrievedInvoices) {
            InvoiceResponse invoiceResponse = new InvoiceResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceResponse);
            returnValue.add(invoiceResponse);
        }
        return returnValue;
    }


}
