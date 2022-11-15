package com.brewery.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.WholeSalerDTO;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.WholesalerRequest;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;


@Service
@Transactional
public class wholesalerImpl implements PublicDAO<WholesalerRequest> {

    @Autowired
    private BrewMapper mapper;

    @Autowired
    private WholesaleRepository wholerepo;

    @Override
    public WholeSalerDTO create(WholesalerRequest o) {

        Wholesaler wholesaler=new Wholesaler();
        wholesaler.setName(o.getName());
        wholesaler.setAdresse(o.getAdresse());
        wholerepo.save(wholesaler);
        return mapper.map(wholesaler, WholeSalerDTO.class);

    }

    @Override
    public WholeSalerDTO update(WholesalerRequest o) {
        return null;
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<WholeSalerDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WholeSalerDTO findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
