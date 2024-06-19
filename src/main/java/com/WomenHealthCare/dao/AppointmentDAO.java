package com.WomenHealthCare.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.model.Appointment;
import com.WomenHealthCare.model.Doctor;
import com.WomenHealthCare.model.Patient;


public class AppointmentDAO {
    private static final Logger logger = LogManager.getLogger(AppointmentDAO.class);

    private static List<Appointment> appointments = new ArrayList<>();

    // Dummy data for appointments
    static {
        // Dummy patient data
        Patient patient1 = new Patient("Alice", "123-456-7890", "123 Street, City", true, "Previous surgeries: Appendectomy", "Healthy");
        Patient patient2 = new Patient("Beth", "456-789-0123", "456 Avenue, Town", true, "Previous pregnancies: 1", "Healthy");

        // Dummy doctor data
        Doctor doctor1 = new Doctor("Dr. Smith", "OB/GYN", "789-012-3456", false, null);
        Doctor doctor2 = new Doctor("Dr. Johnson", "Pediatrician", "987-654-3210", false, null);

        // Adding dummy appointments
        appointments.add(new Appointment(1, new Date(), "10:00 AM", patient1, doctor1));
        appointments.add(new Appointment(2, new Date(), "11:00 AM", patient2, doctor2));
    }

    // Create operation
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        logger.info("Appointment added: {}", appointment.getId());
    }

    // Read operation
    public Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == id) {
                return appointment;
            }
        }
        logger.error("Appointment not found with ID: {}", id);
        return null;
    }

    // Update operation
    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                logger.info("Appointment updated: {}", updatedAppointment.getId());
                return;
            }
        }
        logger.error("Appointment not found with ID: {}", updatedAppointment.getId());
    }

    // Delete operation
    public void deleteAppointment(int id) {
        appointments.removeIf(appointment -> appointment.getId() == id);
        logger.info("Appointment deleted: {}", id);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        logger.info("Retrieving all appointments");
        return appointments;
    }
}
