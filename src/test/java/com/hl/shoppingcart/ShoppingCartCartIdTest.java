package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithUserIdCartIdAndItems;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ShoppingCartCartIdTest {

	@Test
	public void shouldStoreCartId() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals("aaaaa-00001", basket.getCartId());
	}

	@Test
	public void shouldSetCartIdWhenNull() {
		ShoppingCart basket = new ShoppingCart(null, null, null, null);
		assertEquals("aaaaa-00001", basket.getCartId());
	}

	@Test
	public void shouldSetCartId() {
		ShoppingCart basket = buildCartWithUserIdCartIdAndItems(null, "abcde-67890");
		assertEquals("abcde-67890", basket.getCartId());
	}
}
