package assignment8; //Package Declaration is necessary
import java.util.Scanner; // Import Scanner class
/*
 This program will check whether number is prime or not by extending Thread class
 */
public class Assignment8_2 extends Thread // class extending Thread class
{

	public void run() 
	{
		try
		{	
	
		// variables declaration
		int number;
		boolean isPrime=true;
		
		Scanner input= new Scanner(System.in); // Scanner to take input from user
		System.out.println("Enter the number :");
		number=input.nextInt(); // Initialize the number
		input.close();
		
		// logic to check whether number is prime or not
		for (int i=2;i<=number/2;i++)
		{
			if (number%i==0) // check if number is divisible by any other number except itself and 1
			{
				isPrime=false;
				break;
			}
			i++;
		}
		
		// checking the conditions returned by above for loop for printing whether number is prime or not
		if(isPrime==false || number==1) 
		{
			System.out.println(number+" is not prime");
		}
		else
		{
			System.out.println(number+" is prime");
		}
		
		}
		// catching exception 
		catch(Exception e)
		{
			e.printStackTrace(); // printing StackTrace for exception 
		}
	}
	public static void main(String[] args) // main method starts
	{
		// TODO Auto-generated method stub
		
		Assignment8_2 pmobj = new Assignment8_2(); // creating object of Assignment8_2 class 
		pmobj.start(); // calling the start method of Thread class 
		

	}

}

