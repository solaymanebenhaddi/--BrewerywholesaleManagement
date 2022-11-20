package com.brewery.manager.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BrewerieSalesDTO {

    private Long id_beer;
    private Long id_wholesale;
    private Long quantity;
    private LocalDate dateofsale;
    
}
