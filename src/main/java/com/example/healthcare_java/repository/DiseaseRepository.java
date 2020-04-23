package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.Disease;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends CrudRepository<Disease, Integer> {
}