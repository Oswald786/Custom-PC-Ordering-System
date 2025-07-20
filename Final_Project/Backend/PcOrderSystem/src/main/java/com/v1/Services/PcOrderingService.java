package com.v1.Services;

import com.v1.Model.*;

import java.util.Random;

public class PcOrderingService {

    OrderDataBlueprint DatabaseConnectionOrdersList;
    RecieptModel orderReceipt;
    BuiltPcModel builtPc;
    CustomerProfileModel customerProfile;
    int OrderNumber;
    int RandomNumber = 0;
    OrderDataBlueprint DatabaseConnectionOrders = new OrderDataManagment();
    // The provided OrderRequestProccessedModel contains all necessary data for order creation
    // (built PC, customer profile, and receipt). The order number is the only value generated
    // within this class to complete the order.
    public PcOrderingService(OrderRequestProccessedModel orderToAddToDatabase) {
        this.DatabaseConnectionOrdersList = new OrderDataManagment();
        this.orderReceipt = orderToAddToDatabase.getReceipt(); // Already passed in
        this.builtPc = orderToAddToDatabase.getPcBuild();
        this.customerProfile = orderToAddToDatabase.getCustomer();
        this.OrderNumber = GenerateOrderRecieptNumberForDatabase();
    }
    // Uses the Random class to generate a unique order number within defined min/max bounds.
    // Thoroughly tested to avoid duplicates. Can be enhanced in the future for more robust uniqueness.
    public int GenerateOrderRecieptNumberForDatabase(){
        Random r = new Random();
        int max=10000,min=50;
        this.RandomNumber = r.nextInt(max - min + 1) + min;
        return this.RandomNumber;
    }

    // Generates an OrderResponseModel containing the unique order number to return to the customer.
    // Delegates full order processing and upload to persistent storage via the database connection service.
    public OrderResponseModel GenerateOrder(){
        DatabaseConnectionOrders.createOrder(this.orderReceipt,this.builtPc,this.customerProfile,this.OrderNumber);
        OrderResponseModel orderNumberResponse = new OrderResponseModel(this.OrderNumber);
        logOrderDetails();
        return  orderNumberResponse;
    }

    //Logs a full breakdown of the current order details to the console.
    //Includes receipt totals, detailed PC component information, customer data,
    //and order metadata for verification and debugging.
    public void logOrderDetails() {
        System.out.println("========== 🧾 RECEIPT DETAILS ==========");
        System.out.println("Subtotal: £" + orderReceipt.getSubtotal());
        System.out.println("VAT Due: £" + orderReceipt.getVatDue());
        System.out.println("Tax Due: £" + orderReceipt.getTaxDue());
        System.out.println("Grand Total: £" + orderReceipt.getGrandtotalDue());

        System.out.println("\n========== 🖥️ PC COMPONENTS ==========");
        System.out.println("CPU: " + builtPc.getCpu().getPartName() + " (£" + builtPc.getCpu().getPartPrice() + ")");
        System.out.println("Motherboard: " + builtPc.getMotherboard().getPartName() + " (£" + builtPc.getMotherboard().getPartPrice() + ")");
        System.out.println("GPU: " + builtPc.getGpu().getPartName() + " (£" + builtPc.getGpu().getPartPrice() + ")");
        System.out.println("RAM: " + builtPc.getRam().getPartName() + " (£" + builtPc.getRam().getPartPrice() + ")");
        System.out.println("Storage: " + builtPc.getStorage().getPartName() + " (£" + builtPc.getStorage().getPartPrice() + ")");
        System.out.println("PSU: " + builtPc.getPsu().getPartName() + " (£" + builtPc.getPsu().getPartPrice() + ")");
        System.out.println("Case: " + builtPc.getCaseUnit().getPartName() + " (£" + builtPc.getCaseUnit().getPartPrice() + ")");
        System.out.println("Cooler: " + builtPc.getCooler().getPartName() + " (£" + builtPc.getCooler().getPartPrice() + ")");

        System.out.println("\n========== 👤 CUSTOMER DETAILS ==========");
        System.out.println("Name: " + customerProfile.getName());
        System.out.println("Email: " + customerProfile.getEmail());
        System.out.println("Phone: " + customerProfile.getPhoneNumber());
        System.out.println("Shipping Address: " + customerProfile.getShippingAddress());

        System.out.println("\n========== 📦 ORDER META ==========");
        System.out.println("Order Number: " + OrderNumber);
    }


}
