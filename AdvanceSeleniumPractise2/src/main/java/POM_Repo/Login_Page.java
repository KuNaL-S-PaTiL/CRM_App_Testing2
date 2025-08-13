package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	//Element initialization
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//getter methods
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	
	// Elements Declaration
	@FindBy(name = "user_name")
	private WebElement UserNameTextField;
	
	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement LoginButton;
	
	//Business Logics/Libraries
	
	public void loginToApp(String UserName,String PassWord)
	{
		getUserNameTextField().sendKeys(UserName);
		getPasswordTextField().sendKeys(PassWord);
		getLoginButton().click();
	}
	
	
}
