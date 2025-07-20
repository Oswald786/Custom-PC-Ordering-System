package com.v1.Model;

import java.util.ArrayList;
public interface ComponentDataBlueprint {
        ArrayList<PcComponentModel> RetriveParts();
        PcComponentModel getComponentById(int id);
}


