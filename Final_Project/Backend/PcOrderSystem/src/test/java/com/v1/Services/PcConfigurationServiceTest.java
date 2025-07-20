package com.v1.Services;

import com.v1.Model.PcComponentModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PcConfigurationServiceTest {
    ComponentDataManagment mockData = new ComponentDataManagment();
    PcConfigurationService configSystem = new PcConfigurationService();

    {
        // Inject mock database to avoid using actual MockComponentList.txt
        configSystem.DatabaseConnection = mockData;
        mockData.filepath = "MockComponentListTesting.txt";
    }

    @Test
    @DisplayName("Dropdown returns correct CPU part from mock database")
    void testDropdownReturnsCpuPartCorrectly() {

        ArrayList<PcComponentModel> cpuParts = configSystem.returnDropdownOptionsAsList("CPU");

        assertEquals(6, cpuParts.size());

        PcComponentModel part = cpuParts.get(0);
        assertEquals(1, part.getPartId());
        assertEquals("AMD Ryzen 9 7950X", part.getPartName());
        assertEquals("CPU", part.getPartType());
        assertEquals(640, part.getPartPrice());

    }

    @Test
    @DisplayName("Dropdown filters out broken GPU line and only keeps valid one")
    void testDropdownReturnsValidGpuOnly() {
        ArrayList<PcComponentModel> gpuParts = configSystem.returnDropdownOptionsAsList("GPU");

        assertEquals(6, gpuParts.size());
        PcComponentModel part = gpuParts.get(0);

        assertEquals("NVIDIA RTX 4090", part.getPartName());
        assertEquals("GPU", part.getPartType());
        assertEquals(2000, part.getPartPrice());
    }

    @Test
    @DisplayName("Dropdown handles Storage and returns all valid parts")
    void testDropdownStorageHasTwoParts() {
        ArrayList<PcComponentModel> storageParts = configSystem.returnDropdownOptionsAsList("Storage");

        assertEquals(6, storageParts.size());
        for (PcComponentModel part : storageParts) {
            assertEquals("Storage", part.getPartType());
        }
    }

    @Test
    @DisplayName("Dropdown handles empty or invalid categories")
    void testInvalidDropdownReturnsEmptyList() {
        ArrayList<PcComponentModel> result = configSystem.returnDropdownOptionsAsList("NotARealCategory");

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Dropdown returns empty if no valid matches after cleanup")
    void testDropdownStillReturnsNothingIfBadCategory() {
        ArrayList<PcComponentModel> result = configSystem.returnDropdownOptionsAsList("Trash");

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("All parts returned from dropdown must match requested category")
    void testAllReturnedPartsMatchRequestedCategory() {
        String requestedCategory = "RAM";
        ArrayList<PcComponentModel> result = configSystem.returnDropdownOptionsAsList(requestedCategory);

        for (PcComponentModel part : result) {
            assertEquals(requestedCategory, part.getPartType());
        }
    }
}