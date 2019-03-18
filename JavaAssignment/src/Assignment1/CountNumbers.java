package Assignment1;

import java.util.Scanner;

public class CountNumbers {

	public static void main(String[] args) {
		float avg;
		int countPositive=0, countNegative=0, total=0, num;
		Scanner sc = null;
		try{
			sc = new Scanner(System.in);
			System.out.print("Enter an integer, the input ends if it is a 0:  ");
			while((num=sc.nextInt())!=0){
				if(num > 0){
					countPositive++;					
				}else if(num < 0){
					countNegative++;
				}
				total += num;
			}
			if(countPositive == 0 && countNegative == 0)
				System.out.println("No numbers are entered except 0");
			else{
				System.out.println("The number of positives is: "+countPositive);
				System.out.println("The number of negatives is: "+countNegative);
				System.out.println("The total is: "+total);
				System.out.println("The average is: " + total/(float)(countPositive+countNegative));
			}
		}catch(Exception e){
			System.err.println("Error occered while processing your request.\n" + e.getMessage());
		}finally{
			if(sc!=null)
				sc.close();
		}
	}
}
