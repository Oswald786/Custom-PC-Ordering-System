package com.v1.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecieptModelTest {

    @Test
    void testConstructorSetsAllFieldsCorrectly() {
        RecieptModel model = new RecieptModel(1000.0, 200.0, 300.0, 1500.0);

        assertEquals(1000.0, model.getSubtotal());
        assertEquals(200.0, model.getVatDue());
        assertEquals(300.0, model.getTaxDue());
        assertEquals(1500.0, model.getGrandtotalDue());
    }

    @Test
    void testSettersAndGettersIndividually() {
        RecieptModel model = new RecieptModel(0, 0, 0, 0);

        model.setSubtotal(500.0);
        model.setVatDue(100.0);
        model.setTaxDue(150.0);
        model.setGrandtotalDue(750.0);

        assertEquals(500.0, model.getSubtotal());
        assertEquals(100.0, model.getVatDue());
        assertEquals(150.0, model.getTaxDue());
        assertEquals(750.0, model.getGrandtotalDue());
    }
}