package com.automato_dev.home.homeponto.exception;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.validation.ConstraintViolationException;

import com.automato_dev.home.homeponto.exception.model.ErrorModel;
import com.automato_dev.home.homeponto.exception.model.FieldsError;
import com.automato_dev.home.homeponto.pattern.ErrorModelBuilder;
import com.automato_dev.home.homeponto.util.UtilDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Marco Aurélio.
 * @date 02/05/2021 Calsse que ira capturar e manipular os erros das requisições
 *       em tempo de execução, anotada com:
 * @ControllerAdvice informa ao spring que essa é uma classe para tratamento de
 *                   erros da api.
 */
@ControllerAdvice
public class ManipulaExcpetion extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {

        HttpStatus status = ex.getStatus() != null ? ex.getStatus() : HttpStatus.INTERNAL_SERVER_ERROR ;

        new UtilDate();
        ErrorModel error = new ErrorModelBuilder()
        .message(ex.getMessage()).status(status.value())
        .timestamp(UtilDate.convertTimestampDate(OffsetDateTime.now().toEpochSecond()))
        .callMethod(ex.getStackTrace()[0].getMethodName())
        .classNamed(ex.getStackTrace()[0].getClassName())
        .build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {

        ErrorModel error = new ErrorModelBuilder().message(ex.getLocalizedMessage())
                .timestamp(UtilDate.convertTimestampDate(OffsetDateTime.now().toEpochSecond()))
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());

    }

    
    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<Object> handleNonUniqueResult(NonUniqueResultException ex, WebRequest request) {

        ErrorModel error = new ErrorModelBuilder().message(ex.getLocalizedMessage())
                .timestamp(UtilDate.convertTimestampDate(OffsetDateTime.now().toEpochSecond()))
                .callMethod(ex.getStackTrace()[0].getMethodName())
                .classNamed(ex.getStackTrace()[0].getClassName())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());

    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {

        ErrorModel error = new ErrorModelBuilder()
        .message(ex.getLocalizedMessage())
        .timestamp(UtilDate.convertTimestampDate(OffsetDateTime.now()
        .toEpochSecond()))
        .callMethod(ex.getStackTrace()[0].getMethodName())
        .classNamed(ex.getStackTrace()[0].getClassName())
        .build();

        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
            
        List<FieldsError> fields = new ArrayList<>();
        
        for(ObjectError error: ex.getBindingResult().getAllErrors()){

            fields.add(new FieldsError(((FieldError)error).getField(),error.getDefaultMessage()));
        }

        ErrorModel error = new ErrorModelBuilder()
            .message("Um ou mais campos são inválidos")
            .status(status.value())
            .timestamp(UtilDate.convertTimestampDate(OffsetDateTime.now().toEpochSecond()))
            .fields(fields)
            .callMethod(ex.getStackTrace()[0].getMethodName())
            .classNamed(ex.getStackTrace()[0].getClassName())
            .build();


        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

}
