package com.example.recipe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import static org.mockito.Matchers.anyLong;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl impl ;
	
	@Mock
	RecipeRepository repository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		impl = new RecipeServiceImpl(repository);
	}
	
	@Test
	void testGetRecipes() {
		Set<Recipe> recipers = impl.getRecipes();
		assertEquals(recipers.size(), 0);
	}
	
	@Test
	void testGetRecipeById() throws Exception {
		Recipe recipe  = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> optionalRecipe  = Optional.of(recipe);
		
		when(repository.findById(anyLong())).thenReturn(optionalRecipe);
		
		Recipe returnedRecipe = impl.findById(1L);
		
		assertNotNull(returnedRecipe);
		
	}

}
