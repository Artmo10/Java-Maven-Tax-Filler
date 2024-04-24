/*
Authors: SUPR-S GROUP
		Sergio Morales Veliz		C0850889
		Uma Adhikari				C0851787
		Prajnana Kumar Taraphdar	C0852961
		Rezil Mae Sumarinas			C0848587
		Santiago Devia Valderrama	C0850607
		
Title	: CSD_4464_3_Group_Project
Date	: April 18, 2023		
*/

package com.cestar.model;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="tax")
@RequestScoped

public class TaxFilersModel {
	
	private int filerID;
	private String name;
	private String contact;
	private float annualIncome;
	private float expenses;
	private int taxYear;
	private Date dateFiled;
	public int getFilerID() {
		return filerID;
	}
	public void setFilerID(int filerID) {
		this.filerID = filerID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public float getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(float annualIncome) {
		this.annualIncome = annualIncome;
	}
	public float getExpenses() {
		return expenses;
	}
	public void setExpenses(float expenses) {
		this.expenses = expenses;
	}
	public int getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}
	public Date getDateFiled() {
		return dateFiled;
	}
	public void setDateFiled(Date dateFiled) {
		this.dateFiled = dateFiled;
	}
	public TaxFilersModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaxFilersModel(int filerID, String name, String contact, float annualIncome, float expenses, int taxYear,
			Date dateFiled) {
		super();
		this.filerID = filerID;
		this.name = name;
		this.contact = contact;
		this.annualIncome = annualIncome;
		this.expenses = expenses;
		this.taxYear = taxYear;
		this.dateFiled = dateFiled;
	}
	@Override
	public String toString() {
		return "TaxFilersModel [filerID=" + filerID + ", name=" + name + ", contact=" + contact + ", annualIncome="
				+ annualIncome + ", expenses=" + expenses + ", taxYear=" + taxYear + ", dateFiled=" + dateFiled + "]";
	}
	
	
	
}