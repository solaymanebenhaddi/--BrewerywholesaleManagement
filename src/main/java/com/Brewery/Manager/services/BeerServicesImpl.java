package com.brewery.manager.services;

import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BeerDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.BrewerieRepository;
import com.brewery.manager.util.BrewMapper;

@Transactional
@Service
public class BeerServicesImpl implements PublicDAO<BeerDTO> {

    @Autowired
    private BeerRepository beerrepo;

    @Autowired
    private BrewerieRepository brewrepo;

    @Autowired
    private BrewMapper mapper;

    @Override
    public BeerDTO create(BeerDTO beerrequ) throws Exception {
        
        Brewerie brewerie= brewrepo.findById(beerrequ.getId_brewerie()).orElseThrow(() -> new Exception("Brewerie not found"));
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
    public BeerDTO update(BeerDTO beerrequ) throws Exception {
        Beer beer= beerrepo.findById(beerrequ.getId_beer()).orElseThrow(() -> new Exception("Beer not found"));
        Brewerie brewerie= brewrepo.findById(beerrequ.getId_brewerie()).orElseThrow(() -> new Exception("Brewerie not found"));
        beer.setName(beerrequ.getName());
        beer.setPrice(beerrequ.getPrice());
        beer.setAlcohol(beerrequ.getAlcohol());
        beer.setBrewerie(brewerie);
        beerrepo.save(beer);
        return mapper.map(beer,BeerDTO.class);
        
        
    }

    @Override
    public void delete(Long id) throws Exception {
        Beer beer= beerrepo.findById(id).orElseThrow(() -> new Exception("Beer not found"));
        beerrepo.deleteById(beer.getId_beer());

    }

    @Override
    public List<BeerDTO> findAll() {
        List<Beer> beers= beerrepo.findallBeers();
        return  (List<BeerDTO>) mapper.map(beers,BeerDTO.class); 
       
    }
        
       

    @Override
    public BeerDTO findById(long id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Beer> isbeer=beerrepo.findById(id);
        if(isbeer.isPresent()){
            Beer beer= isbeer.get();
            return mapper.map(beer, BeerDTO.class);
        }
         else throw new Exception("No Matching found");
    }

    public List<Beer> BeerbyIdBrewerie(Long id) throws Exception{
        Brewerie brewerie= brewrepo.findById(id).orElseThrow(() -> new Exception("Brewerie not found"));
        List<Beer> beers= beerrepo.findallBeersByBrewerieId(brewerie.getId_brewerie());
        return beers;
        
    }

}