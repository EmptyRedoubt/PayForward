package com.SaladinA.PF.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SaladinA.PF.models.Prsn;
import com.SaladinA.PF.models.Role;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Prsn, Long>{
	Prsn findByEmailAddress(String emailAddress);
	Prsn findByUsername(String username);
	Prsn findByConfirmationToken(String confirmationToken);
	
}
