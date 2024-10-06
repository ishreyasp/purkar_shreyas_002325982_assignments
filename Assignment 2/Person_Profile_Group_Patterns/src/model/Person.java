/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * Class to hold person details
 * 
 * @author Shreyas Purkar
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private byte age;
    private String ssn;
    private Address homeAddress;
    private Address workAddress;

    /**
     * Default class constructor
     */
    public Person() {
    }

    /**
     * Parameterized constructor
     * 
     * @param firstName of the person;
     * @param lastName  of the person;
     * @param age of the person;
     * @param ssn of the person;
     * @param homeAddress object containing home address of the person
     * @param workAddress object containing work address of the person
     */
    public Person(String firstName, 
                  String lastName, 
                  byte age, 
                  String ssn, 
                  Address homeAddress, 
                  Address workAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String streetAddress, 
            short unitNumber, 
            String city, 
            String state, 
            int zipCode, 
            long phoneNumber) {
        this.homeAddress = new Address(streetAddress, 
                city, 
                state, 
                phoneNumber, 
                zipCode, 
                unitNumber);
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String streetAddress, 
            short unitNumber, 
            String city, 
            String state, 
            int zipCode, 
            long phoneNumber) {
        this.workAddress = new Address(streetAddress, 
                city, 
                state, 
                phoneNumber, 
                zipCode, 
                unitNumber);
    }

    /**
     * Method to parse first name into string
     * 
     * @return string value of first name
     */
    @Override
    public String toString() {
        return getFirstName();
    }
       
}
