package assignment8; //Package Declaration is necessary
import java.io.*; // import java io package
/*
 This program will help you understand the concepts of File Handling.
 */
public class Assignment8_1 
{

	public static void main(String[] args) // main method starts
	{
		// TODO Auto-generated method stub
		try
		{
		
		FileReader fr=new FileReader("C:\\Personal\\file.txt"); // FileReader class object for source file.
		
		File file=new File("C:\\Personal\\file1.txt"); // creating the object of File class and providing path of destination file.
		
		if(!file.exists()) // check if destination file not exists then create it
		{
			file.createNewFile(); // creating the destination file
		}
		
		
		FileWriter fw =new FileWriter(file); // FileWriter class object for destination file.
		
		int i=fr.read(); // pointer to the source file
		
		// logic to read the contents of source file and writing to destination file
		while(i!=-1) // looping through the source file till all the contents are read.
		{
			fw.write(i);
			i=fr.read();
		}
		
		fr.close(); // closing the source file
		fw.close(); // closing the destination file
		System.out.println("Contents of Source File copied to Destination File");
		}
		
		// catching the exceptions 
		catch (FileNotFoundException fe ) 
		{
			fe.printStackTrace();
			
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

}
