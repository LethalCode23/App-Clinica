package com.example.ClinicaSoft.service;

import com.example.ClinicaSoft.entities.Patient;
import com.example.ClinicaSoft.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient save(Patient patient) {
        return this.repository.save(patient);
    }

    public Optional<Patient> findById(Integer id) {
        return this.repository.findById(id);
    }

    public void update(Patient patient) {
        this.repository.save(patient);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    public List<Patient> findAll() {
        return this.repository.findAll();
    }
}