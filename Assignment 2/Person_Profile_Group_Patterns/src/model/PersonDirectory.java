/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * Class to perform create, search, update and delete person operations
 * 
 * @author Shreyas Purkar
 */
public class PersonDirectory {
    
    private ArrayList<Person> persons;

    /**
     * Default constructor
     */
    public PersonDirectory() {
        persons = new ArrayList<>();
    }

    /**
     * Method to get list of person
     * 
     * @return List of person
     */
    public ArrayList<Person> getPersons() {
        return persons;
    }

    /**
     * Method to add person details in the list
     * 
     * @param persons list
     */
    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    /**
     * Method to add new person
     * 
     * @param person object
     * @return person details
     */
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }
    
    /**
     * Method to delete a person
     * 
     * @param person object
     */
    public void deletePerson(Person person) {
        persons.remove(person);
    }
    
    public Person searchPerson(String searchValue) {
        Person existingPerson = null;
        for (Person p : getPersons()) {
            if(p.getHomeAddress().getStreetAddress().equalsIgnoreCase(searchValue)
                    || p.getWorkAddress().getStreetAddress().equalsIgnoreCase(searchValue)
                    || p.getFirstName().equalsIgnoreCase(searchValue)
                    || p.getLastName().equalsIgnoreCase(searchValue)) {
                existingPerson = p;
            }
        }
        return existingPerson;
    }
}
