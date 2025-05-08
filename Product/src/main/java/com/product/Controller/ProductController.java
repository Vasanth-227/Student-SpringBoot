package com.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Product;
import com.product.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService ps;
	
	@PostMapping(value="/getObject")
	public String getObject(@RequestBody List<Product> p) {
		return ps.getObject(p);
	}	
	@GetMapping(value="/getAll")
	public List<Product> getAll() {
		return ps.getAll();
	}
}
