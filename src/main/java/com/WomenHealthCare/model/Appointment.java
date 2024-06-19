package com.WomenHealthCare.model;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Class representing an appointment
public class Appointment {
    private static final Logger logger = LogManager.getLogger(Appointment.class);
    private int id; // Unique identifier for the appointment
    private Date date; // Date of the appointment
    private String time; // Time of the appointment
    private Patient patient; // Patient associated with the appointment
    private Doctor doctor; // Doctor associated with the appointment
    
    // Constructor with parameters for ID, date, time, patient, and doctor
    public Appointment(int id, Date date, String time, Patient patient, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.doctor = doctor;
    }
    
    // Unique method for pregnant women to attend pregnancy check-up appointment
    public void checkPregnancyAppointment() {
        logger.info("Attending pregnancy check-up appointment.");
    }

    // Getter method for retrieving the ID of the appointment
    public int getId() {
        return id;
    }

    // Setter method for updating the ID of the appointment
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the date of the appointment
    public Date getDate() {
        return date;
    }

    // Setter method for updating the date of the appointment
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter method for retrieving the time of the appointment
    public String getTime() {
        return time;
    }

    // Setter method for updating the time of the appointment
    public void setTime(String time) {
        this.time = time;
    }

    // Getter method for retrieving the patient associated with the appointment
    public Patient getPatient() {
        return patient;
    }

    // Setter method for updating the patient associated with the appointment
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter method for retrieving the doctor associated with the appointment
    public Doctor getDoctor() {
        return doctor;
    }

    // Setter method for updating the doctor associated with the appointment
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
