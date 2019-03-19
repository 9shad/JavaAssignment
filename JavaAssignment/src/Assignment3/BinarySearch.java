package Assignment3;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		System.out.println(binarySearch(arr, 10));
		System.out.println(binarySearch(new int[] {4, 7, 7, 7, 8, 10, 10,11,12}, 10));
		System.out.println(binarySearch(new int[] {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10}, 4));
		
		System.out.println(findMin1(Arrays.asList(new Integer[] {60437, 60449, 61231, 61617, 61632, 61722, 61818, 61948, 62943, 62967, 63011, 63823, 65145, 65804, 65818, 66739, 66857, 67595, 69350, 71102, 71899, 72411, 72686, 73517, 74932, 76094, 76343, 76903, 77288, 77426, 77683, 78292, 79165, 79675, 79677, 80362, 80879, 80923, 82952, 83789, 83890, 84804, 85330, 87968, 88540, 89290, 89427, 89757, 89878, 91137, 91955, 92820, 93262, 94680, 95100, 96071, 96280, 96537, 96556, 97945, 98173, 98583, 99869, 76, 426, 1579, 1865, 4324, 4634, 5149, 5348, 7859, 8459, 9818, 10649, 10688, 11072, 11522, 12704, 12954, 13010, 13044, 14013, 14843, 16571, 16725, 16843, 17396, 17397, 17670, 17753, 19722, 20831, 21004, 21501, 21987, 22809, 23801, 24161, 24351, 24772, 24833, 25453, 25847, 25854, 25882, 26732, 28087, 28646, 33173, 33585, 35508, 36471, 37394, 37763, 37817, 41076, 41629, 41693, 41700, 42126, 42509, 42932, 43315, 44765, 45646, 46088, 47469, 47837, 48520, 49249, 49968, 51178, 51998, 52215, 53059, 53066, 53347, 54722, 54910, 55927, 58494, 59801, 60213})));

	}
	
	public static int binarySearch(int arr[],int target) { //array must be sorted
		
		int start = 0;
		int end = arr.length -1;
		
		while(start <= end) {
			
			int mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 
	 * Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
public static int findCount(final List<Integer> A, int B) {
        
        int start = 0;
        int end = A.size() -1;
        
        while(start <= end){
            int mid = (start+end)/2;
            
            if(A.get(mid)== B){
                int count = 0;
                for(int i=start;i<=end;i++){
                    if(A.get(i) == B){
                        count++;
                    }
                }
                return count;
            } else if(A.get(mid) > B){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return 0;   
    }

public int findCount1(final List<Integer> a, int b) 
{
    int first=binarySearch(a,b,true);
    if(first==-1)
        return 0;
    else
        return binarySearch(a,b,false)-first+1;
        
}

public int binarySearch(List<Integer> a, int b, Boolean first)
{
    int low=0,high=a.size()-1,result =-1;
    /*if(high==0 &&  a.get(high)==b)
        return 1;*/
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(a.get(mid)==b)
        {
            result=mid;
            if(first)
                high=mid-1;	 
            else
                low=mid+1;
        }
        else if(a.get(mid)>b)
            high=mid-1;
        else
            low=mid+1;
    }
    return result;
}


/**
 * Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
PROBLEM APPROACH:

Note: If you know the number of times the array is rotated, then this problem becomes trivial. If the number of rotation is x, then minimum element is A[x].
Lets look at how we can calculate the number of times the array is rotated.
 */

public static int findMin1(final List<Integer> a) {
    
    int low = 0;
    int high = a.size() -1;
    
    while(low <= high){
        int mid = (low+high)/2;
        
        if(a.get(low) <= a.get(high))
            return a.get(low);
        
        if(mid == 0 && a.get(mid) < a.get(mid+1)){
            return a.get(mid);
        }
        
        if(mid == a.size()-1 && a.get(mid) < a.get(mid-1)){
            return a.get(mid);
        }
        
        if(a.get(mid) < a.get(mid+1) && a.get(mid) < a.get(mid-1)){
            return a.get(mid);
        }else if(a.get(mid) >= a.get(low)){
            low = mid+1;
        }else if(a.get(mid) <= a.get(high)){
            high = mid -1;
        }
    }
    
    return -1;    
}

private int findMin(final List<Integer> a, int left, int right) {
    if (a.get(left) <= a.get(right))
        return a.get(left);
    int mid = (left + right) / 2;
    return Math.min(findMin(a, left, mid), findMin(a, mid + 1, right));
}

// DO NOT MODIFY THE LIST
public int findMin(final List<Integer> a) {
    int left = 0, right = a.size() - 1;
    return findMin(a, left, right);
}






}

