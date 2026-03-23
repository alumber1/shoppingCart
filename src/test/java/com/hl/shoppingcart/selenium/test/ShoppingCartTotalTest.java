package com.hl.shoppingcart.selenium.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;

import com.hl.shoppingcart.ShoppingCartApplication;
import com.hl.shoppingcart.selenium.page.P_Home;

@SpringBootTest(classes = ShoppingCartApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8082")
public class ShoppingCartTotalTest extends BaseTest {

	@Test
	public void shopingCartTotalUILayoutTest() {
		P_Home.load();
		P_Home.btnGetTotal.click();
		
		P_Home.txtShoppingCartTotal.validate.text("Shopping Cart Total");
		P_Home.txtTotal.validate.text("Total: £81.97");
	}
}
