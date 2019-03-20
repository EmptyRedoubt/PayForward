package com.SaladinA.PF.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SaladinA.PF.DAOs.AppUserDAO;
import com.SaladinA.PF.DAOs.PrsnRoleDAO;
import com.SaladinA.PF.models.Prsn;
import com.SaladinA.PF.models.Role;
import com.SaladinA.PF.repositories.RoleRepository;
@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
    private AppUserDAO appUserDAO;
 
    @Autowired
    private PrsnRoleDAO appRoleDAO;
    
    @Autowired
    private RoleRepository rr;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Prsn appUser = this.appUserDAO.findUserAccount(userName);
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        System.out.println("Found User: " + appUser);
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = this.rr.findAllRolesByPrsnId(appUser.getId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String r : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
            	System.out.println(r.toString());
                GrantedAuthority authority = new SimpleGrantedAuthority(r);
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getUsername(), //
                appUser.getPassword(), grantList);
 
        return userDetails;
    }


}
