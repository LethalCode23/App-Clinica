package com.example.ClinicaSoft.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Integer addSec;

    private String addStreet;
    private String addLocation;
    private String addProvince;

    public Address() {

    }

    public Address(Integer addSec, String addStreet, String addLocation, String addProvince) {
        this.addSec = addSec;
        this.addStreet = addStreet;
        this.addLocation = addLocation;
        this.addProvince = addProvince;
    }

    public Integer getAddSec() {
        return addSec;
    }

    public void setAddSec(Integer addSec) {
        this.addSec = addSec;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public String getAddLocation() {
        return addLocation;
    }

    public void setAddLocation(String addLocation) {
        this.addLocation = addLocation;
    }

    public String getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince;
    }
}