package ar.edu.um.clase7jpa.controller;

import ar.edu.um.clase7jpa.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class BaseController {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> exceptionHandler(BaseException e) {
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }

    //Manejador de excepciones de validacion
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    //Manejador de excepciones de tipo
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return new ResponseEntity<>("El tipo de dato ingresado es incorrecto",HttpStatus.BAD_REQUEST);
    }
}
