package com.hl.shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Unit tests for the ShoppingCart class.
 */
public class ShoppingCartTest {

	private static final String VALID_PRODUCT_ID  = "SKU-001";

	private static final double PRICE_SKU001 = 15.99;
	private static final double PRICE_SKU002 = 49.99;

	private static final int SINGLE_QUANTITY = 1;
	private static final int DOUBLE_QUANTITY = 2;

	private static final double TOTAL_TWO_ITEMS = 65.98;
	private static final double TOTAL_DOUBLE_MOUSE = 31.98;
	private static final double TOTAL_DOUBLE_BOTH = 131.96;

	// ===== Happy Path Tests =====

	@Test
	public void shouldReturnZeroWhenCartIsEmpty() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnTotalForSingleItem() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU002, SINGLE_QUANTITY));
		assertEquals(PRICE_SKU002, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnSumOfTotalsForMultipleItems() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU002, SINGLE_QUANTITY), new Item(VALID_PRODUCT_ID , PRICE_SKU001, SINGLE_QUANTITY));
		assertEquals(TOTAL_TWO_ITEMS, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalWhenItemHasMultipleQuantities() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU001, DOUBLE_QUANTITY));
		assertEquals(TOTAL_DOUBLE_MOUSE, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalForMultipleItemsWithQuantities() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU001, DOUBLE_QUANTITY), new Item(VALID_PRODUCT_ID , PRICE_SKU002, DOUBLE_QUANTITY));
		assertEquals(TOTAL_DOUBLE_BOTH, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnEmptyListForWhenCartIsEmpty() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals(Collections.emptyList(), basket.getItems());
	}

	@Test
	public void shouldReturnListForThenCartHasOneItem() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU002, SINGLE_QUANTITY));
		List<Item> items = basket.getItems();

		assertEquals(items.size(), 1);
		assertEquals(VALID_PRODUCT_ID , items.get(0).getProductId());		
	}

	// ===== Validation / Edge Case Tests =====

	/**
	 * For demonstration purposes, this test throws an exception for negative price.
	 * In a production scenario, we could instead treat negative values as zero to handle gracefully.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNegativePrice() {
		buildCartWithItems(new Item(VALID_PRODUCT_ID , -PRICE_SKU002, SINGLE_QUANTITY));
	}

	@Test
	public void shouldTreatNegativeQuantityAsZero() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU002, -1));
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldTreatZeroQuantityAsZero() {
		ShoppingCart basket = buildCartWithItems(new Item(VALID_PRODUCT_ID , PRICE_SKU002, 0));
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	/**
	 * Handling null gracefully by returning 0 for the total.
	 * In a stricter design, we could throw an exception instead, but here we treat null as an empty cart.
	 */
	@Test
	public void shouldReturnZeroForNullItems() {
		ShoppingCart basket = new ShoppingCart(null);
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnEmptyItemForWhenCartIsEmpty() {
		ShoppingCart basket = new ShoppingCart(null);

		assertTrue(basket.getItems().isEmpty());
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
