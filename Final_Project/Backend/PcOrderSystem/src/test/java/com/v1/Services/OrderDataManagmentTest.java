package com.v1.Services;

import com.v1.Model.BuiltPcModel;
import com.v1.Model.CustomerProfileModel;
import com.v1.Model.PcComponentModel;
import com.v1.Model.RecieptModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class OrderDataManagmentTest {

    private RecieptModel mockReceipt;
    private BuiltPcModel mockPc;
    private CustomerProfileModel mockCustomer;
    private OrderDataManagment service;
    private final int mockOrderNumber = 999;

    @BeforeEach
    public void setUp() {
        mockReceipt = new RecieptModel(1000.0, 200.0, 300.0, 1500.0);
        mockPc = new BuiltPcModel();
        mockPc.setCpu(new PcComponentModel(1, "CPU", "Mock CPU", 300));
        mockPc.setMotherboard(new PcComponentModel(2, "Motherboard", "Mock Motherboard", 200));
        mockPc.setGpu(new PcComponentModel(3, "GPU", "Mock GPU", 400));
        mockPc.setRam(new PcComponentModel(4, "RAM", "Mock RAM", 100));
        mockPc.setStorage(new PcComponentModel(5, "Storage", "Mock Storage", 150));
        mockPc.setPsu(new PcComponentModel(6, "PSU", "Mock PSU", 90));
        mockPc.setCaseUnit(new PcComponentModel(7, "Case", "Mock Case", 70));
        mockPc.setCooler(new PcComponentModel(8, "Cooling", "Mock Cooler", 50));

        mockCustomer = new CustomerProfileModel("Ethan Slade", "ethan@example.com", "07000000000", "123 Test St");

        service = new OrderDataManagment();
    }

    @AfterEach
    public void tearDown() {
        File file = new File("./ConfirmedOrders/order-" + mockOrderNumber + ".txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testThrowsWhenReceiptIsNull() {
        try {
            service.createOrder(null, mockPc, mockCustomer, mockOrderNumber);
            fail("Expected NullPointerException for null receipt");
        } catch (Exception e) {
            assertEquals("Finalised order receipt is null.", e.getMessage());
        }
    }

    @Test
    public void testThrowsWhenPcBuildIsNull() {
        try {
            service.createOrder(mockReceipt, null, mockCustomer, mockOrderNumber);
            fail("Expected NullPointerException for null PC build");
        } catch (Exception e) {
            assertEquals("PC to build is null.", e.getMessage());
        }
    }

    @Test
    public void testThrowsWhenCustomerIsNull() {
        try {
            service.createOrder(mockReceipt, mockPc, null, mockOrderNumber);
            fail("Expected NullPointerException for null customer");
        } catch (Exception e) {
            assertEquals("Customer profile is null.", e.getMessage());
        }
    }

    @Test
    public void testThrowsWhenOrderNumberIsNegative() {
        try {
            service.createOrder(mockReceipt, mockPc, mockCustomer, -1);
            fail("Expected NullPointerException for negative order number");
        } catch (Exception e) {
            assertEquals("Order number must be greater than 0.", e.getMessage());
        }
    }

    @Test
    public void testCreatesFileSuccessfully() {
        service.createOrder(mockReceipt, mockPc, mockCustomer, mockOrderNumber);
        File file = new File("./ConfirmedOrders/order-" + mockOrderNumber + ".txt");
        assertTrue(file.exists());
    }
}