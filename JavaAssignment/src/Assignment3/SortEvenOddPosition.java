package Assignment3;

public class SortEvenOddPosition {
	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 1, 6, 9, 5, -2};
		
		/*for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]%2 == 0){
					if(arr[j]%2 == 0){
						if(arr[i] > arr[j]){
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						}
					}
				}else{
					if(arr[j]%2 != 0){
						if(arr[i] > arr[j]){
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						}	
					}
				}
			}
		}*/
		
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]%2 == arr[j]%2){
					if(arr[i] > arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}

	}

}
