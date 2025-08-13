package TestNG_Practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider="getData")
	public void BookTickets(String src,String dest,int ppl)
	{
		System.out.println("Ticket is booked from " +src+ " to " +dest+ " with " +ppl+ " number of people");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="Pune";
		obj[0][1]="Banglore";
		obj[0][2]=3;
		
		obj[1][0]="Pune";
		obj[1][1]="Mumbai";
		obj[1][2]=6;
		
		obj[2][0]="Pune";
		obj[2][1]="Nashik";
		obj[2][2]=9;
		
		return obj;
	}
	
}
