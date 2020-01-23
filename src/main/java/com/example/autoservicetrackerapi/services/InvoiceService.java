package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    List<InvoiceDto> getInvoices();

    List<InvoiceDto> searchInvoicesByProvider(String name);

    List<InvoiceDto> searchInvoicesByService(String name);
}
