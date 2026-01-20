package com.ecom.demo.service;

import com.ecom.demo.model.Order;
import com.ecom.demo.model.Payment;
import com.ecom.demo.repository.OrderRepository;
import com.ecom.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public Payment createPayment(String orderId, Double amount) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!"CREATED".equals(order.getStatus())) {
            throw new RuntimeException("Order already paid or invalid");
        }

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");
        payment.setPaymentId("pay_mock_" + UUID.randomUUID());
        payment.setCreatedAt(Instant.now());

        paymentRepository.save(payment);

        // Mock async webhook callback
        new Thread(() -> {
            try {
                Thread.sleep(3000);

                order.setStatus("PAID");
                orderRepository.save(order);

                payment.setStatus("SUCCESS");
                paymentRepository.save(payment);

            } catch (Exception ignored) {}
        }).start();

        return payment;
    }
}
