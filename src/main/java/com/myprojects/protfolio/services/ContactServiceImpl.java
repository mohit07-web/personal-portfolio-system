package com.myprojects.protfolio.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojects.protfolio.Entities.ContactEntity;
import com.myprojects.protfolio.dto.ContactDto;
import com.myprojects.protfolio.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {


		@Autowired
		private ContactRepository contactRepository;
		
		@Override
		public ContactEntity saveContact(ContactDto contactDto) {
		
			ContactEntity contactEntity = new ContactEntity();
			contactEntity.setName(contactDto.getName());
			contactEntity.setEmail(contactDto.getEmail());
			contactEntity.setSubject(contactDto.getSubject());
			contactEntity.setMessage(contactDto.getMessage());
			contactEntity.setDatetime(LocalDateTime.now().toString());
						
			return contactRepository.save(contactEntity);
	}

}
