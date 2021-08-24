package br.com.contasapi.exceptionhandle;

public class ErrorPersonalizadoDetalhes {

	private String campo;
	private String mensagem;
	
	public String getCampo() {
		return campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
