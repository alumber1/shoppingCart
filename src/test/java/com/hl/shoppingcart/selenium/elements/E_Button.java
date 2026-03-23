package com.hl.shoppingcart.selenium.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E_Button extends E_Base {

	public final ButtonValidation validate;

	public E_Button(String comment, String xpath, String parent) {
		super(comment, xpath, parent);
		this.validate = new ButtonValidation();
	}

	public void click() {
		findElement().click();
	}

	public String getText() {
		return findElement().getText();
	}

	public class ButtonValidation extends Validation<ButtonValidation> {
		public ButtonValidation text(String expected) {
			assertEquals(expected, getText(), "Button text mismatch: " + getComment());
			return this;
		}
	}
}
