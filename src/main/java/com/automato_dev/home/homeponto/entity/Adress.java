package com.automato_dev.home.homeponto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.automato_dev.home.homeponto.enumerator.EnumState;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marco Aurelio
 * @date 06/10/2021
 * 
 * Represent entity tb_endereco in database
 */
 @Getter
 @Setter
 @ToString
 @Entity(name = "tb_endereco")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long idAdress;

    @Column(name = "logradouro")
    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min = 5, max = 100, message = "Campo deve conter entre 5 e 100s caracteres")
    private String publicPlace;

    @Column(name = "bairro")
    @NotBlank(message = "Campo bairro não pode ser vazio")
    @Size(min = 5, max = 25, message = "Campo deve conter entre 5 e 25 caracteres")
    private String district;

    @Column(name = "numero")
    @Digits(fraction = 0, integer = 10, message = "Campo deve conter apenas caracteres numerais")
    @Positive(message = "Deve ser inserido um numero valido para a operação")
    @NotNull(message = "Campo não pode ser nullo")
    private Integer numberAdress;

    @Column(name = "cidade")
    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min = 4, max = 50, message = "Campo deve conter entre 4 e 50 caracteres")
    private String city;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EnumState state;
    
/* 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nr_matricula", referencedColumnName = "nr_matricula", updatable = true, insertable = true)
    @JsonIgnoreProperties("adresses")
    private Collaborator collaborator; */



}
