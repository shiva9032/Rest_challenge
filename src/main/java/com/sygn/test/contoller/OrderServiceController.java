package com.sygn.test.contoller;

import java.util.List;

import com.sygn.test.model.Order;
import com.sygn.test.model.OrderItems;

public interface OrderServiceController {
	
	public Order addOrder(Order order);
	
	public OrderItems addOrderItems(OrderItems orderItems);
	
    public Order updateOrder(Order order);
    
    public OrderItems updateOrderItems(OrderItems orderItems);
		
    public String deleteOrder(Integer orderId);
    
    public String deleteOrderItems(Integer orderItemId);
	
    public Order findOrderById(Integer orderId);
	
	public List<Order> getOrders();
	  
	public List<Order> getOrdersByDate(String orderDate);
	
	public List<Order> getOrdersByCustomer(Integer customerId);
	
	public List<Order> getOrdersByProduct(Integer productId);
	
	public List<OrderItems> getOrderItemsByOrder(Integer orderId);
	
	public List<Order> getOrdersByCustomerAndProduct(int customerId, int productId);

}
