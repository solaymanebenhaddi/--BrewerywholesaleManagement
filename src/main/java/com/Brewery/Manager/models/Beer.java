package com.brewery.manager.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Table(name = "beer")
@Data
public class Beer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_beer;
    private String Name;
    private String Alcohol;
    private double Price;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_brewerie")
    @JoinColumn(name = "id_brewerie", referencedColumnName = "id_brewerie",nullable = false, columnDefinition = "int default 1")
    private Brewerie brewerie;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beer")
	@Fetch(FetchMode.JOIN)
	private List<BrewerieSales> BrewerieSales;

    public Beer(){
        super();
    }

    public Beer(@NotNull String name,@NotNull String alcohol,@NotNull double price,Brewerie brewerie){
        super();
        this.Name=name;
        this.Alcohol=alcohol;
        this.Price=price;
        this.brewerie=brewerie;

    }
    
}
