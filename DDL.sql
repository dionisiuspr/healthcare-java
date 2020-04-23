CREATE DATABASE healthcare_java;

CREATE TABLE patient(
	patient_id int,
	patient_name VARCHAR(50),
	patient_address VARCHAR(50),
	patient_age int,
	patient_dob VARCHAR(50),
	patient_gender char(1),
	patient_uname VARCHAR(50),
	patient_pwd VARCHAR(20),
	PRIMARY KEY(patient_id)
);

CREATE TABLE medical_staff(
	medstaff_id int,
	medstaff_age int,
	medstaff_name VARCHAR(50),
	medstaff_uname VARCHAR(50),
	medstaff_pwd VARCHAR(20),
	PRIMARY KEY(medstaff_id)
);

CREATE TABLE disease(
	disease_id int,
	disease_type VARCHAR(50),
	disease_name VARCHAR(50),
	PRIMARY KEY(disease_id)
);

CREATE TABLE medicine(
	medicine_id int,
	medicine_exp_date VARCHAR(50),
	medicine_name VARCHAR(30),
	medicine_vendor VARCHAR(30),
	medicine_level int,
	medicine_price int,
	medicine_qty int,
	PRIMARY KEY(medicine_id)
);

CREATE TABLE medical_record(
	record_id int,
	#fk
	patient_id int,
	medstaff_id int,
	disease_id int,
	medicine_id int,
	hospital_id int,
	anamnesia VARCHAR(500),
	PRIMARY KEY(record_id),
	FOREIGN KEY(patient_id) REFERENCES patient(patient_id),
	FOREIGN KEY(medstaff_id) REFERENCES medical_staff(medstaff_id),
	FOREIGN KEY(disease_id) REFERENCES disease(disease_id),
	FOREIGN KEY(medicine_id) references medicine(medicine_id),
);

CREATE TABLE appointment(
	appt_id int,
	appt_date date,
	appt_time time,
	appt_status boolean,
	#fk
	patient_id int,
	medstaff_id int,
	PRIMARY KEY(appt_id),
	FOREIGN KEY(patient_id) REFERENCES patient(patient_id),
	FOREIGN KEY(medstaff_id) REFERENCES medical_staff(medstaff_id)
);

CREATE TABLE schedule(
	schedule_id int NOT NULL AUTO_INCREMENT,
	schedule_date date,
	schedule_time time,
	#fk
	medstaff_id int,
	PRIMARY KEY(schedule_id),
	FOREIGN KEY(medstaff_id) REFERENCES medical_staff(medstaff_id)
);