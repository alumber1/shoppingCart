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

	/**
	 * Constructs a new ShoppingCart with the given items.
	 *
	 * @param items the list of items to include; can be null (treated as empty cart)
	 */
	public ShoppingCart(String userId, List<Item> items) {
		if (items == null) {
			this.items = new ArrayList<>();
		} else {
			this.items = items;
		}
		
		if  (userId == null || userId.isBlank()) {
			userId = "1";
		}
		
		this.userId = userId;
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
}
