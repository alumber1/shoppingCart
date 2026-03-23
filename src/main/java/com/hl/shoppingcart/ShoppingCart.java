package com.hl.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart containing multiple items.
 * Provides functionality to calculate the total cost and access individual items.
 */
public class ShoppingCart {

	private final List<Item> items;
	private final String userId;
	private final String cartId;

	private static final String DEFAULT_USER_ID = "1";
	private static final String DEFAULT_CART_ID = "aaaaa-00001";

	/**
	 * Constructs a new ShoppingCart with the given items.
	 *
	 * @param items the list of items to include; can be null (treated as empty cart)
	 */
	public ShoppingCart(String userId, String cartId, List<Item> items) {
		if (items == null) {
			this.items = new ArrayList<>();
		} else {
			this.items = items;
		}

		if  (userId == null || userId.isBlank()) {
			userId = "1";
		}

		if  (cartId == null || cartId.isBlank()) {
			cartId = "aaaaa-00001";
		}

		this.userId = userId;
		this.cartId = cartId;

	}

	/**
	 * Constructs a new ShoppingCart with the given list of items,
	 * using default values for the user ID and cart ID.
	 * 
	 * <p>Defaults used:
	 * <ul>
	 *   <li>User ID: {@value #DEFAULT_USER_ID}</li>
	 *   <li>Cart ID: {@value #DEFAULT_CART_ID}</li>
	 * </ul>
	 * </p>
	 *
	 * @param items the list of items to include in the cart; if null, an empty cart will be created
	 */
	public ShoppingCart(List<Item> items) {
		this(DEFAULT_USER_ID, DEFAULT_CART_ID, items);
	}

	/**
	 * Calculates the total cost of all items in the cart.
	 *
	 * @return total cost of all items; returns 0.0 if the item list is null
	 */
	public double getTotal() {
		double total = items.stream()
				.mapToDouble(item -> item.getItemTotal())
				.sum();

		return BigDecimal.valueOf(total)
				.setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	public List<Item> getItems() {
		return items;
	}

	public String getUserId() {
		return userId;
	}

	public String getCartId() {
		return cartId;
	}
}
