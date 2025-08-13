package Practise;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonIphoneColours {
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.xpath("(//input[@class=\"nav-input nav-progressive-attribute\"])[1]")).sendKeys("Iphone"+Keys.ENTER);
	
	 List<WebElement> ele = driver.findElements(By.xpath("//h2[@aria-label=\"iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Teal\"]/../../..//div[@class=\"a-section s-color-swatch-container s-color-swatch-container-left-aligned s-quick-view-text-align-start\"]//a"));
	for(int i =0; i<ele.size();i++)
	{
		@Nullable
		String colours = ele.get(i).getAttribute("aria-label");
		System.out.println(colours);
	}
	 
	 driver.quit();
}
}
