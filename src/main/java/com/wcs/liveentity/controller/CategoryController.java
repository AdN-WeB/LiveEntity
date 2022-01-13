package com.wcs.liveentity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.liveentity.dto.CategoryDto;
import com.wcs.liveentity.model.Category;
import com.wcs.liveentity.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping
	public Category create(@Valid @RequestBody CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDisplayOrder(categoryDto.getDisplayOrder());
		return categoryRepository.save(category);
	}
}
