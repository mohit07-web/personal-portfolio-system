package com.myprojects.protfolio.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import com.myprojects.protfolio.services.ContactServiceImpl;
import com.myprojects.protfolio.services.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myprojects.protfolio.Entities.ServiceEntity;
import com.myprojects.protfolio.dto.ServiceDto;
import com.myprojects.protfolio.services.ContactService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ContactServiceImpl contactServiceImpl;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ServiceService serviceService;

    AdminController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }
	
	@GetMapping("/home")
	public String home() {
		return "admin/adminHome";
	}
	
	@GetMapping("/readAllContacts")
	public String readAllContacts(Model model) {
	 model.addAttribute("contactData", contactService.readAllContacts());
		return "admin/readAllContacts";
	}
	
	
	@GetMapping("/deleteContactById")
	public String deleteContactById(@RequestParam int id) {

		contactService.deleteContactById(id);
		
		return "redirect:/admin/readAllContacts";
	}
	
	
	@GetMapping("/addService")
	public String addServiceView() {

		
		return "admin/addService";
	}
	
	
	@PostMapping("/addService")
	public String addService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult result
			,Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {

		if(result.hasErrors())
		{
			model.addAttribute("result", "Invalid Input");
			model.addAttribute("errors", result.getFieldErrors());
		
			return "admin/addService";
		}
		

		if(serviceDto.getServiceFile()==null ||  serviceDto.getServiceFile().isEmpty()) 
		{
			model.addAttribute("result", "File Must Be Uploaded ");
		
			return "admin/addService";
		}
		
		MultipartFile multipartFile = serviceDto.getServiceFile();
		long size = multipartFile.getSize();
		if(size>(2*1024*1024)) {
			model.addAttribute("fileError", "File Size Must Not Exceed 2MB ");
			return "admin/addService";
		}
		
		String realPath=request.getServletContext().getRealPath("img/services/");
//		String orignalFileName=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+multipartFile.getOriginalFilename();
//		Path path = Paths.get(realPath, orignalFileName);
//		File file = path.toFile();
//		
//		multipartFile.transferTo(file);
//		
		serviceService.saveService(realPath, multipartFile, serviceDto);
		redirectAttributes.addFlashAttribute("result", "Service Added Successfully");
		
		return "redirect:/admin/addService";
	}
	
	@GetMapping("/readAllService")
	public String readAllServices(Model model) {
	 model.addAttribute("listOfServices", serviceService.readServices());
		return "admin/readAllServices";
	}
	
	@GetMapping("/deleteService")
	public String deleteService(@RequestParam int id, @RequestParam String filename, 
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		String realPath=request.getServletContext().getRealPath("img/services/");

		serviceService.deleteService(realPath, id, filename);
		
		return "redirect:/admin/readAllService";
	}
	
	
	@GetMapping("/updateService")
	public String updateServiceview(@RequestParam int id,Model model) {
		
		Optional<ServiceEntity> service = serviceService.readService(id);
		ServiceEntity serviceEntity=service.get();
		model.addAttribute("serviceData", serviceEntity);
		
		return "admin/updateService";
	}
	

	@PostMapping("/updateService")
	public String updateServiceview(@RequestParam int id, @RequestParam String oldFileName,
			@ModelAttribute ServiceDto serviceDto, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("**************************");
		String realPath=request.getServletContext().getRealPath("img/services/");
		MultipartFile serviceFile=serviceDto.getServiceFile();
		
		serviceService.updateService(realPath, serviceFile, serviceDto, id, oldFileName);
		
		return "redirect:/admin/readAllService";
	}

	@GetMapping("/uploadResume")
	public String updateResumeview() {
		
		return "admin/uploadResume";
	}
	
	@PostMapping("/uploadResume")
	public String updateResume(@RequestParam MultipartFile resume, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
	
		if(resume==null ||  resume.isEmpty()) 
		{
			redirectAttributes.addFlashAttribute("result", "Resume Must Be Uploaded ");
		
			return "redirect:/admin/uploadResume";
		}
		
		long size = resume.getSize();
		if(size>(3*1024*1024)) {
			redirectAttributes.addFlashAttribute("result", "Resume Size Must Not Exceed 3MB ");
			return "redirect:/admin/uploadResume";
		}
		
		String contentType = resume.getContentType();
		if(!contentType.contains("pdf")) {
			redirectAttributes.addFlashAttribute("result", "Resume should be in pdf format");
			return "redirect:/admin/uploadResume";
			
		}
		String realPath=request.getServletContext().getRealPath("/resume/");

		 //new file uploaded
		Path path = Paths.get(realPath, "MyResume.pdf");
		File file = path.toFile();
		
		if(file.exists()) {
			file.delete();
		}
		resume.transferTo(file);
		
		redirectAttributes.addFlashAttribute("result", "Resume Uploaded Successfully");
		
	return "redirect:/admin/uploadResume";

	}
}
