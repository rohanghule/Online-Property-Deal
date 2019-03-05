package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="customers1234")
public class Customer 
{
	private Integer id;
	@NotEmpty(message="Name should not be blank")
	private String name;
	@NotEmpty(message="Email Should not be blank")
	@Email(message="Invalid Email")
    private String email;
	@NotEmpty(message="Login ID should not be blank And Must be unique")
    private String loginId;
	@NotEmpty(message="Passowrd should not be blank")
    private String password;
	@NotEmpty(message="Contact No. should not be blank")
    private String contactNo;
	@NotEmpty(message="Address should not be blank")
    private String address;
    private String role="customer";
    
    public Customer() 
    {
    	System.out.println("Into Cust Ctor");
    }
    
	public Customer(String name, String email, String loginId, String password,	String contactNo, String address) 
	{
		this.name = name;
		this.email = email;
		this.loginId = loginId;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	@Id
	@GeneratedValue
	@Column(length=10)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(length=40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=40,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=20,unique=true)
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column(length=20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=15)
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column(length=40)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	@Column(length=10)
	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email
				+ ", loginId=" + loginId + ", password=" + password
				+ ", contactNo=" + contactNo + ", address=" + address
				+ ", role=" + role + "]";
	}

}
