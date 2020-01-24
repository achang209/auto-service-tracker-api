package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.model.RepairDto;

import java.util.List;

public interface RepairService {
    List<RepairDto> getServices();
}
