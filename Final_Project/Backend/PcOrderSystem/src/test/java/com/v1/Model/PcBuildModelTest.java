package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PcBuildModelTest {

    @Test
    @DisplayName("Constructor correctly sets all fields in PcBuildModel")
    void testConstructorInitializesCorrectly() {
        PcBuildModel build = new PcBuildModel(
                "1", "2", "3", "4", "5", "6", "7", "8"
        );

        assertEquals("1", build.getCpuId());
        assertEquals("2", build.getMotherboardId());
        assertEquals("3", build.getGpuId());
        assertEquals("4", build.getRamId());
        assertEquals("5", build.getStorageId());
        assertEquals("6", build.getPsuId());
        assertEquals("7", build.getCaseId());
        assertEquals("8", build.getCoolerId());
    }

    @Test
    @DisplayName("Getters and setters correctly assign and return PcBuildModel values")
    void testGettersAndSetters() {
        PcBuildModel build = new PcBuildModel();

        build.setCpuId("11");
        build.setMotherboardId("12");
        build.setGpuId("13");
        build.setRamId("14");
        build.setStorageId("15");
        build.setPsuId("16");
        build.setCaseId("17");
        build.setCoolerId("18");

        assertEquals("11", build.getCpuId());
        assertEquals("12", build.getMotherboardId());
        assertEquals("13", build.getGpuId());
        assertEquals("14", build.getRamId());
        assertEquals("15", build.getStorageId());
        assertEquals("16", build.getPsuId());
        assertEquals("17", build.getCaseId());
        assertEquals("18", build.getCoolerId());
    }
}