package com.v1.Services;

import com.v1.Model.*;

import java.util.ArrayList;

public class PcConfigurationService {
    ComponentDataBlueprint DatabaseConnection;
    BillService bill;
    private PcComponentModel cpu;
    private PcComponentModel motherboard;
    private PcComponentModel gpu;
    private PcComponentModel ram;
    private PcComponentModel storage;
    private PcComponentModel psu;
    private PcComponentModel caseUnit;
    private PcComponentModel cooler;

    public PcConfigurationService() {
        this.DatabaseConnection = new ComponentDataManagment();
    }

    //Section returns all dropdown options for the part category requested. Returns as array list for use elsewhere.
    public ArrayList<PcComponentModel> returnDropdownOptionsAsList(String partCatgorySought){
        //Creates an empty list of parts to fill it with parts matching category desired
        ArrayList<PcComponentModel> PartsMatchingDesiredCatagory = new ArrayList<>();
       for(PcComponentModel part : DatabaseConnection.RetriveParts()){
           //Used to check for match
           if (part.getPartType().strip().equalsIgnoreCase(partCatgorySought.strip())){
               PartsMatchingDesiredCatagory.add(part);
               System.out.print("Part added to list Id: " + part.getPartId() + " Part Name: " + part.getPartName()); //When part matches It's added to empty list and recorded in log
           }
           //Logs any parts that don't match category
           else{
               System.out.print("Part Category doesn't match category:" + partCatgorySought + "\n Id: " + part.getPartId() + " \nPart Name: " + part.getPartName() + "\n");
           }
       }
       if (PartsMatchingDesiredCatagory.isEmpty()){
           System.out.println("No part found returning null"); //if there is no apart matching criteria alert is made.
       }
        return PartsMatchingDesiredCatagory;
    }
    // This function returns the PC build by using part IDs.
    // The ComponentDatabaseBlueprint uses these IDs to retrieve the corresponding parts.
    public void RetriveCurrentConfiguration(PcBuildModel chosenModel){
        this.cpu = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getCpuId()));
        this.motherboard = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getMotherboardId()));
        this.gpu = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getGpuId()));
        this.ram = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getRamId()));
        this.storage = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getStorageId()));
        this.psu = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getPsuId()));
        this.caseUnit = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getCaseId()));
        this.cooler = DatabaseConnection.getComponentById(Integer.parseInt(chosenModel.getCoolerId()));
        logCurrentPcConfiguration();
    }
    // This function retrieves part prices from the current configuration and creates a BillService instance.
    // The BillService then generates a receipt containing subtotal, grand total, VAT, and tax values for use by the user and other classes.
    public RecieptModel calculateCurrentConfigurationCost(){
       double subtotal = cpu.getPartPrice()
                + motherboard.getPartPrice()
                + gpu.getPartPrice()
                + ram.getPartPrice()
                + storage.getPartPrice()
                + psu.getPartPrice()
                + caseUnit.getPartPrice()
                + cooler.getPartPrice();
       bill = new BillService(subtotal);
       return bill.createReciept();
    };
    // Logs the full PC configuration, including selected parts and their prices, to verify correct operation and assist with testing.
    public void logCurrentPcConfiguration() {
        System.out.println("🧩 PC Configuration Built:");
        System.out.println("CPU: " + cpu.getPartName() + " (£" + cpu.getPartPrice() + ")");
        System.out.println("Motherboard: " + motherboard.getPartName() + " (£" + motherboard.getPartPrice() + ")");
        System.out.println("GPU: " + gpu.getPartName() + " (£" + gpu.getPartPrice() + ")");
        System.out.println("RAM: " + ram.getPartName() + " (£" + ram.getPartPrice() + ")");
        System.out.println("Storage: " + storage.getPartName() + " (£" + storage.getPartPrice() + ")");
        System.out.println("PSU: " + psu.getPartName() + " (£" + psu.getPartPrice() + ")");
        System.out.println("Case: " + caseUnit.getPartName() + " (£" + caseUnit.getPartPrice() + ")");
        System.out.println("Cooler: " + cooler.getPartName() + " (£" + cooler.getPartPrice() + ")");
    }



    // Constructs the actual PC model using fully populated component objects.
    // At this point, the original part IDs are no longer needed, as full part details (name, type, price)
    // can now be accessed directly from the BuiltPcModel for display, billing, or storage purposes.
    public BuiltPcModel buildPcFromConfiguration() {
        return new BuiltPcModel(
                cpu,
                motherboard,
                gpu,
                ram,
                storage,
                psu,
                caseUnit,
                cooler
        );
    }
}
