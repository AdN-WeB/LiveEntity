package com.wcs.liveentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.liveentity.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
