package com.example.autoservicetrackerapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorDao extends CrudRepository<Vendor, Integer> {
    List<Vendor> findAll();
}
