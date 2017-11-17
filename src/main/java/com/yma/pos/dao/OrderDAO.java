package com.yma.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.yma.pos.entity.Orders;

public interface OrderDAO extends CrudRepository<Orders, Integer>{

	
}
