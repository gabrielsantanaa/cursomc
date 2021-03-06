package com.brabos.bahia.cursoSpring.resources.exceptions;

import com.brabos.bahia.cursoSpring.services.exceptions.AuthorizationException;
import com.brabos.bahia.cursoSpring.services.exceptions.DataIntegrityException;
import com.brabos.bahia.cursoSpring.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request){
            StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST ).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação", new Date());

        for(FieldError x : e.getBindingResult().getFieldErrors() ){
            error.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST ).body(error);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> objectNotFound(AuthorizationException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), new Date());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

}
