package com.example.healthcare_java.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedule_id;

    private String schedule_date;

    private String schedule_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medstaff_id", referencedColumnName = "medstaff_id")
    private MedicalStaff medicalStaff;

    public Schedule() {

    }

    

    public String getSchedule_date() {
        return this.schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public Object get() {
		return this.;
	}

    public void set(Object ) {
		this. = ;
	}

    public String getSchedule_time() {
        return this.schedule_time;
    }

    public void setSchedule_time(String schedule_time) {
        this.schedule_time = schedule_time;
    }


}