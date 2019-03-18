package Assignment1;

import java.util.Scanner;

public class CompoundValue {

	public static void main(String[] args) {
		float rate, monthlyIntrestRate;
		int amount, months;
		float totalAmount = 0;
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			
			System.out.print("Enter an amount: ");
			amount = sc.nextInt();
			
			System.out.print("Enter annual intrest rate: ");
			rate=sc.nextFloat();
			
			System.out.print("Enter number of months: ");
			months = sc.nextInt();
			
			monthlyIntrestRate = rate/1200f; // i.e. (rate/100)/12f is similar to rate/12*100
			
			System.out.println(monthlyIntrestRate);
			for(int i=1;i<=months;i++){
				System.out.println(totalAmount);
				totalAmount = (amount + totalAmount) * (1 + monthlyIntrestRate); 
				
			} 
			System.out.println("Amount in saving account after "+months+" months will be: "+totalAmount);
			
		}catch(Exception e){
			System.err.println("Error occered while processing your request.\n" + e.getMessage());
		}finally{
			if(sc!=null)
				sc.close();
		}
	}

}
