package com.hl.shoppingcart;
import java.util.Arrays;

/**
 * Provides reusable test data and helper methods for shopping cart tests.
 * 
 * Includes product IDs, names, prices, quantities, total values, and methods to create
 * {@link Item} instances or {@link ShoppingCart} instances for tests.
 */
public class TestDataHelper {

	public static final String MOUSE_PROD_ID  = "SKU-001";
	public static final String KEYBOARD_PROD_ID  = "SKU-002";

	public static final String MOUSE_PROD_NAME = "Wireless Mouse";
	public static final String KEYBOARD_PROD_NAME = "Mechanical Keyboard";

	public static final String  GBP = "GBP";

	public static final double PRICE_MOUSE = 15.99;
	public static final double PRICE_KEYBOARD = 49.99;

	public static final int SINGLE_QUANTITY = 1;
	public static final int DOUBLE_QUANTITY = 2;

	public static final double TOTAL_TWO_ITEMS = 65.98;
	public static final double TOTAL_DOUBLE_MOUSE = 31.98;
	public static final double TOTAL_DOUBLE_BOTH = 131.96;

	/**
	 * Helper method to create a new shopping cart with the given items.
	 *
	 * @param items the items to include in the shopping cart
	 * @return a new ShoppingCart containing the given items
	 */
	public static ShoppingCart buildCartWithItems(Item ...items) {		
		return new ShoppingCart(Arrays.asList(items));
	}

	/**
	 * Helper method to create a new shopping cart with the given user and  items.
	 *
	 * @param userId the user ID for the shopping cart
	 * @param items the items to include in the shopping cart
	 * @return a new ShoppingCart containing the given items
	 */
	public static ShoppingCart buildCartWithUserIdAndItems(String userId, Item ...items) {		
		return new ShoppingCart(userId, null, null, Arrays.asList(items));
	}

	/**
	 * Helper method to create a new shopping cart with the given user and  items.
	 *
	 * @param userId the user ID for the shopping cart
	 * @param items the items to include in the shopping cart
	 * @return a new ShoppingCart containing the given items
	 */
	public static ShoppingCart buildCartWithUserIdCartIdAndItems(String userId, String cartId, Item ...items) {		
		return new ShoppingCart(userId, cartId, null, Arrays.asList(items));
	}

	/**
	 * Creates a mouse item with the specified quantity.
	 *
	 * @param quantity number of mouse items
	 * @return new Item representing a mouse
	 */
	public static Item mouse(int quantity) {
		return new Item(MOUSE_PROD_ID, MOUSE_PROD_NAME, PRICE_MOUSE, quantity, null);
	}

	/**
	 * Creates a keyboard item with the default product name (product ID used).
	 *
	 * @param quantity number of keyboard items
	 * @return new Item representing a keyboard
	 */
	public static Item keyboard(int quantity) {
		return new Item(KEYBOARD_PROD_ID, KEYBOARD_PROD_NAME, PRICE_KEYBOARD, quantity, null);
	}

	/**
	 * Creates a keyboard item with a custom product name.
	 *
	 * @param productName name of the keyboard
	 * @param quantity number of keyboard items
	 * @return new Item representing a keyboard with the specified name
	 */
	public static Item keyboard(String productName, int quantity) {
		return new Item(KEYBOARD_PROD_ID, productName, PRICE_KEYBOARD, quantity, null);
	}
}
