package br.com.contasapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
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
