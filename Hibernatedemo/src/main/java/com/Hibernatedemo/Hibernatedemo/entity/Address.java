package com.Hibernatedemo.Hibernatedemo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Address {
    private String city;
    private String town;
    private String street;
    private Integer pincode;

    public Address(String city, String town, String street, Integer pincode) {
        this.city = city;
        this.town = town;
        this.street = street;
        this.pincode = pincode;
    }
    public Address() {}
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
