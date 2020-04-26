package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.MedicalStaff;
import com.example.healthcare_java.model.Patient;
import com.example.healthcare_java.model.MedicalRecord;
import com.example.healthcare_java.model.Disease;
import com.example.healthcare_java.repository.DiseaseRepository;
import com.example.healthcare_java.repository.MedicalRecordRepository;
import com.example.healthcare_java.repository.MedicalStaffRepository;
import com.example.healthcare_java.repository.PatientRepository;

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
public class MedicalRecordController {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicalStaffRepository medstaffRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    // insert
    @PostMapping(path = "/appointment/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<MedicalRecord> addMedicalRecord(@RequestParam String anamnesia,
            @RequestParam int disease_id, @RequestParam int medstaff_id, @RequestParam int patient_id) {

        try {
            MedicalRecord medicalRecord = new MedicalRecord();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            Patient patientData = patientRepository.findById(patient_id).get();
            Disease diseaseData = diseaseRepository.findById(disease_id).get();

            medicalRecord.setMedicalStaff(medicalData);
            medicalRecord.setPatient(patientData);
            medicalRecord.setDisease(diseaseData);

            medicalRecord.setAnamnesia(anamnesia);

            medicalRecordRepository.save(medicalRecord);
            return ResponseEntity.ok(medicalRecord);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/record")
    public @ResponseBody ResponseEntity<Iterable<MedicalRecord>> getAllMedicalRecord() {
        try {
            return ResponseEntity.ok(medicalRecordRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/record/{id}")
    public @ResponseBody ResponseEntity<MedicalRecord> getMedicalRecord(@PathVariable int id) {
        try {
            MedicalRecord medicalRecordData = medicalRecordRepository.findById(id).get();
            return ResponseEntity.ok(medicalRecordData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/record/{record_id}")
    public @ResponseBody ResponseEntity<MedicalRecord> updateMedicalRecord(@RequestParam String anamnesia,
    @RequestParam int disease_id, @RequestParam int medstaff_id, @RequestParam int patient_id,
    @RequestParam int record_id) {

        try {
            MedicalRecord medicalRecord = new MedicalRecord();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            Patient patientData = patientRepository.findById(patient_id).get();
            Disease diseaseData = diseaseRepository.findById(disease_id).get();

            medicalRecord.setMedicalStaff(medicalData);
            medicalRecord.setPatient(patientData);
            medicalRecord.setDisease(diseaseData);

            medicalRecord.setRecord_id(record_id);
            medicalRecord.setAnamnesia(anamnesia);

            medicalRecordRepository.save(medicalRecord);
            return ResponseEntity.ok(medicalRecord);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/record/{id}")
    public @ResponseBody ResponseEntity<Void> deleteMedicalRecord(@PathVariable int id) {
        try {
            medicalRecordRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}