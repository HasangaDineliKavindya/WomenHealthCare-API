package com.WomenHealthCare.resource;

import com.WomenHealthCare.model.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.dao.DoctorDAO;

@Path("/doctors")
public class DoctorResource {
    private static final Logger logger = LogManager.getLogger(DoctorResource.class);
    private final DoctorDAO doctorDAO = new DoctorDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            logger.info("Retrieved all doctors");
            return Response.ok(doctors).build();
        } catch (Exception e) {
            logger.error("Error retrieving doctors: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving doctors").build();
        }
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("doctorId") int id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                logger.info("Retrieved doctor with ID: {}", id);
                return Response.ok(doctor).build();
            } else {
                logger.error("Doctor not found with ID: {}", id);
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving doctor with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving doctor").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDAO.addDoctor(doctor);
            logger.info("Doctor added: {}", doctor.getId());
            return Response.status(Response.Status.CREATED).entity("Doctor created").build();
        } catch (Exception e) {
            logger.error("Error adding doctor: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding doctor").build();
        }
    }

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int id, Doctor updatedDoctor) {
        try {
            updatedDoctor.setId(id);
            doctorDAO.updateDoctor(updatedDoctor);
            logger.info("Doctor updated: {}", id);
            return Response.ok().entity("Doctor updated").build();
        } catch (Exception e) {
            logger.error("Error updating doctor with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating doctor").build();
        }
    }

    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int id) {
        try {
            doctorDAO.deleteDoctor(id);
            logger.info("Doctor deleted: {}", id);
            return Response.ok().entity("Doctor deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting doctor with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting doctor").build();
        }
    }
}
