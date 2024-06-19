package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.model.Doctor;

public class DoctorDAO {
    private static final Logger logger = LogManager.getLogger(DoctorDAO.class);

    private static List<Doctor> doctors = new ArrayList<>();

    // Static block to add dummy data
    static {
        // Dummy doctor data
        Doctor doctor1 = new Doctor("Dr. Smith", "789-012-3456", "123 Main St", false, "OB/GYN");
        Doctor doctor2 = new Doctor("Dr. Johnson", "987-654-3210", "456 Elm St", false, "Pediatrician");
        doctors.add(doctor1);
        doctors.add(doctor2);
    }

    // Create operation
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        logger.info("Doctor added: {}", doctor.getId());
    }

    // Read operation
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        logger.error("Doctor not found with ID: {}", id);
        return null;
    }

    // Update operation
    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                logger.info("Doctor updated: {}", updatedDoctor.getId());
                return;
            }
        }
        logger.error("Doctor not found with ID: {}", updatedDoctor.getId());
    }

    // Delete operation
    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
        logger.info("Doctor deleted: {}", id);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        logger.info("Retrieving all doctors");
        return doctors;
    }
}
