package Assignment1;

import java.util.Scanner;

public class CurrencyExchange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float rate;
		float amount;
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			
			System.out.print("Enter the exchange rate from dollars to RMB: ");
			rate = sc.nextFloat();
			
			System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
			
			switch(sc.nextInt()){
			case 0:
				System.out.print("Enter the Dollar amount: ");
				amount = sc.nextFloat();
				System.out.println("$"+amount+" is "+ (amount*rate) + " yuan");
				break;
			case 1:
				System.out.print("Enter the RMB amount: ");
				amount = sc.nextFloat();
				System.out.println(amount+" yuan is $"+ (amount/rate));
				break;	
			default:
				System.out.println("Invalid Option, please enter either 0 or 1");
				break;
			}
		}catch(Exception e){
			System.err.println("Error occered while processing your request.\n" + e.getMessage());
		}finally{
			if(sc!=null)
				sc.close();
		}
		
	}

}
