package com.wcs.liveentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.liveentity.model.CartLine;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {

}
