package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.InvoiceDto;

public interface InvoiceService {
    InvoiceDto createInvoice(InvoiceDto invoiceDto);
}
