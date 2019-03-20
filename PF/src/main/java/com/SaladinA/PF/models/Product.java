package com.SaladinA.PF.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	public Long id;
	@Column(name="prod_name")
	public String name;
	@Column(name="quantity")
	public int quantity;
	@Column(name="quantity_type")
	public String quantity_type;
	@Column(name="product_type")
	public String product_type;
	@Column(name="prod_desc")
	public String prod_desc;
	@ManyToMany(mappedBy="products")
	 protected Set<Prsn> productList;

}
