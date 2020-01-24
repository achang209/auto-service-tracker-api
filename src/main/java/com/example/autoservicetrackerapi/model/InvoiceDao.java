package com.example.autoservicetrackerapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {
    List<Invoice> findAll();

    List<Invoice> findByVendorNameIgnoreCase(String name);

    List<Invoice> findByRepairNameIgnoreCase(String name);
}
