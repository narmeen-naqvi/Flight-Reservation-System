/*
 * Syeda Narmeen
 * 19I-0635
 * Assignment # 2
 */
package Assignment2;
import java.util.*;
import java.io.*;



public class Main {
	public static void main(String[] args) throws GenderInvalidException, AgeInvalidException, PnumberInvalidException, FlightInvalidException, PlaneTypeInvalidException, FlightException {
	
		try {
			FileWriter file = new FileWriter("flights.txt");
			file.write("1 for America, ");
			file.write("2 for Pakistan, ");
			file.write("3 for Australia, ");
			file.write("4 for India, ");
			file.write("5 for Netherlands");
			file.close();
		}catch(IOException e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
		
	String names[]= {"Pakistan", "America", "Australia", "India", "Netherlands"};
		
	Scanner inp1 = new Scanner(System.in); 
	Passenger arr[];
	arr =new Passenger[5];
	Flight flight[];
	flight =new Flight[5];
	
	for(int i=0;i<5;i++)
	{
		flight[i]=new Flight();
		flight[i].setOrigin(names[i]);
		flight[i].setDestination(0);
		flight[i].setNumOfPassengers(0);
		flight[i].setDate(0, 0, 0);
		flight[i].setTravelDocumentId(i+1);
	}
	
	for(int i=0;i<5;i++)
	{
		arr[i]=new Passenger();
		System.out.println("Enter your name");
		String n=inp1.next();
		arr[i].setName(n);
		
		System.out.println("Enter your gender; m for male, f for female");
		char g=inp1.next().charAt(0);
		
		if(g!='m' && g!='f')
		{
			throw new GenderInvalidException("You entered an Invalid Gender");
		}
		else
		{
			arr[i].setGender(g);
		}
		
		System.out.println("Enter your age");
		int a=inp1.nextInt();
		if(a<0 || a>80)   //Elder passengers not allowed to travel by air
		{
			throw new AgeInvalidException("You entered an Invalid Age");
		}
		else
		{
			arr[i].setAge(a);
		}
		
		System.out.println("Enter your address");
		String ad=inp1.next();
		arr[i].setAddress(ad);
		
		System.out.println("Enter your passport number ");
		int p= inp1.nextInt();
		if(p<0 || p>999)
		{
			throw new PnumberInvalidException("You entered an Invalid Passport Number");
		}
		else
		{
			arr[i].setPnumber(p);
		}
		
		System.out.println("Enter your destination");
		
		try {
			FileReader file = new FileReader("flights.txt");
			Scanner s=new Scanner(file);
			while(s.hasNextLine())
			{
				String data=s.nextLine();
				System.out.println(data);
			}
			file.close();
		}catch(IOException e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
		
		int k=0;
		int f= inp1.nextInt();
		if(f<1 || f>5)
		{
			throw new FlightInvalidException("You entered an Invalid flight");
		}
		else
		{
			for(int j=0;j<5;j++)
			{
				if(flight[j].getTravelDocumentId()==f)
					 k=j;
			}
	
			if(flight[k].isFull()==0)
			{
				arr[i].setDestination(f);
				flight[k].setNumOfPassengers(flight[k].getNumOfPassengers() + 1);
			}
			else
			{
				throw new FlightException("There are no seats available on this flight");
			}
				
			
		}
		
		System.out.println("Enter your type of plane: 1 for Airbus, 2 for Boeing ");
		int t= inp1.nextInt();
		if(t!=1 && t!=2)
		{
			throw new PlaneTypeInvalidException("You entered an Invalid plane type");
		}
		else
		{
			arr[i].setPType(t);
		}
		
		System.out.println("Enter your destination");
		int d= inp1.nextInt();
		flight[k].setDestination(d);
	}
	

	
	}

}
