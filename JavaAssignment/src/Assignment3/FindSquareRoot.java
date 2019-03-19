package Assignment3;

public class FindSquareRoot {

	
	
	/**
	 * Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(11));
		System.out.println(sqrt(2));
		System.out.println(sqrt(4));
	}
	
	public static long sqrt(int a) {
        
        if(a == 0){
            return 0;
        }
        
        if(a == 1){
            return 1;
        }
        
        long start = 1;
        long end = a/2;
        long ans = 0;
        while(start <= end){
            
            long mid = (start+end)/2;
            long check = mid*mid;
            if(check == a){
                return mid;
            }
            
            if(check < a){
                start = mid + 1; 
                ans = mid; 
            }else{
                end = mid -1;
            }
        }
        return ans;
    }
	
	public static int sqrt1(int a) {
	    long low = 1;
	    long high = a;
	    while (low<=high) {
	        long mid = (high + low) / 2;
	        if (mid*mid == a) {
	            return (int) mid;
	        }
	        if (mid*mid > a) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    // if we did not find an exact match the high variable is smaller than low
	    // and therefore contains the floor value of sqrt.
	    return (int) high;
	}

}
