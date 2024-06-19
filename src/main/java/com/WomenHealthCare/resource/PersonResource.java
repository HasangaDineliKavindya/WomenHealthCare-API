package com.WomenHealthCare.resource;

import com.WomenHealthCare.dao.PersonDAO;
import com.WomenHealthCare.model.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/persons")
public class PersonResource {

    private static final Logger logger = LogManager.getLogger(PersonResource.class);
    private PersonDAO personDAO = new PersonDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPeople() {
        logger.info("Retrieving all people");
        return personDAO.getAllPeople();
    }

    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personId") int personId) {
        logger.info("Retrieving person with ID: {}", personId);
        return personDAO.getPersonById(personId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPerson(Person person) {
        logger.info("Adding new person: {}", person);
        personDAO.addPerson(person);
    }

    @PUT
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(@PathParam("personId") int personId, Person updatedPerson) {
        Person existingPerson = personDAO.getPersonById(personId);

        if (existingPerson != null) {
            logger.info("Updating person with ID {}: {}", personId, updatedPerson);
            updatedPerson.setId(personId);
            personDAO.updatePerson(updatedPerson);
        } else {
            logger.error("Person with ID {} not found, update failed", personId);
        }
    }

    @DELETE
    @Path("/{personId}")
    public String deletePerson(@PathParam("personId") int personId) {
        Person deletedPerson = personDAO.getPersonById(personId);
        if (deletedPerson != null) {
            logger.info("Deleting person with ID: {}", personId);
            personDAO.deletePerson(personId);
            return "Person Successfully Deleted " + personId;
        } else {
            logger.error("Person with ID {} not found, delete failed", personId);
            return "Person with ID " + personId + " not found";
        }
    }
}
