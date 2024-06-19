package com.WomenHealthCare.resource;



import com.WomenHealthCare.model.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.WomenHealthCare.dao.BillingDAO;

@Path("/billings")
public class BillingResource {
    private static final Logger logger = LogManager.getLogger(BillingResource.class);
    private final BillingDAO billingDAO = new BillingDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBillings() {
        try {
            List<Billing> billings = billingDAO.getAllBillings();
            logger.info("Retrieved all billings");
            return Response.ok(billings).build();
        } catch (Exception e) {
            logger.error("Error retrieving billings: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving billings").build();
        }
    }

    @GET
    @Path("/{billingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingById(@PathParam("billingId") int id) {
        try {
            Billing billing = billingDAO.getBillingById(id);
            if (billing != null) {
                logger.info("Retrieved billing with ID: {}", id);
                return Response.ok(billing).build();
            } else {
                logger.error("Billing not found with ID: {}", id);
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving billing with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving billing").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        try {
            billingDAO.addBilling(billing);
            logger.info("Billing added: {}", billing.getId());
            return Response.status(Response.Status.CREATED).entity("Billing created").build();
        } catch (Exception e) {
            logger.error("Error adding billing: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding billing").build();
        }
    }

    @PUT
    @Path("/{billingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billingId") int id, Billing updatedBilling) {
        try {
            updatedBilling.setPaid(id);
            billingDAO.updateBilling(updatedBilling);
            logger.info("Billing updated: {}", id);
            return Response.ok().entity("Billing updated").build();
        } catch (Exception e) {
            logger.error("Error updating billing with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating billing").build();
        }
    }

    @DELETE
    @Path("/{billingId}")
    public Response deleteBilling(@PathParam("billingId") int id) {
        try {
            billingDAO.deleteBilling(id);
            logger.info("Billing deleted: {}", id);
            return Response.ok().entity("Billing deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting billing with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting billing").build();
        }
    }
}
