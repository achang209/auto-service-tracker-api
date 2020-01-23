package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.Repair;
import com.example.autoservicetrackerapi.models.RepairDao;
import com.example.autoservicetrackerapi.models.RepairDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePerformedServiceImpl implements ServicePerformedService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public List<RepairDto> getServices() {
        List<Repair> retrievedServices = repairDao.findAll();
        List<RepairDto> returnValue = new ArrayList<>();

        for (Repair service : retrievedServices) {
            RepairDto repairDto = new RepairDto();
            BeanUtils.copyProperties(service, repairDto);
            returnValue.add(repairDto);
        }
        return returnValue;
    }
}
