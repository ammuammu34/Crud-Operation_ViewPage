package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	 
	@NotBlank(message = "Name is mandatory")
	 @Size( min = 3, max = 15,message = "Name shuld have only 3 to 15 Characters")
	private String productName;
	
	@NotNull(message = "Price is mandatory")
	 @Positive(message = "Price should be positive numbers")
	private Double productPrice;
	
	@NotNull(message = "Quantity is mandatory")
	 @Positive(message = "Price should be positive numbers")
	private Integer quantity;

}
