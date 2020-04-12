package solid.lsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturningUserViewLoginPage {
	
	public static WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	
	
	@FindBy(name="userName") WebElement fieldUserName;
	@FindBy(name="password") WebElement fieldUserPassword;
	@FindBy(xpath="//input[@alt='Sign-In']") WebElement signInButton;
	
	
		
	public ReturningUserViewLoginPage(WebDriver driver) {
		
		ReturningUserViewLoginPage.driver = driver;
		
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

}

class AdminViewLoginPage extends ReturningUserViewLoginPage {

	public AdminViewLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void adminUserButton() {
		//Implement Admin user button here
	}
		
}

class NewUserViewLoginPage extends ReturningUserViewLoginPage {

	public NewUserViewLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void NewnUserButton() {
		//Implement New user button here
	}
	
}
