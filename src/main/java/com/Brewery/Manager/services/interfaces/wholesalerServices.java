package com.brewery.manager.services.interfaces;

import java.util.List;

import com.brewery.manager.Dto.WholeSalerDTO;

import lombok.Data;


public interface wholesalerServices {


	List<WholeSalerDTO> findAll();
	
	WholeSalerDTO findById(Long id) throws Exception;

	void deleteById(Long id) throws Exception;
    
}
