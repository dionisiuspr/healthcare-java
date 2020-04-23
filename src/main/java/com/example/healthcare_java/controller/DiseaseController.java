package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.Disease;
import com.example.healthcare_java.repository.DiseaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/healthcare")
public class DiseaseController {
    @Autowired
    private DiseaseRepository diseaseRepository;

    // insert
    @PostMapping(path = "/disease/add")
    public @ResponseBody ResponseEntity<Disease> addNewDisease(@RequestParam String disease_type,
            @RequestParam String disease_name) {

        try {
            Disease diseaseData = new Disease();
            diseaseData.setDisease_type(disease_type);
            diseaseData.setDisease_name(disease_name);
            diseaseRepository.save(diseaseData);
            return ResponseEntity.ok(diseaseData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/disease")
    public @ResponseBody ResponseEntity<Iterable<Disease>> getAllDisease() {
        try {
            return ResponseEntity.ok(diseaseRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/disease/{id}")
    public @ResponseBody ResponseEntity<Disease> getDisease(@PathVariable int id) {
        try {
            Disease diseaseData = diseaseRepository.findById(id).get();
            return ResponseEntity.ok(diseaseData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/disease/{id}")
    public @ResponseBody ResponseEntity<Disease> updateDisease(@RequestParam String disease_type,
            @RequestParam String disease_name) {

        try {
            Disease diseaseData = new Disease();
            diseaseData.setDisease_type(disease_type);
            diseaseData.setDisease_name(disease_name);
            diseaseRepository.save(diseaseData);
            return ResponseEntity.ok(diseaseData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/disease/{id}")
    public @ResponseBody ResponseEntity<Void> deleteDisease(@PathVariable int id) {
        try {
            diseaseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}