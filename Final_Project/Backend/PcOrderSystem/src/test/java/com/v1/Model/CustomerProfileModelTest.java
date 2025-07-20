package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerProfileModelTest {

    @Test
    @DisplayName("Getters and setters work correctly for CustomerProfileModel")
    void testGettersAndSetters() {
        CustomerProfileModel customer = new CustomerProfileModel();

        customer.setName("Ethan Slade");
        customer.setEmail("ethan.slade@example.com");
        customer.setPhoneNumber("07700123456");
        customer.setShippingAddress("123 Fake Street, London, UK");

        assertEquals("Ethan Slade", customer.getName());
        assertEquals("ethan.slade@example.com", customer.getEmail());
        assertEquals("07700123456", customer.getPhoneNumber());
        assertEquals("123 Fake Street, London, UK", customer.getShippingAddress());
    }

    @Test
    @DisplayName("Constructor sets all fields correctly in CustomerProfileModel")
    void testConstructor() {
        CustomerProfileModel customer = new CustomerProfileModel(
                "Ethan Slade",
                "ethan.slade@example.com",
                "07700123456",
                "123 Fake Street, London, UK"
        );

        assertEquals("Ethan Slade", customer.getName());
        assertEquals("ethan.slade@example.com", customer.getEmail());
        assertEquals("07700123456", customer.getPhoneNumber());
        assertEquals("123 Fake Street, London, UK", customer.getShippingAddress());
    }
}