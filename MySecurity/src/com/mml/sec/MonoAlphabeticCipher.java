package com.mml.sec;


/**
 * 
 * @author mukmi
 *In mono-alphabetic ciphers, each symbol in plain-text (eg; ‘o’ in ‘follow’) is mapped to one cipher-text symbol. No matter how many times a symbol occurs in the plain-text, it will correspond to the same cipher-text symbol. For example, if the plain-text is ‘follow’ and the mapping is :
f -> g

The simplest mono-alphabetic cipher is additive cipher. It is also referred to as ‘Shift Cipher’ or ‘Caesar Cipher’. As the name suggests, ‘addition modulus 2’ operation is performed on the plain-text to obtain a cipher-text
 
 C = (M + k) mod n
M = (C – k) mod n

where,
C -> cipher-text
M -> message/plain-text
k -> key
 *
 */
public class MonoAlphabeticCipher {

	static int  alphaNumber = 26;
	
	public static char getKey() {
		return 'c';
	}
	

	public static String encryption(String plainText) {
		StringBuilder cipherText = new StringBuilder();
		
		for (int i = 0; i < plainText.length(); i++) {
			cipherText.append((char)(plainText.charAt(i) + getKey() % alphaNumber))  ;
		}
		
		return cipherText.toString();
	}

	public static String decryption(String cipherText) {
		StringBuilder plainText = new StringBuilder();
		
		for (int i = 0; i < cipherText.length(); i++) {
			plainText.append((char)(cipherText.charAt(i) - getKey() % alphaNumber));
		}
		
		return plainText.toString();
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plainText = "Mark";
		System.out.println("Plain Text is " +  plainText);
		
		String cipherText = encryption(plainText);
		
		System.out.println("Cipher Text is " +  cipherText);

		String plainTextAgain = decryption(cipherText);
		
		System.out.println("Plain Text is " +  plainTextAgain);

	}

}
