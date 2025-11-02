package com.example.ClinicaSoft.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.time.LocalDate;

@JsonPropertyOrder({
        "patSec",
        "patName",
        "patLastName",
        "patCardIde",
        "patDate",
        "address"
})
@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patSec")
    private Integer PatSec;
    private String PatName;
    private String PatLastName;
    private String PatCardIde;
    private LocalDate PatDate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", referencedColumnName = "addSec")
    private Address address;

    public Patient() {

    }

    public Integer getPatSec() {
        return PatSec;
    }

    public void setPatSec(Integer patSec) {
        PatSec = patSec;
    }

    public String getPatName() {
        return PatName;
    }

    public void setPatName(String patName) {
        PatName = patName;
    }

    public String getPatLastName() {
        return PatLastName;
    }

    public void setPatLastName(String patLastName) {
        PatLastName = patLastName;
    }

    public String getPatCardIde() {
        return PatCardIde;
    }

    public void setPatCardIde(String patCardIde) {
        PatCardIde = patCardIde;
    }

    public LocalDate getPatDate() {
        return PatDate;
    }

    public void setPatDate(LocalDate patDate) {
        PatDate = patDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}