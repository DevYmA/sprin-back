package com.yma.pos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yma.pos.dao.OrderDAO;
import com.yma.pos.datatrans.OrdersTrans;
import com.yma.pos.entity.Orders;
import com.yma.pos.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;	
	
	@Override
	public List<OrdersTrans> createOrder(Orders orders) {		
		orderDAO.save(orders);		
		return getAllOrders();
	}

	@Override
	public List<OrdersTrans> getAllOrders() {
		List<OrdersTrans> ordersList = new ArrayList<>();
		orderDAO.findAll()
		.forEach(order ->ordersList.add(
				new OrdersTrans(order.getCustomer().getName(), order.getOrders_id(), order.getOrders_date())
				));
		return ordersList;
	}

	
	
}
