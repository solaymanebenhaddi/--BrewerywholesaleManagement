package com.brewery.manager.util;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ManagerExceptionHandler extends ResponseEntityExceptionHandler {


        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<Object> handleResourceNotFoundException(
                ResourceNotFoundException ex) {
           
            List<String> details = new ArrayList<String>();
            details.add(ex.getMessage());
            
            ApiErrors err = new ApiErrors(
                HttpStatus.BAD_REQUEST, 
                "Resource Not Found" ,
                details);
            
            return ResponseEntityBuilder.build(err);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<?> handleConstraintViolationException(
            Exception ex, 
            WebRequest request) {
            
            List<String> details = new ArrayList<String>();
            details.add(ex.getMessage());
            
            ApiErrors err = new ApiErrors(
             
                HttpStatus.BAD_REQUEST, 
                "Constraint Violations" ,
                details);
            
            return ResponseEntityBuilder.build(err);
        }

        @ExceptionHandler({ Exception.class })
        public ResponseEntity<Object> handleAll(
            Exception ex, 
            WebRequest request) {
            
            List<String> details = new ArrayList<String>();
            details.add(ex.getLocalizedMessage());
            
            ApiErrors err = new ApiErrors(
             
                HttpStatus.BAD_REQUEST, 
                "Error occurred" ,
                details);
            
            return ResponseEntityBuilder.build(err);
        }
    
}
