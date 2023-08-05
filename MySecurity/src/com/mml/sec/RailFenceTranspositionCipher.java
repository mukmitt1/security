package com.mml.sec;

/**
 * 
 * @author mukmi
 * The rail fence cipher (also called a zigzag cipher) is a form of transposition cipher. It derives its name from the way in which it is encoded. .
 * Key has to be numeric 
 * Output
 * Original text: Hello Geek
 * Cipher Text : HlGkeoe-l e-
 */
public class RailFenceTranspositionCipher {

	
 
	
	
	/**
	 * Customer Key
	 */
	public static int getKey() {
		return 3;
	}

	
	/** Encryption by setting the variable and find column position
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encryption(String plainText) {
		String cipherText = "";

		
		
		int row = plainText.length() / getKey();
	    int extraChar  = plainText.length() % getKey();
	    int exrow = (extraChar == 0) ? 0 : 1;
	    int rowtemp = -1, coltemp = -1;
	    //total character
	    int totallen = (row + exrow) * getKey();
	   
	    char pmat[][] = new char[(row + exrow)][(getKey())];
	   //Encryption
	    char encry[] = new char[totallen];
	  
	    int tempcnt = -1;
	    row = 0;
	  
	    for (int i = 0; i < totallen; i++) {
	    	coltemp++;
	        if (i < plainText.length()) {
	        	if (coltemp == getKey()) {
	        		row++;
	                coltemp = 0;
	            }
	            pmat[row][coltemp] = plainText.charAt(i);
	        } else {
	  
	                // Padding can be added between two
	                // consecutive alphabets or a group of
	                // alphabets of the resultant cipher text
	                pmat[row][coltemp] = '-';
	            }
	        }
	  
	        int len = -1, k=-1;
	  
	        //Store encrypted data based on key letter priority
	        for (int i = 0; i < getKey(); i++) {
	        	k++;
	            for (int j = 0; j <= row; j++) {
	                len++;
	                encry[len] = pmat[j][k];
	            }
	        }
	  
	        String p1 = new String(encry);
	        return (new String(p1));
		
		
	}
	

	//Use Decrypt logic
    public static String decryption(String s)
    {
        int min, i, j, k=-1;
//        char key[] = getKey();
        char encry[] = s.toCharArray();
        char temp;
  
  
        // Step 4: Generating a plain message
        int row = s.length()/getKey();
        char pmat[][]
            = new char[row][getKey()];
        int tempcnt = -1;
  
        for (i = 0; i < getKey(); i++) {
 
        	k++;
        	
            for (j = 0; j < row; j++) {
                tempcnt++;
                pmat[j][k] = encry[tempcnt];
            }
        }
  
        // Step 5: Storing matrix character in
        // to a single string
        char p1[] = new char[row * getKey()];
  
        k = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < getKey(); j++) {
                if (pmat[i][j] != '-') {
                    p1[k++] = pmat[i][j];
                }
            }
        }
  
        return (new String(p1));
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plainText = "Hello Geek";
		String cipherText = encryption("Hello Geek");
		System.out.println("Original text: " + plainText);
		System.out.println("Cipher Text : "
                + cipherText);
		System.out.println("Decrypted Plain Text : "
                + decryption(cipherText));

	}

}
