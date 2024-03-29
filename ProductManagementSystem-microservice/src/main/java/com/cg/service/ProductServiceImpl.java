package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ProductDao;
import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Product addProduct(Product product) {
		return dao.saveProduct(product);
	}

	@Override
	public Product fetchProductById(int id) throws ProductNotFoundException {
		return dao.getProductById(id);
	}

	@Override
	public List<Product> fetchAllProduct() {
		return dao.getAllProduct();
	}

	@Override
	public Product updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public boolean removeProduct(int id) throws ProductNotFoundException {
		return dao.deleteProduct(id);
	}

}
