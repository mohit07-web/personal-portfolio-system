package com.myprojects.protfolio.services;

import com.myprojects.protfolio.Entities.ContactEntity;
import com.myprojects.protfolio.dto.ContactDto;

public interface ContactService {


	ContactEntity saveContact(ContactDto contactDto);

}
