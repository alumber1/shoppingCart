package com.hl.shoppingcart.selenium.page;

import com.hl.shoppingcart.selenium.elements.E_Button;
import com.hl.shoppingcart.selenium.elements.E_Text;

public class P_Home extends P_Base {

	public static String parent = ".//html/body";

	public static E_Text txtShoppingCartTotal = new E_Text("Shopping Cart Total Text", "//h2", parent);
	public static E_Text txtTotal = new E_Text("Shopping Cart Total Text", "//p[@id=\"result\"]", parent);
	public static E_Button btnGetTotal = new E_Button("Get Total  button", "//button[text()='Get Total']", parent);

	public static void load() {
		P_Base.load("http://localhost:8080/");
	}

	public static String getTitle() {
		return P_Base.getTitle();
	}

}