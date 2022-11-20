package com.brewery.manager.payload.request;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BrewerieSaleRequest {
    
    private Long id_beer;
    private Long id_wholesale;
    private Long quantity;
    private Long id_warehouse;
    private LocalDate dateofsale;


}
//@JsonProperty(access = Access.WRITE_ONLY)