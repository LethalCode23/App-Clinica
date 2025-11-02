package com.example.ClinicaSoft.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DenSec;
    private Integer DenRegis;
    private String DenName;
    private String DenLastName;

    public Dentist() {

    }

    public Integer getDenSec() {
        return DenSec;
    }

    public void setDenSec(Integer denSec) {
        DenSec = denSec;
    }

    public Integer getDenRegis() {
        return DenRegis;
    }

    public void setDenRegis(Integer denRegis) {
        DenRegis = denRegis;
    }

    public String getDenName() {
        return DenName;
    }

    public void setDenName(String denName) {
        DenName = denName;
    }

    public String getDenLastName() {
        return DenLastName;
    }

    public void setDenLastName(String denLastName) {
        DenLastName = denLastName;
    }
}