package com.hl.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit tests for the ShoppingCart class.
 */
public class ShoppingCartTest {


	// ===== Happy Path Tests =====

	@Test
	public void shouldReturnZeroWhenCartIsEmpty() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnTotalForSingleItem() {
		ShoppingCart basket = buildCartWithItems(new Item(49.99, 1));
		assertEquals(49.99, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnSumOfTotalsForMultipleItems() {
		ShoppingCart basket = buildCartWithItems(new Item(49.99, 1), new Item(15.99,1));
		assertEquals(65.98, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalWhenItemHasMultipleQuantities() {
		ShoppingCart basket = buildCartWithItems(new Item(15.99, 2));
		assertEquals(31.98, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalForMultipleItemsWithQuantities() {
		ShoppingCart basket = buildCartWithItems(new Item(15.99, 2), new Item(49.99, 2));
		assertEquals(131.96, basket.getTotal(), 0.0);
	}

	// ===== Validation / Edge Case Tests =====

	/**
	 * For demonstration purposes, this test throws an exception for negative price.
	 * In a production scenario, we could instead treat negative values as zero to handle gracefully.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNegativePrice() {
		buildCartWithItems(new Item(-49.99, 1));
	}

	/**
	 * For demonstration purposes, this test throws an exception for negative quantity.
	 * In a production scenario, we could instead treat negative values as zero to handle gracefully.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNegativeQuantity() {
		buildCartWithItems(new Item(49.99, -1));
	}

	/**
	 * For demonstration purposes, this test throws an exception for zero quantity.
	 * In a production scenario, we could instead treat zero values as zero or skip the item.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForZeroQuantity() {
		buildCartWithItems(new Item(49.99, 0));
	}

	/**
	 * Handling null gracefully by returning 0 for the total.
	 * In a stricter design, we could throw an exception instead, but here we treat null as an empty cart.
	 */
	@Test
	public void shouldReturnZeroForNull() {
		ShoppingCart basket = new ShoppingCart(null);
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	// ===== Helper Methods =====

	/**
	 * Helper method to create a new shopping cart with the given items.
	 *
	 * @param items the items to include in the shopping cart
	 * @return a new ShoppingCart containing the given items
	 */
	private ShoppingCart buildCartWithItems(Item ...items) {		
		return new ShoppingCart(Arrays.asList(items));
	}
}
