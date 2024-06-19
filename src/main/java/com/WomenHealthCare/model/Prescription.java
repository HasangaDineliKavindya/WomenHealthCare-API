package com.WomenHealthCare.model;

// Class representing a prescription
public class Prescription {
    private int id; // Unique identifier for the prescription
    private String patient; // Name of the patient
    private String medication; // Name of the prescribed medication
    private String dosage; // Dosage of the medication
    private String instructions; // Instructions for taking the medication

    // Constructor to initialize a prescription with patient, medication, dosage, and instructions
    public Prescription(String patient, String medication, String dosage, String instructions) {
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
    }

    // Getter method for patient name
    public String getPatient() {
        return patient;
    }

    // Setter method for patient name
    public void setPatient(String patient) {
        this.patient = patient;
    }

    // Getter method for medication name
    public String getMedication() {
        return medication;
    }

    // Setter method for medication name
    public void setMedication(String medication) {
        this.medication = medication;
    }

    // Getter method for dosage
    public String getDosage() {
        return dosage;
    }

    // Setter method for dosage
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    // Getter method for instructions
    public String getInstructions() {
        return instructions;
    }

    // Setter method for instructions
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    // Getter method for prescription ID
    public int getId() {
        return id;
    }

    // Setter method for prescription ID
    public void setId(int id) {
        this.id = id;
    }
}
