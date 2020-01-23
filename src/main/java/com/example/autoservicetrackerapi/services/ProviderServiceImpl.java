package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.Provider;
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
        List<Provider> retrievedProviders = serviceProviderDao.findAll();
        List<ServiceProviderDto> returnValue = new ArrayList<>();

        for (Provider provider : retrievedProviders) {
            ServiceProviderDto serviceProviderDto = new ServiceProviderDto();
            BeanUtils.copyProperties(provider, serviceProviderDto);
            returnValue.add(serviceProviderDto);
        }

        return returnValue;
    }
}
