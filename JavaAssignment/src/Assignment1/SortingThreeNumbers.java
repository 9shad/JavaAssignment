package Assignment1;

import java.util.Scanner;

public class SortingThreeNumbers {

	public static void main(String[] args) {
		double num1,num2,num3;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		num1 = sc.nextDouble();
		
		System.out.print("Enter second number: ");
		num2 = sc.nextDouble();
		
		System.out.print("Enter third number: ");
		num3 = sc.nextDouble();
		
		displaySortedNumbers(num1, num2, num3);
		displaySortedNumber(num1, num2, num3);
	}
	
	public static void displaySortedNumbers( double num1, double num2, double num3) {
		double[] arr = { num1, num2, num3 };
		
		for(int i=0; i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					double temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("Sorted array is:");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void displaySortedNumber( double num1, double num2, double num3) {
		System.out.println("");
		if(num1 < num2 && num1 < num3){
			System.out.print(num1+ " ");
			if(num2 < num3)
				System.out.print(num2+ " " + num3);
			else
				System.out.print(num3+ " " + num2);
		}else if(num2 < num1 && num2 < num3){
			System.out.print(num2+ " ");
			if(num1 < num3)
				System.out.print(num1+ " " + num3);
			else
				System.out.print(num3+ " " + num1);
		}else{
			System.out.print(num3+ " ");
			if(num1 < num2)
				System.out.print(num1+ " " + num2);
			else
				System.out.print(num2+ " " + num1);
		}
		
	}
}
