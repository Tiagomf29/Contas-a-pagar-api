package br.com.contasapi.functions.utils;

public class FunctionsUtils {

	
	public static String returnNameCampoException(String mensagem) {
        				
		if(mensagem.contains("[\"value\"])"))return "value";    		
		else if(mensagem.contains("[\"quantityPlots\"])"))return "quantityPlots";
		else if(mensagem.contains("[\"dateFirstPayable\"])")) return "dateFirstPayable"; 
		else return "";
    					
	}
	
}
