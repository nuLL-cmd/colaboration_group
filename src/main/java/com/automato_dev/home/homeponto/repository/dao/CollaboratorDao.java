package com.automato_dev.home.homeponto.repository.dao;

import java.util.List;

import com.automato_dev.home.homeponto.entity.Collaborator;
import com.automato_dev.home.homeponto.exception.BusinessException;

public interface CollaboratorDao {

    List<Collaborator> fetchAllCollaborators() throws BusinessException;

    List<Collaborator> fetchByNameCollaborators(String name) throws BusinessException;

    Collaborator fetchCollaborator(Long registration) throws BusinessException;
    
}