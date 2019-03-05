package com.app.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojo.Customer;
import com.app.pojo.RequirementProperty;
import com.app.pojo.SellProperty;
import com.app.pojo.SoldProperty;
import com.app.service.SellPropertyService;


@Controller
@RequestMapping("/prop")
public class SellPropertyController 
{
	@Autowired
	private SellPropertyService service;
	
	@RequestMapping("/list")
	public String listAll(ModelMap map, SellProperty s) 
	{
		System.out.println("in list categories");
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "user";
	}
	
	@RequestMapping("/admin")
	public String showAdminForm(Customer c, Model map)
	{
		return "admin";
	}
	
	@RequestMapping(value="/admin",method=RequestMethod.POST)
	public String processAdminForm(Customer c, Model map)
	{
		return "admin";
	}
	
	
	@RequestMapping("/allproperty")
	public String showAllPropery(ModelMap map, SellProperty s) 
	{
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "admin/allproperty" ;
	}
	
	/*@ModelAttribute
	public String showPropery(Model map) 
	{
		map.addAttribute("sellProperty",new SellProperty() );
		return "admin/addproperty" ;
	}*/
	
	@RequestMapping(value="/allprop1",method=RequestMethod.POST)
	public String showAllUpdatePropery(ModelMap map,@Valid SellProperty s,BindingResult bs) 
	{
		if(bs.hasErrors())
			return "admin/updateroperty";
		service.updateSellProperty(s);
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "admin/allproperty" ;
	}

	@RequestMapping("/addproperty")
	public String showAddPropery(ModelMap map, SellProperty s) 
	{
		return "admin/addproperty" ;
	}
	
	@RequestMapping("/updateproperty")
	public String showUpdatePropery(ModelMap map, SellProperty s) 
	{
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "admin/updateproperty" ;
	}
	
	@RequestMapping(value="/addproperty",method=RequestMethod.POST)
	public String processBookFrom(Model map,@Valid SellProperty sp, BindingResult bs)
	{
		if(bs.hasErrors())
			return "addproperty";
		service.addSellProperty(sp);
		return "admin/addSuccess";
	}
	
	@RequestMapping(value="/addupdateproperty")
	public String processUpdateForm(@RequestParam("updateId") int updateId,ModelMap map, SellProperty s)
	{
		map.addAttribute("sell", service.findSellProperty(updateId));
		return "admin/addupdateproperty";
	}
	
	
	@RequestMapping("/deleteproperty")
	public String showDeletePropery(ModelMap map, SellProperty s) 
	{
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "admin/deleteproperty" ;
	}
	
	@RequestMapping(value="/adddeleteproperty")
	public String processDeleteForm(@RequestParam("deleteId") int deleteId,ModelMap map, SellProperty sp)
	{
		map.addAttribute("sell", service.findSellProperty(deleteId));
		return "admin/adddeleteproperty";
	}
	
	@RequestMapping(value="/allprop2",method=RequestMethod.POST)
	public String showAllDeletePropery(ModelMap map,@Valid SellProperty s,BindingResult bs) 
	{
		if(bs.hasErrors())
			return "admin/deleteproperty";
		service.deleteSellProperty(s);
		map.addAttribute("status","Sell Property Deleted Successfully");
		map.addAttribute("sell_dtls", service.getAllSellProperties());
		return "admin/allproperty" ;
	}
	
	@RequestMapping("/requirement")
	public String listAllReq(ModelMap map, RequirementProperty s) 
	{
		System.out.println("in list categories");
		map.addAttribute("req_dtls", service.getAllReqProperties());
		return "admin/requirement" ;
	}
	
	@RequestMapping(value="/reqirementUpdate")
	public String processReqForm(@RequestParam("updateId") int updateId,ModelMap map, RequirementProperty s)
	{
		map.addAttribute("req", service.findReqProperty(updateId));
		return "admin/requirementUpdate";
	}	
	

	@RequestMapping(value="/listReq",method=RequestMethod.POST)
	public String processReqUpdatePropery(ModelMap map,@Valid RequirementProperty s,BindingResult bs) 
	{
		if(bs.hasErrors())
			return "admin/reqirementUpdate";
		service.updateReqProperty(s);
		map.addAttribute("status","Reqirement Property Updated Successfully");
		map.addAttribute("req_dtls", service.getAllReqProperties());
		return "admin/requirement" ;
	}
	
	

}
