package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithUserIdAndItems;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartUserIdTest {

	@Test
	public void shouldStoreUserId() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals("1", basket.getUserId());
	}

	@Test
	public void shouldSetUserIdWhenNull() {
		ShoppingCart basket = new ShoppingCart(null, null, null);
		assertEquals("1", basket.getUserId());
	}

	@Test
	public void shouldSetUserId() {
		ShoppingCart basket = buildCartWithUserIdAndItems("12345");
		assertEquals("12345", basket.getUserId());
	}

}
