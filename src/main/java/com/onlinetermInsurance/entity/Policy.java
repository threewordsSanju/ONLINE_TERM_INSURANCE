package com.onlinetermInsurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "POLICY")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "policy_id", nullable = false)
	int id;
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "age_for_term", nullable = false)
	private int yearsOfPayment;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "maturity_period", nullable = false)
	private int maturityperiod;
	@Column(name = "maturity_amount", nullable = false)
	private double maturityamount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User user;

	public Policy() {
		super();
	}

	public Policy(int id, String description, String userName, int yearsOfPayment, double amount, int maturityperiod,
			double maturityamount) {
		super();
		this.id = id;
		this.description = description;
		this.userName = userName;
		this.yearsOfPayment = yearsOfPayment;
		this.amount = amount;
		this.maturityperiod = maturityperiod;
		this.maturityamount = maturityamount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearsOfPayment() {
		return yearsOfPayment;
	}

	public void setYearsOfPayment(int yearsOfPayment) {
		this.yearsOfPayment = yearsOfPayment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public int getMaturityperiod() {
		return maturityperiod;
	}

	public void setMaturityperiod(int maturityperiod) {
		this.maturityperiod = maturityperiod;
	}

	public double getMaturityamount() {
		return maturityamount;
	}

	public void setMaturityamount(double d) {
		this.maturityamount = d;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", description=" + description + ", userName=" + userName + ", yearsOfPayment="
				+ yearsOfPayment + ", amount=" + amount + ", maturityperiod=" + maturityperiod + ", maturityamount="
				+ maturityamount + ", user=" + user + "]";
	}

}
