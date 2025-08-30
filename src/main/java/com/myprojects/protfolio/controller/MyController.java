package com.myprojects.protfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myprojects.protfolio.dto.ContactDto;
import com.myprojects.protfolio.services.ContactService;

@Controller
@RequestMapping("/client")
public class MyController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/services")
	public String services() {
		return "services";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute ContactDto contactDto, RedirectAttributes redirectAttributes) {
		
		contactService.saveContact(contactDto);
		redirectAttributes.addFlashAttribute("result", "Contact Saved Successfully");
		return "redirect:/client/contact";
	}
}
