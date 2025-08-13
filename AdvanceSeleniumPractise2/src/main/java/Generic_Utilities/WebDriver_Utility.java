package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait for elements to load
	 * @param driver
	 */
	public void waitForElimentsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used to perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to switch window
	 * @param driver
	 * @param PartialTitle
	 */
	public void switchToWindow(WebDriver driver,String PartialTitle)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> it = allWins.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			@Nullable
			String title = driver.getTitle();
			if(title.contains(PartialTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * This Method is used to handle drop down
	 * @param driver
	 * @param Value
	 * @param dropDownElement
	 */
	public void DropDownSelectByValue(WebDriver driver,String Value,WebElement dropDownElement) 
	{
	Select s = new Select(dropDownElement);
	s.selectByValue(Value);
	}
	
	/**
	 * This method is used to accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public static String takeSCreenShotEx(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
}
}
