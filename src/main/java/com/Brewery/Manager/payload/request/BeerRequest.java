package com.brewery.manager.payload.request;

import lombok.Data;

@Data
public class BeerRequest {
    private Long id_beer;
    private String Name;
    private String Alcohol;
    private double Price;
    private Long id_brewerie;
}
