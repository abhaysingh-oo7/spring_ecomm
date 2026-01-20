package com.ecom.demo.repository;

import com.ecom.demo.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUserId(String userId);
}
