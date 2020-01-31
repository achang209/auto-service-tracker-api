package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.InvoiceDto;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.util.List;

public interface InvoiceService {

    InvoiceDto createInvoice(@Valid InvoiceDto invoiceDto);

    List<InvoiceDto> getInvoices();

    List<InvoiceDto> searchInvoicesByVendor(String name);

    List<InvoiceDto> searchInvoicesByRepair(String name);
}
