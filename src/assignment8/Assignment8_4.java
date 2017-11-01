package assignment8; //Package Declaration is necessary
import java.util.Scanner; // import Scanner class
/*
 This program will help to reserve tickets in an Online Bus Reservation System using Synchronization.
 */
class Bus
{
	// variables declaration
    private final int [] seats = new int[50];
    private int nextSeat = 0;
    int bookedSeats;
    int seatsAvailable;
    
    public void bookSeat(String passengerName) throws Exception // method for booking seats
    {
    	Scanner input=new Scanner(System.in); // Scanner to take input from user
    	System.out.println("Enter the number of seats to be booked by:"+passengerName);
    	bookedSeats=input.nextInt(); // Initialize bookedSeats variable
    	
    	// logic for booking number of seats entered by passenger
    	for (int i=1;i<=bookedSeats;i++)
    	{
    		if(nextSeat<seats.length) // if seats are available then only booking can be done
    		{
    			seats[nextSeat]=nextSeat; //array variable to book seat
    			nextSeat++;
    			System.out.println("Seat number " +nextSeat+ " booked by "+passengerName);
    		}
    		else
    		{
    			System.out.println("The bus is full sorry"); // printing message if no more seats are available 
    		}
        
    	} 
    	
    	seatsAvailable=seats.length-nextSeat; // calculating available seats
    	System.out.println("Total seats Available :"+seatsAvailable); // printing total seats available
    	System.out.println("Total seats booked till now :"+nextSeat); // printing total booked seats till now
    	
    	
    	
}
    
}

class Booking extends Thread // Booking class extending Thread class
{

	// variables declaration
    Bus bus;
    private String passengerName;

    public Booking(Bus bus, String passengerName) // parameterized constructor of Booking class
    {
        this.bus=bus;
        this.passengerName=passengerName;
    }

    public void run() // run method 
    {
        synchronized(bus) // synchronizing the object of Bus class
        {
            try 
            {
                bus.bookSeat(passengerName); // calling the bookSeat method of Bus class
            } 
            catch (Exception ex) // catching the exception
            {
               ex.printStackTrace(); // // printing the StackTrace for exception
            }

        }
    }

    public String getPassengerName() //return passenger name
    {
        return passengerName;
    }

    public void setPassengerName(String passengerName) // set passenger name
    {
        this.passengerName = passengerName;
    }
    
   
}

public class Assignment8_4 // main class
{
    public static void main(String [] args)  // main method starts
    {
        Bus obj = new Bus(); // object of Bus class

        // creating the objects of Booking class
        Booking b1 = new Booking(obj,"Madhav");
        Booking b2 = new Booking(obj, "Ajay");

        // calling the start method of objects
        b1.start();
        b2.start();

    }
}
