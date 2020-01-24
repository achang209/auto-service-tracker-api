package com.example.autoservicetrackerapi.controller;

import com.example.autoservicetrackerapi.model.RepairDto;
import com.example.autoservicetrackerapi.model.ui.RepairDetailsResponse;
import com.example.autoservicetrackerapi.service.RepairServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RepairController {

    @Autowired
    private RepairServiceImpl repairService;

    @GetMapping("repair")
    public List<RepairDetailsResponse> getServices() {
        List<RepairDto> retrievedServices = repairService.getServices();
        List<RepairDetailsResponse> returnValue = new ArrayList<>();

        for (RepairDto repairDto : retrievedServices) {
            RepairDetailsResponse repairResponse = new RepairDetailsResponse();
            BeanUtils.copyProperties(repairDto, repairResponse);
            returnValue.add(repairResponse);
        }
        return returnValue;
    }
}
