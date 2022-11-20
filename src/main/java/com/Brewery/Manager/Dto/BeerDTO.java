package com.brewery.manager.Dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class BeerDTO {
    private Long id_beer;
    private String Name;
    private String Alcohol;
    private double Price;
    @JsonProperty(access = Access.WRITE_ONLY)
    private Long id_brewerie;
    
}
