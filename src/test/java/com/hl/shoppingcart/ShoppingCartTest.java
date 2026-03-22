package com.hl.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void totalOfEmptyBasket() {
		ShoppingCart basket = new ShoppingCart(new ArrayList());
		assertEquals(0.0, basket.getTotal(), 0.0);
	}
	
	@Test
	public void totalOfSingleItem() {
		ShoppingCart basket = new ShoppingCart(Arrays.asList(new Item(49.99, 1)));
		assertEquals(49.99, basket.getTotal(), 0.0);
	}
	
}
