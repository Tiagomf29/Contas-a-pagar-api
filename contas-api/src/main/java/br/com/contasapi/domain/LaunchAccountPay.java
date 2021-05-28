package br.com.contasapi.domain;

import java.time.LocalDate;

public class LaunchAccountPay {
	
	private int code;
	private AccountPayable accountPayable;
	private LocalDate date;
	private Float value;
	private int parcelInstallment;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public AccountPayable getAccountPayable() {
		return accountPayable;
	}
	public void setAccountPayable(AccountPayable accountPayable) {
		this.accountPayable = accountPayable;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public int getParcelInstallment() {
		return parcelInstallment;
	}
	public void setParcelInstallment(int parcelInstallment) {
		this.parcelInstallment = parcelInstallment;
	}
	
	

}
