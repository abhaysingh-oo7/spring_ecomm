package com.ecom.demo.controller;

import com.ecom.demo.model.Payment;
import com.ecom.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Map<String, Object> request) {

        String orderId = request.get("orderId").toString();
        Double amount = Double.valueOf(request.get("amount").toString());

        return paymentService.createPayment(orderId, amount);
    }
}
