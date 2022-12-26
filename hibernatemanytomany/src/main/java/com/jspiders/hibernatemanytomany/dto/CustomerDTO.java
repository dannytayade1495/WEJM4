package com.jspiders.hibernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class CustomerDTO {
	
	@Id
	private int id;
	
	private String name;
	
	private String email;
	
	private long contact;
	
	@ManyToMany
	@JoinTable(name = "customer_product_details",
	joinColumns = @JoinColumn(referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
	private List<ProductDTO> products;

}
