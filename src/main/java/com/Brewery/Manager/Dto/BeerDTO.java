package com.brewery.manager.Dto;

import lombok.Data;

@Data
public class BeerDTO {

    private String Name;
    private String Alcohol;
    private double Price;
    private Long brewerie_id;
    
}