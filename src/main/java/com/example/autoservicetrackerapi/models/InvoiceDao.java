package com.example.autoservicetrackerapi.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice, Integer> {

    /*
    List<Invoice> findByServiceProviderIgnoreCase(ServiceProvider serviceProvider);

     */

    List<Invoice> findByServicePerformedIgnoreCase(String servicePerformed);
}
