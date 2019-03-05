package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.RequirementProperty;
import com.app.pojo.SellProperty;
import com.app.pojo.SoldProperty;

@Repository
public class SellPropertyDaoImpl implements SellPropertyDao 
{
	@Autowired
	private SessionFactory session;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SellProperty> getAllSellProperties() 
	{
		List<SellProperty> sp = session.getCurrentSession().createQuery("select s from SellProperty s where s.status!='sold'").list();
		return sp;
	}

	@Override
	public RequirementProperty addSellRequirementProperty(RequirementProperty re) 
	{
			session.getCurrentSession().save(re);
			return re;
	}
	
	@Override
	public SellProperty addSellProperty(SellProperty sp) {
		session.getCurrentSession().save(sp);
		return sp;
	}
	
	@Override
	public SellProperty findSellProperty(Integer sellid) 
	{
		return (SellProperty)session.getCurrentSession().createQuery("select s from SellProperty s where s.sellId = :id").setParameter("id", sellid).uniqueResult();
	}
	
	@Override
	public RequirementProperty findReqProperty(Integer reqId) {
		return (RequirementProperty)session.getCurrentSession().createQuery("select r from RequirementProperty r where r.id =:id").setParameter("id",reqId).uniqueResult();
	}
	
	@Override
	public SellProperty updateSellProperty(SellProperty sp) 
	{
		session.getCurrentSession().update(sp);
		return sp;
	}
	
	@Override
	public RequirementProperty updateReqProperty(RequirementProperty r) {
		session.getCurrentSession().update(r);
		return r;
	}
	
	@Override
	public SellProperty deleteSellProperty(SellProperty sp) {
		session.getCurrentSession().delete(sp);
		return sp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RequirementProperty> getAllReqProperties() {
		return session.getCurrentSession().createQuery("select r from RequirementProperty r").list();
	}
	
	@Override
	public SoldProperty addSoldProperty(SoldProperty sp) {
		session.getCurrentSession().save(sp);
		return sp;
	}
	
}
