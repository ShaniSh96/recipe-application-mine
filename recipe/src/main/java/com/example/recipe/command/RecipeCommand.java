package com.example.recipe.command;

import java.util.HashSet;
import java.util.Set;

import com.example.recipe.model.Difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class RecipeCommand {
	private Long id;
	private String description;
	private Integer cookTime;
	private Integer prepTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	private Set<IngredientCommand> ingredients = new HashSet<>();
	private Difficulty difficulty;
	private NotesCommand notes;
	private Set<CategoryCommand> categories = new HashSet<>();
}
