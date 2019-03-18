package Assignment3;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,3,2,4,5,6,7,23,2,1};
		int n = arr.length;
		for(int index=1; index<n; index++){
        	System.out.print(arr[index] + " ");
        }
        for (int index=1; index<n; index++)// insertion sort we start with second element so index = 1 
        { 
            int key = arr[index]; 
            int j = index-1; // j starts from previous element 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            
            for (;j>=0 && arr[j] > key; j--) 
            { 
                arr[j+1] = arr[j]; 
            } 
            arr[j+1] = key; //since we are doing j-- we need to add the element at j+1 location
        } 
        
        for(int index=1; index<n; index++){
        	System.out.print(arr[index] + " ");
        }
	}

}
