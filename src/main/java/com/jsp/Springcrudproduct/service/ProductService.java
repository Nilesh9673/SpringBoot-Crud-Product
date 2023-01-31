package com.jsp.Springcrudproduct.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.Springcrudproduct.dao.ProductDao;
import com.jsp.Springcrudproduct.dto.ProductDto;
import com.jsp.Springcrudproduct.dto.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;

	// save product
	public ResponseStructure<ProductDto> saveProduct(ProductDto product) {
		ResponseStructure<ProductDto> responseStructure = new ResponseStructure<>();
		ProductDto productDto = productDao.saveProduct(product);
		responseStructure.setData(productDto);
		responseStructure.setMessage("Product save succesfully");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		return responseStructure;
	}

	// get all product
	public ResponseStructure<List<ProductDto>> getAllProduct() {
		ResponseStructure<List<ProductDto>> responseStructure = new ResponseStructure<>();
		List<ProductDto> product = productDao.getAllProduct();
		if (product.size() > 0) {
			responseStructure.setData(product);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage(" Not Success");

		}
		return responseStructure;
	}

	// get product by id
	public ResponseStructure<ProductDto> getProductById(int id) {
		ResponseStructure<ProductDto> responseStructure = new ResponseStructure<ProductDto>();
		ProductDto productDto = productDao.getProductById(id);
		if (productDto != null) {
			responseStructure.setData(productDto);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Found");
		} else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Not Found");

		}
		return responseStructure;
	}

	// delete product by id
	public ResponseStructure<String> deleteProductById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = productDao.deleteProductById(id);
		if (flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		} else {
			responseStructure.setData("Data Not deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Not Deleted");
		}
		return responseStructure;
	}

	// update name by id
	public ResponseStructure<ProductDto> updateNameByid(int id, ProductDto product) {
		ResponseStructure<ProductDto> responseStructure = new ResponseStructure<ProductDto>();
		ProductDto productDto = productDao.getProductById(id);
		if (productDto != null) {
			productDto.setName(product.getName());
			responseStructure.setData(productDao.updateProductById(id, productDto));
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
		} else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(" Not Updated");
		}
		return responseStructure;
	}

	// update price by id

	public ResponseStructure<ProductDto> updatePriceByid(int id, ProductDto product) {
		ResponseStructure<ProductDto> responseStructure = new ResponseStructure<ProductDto>();
		ProductDto productDto = productDao.getProductById(id);
		if (productDto != null) {
			productDto.setPrice(product.getPrice());
			responseStructure.setData(productDao.updateProductById(id, productDto));
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
		} else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage(" Not Updated");
		}
		return responseStructure;
	}
}
