package com.example.recipe.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.recipe.model.Category;
import com.example.recipe.model.Difficulty;
import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Notes;
import com.example.recipe.model.Recipe;
import com.example.recipe.model.UnitOfMeasure;
import com.example.recipe.repository.CategoryRepository;
import com.example.recipe.repository.RecipeRepository;
import com.example.recipe.repository.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BootStrap implements ApplicationListener<ContextRefreshedEvent>{

	private final CategoryRepository categoryRepo;
	private final UnitOfMeasureRepository uomRepo;
	private final RecipeRepository recipeRepo;
	
	
	
	public BootStrap(CategoryRepository categoryRepo, UnitOfMeasureRepository uomRepo, RecipeRepository recipeRepo) {
		this.categoryRepo = categoryRepo;
		this.uomRepo = uomRepo;
		this.recipeRepo = recipeRepo;
	}
	
	
	private List<Recipe> getRecipe(){
		List<Recipe> recipeList = new ArrayList<>();
		
		Optional<UnitOfMeasure> eachOptional = uomRepo.findByUom("Each");
		if(!eachOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> dashOptional = uomRepo.findByUom("Dash");

		if(!eachOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> teasSpoonOptional = uomRepo.findByUom("TeasSpoon");
		if(!teasSpoonOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> tableSpoonOptional = uomRepo.findByUom("TableSpoon");
		if(!tableSpoonOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> ounceOptional = uomRepo.findByUom("Ounce");
		if(!ounceOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> pinchOptional = uomRepo.findByUom("Pinch");
		if(!pinchOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		Optional<UnitOfMeasure> cupOptional = uomRepo.findByUom("Cup");
		if(!cupOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}

		Optional<UnitOfMeasure> pintOptional = uomRepo.findByUom("Pint");
		if(!pintOptional.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		log.debug("Getting all Units of Measure");
		
		UnitOfMeasure eachUom = eachOptional.get();
		UnitOfMeasure dashUom = dashOptional.get();
		UnitOfMeasure teasSpoonUom = teasSpoonOptional.get();
		UnitOfMeasure tableSpoonUom = tableSpoonOptional.get();
		UnitOfMeasure ounceUom = ounceOptional.get();
		UnitOfMeasure pinchUom = pinchOptional.get();
		UnitOfMeasure cupUom = cupOptional.get();
		UnitOfMeasure pintUom = pintOptional.get();
		
		Optional<Category> americanCategoryOptional = categoryRepo.findByDescription("American");
		if(!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}
		
		
		Optional<Category> maxicanCategoryOptional = categoryRepo.findByDescription("Maxican");
		if(!maxicanCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}
		Optional<Category> italianCategoryOptional = categoryRepo.findByDescription("Italian");
		if(!italianCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}
		Optional<Category> fastFoodCategoryOptional = categoryRepo.findByDescription("Fast Food");
		if(!fastFoodCategoryOptional.isPresent()) {
			throw new RuntimeException("Expected Category not found");
		}
		
		
		Category amricanCategory = americanCategoryOptional.get();
		Category maxicanCategory = maxicanCategoryOptional.get();
		Category italianCategory = italianCategoryOptional.get();
		Category fastFoodCategory = fastFoodCategoryOptional.get();
		
		
		Recipe guacamouli = new Recipe();
		guacamouli.setPerpTime(10);
		guacamouli.setCookTime(0);
		guacamouli.setServeings(2);
		guacamouli.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		guacamouli.setDescription("yummy guacaMole");
		guacamouli.setDifficulty(Difficulty.EASY);
		guacamouli.setDirections("The trick to making perfect guacamole is using ripe avocados that are just the right amount of ripeness. Not ripe enough and the avocado will be hard and tasteless. Too ripe and the taste will be off.\r\n");
		Notes guacNote = new Notes();
		guacNote.setRecipeNotes("Once you have basic guacamole down, feel free to experiment with variations including strawberries, peaches, pineapple, mangoes, even watermelon. One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it ");
		guacNote.setRecipe(guacamouli);
		
		log.debug("setting note to the recipe");
		
		guacamouli.setNotes(guacNote);
		
		guacamouli.getIngredients().add(new Ingredient("Ripe Avcado", new BigDecimal(2), eachUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Kosher Salt", new BigDecimal(.5), teasSpoonUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Lime Juice", new BigDecimal(2), tableSpoonUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Minced Red Onion", new BigDecimal(2), tableSpoonUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Chiles", new BigDecimal(2), eachUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Balck Papper", new BigDecimal(2), dashUom,guacamouli));
		guacamouli.getIngredients().add(new Ingredient("Ripe Tomato", new BigDecimal(.5), eachUom,guacamouli));
		
		
		guacamouli.getCategories().add(amricanCategory);
		guacamouli.getCategories().add(maxicanCategory);
		
		recipeList.add(guacamouli);
		return recipeList;
	}


	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepo.saveAll(getRecipe());
	}

}
