package com.automato_dev.home.homeponto.pattern;

import java.util.List;

import com.automato_dev.home.homeponto.exception.model.FieldsError;
import com.automato_dev.home.homeponto.exception.model.ErrorModel;

/**
 * @author Marco Aurélio.
 * @date 29-11-2021
 * 
 * Classe que segue o padrão Builder para a entidade Erro.
 */
public class ErrorModelBuilder {

    private Integer status;
    private String message;
    private String timestamp;
    private List<FieldsError> fields;
    private String callMethod;
    private String className;


    public ErrorModel build(){

        return new ErrorModel(this.status, this.message, this.timestamp, this.fields, this.callMethod, this.className);
    }

    public ErrorModelBuilder status(Integer status){

        this.status = status;
        return this;
    }

    public ErrorModelBuilder message(String message){

        this.message = message;
        return this;
    }

    public ErrorModelBuilder timestamp(String timestamp){

        this.timestamp = timestamp;
        return this;
    }

    public ErrorModelBuilder fields(List<FieldsError> fields){

        this.fields = fields;
        return this;
    }


    public ErrorModelBuilder callMethod(String callMethod){

        this.callMethod = callMethod;
        return this;
    }

    public ErrorModelBuilder classNamed(String className){

        this.className = className;
        return this;
    }

}
