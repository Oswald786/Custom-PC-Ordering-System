package com.v1.Services;

import com.v1.Model.BuiltPcModel;
import com.v1.Model.CustomerProfileModel;
import com.v1.Model.OrderDataBlueprint;
import com.v1.Model.RecieptModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//The class implements the interface for orders again to be changed when appropriate to oracle database
public class OrderDataManagment implements OrderDataBlueprint {

    public void createOrder(RecieptModel finalisedOrderReciept, BuiltPcModel PcToBuild, CustomerProfileModel Customer, int OrderNumber) {
        //Added some check to ensure that no part of order is null.
        try {
            if (finalisedOrderReciept == null) {
                throw new IllegalArgumentException("Finalised order receipt is null.");
            }

            if (PcToBuild == null) {
                throw new IllegalArgumentException("PC to build is null.");
            }

            if (Customer == null) {
                throw new IllegalArgumentException("Customer profile is null.");
            }

            if (OrderNumber < 0) {
                throw new IllegalArgumentException("Order number must be greater than 0.");
            }

            //Provided ther eis no null attributes it will procceed to create file
            else{
                String fileName = "order-" + OrderNumber + ".txt";
                String resourceFolder = "./ConfirmedOrders";
                // Below checks if the file directory exists; if not, it creates it.
                // Interface has no required return as this will not be confirmed until the Oracle database is created.
                File directory = new File(resourceFolder);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File file = new File(directory, fileName);
                //Buffered writer used to generate all details line by line, emojis copied online
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("🧾 RECEIPT DETAILS \n");
                    writer.write("Subtotal: £" + finalisedOrderReciept.getSubtotal() + "\n");
                    writer.write("VAT Due: £" + finalisedOrderReciept.getVatDue() + "\n");
                    writer.write("Tax Due: £" + finalisedOrderReciept.getTaxDue() + "\n");
                    writer.write("Grand Total: £" + finalisedOrderReciept.getGrandtotalDue() + "\n\n");

                    writer.write(" 🖥️ PC COMPONENTS \n");
                    writer.write("CPU: " + PcToBuild.getCpu().getPartName() + " (£" + PcToBuild.getCpu().getPartPrice() + ")\n");
                    writer.write("Motherboard: " + PcToBuild.getMotherboard().getPartName() + " (£" + PcToBuild.getMotherboard().getPartPrice() + ")\n");
                    writer.write("GPU: " + PcToBuild.getGpu().getPartName() + " (£" + PcToBuild.getGpu().getPartPrice() + ")\n");
                    writer.write("RAM: " + PcToBuild.getRam().getPartName() + " (£" + PcToBuild.getRam().getPartPrice() + ")\n");
                    writer.write("Storage: " + PcToBuild.getStorage().getPartName() + " (£" + PcToBuild.getStorage().getPartPrice() + ")\n");
                    writer.write("PSU: " + PcToBuild.getPsu().getPartName() + " (£" + PcToBuild.getPsu().getPartPrice() + ")\n");
                    writer.write("Case: " + PcToBuild.getCaseUnit().getPartName() + " (£" + PcToBuild.getCaseUnit().getPartPrice() + ")\n");
                    writer.write("Cooler: " + PcToBuild.getCooler().getPartName() + " (£" + PcToBuild.getCooler().getPartPrice() + ")\n\n");

                    writer.write(" 👤 CUSTOMER DETAILS \n");
                    writer.write("Name: " + Customer.getName() + "\n");
                    writer.write("Email: " + Customer.getEmail() + "\n");
                    writer.write("Phone: " + Customer.getPhoneNumber() + "\n");
                    writer.write("Shipping Address: " + Customer.getShippingAddress() + "\n\n");

                    writer.write(" 📦 ORDER META \n");
                    writer.write("Order Number: " + OrderNumber + "\n");
                } catch (IOException e) {
                    System.out.println("Failed to write order file: " + e.getMessage());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Order validation failed: " + e.getMessage());
            throw e; // throws Error in case of anything gone wrong or if it's unhappy with any arguments
        }
}}
