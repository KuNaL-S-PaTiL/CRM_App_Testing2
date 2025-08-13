package POM_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationForCreateProductAndDeleteProduct {

	public ValidationForCreateProductAndDeleteProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateForProductIsDeleted(WebDriver driver,String prdName)
	{
		List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
	 	boolean flag=false;
	 	for (WebElement prd : prdData)
	 	{
	 		String actPrd = prd.getText();
	 		if(actPrd.contains(prdName))
	 		{
	 			flag=true;
	 			break;
			}
	 	}
//	 	if(flag)
//	 	{
//	 		System.out.println("Product Name is Deleted");
//	 	}
//	 	else
//	 	{
//	 		System.out.println("Product Name is not Deleted");
//	 	}
	 	Assert.assertTrue(flag, "Product Name is not Deleted");
	 	System.out.println("Product Name is Deleted");
	}
}
