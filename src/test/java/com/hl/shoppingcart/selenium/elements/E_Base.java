package com.hl.shoppingcart.selenium.elements;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hl.shoppingcart.selenium.util.DriverSingleton;

public class E_Base {

	protected static WebDriver driver = DriverSingleton.getDriver();

	private String comment;
	private String xpath;
	private String parent;

	public E_Base(String comment, String xpath, String parent) {
		this.comment = comment;
		this.xpath = xpath;
		this.parent = parent;
	}

	public WebElement findElement() {
		return driver.findElement(By.xpath(parent + xpath));
	}

	public String getComment() {
		return comment;
	}

	public class Validation<T extends Validation<T>> {
		@SuppressWarnings("unchecked")
		public T visible() {
			assertTrue(findElement().isDisplayed(), comment + " should be visible");
			return (T) this;
		}

		@SuppressWarnings("unchecked")
		public T enabled() {
			assertTrue(findElement().isEnabled(), comment + " should be enabled");
			return (T) this;
		}
	}
}
