package com.sygn.test.dao;

import java.util.List;

import com.sygn.test.model.Product;

public interface ProductDAO {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public void deleteProduct(Integer productId);

	public Product updateProduct(Product product);

	public Product getProduct(int productId);
	
	public List<Product> getProductsByName(String productName);
	
	public List<Product> getProductsByCustomer(int customerId);
	
	public List<Product> getProductsByOrder(int orderId);
	
}
