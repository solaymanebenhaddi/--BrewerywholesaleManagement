package com.brewery.manager.util;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {

	
	public static ResponseEntity<Object> build(ApiErrors apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
