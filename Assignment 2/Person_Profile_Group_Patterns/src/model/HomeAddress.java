/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Shreyas Purkar
 */
public class HomeAddress {
    
    private String streetAddress;
    private String city;
    private String state;
    private long phoneNumber;
    private int zip;
    private short unitNumber;

    public HomeAddress() {
    }

    public HomeAddress(String streetAddress, String city, String state, long phoneNumber, int zip, short unitNumber) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zip = zip;
        this.unitNumber = unitNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public short getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(short unitNumber) {
        this.unitNumber = unitNumber;
    }

}
