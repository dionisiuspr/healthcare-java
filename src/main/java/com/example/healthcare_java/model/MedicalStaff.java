package com.example.healthcare_java.model;

// import javax.persistence.CascadeType;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "medicalStaff")
@Table(name = "medical_staff")
public class MedicalStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int medstaff_id;

    @NotNull
    private int medstaff_age;

    @NotNull
    private String medstaff_name;

    // @OneToMany(
    // mappedBy = "medicalStaff",
    // cascade = CascadeType.PERSIST,
    // fetch = FetchType.LAZY
    // )

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
}