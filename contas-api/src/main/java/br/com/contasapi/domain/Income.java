package br.com.contasapi.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	private LocalDate dateIncome;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
		
	@ManyToOne
	@JoinColumn(name = "typeIncome")
	private TypeIncome typeIncome;
	
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
