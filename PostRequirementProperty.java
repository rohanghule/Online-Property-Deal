package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="postrequirementtable1")
public class PostRequirementProperty 
{
	private Integer id;
	@NotEmpty
    private String loginId;
	@NotEmpty(message="Area should not be blank")
	private String area;
	@NotEmpty(message="Type should not be blank")
	private String type;
	@NotNull(message="Please Add Min Budget")
	private Double minBudget;
	@NotNull(message="Please Add Max Budget")
	private Double maxBudget;
	@NotEmpty(message="City should not be blank")
	private String city;
	private String status="pending";
	
	public PostRequirementProperty() {
	}

	public PostRequirementProperty(Integer id, String loginId, String area,
			String type, Double minBudget, Double maxBudget, String city,
			String status) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.area = area;
		this.type = type;
		this.minBudget = minBudget;
		this.maxBudget = maxBudget;
		this.city = city;
		this.status = status;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(Double minBudget) {
		this.minBudget = minBudget;
	}

	public Double getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(Double maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PostRequirementProperty [id=" + id + ", loginId=" + loginId
				+ ", area=" + area + ", type=" + type + ", minBudget="
				+ minBudget + ", maxBudget=" + maxBudget + ", city=" + city
				+ ", status=" + status + "]";
	}

}

