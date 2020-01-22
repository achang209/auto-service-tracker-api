package com.example.autoservicetrackerapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ServicePerformed {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    @JoinColumn(name = "service_performed_id") @JsonIgnore
    private List<Invoice> invoices = new ArrayList<>();

    public ServicePerformed() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
