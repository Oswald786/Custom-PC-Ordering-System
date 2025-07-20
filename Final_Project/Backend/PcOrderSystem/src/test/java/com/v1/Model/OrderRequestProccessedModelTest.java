package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderRequestProccessedModelTest {

    @Test
    @DisplayName("OrderRequestProccessedModel constructs all fields properly from raw input")
    void testProcessedModelBuildsSuccessfully() {
        PcBuildModel mockBuild = new PcBuildModel(
                "1", "2", "3", "4", "5", "6", "7", "8"
        );

        CustomerProfileModel mockCustomer = new CustomerProfileModel(
                "Ethan Slade",
                "ethan.slade@example.com",
                "07700123456",
                "123 Fake Street, London, UK"
        );

        OrderRequestProccessedModel processedOrder = new OrderRequestProccessedModel(mockBuild, mockCustomer);

        assertNotNull(processedOrder.getPcBuild());
        assertNotNull(processedOrder.getPcBuild().getCpu());
        assertNotNull(processedOrder.getPcBuild().getGpu());
        assertNotNull(processedOrder.getPcBuild().getRam());
        assertNotNull(processedOrder.getPcBuild().getStorage());
        assertNotNull(processedOrder.getPcBuild().getMotherboard());
        assertNotNull(processedOrder.getPcBuild().getPsu());
        assertNotNull(processedOrder.getPcBuild().getCaseUnit());
        assertNotNull(processedOrder.getPcBuild().getCooler());

        assertEquals("Ethan Slade", processedOrder.getCustomer().getName());
        assertEquals("ethan.slade@example.com", processedOrder.getCustomer().getEmail());
        assertEquals("07700123456", processedOrder.getCustomer().getPhoneNumber());
        assertEquals("123 Fake Street, London, UK", processedOrder.getCustomer().getShippingAddress());

        assertNotNull(processedOrder.getReceipt());
        assertTrue(processedOrder.getReceipt().getSubtotal() > 0);
        assertTrue(processedOrder.getReceipt().getGrandtotalDue() > 0);
    }
}