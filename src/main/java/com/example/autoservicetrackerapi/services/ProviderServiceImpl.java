package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.ServiceProvider;
import com.example.autoservicetrackerapi.models.ServiceProviderDao;
import com.example.autoservicetrackerapi.models.ServiceProviderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ServiceProviderDao serviceProviderDao;

    @Override
    public List<ServiceProviderDto> getServiceProviders() {
        List<ServiceProvider> retrievedServiceProviders = serviceProviderDao.findAll();
        List<ServiceProviderDto> returnValue = new ArrayList<>();

        for (ServiceProvider serviceProvider : retrievedServiceProviders) {
            ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
            BeanUtils.copyProperties(serviceProvider, serviceProviderDto);
            returnValue.add(serviceProviderDto);
        }

        return returnValue;
    }
}
