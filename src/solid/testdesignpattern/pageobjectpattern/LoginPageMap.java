package solid.testdesignpattern.pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

public class LoginPageMap {
	
	private WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	
	
	//@FindBy(name="userName") WebElement fieldUserName;
	//@FindBy(name="password") WebElement fieldUserPassword;
	//@FindBy(xpath="//input[@alt='Sign-In']") WebElement signInButton;
	
	
		
	public LoginPageMap(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement userName() {
		return this.driver.findElement(By.name("aeendale"));
	}
	
	public WebElement password() {
		return this.driver.findElement(By.name("aeendale"));
	}
	
	public WebElement signInButton() {
		return this.driver.findElement(By.name("aeendale"));
	}
}
