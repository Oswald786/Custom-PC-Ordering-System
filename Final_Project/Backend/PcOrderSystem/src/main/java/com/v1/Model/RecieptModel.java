package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class RecieptModel {
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getVatDue() {
        return vatDue;
    }

    public void setVatDue(double vatDue) {
        this.vatDue = vatDue;
    }

    public double getTaxDue() {
        return taxDue;
    }

    public void setTaxDue(double taxDue) {
        this.taxDue = taxDue;
    }

    public double getGrandtotalDue() {
        return grandtotalDue;
    }

    public void setGrandtotalDue(double grandtotalDue) {
        this.grandtotalDue = grandtotalDue;
    }

    double subtotal;
    double vatDue;
    double taxDue;
    double grandtotalDue;
    public RecieptModel(double subtotal,double vatDue, double taxDue,double grandtotalDue) {
        this.subtotal = subtotal;
        this.vatDue = vatDue;
        this.taxDue = taxDue;
        this.grandtotalDue = grandtotalDue;
    }
}
