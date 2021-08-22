package br.com.contasapi.genericsinterfaces;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;

public interface InterfaceCrudUser<T> {

	HashMap<T, Integer> insert(T t);
	HashMap<T, Integer> update(T t);
	ResponseEntity<T>delete(int id);
	ArrayList<T>allList();
	ArrayList<T> listByCod(int id);
	Boolean validaLogin(T t);
	
}
