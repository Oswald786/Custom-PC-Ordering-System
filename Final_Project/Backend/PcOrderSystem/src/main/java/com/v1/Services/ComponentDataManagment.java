package com.v1.Services;

import com.v1.Model.ComponentDataBlueprint;
import com.v1.Model.PcComponentModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//Uses interface to easily be swapped with oracled database class when possible
public class ComponentDataManagment implements ComponentDataBlueprint {
    //Uses the mock txt file containing the components for program
    public ComponentDataManagment() {
        this.filepath = "MockComponentList.txt";
        this.BuildPartsFromDatabase();
    }

    public String filepath;

    ArrayList<PcComponentModel> ComponentList = new ArrayList<>();


    //Function to build parts on list
    public void BuildPartsFromDatabase(){
        String line;

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filepath);
            BufferedReader ComponentsFile = new BufferedReader(new InputStreamReader(is));
            while ((line = ComponentsFile.readLine()) != null){
               String[] data = line.split(",");
               try{
                   int id = Integer.parseInt(data[0].trim());
                   String name = data[1].trim();
                   String category = data[2].trim();
                   int price = Integer.parseInt(data[3].trim());

                   PcComponentModel formattedPart = new PcComponentModel(id,name,category,price);
                   ComponentList.add(formattedPart);
               }catch (Exception e){
                System.out.println("error incorrect or malformed line: " + line);
                continue;
               }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<PcComponentModel> RetriveParts(){
        return this.ComponentList;
    }

    public PcComponentModel getComponentById(int id) {
        for (PcComponentModel component : ComponentList) {
            if (component.getPartId() == id) {
                return component;
            }
        }
        return null;
    }
}
