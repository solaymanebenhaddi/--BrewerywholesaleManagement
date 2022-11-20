package com.brewery.manager.Dto;

import lombok.Data;

@Data
public class QuoteBeer {

    private Long id_dev;

    private Long id_beer;

    private long id_warehouse;
    
    private long id_wholesale;

    private long quantity;
    
}
