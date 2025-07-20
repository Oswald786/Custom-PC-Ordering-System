package com.v1.Services;

import com.v1.Model.BillModel;
import com.v1.Model.RecieptModel;

public class BillService {
    BillModel bill;

    public BillService(double orderSubtotal){
        this.bill = new BillModel(orderSubtotal,0.05,0.15);
    }


    public double calculateVAT() {
        return bill.getSubTotal() * bill.getVatRate();
    }

    public double calculateTax() {
        return bill.getSubTotal() * bill.getTaxRate();
    }

    public double calculateGrandTotal() {
        return bill.getSubTotal() + calculateVAT() + calculateTax();
    }

    public RecieptModel createReciept(){
        return new RecieptModel(bill.getSubTotal(),calculateVAT(),calculateTax(),calculateGrandTotal());
    }



}
