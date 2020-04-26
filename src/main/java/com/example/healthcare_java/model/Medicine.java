package com.example.healthcare_java.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medicine")

public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medicine_id;

    @NotNull
    private String medicine_exp_date;

    @NotNull
    private String medicine_name;

    @NotNull
    private String medicine_vendor;

    @NotNull
    private int medicine_level;

    @NotNull
    private int medicine_price;
    
    @NotNull
    private int medicine_qty;

    @OneToMany(targetEntity = MedicineList.class, mappedBy = "medicine", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MedicineList> medicineList;

    // constructor
    public Medicine() {
    }

    public Medicine(int med_id) {
        this.medicine_id = med_id;
    }

    public Medicine(String med_date, String med_name, String med_vendor, int med_level, int med_price, int med_qty) {
        this.medicine_exp_date = med_date;
        this.medicine_name = med_name;
        this.medicine_vendor = med_vendor;
        this.medicine_level = med_level;
        this.medicine_price = med_price;
        this.medicine_qty = med_qty;
    }

    // Getter - setter
    public int getMedicine_id() {
        return this.medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_exp_date() {
        return this.medicine_exp_date;
    }

    public void setMedicine_exp_date(String medicine_exp_date) {
        this.medicine_exp_date = medicine_exp_date;
    }

    public String getMedicine_name() {
        return this.medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_vendor() {
        return this.medicine_vendor;
    }

    public void setMedicine_vendor(String medicine_vendor) {
        this.medicine_vendor = medicine_vendor;
    }

    public int getMedicine_level() {
        return this.medicine_level;
    }

    public void setMedicine_level(int medicine_level) {
        this.medicine_level = medicine_level;
    }

    public int getMedicine_price() {
        return this.medicine_price;
    }

    public void setMedicine_price(int medicine_price) {
        this.medicine_price = medicine_price;
    }

    public int getMedicine_qty() {
        return this.medicine_qty;
    }

    public void setMedicine_qty(int medicine_qty) {
        this.medicine_qty = medicine_qty;
    }

}