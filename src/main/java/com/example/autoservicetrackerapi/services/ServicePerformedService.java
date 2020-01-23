package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.ServicePerformedDto;

import java.util.List;

public interface ServicePerformedService {
    List<ServicePerformedDto> getServices();
}
