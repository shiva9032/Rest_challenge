package com.sygn.test.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sygn.test.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Product addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product Product = (Product) sessionFactory.getCurrentSession().load(Product.class, productId);
		if (null != Product) {
			this.sessionFactory.getCurrentSession().delete(Product);
		}
	}

	public Product getProduct(int productId) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	}

	@Override
	public Product updateProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return product;
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Product where productName=?");
		query.setParameter(0, productName);
		return query.list();
	}

	@Override
	public List<Product> getProductsByCustomer(int customerId) {
		Query query = sessionFactory.getCurrentSession().createQuery("select product from OrderItems where customer.customerId=?");
		query.setParameter(0, customerId);
		return query.list();
	}

	@Override
	public List<Product> getProductsByOrder(int orderId) {
		Query query = sessionFactory.getCurrentSession().createQuery("select product from OrderItems where order.orderId=?");
		query.setParameter(0, orderId);
		return query.list();
	}

}