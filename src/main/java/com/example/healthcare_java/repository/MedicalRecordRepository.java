package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.MedicalRecord;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Integer> {
    
}