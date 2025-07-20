package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CategoryResponseModelTest {

    @Test
    @DisplayName("Getters and setters for CategoryResponseModel return correct part list")
    void testGetAndSetCategoryPartsList() {
        // Arrange
        ArrayList<PcComponentModel> partsList = new ArrayList<>();
        PcComponentModel part1 = new PcComponentModel(1, "RTX 4080", "GPU", 1200);
        PcComponentModel part2 = new PcComponentModel(2, "RX 7900 XTX", "GPU", 999);
        partsList.add(part1);
        partsList.add(part2);

        CategoryResponseModel model = new CategoryResponseModel();

        // Act
        model.setCategory(partsList);

        // Assert
        ArrayList<PcComponentModel> returnedList = model.getCategory();
        assertNotNull(returnedList);
        assertEquals(2, returnedList.size());
        assertEquals("RTX 4080", returnedList.get(0).getPartName());
        assertEquals("RX 7900 XTX", returnedList.get(1).getPartName());
        assertEquals("GPU", returnedList.get(0).getPartType());
        assertEquals(1200, returnedList.get(0).getPartPrice());
        assertEquals(999, returnedList.get(1).getPartPrice());
    }
}