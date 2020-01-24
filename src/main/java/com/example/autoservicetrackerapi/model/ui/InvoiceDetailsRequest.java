package com.example.autoservicetrackerapi.model.ui;

import org.springframework.web.multipart.MultipartFile;

public class InvoiceDetailsRequest {
    private String date;
    private int mileage;
    private int vendorId;
    private int repairId;
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

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
