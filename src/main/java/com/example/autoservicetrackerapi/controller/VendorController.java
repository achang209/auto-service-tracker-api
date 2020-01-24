package com.example.autoservicetrackerapi.controller;

import com.example.autoservicetrackerapi.model.VendorDto;
import com.example.autoservicetrackerapi.model.ui.VendorDetailsResponse;
import com.example.autoservicetrackerapi.service.VendorServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VendorController {

    @Autowired
    private VendorServiceImpl vendorService;

    @GetMapping("vendor")
    public List<VendorDetailsResponse> getVendors () {
        List<VendorDto> providers = vendorService.getVendors();
        List<VendorDetailsResponse> returnValue = new ArrayList<>();

        for (VendorDto vendorDto : providers) {
            VendorDetailsResponse serviceVendorDetailsResponse = new VendorDetailsResponse();
            BeanUtils.copyProperties(vendorDto, serviceVendorDetailsResponse);
            returnValue.add(serviceVendorDetailsResponse);
        }
        return returnValue;
    }
}
