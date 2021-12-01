package com.automato_dev.home.homeponto.resource;

import javax.validation.Valid;

import com.automato_dev.home.homeponto.entity.Collaborator;
import com.automato_dev.home.homeponto.exception.BusinessException;
import com.automato_dev.home.homeponto.service.CollaboratorService;
import com.automato_dev.home.homeponto.util.ReturnMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("collaborator")
public class CollaboratorResource {
    
    @Autowired
    private CollaboratorService collaboratorService;

    @GetMapping
    private ResponseEntity<?> fetchAllCollaborators(){

        return collaboratorService.fetchAllCollaborators();
    }

    @GetMapping(value = "{registration}/registration", produces = "application/json")
    private ResponseEntity<?> fetchCollaboratorByRegistration(@PathVariable Long registration){

        if(registration >  0L){

            return collaboratorService.fetchColaboratorByRegistrataion(registration);

        }

        ReturnMessage message = new ReturnMessage();
        message.setMessage("Deve ser inserido uma matricula valida!");
        message.setHttpStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(message.getHttpStatus()).body(message.getMessage());
    }

    @GetMapping(value = "{name}/like_name", produces = "application/json")
    private ResponseEntity<?> fetchCollaboratorByName(@PathVariable String name) throws BusinessException{

        return collaboratorService.fetchCollaboratorByName(name);
    }

    
    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    private Object createCollaborator(@Valid @RequestBody Collaborator collaborator){

        return collaboratorService.createCollaborator(collaborator);
    }

    @DeleteMapping
    private ResponseEntity<?> deletecollaborator(@Valid @RequestBody Collaborator collaborator){

        return collaboratorService.deleteCollaborator(collaborator);
    }

    @PutMapping
    private ResponseEntity<?> updateCollaborator(@Valid @RequestBody Collaborator collaborator){

        return collaboratorService.updateCollaborator(collaborator);
    }
}
