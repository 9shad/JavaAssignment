package Assignment3;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[-1,-1,-1,-1,-1,-1]
		//[0,0,-1,0]
		//[0,-1,-1,-1]
		//[-1,0,-1,-1]
		//[0,-1,0,0]
		//[2,3,-1,-1]
		//[ 1967513926, 1540383426, -1303455736, -521595368 ]
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1967513926);
		al.add(1540383426);
		al.add(-1);
		al.add(-1);
		System.out.println(maxset(al));
	}
	
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int start = 0;
		int end = 0;
		long sum = 0;
		long maxSum = 0;
		int rangeStart = 0;
		int rangeEnd = 0;
		
		for(int i = 0;i<A.size();i++) {
			if(A.get(i)>=0) {
				end = i;
				sum+=A.get(i);
			}else {
				start = i+1;
				sum = 0;
			}
			if(sum>maxSum) {
				maxSum = sum;
				rangeStart = start;
				rangeEnd = end;
			}else if(sum == maxSum) {
				if((rangeEnd-rangeStart) == (end-start)) {
					if(start > rangeStart) {
						rangeStart = start;
						rangeEnd = end;
					}
				}else 
				if((rangeEnd-rangeStart) < (end-start)){
					rangeStart = start;
					rangeEnd = end;
				}
			}
		}
		
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=rangeStart;i<=rangeEnd;i++) {
			if(A.get(i) >=0)
				result.add(A.get(i));
		}

		return result;	
    }
	
	public ArrayList<Integer> maxset1(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> copy = new ArrayList<>();
        long sum = 0;
        long temp = 0;

        for (int num : A) {
            if (num >= 0) {
                temp += num;
                copy.add(num);
            }
            else {
                temp = 0;
                copy.clear();
            }
            
            if (temp > sum || (temp == sum && ans.size() < copy.size())) {
                sum = temp;
                ans.clear();
                ans.addAll(copy);
            }
        }

        return ans;
    }
	
	

}
