package com.brewery.manager.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Table(name = "brewerie")
@Data
public class Brewerie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_brewerie;
    private String Name;
    private String Adresse;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "brewerie")
    @Fetch(FetchMode.SELECT)
    private List<Beer> beer;

    public Brewerie(@NotNull String name,@NotNull String adresse){
        super();
        this.Name=name;
        this.Adresse=adresse;
    }
    
}
