package com.WomenHealthCare.resource;

import com.WomenHealthCare.model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.WomenHealthCare.dao.AppointmentDAO;

@Path("/appointments")
public class AppointmentResource {
    private static final Logger logger = LogManager.getLogger(AppointmentResource.class);
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    // Endpoint to retrieve all appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            logger.info("Retrieved all appointments");
            return Response.ok(appointments).build();
        } catch (Exception e) {
            logger.error("Error retrieving appointments: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving appointments").build();
        }
    }

    // Endpoint to retrieve a specific appointment by ID
    @GET
    @Path("/{appointmentsId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("appointmentsId") int id) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            if (appointment != null) {
                logger.info("Retrieved appointment with ID: {}", id);
                return Response.ok(appointment).build();
            } else {
                logger.error("Appointment not found with ID: {}", id);
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
            }
        } catch (Exception e) {
            logger.error("Error retrieving appointment with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving appointment").build();
        }
    }

    // Endpoint to add a new appointment
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            logger.info("Appointment added: {}", appointment.getId());
            return Response.status(Response.Status.CREATED).entity("Appointment created").build();
        } catch (Exception e) {
            logger.error("Error adding appointment: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding appointment").build();
        }
    }

    // Endpoint to update an existing appointment
    @PUT
    @Path("/{appointmentsId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentsId") int id, Appointment updatedAppointment) {
        try {
            updatedAppointment.setId(id);
            appointmentDAO.updateAppointment(updatedAppointment);
            logger.info("Appointment updated: {}", id);
            return Response.ok().entity("Appointment updated").build();
        } catch (Exception e) {
            logger.error("Error updating appointment with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating appointment").build();
        }
    }

    // Endpoint to delete an existing appointment
    @DELETE
    @Path("/{appointmentsId}")
    public Response deleteAppointment(@PathParam("appointmentsId") int id) {
        try {
            appointmentDAO.deleteAppointment(id);
            logger.info("Appointment deleted: {}", id);
            return Response.ok().entity("Appointment deleted").build();
        } catch (Exception e) {
            logger.error("Error deleting appointment with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting appointment").build();
        }
    }
}
