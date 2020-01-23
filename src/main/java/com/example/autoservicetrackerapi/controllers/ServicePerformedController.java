package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.RepairDto;
import com.example.autoservicetrackerapi.models.ui.ServicePerformedResponse;
import com.example.autoservicetrackerapi.services.ServicePerformedServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServicePerformedController {

    @Autowired
    private ServicePerformedServiceImpl servicePerformedService;

    @GetMapping("service_performed")
    public List<ServicePerformedResponse> getServices() {
        List<RepairDto> retrievedServices = servicePerformedService.getServices();
        List<ServicePerformedResponse> returnValue = new ArrayList<>();

        for (RepairDto repairDto : retrievedServices) {
            ServicePerformedResponse servicePerformedResponse = new ServicePerformedResponse();
            BeanUtils.copyProperties(repairDto, servicePerformedResponse);
            returnValue.add(servicePerformedResponse);
        }
        return returnValue;
    }
}