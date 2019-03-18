package Assignment1;

import java.util.Scanner;

public class CheckANumber {

	public static void main(String[] args) {
		int number1;
		try{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter First number: ");
			number1 = sc.nextInt();
			
			if(number1%5 == 0 && number1%6 == 0){
				System.out.println(number1 +  " is divisible by both 5 and 6");
			}else if (number1%5 == 0 || number1%6 == 0){
				System.out.println(number1 +  " is divisible by either 5 or 6, but not both");
			}else{
				System.out.println(number1 +  " is not divisible by either 5 or 6");
			}
			
		}catch(Exception e){
			System.err.println("Error occered while processing your request.\n" + e.getMessage());
		}
	}

}
