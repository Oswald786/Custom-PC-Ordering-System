package com.v1.Model;

import com.v1.Services.PcConfigurationService;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class OrderRequestProccessedModel {
    private BuiltPcModel pcBuild;
    private CustomerProfileModel customer;
    private RecieptModel receipt;
    private int OrderNumber;

    public OrderRequestProccessedModel(PcBuildModel rawBuild, CustomerProfileModel customer) {
        PcConfigurationService configurator = new PcConfigurationService();
        rawBuild.logSelectedIds();
        configurator.RetriveCurrentConfiguration(rawBuild);
        this.pcBuild = configurator.buildPcFromConfiguration();

        this.customer = customer;
        this.receipt = configurator.calculateCurrentConfigurationCost();
    }

    public BuiltPcModel getPcBuild() {
        return this.pcBuild;
    }

    public void setPcBuild(BuiltPcModel pcBuild) {
        this.pcBuild = pcBuild;
    }

    public CustomerProfileModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfileModel customer) {
        this.customer = customer;
    }

    public RecieptModel getReceipt() {
        return receipt;
    }

    public void setReceipt(RecieptModel receipt) {
        this.receipt = receipt;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        OrderNumber = orderNumber;
    }
}

