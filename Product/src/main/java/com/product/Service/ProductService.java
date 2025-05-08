package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.DAO.ProductDAO;
import com.product.Entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDAO pd;
	
	public String getObject(List<Product> p) {
		return pd.getObject(p);
	}
	public List<Product> getAll() {
		return pd.getAll();
	}
}
