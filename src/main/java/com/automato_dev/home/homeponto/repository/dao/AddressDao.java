package com.automato_dev.home.homeponto.repository.dao;

import java.util.List;

import com.automato_dev.home.homeponto.entity.Adress;
import com.automato_dev.home.homeponto.exception.BusinessException;

public interface AddressDao {


    List<Adress> fetchAddresByCollaborator(Long registration) throws BusinessException;
    
}
