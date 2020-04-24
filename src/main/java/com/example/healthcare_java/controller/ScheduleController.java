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

public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private MedicalStaffRepository medstaffRepository;

    //insert
    @PostMapping(path = "/schedule/add") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<Schedule> addSchedule(
            @RequestParam String schedule_date,
            @RequestParam String schedule_time,
            @RequestParam int medstaff_id) 
        {

        try {
            Schedule scheduleData = new Schedule();
            MedicalStaff medstaffData = medstaffRepository.findById(medstaff_id).get();
            scheduleData.setMedicalStaff(medstaffData);
            scheduleData.setSchedule_date(schedule_date);
            scheduleData.setSchedule_time(schedule_time);;
            scheduleRepository.save(scheduleData);
            return ResponseEntity.ok(scheduleData);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}