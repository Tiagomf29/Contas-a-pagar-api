package br.com.contasapi.functions.utils;

import java.util.HashMap;
import java.util.Map;

public class GenericsFunctions {
	
	public static <T> Object returnObjectByMap(HashMap<T, Integer> hashMap) {
		
		for(Map.Entry<T, Integer> v : hashMap.entrySet()) {
			return v.getKey();
		}
		
		return null;
		
	}
	
	public static <T> HashMap<T, Integer> returnMapByObjects(T obj, Integer value){
		
		HashMap<T, Integer> mapa = new HashMap<>();
		mapa.put(obj, value);
		
		return mapa;
				
	}

}
