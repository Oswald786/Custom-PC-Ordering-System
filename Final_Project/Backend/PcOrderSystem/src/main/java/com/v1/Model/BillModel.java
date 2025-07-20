package com.v1.Model;

public class BillModel {
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getVatRate() {
        return vatRate;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getGrandTotalBill() {
        return grandTotalBill;
    }

    public void setGrandTotalBill(double grandTotalBill) {
        this.grandTotalBill = grandTotalBill;
    }

    double subTotal;
    double vatRate;
    double taxRate;
    double grandTotalBill;

    public BillModel(double subTotal,double vatRate,double taxRate) {
     this.subTotal = subTotal;
     this.vatRate = vatRate;
     this.taxRate = taxRate;
    }
}
