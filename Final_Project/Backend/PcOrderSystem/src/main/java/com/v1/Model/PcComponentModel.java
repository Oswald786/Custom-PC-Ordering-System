package com.v1.Model;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class PcComponentModel {
    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public int getPartId() {
        return PartId;
    }

    public void setPartId(int partId) {
        PartId = partId;
    }

    public String getPartType() {
        return PartType;
    }

    public void setPartType(String partType) {

        PartType = partType;
    }

    public int getPartPrice() {
        return PartPrice;
    }

    public void setPartPrice(int partPrice) {
        PartPrice = partPrice;
    }

    String PartName;
    int PartId;
    String PartType;
    int PartPrice;

    public PcComponentModel() {
    }

    public PcComponentModel(int PartId,String PartName, String PartType,int PartPrice) {
        this.PartId = PartId;
        this.PartName = PartName;
        this.PartType = PartType;
        this.PartPrice = PartPrice;
    }
}
