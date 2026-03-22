package com.hl.shoppingcart;

/**
 * Represents a single item in a shopping cart.
 */
public class Item {

	private static final double MIN_PRICE = 0.0;
	private static final int MIN_QUANTITY = 1;
	
	private double price = 0;
	private int quantity = 0;
	private String productId = "";


    /**
     * Constructs a new Item with the given price and quantity.
     *
     * @param price the price of a single unit, must be >= 0
     * @param quantity the quantity of the item, if less than 1, it will be treated as 0
     * @throws IllegalArgumentException if price < 0
     */
	public Item(String productId, double price, int quantity) {

		if (price < MIN_PRICE) {
			throw new IllegalArgumentException("Price cannot be negative");
		}

		if (quantity < MIN_QUANTITY) {
			quantity = 0;
		}

		this.productId = productId;
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
	
	/**
	 * Returns the items product Id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}
}
