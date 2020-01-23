package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.RepairDto;
import com.example.autoservicetrackerapi.models.ui.RepairResponse;
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
    public List<RepairResponse> getServices() {
        List<RepairDto> retrievedServices = servicePerformedService.getServices();
        List<RepairResponse> returnValue = new ArrayList<>();

        for (RepairDto repairDto : retrievedServices) {
            RepairResponse repairResponse = new RepairResponse();
            BeanUtils.copyProperties(repairDto, repairResponse);
            returnValue.add(repairResponse);
        }
        return returnValue;
    }
}
