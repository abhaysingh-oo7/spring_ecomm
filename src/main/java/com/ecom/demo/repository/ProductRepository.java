package com.ecom.demo.repository;

import com.ecom.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}


//
//Purpose of this is to:
//
//Save products
//
//Fetch all products
//
//Find by ID