package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.Invoice;
import com.example.autoservicetrackerapi.models.InvoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    @Autowired
    private InvoiceDao invoiceDao;

    @GetMapping("search")
    public List<Invoice> searchByProvider(@RequestParam String provider) {
        Iterable<Invoice> allInvoices = invoiceDao.findAll();
        List<Invoice> invoicesToSend = new ArrayList<>();

        for (Invoice invoice : allInvoices) {
            if (invoice.getServiceProvider().toLowerCase().contains(provider)) {
                invoicesToSend.add(invoice);
            }
        }
        return invoicesToSend;
    }
}
