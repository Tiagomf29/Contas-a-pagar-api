package br.com.contasapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Restore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@ApiModelProperty(value = "Codigo único (Gerado automaticamente)")
	private int code;
		
	@NotBlank
	@Size(max = 200)
	@ApiModelProperty(value = "Caminho do restore da dados")
	private String patchRestore;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPatchRestore() {
		return patchRestore;
	}
	public void setPatchRestore(String patchRestore) {
		this.patchRestore = patchRestore;
	}
	
}
