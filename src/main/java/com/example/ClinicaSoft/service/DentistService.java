package com.example.ClinicaSoft.service;

import com.example.ClinicaSoft.entities.Dentist;
import com.example.ClinicaSoft.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    private final DentistRepository repository;

    @Autowired
    public DentistService(DentistRepository repository) {
        this.repository = repository;
    }

    public Dentist save(Dentist dentist) {
        return this.repository.save(dentist);
    }

    public Optional<Dentist> findById(Integer id) {
        return this.repository.findById(id);
    }

    public void update(Dentist dentist) {
        this.repository.save(dentist);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    public List<Dentist> findAll() {
        return this.repository.findAll();
    }
}