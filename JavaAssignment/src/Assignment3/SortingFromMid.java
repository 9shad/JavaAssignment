package Assignment3;

public class SortingFromMid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 8, -1, 7, 6, 3, 10, -7, -9}; //should always have odd number of elements
		int mid = arr.length / 2;
		
		boolean outerLoopGoLeft = false;
		boolean innerLoopGoLeft = false;
		
		int outerCount = 1;
		int innerCount;
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		for(int i = mid; i>=0 && i<arr.length && outerCount <arr.length;){
			int index = i;
			innerCount = outerCount;
			int j=i;
			for(;j>=0 && j<arr.length && innerCount<arr.length;){
				if(innerLoopGoLeft){
					j = j - innerCount;
					innerLoopGoLeft = false;
				}else if(!innerLoopGoLeft){
					j = j + innerCount;
					innerLoopGoLeft = true;
				}
				if(arr[index] > arr[j]){
					index = j;
				}
				innerCount++;
			}
			if(i!=index){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
	
			if(outerLoopGoLeft){
				i = i - outerCount;
				outerLoopGoLeft = false;
			}else if(!outerLoopGoLeft){
				i = i + outerCount;
				outerLoopGoLeft = true;
			}
			outerCount++;
			if(outerCount%2==0){ //for next inner iteration, deciding where J should go first
				innerLoopGoLeft = true;
			}else{
				innerLoopGoLeft = false;
			}
		}
		System.out.println();
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
