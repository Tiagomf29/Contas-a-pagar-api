package br.com.contasapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class AccountPayable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@ApiModelProperty(value = "Codigo único do cabeçalho da conta a pagar (gerado automaticamente)")
	private int code;
	
	@Transient
	@Column(nullable = false)
	@ApiModelProperty(value = "Data do primeiro pagamento da conta a pagar")
	private LocalDate dateFirstPayable;
	
	@Transient	
	@ApiModelProperty(value = "Valor da conta a pagar. Pode ser o valor total ou o valor da parcela")
	@Column(nullable = false)
	private Float value;
	
	@Transient
	@ApiModelProperty(value = "Define se o valor informado no campo \"value\" será o valor total (true) ou o valor da parcela (false)")
	@Column(nullable = false)
	private boolean amount;
	
	@ApiModelProperty(value = "Descrição da conta a pagar")
	@Column(nullable = false, length = 50)
	private String description;
	
	@ApiModelProperty(value = "Quantidade de parcelas")
	@Column(nullable = false, length = 6)
	private int quantityPlots;
	
	@ManyToOne
	@JoinColumn(name = "user")
	@ApiModelProperty(value = "Usuário logado no sistema")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "payer")
	@ApiModelProperty(value = "Registro do pagador da conta a pagar")	
	private Payer payer;
	
	@ManyToOne
	@JoinColumn(name = "payment_type")
	@ApiModelProperty(value = "Registro do tipo de pagamento")	
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
