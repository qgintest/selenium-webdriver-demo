package testframework.mercurytours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MercuryToursPageRepository {
	
	public static WebDriver driver;
	
	
	final static String userName = "aeendale";
	final static String password = "Postal12Postal12";

	
	
	@FindBy(name="userName") WebElement fieldUserName;
	@FindBy(name="password") WebElement fieldUserPassword;
	@FindBy(xpath="//input[@alt='Sign-In']") WebElement signInButton;
	
	@FindBy(xpath="//input[@value='oneway']") WebElement flightFinderContinue;
	
	//Passegner Details
	@FindBy(name="passCount") WebElement passengerCountDropDownMenu;
	
	@FindBy(xpath="//a[@href='mercuryreservation.php']") WebElement backToFlightFinderButton;
	
	
		
	public MercuryToursPageRepository(WebDriver driver) {
		
		MercuryToursPageRepository.driver = driver;
		
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
	
	public void clickOnFlightContinue() {
		flightFinderContinue.click();
	}
	
	public void clickOnbackToFlightFinderButton() {
		backToFlightFinderButton.click();
	}
	
	public void selectPassengerFromDropDown(int index) {
		Select passengerDropDownMenu = new Select(backToFlightFinderButton);
		passengerDropDownMenu.selectByIndex(index);
	}

}
