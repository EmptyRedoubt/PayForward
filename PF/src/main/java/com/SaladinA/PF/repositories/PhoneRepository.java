package com.SaladinA.PF.repositories;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import com.SaladinA.PF.models.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long>{
	//Optional<Phone> findById(Id id);
	
	Phone findByPhoneNumber(String phoneNumber);
	
	Iterable<Phone> findAll();
	
	Phone save(String phoneNumber);

}
