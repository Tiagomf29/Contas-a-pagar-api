package br.com.contasapi.functions.utils;

import java.security.MessageDigest;

public class CriptografiaMD5 {
	
	public static String CriptografaSenha(String password) {		
		
		byte[] defaultBytes = password.getBytes();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[] = algorithm.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
		
			password = hexString.toString();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return password;			
		
	}			

}
