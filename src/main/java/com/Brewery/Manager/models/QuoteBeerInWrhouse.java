package com.brewery.manager.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy;

@Entity
@Table(name = "Cabinet_Medecins")
@Data
public class QuoteBeerInWrhouse {
    

    @EmbeddedId
    private QuateandBeersHouseIDs QtBrHouseIDs;

    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_devis")
    @JoinColumn(name = "id_devis", referencedColumnName = "id_devis")
    private Quote quote;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id")
    @JoinColumn(name = "idbw", referencedColumnName = "idbw")
    private BeerInWarehouse bWarehouse;

    private long quantity;

    private Double discount;

    private Double price;
    public QuoteBeerInWrhouse(){
        super();
    }

    public QuoteBeerInWrhouse(Quote quote,BeerInWarehouse bWarehouse,long quantity,Double price){

        super();
        this.QtBrHouseIDs=new QuateandBeersHouseIDs(quote.id_devis, bWarehouse);
        this.quantity=quantity;
        this.price=price;
    }
}
