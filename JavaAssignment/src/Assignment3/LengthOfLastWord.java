package Assignment3;

public class LengthOfLastWord {
	
	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("Hello World  "));
		System.out.println(lengthOfLastWord("  xDGBklKecz IAcOJYOH O  WY WPi"));
	}
	
public static int lengthOfLastWord(final String A) {
        
        if(A == null || A.length() == 0){
            return 0;
        }
        
        
        int count = 0;
        boolean charFound = false;
        
        for(int i=A.length()-1; i>=0; i--){
        	if(A.charAt(i) != ' ' && !charFound){
            	charFound = true;
            }
        	
        	if(A.charAt(i) == ' ' && charFound){
                break;
            }
        	
        	if(charFound) {
        		count++;
        	}
        }
        
        return count;
        
    }


public int lengthOfLastWord1(final String s) {
    int len = 0;
    
    int i = s.length()-1;
    while (i >= 0 && s.charAt(i) == ' ') {
        i--;
    }
    
    for (i=i; i>=0; i--) {
        if (s.charAt(i) == ' ') {
            return len;
        }
        len++;
    }
    
    return len;
}



}
