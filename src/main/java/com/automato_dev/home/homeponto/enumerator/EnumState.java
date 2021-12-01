package com.automato_dev.home.homeponto.enumerator;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumState {
    
    AL("ALAGOAS","AL"),
	AP("AMAPA", "AP"),
	AM("AMAZONAS","AM"),
	BA("BAHIA","BA"),
	CE("CEARA","CE"),
	DF("DISTRITO FEDERAL","DF"),
	ES("ESPIRITO SANTO","ES"),
	GO("GO","GOIAS"),
	MA("MARANHAO","MA"),
	MT("MATO GROSSO","MT"),
	MS("MATO GROSSO DO SUL","MS"),
	MG("MINAS GERAIS","MG"),
	PA("PARA","PARA"),
	PB("PARAIBA","PB"),
	PR("PARANA","PR"),
	PE("PERNAMBUCO","PE"),
	PI("PIAUI","PI"),
	RJ("RIO DE JANEIRO","RJ"),
	RN("RIO GRANDE DO NORME","RN"),
	RS("RIO GRANDE DO SUL","RS"),
	RO("RONDONIA","RO"),
	RR("RORAIMA","RR"),
	SC("SANTA CATARINA","SC"),
	SP("SÂO PAULO","SP"),
	SE("SERGIPE","SE"),
	TO("TOCANTINS","TO");

    private final String codigo;
    private final String descricao;


    private EnumState(String codigo, String descricao){

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
