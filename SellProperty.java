package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="sellproperty1")
public class SellProperty 
{
	private Integer sellId;
	@NotEmpty(message="Type should not be blank")
	private String type;
	@NotEmpty(message="Address should not be blank")
	private String address;
	@NotEmpty(message="City should not be blank")
	private String city;
	@NotNull(message="Price must not be blank")	
	private Double price;
	@NotNull(message="PlotArea must not be blank")
	private Double plotarea;
	@NotEmpty(message="Description should not be blank")
	private String description;
	@NotEmpty(message="Image Url should not be blank")
	private String imageurl;
	@NotEmpty(message="Status should not be blank")
	private String status;
	
	public SellProperty() 
	{
		System.out.println("Into Sell Property Ctor");
	}

	public SellProperty(String type, String address, String city, Double price, Double plotarea, String description, String imageurl, String status) 
	{
		this.type = type;
		this.address = address;
		this.city = city;
		this.price = price;
		this.plotarea = plotarea;
		this.description = description;
		this.imageurl = imageurl;
		this.status= status;
	}

	@Id
	@GeneratedValue
	public Integer getSellId() {
		return sellId;
	}

	public void setSellId(Integer sellId) {
		this.sellId = sellId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPlotarea() {
		return plotarea;
	}

	public void setPlotarea(Double plotarea) {
		this.plotarea = plotarea;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SellProperty [sellId=" + sellId + ", type=" + type
				+ ", address=" + address + ", city=" + city + ", price="
				+ price + ", plotarea=" + plotarea + ", description="
				+ description + ", imageurl=" + imageurl + ", status=" + status
				+ "]";
	}
	
	
}
