package com.myprojects.protfolio.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myprojects.protfolio.Entities.ServiceEntity;
import com.myprojects.protfolio.dto.ServiceDto;
import com.myprojects.protfolio.repositories.ContactRepository;
import com.myprojects.protfolio.repositories.ServiceRepository;

@Service
public class ServiceServiceImpl implements ServiceService{

	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public ServiceEntity saveService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto) throws Exception {

		String filename=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+multipartFile.getOriginalFilename();
		
		ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
		serviceEntity.setFilename(filename);
		serviceEntity.setDatetime(LocalDateTime.now().toString());
		
		ServiceEntity entity = serviceRepository.save(serviceEntity);
		
		Path path = Paths.get(realPath, filename);
		File file = path.toFile();
		
		multipartFile.transferTo(file);
		
		
		return entity;
	}

	@Override
	public List<ServiceEntity> readServices() {

		
		return serviceRepository.findAll();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteService(String realPath, int id, String filename) {

		serviceRepository.deleteById(id);
		File file = new File(realPath+File.separator+filename);
		file.delete();
		
	}

	@Override
	public Optional<ServiceEntity> readService(int id) {

		return serviceRepository.findById(id);
	}

	@Override
	public ServiceEntity updateService(String realPath, MultipartFile multipartFile, ServiceDto serviceDto, int id,
			String oldFileName) throws Exception {
		
		
		
			if(multipartFile!=null && !multipartFile.isEmpty()) {
				
				String filename=UUID.randomUUID().toString()+LocalDateTime.now().toString().replace(":", "a")+multipartFile.getOriginalFilename();
				
				ServiceEntity serviceEntity=modelMapper.map(serviceDto, ServiceEntity.class);
				serviceEntity.setId(id);
				serviceEntity.setFilename(filename);
				serviceEntity.setDatetime(LocalDateTime.now().toString());
				ServiceEntity entity= serviceRepository.save(serviceEntity);
			
				//old file updated
			  new File(realPath+File.separator+oldFileName).delete();
				
			  //new file uploaded
				Path path = Paths.get(realPath, filename);
				File file = path.toFile();
				
				multipartFile.transferTo(file);
				
				return entity;
			}
			else {
				ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
				serviceEntity.setId(id);
				serviceEntity.setFilename(oldFileName);
				serviceEntity.setDatetime(LocalDateTime.now().toString());
				
				ServiceEntity entity = serviceRepository.save(serviceEntity);
				
				return entity;
			}
		
	}
}