package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.Medicine;
import com.example.healthcare_java.repository.MedicineRepository;

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
public class MedicineController {
    @Autowired
    private MedicineRepository medicineRepository;

    // insert
    @PostMapping(path = "/medicine/add")
    public @ResponseBody ResponseEntity<Medicine> addNewMedicine(@RequestParam String med_date,
            @RequestParam String med_name, @RequestParam String med_vendor, @RequestParam int med_level,
            @RequestParam int med_price, @RequestParam int med_qty) {

        try {
            Medicine medicineData = new Medicine();
            medicineData.setMedicine_exp_date(med_date);
            medicineData.setMedicine_name(med_name);
            medicineData.setMedicine_vendor(med_vendor);
            medicineData.setMedicine_level(med_level);
            medicineData.setMedicine_price(med_price);
            medicineData.setMedicine_qty(med_qty);
            medicineRepository.save(medicineData);
            return ResponseEntity.ok(medicineData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/medicine")
    public @ResponseBody ResponseEntity<Iterable<Medicine>> getAllMedicine() {
        try {
            return ResponseEntity.ok(medicineRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/medicine/{id}")
    public @ResponseBody ResponseEntity<Medicine> getMedicine(@PathVariable int id) {
        try {
            Medicine medicineData = medicineRepository.findById(id).get();
            return ResponseEntity.ok(medicineData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/medicine/{id}")
    public @ResponseBody ResponseEntity<Medicine> updateMedicine(@RequestParam String med_date,
            @RequestParam String med_name, @RequestParam String med_vendor, @RequestParam int med_level,
            @RequestParam int med_price, @RequestParam int med_qty) {

        try {
            Medicine medicineData = new Medicine();
            medicineData.setMedicine_exp_date(med_date);
            medicineData.setMedicine_name(med_name);
            medicineData.setMedicine_vendor(med_vendor);
            medicineData.setMedicine_level(med_level);
            medicineData.setMedicine_price(med_price);
            medicineData.setMedicine_qty(med_qty);
            medicineRepository.save(medicineData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/medicine/{id}")
    public @ResponseBody ResponseEntity<Void> deleteMedicine(@PathVariable int id) {
        try {
            medicineRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}