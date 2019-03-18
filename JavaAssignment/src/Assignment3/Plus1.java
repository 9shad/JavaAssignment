package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Plus1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
		 */
		System.out.println(plusOne(Arrays.asList(new Integer[] {0, 6, 0, 6, 4, 8, 8, 1})));
	}
	public static List<Integer> plusOne(List<Integer> A) {
		
		if(A.get(0) == 9){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(0);
            temp.addAll(A);
            A=temp;
        }
        
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i) < 9){
                A.set(i,A.get(i)+1);
                break;
            }else{
                A.set(i, 0);
            }
        }
        
        Iterator<Integer> it = A.iterator();
        while(it.hasNext()) {
        	if(it.next() == 0) {
        		it.remove();
        	}else {
        		break;
        	}
        }
        
        return A;
	}
}
