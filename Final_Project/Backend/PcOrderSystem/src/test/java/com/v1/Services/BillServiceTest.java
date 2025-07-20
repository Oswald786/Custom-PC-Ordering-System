package com.v1.Services;

import com.v1.Model.BillModel;
import com.v1.Model.RecieptModel;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BillServiceTest {
    BillService fakeBill = new BillService(5000);

    @Test
    @DisplayName("Calculates VAT correctly")
    void calculateVAT() {
        Assertions.assertEquals(250,this.fakeBill.calculateVAT());
    }

    @Test
    @DisplayName("Calculates full tax correctly")
    void calculateTax() {
        Assertions.assertEquals(750,fakeBill.calculateTax());
    }

    @Test
    @DisplayName("Calculates grandtotal correctly")
    void calculateGrandTotal() {
        Assertions.assertEquals(6000,fakeBill.calculateGrandTotal());
    }

    @Test
    @DisplayName("Correctly creates a receipt with correct attributes")
    void createReciept() {
        RecieptModel expectedReciept = new RecieptModel(
                5000.0,
                250.0,
                750.0,
                6000.0
        );
        RecieptModel receiptCreated = fakeBill.createReciept();
        Assertions.assertEquals(expectedReciept.getSubtotal(),receiptCreated.getSubtotal());
        Assertions.assertEquals(expectedReciept.getGrandtotalDue(),receiptCreated.getGrandtotalDue());
        Assertions.assertEquals(expectedReciept.getTaxDue(),receiptCreated.getTaxDue());
        Assertions.assertEquals(expectedReciept.getVatDue(),receiptCreated.getVatDue());
    }
}