package com.sygn.test.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sygn.test.dao.ProductDAO;
import com.sygn.test.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductServiceControllerImpl implements ProductServiceController {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/save")
	public Product addProduct(@RequestBody Product product) {
		product.setProductId(null);
		productDAO.addProduct(product);
		return product;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/update")
	public Product updateProduct(@RequestBody Product product) {
		return productDAO.updateProduct(product);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, path="/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer productId) {
		if(productId == 0){
			return "Product not deleted...";
		}
		productDAO.deleteProduct(productId);
		return "Product deleted successfully";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/get/{id}")
	public Product findProductById(@PathVariable("id") Integer productId) {
		Product product = productDAO.getProduct(productId);
		return product;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/list")
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byName/{name}")
	public List<Product> getProductsByName(@PathVariable("name")String productName) {
		return productDAO.getProductsByName(productName);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byCustomer/{id}")
	public List<Product> getProductsByCustomerId(@PathVariable("id")Integer customerId) {
		return productDAO.getProductsByCustomer(customerId);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byOrder/{id}")
	public List<Product> getProductsByOrderId(@PathVariable("id")Integer orderId) {
		return productDAO.getProductsByOrder(orderId);
	}

}
