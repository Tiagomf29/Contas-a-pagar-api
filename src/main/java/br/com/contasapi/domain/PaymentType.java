package br.com.contasapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class PaymentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Codigo único do tipo de pagamento(Gerado automaticamente)")
	private int code;
		
	@NotBlank
	@Size(max = 50)
	@ApiModelProperty(value = "Descrição do tipo de pagamento da conta")
	private String description;
	
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
	
	 

}
