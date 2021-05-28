package br.com.contasapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Backup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
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
