package com.example.autoservicetrackerapi.controllers;

import com.example.autoservicetrackerapi.models.ServiceProvider;
import com.example.autoservicetrackerapi.models.ServiceProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @GetMapping("service_provider")
    public List<ServiceProvider> getServiceProviders () {
        return (List<ServiceProvider>) serviceProviderDao.findAll();
    }
}
