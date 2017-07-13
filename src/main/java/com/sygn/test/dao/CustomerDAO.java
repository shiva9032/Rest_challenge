package com.sygn.test.dao;

import java.util.List;

import com.sygn.test.model.Customer;

public interface CustomerDAO {

	public Customer addCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public void deleteCustomer(Integer customerId);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomer(int customerId);
	
	public List<Customer> getCustomersByName(String customerName);
}
