package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Autowired
    private FileStorageServiceImpl fileStorageService;

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto) {
        fileStorageService.store(invoiceDto.getFile());
        String fileDownloadUri = fileStorageService.convertToFileDownloadUri(invoiceDto.getFile());
        invoiceDto.setFilePath(fileDownloadUri);

        ServiceProvider serviceProvider = serviceProviderDao.findById(invoiceDto.getServiceProviderId()).get();
        invoiceDto.setServiceProvider(serviceProvider);

        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        Invoice storedInvoiceDetails = invoiceDao.save(invoice);
        InvoiceDto returnValue = new InvoiceDto();
        BeanUtils.copyProperties(storedInvoiceDetails, returnValue);

        return returnValue;
    }
}
