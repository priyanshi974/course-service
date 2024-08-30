package com.pg.employee_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EnrollmentNotFoundException extends RuntimeException{

    public EnrollmentNotFoundException(String message){
        super(message);
    }
}
