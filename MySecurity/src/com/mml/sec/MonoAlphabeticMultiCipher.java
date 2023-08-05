package com.mml.sec;


/**
 * 
 * @author mukmi
 *In mono-alphabetic ciphers, each symbol in plain-text (eg; ‘o’ in ‘follow’) is mapped to one cipher-text symbol. No matter how many times a symbol occurs in the plain-text, it will correspond to the same cipher-text symbol. For example, if the plain-text is ‘follow’ and the mapping is :
f -> g

The simplest mono-alphabetic cipher is additive cipher. It is also referred to as ‘Shift Cipher’ or ‘Caesar Cipher’. As the name suggests, ‘addition modulus 2’ operation is performed on the plain-text to obtain a cipher-text
 
 C = (M * k) mod n
M = (C * 1/k) mod n

where,
C -> cipher-text
M -> message/plain-text
k -> key


limitation. Key has to be odd number. Data has to be lower case.

 *
 */
public class MonoAlphabeticMultiCipher {

	static int  alphaNumber = 26;
	static int  ASCII_LC_CASE_START = 97;
	
	public static int getKey() {
		return 7;
	}
	

	/**
	 * multiply each character of plaintext to key
	 * @param plainText
	 * @return
	 */
	public static String encryption(String plainText) {
		StringBuilder cipherText = new StringBuilder();
		
		for (int i = 0; i < plainText.length(); i++) {
			cipherText.append((char)(((plainText.charAt(i) * getKey()-ASCII_LC_CASE_START) % alphaNumber) + ASCII_LC_CASE_START)   )  ;
		}
		
		return cipherText.toString();
	}

	/**
	 * 
	 * @param cipherText
	 * @return
	 * Decrypt data
	 */
	public static String decryption(String cipherText) {
		StringBuilder plainText = new StringBuilder();
		
		int aInv =0;
		
		aInv = multipleInverse();
		
		for (int i = 0; i < cipherText.length(); i++) {
			plainText.append((char)((  (cipherText.charAt(i) *  aInv -ASCII_LC_CASE_START)%alphaNumber)+ASCII_LC_CASE_START ));
			
		}

	    return plainText.toString();
	}

	/**
	 * 
	 * @return
	 * find multiple inverse of key.
	 * 
	 */
	public static int multipleInverse() {
		int aInv =0;
		for (int i = 0; i < alphaNumber; i++) {
			if(((i*alphaNumber)+1)%getKey()==0)
    		{
					aInv=((i*alphaNumber)+1)/getKey();
					System.out.println("aInv isssssssssss " + aInv);
        			break;
    		}
		   }
		
		return aInv;
	}
	
	
	public static void main(String[] args) {
		
		String plainText = "mark";
		System.out.println("Plain Text is " +  plainText);
		
		String cipherText = encryption(plainText);
		
		System.out.println("Cipher Text is " +  cipherText);

		String plainTextAgain = decryption(cipherText);
		
		System.out.println("Plain Text is " +  plainTextAgain);

	}

}
