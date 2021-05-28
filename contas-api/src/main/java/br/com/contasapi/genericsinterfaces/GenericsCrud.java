package br.com.contasapi.genericsinterfaces;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

public interface GenericsCrud<T> {

	ResponseEntity<T>insert(T t);
	ResponseEntity<T>update(T t);
	ResponseEntity<T>delete(int id);
	ArrayList<T>allList();
	
}
