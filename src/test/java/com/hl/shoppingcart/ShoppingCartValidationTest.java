package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.GBP;
import static com.hl.shoppingcart.TestDataHelper.KEYBOARD_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.KEYBOARD_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.PRICE_KEYBOARD;
import static com.hl.shoppingcart.TestDataHelper.PRICE_MOUSE;
import static com.hl.shoppingcart.TestDataHelper.SINGLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.keyboard;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ShoppingCartValidationTest {

	/**
	 * For demonstration purposes, this test throws an exception for negative price.
	 * In a production scenario, we could instead treat negative values as zero to handle gracefully.
	 */
	@Test
	public void shouldThrowExceptionWhenPriceIsNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			buildCartWithItems(new Item(KEYBOARD_PROD_ID, KEYBOARD_PROD_NAME, -PRICE_KEYBOARD, SINGLE_QUANTITY, GBP));
		});
	}	

	@Test
	public void shouldReturnZeroWhenQuantityIsNegative() {
		ShoppingCart basket =  buildCartWithItems(keyboard(-1));
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnZeroWhenQuantityIsZero() {
		ShoppingCart basket =  buildCartWithItems(new Item(KEYBOARD_PROD_ID, KEYBOARD_PROD_NAME, PRICE_KEYBOARD, 0, GBP));
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldThrowExceptionWhenProductIdIsEmpty() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", KEYBOARD_PROD_ID, PRICE_MOUSE, SINGLE_QUANTITY, GBP);
		});
	}

	/**
	 * Handling null gracefully by returning 0 for the total.
	 * In a stricter design, we could throw an exception instead, but here we treat null as an empty cart.
	 */
	@Test
	public void shouldReturnZeroWhenCartIsNull() {
		ShoppingCart basket = new ShoppingCart(null, null, null, null);
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnEmptyListWhenCartIsNull() {
		ShoppingCart basket = new ShoppingCart(null, null, null, null);
		assertTrue(basket.getItems().isEmpty());
	}
}
