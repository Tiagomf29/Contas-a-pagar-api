package br.com.contasapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@ApiModelProperty(value = "Codigo único da renda (Gerado automaticamente)")
	private int code;
	
	@NotBlank
	@ApiModelProperty(value = "Data da recebimento da renda")
	private LocalDate dateIncome;
	
	@ManyToOne
	@JoinColumn(name = "user")
	@ApiModelProperty(value = "Usuário logado no sistema")
	private User user;
		
	@ManyToOne
	@JoinColumn(name = "typeIncome")
	@ApiModelProperty(value = "Tipo da renda")
	private TypeIncome typeIncome;
	
	@ApiModelProperty(value = "Valor da renda recebida")
	@NotBlank
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
