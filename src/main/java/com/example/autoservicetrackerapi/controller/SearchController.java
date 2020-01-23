package com.example.autoservicetrackerapi.controller;

import com.example.autoservicetrackerapi.model.InvoiceDto;
import com.example.autoservicetrackerapi.model.ui.InvoiceDetailsResponse;
import com.example.autoservicetrackerapi.service.InvoiceServiceImpl;
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
    public List<InvoiceDetailsResponse> searchInvoicesByProvider(@RequestParam String name) {
        List<InvoiceDto> retrievedInvoices = invoiceService.searchInvoicesByProvider(name);
        List<InvoiceDetailsResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : retrievedInvoices) {
            InvoiceDetailsResponse invoiceDetailsResponse = new InvoiceDetailsResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceDetailsResponse);
            returnValue.add(invoiceDetailsResponse);
        }
        return returnValue;
    }

    @GetMapping("service")
    public List<InvoiceDetailsResponse> searchInvoicesByService(@RequestParam String name) {
        List<InvoiceDto> retrievedInvoices = invoiceService.searchInvoicesByService(name);
        List<InvoiceDetailsResponse> returnValue = new ArrayList<>();

        for (InvoiceDto invoiceDto : retrievedInvoices) {
            InvoiceDetailsResponse invoiceDetailsResponse = new InvoiceDetailsResponse();
            BeanUtils.copyProperties(invoiceDto, invoiceDetailsResponse);
            returnValue.add(invoiceDetailsResponse);
        }
        return returnValue;
    }


}
