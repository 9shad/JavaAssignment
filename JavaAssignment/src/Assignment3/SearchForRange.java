package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> list = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,8});
		System.out.println(searchRange(list, 8));
	}
	
	/**
	 * 
	 * 
	 * Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].
	 * 
	 */
	
	public static ArrayList<Integer> searchRange(final List<Integer> arr, int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean findFirstOccurence = true; //move left every time we find the element
		
		result.add(binarySearch(arr, target, findFirstOccurence));
		result.add(binarySearch(arr, target, !findFirstOccurence));

		return result;
	}
	
	public static int binarySearch(final List<Integer> arr, int target, boolean findFirstOccurence) {
		int start = 0;
		int end = arr.size()-1;
		int result = -1;
		
		while(start<=end) {
			int mid = (start+end)/2;	
			if(arr.get(mid) == target) {
				result = mid;
				if(findFirstOccurence) {
					end = mid -1;
				}else {
					start = mid + 1;
				}
			}else if(target > arr.get(mid)) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		return result;
	}

}
