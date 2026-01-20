package com.ecom.demo.service;


import com.ecom.demo.model.CartItem;
import com.ecom.demo.model.Product;
import com.ecom.demo.repository.CartRepository;
import com.ecom.demo.dto.AddToCartRequest;
import com.ecom.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItem addToCart(AddToCartRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = new CartItem();
        item.setUserId(request.getUserId());
        item.setProductId(product.getId());
        item.setQuantity(request.getQuantity());

        return cartRepository.save(item);
    }

    public List<CartItem> getUserCart(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public void clearCart(String userId) {
        cartRepository.deleteByUserId(userId);
    }
}
