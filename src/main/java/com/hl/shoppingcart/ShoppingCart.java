package com.hl.shoppingcart;

import java.util.List;


/**
 * Represents a shopping cart that holds multiple items.
 */
public class ShoppingCart {

	private final List<Item> items;
	private static final double EMPTY_CART_TOTAL = 0.0;

	/**
	 * Constructs a new ShoppingCart with the given items.
	 *
	 * @param items the list of items to include; can be null (treated as empty cart)
	 */
	public ShoppingCart(List<Item> items) {
		this.items = items;
	}

	/**
	 * Calculates the total cost of all items in the cart.
	 *
	 * @return total cost of all items; returns 0.0 if the item list is null
	 */
	public double getTotal() {

		if(items == null) {
			return EMPTY_CART_TOTAL;
		}

		return items.stream().mapToDouble(item -> item.getItemTotal()).sum();
	}

	public String getProductId() {
		return "SKU-001";
	}

}
