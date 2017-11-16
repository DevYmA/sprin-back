package com.yma.pos.dao;

import org.springframework.data.repository.CrudRepository;

import com.yma.pos.entity.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Integer> {

}
