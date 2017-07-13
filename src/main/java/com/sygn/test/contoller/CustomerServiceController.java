package com.sygn.test.contoller;

import java.util.List;

import com.sygn.test.model.Customer;
import com.sygn.test.model.Product;

public interface CustomerServiceController {

	public Customer createCustomer(Customer customer);
	
    public Customer updateCustomer(Customer customer);
		
    public String deleteCustomer(Integer customerId);
	
    public Customer findCustomerById(Integer customerId);
	
	public List<Customer> getCustomers();
	
	public List<Customer> getCustomersByName(String customerName);
		
}
