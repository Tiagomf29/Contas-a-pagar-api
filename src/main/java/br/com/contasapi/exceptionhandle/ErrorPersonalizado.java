package br.com.contasapi.exceptionhandle;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ErrorPersonalizado {
	
	private int status;
	private String descricao;
	private LocalDateTime dateTime;
	private ArrayList<ErrorPersonalizadoDetalhes> campos;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public ArrayList<ErrorPersonalizadoDetalhes> getCampos() {
		return campos;
	}
	public void setCampos(ArrayList<ErrorPersonalizadoDetalhes> campos) {
		this.campos = campos;
	}
	
}
