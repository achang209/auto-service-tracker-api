package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.RepairDto;

import java.util.List;

public interface ServicePerformedService {
    List<RepairDto> getServices();
}
