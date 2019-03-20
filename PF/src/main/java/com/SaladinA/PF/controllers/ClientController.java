package com.SaladinA.PF.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SaladinA.PF.models.Prsn;
import com.SaladinA.PF.models.Role;
import com.SaladinA.PF.services.UserService;
@Controller
public class ClientController {
	@Autowired
	 private UserService userService;
	@RequestMapping({"/ClientHome", "/ClientHome.html"})
	public String getClientHomePage(Model model) {
		System.out.println("You are HOME");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  Prsn user = userService.findByEmailAddress(auth.getName());
		  if(user != null) {
			  List<Role> role = userService.findByPersonRoles_Id(user.getId());
			  String userRole = "";
			  for(Role r : role) {
				  System.out.println(r.getRole());
				  userRole = r.getRole();
			  }
			  model.addAttribute("role", userRole);
			 model.addAttribute("user", user);
			 model.addAttribute("userExists", true);
		  }else {
		  	model.addAttribute("user", new Prsn());
		  }
		return "ClientHome";
	}	
}
