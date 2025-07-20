package com.v1.Controllers;

import com.v1.Model.OrderRequestProccessedModel;
import com.v1.Model.OrderRequestRawModel;
import com.v1.Model.OrderResponseModel;
import com.v1.Services.PcOrderingService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
@Controller("/v1OrderingController")
public class PcOrderingController {

    @Post("/ReturnOrderNumber")
    OrderResponseModel RetriveCost(@Body OrderRequestRawModel orderDetailsRaw){
        try {
            OrderRequestProccessedModel proccessedOrder = new OrderRequestProccessedModel(orderDetailsRaw.getRawBuild(), orderDetailsRaw.getCustomer());
            System.out.println("Completed creation of processed order");
            PcOrderingService orderService = new PcOrderingService(proccessedOrder);
            System.out.println("Raw Build: " + proccessedOrder.getPcBuild());
            System.out.println("Raw Build: " + proccessedOrder.getCustomer());
            OrderResponseModel generatedResponse = orderService.GenerateOrder();
            return generatedResponse;
        }
        catch (Exception e){
            System.out.println("Exception creating processed order");
            e.printStackTrace();
            throw e;
        }
    }
}
