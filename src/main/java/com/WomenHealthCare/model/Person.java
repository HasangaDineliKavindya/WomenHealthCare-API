package com.WomenHealthCare.model;

// Class representing a person, including pregnant women
public class Person {
    private int id; // Unique identifier for the person
    private String name; // Name of the person
    private String contactInformation; // Contact information of the person
    private String address; // Address of the person
    private boolean isPregnant; // Flag indicating if the person is pregnant

    // Constructor with parameters for name, contact information, address, and pregnancy status
    public Person(String name, String contactInformation, String address, boolean isPregnant) {
        this.name = name;
        this.contactInformation = contactInformation;
        this.address = address;
        this.isPregnant = isPregnant;
    }

    // Getter method to check if the person is pregnant
    public boolean isPregnant() {
        return isPregnant;
    }

    // Setter method to update pregnancy status
    public void setPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    // Getter method for retrieving the name of the person
    public String getName() {
        return name;
    }

    // Setter method for updating the name of the person
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the contact information of the person
    public String getContactInformation() {
        return contactInformation;
    }

    // Setter method for updating the contact information of the person
    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    // Getter method for retrieving the address of the person
    public String getAddress() {
        return address;
    }

    // Setter method for updating the address of the person
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method for retrieving the ID of the person
    public int getId() {
        return id;
    }

    // Setter method for updating the ID of the person
    public void setId(int id) {
        this.id = id;
    }
}
