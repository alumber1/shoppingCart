package com.hl.shoppingcart.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

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

	@Test
	void shouldReturn200AndCorrectTotalForValidCart() throws Exception {
		String payload = readJson("shoppingCartPayload.json");

		mockMvc.perform(post("/api/cart/total")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(81.97))
		.andExpect(jsonPath("$.userId").value("12345"))
		.andExpect(jsonPath("$.cartId").value("abcde-67890"));
	}

	@Test
	void shouldReturnTotal0ForEmptyCart() throws Exception {
		String payload = readJson("shoppingCartEmpty.json");

		mockMvc.perform(post("/api/cart/total")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.total").value(0.00));
	}

	@Test
	void shouldReturnBadRequestForInvalidPayload() throws Exception {
		String payload = "A bad payload";

		mockMvc.perform(post("/api/cart/total")
				.contentType(MediaType.APPLICATION_JSON)
				.content(payload))
		.andExpect(status().isBadRequest());
	}
}