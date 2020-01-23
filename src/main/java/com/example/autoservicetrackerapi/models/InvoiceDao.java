package com.example.autoservicetrackerapi.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {
    List<Invoice> findAll();

    List<Invoice> findByServiceProviderNameIgnoreCase(String name);


    List<Invoice> findByServicePerformedNameIgnoreCase(String name);
}
