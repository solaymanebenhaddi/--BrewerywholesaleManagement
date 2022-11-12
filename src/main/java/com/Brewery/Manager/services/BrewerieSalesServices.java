package com.brewery.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BrewerieSalesDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.BrewerieSales;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.BrewerieSalesRepository;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;

@Transactional
@Service
public class BrewerieSalesServices implements PublicDAO<BrewerieSalesDTO> {

    @Autowired
    BrewerieSalesRepository BrewSalesRep;
    @Autowired
    WholesaleRepository wholesalerep;

    @Autowired
    BeerRepository beerrepo;

    @Autowired
    BrewMapper mapper;

    @Override
    public BrewerieSalesDTO create(BrewerieSalesDTO salereq) throws Exception {
        Wholesaler wholesale = wholesalerep.findById(salereq.getId_wholesale())
                .orElseThrow(() -> new Exception("Brewerie not whaole seller"));
        Beer beer = beerrepo.findById(salereq.getId_wholesale())
                .orElseThrow(() -> new Exception("Brewerie not whaole seller"));

        double transaction = beer.getPrice() * salereq.getQuantity();
        BrewerieSales Brwsale = new BrewerieSales(beer, wholesale, transaction, salereq.getQuantity());
        BrewSalesRep.save(Brwsale);

        BrewerieSalesDTO Brsale = mapper.map(Brwsale, BrewerieSalesDTO.class);
        return Brsale;
    }

    @Override
    public BrewerieSalesDTO update(BrewerieSalesDTO o) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public List<BrewerieSalesDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BrewerieSalesDTO findById(long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}