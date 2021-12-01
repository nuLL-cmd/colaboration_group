package com.automato_dev.home.homeponto.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Marco Aurelio
 * @date 06/10/2021
 * 
 * Represent entity tb_atividade_colaborador in database
 */
@Getter
@Setter
@ToString
@Entity(name = "tb_atividade_funcionario")
public class ActivityCollaborator {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atv_func")
    private Long idAtvFunc;

    @Column(name = "dt_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateEntry;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nr_matricula", referencedColumnName = "nr_matricula",updatable = true, insertable = true)
    @JsonIgnoreProperties("activities")
    private Collaborator collaborator;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "id_atividade", referencedColumnName = "id_atividade", updatable = true, insertable = true)
    @JsonIgnoreProperties("collaborators")
    private Activity activity;

    
}
