package br.com.contasapi.domain;

import java.time.LocalDate;

public class Income {

	private int code;
	private LocalDate dateIncome;
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

	
	
}
