package br.com.contasapi.domain;

import java.time.LocalDate;

public class Income {

	private int code;
	private LocalDate dateIncome;
	private User user;
	private TypeIncome typeIncome;
	private float value;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public LocalDate getDateIncome() {
		return dateIncome;
	}
	public void setDateIncome(LocalDate dateIncome) {
		this.dateIncome = dateIncome;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TypeIncome getTypeIncome() {
		return typeIncome;
	}
	public void setTypeIncome(TypeIncome typeIncome) {
		this.typeIncome = typeIncome;
	}
		
}
