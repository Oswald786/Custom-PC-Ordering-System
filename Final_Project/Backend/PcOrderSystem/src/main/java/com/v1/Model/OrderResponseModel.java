package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class OrderResponseModel {
    private int orderNumber;

    public OrderResponseModel(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
