package com.v1.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryRequestTest {

    @Test
    @DisplayName("Getter and setter for CategoryRequest should return expected category value")
    void testGetAndSetCategory() {
        // Arrange
        CategoryRequest request = new CategoryRequest();

        // Act
        request.setCategory("GPU");

        // Assert
        assertEquals("GPU", request.getCategory());
    }
}