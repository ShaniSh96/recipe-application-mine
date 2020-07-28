package com.example.recipe.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.recipe.model.Recipe;

//@Service
public class RecipeServiceImpl{ //implements RecipeService{


	protected Map<Long, Recipe> map = new HashMap<>();
	
	//private final RecipeRepository reposiroty;

	//public RecipeServiceImpl() {
		//reposiroty = new RecipeRepositoryImpl();
		 
	//}


	//@Override
	public Recipe findById(Long id) {
		return map.get(id);
	}

	/*
	 * //@Override public Recipe findByTitle(String title) { for(Map.Entry<Long,
	 * Recipe> entry : map.entrySet()) {
	 * if(entry.getValue().getTitle().equals(title)) { return entry.getValue(); } }
	 * return null; }
	 */


	/*
	 * //@Override public Recipe save(Recipe recipe) {
	 * 
	 * recipe.setId(findId());
	 * 
	 * System.out.println("Saving : "+recipe.getId() + ":" + recipe.getTitle());
	 * 
	 * for(Map.Entry<Long, Recipe> entry: map.entrySet()) {
	 * System.out.println(entry.getValue().getTitle() + ":" +
	 * entry.getValue().getRecipe()); }
	 * 
	 * return map.put(recipe.getId(), recipe);
	 * 
	 * }
	 */

	//@Override
	public void delete(Recipe recipe) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(recipe));
	}

	//@Override
	public void deleteAll() {
		map.clear();
	}

	//@Override
	public Set<Recipe> findAll() {
		// TODO Auto-generated method stub
		return new HashSet<>(map.values());
	}
	
	private Long findId() {
		Long myId = null;
		try {
			myId = Collections.max(map.keySet()) + 1;
		}catch(Exception e) {
			myId = 1L;
		}
		return myId;
		
	}

	
	
}
