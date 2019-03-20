package com.SaladinA.PF.models;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
 
 @Id
 //@GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="role_id")
 protected Long id;
 
 @Column(name="role")
 protected String role;
 
 @ManyToMany(mappedBy="roles")
 protected Set<Prsn> personRoles;

 public Set<Prsn> getPersonRoles() {
	return personRoles;
}

public void setPersonRoles(Set<Prsn> personRoles) {
	this.personRoles = personRoles;
}



 public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getRole() {
  return role;
 }

 public void setRole(String role) {
  this.role = role;
 }

}
