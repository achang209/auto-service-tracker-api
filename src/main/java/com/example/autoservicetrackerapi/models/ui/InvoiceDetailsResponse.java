package com.example.autoservicetrackerapi.models.ui;

import com.example.autoservicetrackerapi.models.Vendor;

public class InvoiceDetailsResponse {
    private int Id;
    private String date;
    private int mileage;
    private Vendor vendor;
    private String servicePerformed;
    private String filePath;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public String getServicePerformed() {
        return servicePerformed;
    }

    public void setServicePerformed(String servicePerformed) {
        this.servicePerformed = servicePerformed;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
