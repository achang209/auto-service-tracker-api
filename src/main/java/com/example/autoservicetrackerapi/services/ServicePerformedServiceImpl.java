package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.ServicePerformed;
import com.example.autoservicetrackerapi.models.ServicePerformedDao;
import com.example.autoservicetrackerapi.models.ServicePerformedDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerformedServiceImpl implements ServicePerformedService {

    @Autowired
    private ServicePerformedDao servicePerformedDao;

    @Override
    public List<ServicePerformedDto> getServices() {
        List<ServicePerformed> retrievedServices = servicePerformedDao.findAll();
        List<ServicePerformedDto> returnValue = new ArrayList<>();

        for (ServicePerformed service : retrievedServices) {
            ServicePerformedDto servicePerformedDto = new ServicePerformedDto();
            BeanUtils.copyProperties(service, servicePerformedDto);
            returnValue.add(servicePerformedDto);
        }
        return returnValue;
    }
}
