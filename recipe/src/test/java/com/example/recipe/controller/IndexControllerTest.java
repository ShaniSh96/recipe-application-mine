package com.example.recipe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.example.recipe.service.RecipeService;

class IndexControllerTest {

	IndexController controller;
	
	@Mock
	RecipeService service;
	@Mock
	Model model;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(service);
	}
	
	
	@Test
	void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"));
		
	}
	
	@Test
	void testGetRecipeList() {

		assertEquals(controller.getRecipeList(model), "index");
		
		
		verify(service,times(1)).getRecipes();
	}

}
