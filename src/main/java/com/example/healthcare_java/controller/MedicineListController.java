package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.MedicalRecord;
import com.example.healthcare_java.model.Medicine;
import com.example.healthcare_java.model.MedicineList;
import com.example.healthcare_java.repository.MedicalRecordRepository;
import com.example.healthcare_java.repository.MedicineListRepository;
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
public class MedicineListController {
    @Autowired
    private MedicineListRepository medicineListRepository;

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    // insert
    @PostMapping(path = "/medicinelist/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<MedicineList> addMedicalRecord(@RequestParam int record_id,
            @RequestParam int medicine_id) {

        try {
            MedicineList medicineList = new MedicineList();
            MedicalRecord medicalRecord = medicalRecordRepository.findById(record_id).get();
            Medicine medicine = medicineRepository.findById(medicine_id).get();
            
            medicineList.setMedicalRecord(medicalRecord);
            medicineList.setMedicine(medicine);

            medicineListRepository.save(medicineList);
            return ResponseEntity.ok(medicineList);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/medicinelist")
    public @ResponseBody ResponseEntity<Iterable<MedicineList>> getAllMedicineList() {
        try {
            return ResponseEntity.ok(medicineListRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/medicinelist/{id}")
    public @ResponseBody ResponseEntity<MedicineList> getMedicineList(@PathVariable int id) {
        try {
            MedicineList medicineListData = medicineListRepository.findById(id).get();
            return ResponseEntity.ok(medicineListData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/medicinelist/{medicinelist_id}")
    public @ResponseBody ResponseEntity<MedicineList> updateMedicineList(@RequestParam int record_id,
    @RequestParam int medicine_id, @RequestParam int medicinelist_id) {

        try {
            MedicineList medicineList = new MedicineList();
            MedicalRecord medicalRecord = medicalRecordRepository.findById(record_id).get();
            Medicine medicine = medicineRepository.findById(medicine_id).get();
            
            medicineList.setMedicalRecord(medicalRecord);
            medicineList.setMedicine(medicine);

            medicineList.setMedicinelist_id(medicinelist_id);

            medicineListRepository.save(medicineList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/medicinelist/{id}")
    public @ResponseBody ResponseEntity<Void> deleteMedicineList(@PathVariable int id) {
        try {
            medicineListRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}