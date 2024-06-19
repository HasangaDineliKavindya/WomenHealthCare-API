package com.WomenHealthCare.model;

// Class representing a doctor, extending the Person class
public class Doctor extends Person {
    private String specialization; // Specialization of the doctor

    // Constructor with parameters for name, contact information, address, pregnancy status, and specialization
    public Doctor(String name, String contactInformation, String address, boolean isPregnant, String specialization) {
        super(name, contactInformation, address, isPregnant);
        this.specialization = specialization;
    }

    // Unique method for doctors assisting with baby delivery for pregnant women
    public void babyDeliveryAssistance() {
        System.out.println("Assisting with baby delivery!");
    }

    // Getter method for retrieving the specialization of the doctor
    public String getSpecialization() {
        return specialization;
    }

    // Setter method for updating the specialization of the doctor
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
