package com.sygn.test.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sygn.test.model.Customer;


@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Customer addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		return customer;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, customerId);
		if (null != customer) {
			this.sessionFactory.getCurrentSession().delete(customer);
		}
	}

	public Customer getCustomer(int customerId) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomersByName() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public List<Customer> getCustomersByName(String customerName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Customer where customerName=?");
		query.setParameter(0, customerName);
		return query.list();
	}

}