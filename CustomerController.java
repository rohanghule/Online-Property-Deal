package com.app.controller;

import javax.servlet.http.HttpSession;
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
import com.app.service.CustomerService;
import com.app.service.SellPropertyService;


@Controller
@RequestMapping("/cust")
public class CustomerController 
{
	@Autowired
	private CustomerService service;
	@Autowired
	private SellPropertyService service1;
	
	@RequestMapping(value="/user")
	public String showUserForm(Customer c, Model map)
	{
		return "user";
	}
	
	@RequestMapping(value="/book")
	public String showBookForm(Model map, RequirementProperty re)
	{
		return "book";
	}
	
	@RequestMapping(value="/register")
	public String showRegisterForm(Customer c, Model map)
	{
		return "register";
	}
	
	@RequestMapping(value="/index")
	public String showIndexForm(Customer c, Model map)
	{
		return "index";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegisterFrom(Model map,@Valid Customer c1, BindingResult bs)
	{
		if(bs.hasErrors())
			return "register";
		String str = service.registerCustomer(c1);
		
		if(str=="register")
		{
			//map.addAttribute("customer", "Invalid Username or Password");
			return "register";
		}
		map.addAttribute("customer", str);
		return "success";
	}
	
	@RequestMapping(value="/login")
	public String showLoginForm(Customer c, Model map)
	{
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLoginFrom(Model map,HttpSession hs,@Valid Customer c1, BindingResult bs)
	{
		if(bs.hasFieldErrors("loginId") || bs.hasFieldErrors("password"))
			return "login";
		Customer cust = service.validateCustomer(c1.getLoginId(),c1.getPassword());
		System.out.println(cust);
		if( cust==null)
		{
			hs.setAttribute("cust_dtls", "Enter valid details");
			return "login";
		}
		if(cust.getRole().equals("admin"))
		{
			hs.setAttribute("cust_dtls",cust);
			return "redirect:/prop/admin";
		}
		else
		{
			hs.setAttribute("cust_dtls", cust);
			return "forward:/prop/list";
		}
	}
	

	@RequestMapping(value="/book",method=RequestMethod.POST)
	public String processBookFrom(Model map,@Valid RequirementProperty re, BindingResult bs,HttpSession hs)
	{
		if(bs.hasErrors())
			return "book";
		System.out.println(re);
		
		Customer cust=(Customer)hs.getAttribute("cust_dtls");
		System.out.println(cust);
		
		re.setLoginId(cust.getLoginId());
		service1.addSellRequirementProperty(re);
		return "successbk";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
	 	session.invalidate();
		return "logout";
	}
	
	@RequestMapping(value="/home")
	public String showHomeForm(Customer c, Model map)
	{
		return "home";
	}
	
	@RequestMapping(value="/search")
	public String showSearchForm(Model map)
	{
		return "search";
	}
	
	@RequestMapping(value="/searchDetails")
	public String processSearchForm(@RequestParam("myField") String city, ModelMap map)
	{
		map.addAttribute("sell",service.getListByCity(city));
		return "searchDetails";
	}
	
}
