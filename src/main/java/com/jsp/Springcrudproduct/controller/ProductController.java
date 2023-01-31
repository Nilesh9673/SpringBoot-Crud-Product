package com.jsp.Springcrudproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Springcrudproduct.dto.ProductDto;
import com.jsp.Springcrudproduct.dto.ResponseStructure;
import com.jsp.Springcrudproduct.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/products")
	public ResponseStructure<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
		return productService.saveProduct(productDto);
	}

	@GetMapping("/products/{id}")
	public ResponseStructure<ProductDto> getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/products")
	public ResponseStructure<List<ProductDto>> getAllProduct() {
		return productService.getAllProduct();
	}

	@DeleteMapping("/products/{id}")
	public ResponseStructure<String> deleteProductById(@PathVariable int id) {
		return productService.deleteProductById(id);
	}

	@PutMapping("/productname/{id}")
	public ResponseStructure<ProductDto> updateNameByid(@PathVariable int id, @RequestBody ProductDto productDto) {
		return productService.updateNameByid(id, productDto);
	}

	@PutMapping("/productprice/{id}")
	public ResponseStructure<ProductDto> updatepriceByid(@PathVariable int id, @RequestBody ProductDto productDto) {
		return productService.updatePriceByid(id, productDto);
	}
}
