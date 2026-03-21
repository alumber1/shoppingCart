package com.hl.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void totalOfEmptyBasket() {
		ShoppingCart basket = new ShoppingCart();
		assertEquals(0.0, basket.getTotal(), 0.0);
	}
}
