package br.com.contasapi.domain;

public class User {
	
	private int code;
	private short cpf;
	private String fullName;
	private String login;
	private String password;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public short getCpf() {
		return cpf;
	}
	public void setCpf(short cpf) {
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
