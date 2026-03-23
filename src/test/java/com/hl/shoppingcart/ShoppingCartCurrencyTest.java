package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.DOUBLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.PRICE_MOUSE;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ShoppingCartCurrencyTest {

	@Test
	public void shouldSetCurrencyToGbpWhencurrencyIsNull() {
		Item mouse = new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, PRICE_MOUSE, DOUBLE_QUANTITY, null);
		ShoppingCart cart = new ShoppingCart(Arrays.asList(mouse));
		assertEquals("GBP", cart.getItems().get(0).getCurrency());		
	}

	@Test
	public void shouldSetCurrencyToGbpWhencurrencyIsEmpty() {
		Item mouse = new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, PRICE_MOUSE, DOUBLE_QUANTITY, "");
		ShoppingCart cart = new ShoppingCart(Arrays.asList(mouse));
		assertEquals("GBP", cart.getItems().get(0).getCurrency());		
	}

	@Test
	public void shouldSetCurrencyToUSD() {
		Item mouse = new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, PRICE_MOUSE, DOUBLE_QUANTITY, "USD");
		ShoppingCart cart = new ShoppingCart(Arrays.asList(mouse));
		assertEquals("USD", cart.getItems().get(0).getCurrency());		
	}
}
