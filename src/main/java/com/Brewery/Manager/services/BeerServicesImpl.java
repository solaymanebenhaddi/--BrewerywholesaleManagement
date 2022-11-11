package com.brewery.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BeerDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.BrewerieRepository;
import com.brewery.manager.util.BrewMapper;

public class BeerServicesImpl implements PublicDAO<BeerDTO> {

    @Autowired
    private BeerRepository beerrepo;

    @Autowired
    private BrowerieServicesImpl brewservices;

    @Autowired
    private BrewerieRepository brewrepo;

    @Autowired
    private BrewMapper mapper;

    @Override
    public BeerDTO create(BeerDTO beerrequ) throws Exception {
        Brewerie brewerie= brewrepo.findById(beerrequ.getBrewerie_id()).orElseThrow(() -> new Exception("Brewerie not found"));
        Beer beer=new Beer();
        beer.setName(beerrequ.getName());
        beer.setPrice(beerrequ.getPrice());
        beer.setAlcohol(beerrequ.getAlcohol());
        beer.setBrewerie(brewerie);
        beerrepo.save(beer);
        BeerDTO Brdto = mapper.map(beer,BeerDTO.class);
        return Brdto;
    }

    @Override
    public void update(BeerDTO o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(BeerDTO o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<BeerDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<BeerDTO> findById(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}