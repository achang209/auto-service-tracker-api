package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.VendorDto;

import java.util.List;

public interface VendorService {
    List<VendorDto> getServiceProviders();
}
