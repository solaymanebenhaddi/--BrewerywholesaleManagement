package com.brewery.manager.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "wholesaler")
@Data
public class Wholesaler {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_wholesale;
    private String Name;
    private String Adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wholesaler")
	@Fetch(FetchMode.JOIN)
    @JsonIgnore
	private List<BrewerieSales> BrewerieSales;

    

    
}
