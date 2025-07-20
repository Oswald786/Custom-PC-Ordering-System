package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class OrderRequestRawModel {
    private PcBuildModel rawBuild;
    private CustomerProfileModel customer;
    public PcBuildModel getRawBuild() {
        return rawBuild;
    }

    public void setRawBuild(PcBuildModel rawBuild) {
        this.rawBuild = rawBuild;
    }

    public CustomerProfileModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfileModel customer) {
        this.customer = customer;
    }

    public OrderRequestRawModel() {

    }
}
