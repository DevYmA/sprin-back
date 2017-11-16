package com.yma.pos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yma.pos.dao.CustomerDAO;
import com.yma.pos.entity.Customer;
import com.yma.pos.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerDAO.findAll().forEach(customerList::add);
		
		return customerList;
	}

	@Override
	public Customer findCustomer(int id) {		
		return customerDAO.findOne(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDAO.delete(id);
	}

}
