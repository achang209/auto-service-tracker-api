package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private VendorDao vendorDao;

    @Autowired
    private FileStorageServiceImpl fileStorageService;

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        fileStorageService.store(invoiceDto.getFile());
        String fileDownloadUri = fileStorageService.convertToFileDownloadUri(invoiceDto.getFile());
        invoiceDto.setFilePath(fileDownloadUri);

        Vendor vendor = vendorDao.findById(invoiceDto.getServiceProviderId()).get();
        invoiceDto.setVendor(vendor);

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Invoice storedInvoiceDetails = invoiceDao.save(invoice);
        InvoiceDto returnValue = new InvoiceDto();
        BeanUtils.copyProperties(storedInvoiceDetails, returnValue);

        return returnValue;
    }

    @Override
    public List<InvoiceDto> getInvoices() {
        List<Invoice> retrievedInvoices = invoiceDao.findAll();
        List<InvoiceDto> returnValue = new ArrayList<>();

        for(Invoice invoice : retrievedInvoices) {
            InvoiceDto invoiceDto = new InvoiceDto();
            BeanUtils.copyProperties(invoice, invoiceDto);
            returnValue.add(invoiceDto);
        }
        return returnValue;
    }

    @Override
    public List<InvoiceDto> searchInvoicesByProvider(String name) {
        List<Invoice> retrievedInvoices = invoiceDao.findByVendorNameIgnoreCase(name);
        List<InvoiceDto> returnValue = new ArrayList<>();

        for(Invoice invoice : retrievedInvoices) {
            InvoiceDto invoiceDto = new InvoiceDto();
            BeanUtils.copyProperties(invoice, invoiceDto);
            returnValue.add(invoiceDto);
        }
        return returnValue;
    }

    @Override
    public List<InvoiceDto> searchInvoicesByService(String name) {
        List<Invoice> retrievedInvoices = invoiceDao.findByRepairNameIgnoreCase(name);
        List<InvoiceDto> returnValue = new ArrayList<>();

        for(Invoice invoice : retrievedInvoices) {
            InvoiceDto invoiceDto = new InvoiceDto();
            BeanUtils.copyProperties(invoice, invoiceDto);
            returnValue.add(invoiceDto);
        }
        return returnValue;
    }
}
