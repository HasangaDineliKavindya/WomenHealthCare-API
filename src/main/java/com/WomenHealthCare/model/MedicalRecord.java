package com.WomenHealthCare.model;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MedicalRecord {
    private static final Logger logger = LogManager.getLogger(MedicalRecord.class);
    private Patient patient;
    private List<String> diagnoses;
    private List<String> treatments;
    

    public MedicalRecord(Patient patient) {
        this.patient = patient;
        this.diagnoses = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public MedicalRecord(String string, String string2, String string3, String string4) {
        
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void addDiagnosis(String diagnosis) {
        this.diagnoses.add(diagnosis);
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public void addTreatment(String treatment) {
        this.treatments.add(treatment);
    }

    public int getId() {
       
        return this.patient.getId();
    }

    public void setId(int id) {
        this.patient.setId(id);
        logger.info("Setting ID for Patient: " + id);
    }
    
}