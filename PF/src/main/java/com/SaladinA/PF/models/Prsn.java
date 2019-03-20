package com.SaladinA.PF.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import com.SaladinA.PF.repositories.RoleRepository;

@Entity
@Table(name="prsn")
//@javax.persistence.Entity(name = "prsn")
public class Prsn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prsn_id")
	public Long id;
	@Column(name="username")
	public String username;
	@Column(name="password")
	public String password;
	@Column(name = "email")
	public String emailAddress;
	@Column(name = "user_account_active_ind")
	protected int user_account_active_ind;	
	@Column(name = "confirmation_token")
	protected String confirmationToken;
	@Column(name = "first_name")
	public String firstName;
	@Column(name = "last_name")
	public String lastName;
	@Column(name = "company_name")
	public String company;
	@Temporal(TemporalType.DATE)
	@Column(name="prsn_bday")
	public Date birthday;
	@ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="prsn_role", joinColumns=@JoinColumn(name="prsn_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	 public Set<Role> roles;
	@ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="prod_list", joinColumns=@JoinColumn(name="prsn_id"), inverseJoinColumns=@JoinColumn(name="prod_id"))
	 public Set<Product> products;
	@OneToMany
    @JoinColumn(name = "fk_prsn_id")
	public Set<Address> addresses = new HashSet<>();
	@OneToMany
    @JoinColumn(name = "fk_prsn_id")
	public Set<Phone> phoneNumbers = new HashSet<>();
	@Column
	@CreationTimestamp
	private LocalDateTime create_dt;
	@Column
	@UpdateTimestamp
	private LocalDateTime mod_dt;
	
	public Prsn() {}

	public Prsn(Long id, String username, String password, String emailAddress, int user_account_active_ind,
			String confirmationToken, String firstName, String lastName, String company, Date birthday, Set<Role> roles,
			Set<Address> addresses, Set<Phone> phoneNumbers, LocalDateTime create_dt, LocalDateTime mod_dt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.emailAddress = emailAddress;
		this.user_account_active_ind = user_account_active_ind;
		this.confirmationToken = confirmationToken;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.birthday = birthday;
		this.roles = roles;
		this.addresses = addresses;
		this.phoneNumbers = phoneNumbers;
		this.create_dt = create_dt;
		this.mod_dt = mod_dt;
	}

	public Prsn(String username, String password, Collection<GrantedAuthority> roleNames) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	
	}
	
	public Prsn(String username, String password, Set<Role> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int isUser_account_active_ind() {
		return user_account_active_ind;
	}

	public void setUser_account_active_ind(int user_account_active_ind) {
		this.user_account_active_ind = user_account_active_ind;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public LocalDateTime getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(LocalDateTime create_dt) {
		this.create_dt = create_dt;
	}

	public LocalDateTime getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(LocalDateTime mod_dt) {
		this.mod_dt = mod_dt;
	}
//	@Autowired
//	private RoleRepository r;
//	public Collection<GrantedAuthority> getAuthorities(Long id) {
//		Collection<GrantedAuthority> s = r.findAllRolesByPrsnId(id);
//		
//		return s;
//	}


}
