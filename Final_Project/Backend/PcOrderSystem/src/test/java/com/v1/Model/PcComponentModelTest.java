package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PcComponentModelTest {

    @Test
    @DisplayName("Constructor correctly sets all PcComponentModel fields")
    void testConstructorInitializesCorrectly() {
        PcComponentModel component = new PcComponentModel(101, "Corsair Vengeance 32GB", "RAM", 120);

        assertEquals(101, component.getPartId());
        assertEquals("Corsair Vengeance 32GB", component.getPartName());
        assertEquals("RAM", component.getPartType());
        assertEquals(120, component.getPartPrice());
    }

    @Test
    @DisplayName("Getters and setters correctly assign and return PcComponentModel values")
    void testGettersAndSetters() {
        PcComponentModel component = new PcComponentModel();

        component.setPartId(202);
        component.setPartName("Samsung 980 Pro 2TB");
        component.setPartType("Storage");
        component.setPartPrice(180);

        assertEquals(202, component.getPartId());
        assertEquals("Samsung 980 Pro 2TB", component.getPartName());
        assertEquals("Storage", component.getPartType());
        assertEquals(180, component.getPartPrice());
    }
}