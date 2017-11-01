package assignment8; //Package Declaration is necessary
/*
 This program implements the basic functions for the online Banking Application
 using Multithreading & Synchronization.
 */
class BankAccount // class having basic bank functions
{
	// variable declaration
	int balance=1000;
	
	// function to return balance
	public int getBalance()
	{
		return balance;
	}
	
	// function to withdraw amount
	public void withdraw(int amt)
	{
		balance=balance-amt;
	}
	
	// function to deposit amount
	public void deposit(int amt)
	{
		balance=balance+amt;
	}
}

public class Assignment8_3 implements Runnable //class implementing Runnable interface
{

	private BankAccount acc=new BankAccount(); // creating object of BankAccount class
	public static void main(String[] args) // main method starts
	{
		// TODO Auto-generated method stub
		
		Assignment8_3 r=new Assignment8_3(); // creating the object of Assignment8_3 class 
		
		// passing the object of Assignment8_3 class to Threads
		Thread t1 = new Thread(r); 
		Thread t2 = new Thread(r);
		
		// setting the name of Threads
		t1.setName("Madhav"); 
		t2.setName("Varun"); 
	
		// calling the start method of Threads
		t1.start();
		t2.start();
	}	
	
	public void run() // run method of Thread
	{
		// loop to call withdrawal and deposit methods
		for (int i=0;i<3;i++)
		{
			accountWithdrawal(100);
			if(acc.getBalance()<0)
			{
				System.out.println("Balance overdrawn");
			}
		}
		
		for (int i=0;i<3;i++)
		{
			accountDeposit(50);
		}
	}
	
	// synchronizing accountWithdrawal method
	public synchronized void accountWithdrawal(int amt)
	{
		if(acc.getBalance()>100)
		{
			System.out.println(Thread.currentThread().getName()+" will withdraw the amount"); // printing the name of current thread that will withdraw
			try
			{
				Thread.sleep(1000); // sleeping the thread for 1 second
			}
			catch(InterruptedException ie) // catching the exception
			{
				ie.printStackTrace(); // printing the StackTrace for exception
			}
			acc.withdraw(amt); // calling the withdraw method
			System.out.println(Thread.currentThread().getName()+" completed withdrawal of amount : "+amt); // printing the name of current thread which has completed withdrawal
		}
		
		else
		{
			System.out.println("Not enough balance to withdraw for "+Thread.currentThread().getName()); // printing the message if there is not enough balance in account
		}
		
	
	}
	
	// synchronizing accountDeposit method
	public synchronized void accountDeposit(int amt)
	{

		System.out.println(Thread.currentThread().getName() + " going to deposit the amount"); // printing the name of current thread that will deposit
		
		try
		{
		Thread.sleep(1000); // sleeping the thread for 1 second
		}
		
		catch(InterruptedException ie) // catching the exception
		{
			ie.printStackTrace(); // printing the StackTrace for exception
		}
		
		acc.deposit(amt); // calling the deposit method
		System.out.println(Thread.currentThread().getName() + " completed the deposit of amount : "+amt); // printing the name of current thread which has completed deposit
	
	}
	
}
