package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.Vendor;
import com.example.autoservicetrackerapi.models.ProviderDao;
import com.example.autoservicetrackerapi.models.ProviderDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDao providerDao;

    @Override
    public List<ProviderDto> getServiceProviders() {
        List<Vendor> retrievedVendors = providerDao.findAll();
        List<ProviderDto> returnValue = new ArrayList<>();

        for (Vendor vendor : retrievedVendors) {
            ProviderDto providerDto = new ProviderDto();
            BeanUtils.copyProperties(vendor, providerDto);
            returnValue.add(providerDto);
        }

        return returnValue;
    }
}
