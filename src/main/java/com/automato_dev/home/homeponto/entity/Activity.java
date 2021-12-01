package com.automato_dev.home.homeponto.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Marco Aurelio
 * @date 07/10/2021
 * 
 * Represent entity tb_atividade in database
 */
@Getter
@Setter
@ToString
@Entity(name = "tb_atividade")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    private Long idActivity;

    @Column(name = "nm_atividade")
    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min = 5, max = 50, message = "Campo deve conter entre 5 e 50 caracteres")
    private String nameActivity;

    @Column(name = "dt_alteracao")
    @NotNull(message = "Campo não pode ser vazio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateAlteration;

    @ManyToMany(mappedBy = "activities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("activities")
    private List<Collaborator> collaborators;



}
