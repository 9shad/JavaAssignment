package Assignment3;

public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 1, 6, 9, 5, -2};
		for(int i=0;i<arr.length-1;i++){
			int index = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[index]>arr[j]){
					index = j;
				}
			}
			if(index != i){
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}
