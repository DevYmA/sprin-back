package com.yma.pos.controller;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yma.pos.entity.Customer;
import com.yma.pos.entity.Orders;
import com.yma.pos.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("customers")
	public List<Customer> saveCustomer(@Valid @RequestBody Customer customer){
		System.out.println("Running Customer Service");
		customerService.save(customer);
		return customerService.findAll();
		/*Set<Orders> orders = new LinkedHashSet<>();
		Customer customer = new Customer(0, "Rick", "Chillow", "078947895", "rick@abc.com", null);
		orders.add(new Orders(0, new Date(2017,9,15), customer));
		orders.add(new Orders(0, new Date(2017,8,9), customer));
		orders.add(new Orders(0, new Date(2017,6,20), customer));
		customer.setOrders(orders);
		customerService.save(customer);
		return "Order added success !";*/
	}
	
	@GetMapping("customers")
	public List<Customer> getAllCutomer(){
		return customerService.findAll();
	}
	
	@GetMapping("customers/{id}")
	public Customer findCustmerById(@PathVariable("id") int id){
		return customerService.findCustomer(id);
	}
	
	@PutMapping("customers/{id}")
	public ResponseEntity<List<Customer>> updateCustomer(@PathVariable("id") int id,@Valid @RequestBody Customer customer){
		Customer customerData = customerService.findCustomer(id);
		if(customerData == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerData.setName(customer.getName());
		customerData.setAddress(customer.getAddress());
		customerData.setEmail(customer.getEmail());
		customerData.setPhone(customer.getPhone());
		return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("customers/{id}")
	public void deleteCustomer(@PathVariable("id") int id){
		customerService.deleteCustomer(id);
	}
	
}
