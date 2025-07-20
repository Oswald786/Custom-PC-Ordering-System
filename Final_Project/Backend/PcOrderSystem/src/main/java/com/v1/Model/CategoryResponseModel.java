package com.v1.Model;

import java.util.ArrayList;

public class CategoryResponseModel {
    private ArrayList<PcComponentModel> PartsForCatagory;

    public ArrayList<PcComponentModel> getCategory() {
        return PartsForCatagory;
    }

    public void setCategory(ArrayList<PcComponentModel> PartsForCatagory) {
        this.PartsForCatagory = PartsForCatagory;
    }
}
