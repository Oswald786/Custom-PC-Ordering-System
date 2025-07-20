package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestRawModelTest {

    @Test
    @DisplayName("OrderRequestRawModel stores and returns all fields correctly")
    void testAllFieldsSetAndRetrievedCorrectly() {

        PcBuildModel mockBuild = new PcBuildModel(
                "1", "2", "3", "4", "5", "6", "7", "8"
        );

        CustomerProfileModel mockCustomer = new CustomerProfileModel(
                "Ethan Slade",
                "ethan.slade@example.com",
                "07700123456",
                "123 Fake Street, London, UK"
        );

        OrderRequestRawModel request = new OrderRequestRawModel();
        request.setRawBuild(mockBuild);
        request.setCustomer(mockCustomer);


        assertEquals("1", request.getRawBuild().getCpuId());
        assertEquals("2", request.getRawBuild().getMotherboardId());
        assertEquals("3", request.getRawBuild().getGpuId());
        assertEquals("4", request.getRawBuild().getRamId());
        assertEquals("5", request.getRawBuild().getStorageId());
        assertEquals("6", request.getRawBuild().getPsuId());
        assertEquals("7", request.getRawBuild().getCaseId());
        assertEquals("8", request.getRawBuild().getCoolerId());


        assertEquals("Ethan Slade", request.getCustomer().getName());
        assertEquals("ethan.slade@example.com", request.getCustomer().getEmail());
        assertEquals("07700123456", request.getCustomer().getPhoneNumber());
        assertEquals("123 Fake Street, London, UK", request.getCustomer().getShippingAddress());
    }
}