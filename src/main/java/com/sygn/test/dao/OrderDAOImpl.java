package com.sygn.test.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sygn.test.model.Order;
import com.sygn.test.model.OrderItems;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Order addOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return order;
	}
	
	public OrderItems addOrderItems(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return orderItems;
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	@Override
	public void deleteOrder(Integer orderId) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, orderId);
		if (null != order) {
			this.sessionFactory.getCurrentSession().delete(order);
		}
	}
	
	public void deleteOrderItems(Integer orderId) {
		OrderItems orderItems = (OrderItems) sessionFactory.getCurrentSession().load(OrderItems.class, orderId);
		if (null != orderItems) {
			this.sessionFactory.getCurrentSession().delete(orderItems);
		}
	}

	public Order getOrder(int orderId) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
	}

	@Override
	public Order updateOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return order;
	}
	
	public OrderItems updateOrderItems(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return orderItems;
	}
	
	@Override
	public List<Order> getOrdersByDate(Date date) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Order where orderDate = ?");
		query.setParameter(0, date);
		return query.list();
	}

	@Override
	public List<Order> getOrdersByCustomer(int customerId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Order where customer.customerId=?");
		query.setParameter(0, customerId);
		return query.list();
	}

	@Override
	public List<Order> getOrdersByProduct(int productId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Order where product.productId=?");
		query.setParameter(0, productId);
		return query.list();
	}

	@Override
	public List<Order> getOrdersByCustomerAndProduct(int customerId, int productId) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("select order from OrderItems where product.productId=? and customer.customerId=?");
		query.setParameter(0, productId);
		query.setParameter(1, productId);
		return query.list();
	}

	@Override
	public List<OrderItems> getOrderItemsByOrder(int orderId) {
		Query query = sessionFactory.getCurrentSession().createQuery(" from OrderItems where order.orderId=? ");
		query.setParameter(0, orderId);
		return query.list();
	}

}