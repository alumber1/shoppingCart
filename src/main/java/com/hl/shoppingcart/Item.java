package com.hl.shoppingcart;

/**
 * Represents a single item in a shopping cart.
 */
public class Item {

	private double price = 0;
	private int quantity = 0;


	/**
	 * Constructs a new Item with the given price and quantity.
	 *
	 * @param price the price of a single unit, must be >= 0
	 * @param quantity the quantity of the item, must be > 0
	 * @throws IllegalArgumentException if price < 0 or quantity <= 0
	 */
	public Item(double price, int quantity) {

		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}

		if (quantity <= 0) {
			throw new IllegalArgumentException("Quantity cannot be negative");
		}

		this.price = price;
		this.quantity = quantity;

	}

	/**
	 * Calculates the total cost of this item (price * quantity).
	 *
	 * @return total cost of the item
	 */
	public double getItemTotal() {
		return price * quantity;
	}
}
