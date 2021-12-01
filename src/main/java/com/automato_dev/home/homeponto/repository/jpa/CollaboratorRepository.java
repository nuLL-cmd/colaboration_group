package com.automato_dev.home.homeponto.repository.jpa;

import com.automato_dev.home.homeponto.entity.Collaborator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator,Long> {


    
    
}
