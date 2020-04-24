package com.example.healthcare_java.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disease")
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int disease_id;

    @NotNull
    private String disease_type;

    @NotNull
    private String disease_name;

    // relation to medical_record
    @OneToMany(targetEntity = MedicalRecord.class, mappedBy = "disease", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MedicalRecord> medicalRecord;

    // constructor
    public Disease() {
    }

    public Disease(int disease_id) {
        this.disease_id = disease_id;
    }

    public Disease(String disease_type, String disease_name) {
        this.disease_type = disease_type;
        this.disease_name = disease_name;
    }

    // getter - setter
    public int getDisease_id() {
        return this.disease_id;
    }

    public void setDisease_id(int disease_id) {
        this.disease_id = disease_id;
    }

    public String getDisease_type() {
        return this.disease_type;
    }

    public void setDisease_type(String disease_type) {
        this.disease_type = disease_type;
    }

    public String getDisease_name() {
        return this.disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    // Medical record
    @JsonBackReference
    public Set<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Set<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
        for (MedicalRecord medicalRecords : medicalRecord) {
            medicalRecords.setDisease(this);
        }
    }
}