package Assignment3;

import java.util.ArrayList;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,7,3,5,8,3,6,9,3,2,4,7,8,0};
		int start = 0;
		int end = arr.length -1;
		for (int i:arr) {
			System.out.print(i+ ", ");
		}
		System.out.println();
		
		quickSort(arr,start,end);
		for (int i:arr) {
			System.out.print(i+ ", ");
		}
	}
	
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start>=end) {
			return;
		}
		int pivotIndex = partition(arr, start, end);
		quickSort(arr, start, pivotIndex-1);
		quickSort(arr, pivotIndex+1, end);
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pIndex = start;
		int pElement = arr[end];
		
		for(int i = start; i < end; i++) {
			if(arr[i] <= pElement) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		
		arr[end] = arr[pIndex];
		arr[pIndex] = pElement;
		
		return pIndex;

	}

}
