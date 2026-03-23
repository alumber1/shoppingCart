package com.hl.shoppingcart;

import static com.hl.shoppingcart.TestDataHelper.DOUBLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.KEYBOARD_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.KEYBOARD_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_ID;
import static com.hl.shoppingcart.TestDataHelper.MOUSE_PROD_NAME;
import static com.hl.shoppingcart.TestDataHelper.PRICE_KEYBOARD;
import static com.hl.shoppingcart.TestDataHelper.PRICE_MOUSE;
import static com.hl.shoppingcart.TestDataHelper.SINGLE_QUANTITY;
import static com.hl.shoppingcart.TestDataHelper.TOTAL_DOUBLE_BOTH;
import static com.hl.shoppingcart.TestDataHelper.TOTAL_DOUBLE_MOUSE;
import static com.hl.shoppingcart.TestDataHelper.TOTAL_TWO_ITEMS;
import static com.hl.shoppingcart.TestDataHelper.buildCartWithItems;
import static com.hl.shoppingcart.TestDataHelper.keyboard;
import static com.hl.shoppingcart.TestDataHelper.mouse;
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class ShoppingCartHappyPathTest {

	@Test
	public void shouldReturnZeroWhenCartIsEmpty() {
		ShoppingCart basket = TestDataHelper.buildCartWithItems();
		assertEquals(0.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnTotalForSingleItem() {
		ShoppingCart basket = buildCartWithItems(keyboard(SINGLE_QUANTITY));
		assertEquals(PRICE_KEYBOARD, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnSumOfTotalsForMultipleItems() {
		ShoppingCart basket = buildCartWithItems(keyboard(SINGLE_QUANTITY), mouse(SINGLE_QUANTITY));
		assertEquals(TOTAL_TWO_ITEMS, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalWhenItemHasMultipleQuantities() {
		ShoppingCart basket = buildCartWithItems(mouse(DOUBLE_QUANTITY));
		assertEquals(TOTAL_DOUBLE_MOUSE, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldCalculateTotalForMultipleItemsWithQuantities() {
		ShoppingCart basket = buildCartWithItems(mouse(DOUBLE_QUANTITY), keyboard(DOUBLE_QUANTITY));
		assertEquals(TOTAL_DOUBLE_BOTH, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldReturnEmptyListForWhenCartIsEmpty() {
		ShoppingCart basket = buildCartWithItems();
		assertEquals(Collections.emptyList(), basket.getItems());
	}

	@Test
	public void shouldReturnProdcutId() {
		ShoppingCart basket = buildCartWithItems(keyboard(SINGLE_QUANTITY));
		List<Item> items = basket.getItems();

		assertEquals(items.size(), 1);
		assertEquals(KEYBOARD_PROD_ID , items.get(0).getProductId());		
	}

	@Test
	public void shouldIgnoreItemsWithInvalidQuantityWhenCalculatingTotal() {
		ShoppingCart basket = buildCartWithItems(mouse(DOUBLE_QUANTITY), keyboard(-1));              
		assertEquals(PRICE_MOUSE * DOUBLE_QUANTITY, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldOnlySumItemsWithPositiveQuantity() {
		ShoppingCart basket = buildCartWithItems(mouse(SINGLE_QUANTITY), keyboard(0));
		assertEquals(PRICE_MOUSE, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldRoundTotalToTwoDecimalPlaces() {
		double decimalPrice = 31.9998; 
		ShoppingCart basket = buildCartWithItems(new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, decimalPrice, SINGLE_QUANTITY, null));
		assertEquals(32.0, basket.getTotal(), 0.0);
	}

	@Test
	public void shouldRoundTotalToTwoDecimalPlacesWhenMultipleItemsArePresent() {
		double mouseDecimalPrice = 15.219999999;
		double keyboardDecimalPrice  = 49.56999999;

		Item mouse = new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, mouseDecimalPrice, SINGLE_QUANTITY, null);
		Item keyboard = new Item(KEYBOARD_PROD_ID, KEYBOARD_PROD_NAME, keyboardDecimalPrice, DOUBLE_QUANTITY, null);

		ShoppingCart basket = buildCartWithItems(mouse, keyboard);

		assertEquals(114.36, basket.getTotal(), 0.0);
	}

}
