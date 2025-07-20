package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillModelTest {

    @Test
    @DisplayName("Constructor assigns initial values correctly")
    void testConstructor() {
        BillModel bill = new BillModel(100.0, 0.2, 0.15);

        assertEquals(100.0, bill.getSubTotal());
        assertEquals(0.2, bill.getVatRate());
        assertEquals(0.15, bill.getTaxRate());
    }

    @Test
    @DisplayName("Getters and setters work for all BillModel fields")
    void testGettersAndSetters() {
        BillModel bill = new BillModel(0, 0, 0);

        bill.setSubTotal(150.0);
        bill.setVatRate(0.18);
        bill.setTaxRate(0.12);
        bill.setGrandTotalBill(200.0);

        assertEquals(150.0, bill.getSubTotal());
        assertEquals(0.18, bill.getVatRate());
        assertEquals(0.12, bill.getTaxRate());
        assertEquals(200.0, bill.getGrandTotalBill());
    }
}