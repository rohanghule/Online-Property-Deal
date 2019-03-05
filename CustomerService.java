package com.app.service;

import java.util.List;

import com.app.pojo.Customer;
import com.app.pojo.SellProperty;

public interface CustomerService 
{
	Customer validateCustomer(String id, String pass);
	String registerCustomer(Customer c1);
	 List<SellProperty> getListByCity(String city);
}
