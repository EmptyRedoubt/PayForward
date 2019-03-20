package com.SaladinA.PF.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SaladinA.PF.models.Prsn;
import com.SaladinA.PF.models.Role;
import com.SaladinA.PF.services.UserService;
import com.SaladinA.PF.utils.WebUtils;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping({ "", "/", "/home", "/home.html" })
	public String getIndexPage(Model model, Principal principal) {
		User loginedUser = null;
		String userInfo = null;
		Prsn p = null;
		//System.out.println(principal.getName());
		// After user login successfully.
		if (principal != null) {
			System.out.println("Set User");
			String userName = principal.getName();

			System.out.println("User Name: " + userName);

			loginedUser = (User) ((Authentication) principal).getPrincipal();
			p = userService.findByUsername(userName);

			userInfo = WebUtils.toString(loginedUser);
		}

		if (loginedUser != null) {
			List<Role> role = userService.findByPersonRoles_Id(p.getId());
			String userRole = "";
			for (Role r : role) {
				System.out.println(r.getRole());
				userRole = r.getRole();
			}
			model.addAttribute("userInfo", userInfo);
			model.addAttribute("role", userRole);
			model.addAttribute("user", loginedUser);
			model.addAttribute("prsn", p);
			model.addAttribute("userExists", true);
		} else {
			model.addAttribute("user", new Prsn());
		}
		return "home";
	}

}
