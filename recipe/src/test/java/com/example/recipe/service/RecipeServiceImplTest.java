package com.example.recipe.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.recipe.model.Category;
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

}
