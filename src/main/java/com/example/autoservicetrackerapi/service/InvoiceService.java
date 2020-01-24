package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    InvoiceDto createInvoice(InvoiceDto invoiceDto);

    List<InvoiceDto> getInvoices();

    List<InvoiceDto> searchInvoicesByVendor(String name);

    List<InvoiceDto> searchInvoicesByRepair(String name);
}
