package com.automato_dev.home.homeponto.exception.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Marco Aurélio
 * @date 29/11/2021
 * Classe que representara o erro manipulado pela classe ManipulaException.java
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class ErrorModel {

    private Integer status;
    private String message;
    private String timestamp;

    private List<FieldsError> fields;
    private String callMethod;
    private String className;

}
