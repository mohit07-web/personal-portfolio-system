package com.myprojects.protfolio.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handleGeneralException( Exception e, RedirectAttributes redirectAttributes
			, HttpServletRequest httpServletRequest) {
		
		String header = httpServletRequest.getHeader("referer");
		System.out.println(header);
		
		//redirectAttributes.addFlashAttribute("result", "Something Went Wrong"+e.getMessage());
		redirectAttributes.addFlashAttribute("result", "Something Went Wrong");
		return "redirect:" +header;
		
	}
	
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String handleMaxFileException( Exception e, RedirectAttributes redirectAttributes
			, HttpServletRequest httpServletRequest) {
		
		String header = httpServletRequest.getHeader("referer");
		System.out.println(header);
		
		//redirectAttributes.addFlashAttribute("result", "Something Went Wrong"+e.getMessage());
		redirectAttributes.addFlashAttribute("result", "File Size must not exceed 5MB");
		return "redirect:" +header;
		
	}
}
