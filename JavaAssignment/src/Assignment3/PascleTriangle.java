package Assignment3;

import java.util.ArrayList;

public class PascleTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(5));
		System.out.println(getRow(0));
	}
	
	
	
	/**
	 * 
	 * 
	 * Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?
	 * 
	 * 
	 * @param A
	 * @return
	 */
	
	
	
	public static ArrayList<Integer> getRow(int A) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		if(A == 0) {
			al.add(1);
		}else {
			for(int i=0;i<=A;i++) {
				
				if(i==0) {
					temp.add(1);
				}else {
					temp.add(1);
					for(int j = 0; j<al.size()-1;j++) {
						temp.add(al.get(j)+al.get(j+1));
					}
					temp.add(1);
				}
				al.clear();
				al.addAll(temp);
				temp.clear();
			}
		}
		return al;
		
    }
	
	public ArrayList<Integer> getRow1(int a) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    res.add(1);
	    for(int i=1; i<=a; i++){
	        int num = (a+1-i)*res.get(i-1)/i;
	        res.add(num);
	    }
	    return res;
	    	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
	 * 
	 * 
	 */
	
	public static ArrayList<ArrayList<Integer>> solve(int A) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<A;i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if(i==0) {
				temp.add(1);
			}else {
				temp.add(1);
				for(int j=0;j<al.get(i-1).size()-1;j++) {
					temp.add(al.get(i-1).get(j)+al.get(i-1).get(j+1));
				}
				temp.add(1);
			}
			al.add(temp);
		}
		
		return al;
		
    }

}
