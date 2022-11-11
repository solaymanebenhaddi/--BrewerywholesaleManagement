package com.brewery.manager.services.interfaces;


import java.util.List;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BrewerieDTO;
import com.brewery.manager.models.Brewerie;



public interface BrewerieServices {

	BrewerieDTO create(BrewerieDTO dto);
	
	BrewerieDTO update(BrewerieDTO dto, Long id) throws Exception;
   
	List<BrewerieDTO> findAll();
   
	BrewerieDTO findById(Long id) throws Exception;

	void deleteById(Long id) throws Exception; 
}
