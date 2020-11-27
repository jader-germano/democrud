package com.poc.democrud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestUsuarios {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getsAllUsers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getsSingleUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void returnsNotFoundForInvalidSingleUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/4")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}

	@Test
	public void addsNewUser() throws Exception {
		String newUser = "{\"name\":\"Jader\",\"cpf\":\"03896097148\","+
				"\"role\":\"user\"";
		mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newUser)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
}