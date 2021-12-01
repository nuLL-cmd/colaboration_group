package com.automato_dev.home.homeponto.service;

import java.util.List;
import java.util.Objects;

import com.automato_dev.home.homeponto.entity.Collaborator;
import com.automato_dev.home.homeponto.exception.BusinessException;
import com.automato_dev.home.homeponto.repository.dao.CollaboratorDao;
import com.automato_dev.home.homeponto.repository.jpa.CollaboratorRepository;
import com.automato_dev.home.homeponto.util.ReturnMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
    
    @Autowired
    private CollaboratorDao collaboratorDao;

    @Autowired
    private CollaboratorRepository collaboratorRepo;


    public ResponseEntity<?> fetchAllCollaborators(){

        try{

             List<Collaborator> collaborators = collaboratorDao.fetchAllCollaborators();

             return ResponseEntity.ok().body(collaborators);

        }catch(Exception e){

            ReturnMessage message = new ReturnMessage(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            
            return ResponseEntity.status(message.getHttpStatus()).body(message.getMessage());

        }

    }

    public ResponseEntity<?> fetchColaboratorByRegistrataion(Long registration){

            try {


            Collaborator collaborator = collaboratorDao.fetchCollaborator(registration);

            if(Objects.nonNull(collaborator)){

                return ResponseEntity.ok().body(collaborator);
            }

            return ResponseEntity.noContent().build();
                
            } catch (Exception e) {

               ReturnMessage message = new ReturnMessage();

               message.setMessage(e.getLocalizedMessage());
               message.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

               return ResponseEntity.status(message.getHttpStatus()).body(message);
            }

    }

    public ResponseEntity<?> fetchCollaboratorByName(String name){

        try{

            List<Collaborator> collaborators = collaboratorDao.fetchByNameCollaborators(name);

            return ResponseEntity.ok().body(collaborators);


        }catch(Exception e){


            throw new BusinessException(e.getMessage());

        }

    }

    public Object createCollaborator(Collaborator collaborator){

        try{


            Collaborator returnCollaborator = collaboratorRepo.save(collaborator);

            return returnCollaborator;


        }catch(Exception e){

            throw new BusinessException(e.getMessage());
        }
       
    }

    public ResponseEntity<?> deleteCollaborator(Collaborator collaborator){

        try{

            collaboratorRepo.delete(collaborator);

            return ResponseEntity.noContent().build();


        }catch(Exception e){

            throw new BusinessException();
        }
    }

    public ResponseEntity<?> updateCollaborator(Collaborator collaborator){

        try{

            if(Objects.nonNull(collaborator))
                collaboratorRepo.save(collaborator);

            return ResponseEntity.accepted().body(collaborator);

        }catch(Exception e){
            e.printStackTrace();
             throw new BusinessException(e.getMessage());
             
        }
    }
    
}
 