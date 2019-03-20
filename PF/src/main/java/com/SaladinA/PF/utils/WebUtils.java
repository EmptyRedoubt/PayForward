package com.SaladinA.PF.utils;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.SaladinA.PF.models.Prsn;


public class WebUtils {
	   public static String toString(User loginedUser) {
	        StringBuilder sb = new StringBuilder();
	 
	        sb.append("UserName:").append(loginedUser.getUsername());
	 
	        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
	        if (authorities != null && !authorities.isEmpty()) {
	            sb.append(" (");
	            boolean first = true;
	            for (GrantedAuthority a : authorities) {
	                if (first) {
	                    sb.append(a.getAuthority());
	                    first = false;
	                } else {
	                    sb.append(", ").append(a.getAuthority());
	                }
	            }
	            sb.append(")");
	        }
	        return sb.toString();
	    }

	public static String toString(org.springframework.boot.autoconfigure.security.SecurityProperties.User loginedUser) {
		StringBuilder sb = new StringBuilder();
		 
        sb.append("UserName:").append(loginedUser.getName());
 
        @SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) ((UserDetails) loginedUser).getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
	}
}
