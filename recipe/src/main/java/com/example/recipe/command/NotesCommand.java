package com.example.recipe.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class NotesCommand {
	private Long id;
	private String recipeNotes;
}
