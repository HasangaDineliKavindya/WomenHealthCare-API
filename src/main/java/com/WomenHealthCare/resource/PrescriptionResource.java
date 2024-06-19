package com.WomenHealthCare.resource;



import com.WomenHealthCare.model.Prescription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.dao.PrescriptionDAO;

@Path("/prescriptions")
public class PrescriptionResource {
    private static final Logger logger = LogManager.getLogger(PrescriptionResource.class);
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            logger.info("Retrieved all prescriptions");
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            logger.error("Error retrieving prescriptions: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving prescriptions").build();
        }
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("prescriptionId") int id) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(id);
            if (prescription != null) {
                logger.info("Retrieved prescription with ID: {}", id);
                return Response.ok(prescription).build();
            } else {
                logger.error("Prescription not found with ID: {}", id);
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving prescription with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving prescription").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            logger.info("Prescription added: {}", prescription.getId());
            return Response.status(Response.Status.CREATED).entity("Prescription created").build();
        } catch (Exception e) {
            logger.error("Error adding prescription: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding prescription").build();
        }
    }

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") int id, Prescription updatedPrescription) {
        try {
            updatedPrescription.setId(id);
            prescriptionDAO.updatePrescription(updatedPrescription);
            logger.info("Prescription updated: {}", id);
            return Response.ok().entity("Prescription updated").build();
        } catch (Exception e) {
            logger.error("Error updating prescription with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating prescription").build();
        }
    }

    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") int id) {
        try {
            prescriptionDAO.deletePrescription(id);
            logger.info("Prescription deleted: {}", id);
            return Response.ok().entity("Prescription deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting prescription with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting prescription").build();
        }
    }
}
