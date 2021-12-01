package com.automato_dev.home.homeponto.enumerator;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumSex {

    M("MASCULINO","M"),
    F("FEMININO","F"),
    O("OUTROS","O");

    private final String codigo;
    private final String descricao;

    private EnumSex(String descricao, String codigo){

        this.codigo = codigo;
        this.descricao = descricao;

        try{

            Field field = this.getClass().getSuperclass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(this, this.codigo);

        }catch(Exception e){

            e.printStackTrace();
        }
    }

    @JsonValue
    public String getDescricao(){

        return this.descricao;
    }

    	 

}
