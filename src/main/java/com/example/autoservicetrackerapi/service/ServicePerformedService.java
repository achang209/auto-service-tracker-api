package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.RepairDto;

import java.util.List;

public interface ServicePerformedService {
    List<RepairDto> getServices();
}
