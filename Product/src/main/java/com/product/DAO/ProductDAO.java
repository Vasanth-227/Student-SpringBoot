package com.product.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.Entity.Product;
import com.product.Repository.ProductRepository;


@Repository
public class ProductDAO {
	@Autowired
	ProductRepository pr;
	
	public String getObject(List<Product> p) {
		pr.saveAll(p);
		return "Products posted successfully";
	}
	public List<Product> getAll() {
		return pr.findAll();
	}
}
