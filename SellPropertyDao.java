package com.app.dao;

import java.util.List;

import com.app.pojo.RequirementProperty;
import com.app.pojo.SellProperty;
import com.app.pojo.SoldProperty;

public interface SellPropertyDao 
{
	public List<SellProperty> getAllSellProperties();
	
	public List<RequirementProperty> getAllReqProperties();
	
	public RequirementProperty addSellRequirementProperty(RequirementProperty re);
	
	public RequirementProperty findReqProperty(Integer reqId);
	
	public RequirementProperty updateReqProperty(RequirementProperty r);
	
	public SellProperty addSellProperty(SellProperty sp);
	
	public SoldProperty addSoldProperty(SoldProperty sp);
	
	public SellProperty findSellProperty(Integer sellid);
	
	public SellProperty updateSellProperty(SellProperty sp);
	
	public SellProperty deleteSellProperty(SellProperty sp);
}
