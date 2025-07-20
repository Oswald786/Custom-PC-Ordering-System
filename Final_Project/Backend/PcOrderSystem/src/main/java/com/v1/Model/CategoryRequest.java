package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class CategoryRequest {
        private String category;

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

}
