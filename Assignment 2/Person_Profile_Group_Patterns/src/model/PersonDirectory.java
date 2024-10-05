/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Shreyas Purkar
 */
public class PersonDirectory {
    
    private ArrayList<Person> persons;

    /**
     * 
     */
    public PersonDirectory() {
        persons = new ArrayList<>();
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Person> getPersons() {
        return persons;
    }

    /**
     * 
     * @param persons 
     */
    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    /**
     * 
     * @param person
     * @return 
     */
    public Person addPerson(Person person) {
        persons.add(person);
        return person;
    }
    
    /**
     * 
     * @param person 
     */
    public void deletePerson(Person person) {
        persons.remove(person);
    }
    
}
