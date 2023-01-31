package com.jsp.Springcrudproduct.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Springcrudproduct.dto.ProductDto;
import com.jsp.Springcrudproduct.repository.ProductRepositiory;

@Repository
public class ProductDao {
	@Autowired
	ProductRepositiory productRepositiory;

	// save product
	public ProductDto saveProduct(ProductDto product) {
		return productRepositiory.save(product);
	}

	// all product
	public List<ProductDto> getAllProduct() {
		return productRepositiory.findAll();
	}

	// get product by id
	public ProductDto getProductById(int id) {
		Optional<ProductDto> opt = productRepositiory.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	// delete product by id
	public boolean deleteProductById(int id) {
		Optional<ProductDto> opt = productRepositiory.findById(id);
		if (opt.isPresent()) {
			productRepositiory.delete(opt.get());
			return true;
		} else {
			return false;
		}
	}

	// update Product
	public ProductDto updateProductById(int id, ProductDto product) {
		Optional<ProductDto> opt = productRepositiory.findById(id);
		if (opt.isPresent()) {
			return productRepositiory.save(product);
		} else {
			return null;
		}
	}

}
