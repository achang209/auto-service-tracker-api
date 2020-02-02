package com.example.autoservicetrackerapi.service;

import com.example.autoservicetrackerapi.exception.VendorServiceException;
import com.example.autoservicetrackerapi.model.Vendor;
import com.example.autoservicetrackerapi.model.VendorDao;
import com.example.autoservicetrackerapi.model.VendorDto;
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
    public List<VendorDto> getVendors() {
        List<Vendor> retrievedVendors = vendorDao.findAll();
        List<VendorDto> returnValue = new ArrayList<>();

        for (Vendor vendor : retrievedVendors) {
            VendorDto vendorDto = new VendorDto();
            BeanUtils.copyProperties(vendor, vendorDto);
            returnValue.add(vendorDto);
        }

        return returnValue;
    }

    @Override
    public VendorDto addVendor(VendorDto vendorDto) {
        Vendor vendor = new Vendor();
        BeanUtils.copyProperties(vendorDto, vendor);
        Vendor storedVendorDetails = vendorDao.save(vendor);

        VendorDto returnValue = new VendorDto();
        BeanUtils.copyProperties(storedVendorDetails, returnValue);

        return returnValue;
    }

    @Override
    public void deleteVendor(int vendorId) {

        if (!vendorDao.existsById(vendorId)) {
            throw new VendorServiceException("Vendor with id " + vendorId + " does not exist" );
        }
        vendorDao.deleteById(vendorId);
    }


}
