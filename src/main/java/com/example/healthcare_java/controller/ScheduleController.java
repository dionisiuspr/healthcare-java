package com.example.healthcare_java.controller;

import com.example.healthcare_java.model.MedicalStaff;
import com.example.healthcare_java.model.Schedule;
import com.example.healthcare_java.repository.MedicalStaffRepository;
import com.example.healthcare_java.repository.ScheduleRepository;

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
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MedicalStaffRepository medstaffRepository;

    // insert
    @PostMapping(path = "/schedule/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<Schedule> addSchedule(@RequestParam String schedule_date,
            @RequestParam String schedule_time, @RequestParam int medstaff_id) {

        try {
            Schedule scheduleData = new Schedule();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            scheduleData.setMedicalStaff(medicalData);
            scheduleData.setSchedule_date(schedule_date);
            scheduleData.setSchedule_time(schedule_time);
            scheduleRepository.save(scheduleData);
            return ResponseEntity.ok(scheduleData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get
    @GetMapping(path = "/schedule")
    public @ResponseBody ResponseEntity<Iterable<Schedule>> getAllSchedule() {
        try {
            return ResponseEntity.ok(scheduleRepository.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // get by id
    @GetMapping(path = "/schedule/{id}")
    public @ResponseBody ResponseEntity<Schedule> getSchedule(@PathVariable int id) {
        try {
            Schedule scheduleData = scheduleRepository.findById(id).get();
            return ResponseEntity.ok(scheduleData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // update
    @PutMapping(path = "/schedule/{schedule_id}")
    public @ResponseBody ResponseEntity<Schedule> updateSchedule(@RequestParam String schedule_time,
            @RequestParam String schedule_date, @RequestParam int medstaff_id, @PathVariable int schedule_id) {

        try {
            Schedule scheduleData = new Schedule();
            MedicalStaff medicalData = medstaffRepository.findById(medstaff_id).get();
            scheduleData.setMedicalStaff(medicalData);
            scheduleData.setSchedule_id(schedule_id);
            scheduleData.setSchedule_date(schedule_date);
            scheduleData.setSchedule_time(schedule_time);
            scheduleRepository.save(scheduleData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // delete
    @DeleteMapping(path = "/schedule/{id}")
    public @ResponseBody ResponseEntity<Void> deleteSchedule(@PathVariable int id) {
        try {
            scheduleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}