package com.cg.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cg.dto.Product;
import com.cg.exception.ProductNotFoundException;
import com.mongodb.client.result.DeleteResult;

@Repository
public class ProductDaoImpl implements ProductDao {

	private MongoTemplate mongoTemplate;
	
	@Autowired
	public ProductDaoImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Product saveProduct(Product product) {
		mongoTemplate.save(product);
		return product;
	}

	@Override
	public Product getProductById(int id) throws ProductNotFoundException {
		Product p = mongoTemplate.findById(id, Product.class);
		if(p == null)
			throw new ProductNotFoundException("No product found for id: " + id);
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		return mongoTemplate.findAll(Product.class);
	}

	@Override
	public Product updateProduct(Product product) {
		mongoTemplate.save(product);
		return product;
	}

	@Override
	public boolean deleteProduct(int id) throws ProductNotFoundException {
		Product p = mongoTemplate.findById(id, Product.class);
		if(p == null)
			throw new ProductNotFoundException("Invalid product id: " + id);
		DeleteResult result = mongoTemplate.remove(p);
		return result.wasAcknowledged();
	}

}
