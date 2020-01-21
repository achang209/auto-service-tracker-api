package com.example.autoservicetrackerapi.models.ui;

public class InvoiceDetailsResponse {
    private String invoiceId;
    private int mileage;
    private String serviceProviderName;
    private String servicePerformedName;
    private String filePath;

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName;
    }

    public String getServicePerformedName() {
        return servicePerformedName;
    }

    public void setServicePerformedName(String servicePerformedName) {
        this.servicePerformedName = servicePerformedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
