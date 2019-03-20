package com.SaladinA.PF.repositories;

import org.springframework.data.repository.CrudRepository;

import com.SaladinA.PF.models.Address;
import com.SaladinA.PF.models.Prsn;


public interface AddressRepository extends CrudRepository<Address, Long>{
	Prsn findByPerson(Prsn person);
	
	

}
