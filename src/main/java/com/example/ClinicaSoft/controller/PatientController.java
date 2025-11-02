package com.example.ClinicaSoft.controller;

import com.example.ClinicaSoft.entities.Patient;
import com.example.ClinicaSoft.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        return this.service.save(patient);
    }

    @GetMapping("/all")
    public List<Patient> getAll() {
        return this.service.findAll();
    }

    @PutMapping("/update")
    public Patient update(@RequestBody Patient patient) {

        Optional<Patient> optionalPatient = service.findById(patient.getPatSec());

        if (optionalPatient.isPresent()) {
            this.service.update(patient);
        }

        return patient;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        String response;

        if (this.service.findById(id).isPresent()) {

            this.service.delete(id);
            response = "Se elimino el registro correctamente";
        } else {
            response = "No se encontro el registro.";
        }

        return response;
    }
}