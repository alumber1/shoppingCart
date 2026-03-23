package com.hl.shoppingcart.selenium.elements;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class E_Text extends E_Base {

	public final TextValidation validate;

	public E_Text(String comment, String xpath, String parent) {
		super(comment, xpath, parent);

		this.validate = new TextValidation();
	}

	public String getText() {
		return findElement().getText();
	}

	public class TextValidation extends Validation<TextValidation> {

		public TextValidation text(String expected) {
			assertEquals(expected, getText(), "Text mismatch: " + getComment());
			return this; 
		}
	}
}
