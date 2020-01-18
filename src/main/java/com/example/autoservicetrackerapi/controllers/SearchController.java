package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.Invoice;
import com.example.autoservicetrackerapi.models.InvoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("search")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {

    @Autowired
    private InvoiceDao invoiceDao;

    /*
    @GetMapping("provider")
    public List<Invoice> searchByProvider(@RequestParam String provider) {
        return invoiceDao.findByServiceProviderIgnoreCase(provider);
    }
    */

    @GetMapping("service")
    public List<Invoice> searchByService(@RequestParam String service) {
        return invoiceDao.findByServicePerformedIgnoreCase(service);
    }
}
