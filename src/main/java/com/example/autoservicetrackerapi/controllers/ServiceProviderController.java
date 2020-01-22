package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.InvoiceDto;
import com.example.autoservicetrackerapi.models.ServiceProvider;
import com.example.autoservicetrackerapi.models.ServiceProviderDao;
import com.example.autoservicetrackerapi.models.ServiceProviderDto;
import com.example.autoservicetrackerapi.models.ui.InvoiceDetailsResponse;
import com.example.autoservicetrackerapi.models.ui.ServiceProviderResponse;
import com.example.autoservicetrackerapi.services.ProviderServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceProviderController {

    @Autowired
    private ProviderServiceImpl providerService;

    @GetMapping("service_provider")
    public List<ServiceProviderResponse> getServiceProviders () {
        List<ServiceProviderDto> providers = providerService.getServiceProviders();
        List<ServiceProviderResponse> returnValue = new ArrayList<>();

        for (ServiceProviderDto serviceProviderDto : providers) {
            ServiceProviderResponse serviceProviderResponse = new ServiceProviderResponse();
            BeanUtils.copyProperties(serviceProviderDto, serviceProviderResponse);
            returnValue.add(serviceProviderResponse);
        }
        return returnValue;
    }
}
