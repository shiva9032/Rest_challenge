package com.sygn.test.contoller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sygn.test.dao.OrderDAO;
import com.sygn.test.model.Order;
import com.sygn.test.model.OrderItems;

@RestController
@RequestMapping("/api/orders")
public class OrderServiceControllerImpl implements OrderServiceController{
	
	@Autowired
	private OrderDAO orderDAO;

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/save")
	public Order addOrder(@RequestBody Order order) {
		order.setOrderId(null);
		orderDAO.addOrder(order);
		return order;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/update")
	public Order updateOrder(@RequestBody Order order) {
		return orderDAO.updateOrder(order);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, path="/delete/{id}")
	public String deleteOrder(@PathVariable("id") Integer orderId) {
		if(orderId == 0){
			return "Order not deleted...";
		}
		orderDAO.deleteOrder(orderId);
		return "Order deleted successfully";
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/get/{id}")
	public Order findOrderById(@PathVariable("id") Integer orderId) {
		Order Order = orderDAO.getOrder(orderId);
		return Order;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/list")
	public List<Order> getOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byDate/{date}")
	public List<Order> getOrdersByDate(@PathVariable("date") String date) {
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date orderDate = simpleDateFormat.parse(date);
			return orderDAO.getOrdersByDate(orderDate);
		}catch(Exception e){}
		return new ArrayList<Order>();
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byCustomer/{id}")
	public List<Order> getOrdersByCustomer(@PathVariable("id") Integer customerId) {
		return orderDAO.getOrdersByCustomer(customerId);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byProduct/{id}")
	public List<Order> getOrdersByProduct(@PathVariable("id") Integer productId) {
		return orderDAO.getOrdersByProduct(productId);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byOrder/{id}")
	public List<OrderItems> getOrderItemsByOrder(@PathVariable("id") Integer orderId) {
		return orderDAO.getOrderItemsByOrder(orderId);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, path="/byCutomerProduct/{customerId}/{productId}")
	public List<Order> getOrdersByCustomerAndProduct(@PathVariable("customerId") int customerId,
													 @PathVariable("productId") int productId) {
		return orderDAO.getOrdersByCustomerAndProduct(customerId, productId);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST, path="/items/save")
	public OrderItems addOrderItems(@RequestBody OrderItems orderItems) {
		orderItems.setOrderItemId(null);
		orderDAO.addOrderItems(orderItems);
		return orderItems;
	}

	@Override
	public OrderItems updateOrderItems(OrderItems orderItems) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrderItems(Integer orderItemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
