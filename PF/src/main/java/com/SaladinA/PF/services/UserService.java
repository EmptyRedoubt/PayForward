package com.SaladinA.PF.services;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.SaladinA.PF.models.Prsn;
import com.SaladinA.PF.models.Role;
import com.SaladinA.PF.repositories.RoleRepository;
import com.SaladinA.PF.repositories.UserRepository;

@Service
public class UserService {
	
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

		public Prsn findByEmailAddress(String emailAddress){
	        return userRepository.findByEmailAddress(emailAddress);
	    }
		
	    public Prsn saveUser(Prsn user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setUser_account_active_ind(1);;
	        Role userRole = roleRepository.findByRole("ADMIN");
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	        return userRepository.save(user);
	    }
	    public List<Role> findByPersonRoles_Id(Long id) {	    	
			return roleRepository.findByPersonRoles_Id(id);
	    	
	    }
	    public List<String> findAllRolesByPrsnId(Long prsn_id){
			return roleRepository.findAllRolesByPrsnId(prsn_id);
	    	
	    }
	    public Prsn findByUsername(String username) {
	    	return userRepository.findByUsername(username);
	    }

}
