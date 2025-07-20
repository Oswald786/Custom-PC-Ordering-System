package com.v1.Model;

public interface OrderDataBlueprint {
    public void createOrder(RecieptModel finalisedOrderReciept, BuiltPcModel PcToBuild, CustomerProfileModel Customer,int OrderNumber);
}
