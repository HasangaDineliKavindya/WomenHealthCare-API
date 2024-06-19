package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.WomenHealthCare.model.MedicalRecord;

public class MedicalRecordDAO {
    private static final Logger logger = LogManager.getLogger(MedicalRecordDAO.class);

    private static List<MedicalRecord> medicalRecords = new ArrayList<>();

    // Adding dummy data
    static {
        // Dummy data for women's pregnancy records
        MedicalRecord record1 = new MedicalRecord("Emma Johnson", "2023-06-10", "Pregnancy", "Normal");
        MedicalRecord record2 = new MedicalRecord("Olivia Smith", "2023-07-15", "Pregnancy", "High Risk");
        MedicalRecord record3 = new MedicalRecord("Sophia Williams", "2023-08-20", "Pregnancy", "Normal");
        MedicalRecord record4 = new MedicalRecord("Ava Brown", "2023-09-25", "Pregnancy", "High Risk");
        MedicalRecord record5 = new MedicalRecord("Isabella Jones", "2023-10-30", "Pregnancy", "Normal");
        
        // Adding the dummy records to the list
        medicalRecords.add(record1);
        medicalRecords.add(record2);
        medicalRecords.add(record3);
        medicalRecords.add(record4);
        medicalRecords.add(record5);
    }

    // Create operation
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        logger.info("Medical Record added: {}", medicalRecord.getId());
    }

    // Read operation
    public MedicalRecord getMedicalRecordById(int id) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        logger.error("Medical Record not found with ID: {}", id);
        return null;
    }

    // Update operation
    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getId() == updatedMedicalRecord.getId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                logger.info("Medical Record updated: {}", updatedMedicalRecord.getId());
                return;
            }
        }
        logger.error("Medical Record not found with ID: {}", updatedMedicalRecord.getId());
    }

    // Delete operation
    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
        logger.info("Medical Record deleted: {}", id);
    }

    // Get all medical records
    public List<MedicalRecord> getAllMedicalRecords() {
        logger.info("Retrieving all medical records");
        return medicalRecords;
    }
}
