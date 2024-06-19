package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.model.Billing;
import com.WomenHealthCare.model.Patient;

public class BillingDAO {
    private static final Logger logger = LogManager.getLogger(BillingDAO.class);

    private static List<Billing> billings = new ArrayList<>();

    // Create operation
    public void addBilling(Billing billing) {
        billings.add(billing);
        logger.info("Billing added: {}", billing.getId());
    }

    // Read operation
    public Billing getBillingById(int id) {
        for (Billing billing : billings) {
            if (billing.getId() == id) {
                return billing;
            }
        }
        logger.error("Billing not found with ID: {}", id);
        return null;
    }

    // Update operation
    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            if (billings.get(i).getId() == updatedBilling.getId()) {
                billings.set(i, updatedBilling);
                logger.info("Billing updated: {}", updatedBilling.getId());
                return;
            }
        }
        logger.error("Billing not found with ID: {}", updatedBilling.getId());
    }

    // Delete operation
    public void deleteBilling(int id) {
        billings.removeIf(billing -> billing.getId() == id);
        logger.info("Billing deleted: {}", id);
    }

    // Get all billings
    public List<Billing> getAllBillings() {
        logger.info("Retrieving all billings");
        return billings;
    }

    // Dummy data for billings
    static {
        // Dummy patient data
        Patient patient1 = new Patient("Alice", "123-456-7890", "123 Street, City", true, "Previous surgeries: Appendectomy", "Healthy");
        Patient patient2 = new Patient("Beth", "456-789-0123", "456 Avenue, Town", true, "Previous pregnancies: 1", "Healthy");

        // Adding dummy billings
        billings.add(new Billing(patient1, 100.00, 1));
        billings.add(new Billing(patient2, 150.00, 0));
    }
}
