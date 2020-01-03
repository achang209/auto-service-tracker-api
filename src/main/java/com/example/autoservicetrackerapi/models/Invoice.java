package com.example.autoservicetrackerapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invoice {

    @Id @GeneratedValue
    private int id;
    private String date;
    private int currentMileage;
    private String serviceProvider;
    private String servicesPerformed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServicesPerformed() {
        return servicesPerformed;
    }

    public void setServicesPerformed(String servicesPerformed) {
        this.servicesPerformed = servicesPerformed;
    }
}
