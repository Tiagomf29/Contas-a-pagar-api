package br.com.contasapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Backup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@ApiModelProperty(value = "Codigo único do backup de dados (Gerado automaticamente)")
	private int code;
	
	@Column(nullable = false, length = 200)
	@ApiModelProperty(value = "Caminho do backup da dados")
	private String patchBackup;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPatchBackup() {
		return patchBackup;
	}
	public void setPatchBackup(String patchBackup) {
		this.patchBackup = patchBackup;
	}
	
	

}
