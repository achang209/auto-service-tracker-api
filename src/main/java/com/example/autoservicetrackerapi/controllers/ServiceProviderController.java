package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.VendorDto;
import com.example.autoservicetrackerapi.models.ui.VendorDetailsResponse;
import com.example.autoservicetrackerapi.services.VendorServiceImpl;
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
    private VendorServiceImpl providerService;

    @GetMapping("service_provider")
    public List<VendorDetailsResponse> getServiceProviders () {
        List<VendorDto> providers = providerService.getServiceProviders();
        List<VendorDetailsResponse> returnValue = new ArrayList<>();

        for (VendorDto vendorDto : providers) {
            VendorDetailsResponse serviceVendorDetailsResponse = new VendorDetailsResponse();
            BeanUtils.copyProperties(vendorDto, serviceVendorDetailsResponse);
            returnValue.add(serviceVendorDetailsResponse);
        }
        return returnValue;
    }
}
