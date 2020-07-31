package com.example.recipe.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
	void testGetRecipeList() {

		assertEquals(controller.getRecipeList(model), "index");
	}

}
