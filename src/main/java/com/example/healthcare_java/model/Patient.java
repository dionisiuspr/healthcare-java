package com.example.healthcare_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int patient_id;

    @NotNull
    private String patient_name;

    @NotNull
    private String patient_address;

    @NotNull
    private int patient_age;

    @NotNull
    private String patient_dob;

    @NotNull
    private String patient_gender;

    // constructors
    public Patient() {
    }

    public Patient(int patient_id) {
        this.patient_id = patient_id;
    }

    public Patient(String patient_name, String patient_address, int patient_age, String patient_dob, String patient_gender){
        this.patient_address = patient_address;
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_dob = patient_dob;
        this.patient_gender = patient_gender;
    }

    //getter - setter
    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return this.patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_address() {
        return this.patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public int getPatient_age() {
        return this.patient_age;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public String getPatient_dob() {
        return this.patient_dob;
    }

    public void setPatient_dob(String patient_dob) {
        this.patient_dob = patient_dob;
    }

    public String getPatient_gender() {
        return this.patient_gender;
    }

    public void setPatient_gender(String patient_gender) {
        this.patient_gender = patient_gender;
    }
}