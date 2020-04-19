package com.example.healthcare_java.exception;

public class PatientNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // private int patient_id;

    public PatientNotFoundException(int patient_id) {
        super(String.format("Patient is not found with id : '%s'", patient_id));
    }
}