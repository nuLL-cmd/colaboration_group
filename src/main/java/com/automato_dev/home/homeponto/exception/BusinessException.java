package com.automato_dev.home.homeponto.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * @author Marco Aurélio.
 * @date 29/11/2021
 * Classe primaria que recebera uma mensagem e um status http, a calsse extende de:
 * @RuntimeException: Os erros serão capturados em tempo de execução.
 */
@Getter
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    public BusinessException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(){
       
    }

    
}
