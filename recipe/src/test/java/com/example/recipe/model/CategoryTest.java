package com.example.recipe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

	Category category ;
	
	@BeforeEach
	public void setUp() {
		category = new Category();
	}
	
	
	@Test
	void testGetId() {
		Long idValue = 5l;
		category.setId(idValue);
		
		
		assertEquals(idValue, category.getId());
	}

	@Test
	void testGetDescription() {
		category.setDescription("blah");
		assertEquals("blah", category.getDescription());
	}

	@Test
	void testGetRecipes() {
		
	}

}
