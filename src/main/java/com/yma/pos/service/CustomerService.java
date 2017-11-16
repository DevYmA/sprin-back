package com.yma.pos.service;

import java.util.List;

import com.yma.pos.entity.Customer;

public interface CustomerService {

	public void save(Customer customer);
	public List<Customer> findAll();
	public Customer findCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
}
