package com.app.dao;

import java.util.List;

import com.app.pojo.Customer;
import com.app.pojo.SellProperty;

public interface CustomerDao 
{
	Customer validateCustomer(String id, String pass);

	Customer registerCustomer(Customer c1);
	
	List<SellProperty> getListByCity(String city);
}
