package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.PRICE_MOUSE;
import static com.hl.shoppingcart.TestDataHelper.SINGLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.GBP;
import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.util.Arrays;

import org.junit.Test;

public class ShoppingCartTimestampTest {

	@Test
	public void shouldUseProvidedTimestamp() {
		Instant now = Instant.now();
		ShoppingCart basket = new ShoppingCart(null, now);	
		assertEquals(now, basket.getTimestamp());	
	}
	
	@Test
	public void shouldReturnTimestampInIsoFormat() {
	    Item mouse = new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, PRICE_MOUSE, SINGLE_QUANTITY, GBP);
	    ShoppingCart basket = new ShoppingCart("", "", Instant.parse("2025-09-12T08:45:00Z"), Arrays.asList(mouse));

	    assertEquals("2025-09-12T08:45:00Z", basket.getTimestamp().toString());
	}
}
