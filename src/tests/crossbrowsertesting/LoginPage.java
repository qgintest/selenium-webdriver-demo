package tests.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SyncDriver {
	
	public static WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	
	
	@FindBy(name="userName") WebElement fieldUserName;
	@FindBy(name="password") WebElement fieldUserPassword;
	@FindBy(xpath="//input[@alt='Sign-In']") WebElement signInButton;
	
	
		
	public LoginPage(WebDriver driver) {
		
		LoginPage.driver = driver;
		
		PageFactory.initElements(driver, this);
		//System.out.println("elements initalized");
	}
	
	public void setUserName() {
		SyncDriver.waitUntilElementIsVisible(driver, fieldUserName, 5);
		fieldUserName.sendKeys(userName);
	}
	
	public void setPassword() {
		SyncDriver.waitUntilElementIsVisible(driver, fieldUserPassword, 5);
		fieldUserPassword.sendKeys(password);
	}
	
	public void clickOnSignButton() {
		signInButton.click();
	}
	
	public void loginToMercuryTours() {
		setUserName();
		setPassword();
		clickOnSignButton();
	}

}
