// PersonDAO.java
package com.WomenHealthCare.dao;

import com.WomenHealthCare.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersonDAO {
    // Logger for logging messages
    private static final Logger logger = LogManager.getLogger(PersonDAO.class);
    // List to store Person objects
    private static List<Person> people = new ArrayList<>();

    static {
        // Existing data
        // Initialize some sample Person objects
        Person woman1 = new Person("Emma Johnson", "123 Main Street", "New York", false);
        Person woman2 = new Person("Olivia Smith", "456 Oak Avenue", "Los Angeles", true);
        Person woman3 = new Person("Sophia Williams", "789 Elm Road", "Chicago", false);
        Person woman4 = new Person("Ava Brown", "101 Pine Lane", "Houston", true);
        Person woman5 = new Person("Isabella Jones", "234 Cedar Drive", "Miami", false);
        // Adding Dummy data
        // Add a dummy Person object to the list
        Person dummy = new Person("Dummy Garcia", "789 Maple Street", "San Francisco", true);
        people.add(dummy);
    }

    // Method to get all Person objects
    public List<Person> getAllPeople() {
        return people;
    }

    // Method to get a Person by ID
    public Person getPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    // Method to add a new Person
    public void addPerson(Person person) {
        int newUserId = getNextUserId();
        person.setId(newUserId);
        people.add(person);
    }

    // Method to update an existing Person
    public void updatePerson(Person updatedPerson) {
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            if (person.getId() == updatedPerson.getId()) {
                people.set(i, updatedPerson);
                return;
            }
        }
    }

    // Method to delete a Person by ID
    public void deletePerson(int id) {
        people.removeIf(person -> person.getId() == id);
    }

    // Method to get the next available user ID
    public int getNextUserId() {
        int maxUserId = Integer.MIN_VALUE;
        for (Person person : people) {
            int userId = person.getId();
            if (userId > maxUserId) {
                maxUserId = userId;
            }
        }
        return maxUserId + 1;
    }
}
