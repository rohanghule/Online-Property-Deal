package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.pojo.Customer;
import com.app.pojo.SellProperty;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public Customer validateCustomer(String id, String pass) 
	{
		return dao.validateCustomer(id, pass);
	}

	@Override
	public String registerCustomer(Customer c1) 
	{
		Customer c = dao.registerCustomer(c1);
		if(c.getId()==null)
			return "register";
		return c.getName();
	}
	
	@Override
	public List<SellProperty> getListByCity(String city) {
		return dao.getListByCity(city);
	}
}
