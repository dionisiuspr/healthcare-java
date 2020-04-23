package com.example.healthcare_java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "disease")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int disease_id;

    @NotNull
    private String disease_type;

    @NotNull
    private String disease_name;

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

}