package com.jsp.Springcrudproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Springcrudproduct.dto.ProductDto;

public interface ProductRepositiory extends JpaRepository<ProductDto, Integer> {

}
