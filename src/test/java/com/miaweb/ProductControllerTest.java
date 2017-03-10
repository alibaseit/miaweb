package com.miaweb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.miaweb.controller.ProductController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
	@Autowired
	private ProductController productController;

	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
	}
    
	@Test
	public void testControllerIsNul() {
	  assertThat(productController).isNotNull();	
	}
	
	@Test
	public void testAllProducts() throws Exception {
		mockMvc.perform(get("/product")).andExpect(status().isOk());
	}

}
