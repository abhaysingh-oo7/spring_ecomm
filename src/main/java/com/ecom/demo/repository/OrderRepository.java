package com.ecom.demo.repository;


import com.ecom.demo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}

//thsi saves orders and find orders by ID