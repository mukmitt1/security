package com.mml.sec;


/**
 * 
 * XOR operation to encrypt the data. 
 * Remember properties: 
 * A XOR B = B XOR A
 * A XOR (B XOR C) = (A XOR B ) XOR C
 * A XOR 0 = A
 * A XOR A = 0
 * 
 * A XOR A XOR B = B
 * @author mukmi
 *
 */
public class XOREncryption {

	public static char getKey() {
		return 'M';
	}
	
	
	public static String encryption(String plainText) {
		String cipherText = "";
		
		for (int i = 0; i < plainText.length(); i++) {
			cipherText +=  Character.toString(plainText.charAt(i) ^ getKey());
		}
		
		return cipherText;
	}

	public static String decryption(String cipherText) {
		String plainText = "";
		
		for (int i = 0; i < cipherText.length(); i++) {
			plainText += Character.toString(cipherText.charAt(i) ^ getKey());
		}
		
		return plainText;
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
