package com.SaladinA.PF.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	@RequestMapping({"/about", "/about.html"})
	public String getAboutPage() {
		return "about";
	}	
}
