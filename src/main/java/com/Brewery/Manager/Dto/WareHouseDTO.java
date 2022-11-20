package com.brewery.manager.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class WareHouseDTO {

    private Long id_warehouse;
    private String Adresse;
    @JsonProperty(access = Access.WRITE_ONLY)
    private WholeSalerDTO wholesaler;
}
