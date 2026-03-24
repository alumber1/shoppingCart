package com.hl.shoppingcart.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.file.Files;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/** Utility to read JSON payloads from test resources */
	private String readJson(String path) throws Exception {
		ClassPathResource resource = new ClassPathResource(path);
		return Files.readString(resource.getFile().toPath());
	}
	
	private ResultActions postCart(String payload) throws Exception {
	    return mockMvc.perform(post("/api/cart/total")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(payload));
	}

	@Test
	void shouldReturn200AndCorrectTotalForValidCart() throws Exception {
		String payload = readJson("shoppingCartPayload.json");
		
		postCart(payload)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(81.97))
		.andExpect(jsonPath("$.userId").value("12345"))
		.andExpect(jsonPath("$.cartId").value("abcde-67890"));
	}

	@Test
	void shouldReturn200AndCorrectTotalforOneItem() throws Exception {
		String payload = readJson("shoppingCartPayloadOneItem.json");

		postCart(payload)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(31.98))
		.andExpect(jsonPath("$.userId").value("6789"))
		.andExpect(jsonPath("$.cartId").value("fghij-12345"));
	}

	@Test
	void shouldReturnTotal0ForEmptyCart() throws Exception {
		String payload = readJson("shoppingCartEmpty.json");
		postCart(payload)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(0.00));
	}

	@Test
	void shouldReturnBadRequestForInvalidPayload() throws Exception {
		String payload = "A bad payload";

		postCart(payload)
		.andExpect(status().isBadRequest());
	}
	
	@Test
	void shouldReturnBadRequestForNegativePayloads() throws Exception {
		String payload = readJson("shoppingCartInvalidNegativePrice.json");

		postCart(payload)
		.andExpect(status().isBadRequest());
	}

	@Test
	void shouldDefaultCurrencyWhenMissing() throws Exception {
		String payload = readJson("shoppingCartMissingCurrency.json");

		postCart(payload)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").exists());
	}

	@Test
	void shouldHandleMissingTimestamp() throws Exception {
		String payload = readJson("shoppingCartMissingTimestamp.json");

		postCart(payload)
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(81.97));
	}
	
	@Test
	void shouldReturnBadRequestForBrokenPayloads() throws Exception {
		String brokenJson = """
				{
				  "userId": "12345"
				  "cartId": "abcde-67890"
				  "items": [
				    {
				      "productId": "SKU-001",
				      "productName": "Wireless Mouse",
				      "quantity": 2,
				      "price": 15.99,
				      "currency": "GBP"
				    }
				    {
				      "productId": "SKU-002",
				      "productName": "Mechanical Keyboard",
				      "quantity": 1,
				      "price": 49.99,
				      "currency": "GBP"
				    }
				  "timestamp": "2025-09-12T08:45:00Z"
				}
				""";

		postCart(brokenJson)
		.andExpect(status().isBadRequest());
	}
}