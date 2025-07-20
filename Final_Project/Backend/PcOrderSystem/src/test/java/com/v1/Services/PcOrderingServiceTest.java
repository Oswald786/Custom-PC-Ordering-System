package com.v1.Services;

import com.v1.Model.CustomerProfileModel;
import com.v1.Model.OrderRequestProccessedModel;
import com.v1.Model.OrderResponseModel;
import com.v1.Model.PcBuildModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PcOrderingServiceTest {
    PcOrderingService testservice;

    @BeforeEach
    void setUp() {
        PcBuildModel mockBuild = new PcBuildModel(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8"
        );
        CustomerProfileModel mockCustomer = new CustomerProfileModel(
                "Ethan Slade",
                "ethan.slade@example.com",
                "07700123456",
                "123 Fake Street, London, UK"
        );
        OrderRequestProccessedModel mockProccessedOrder = new OrderRequestProccessedModel(mockBuild,mockCustomer);
        this.testservice = new PcOrderingService(mockProccessedOrder);
    }

    @Test
    @DisplayName("Builds the Service correctly with valid Pc Build values")
    void buildsPcCorrectly() {
        assertEquals(1, testservice.builtPc.getCpu().getPartId());
        assertEquals(2, testservice.builtPc.getMotherboard().getPartId());
        assertEquals(3, testservice.builtPc.getGpu().getPartId());
        assertEquals(4, testservice.builtPc.getRam().getPartId());
        assertEquals(5, testservice.builtPc.getStorage().getPartId());
        assertEquals(6, testservice.builtPc.getPsu().getPartId());
        assertEquals(7, testservice.builtPc.getCaseUnit().getPartId());
        assertEquals(8, testservice.builtPc.getCooler().getPartId());
    }

    @Test
    @DisplayName("Generates a customer correctly as well")
    void customerGeneratedCorrectly(){
        assertNotNull(testservice.customerProfile); // Ensure it's not null

        assertEquals("Ethan Slade", testservice.customerProfile.getName());
        assertEquals("ethan.slade@example.com", testservice.customerProfile.getEmail());
        assertEquals("07700123456", testservice.customerProfile.getPhoneNumber());
        assertEquals("123 Fake Street, London, UK", testservice.customerProfile.getShippingAddress());
    }
    @Test
    @DisplayName("Generates random order number successfully")
    void generateOrderRecieptNumberForDatabase() {
        Set<Integer> collectedNumbers = new HashSet<>();
        for (int i = 0; i < 40; i++){
           collectedNumbers.add(testservice.GenerateOrderRecieptNumberForDatabase());
        }
        Assertions.assertEquals(40,collectedNumbers.size());

    }

    @Test
    void generateOrder() {
        OrderResponseModel OrderResponseModel = testservice.GenerateOrder();
        Assertions.assertNotNull(OrderResponseModel);
    }

    @Test
    void logOrderDetails() {
    }

}