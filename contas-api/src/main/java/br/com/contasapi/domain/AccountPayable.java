package br.com.contasapi.domain;

public class AccountPayable {
	
	private int code;
	private String description;
	private int quantityPlots;
	private User user;
	private Payer payer;
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
	
	

}
