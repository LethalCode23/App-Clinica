package com.example.ClinicaSoft.controller;

import com.example.ClinicaSoft.entities.Dentist;
import com.example.ClinicaSoft.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService service;

    @Autowired
    public DentistController(DentistService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Dentist save(@RequestBody Dentist dentist) {
        return this.service.save(dentist);
    }

    @GetMapping("/all")
    public List<Dentist> getAll() {
        return this.service.findAll();
    }

    @PutMapping("/update")
    public Dentist update(@RequestBody Dentist dentist) {

        Optional<Dentist> optionalDentist = service.findById(dentist.getDenSec());

        if (optionalDentist.isPresent()) {
            service.update(dentist);
        }

        return dentist;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        String response;

        if (service.findById(id).isPresent()) {

            this.service.delete(id);
            response = "Se elimino correctamente el registro.";
        } else {
            response = "No se encontro el registro";
        }

        return response;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable  Integer id) {

        Optional<Dentist> dentistWanted = this.service.findById(id);

        return dentistWanted.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}