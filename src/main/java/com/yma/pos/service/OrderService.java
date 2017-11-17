package com.yma.pos.service;

import java.util.List;

import com.yma.pos.datatrans.OrdersTrans;
import com.yma.pos.entity.Orders;

public interface OrderService {

	public List<OrdersTrans> createOrder(Orders orders);
	public List<OrdersTrans> getAllOrders ();
}
