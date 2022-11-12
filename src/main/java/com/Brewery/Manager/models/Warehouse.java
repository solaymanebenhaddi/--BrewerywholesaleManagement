package com.brewery.manager.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "warehouse")
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_warehouse;
    private String Adresse;

    @OneToOne
    private Wholesaler wholesaler;

    
}
