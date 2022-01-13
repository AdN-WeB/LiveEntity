package com.wcs.liveentity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.liveentity.dto.ProductDto;
import com.wcs.liveentity.model.Category;
import com.wcs.liveentity.model.Product;
import com.wcs.liveentity.repository.CategoryRepository;
import com.wcs.liveentity.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@PostMapping
	public Product create(@Valid @RequestBody ProductDto productDto) {
		// La liste des catégories associée au produit qui est en train d'être créé.
		List<Category> categories = new ArrayList<>();
		
		// pour chaque ID catégorie dans la liste d'id catégorie dans le DTO
		for (Long idCategory : productDto.getIdsCategory()) {
			// on recup la catégorie, si elle existe, on la met dans la liste des cat
			// associée au product nouvellement créé.
			Optional<Category> optCategory = categoryRepository.findById(idCategory);
			if(optCategory.isPresent()) {
				categories.add(optCategory.get());
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		}
		
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setCategories(categories);
		return productRepository.save(product);
	}

}
