package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SellPropertyDao;
import com.app.pojo.RequirementProperty;
import com.app.pojo.SellProperty;
import com.app.pojo.SoldProperty;

@Service
@Transactional
public class SellPropertyServiceimpl implements SellPropertyService 
{
	@Autowired
	private SellPropertyDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<SellProperty> getAllSellProperties() 
	{
		return dao.getAllSellProperties();
	}
	
	@Override
	public RequirementProperty addSellRequirementProperty(RequirementProperty re) {
		return dao.addSellRequirementProperty(re);
	}
	
	@Override
	public RequirementProperty updateReqProperty(RequirementProperty r) {
		return dao.updateReqProperty(r);
	}
	@Override
	public SellProperty addSellProperty(SellProperty sp) {
		return dao.addSellProperty(sp);
	}
	
	@Override
	public SellProperty findSellProperty(Integer sellid) {
		return dao.findSellProperty(sellid);
	}
	
	@Override
	public RequirementProperty findReqProperty(Integer reqId) {
		return dao.findReqProperty(reqId);
	}
	
	@Override
	public SellProperty updateSellProperty(SellProperty sp) {
		return dao.updateSellProperty(sp);
	}
	
	@Override
	public SellProperty deleteSellProperty(SellProperty sp) {
		return dao.deleteSellProperty(sp);
	}
	
	@Override
	public List<RequirementProperty> getAllReqProperties() {
		return dao.getAllReqProperties();
	}
	
	@Override
	public SoldProperty addSoldProperty(SoldProperty sp) {
		return dao.addSoldProperty(sp);
	}
}
