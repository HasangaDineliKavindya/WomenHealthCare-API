package com.WomenHealthCare.model;


public class Patient extends Person {
    private String medicalHistory;
    private String currentHealthStatus;
    
    public Patient(String name, String contactInformation, String address, boolean isPregnant, String medicalHistory, String currentHealthStatus) {
        super(name, contactInformation, address, isPregnant);
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
    // Unique method for pregnant women
    public void checkBabyKick() {
        System.out.println("Feeling the baby kick!");
    }

    // Getters and setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    // This getId() method is inherited from the Person class
}
