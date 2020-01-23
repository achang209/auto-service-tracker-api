package com.example.autoservicetrackerapi.model.ui;

import org.springframework.web.multipart.MultipartFile;

public class InvoiceDetailsRequest {
    private String date;
    private int mileage;
    private int serviceProviderId;
    private String servicePerformed;
    private MultipartFile file;

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

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getServicePerformed() {
        return servicePerformed;
    }

    public void setServicePerformed(String servicePerformed) {
        this.servicePerformed = servicePerformed;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
