package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.VendorDto;

import java.util.List;

public interface VendorService {
    List<VendorDto> getVendors();
    VendorDto addVendor(VendorDto vendorDto);
}
