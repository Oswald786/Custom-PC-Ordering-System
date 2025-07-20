package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class CustomerProfileModel {

    private String name;
    private String email;
    private String phoneNumber;
    private String shippingAddress;

    public CustomerProfileModel() {
    }


    public CustomerProfileModel(String name, String email, String phoneNumber, String shippingAddress) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.shippingAddress = shippingAddress;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShippingAddress() {
        return this.shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
