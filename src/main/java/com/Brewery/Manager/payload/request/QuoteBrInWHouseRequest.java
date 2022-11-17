package com.brewery.manager.payload.request;

import lombok.Data;

@Data
public class QuoteBrInWHouseRequest {


    
    private Long id_dev;

    private Long id_beer;

    private long id_warehouse;
    
    private long id_wholesale;

    private long quantity;

}
