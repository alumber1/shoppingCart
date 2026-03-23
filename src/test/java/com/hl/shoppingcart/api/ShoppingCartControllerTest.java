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
    
    @Test
    void shouldReturnTotalForValidCart() throws Exception {
    	String payload = readJson("shoppingCartPayload.json");
    	
    	 mockMvc.perform(post("/api/cart/total")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content(payload))
                 .andExpect(jsonPath("$.total").value(81.97));
     }
	
    private String readJson(String path) throws Exception {
        ClassPathResource resource = new ClassPathResource(path);
        return Files.readString(resource.getFile().toPath());
    }
}
