package com.brewery.manager.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Beer_wholesaler")
@Data
public class BrewerieSales {
    @EmbeddedId
    private BeerWholesaleIDs id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_beer")
    @JoinColumn(name = "id_beer", referencedColumnName = "id_beer")
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private Beer beer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_wholesale")
    @JoinColumn(name = "id_wholesale", referencedColumnName = "id_wholesale")
    private Wholesaler wholesaler;


    private Long quantity;
    private double price_transaction;
    private LocalDate dateofsale;

    public BrewerieSales(){
       super(); 
    }

    public BrewerieSales(Beer beer,Wholesaler wholesaler,double price,long quantity){
        super(); 
        this.id =  new BeerWholesaleIDs(beer.getId_beer(),wholesaler.getId_wholesale());
        this.beer=beer;
        this.wholesaler=wholesaler;
        this.price_transaction=price;
        this.quantity=quantity;
     }

}
