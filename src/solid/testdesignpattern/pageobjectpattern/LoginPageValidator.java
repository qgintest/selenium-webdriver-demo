package solid.testdesignpattern.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPageValidator {
	
	private WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	

	public LoginPageValidator(WebDriver driver) {
		this.driver = driver;
	}
	
	protected LoginPageMap Map() {
		return new LoginPageMap(this.driver);
	}
	
	public void ResultsCount(String expectedCount) {
		Assert.assertTrue(this.Map().userName().getText().contains("username"), "Invalid username text");
	}
	

}
