package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Customer;
import com.app.pojo.SellProperty;

@Repository
public class CustomerDaoImpl implements CustomerDao 
{
    @Autowired
	private SessionFactory session;
    
	@Override
	public Customer validateCustomer(String id, String pass) 
	{
		Customer cust = (Customer) session.getCurrentSession().createQuery("select c from Customer c where c.loginId = :id and c.password = :pass").setParameter("id", id).setParameter("pass", pass).uniqueResult();
		return cust;
	}

	@Override
	public Customer registerCustomer(Customer c1) 
	{
		session.getCurrentSession().save(c1);
		return c1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SellProperty> getListByCity(String city) 
	{
		List<SellProperty> sp = session.getCurrentSession().createQuery("select s from SellProperty s where s.city=:city").setParameter("city", city).list();
		System.out.println(sp);
		return sp;
	}
	
}
