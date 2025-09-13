package com.myprojects.protfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myprojects.protfolio.Entities.ContactEntity;
import com.myprojects.protfolio.dto.ContactDto;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

	boolean existsByEmail(String email);
	
}
