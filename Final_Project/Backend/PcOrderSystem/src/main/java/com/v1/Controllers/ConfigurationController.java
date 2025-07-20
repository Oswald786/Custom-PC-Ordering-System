package com.v1.Controllers;

import com.v1.Model.CategoryRequest;
import com.v1.Model.PcBuildModel;
import com.v1.Model.PcComponentModel;
import com.v1.Model.RecieptModel;
import com.v1.Services.PcConfigurationService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import java.util.ArrayList;

@Controller("/v1ConfigurationController")
public class ConfigurationController {

    @Post("/retriveParts")
    ArrayList<PcComponentModel> RetriveParts(@Body CategoryRequest request){
        PcConfigurationService dropDownDataRetrieved = new PcConfigurationService();
        System.out.println(request.getCategory());
        return dropDownDataRetrieved.returnDropdownOptionsAsList(request.getCategory());
    }

    @Post("/ReturnCost")
    RecieptModel RetriveCost(@Body PcBuildModel buildIdNumbers){
        PcConfigurationService dropDownDataRetrieved = new PcConfigurationService();
        dropDownDataRetrieved.RetriveCurrentConfiguration(buildIdNumbers);
        return dropDownDataRetrieved.calculateCurrentConfigurationCost();
    }
}
