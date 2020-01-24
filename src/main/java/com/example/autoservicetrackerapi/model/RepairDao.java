package com.example.autoservicetrackerapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairDao extends CrudRepository<Repair, Integer> {
    List<Repair> findAll();
}
