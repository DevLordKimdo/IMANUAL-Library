package com.i.manual.util;

import java.security.SecureRandom;

public class UtilMakeCrypto {
	
	public String StringNum(int Digit) {
		
		String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
        SecureRandom Random = new SecureRandom();
        StringBuilder CryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = Random.nextInt(Characters.length());
            CryptoNumber.append(Characters.charAt(index));
        }
        
        return CryptoNumber.toString().toUpperCase();
	}
	
	public String NumberOnly(int Digit) {
		
		String Characters = "0123456789";
		
        SecureRandom Random = new SecureRandom();
        StringBuilder CryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = Random.nextInt(Characters.length());
            CryptoNumber.append(Characters.charAt(index));
        }
        
        return CryptoNumber.toString().toUpperCase();
	}
	
	public String StringOnly(int Digit) {
		
		String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
        SecureRandom Random = new SecureRandom();
        StringBuilder CryptoNumber = new StringBuilder(Digit);

        for (int i = 0; i < Digit; i++) {
            int index = Random.nextInt(Characters.length());
            CryptoNumber.append(Characters.charAt(index));
        }
        
        return CryptoNumber.toString().toUpperCase();
	}
}
