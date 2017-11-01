package assignment8; //Package Declaration is necessary
import java.util.Scanner; // Import Scanner class
/*
This program will check whether number is prime or not by implementing Runnable interface
*/
public class PrimeNumberRunnable implements Runnable // class implementing Runnable interface
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
		
		PrimeNumberRunnable obj = new PrimeNumberRunnable(); //creating the object of PrimeNumberRunnable class
		Thread rt = new Thread(obj); // passing the object of PrimeNumberRunnable class to Thread class object
		rt.start(); // calling the start method of Thread class
	}

}

