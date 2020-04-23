package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.Medicine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Integer> {
    
}