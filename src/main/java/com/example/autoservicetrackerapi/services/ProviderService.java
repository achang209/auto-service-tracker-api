package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.ProviderDto;

import java.util.List;

public interface ProviderService {
    List<ProviderDto> getServiceProviders();
}
