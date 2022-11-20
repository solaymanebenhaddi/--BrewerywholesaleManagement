package com.brewery.manager.payload.request;

import lombok.Data;

@Data
public class BeerinwhRequest {
   
    private Long id_beer;

    private Long id_warehouse;

    private Long quantity;
}
