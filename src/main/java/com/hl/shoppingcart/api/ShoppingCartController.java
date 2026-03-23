package com.hl.shoppingcart.api;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hl.shoppingcart.ShoppingCart;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {
	
	@PostMapping("/total")
    public ResponseEntity<ShoppingCartResponse> calculateTotal(@RequestBody ShoppingCartRequest request) {

        ShoppingCart cart = new ShoppingCart(request.userId, request.cartId, Instant.now(), request.items);

        ShoppingCartResponse response = new ShoppingCartResponse();
        response.total = cart.getTotal();
        response.userId = cart.getUserId();
        response.cartId = cart.getCartId();

        return ResponseEntity.ok(response);
    }
}
