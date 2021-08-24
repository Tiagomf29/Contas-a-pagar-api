package br.com.contasapi.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class LaunchAccountPay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@ApiModelProperty(value = "Codigo único do lançamento da conta a pagar (Gerado automaticamente)")
	private int code;
	
	@ManyToOne
	@JoinColumn(name = "account_payable")
	@ApiModelProperty(value = "Cabeçalho da conta a pagar)")	
	private AccountPayable accountPayable;
	
	@ApiModelProperty(value = "Data do pagamento do lançamento da conta a pagar")
	private LocalDate date;
	
	@ApiModelProperty(value = "Valor do lançamento da conta a pagar")
	private Float value;
	
	@ApiModelProperty(value = "Número da parcela do pagamento da conta a pagar")	
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
