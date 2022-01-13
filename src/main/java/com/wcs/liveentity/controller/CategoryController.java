package com.wcs.liveentity.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.liveentity.dto.CategoryDto;
import com.wcs.liveentity.model.Category;
import com.wcs.liveentity.model.Product;
import com.wcs.liveentity.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
	@PostMapping
	public Category create(@Valid @RequestBody CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDisplayOrder(categoryDto.getDisplayOrder());
		return categoryRepository.save(category);
	}
	
	@GetMapping("/{id}/products")
	public List<Product> getProductsFromCategory(@PathVariable(required = true) Long id){
		// on va chercher la category, si elle n'existe pas, on lance une exception
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		// on retourne la liste de produits liée à la catégorie.
		return category.getProducts();
	}
}
