package com.brewery.manager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "wholesaler")
@Data
public class Wholesaler {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_wholesale;
    private String Name;
    private String Adresse;

    

    
}
