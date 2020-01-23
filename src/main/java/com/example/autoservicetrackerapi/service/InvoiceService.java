package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    List<InvoiceDto> getInvoices();

    List<InvoiceDto> searchInvoicesByProvider(String name);

    List<InvoiceDto> searchInvoicesByService(String name);
}
