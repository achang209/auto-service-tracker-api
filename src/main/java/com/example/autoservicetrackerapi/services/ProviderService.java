package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.VendorDto;

import java.util.List;

public interface ProviderService {
    List<VendorDto> getServiceProviders();
}
