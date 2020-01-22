package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.ServicePerformedDto;
import com.example.autoservicetrackerapi.models.ui.ServicePerformedResponse;
import com.example.autoservicetrackerapi.models.ui.ServiceProviderResponse;
import com.example.autoservicetrackerapi.services.ServicePerformedService;
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
        List<ServicePerformedDto> retrievedServices = servicePerformedService.getServices();
        List<ServicePerformedResponse> returnValue = new ArrayList<>();

        for (ServicePerformedDto servicePerformedDto : retrievedServices) {
            ServicePerformedResponse servicePerformedResponse = new ServicePerformedResponse();
            BeanUtils.copyProperties(servicePerformedDto, servicePerformedResponse);
            returnValue.add(servicePerformedResponse);
        }
        return returnValue;
    }
}
