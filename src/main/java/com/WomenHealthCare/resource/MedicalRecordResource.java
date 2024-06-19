package com.WomenHealthCare.resource;



import com.WomenHealthCare.model.MedicalRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.dao.MedicalRecordDAO;

@Path("/medical-records")
public class MedicalRecordResource {
    private static final Logger logger = LogManager.getLogger(MedicalRecordResource.class);
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecords() {
        try {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            logger.info("Retrieved all medical records");
            return Response.ok(medicalRecords).build();
        } catch (Exception e) {
            logger.error("Error retrieving medical records: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving medical records").build();
        }
    }

    @GET
    @Path("/{medical-recordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordById(@PathParam("medical-recordId") int id) {
        try {
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecord != null) {
                logger.info("Retrieved medical record with ID: {}", id);
                return Response.ok(medicalRecord).build();
            } else {
                logger.error("Medical Record not found with ID: {}", id);
                return Response.status(Response.Status.NOT_FOUND).entity("Medical Record not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving medical record with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving medical record").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            logger.info("Medical Record added: {}", medicalRecord.getId());
            return Response.status(Response.Status.CREATED).entity("Medical Record created").build();
        } catch (Exception e) {
            logger.error("Error adding medical record: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding medical record").build();
        }
    }

    @PUT
    @Path("/{medical-recordId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("medical-recordId") int id, MedicalRecord updatedMedicalRecord) {
        try {
            updatedMedicalRecord.setId(id);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
            logger.info("Medical Record updated: {}", id);
            return Response.ok().entity("Medical Record updated").build();
        } catch (Exception e) {
            logger.error("Error updating medical record with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating medical record").build();
        }
    }

    @DELETE
    @Path("/{medical-recordId}")
    public Response deleteMedicalRecord(@PathParam("medical-recordId") int id) {
        try {
            medicalRecordDAO.deleteMedicalRecord(id);
            logger.info("Medical Record deleted: {}", id);
            return Response.ok().entity("Medical Record deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting medical record with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting medical record").build();
        }
    }
}
