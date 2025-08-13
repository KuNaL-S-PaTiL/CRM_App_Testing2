package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ValidationOfCreateProduct {

	public ValidationOfCreateProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to validate if product is created or not
	 * @param driver
	 * @param PrdName
	 */
	public void validateProductCreated(WebDriver driver,String PrdName)
	{
		   String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
		   
//		   if(actData.equals(PrdName))
//		   {
//			   System.out.println("Product is created");
//		   }
//		   else
//		   {
//			   System.out.println("Product is not created");
//		   }
		   
		   //Hard Assert
//		   Assert.assertEquals(actData, PrdName , "Product is not created");
//			System.out.println("Product is created");
		   
		   //Soft Assert
		   SoftAssert soft = new SoftAssert();
		   soft.assertEquals(actData, PrdName , "Product is not created");
		   System.out.println("Product is created");
		   soft.assertAll();
	}
}
