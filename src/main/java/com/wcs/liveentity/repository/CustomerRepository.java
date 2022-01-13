package com.wcs.liveentity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.liveentity.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
