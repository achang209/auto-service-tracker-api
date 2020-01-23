package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.ProviderDto;
import com.example.autoservicetrackerapi.models.ui.VendorDetailsResponse;
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
    public List<VendorDetailsResponse> getServiceProviders () {
        List<ProviderDto> providers = providerService.getServiceProviders();
        List<VendorDetailsResponse> returnValue = new ArrayList<>();

        for (ProviderDto providerDto : providers) {
            VendorDetailsResponse serviceVendorDetailsResponse = new VendorDetailsResponse();
            BeanUtils.copyProperties(providerDto, serviceVendorDetailsResponse);
            returnValue.add(serviceVendorDetailsResponse);
        }
        return returnValue;
    }
}
