package com.sygn.test.contoller;

import java.util.List;

import com.sygn.test.model.Product;

public interface ProductServiceController {
	
	public Product addProduct(Product product);
	
    public Product updateProduct(Product product);

    public String deleteProduct(Integer productId);
		
	public Product findProductById(Integer productId);
	
	public List<Product> getAllProducts();
	
	public List<Product> getProductsByName(String productName);
	
	public List<Product> getProductsByCustomerId(Integer customerId);
	
	public List<Product> getProductsByOrderId(Integer orderId);

}
