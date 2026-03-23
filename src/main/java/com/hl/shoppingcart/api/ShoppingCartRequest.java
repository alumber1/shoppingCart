package com.hl.shoppingcart.api;

import java.time.Instant;
import java.util.List;

import com.hl.shoppingcart.Item;

public class ShoppingCartRequest {
    public String userId;
    public String cartId;
    public Instant timestamp;
    public List<Item> items;
}
