package com.sygn.test.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sygn.test.dao.CustomerDAO;
import com.sygn.test.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerServiceControllerImpl implements CustomerServiceController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@RequestMapping(method = RequestMethod.GET, path="/list")                           
	public List<Customer> getCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/get/{id}")
	public Customer findCustomerById(@PathVariable("id") Integer customerId) {
		Customer customer = customerDAO.getCustomer(customerId);
		return customer;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/save")
	public Customer createCustomer(@RequestBody Customer customer) {
		customer.setCustomerId(null);
		customerDAO.addCustomer(customer);
		return customer;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerDAO.updateCustomer(customer);
	}
	
	@Override
	@RequestMapping(method = RequestMethod.PUT, path="/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Integer customerId){
		if(customerId == 0){
			return "Customer not deleted...";
		}
		customerDAO.deleteCustomer(customerId);
		return "Customer deleted successfully";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byName/{name}")
	public List<Customer> getCustomersByName(@PathVariable("name")String customerName) {
		return customerDAO.getCustomersByName(customerName);
	}
}
