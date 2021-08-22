package br.com.contasapi.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class AccountPayable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Transient
	private LocalDate dateFirstPayable;
	
	@Transient	
	private Float value;
	
	@Transient
	private boolean amount;
	
	private String description;
	private int quantityPlots;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "payer")
	private Payer payer;
	
	@ManyToOne
	@JoinColumn(name = "payment_type")
	private PaymentType paymentType;	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payer getPayer() {
		return payer;
	}
	public void setPayer(Payer payer) {
		this.payer = payer;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantityPlots() {
		return quantityPlots;
	}
	public void setQuantityPlots(int quantityPlots) {
		this.quantityPlots = quantityPlots;
	}
	
	public LocalDate getDateFirstPayable() {
		return dateFirstPayable;
	}
	public void setDateFirstPayable(LocalDate dateFirstPayable) {
		this.dateFirstPayable = dateFirstPayable;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public boolean isAmount() {
		return amount;
	}
	public void setAmount(boolean amount) {
		this.amount = amount;
	}	


}
