package br.com.contasapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@ApiModelProperty(value = "Código único do usuário (Gerado automaticamente)")
	private int code;
	
	@Column(nullable = false, length = 12)
	@ApiModelProperty(value = "CPF do usuário")
	private String cpf;
	
	@Column(nullable = false, length = 80)
	@ApiModelProperty(value = "Nome completo do usuário")
	private String fullName;
	
	@Column(nullable = false, length = 15)
	@ApiModelProperty(value = "Descrição do login do usuário")
	private String login;	
	
	@Column(nullable = false, length = 150)
	@ApiModelProperty(value = "Senha do usuário")
	private String password;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
