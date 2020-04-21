package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.MedicalStaff;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalStaffRepository extends CrudRepository<MedicalStaff, Integer> {
}