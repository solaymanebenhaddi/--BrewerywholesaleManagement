package com.brewery.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.manager.Dto.BeerInwhDTO;
import com.brewery.manager.Dto.WareHouseDTO;
import com.brewery.manager.Dto.WholeSalerDTO;
import com.brewery.manager.payload.request.BeerinwhRequest;
import com.brewery.manager.payload.request.WarehouseRequest;
import com.brewery.manager.payload.request.WholesalerRequest;
import com.brewery.manager.services.BeerInWareHouseServices;
import com.brewery.manager.services.WareHouseServices;
import com.brewery.manager.services.wholesalerImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/wholesaler")
public class WholeSalerController {

    @Autowired
    private wholesalerImpl wholeservices;

    @Autowired
    private WareHouseServices wareHouseServices;

    @Autowired
    private BeerInWareHouseServices beerInWareHouseServices;
    
    
    @PostMapping("/addwarehouse")
    public WareHouseDTO addwarehouse(@RequestBody WarehouseRequest WholeSaler) throws Exception{
        WareHouseDTO warehouse=wareHouseServices.create(WholeSaler);
        return warehouse;
   
    }

   
    @PostMapping("/addwholesaler")
    public WholeSalerDTO addbrewerie(@RequestBody WholesalerRequest WholeSaler) throws Exception{
        WholeSalerDTO saler=wholeservices.create(WholeSaler);
        return saler;
   
    }

    @PostMapping("/addStock")
    public BeerInwhDTO AddStock(@RequestBody BeerinwhRequest beerinwhRequest) throws Exception{
        BeerInwhDTO stock=beerInWareHouseServices.create(beerinwhRequest);
        return stock;
   
    }

    @PostMapping("/updatestock")
    public BeerInwhDTO UpdateStock(@RequestBody BeerinwhRequest beerinwhRequest) throws Exception{
        BeerInwhDTO stock=beerInWareHouseServices.update(beerinwhRequest);
        return stock;
   
    }
    
}
