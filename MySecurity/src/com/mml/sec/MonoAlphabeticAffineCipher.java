package com.mml.sec;


/**
 * 
 * @author mukmi
 * The ‘key’ for the Affine cipher consists of 2 numbers, we’ll call them a and b.
 * E ( x ) = ( a x + b ) mod m 
 * modulus m: size of the alphabet
 * a and b: key of the cipher.
 * a must be chosen such that a and m are coprime.
 */
public class MonoAlphabeticAffineCipher {

	static int  alphaNumber = 26;
	static int  ASCII_UC_CASE_START = 'A';
	
	
	/**
	 * 
	 * @return
	 * in ax+b equation, a is 17
	 */
	public static int getKey1() {
		return 17;
	}

	/**
	 * 
	 * @return
	 * suppose b is 20
	 */
	public static int getKey2() {
		return 20;
	}


	/**
	 * multiply each character of plaintext to key
	 * @param plainText
	 * @return
	 * Here we wil calculate (ax + b) MOD 26
	 */
	public static String encryption(String plainText) {
		StringBuilder cipherText = new StringBuilder();
		
		for (int i = 0; i < plainText.length(); i++) {
	
			if (plainText.charAt(i) != ' ') {
				cipherText.append((char)((   ((plainText.charAt(i) * getKey1()-ASCII_UC_CASE_START) + getKey2()) % alphaNumber) + ASCII_UC_CASE_START)   )  ;
			}else {
				cipherText.append(' ');
			}
		}
		
		return cipherText.toString();
	}
	/**
	 * 
	 * @param cipherText
	 * @return
	 * Decrypt data
	 * D ( x ) = a^-1 ( x - b ) mod m
	 * a^-1 : modular multiplicative inverse of a modulo m. i.e., it satisfies the equation
	 * 1 = a a^-1 mod m .
	 */
	public static String decryption(String cipherText) {
		StringBuilder plainText = new StringBuilder();
		
		int aInv =0;
		
		aInv = multipleInverse();
		
		for (int i = 0; i < cipherText.length(); i++) {
			if (cipherText.charAt(i) != ' ') {
			//	plainText.append((char)((  (cipherText.charAt(i) *  aInv  + ASCII_UC_CASE_START  -getKey2())%alphaNumber)+ASCII_UC_CASE_START ));
				plainText.append( (char) ((aInv *
                        (cipherText.charAt(i) + ASCII_UC_CASE_START - getKey2()) % alphaNumber) + ASCII_UC_CASE_START));
			}else {
				plainText.append(' ');
			}
		}

	    return plainText.toString();
	}

	
	public static String decryption1(String cipherText) {
		StringBuilder plainText = new StringBuilder();
		String msg = "";
		
		int a_Inv =0;
		
		a_Inv = multipleInverse();
		
		for (int i = 0; i < cipherText.length(); i++)
        {
            /*Applying decryption formula a^-1 ( x - b ) mod m
            {here x is cipher[i] and m is 26} and added 'A'
            to bring it in range of ASCII alphabet[ 65-90 | A-Z ] */
            if (cipherText.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_Inv *
                        ((cipherText.charAt(i) + 'A' - getKey2())) % 26)) + 'A');
            }
            else //else simply append space character
            {
                msg += cipherText.charAt(i);
            }
        }
	    return msg;
	}

	
	/**
	 * 
	 * @return
	 * find multiple inverse of key.
	 * 
	 * 
	 */
	public static int multipleInverse() {
		int aInv =0;
		for (int i = 0; i < alphaNumber; i++) {
//			if(((i*alphaNumber)+1)%getKey1()==0)
			if( (i*getKey1())% alphaNumber==1)
			{
					//aInv=((i*alphaNumber)+1)/getKey1();
					aInv = i;
					System.out.println("aInv isssssssssss " + aInv);
        			break;
    		}
		   }
		
		return aInv;
	}
	
	
	public static void main(String[] args) {
		
		String plainText = "AFFINE CIPHER";
		System.out.println("Plain Text is " +  plainText);
		
		String cipherText = encryption(plainText);
		
		System.out.println("Cipher Text is " +  cipherText);

		String plainTextAgain = decryption(cipherText);
		
		System.out.println("Plain Text is " +  plainTextAgain);

	}

}
