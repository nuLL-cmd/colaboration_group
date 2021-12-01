package com.automato_dev.home.homeponto.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.automato_dev.home.homeponto.entity.Adress;
import com.automato_dev.home.homeponto.exception.BusinessException;
import com.automato_dev.home.homeponto.repository.dao.AddressDao;
import com.automato_dev.home.homeponto.util.UtilLog;

import org.springframework.stereotype.Repository;

@SuppressWarnings(value = "unchecked")
@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {


    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Adress> fetchAddresByCollaborator(Long registration) throws BusinessException {
        
        try{

            String queryString = "select e. * from tb_endereco as e where nr_matricula = :registration";

            Query query = em.createNativeQuery(queryString, Adress.class);
    
            query.setParameter("registration", registration);
    
            List<Adress> addresses = query.getResultList();
    
            return addresses;

        }catch(PersistenceException p){

            UtilLog.getLog().error(p.getMessage(), p);
            throw new BusinessException(p.getMessage());


        }catch(Exception e){

            UtilLog.getLog().error(e.getMessage(), e);
            throw new BusinessException(e.getMessage());
        }

      
    }
    
}
