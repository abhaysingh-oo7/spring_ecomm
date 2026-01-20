package com.ecom.demo.controller;

import com.ecom.demo.model.Order;
import com.ecom.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrderFromCart(@RequestBody Map<String, String> request) {
        return orderService.createOrder(request.get("userId"));
    }

    @GetMapping("/{orderId}")
    public Order getOrderDetails(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }
    @GetMapping("/user/{userId}")
    public List<Order> getOrderHistoryForUser(@PathVariable String userId) {
        return orderService.getOrdersByUser(userId);
    }

}
