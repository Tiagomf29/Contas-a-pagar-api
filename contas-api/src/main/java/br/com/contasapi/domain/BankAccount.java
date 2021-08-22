package br.com.contasapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@ApiModelProperty(value = "Codigo único da conta do banco (Gerado automaticamente)")
	private int code;
	
	@ManyToOne
	@JoinColumn(name = "code_user")
	@ApiModelProperty(value = "Usuário logado no sistema")
	private User user;
	
	@ApiModelProperty(value = "Valor da conta")
	@Column(nullable = false)
	private float value;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	
	

}
