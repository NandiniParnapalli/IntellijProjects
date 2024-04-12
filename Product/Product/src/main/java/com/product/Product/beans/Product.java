package com.product.Product.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="product")
public class Product {
 
	private int id;
	private String name;
	private String description;
	private int price;
	private int stock;
	
	
}
