package com.yma.pos.datatrans;

import java.util.Date;

public class OrdersTrans {

	private String customer_name;
	private Integer id;
	private Date date;
	
	public OrdersTrans() {
		// TODO Auto-generated constructor stub
	}

	public OrdersTrans(String customer_name, Integer id, Date date) {
		super();
		this.customer_name = customer_name;
		this.id = id;
		this.date = date;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
