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
@Table(name = "medical_staff")
public class MedicalStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medstaff_id;

    @NotNull
    private int medstaff_age;

    @NotNull
    private String medstaff_name;

    //relation to schedule
    @OneToMany(targetEntity = Schedule.class, mappedBy = "medicalStaff", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Schedule> schedule;

    //relation to appointment
    @OneToMany(targetEntity = Appointment.class, mappedBy = "medicalStaff", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Appointment> appointment;

    //relation to medical_record
    @OneToMany(targetEntity = MedicalRecord.class, mappedBy = "medicalStaff", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<MedicalRecord> medicalRecord;  

    public MedicalStaff() {
    }

    public MedicalStaff(final int medstaff_id) {
        this.medstaff_id = medstaff_id;
    }

    public MedicalStaff(final int medstaff_age, final String medstaff_name) {
        this.medstaff_age = medstaff_age;
        this.medstaff_name = medstaff_name;
    }

    // getter - setter
    public int getMedstaff_id() {
        return this.medstaff_id;
    }

    public void setMedstaff_id(final int medstaff_id) {
        this.medstaff_id = medstaff_id;
    }

    public int getMedstaff_age() {
        return this.medstaff_age;
    }

    public void setMedstaff_age(final int medstaff_age) {
        this.medstaff_age = medstaff_age;
    }

    public String getMedstaff_name() {
        return this.medstaff_name;
    }

    public void setMedstaff_name(final String medstaff_name) {
        this.medstaff_name = medstaff_name;
    }

    //Schedule
    @JsonBackReference
    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
        for (Schedule schedules : schedule) {
            schedules.setMedicalStaff(this);
        }
    }

    //Appoinment
    @JsonBackReference
    public Set<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppoinment(Set<Appointment> appointment) {
        this.appointment = appointment;
        for (Appointment appointments : appointment) {
            appointments.setMedicalStaff(this);
        }
    }

    //Medical Record
    @JsonBackReference
    public Set<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Set<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
        for (MedicalRecord medicalRecords : medicalRecord) {
            medicalRecords.setMedicalStaff(this);
        }
    }

}