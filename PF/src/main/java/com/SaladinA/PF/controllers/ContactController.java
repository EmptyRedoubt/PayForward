package com.SaladinA.PF.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	@RequestMapping({"/contact.html"})
	public String getContactPage() {
		return "contact";
	}

}
