package com.wcs.liveentity.dto;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDto {
	@NotBlank
	@Size(min=2, max = 255)
	private String name;
	
	@NotBlank
	@Size(min=5, max = 255)
	private String description;
	
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=3, fraction=2)
	private Float price;
	
	@Min(value = 0)
	private Integer stock;
	
	@Size(min = 1)
	private List<Long> idsCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Long> getIdsCategory() {
		return idsCategory;
	}

	public void setIdsCategory(List<Long> idsCategory) {
		this.idsCategory = idsCategory;
	}
}
