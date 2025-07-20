package com.v1.Services;

import com.v1.Model.PcComponentModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComponentDataManagmentTest {

    ComponentDataManagment MockData = new ComponentDataManagment();


    @Test
    @DisplayName("Builds components into list and checks there is no malformed entries")
    void testComponentParsingWithMalformedLines() {
        MockData.filepath = "MockComponentListTesting.txt";
        ArrayList<PcComponentModel> parts = MockData.RetriveParts();

        // Assert correct number of valid parts parsed
        assertEquals(50, parts.size());

        // Optional: validate first entry
        PcComponentModel part1 = parts.get(0);
        assertEquals(01, part1.getPartId());
        assertEquals("AMD Ryzen 9 7950X", part1.getPartName());
        assertEquals("CPU", part1.getPartType());
        assertEquals(640, part1.getPartPrice());

        // Optional: check no malformed entries snuck in
        for (PcComponentModel part : parts) {
            assertNotNull(part.getPartName());
            assertNotNull(part.getPartType());
            assertTrue(part.getPartPrice() > 0);
        }
    }
}