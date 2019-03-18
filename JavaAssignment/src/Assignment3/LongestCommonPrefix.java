package Assignment3;

import java.util.ArrayList;

public class LongestCommonPrefix {
/**
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
 * 
 * 
 * @param args
 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<A.size();i++){
            if(i==0){
                sb.append(A.get(0));
            }else{
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<sb.length() && j<A.get(i).length();j++){
                    if(sb.charAt(j) == A.get(i).charAt(j)){
                        temp.append(sb.charAt(j));
                    }else{
                        break;
                    }
                }
                sb = temp;
            }
        }
        return sb.toString();
    }
	
	public static String longestCommonPrefix1(ArrayList<String> A) {
        if (A == null || A.size() == 0) return null;
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String S : A) {
            if (S == null || S.length() == 0) return null;
            if (S.length() < minLen) minLen = S.length();
        }
        for (int j = 0; j < minLen; j++) {
            int count = 0;
            char c = A.get(0).charAt(j);
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i).charAt(j) != c) break;
                count++;
            }
            if (count != A.size()) return sb.toString();
            sb.append(c);
        }
        
        return sb.toString();
    }

}
