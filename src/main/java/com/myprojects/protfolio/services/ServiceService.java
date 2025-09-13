package com.myprojects.protfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.myprojects.protfolio.Entities.ServiceEntity;
import com.myprojects.protfolio.dto.ServiceDto;

public interface ServiceService {

	
	ServiceEntity saveService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto) throws Exception;

	List<ServiceEntity> readServices();

	void deleteService(String realPath, int id, String filename);

	Optional<ServiceEntity>readService(int id);
	
	ServiceEntity updateService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto, int id, String oldFileName) throws Exception;

}
