package Assignment3;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {6,7,3,5,8,3,6,9,3,2,4,7,8,0};
		int start = 0;
		int end = arr.length -1;
		for (int i:arr) {
			System.out.print(i+ ", ");
		}
		System.out.println();
		mergeSort(arr,start,end);
		
		for (int i:arr) {
			System.out.print(i+ ", ");
		}
		
	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		if(start == end) {
			return;
		}
		int mid = (start + end)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr,start,mid,end);
	}
	
	public static void merge(int[] arr,int start,int mid, int end) {
		int[] temp = new int[end-start+1];
		int i = start;
		int j = mid+1;
		int index = 0;
		while(i<=mid && j<=end) {
			if(arr[i] <= arr[j]) {
				temp[index] = arr[i];
				i++;
			}else {
				temp[index] = arr[j];
				j++;
			}
			index++;
		}
		while(i<=mid) {
			temp[index++] = arr[i++];
		}
		
		while(j<=end) {
			temp[index++] = arr[j++];
		}
				
		for(int k = start; k <= end; k++) {
			arr[k] = temp[k-start];
		}
	}
}
