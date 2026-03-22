package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.SINGLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.keyboard;
import static com.hl.shoppingcart.TestDataHelper.mouse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartProductNameTest {

	@Test
	public void shouldReturnEmptyStringWhenProductNameIsNull() {
		ShoppingCart basket = buildCartWithItems(keyboard(null, SINGLE_QUANTITY));
		assertEquals("", basket.getItems().get(0).getProductName());
	}

	@Test
	public void shouldReturnProductNameWhenProductNameIsSet() {
		ShoppingCart basket = buildCartWithItems(mouse(SINGLE_QUANTITY));
		assertEquals("Wireless Mouse", basket.getItems().get(0).getProductName());
	}
	
	@Test
	public void shouldReturnProductNameWithNullsAndSet() {
		ShoppingCart basket = buildCartWithItems(mouse(SINGLE_QUANTITY), keyboard(null, SINGLE_QUANTITY));
		
		assertEquals(basket.getItems().size(), 2);
		assertEquals(basket.getItems().get(0).getProductName(), MOUSE_PROD_NAME);
		assertEquals(basket.getItems().get(1).getProductName(), "");
	}
}
