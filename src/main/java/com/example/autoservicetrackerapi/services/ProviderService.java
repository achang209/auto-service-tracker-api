package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.ServiceProviderDto;

import java.util.List;

public interface ProviderService {
    List<ServiceProviderDto> getServiceProviders();
}
