package com.hl.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Represents a shopping cart that holds multiple items.
 */
public class ShoppingCart {

	private final List<Item> items;

	/**
	 * Constructs a new ShoppingCart with the given items.
	 *
	 * @param items the list of items to include; can be null (treated as empty cart)
	 */
	public ShoppingCart(List<Item> items) {
		if (items == null) {
			this.items = new ArrayList<>();
		} else {
			this.items = items;
		}
	}

	/**
	 * Calculates the total cost of all items in the cart.
	 *
	 * @return total cost of all items; returns 0.0 if the item list is null
	 */
	public double getTotal() {
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

	public List<Item> getItems() {
		return items;
	}
}
