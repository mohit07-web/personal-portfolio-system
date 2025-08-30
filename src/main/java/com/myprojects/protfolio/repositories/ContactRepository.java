package com.myprojects.protfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myprojects.protfolio.Entities.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

	
}
