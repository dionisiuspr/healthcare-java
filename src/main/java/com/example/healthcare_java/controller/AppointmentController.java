package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.MedicalStaff;
import com.example.healthcare_java.model.Patient;
import com.example.healthcare_java.model.Appointment;
import com.example.healthcare_java.repository.AppointmentRepository;
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
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MedicalStaffRepository medstaffRepository;

    @Autowired
    private PatientRepository patientRepository;

    // insert
    @PostMapping(path = "/appointment/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<Appointment> addAppointment(@RequestParam String appointment_date,
            @RequestParam String appointment_time, @RequestParam boolean appointment_status,
            @RequestParam int medstaff_id, @RequestParam int patient_id, @PathVariable int appointment_id) {

        try {
            Appointment appointmentData = new Appointment();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            Patient patientData = patientRepository.findById(patient_id).get();

            appointmentData.setMedicalStaff(medicalData);
            appointmentData.setPatient(patientData);

            appointmentData.setAppointment_date(appointment_date);
            appointmentData.setAppointment_time(appointment_time);
            appointmentData.setAppointment_status(appointment_status);

            appointmentRepository.save(appointmentData);
            return ResponseEntity.ok(appointmentData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/appointment")
    public @ResponseBody ResponseEntity<Iterable<Appointment>> getAllAppointment() {
        try {
            return ResponseEntity.ok(appointmentRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/appointment/{id}")
    public @ResponseBody ResponseEntity<Appointment> getAppointment(@PathVariable int id) {
        try {
            Appointment appointmentData = appointmentRepository.findById(id).get();
            return ResponseEntity.ok(appointmentData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/appointment/{appointment_id}") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<Appointment> updateAppointment(@RequestParam String appointment_date,
            @RequestParam String appointment_time, @RequestParam boolean appointment_status,
            @RequestParam int medstaff_id, @RequestParam int patient_id, @PathVariable int appointment_id) {

        try {
            Appointment appointmentData = new Appointment();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            Patient patientData = patientRepository.findById(patient_id).get();

            appointmentData.setMedicalStaff(medicalData);
            appointmentData.setPatient(patientData);

            appointmentData.setAppointment_date(appointment_date);
            appointmentData.setAppointment_time(appointment_time);
            appointmentData.setAppointment_status(appointment_status);

            appointmentRepository.save(appointmentData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/appointment/{id}")
    public @ResponseBody ResponseEntity<Void> deleteAppointment(@PathVariable int id) {
        try {
            appointmentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}