
package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.model.Prescription;

public class PrescriptionDAO {
    private static final Logger logger = LogManager.getLogger(PrescriptionDAO.class);

    private static List<Prescription> prescriptions = new ArrayList<>();
    static {
        // Dummy data for prescriptions
        Prescription prescription1 = new Prescription("Emma Johnson", "Paracetamol", "500mg", "Take one tablet daily");
        Prescription prescription2 = new Prescription("Olivia Smith", "Amoxicillin", "250mg", "Take two tablets twice daily");
        Prescription prescription3 = new Prescription("Sophia Williams", "Ibuprofen", "400mg", "Take one tablet as needed for pain");
        
        // Adding the dummy prescriptions to the list
        prescriptions.add(prescription1);
        prescriptions.add(prescription2);
        prescriptions.add(prescription3);
    }
    // Create operation
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        logger.info("Prescription added: {}", prescription.getId());
    }

    // Read operation
    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        logger.error("Prescription not found with ID: {}", id);
        return null;
    }

    // Update operation
    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getId() == updatedPrescription.getId()) {
                prescriptions.set(i, updatedPrescription);
                logger.info("Prescription updated: {}", updatedPrescription.getId());
                return;
            }
        }
        logger.error("Prescription not found with ID: {}", updatedPrescription.getId());
    }

    // Delete operation
    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
        logger.info("Prescription deleted: {}", id);
    }

    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        logger.info("Retrieving all prescriptions");
        return prescriptions;
    }
}