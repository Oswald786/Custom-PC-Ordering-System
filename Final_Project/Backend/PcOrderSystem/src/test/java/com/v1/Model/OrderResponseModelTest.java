package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseModelTest {

    @Test
    @DisplayName("Constructor sets order number correctly in OrderResponseModel")
    void testConstructorInitializesCorrectly() {
        OrderResponseModel response = new OrderResponseModel(12345);
        assertEquals(12345, response.getOrderNumber());
    }

    @Test
    @DisplayName("Getter returns correct order number from OrderResponseModel")
    void testGetOrderNumber() {
        OrderResponseModel response = new OrderResponseModel(67890);
        int result = response.getOrderNumber();
        assertEquals(67890, result);
    }
}