package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.SINGLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.PRICE_MOUSE;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.keyboard;
import static com.hl.shoppingcart.TestDataHelper.mouse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartProductNameTest {

	// ===== Positive product name tests =====
	
	@Test
	public void shouldReturnProductNameWhenProductNameIsSet() {
		ShoppingCart basket = buildCartWithItems(mouse(SINGLE_QUANTITY));
		assertEquals("Wireless Mouse", basket.getItems().get(0).getProductName());
	}
	
	@Test
	public void shouldAllowSpecialCharactersInProductName() {
	    String specialName = "!$%^Éclair^&$*()^$% Mouse";
	    ShoppingCart basket = buildCartWithItems(new Item(MOUSE_PROD_ID, specialName, PRICE_MOUSE, SINGLE_QUANTITY));
	    assertEquals(specialName, basket.getItems().get(0).getProductName());
	}
	
	@Test
	public void shouldHandleVeryLongProductName() {
	    String longName = "A".repeat(10000);
	    ShoppingCart basket = buildCartWithItems(new Item(MOUSE_PROD_ID, longName, PRICE_MOUSE, SINGLE_QUANTITY));
	    assertEquals(longName, basket.getItems().get(0).getProductName());
	}
	
	@Test
	public void shouldPreserveWhitespaceProductName() {
	    String name = "   ";
	    ShoppingCart basket = buildCartWithItems(keyboard(name, SINGLE_QUANTITY));
	    assertEquals(name, basket.getItems().get(0).getProductName());
	}
	
	// ===== Null / empty product name tests =====
	
	@Test
	public void shouldReturnEmptyStringForNullProductName() {
		ShoppingCart basket = buildCartWithItems(keyboard(null, SINGLE_QUANTITY));
		assertEquals("", basket.getItems().get(0).getProductName());
	}

	@Test
	public void shouldReturnEmptyStringWhenProductNameIsEmpty() {
	    ShoppingCart basket = buildCartWithItems(keyboard("", SINGLE_QUANTITY));
	    assertEquals("", basket.getItems().get(0).getProductName());
	}
	
	@Test
	public void shouldHandleMixedNullAndValidProductNames() {
		ShoppingCart basket = buildCartWithItems(mouse(SINGLE_QUANTITY), keyboard(null, SINGLE_QUANTITY));
		
		assertEquals(2, basket.getItems().size());
		assertEquals(MOUSE_PROD_NAME, basket.getItems().get(0).getProductName());
		assertEquals("",basket.getItems().get(1).getProductName());
	}
	
	// ===== Null / empty product name tests =====
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenProductIdIsEmptyEvenIfProductNameIsNull() {
	    new Item("", null, PRICE_MOUSE, SINGLE_QUANTITY);
	}
	
}
