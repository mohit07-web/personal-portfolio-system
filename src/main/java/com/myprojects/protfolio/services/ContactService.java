package com.myprojects.protfolio.services;

import java.util.List;

import com.myprojects.protfolio.Entities.ContactEntity;
import com.myprojects.protfolio.dto.ContactDto;

public interface ContactService {

	ContactEntity saveContact(ContactDto contactDto);
	boolean isContactEmailExist(String email);

	List<ContactEntity> readAllContacts();
	
	void deleteContactById(int id);
}

