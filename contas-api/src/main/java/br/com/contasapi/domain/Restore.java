package br.com.contasapi.domain;

public class Restore {
	
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
