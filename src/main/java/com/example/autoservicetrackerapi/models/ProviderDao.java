package com.example.autoservicetrackerapi.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderDao extends CrudRepository<Provider, Integer> {
    List<Provider> findAll();
}
