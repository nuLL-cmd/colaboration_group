package com.automato_dev.home.homeponto.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.automato_dev.home.homeponto.entity.Collaborator;
import com.automato_dev.home.homeponto.exception.BusinessException;
import com.automato_dev.home.homeponto.repository.dao.CollaboratorDao;
import com.automato_dev.home.homeponto.util.UtilLog;

import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository("collaboratorDao")
public class CollaboratorDaoImpl implements CollaboratorDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Collaborator> fetchAllCollaborators() throws BusinessException {

        try {

            String queryString = "  select c. * from tb_funcionario as c ";

            Query query = em.createNativeQuery(queryString, Collaborator.class);

            return (List<Collaborator>) query.getResultList();

        } catch (PersistenceException e) {

            UtilLog.getLog().error(e.getMessage(), e);
            throw new BusinessException(e.getLocalizedMessage());

        } catch (Exception e) {

            UtilLog.getLog().error(e.getMessage(), e);
            throw new BusinessException(e.getLocalizedMessage());
        }

    }

    @Override
    public List<Collaborator> fetchByNameCollaborators(String name) throws BusinessException {

        try {

            String queryString = "  select f. * from tb_funcionario as f "
                    + "  where f.nm_funcionario like  :name  ";

            Query query = em.createNativeQuery(queryString, Collaborator.class);

            query.setParameter("name", "%"+name+"%");

            return (List<Collaborator>) query.getResultList();

        } catch (Exception e) {

            String message = e.getMessage();

            if(e instanceof PersistenceException){

                if(e.getLocalizedMessage().contains("JDBC")){
                    
                    message = "Erro ao consumir a conexãso JDBC, verifique a conexão com o banco e tente novamente.";
                }
            }

            throw new BusinessException(message);
        }
    }

    @Override
    public Collaborator fetchCollaborator(Long registration) throws BusinessException {

        try {

            String sqlString = "  select  f. * from tb_funcionario f   "
                                + "  where f.nr_matricula =  :registration  ";

            Query query = em.createNativeQuery(sqlString, Collaborator.class);

            query.setParameter("registration", registration);

            Collaborator collaborator =  (Collaborator) query.getSingleResult(); 

            return collaborator;

        } catch (NoResultException n) {

            UtilLog.getLog().info("Não foi encontrado result na consulta.");
            return null;

        } catch (PersistenceException e) {

            throw new BusinessException(e.getLocalizedMessage());
        }

    }

}
