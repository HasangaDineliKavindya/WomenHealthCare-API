package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.List;

import com.WomenHealthCare.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatientDAO {
    // Logger for logging messages
    private static final Logger logger = LogManager.getLogger(PatientDAO.class);

    // List to store patient data
    private static List<Patient> patients = new ArrayList<>();
    
    // Dummy data for pregnant women
    static {
        patients.add(new Patient("Alice", "123-456-7890", "123 Street, City", true, "Previous surgeries: Appendectomy", "Healthy"));
        patients.add(new Patient("Beth", "456-789-0123", "456 Avenue, Town", true, "Previous pregnancies: 1", "Healthy"));
        patients.add(new Patient("Carol", "789-012-3456", "789 Road, Village", true, "None", "Healthy"));
    }
    
    // Create operation: Add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        logger.info("Patient added: {}", patient.getId());
    }

    // Read operation: Get a patient by ID
    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        logger.error("Patient not found with ID: {}", id);
        return null;
    }

    // Update operation: Update an existing patient's information
    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                logger.info("Patient updated: {}", updatedPatient.getId());
                return;
            }
        }
        logger.error("Patient not found with ID: {}", updatedPatient.getId());
    }

    // Delete operation: Delete a patient by ID
    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
        logger.info("Patient deleted: {}", id);
    }

    // Get all patients: Retrieve all patients from the list
    public List<Patient> getAllPatients() {
        logger.info("Retrieving all patients");
        return patients;
    }
}
