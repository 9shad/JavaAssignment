package Assignment3;

public class MidArraySortig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {3,2,4,5,3,4,3,2,1,1,6,7,8,5,43,5,6,4,3,8,9};
		
		for(int index = 0; index < arr.length; index++){
			System.out.print(arr[index]+" ");
		}
		
		for(int i=0; i < arr.length-1; i++){
			for(int j=i+1; j < arr.length; j++){
				if(i < arr.length/2){
					if(arr[i] > arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}else{
					if(arr[i] < arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		System.out.println();
		for(int index = 0; index < arr.length; index++){
			System.out.print(arr[index]+" ");
		}
	}

}
