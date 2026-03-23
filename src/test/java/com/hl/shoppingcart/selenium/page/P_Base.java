package com.hl.shoppingcart.selenium.page;

import org.openqa.selenium.WebDriver;

import com.hl.shoppingcart.selenium.util.DriverSingleton;

public class P_Base {

	// Static driver shared by all pages
	protected static WebDriver driver = DriverSingleton.getDriver();

	// Static load method
	public static void load(String url) {
		driver.get(url);
	}

	// Static getter for page title
	public static String getTitle() {
		return driver.getTitle();
	}
}
