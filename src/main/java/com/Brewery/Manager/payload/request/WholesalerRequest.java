package com.brewery.manager.payload.request;

import lombok.Data;

@Data
public class WholesalerRequest {
    private long id_wholesale;
    private String Name;
    private String Adresse;
}
