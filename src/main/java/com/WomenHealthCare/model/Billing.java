package com.WomenHealthCare.model;

// Class representing billing information
public class Billing {
    private Patient patient; // Patient associated with the billing
    private double amount; // Amount to be paid
    private int paid; // Flag indicating whether the bill is paid or not

    // Constructor to initialize billing with patient, amount, and paid status
    public Billing(Patient patient, double amount, int paid) {
        this.patient = patient;
        this.amount = amount;
        this.paid = paid;
    }

    // Getter method for patient
    public Patient getPatient() {
        return patient;
    }

    // Setter method for patient
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Getter method for amount
    public double getAmount() {
        return amount;
    }

    // Setter method for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Method to check if the bill is paid
    public int isPaid() {
        return paid;
    }

    // Setter method for paid status
    public void setPaid(int paid) {
        this.paid = paid;
    }

    // Method to get the ID of the associated patient
    public int getId() {
        return patient.getId();
    }
}
