package solid.testdesignpattern.factorypattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public static WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	
	
	@FindBy(name="userName") WebElement fieldUserName;
	@FindBy(name="password") WebElement fieldUserPassword;
	@FindBy(xpath="//input[@alt='Sign-In']") WebElement signInButton;
	
	
		
	public LoginPage(WebDriver driver) {
		
		LoginPage.driver = driver;
		
		PageFactory.initElements(driver, this);
		System.out.println("elements initalized");
	}
	
	public void setUserName() {
		fieldUserName.sendKeys(userName);
	}
	
	public void setPassword() {
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
