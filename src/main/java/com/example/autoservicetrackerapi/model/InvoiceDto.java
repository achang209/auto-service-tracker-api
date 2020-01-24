package com.example.autoservicetrackerapi.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class InvoiceDto implements Serializable {
    private static final long serialVersionUID = 6460692248095615980L;

    private int id;
    private String date;
    private int mileage;
    private int vendorId;
    private Vendor vendor;
    private int repairId;
    private Repair repair;
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

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
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
