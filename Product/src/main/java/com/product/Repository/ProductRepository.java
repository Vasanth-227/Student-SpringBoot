package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
