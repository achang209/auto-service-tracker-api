package com.example.autoservicetrackerapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Repair {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany @JoinColumn(name = "service_performed_id") @JsonIgnore
    private List<Invoice> invoices = new ArrayList<>();

    public Repair() {
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
