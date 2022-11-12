package com.brewery.manager.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BrewerieSalesDTO {

    private long id_beer;
    private long id_wholesale;
    private Long quantity;
    private LocalDate dateofsale;
    
}
