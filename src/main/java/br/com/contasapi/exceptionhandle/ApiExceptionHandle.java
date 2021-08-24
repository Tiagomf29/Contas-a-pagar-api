package br.com.contasapi.exceptionhandle;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandle extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		ArrayList<ErrorPersonalizadoDetalhes> listaCampos = new ArrayList<>();
		
		ErrorPersonalizado ep = new ErrorPersonalizado();
		ep.setStatus(status.value());
		ep.setDescricao("Um ou mais campos obrigatórios não foram preenchidos. Verifique!");
		ep.setDateTime(LocalDateTime.now());
		
	    for(ObjectError error :  ex.getBindingResult().getAllErrors()) {
	    	
	    	ErrorPersonalizadoDetalhes epd = new ErrorPersonalizadoDetalhes();
	    	epd.setCampo(((FieldError)error).getField());
	    	epd.setMensagem(error.getDefaultMessage());
	    	listaCampos.add(epd);
	    		    	
	    }
	     
	     ep.setCampos(listaCampos);
		
		
		return super.handleExceptionInternal(ex, ep, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorPersonalizado ep = new ErrorPersonalizado();
		ep.setStatus(status.value());
		ep.setDescricao("Valor inválido para o campo.");
		ep.setDateTime(LocalDateTime.now());
		
			
    	ErrorPersonalizadoDetalhes epd = new ErrorPersonalizadoDetalhes();
    	String campo = "";
    	
	
        System.out.println(ex.getMessage());
    	if(ex.getMessage().contains("[\"value\"])")) {
    		campo = "value";
    		
    	}else if(ex.getMessage().contains("[\"quantityPlots\"])")) {
    	{
    		campo = "quantityPlots";
    	}
    	
    	}
    	
    	epd.setCampo(campo);
    	epd.setMensagem("Valor inválido para o campo.");
    	ArrayList<ErrorPersonalizadoDetalhes> listaCampos = new ArrayList<>();
    	listaCampos.add(epd);
    	
    	ep.setCampos(listaCampos);
    	
		return super.handleExceptionInternal(ex, ep, headers, status, request);
    	
	}
}
