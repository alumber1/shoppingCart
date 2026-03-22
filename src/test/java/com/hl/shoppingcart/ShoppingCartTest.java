package com.hl.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ShoppingCartTest {

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
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionForNegativePrice() {
		ShoppingCart basket = buildCartWithItems(new Item(-49.99, 1));
	}
	
	private ShoppingCart buildCartWithItems(Item ...item) {		
		return new ShoppingCart(Arrays.asList(item));
	}
}
