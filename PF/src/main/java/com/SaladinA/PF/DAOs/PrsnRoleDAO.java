package com.SaladinA.PF.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.SaladinA.PF.models.Role;

@Repository
@Transactional
public class PrsnRoleDAO {
    @Autowired
    private EntityManager entityManager;
 
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    //@SuppressWarnings("unchecked")
	public List<String> getRoleNames(Long prsnId) {
		
		
        //String sql = "Select r.role from " + Role.class.getName() + " r " + "JOIN " + //
        //        + " where r.prsn.prsn_Id = :prsnId ";
 
        Query query = this.entityManager.createQuery(rolesQuery, String.class);
        query.setParameter("userId", prsnId);
        return query.getResultList();
    }
}
