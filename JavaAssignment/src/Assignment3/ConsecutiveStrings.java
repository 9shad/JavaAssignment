package Assignment3;

public class ConsecutiveStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] arr = {"cde", "ab", "ab", "ab", "ab", "c", "c","d"};
		String[] arr = {"cde", "ab", "ab", "dddd", "dddd", "dddd", "abcde"}; 
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		for(int k=0;k<getCountOfUniqueElements(arr)-1;k++)//run outer loop for count of unique elements
		for(int i=0;i<arr.length-2;i++){
			if(!(arr[i].equals(arr[i+1]))){
				int countOfCurrentElement = getCurrentElementCount(arr, arr[i]);
				int countOfNextElement = getCurrentElementCount(arr, arr[i+1]);
				
				if(countOfCurrentElement < countOfNextElement){
					String currentElement = arr[i];
					String nextElement = arr[i+1];
					int nextElementStartIndex = i+1;
					int nextElementEndIndex = nextElementStartIndex + countOfNextElement;
					int currentElementStartIndex = getStartIndexOfElement(arr, currentElement);
					for(int j=currentElementStartIndex ; j<nextElementEndIndex-countOfCurrentElement; j++){
						arr[j] = nextElement;
					}
					for(int j=nextElementEndIndex-countOfCurrentElement ; j<nextElementEndIndex; j++){
						arr[j] = currentElement;
					}
				}
			}			
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	public static int getCurrentElementCount(String[] arr, String element){
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i].equals(element)){
				count++;
			}
		}
		return count;
	}
	public static int getStartIndexOfElement(String[] arr, String element){
		for(int i=0; i<arr.length; i++){
			if(arr[i].equals(element)){
				return i;
			}
		}
		return 0;
	}
	public static int getCountOfUniqueElements(String[] arr){
		int count = 1;
		
		for(int i=0; i<arr.length; i++){
			if(i+1 < arr.length && !(arr[i].equals(arr[i+1]))){
				count++;
			}
		}
		
		return count;
	}
}
