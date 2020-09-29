package com.example.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.command.IngredientCommand;
import com.example.recipe.command.RecipeCommand;
import com.example.recipe.command.UnitOfMeasureCommand;
import com.example.recipe.service.IngredientService;
import com.example.recipe.service.RecipeService;
import com.example.recipe.service.UnitOfMeasureService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IngredientController {

	private final RecipeService recipeService;
	private final IngredientService ingredientService;
	private final UnitOfMeasureService uomService;
	
	public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService uomService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
		this.uomService = uomService;
	}
	
	@RequestMapping("/recipe/{id}/ingredients")
	public String listIngredient(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandByID(Long.valueOf(id)));
		
		return "recipe/ingredient/list";
	}
	
	@RequestMapping("/recipe/{recipeId}/ingredient/{ingredienetId}/show")
	public String showRecipeIngredient(@PathVariable String recipeId, 
									  @PathVariable String ingredienetId, Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(ingredienetId)));
		return "recipe/ingredient/show";
	}
	
	@RequestMapping("/recipe/{recipeId}/ingredient/{ingredienetId}/update")
	public String updateRecipeIngredient(@PathVariable String recipeId, 
									  @PathVariable String ingredienetId, Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndId(Long.valueOf(recipeId), Long.valueOf(ingredienetId)));

		model.addAttribute("uomList", uomService.listAllUoms());
		return "recipe/ingredient/ingredientform";
	}
	
	@PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
	
	
	@RequestMapping("recipe/{recipeId}/ingredient/new")
	public String newRecipe(@PathVariable String recipeId, Model model) {
		RecipeCommand recipeCommand = recipeService.findCommandByID(Long.valueOf(recipeId));
		
		IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setRecipeId(Long.valueOf(recipeId));
		model.addAttribute("ingredient",ingredientCommand);
		
		ingredientCommand.setUom(new UnitOfMeasureCommand());
		model.addAttribute("uomList", uomService.listAllUoms());
		return "recipe/ingredient/ingredientform";	
		
	}
}
