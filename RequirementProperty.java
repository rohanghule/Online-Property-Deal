package com.app.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="requirementtable1")
public class RequirementProperty implements Serializable 
{
	private Integer id;
	@NotNull
	private Integer sellId;
	@NotEmpty
    private String loginId;
	@NotEmpty(message="Name should not be blank")
	private String name;
	@NotEmpty(message="Email Should not be blank")
	@Email(message="Invalid Email")
    private String email;
	@NotEmpty(message="Contact No. should not be blank")
    private String contactNo;
    private String message;
    private String status="pending";
    
    public RequirementProperty() {
	}

	public RequirementProperty(Integer sellId, String loginId, String name,
			String email, String contactNo, String message) {
		super();
		this.sellId = sellId;
		this.loginId = loginId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.message = message;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSellId() {
		return sellId;
	}

	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}
	
	
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "RequirementProperty [sellId=" + sellId + ", loginId=" + loginId
				+ ", name=" + name + ", email=" + email + ", contactNo="
				+ contactNo + ", message=" + message + "]";
	}
    
}
