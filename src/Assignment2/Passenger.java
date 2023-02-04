package Assignment2;
import java.util.*;

public class Passenger {
	String name;
	char gender;
	int age;
	String address;
	int passportNumber;
	int destination;
	int typeOfPlane;


	Passenger(){
	name="abc";
	gender='0';
	age=0;
	address="/0";
	passportNumber=0;
	destination=0;
	typeOfPlane=0;

	}

	Passenger(String a, char b, int c, String d, int e, int f, int g){
		name=a;
		gender=b;
		age=c;
		address=d;
		passportNumber=e;
		destination=f;
		typeOfPlane=g;

	}

	Scanner inp1 = new Scanner(System.in);

	public void  enterInfo() throws GenderInvalidException{
		System.out.println("Enter your name");
		String n=inp1.next();
		name=n;
	}
	
	
	

    public void setName(String a)
    {
    	name=a;
    }
    
    public void setGender(char a)
    {
    	gender=a;
    }
    
    public void setAge(int a)
    {
    	age=a;
    }
    
    public void setAddress(String a)
    {
    	address=a;
    }
    

	public void setPnumber(int a) {
	
		passportNumber=a;
	}
    
	public void setDestination(int a) {
		
		destination=a;
	}

	public void setPType(int a) {
		typeOfPlane=a;
	}

	
}
