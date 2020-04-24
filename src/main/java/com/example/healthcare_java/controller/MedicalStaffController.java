package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.MedicalStaff;
import com.example.healthcare_java.repository.MedicalStaffRepository;

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
public class MedicalStaffController {
    @Autowired
    private MedicalStaffRepository medstaffRepository;

    // insert
    @PostMapping(path = "/medstaff/add")
    public @ResponseBody ResponseEntity<MedicalStaff> addNewMedstaff(@RequestParam String medstaff_name,
            @RequestParam int medstaff_age) {

        try {
            MedicalStaff medstaffData = new MedicalStaff();
            medstaffData.setMedstaff_name(medstaff_name);
            medstaffData.setMedstaff_age(medstaff_age);
            medstaffRepository.save(medstaffData);
            return ResponseEntity.ok(medstaffData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/medstaff")
    public @ResponseBody ResponseEntity<Iterable<MedicalStaff>> getAllMedstaff() {
        try {
            return ResponseEntity.ok(medstaffRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/medstaff/{id}")
    public @ResponseBody ResponseEntity<MedicalStaff> getMedstaff(@PathVariable int id) {
        try {
            MedicalStaff medstaffData = medstaffRepository.findById(id).get();
            return ResponseEntity.ok(medstaffData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/medstaff/{id}")
    public @ResponseBody ResponseEntity<MedicalStaff> updateMedstaff(@RequestParam String medstaff_name,
            @RequestParam int medstaff_age) {

        try {
            MedicalStaff medstaffData = new MedicalStaff();
            medstaffData.setMedstaff_name(medstaff_name);
            medstaffData.setMedstaff_age(medstaff_age);
            medstaffRepository.save(medstaffData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/medstaff/{id}")
    public @ResponseBody ResponseEntity<Void> deleteMedstaff(@PathVariable int id) {
        try {
            medstaffRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}