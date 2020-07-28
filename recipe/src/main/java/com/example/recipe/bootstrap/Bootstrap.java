package com.example.recipe.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;

@Component
public class Bootstrap implements CommandLineRunner {


	 private final RecipeRepository repository;
	 
	 
	public Bootstrap(RecipeRepository repository) {
		this.repository = repository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 
		/*
		 * Recipe recipe1 = new Recipe(); recipe1.setTitle("Biriyani");
		 * recipe1.setRecipe("adasdfs SGJEQ KJ wiheir ,adiwhrw fiuwehro");
		 * repository.save(recipe1); System.out.println("Recipe 1 added...");
		 * 
		 * 
		 * Recipe recipe2 = new Recipe(); recipe2.setTitle("Pani Puri");
		 * recipe2.setRecipe("trhfb  SG34565 fghlskg ni iwhrw fiuwehro");
		 * repository.save(recipe2); System.out.println("Recipe 2 added...");
		 */
		 
	}
	

}
