package com.example.recipe.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.recipe.command.NotesCommand;
import com.example.recipe.model.Notes;

import lombok.Synchronized;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes>{

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		if(source == null)
			return null;
		
		Notes note = new Notes();
		note.setId(source.getId());
		note.setRecipeNotes(source.getRecipeNote());
		
		return note;
	}

}
