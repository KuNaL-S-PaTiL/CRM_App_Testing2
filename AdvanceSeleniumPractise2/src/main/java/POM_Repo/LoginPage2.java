package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	public LoginPage2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement userName;
	@FindAll({@FindBy(xpath="//input[@type=\"password\"]"),@FindBy(name = "user_password")})
	private WebElement passWord;
	@FindAll({@FindBy(xpath = "(//input[@value=\"Login\"])[2]"),@FindBy(id="submitButton")})
	private WebElement loginButton;
	
	public void loginToVtigerApp(String username,String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginButton.click();
	}
}
