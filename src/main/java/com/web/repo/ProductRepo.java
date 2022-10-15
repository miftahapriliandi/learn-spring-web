package com.web.repo;

import org.springframework.data.repository.CrudRepository;

import com.web.entity.Product;

public interface ProductRepo extends CrudRepository<Product, Long>{

    
    
}
