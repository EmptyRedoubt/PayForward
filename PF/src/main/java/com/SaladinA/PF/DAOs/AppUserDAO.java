package com.SaladinA.PF.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SaladinA.PF.models.Prsn;

@Repository
@Transactional
public class AppUserDAO {
	
	  @Autowired
	    private EntityManager entityManager;
	 
	    public Prsn findUserAccount(String userName) {
	        try {
	            String sql = "Select e from " + Prsn.class.getName() + " e " //
	                    + " Where e.username = :userName ";
	 
	            Query query = entityManager.createQuery(sql, Prsn.class);
	            query.setParameter("userName", userName);
	 
	            return (Prsn) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }

}
