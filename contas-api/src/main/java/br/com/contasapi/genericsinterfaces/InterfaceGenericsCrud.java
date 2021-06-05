package br.com.contasapi.genericsinterfaces;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;

public interface InterfaceGenericsCrud<T> {

	HashMap<T, Integer> insert(T t);
	HashMap<T, Integer> update(T t);
	ResponseEntity<T>delete(int id);
	ArrayList<T>allList();
	ArrayList<T> listByCod(int id);

	
}
