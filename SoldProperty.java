package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="soldproperty1")
public class SoldProperty
{
	private Integer soldId;
	@NotNull
	private Integer sellId;
	@NotEmpty
    private String loginId;
	@NotNull(message=" Please add Paid amount")
	private Double amountPaid;
	@NotNull(message="Please add Total Amount")
	private Double totalAmount;
	@NotNull(message="Please add Total Amount")
	private Double amountBal;

	public SoldProperty() {
	}

	
	public SoldProperty(Integer soldId, Integer sellId, String loginId,
			Double amountPaid, Double totalAmount, Double amountBal) {
		super();
		this.soldId = soldId;
		this.sellId = sellId;
		this.loginId = loginId;
		this.amountPaid = amountPaid;
		this.totalAmount = totalAmount;
		this.amountBal = amountBal;
	}


	@Id
	@GeneratedValue
	public Integer getSoldId() {
		return soldId;
	}

	public void setSoldId(Integer soldId) {
		this.soldId = soldId;
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

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public void setAmountBal(Double amountBal) {
		this.amountBal = amountBal;
	}
	
	public Double getAmountBal() {
		return amountBal;
	}


	@Override
	public String toString() {
		return "SoldProperty [soldId=" + soldId + ", sellId=" + sellId
				+ ", loginId=" + loginId + ", amountPaid=" + amountPaid
				+ ", totalAmount=" + totalAmount + ", amountBal=" + amountBal
				+ "]";
	}

}
