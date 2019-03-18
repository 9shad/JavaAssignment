package Assignment3;

public class SegmentSorting {

	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 5, 3, 8, 6, 2};
		int segment = 3;
		
		for(int i = 0; i < arr.length;i += segment){
			//first loop goes from segment to segment
			for(int j = i; j < (i + segment - 1) && j < arr.length ; j++ ){
				//second loop starts from i and goes up to segment length - 1 and j must be less than array size
				for(int k = j+1 ; k < (i + segment) && k < arr.length ; k++){
					//third loop starts from j+1 and goes up to segment length and k must be less than array size
					if(arr[j] > arr[k]){
						int temp = arr[j];
						arr[j] = arr[k];
						arr[k] = temp;
					}
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			if(i%segment == 0 & i!=0){
				System.out.print("| ");
			}
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
		//Part B
		int evenSegmentArrLength = segment * (arr.length/segment); // considering only full segments and leaving the last uneven segment for now
		
		//sorts all segments excluding the last segment if it has elements less than segment size
		for(int i=0;i<evenSegmentArrLength;i+=segment){
			int index = i;
			for(int j=i+segment;j<evenSegmentArrLength;j+=segment){
				if(arr[index] > arr[j]){
					index = j;
				}
			}
			int tempIndex = i;
			if(index!=i){
				for(int j = 0;j<segment;j++){
					int tmp = arr[index];
					arr[index] = arr[tempIndex];
					arr[tempIndex] = tmp;
					index++;
					tempIndex++;
				}
			}
		}
		
		//if there is an odd segment then we consider that in following code
		if(arr.length - evenSegmentArrLength !=0){ //if non zero then there is odd segment at end of array
			//copying the last segment in to temp array
			int[] temp = new int[arr.length-evenSegmentArrLength];
			for(int i=0; i<temp.length;i++){
				temp[i] = arr[evenSegmentArrLength+i];
			}

			//finding the correct position to place last segment by comparing first element of that segment with other segment's first element
			int index = evenSegmentArrLength;
			for(int i = 0; i< arr.length ; i+=segment){
				if(arr[evenSegmentArrLength] < arr[i]){
					index = i;
					break; //since remaining array is sorted by initial segment element we break when we find the correct position
				}
			}
			
			//checking if the array needs shuffling based on position we found in previous step
			if(evenSegmentArrLength != index)//meaning it needs a shuffle
			{
				//moving elements to place the odd segment in correct place
				int count = 1;
				for(int i=evenSegmentArrLength-1; i>=index; i--){
					arr[arr.length-count] = arr[i];
					count++;
				}
				//placing odd segment in correct place
				for(int i = index, j=0; j< temp.length ; i++,j++){
					arr[i] = temp[j];
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");
		}
	}

}
