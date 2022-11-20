package com.brewery.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.WholeSalerDTO;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.WholesalerRequest;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;


@Service
@Transactional
public class wholesalerImpl implements PublicDAO<WholesalerRequest> {

    @Autowired
    private BrewMapper mapper;

    @Autowired
    private WholesaleRepository wholerepo;

    @Override
    public WholeSalerDTO create(WholesalerRequest o) throws Exception {

        try {
            
            Wholesaler wholesaler=new Wholesaler();
            wholesaler.setName(o.getName());
            wholesaler.setAdresse(o.getAdresse());
            wholerepo.save(wholesaler);
            return mapper.map(wholesaler, WholeSalerDTO.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public WholeSalerDTO update(WholesalerRequest o) throws Exception {
        try {
            Wholesaler wholesaler=wholerepo.findById(o.getId_wholesale()).orElseThrow(()-> new ResourceNotFoundException("NO macthing seller !"));
            wholesaler.setName(o.getName());
            wholesaler.setAdresse(o.getAdresse());
            wholerepo.save(wholesaler);
            return mapper.map(wholesaler, WholeSalerDTO.class);
            
        } catch (Exception e) {
        throw new Exception(e.getMessage());
        }
        
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<WholeSalerDTO> findAll() throws Exception {
    
    try{
        List<Wholesaler> wholesaler=wholerepo.findAll();
         return (List<WholeSalerDTO>) mapper.map(wholesaler, WholeSalerDTO.class);
    }
     catch (Exception e) {
        throw new Exception(e.getMessage());
        }
      
    }

    @Override
    public WholeSalerDTO findById(long id) throws Exception {
        try {
            Wholesaler wholesaler=wholerepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO macthing seller !"));
            return mapper.map(wholesaler, WholeSalerDTO.class);
        } 
        catch (Exception e) {
            throw new Exception(e.getMessage());
            }
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        try {
            Wholesaler wholesaler=wholerepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("NO macthing seller !"));
            wholerepo.delete(wholesaler);
            ResponseEntity.status(200).build();
            return ResponseEntity.ok("Seller Deleted Seccessefully");
        } 
            catch (Exception e) {
            throw new Exception(e.getMessage());
            }
        
    }
    
}
