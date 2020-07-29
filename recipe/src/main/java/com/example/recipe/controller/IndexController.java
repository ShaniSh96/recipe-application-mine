package com.example.recipe.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.recipe.model.Category;
import com.example.recipe.model.UnitOfMeasure;
import com.example.recipe.repository.CategoryRepository;
import com.example.recipe.repository.UnitOfMeasureRepository;

@Controller
public class IndexController {
	
	private CategoryRepository categoryRepo;
	private UnitOfMeasureRepository unitOfMeasureRepo;
	
	
	public IndexController(CategoryRepository categoryRepo, UnitOfMeasureRepository unitOfMeasureRepo) {
		this.categoryRepo = categoryRepo;
		this.unitOfMeasureRepo = unitOfMeasureRepo;
	}



	@RequestMapping({" ","/","index","index.html"})
	public String getRecipeList(Model model) {
		
		Optional<Category> categoryOptionaal = categoryRepo.findByDescription("Italian");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepo.findByUom("Ounce");
		
		System.out.println("Category ID :"+categoryOptionaal.get().getId());
		System.out.println("Unit Of Measure ID :"+unitOfMeasureOptional.get().getId());
		return "index";
		
	}
}
