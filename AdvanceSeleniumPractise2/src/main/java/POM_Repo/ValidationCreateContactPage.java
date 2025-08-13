package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationCreateContactPage {

	public ValidationCreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateContactCreated(WebDriver driver,String FN,String LN)
	{
		 String FNactData = driver.findElement(By.xpath("//span[@id=\"dtlview_First Name\"]")).getText();
		 String LNactData = driver.findElement(By.xpath("//span[@id=\"dtlview_Last Name\"]")).getText();
		 
//		 if(FN.contains(FNactData)&&(LN.contains(LNactData)))
//		 {
//			 System.out.println("Contact is created");
//		 }
//		 else
//		 {
//			 System.out.println("Contact is not created");
//		 }
		 Assert.assertEquals(FN, FNactData , "Contact is not created");
		 Assert.assertEquals(LN, LNactData , "Contact is not created");
		 System.out.println("Contact is created");
	}
	
}
