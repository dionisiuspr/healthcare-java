package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.Appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    
}