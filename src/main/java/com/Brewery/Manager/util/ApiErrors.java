package com.brewery.manager.util;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiErrors {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
	private HttpStatus status;
	private String message;
	private List<?> errors;

	public ApiErrors(HttpStatus status, String message, List<?> errors) {
		super();
        this.timestamp=LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

    public ApiErrors(boolean b, String string) {
		super();
		this.status = status;
		this.message = message;
    }
}
    

