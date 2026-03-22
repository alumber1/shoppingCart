package com.hl.shoppingcart;

import java.util.List;
import java.util.stream.Collectors;


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

	/**
	 * Returns a list of product IDs for all items in the cart.
	 *
	 * @return a List of product IDs; returns an empty List if the cart has no items
	 */
	public List<String> getProductId() {
		return items.stream().map(Item::getProductId).collect(Collectors.toList());
	}

}
