package com.example.autoservicetrackerapi.services;

import com.example.autoservicetrackerapi.models.Vendor;
import com.example.autoservicetrackerapi.models.VendorDao;
import com.example.autoservicetrackerapi.models.VendorDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorDao vendorDao;

    @Override
    public List<VendorDto> getServiceProviders() {
        List<Vendor> retrievedVendors = vendorDao.findAll();
        List<VendorDto> returnValue = new ArrayList<>();

        for (Vendor vendor : retrievedVendors) {
            VendorDto vendorDto = new VendorDto();
            BeanUtils.copyProperties(vendor, vendorDto);
            returnValue.add(vendorDto);
        }

        return returnValue;
    }
}
