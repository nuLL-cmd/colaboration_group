package com.automato_dev.home.homeponto.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marco Aurelio
 * @date 06/10/2021
 * 
 *       Represent entity tb_colaborador in database
 */
@Getter
@Setter
@ToString
@Entity(name = "tb_funcionario")
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nr_matricula")
    private Long registration;

    @Column(name = "nm_funcionario")
    @NotBlank(message = "Campo nome não pode ser vazio!")
    @Size(min = 5, max = 50, message = "Campo deve conter nomes com no minimo 5 caracteres e um máximo de 50 caracteres")
    private String name;

    @Column(name = "idade")
    @NotNull(message = "Campo idade não pode ser vazio")
    @Positive(message = "Insira um numero valido!")
    @Digits(fraction = 0, integer = 10, message = "Deve ser inserido um caractere numeral")
    @Max(value = 200, message = "Idade não pode ser maior que 200")
    @Min(value = 18, message = "Idade minima para registro tem que ser de 18 anos")
    private Integer age;

    @Column(name = "nacionalidade")
    @NotBlank(message = "Campo nacionalidade não pode ser vazio")
    @Size(min = 5, message = "Necessário conter ao menos 5 caracteres")
    private String nationality;

    @Valid
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "nr_matricula", referencedColumnName = "nr_matricula",updatable = true, insertable = true)
    @JsonIgnoreProperties("collaborator")
    private List<Adress> adresses = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "tb_atividade_funcionario", joinColumns = @JoinColumn(name = "nr_matricula"),
    inverseJoinColumns = @JoinColumn(name = "id_atividade"))
    @JsonIgnoreProperties("collaborators")
    private List<Activity> activities;

}
