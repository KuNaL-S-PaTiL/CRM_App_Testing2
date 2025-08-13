package TestNG_Practise;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



public class SampleTest {

	@Test
	public void createProduct()
	{

	System.out.println("Product is Created");

	}
	
	@Test(dependsOnMethods = "createProduct",invocationCount = 4)
	public void modifyProduct()
	{

		System.out.println("Product is Modified");
	}
	
	@Test(dependsOnMethods ="createProduct")
	public void deleteProduct()
	{
		System.out.println("Product is deleted");
	}
	
}
