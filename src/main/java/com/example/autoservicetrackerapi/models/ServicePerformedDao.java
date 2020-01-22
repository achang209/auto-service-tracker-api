package com.example.autoservicetrackerapi.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicePerformedDao extends CrudRepository<ServicePerformed, Integer> {
}
