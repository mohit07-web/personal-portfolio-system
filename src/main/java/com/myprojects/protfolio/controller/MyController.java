package com.myprojects.protfolio.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myprojects.protfolio.dto.ContactDto;
import com.myprojects.protfolio.services.ContactService;
import com.myprojects.protfolio.services.ServiceService;

@Controller
@RequestMapping("/client")
public class MyController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServiceService serviceService;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/services")
	public String services(Model model) {
		model.addAttribute("listOfServices", serviceService.readServices());
		return "services";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid @ModelAttribute ContactDto contactDto,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		
		/*if(bindingResult.hasErrors()) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for( FieldError error: fieldErrors) {
			String field = error.getField();
			if(field.equals("name")){
			String defaultMessage = error.getDefaultMessage();
			System.out.println("NAME FIELD CONTAINS:" + defaultMessage);
			}
			}
		
		}*/
		

		if(bindingResult.hasErrors()) {
		model.addAttribute("result","Invalid Input");
		model.addAttribute("errors",bindingResult.getFieldErrors() );
		return "contact";
		}
		
		
		if(contactService.isContactEmailExist(contactDto.getEmail())){
			redirectAttributes.addFlashAttribute("result", "You have already sent");
			return "redirect:/client/contact";
		}
		
		contactService.saveContact(contactDto);
		redirectAttributes.addFlashAttribute("result", "Contact Saved Successfully");
		return "redirect:/client/contact";
	}
	
	@GetMapping("/downloadResume")
	public void downloadResume(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String realPath=request.getServletContext().getRealPath("/resume/");
		Path path = Paths.get(realPath, "MyResume.pdf");
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename-MyResume.pdf");
		
		ServletOutputStream outputStream = response.getOutputStream();
		Files.copy(path, outputStream);
		
		outputStream.flush();
		
		
	}
}
