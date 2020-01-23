package com.example.autoservicetrackerapi.models;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class InvoiceDto implements Serializable {
    private static final long serialVersionUID = 6460692248095615980L;

    private int id;
    private String date;
    private int mileage;
    private int serviceProviderId;
    private Provider provider;
    private String servicePerformed;
    private MultipartFile file;
    private String filePath;

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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
