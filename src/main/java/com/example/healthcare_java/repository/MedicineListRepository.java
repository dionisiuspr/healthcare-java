package com.example.healthcare_java.repository;

import com.example.healthcare_java.model.MedicineList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineListRepository extends CrudRepository<MedicineList, Integer>{

}