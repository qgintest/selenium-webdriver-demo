package solid.testdesignpattern.pageobjectpattern;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	protected LoginPageMap Map(){
		return new LoginPageMap(this.driver);
	}
	
	public LoginPageValidator Validate() {
		return new LoginPageValidator(this.driver);
	}
	
	public void loginToMercuryTours() {
		this.Map().userName().sendKeys(userName);
		this.Map().password().sendKeys(password);
		this.Map().signInButton().click();
	}
}
