package com.sygn.test.dao;

import java.util.Date;
import java.util.List;

import com.sygn.test.model.Order;
import com.sygn.test.model.OrderItems;

public interface OrderDAO {

	public Order addOrder(Order order);
	
	public OrderItems addOrderItems(OrderItems orderItems);

	public List<Order> getAllOrders();

	public void deleteOrder(Integer orderId);
	
	public void deleteOrderItems(Integer orderItemId);

	public Order updateOrder(Order order);
	
	public OrderItems updateOrderItems(OrderItems orderItems);

	public Order getOrder(int orderId);
	
	public List<Order> getOrdersByDate(Date orderDate);
	
	public List<Order> getOrdersByCustomer(int customerId);
	
	public List<Order> getOrdersByProduct(int productId);
	
	public List<Order> getOrdersByCustomerAndProduct(int customerId, int productId);
	
	public List<OrderItems> getOrderItemsByOrder(int orderId);
	
	
}
