package com.mml.sec;

/**
 * 
 * @author mukmi
 * Columnar Transposition involves writing the plaintext out in rows, and then reading the 
 * ciphertext off in columns one by one.
 * 
 * Output
 * 63401725 
 * Cipher Text : l-o-G-ekl-e-He -
 */
public class ColumnarTranspositionCipher {

	
	private static char[] orginalKey = getKey().toCharArray();
	private static int[] sortedKeyPos = new int[getKey().length()];
    private static char[] sortedKey = getKey().toCharArray();
 
	
	
	/**
	 * Customer Key
	 */
	public static String getKey() {
		return "megabuck";
	}

	/**
	 * find character position
	 */
	public static void processKey() {
		
		int min = -1;
		orginalKey = getKey().toCharArray();
		sortedKeyPos = new int[getKey().length()];
        sortedKey = getKey().toCharArray();
		
        
        //sort character array
		for (int i = 0; i < getKey().length(); i++) {
            min = i;
            for (int j = i; j < getKey().length(); j++) {
                if (sortedKey[min] > sortedKey[j]) {
                    min = j;
                }
            }
  
            if (min != i) {
                char temp = sortedKey[i];
                sortedKey[i] = sortedKey[min];
                sortedKey[min] = temp;
            }
        }

		
		
		/**
		 * Store position of key character from original key. Use sorted character array
		 */
		for (int i = 0; i < getKey().length(); i++) {
            for (int j = 0; j < getKey().length(); j++) {
                if (orginalKey[i] == sortedKey[j])
                    sortedKeyPos[i] = j;
            }
        }
		
		for (int i = 0; i < sortedKeyPos.length; i++) {
			System.out.print(sortedKeyPos[i]);
			
		}
		System.out.println(" ");
  
	}
	
	/** Encryption by setting the variable and find column position
	 * 
	 * @param plainText
	 * @return
	 */
	public static String encryption(String plainText) {
		String cipherText = "";

		processKey();
		
		
		int row = plainText.length() / getKey().length();
	    int extraChar  = plainText.length() % getKey().length();
	    int exrow = (extraChar == 0) ? 0 : 1;
	    int rowtemp = -1, coltemp = -1;
	    //total character
	    int totallen = (row + exrow) * getKey().length();
	   
	    char pmat[][] = new char[(row + exrow)][(getKey().length())];
	   //Encryption
	    char encry[] = new char[totallen];
	  
	    int tempcnt = -1;
	    row = 0;
	  
	    for (int i = 0; i < totallen; i++) {
	    	coltemp++;
	        if (i < plainText.length()) {
	        	if (coltemp == (getKey().length())) {
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
	  
	        int len = -1, k;
	  
	        //Store encrypted data based on key letter priority
	        for (int i = 0; i < getKey().length(); i++) {
	            for (k = 0; k < getKey().length(); k++) {
	                if (i == sortedKeyPos[k]) {
	                    break;
	                }
	            }
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
        int min, i, j, k;
        char key[] = getKey().toCharArray();
        char encry[] = s.toCharArray();
        char temp;
  
        processKey();
  
        // Step 4: Generating a plain message
        int row = s.length()/getKey().length();
        char pmat[][]
            = new char[row][(getKey().length())];
        int tempcnt = -1;
  
        for (i = 0; i < getKey().length(); i++) {
            for (k = 0; k < getKey().length(); k++) {
                if (i == sortedKeyPos[k]) {
                    break;
                }
            }
  
            for (j = 0; j < row; j++) {
                tempcnt++;
                pmat[j][k] = encry[tempcnt];
            }
        }
  
        // Step 5: Storing matrix character in
        // to a single string
        char p1[] = new char[row * getKey().length()];
  
        k = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < getKey().length(); j++) {
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
