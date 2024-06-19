package com.WomenHealthCare.resource;

import com.WomenHealthCare.dao.PatientDAO;
import com.WomenHealthCare.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/patients")
public class PatientResource {
    private static final Logger logger = LogManager.getLogger(PatientResource.class);
    private final PatientDAO patientDAO = new PatientDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        try {
            return Response.ok(patientDAO.getAllPatients()).build();
        } catch (Exception e) {
            logger.error("Error retrieving patients: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving patients").build();
        }
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("patientId") int id) {
        try {
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving patient with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving patient").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).entity("Patient created").build();
        } catch (Exception e) {
            logger.error("Error adding patient: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding patient").build();
        }
    }

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") int id, Patient updatedPatient) {
        try {
            updatedPatient.setId(id);
            patientDAO.updatePatient(updatedPatient);
            return Response.ok().entity("Patient updated").build();
        } catch (Exception e) {
            logger.error("Error updating patient with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating patient").build();
        }
    }

    @DELETE
    @Path("/{patientId}")
    public Response deletePatient(@PathParam("patientId") int id) {
        try {
            patientDAO.deletePatient(id);
            return Response.ok().entity("Patient deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting patient with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting patient").build();
        }
    }
}
