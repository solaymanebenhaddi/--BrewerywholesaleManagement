package com.brewery.manager.services;

import java.util.List;
import java.util.stream.Stream;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BeerDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.BrewerieRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;

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
        
        Brewerie brewerie= brewrepo.findById(beerrequ.getId_brewerie()).orElseThrow(() -> new ResourceNotFoundException("Brewerie not found"));
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
        Beer beer= beerrepo.findById(beerrequ.getId_beer()).orElseThrow(() -> new ResourceNotFoundException("Beer not found"));
        Brewerie brewerie= brewrepo.findById(beerrequ.getId_brewerie()).orElseThrow(() -> new ResourceNotFoundException("Brewerie not found"));
        beer.setName(beerrequ.getName());
        beer.setPrice(beerrequ.getPrice());
        beer.setAlcohol(beerrequ.getAlcohol());
        beer.setBrewerie(brewerie);
        beerrepo.save(beer);
        return mapper.map(beer,BeerDTO.class);
        
        
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        try {
            Beer beer= beerrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Beer not found"));
            beerrepo.deleteById(beer.getId_beer());
            ResponseEntity.status(200).build();
            return ResponseEntity.ok(" beer has been deleted seccessefully"); 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        

    }

    @Override
    public List<BeerDTO> findAll() throws Exception {
        try {
            List<Beer> beers= beerrepo.findallBeers();
            return  (List<BeerDTO>) mapper.map(beers,BeerDTO.class); 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
        
       

    @Override
    public BeerDTO findById(long id) throws Exception {
        try {
            Optional<Beer> isbeer=beerrepo.findById(id);
            if(isbeer.isPresent()){
                Beer beer= isbeer.get();
                return mapper.map(beer, BeerDTO.class);
            }
             else throw new ResourceNotFoundException("No Matching found");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
      
    }

    public List<Beer> BeerbyIdBrewerie(Long id) throws Exception{
       
       try{ Brewerie brewerie= brewrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brewerie not found"));
        List<Beer> beers= beerrepo.findallBeersByBrewerieId(brewerie.getId_brewerie());
        return beers;
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
        
    }


}