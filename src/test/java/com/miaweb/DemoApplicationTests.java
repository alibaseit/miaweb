package com.miaweb;

import com.miaweb.controller.DenemeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired
	private DenemeController denemeController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		assertThat(denemeController).isNotNull();
	}

	@Test
	public void testDenemeControllerContainAnyText() throws Exception {
        mockMvc.perform(get("/deneme/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hi")));
    }

}
