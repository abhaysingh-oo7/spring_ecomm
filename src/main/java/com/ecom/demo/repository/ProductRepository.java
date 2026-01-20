package com.ecom.demo.repository;

import com.ecom.demo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameContainingIgnoreCase(String name);
}



//
//Purpose of this is to:
//
//Save products
//
//Fetch all products
//
//Find by ID