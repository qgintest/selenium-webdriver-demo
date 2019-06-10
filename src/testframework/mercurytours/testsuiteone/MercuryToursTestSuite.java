package testframework.mercurytours.testsuiteone;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testframework.mercurytours.pages.MercuryToursPageRepository;

public class MercuryToursTestSuite {

	static WebDriver driver;
	
	MercuryToursPageRepository mercuryToursPage;

	@Parameters({ "MercuryToursURL" })
	@BeforeClass
	public void setup(String Url) {
		
		final String InitDriver = "webdriver.chrome.driverr";
		final String startDriver = "lib" + File.separator + "chromedriver";

		System.setProperty(InitDriver, startDriver);

		driver = new ChromeDriver();
		
		mercuryToursPage = new MercuryToursPageRepository(driver);

		driver.get(Url);

		Assert.assertEquals(driver.getCurrentUrl(), Url);

		mercuryToursPage.setUserName();
		mercuryToursPage.setPassword();
		mercuryToursPage.clickOnSignButton();
		
		//loginToMercuryTours("aeendale", "Postal12Postal12");
		
		mercuryToursPage.clickOnFlightContinue();
		//driver.findElement(By.xpath("//input[@value='oneway']")).click();

		System.out.println("Mercury Tours Before Test");
	}

//	public static void loginToMercuryTours(String username, String password) {
//		// Login to Mercury Tours
//		//driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
//		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
//		//driver.findElement(By.xpath("//input[@alt='Sign-In']")).click();
//	}

	@AfterClass
	public void teardown() {

		driver.quit();
		System.out.println("Mercury Tours After Test");
	}

	@BeforeMethod
	public void beforeEachTest() {
		
		System.out.println("Landed on Flight Finder Page");
	}

	@AfterMethod
	public void afterEachTest() {
		
		mercuryToursPage.clickOnbackToFlightFinderButton();
		//driver.findElement(By.xpath("//a[@href='mercuryreservation.php']")).click();
		System.out.println("After each test");
	}

	@Test(enabled = false)
	public void bookFlightsFromFrankfurt() throws Exception {

		mercuryToursPage.selectPassengerFromDropDown(1);
		//Select passengerDropDownMenu = new Select(driver.findElement(By.name("passCount")));
		//passengerDropDownMenu.selectByIndex(1);
		Thread.sleep(1000);

		Select fromPortDropDownMenu = new Select(driver.findElement(By.name("fromPort")));
		fromPortDropDownMenu.selectByVisibleText("Frankfurt");


		Select airlinesOptions = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		airlinesOptions.selectByVisibleText("No Preference");

		driver.findElement(By.cssSelector("input[name=findFlights]")).click();

		driver.findElement(By.name("reserveFlights")).click();

		// Enter flight info and purchase
		Select meanPreferenceDropDown = new Select(driver.findElement(By.name("pass.0.meal")));
		List<WebElement> allMealOptions = meanPreferenceDropDown.getOptions();

		// select all meal options
		for (WebElement meal : allMealOptions) {
			meal.click();
		}

		driver.findElement(By.name("buyFlights")).click();


		System.out.println("Mercury Tours Test A");
	}

	@Test(enabled = false)
	public void bookFlightsFromLondon() throws Exception {
		
		Select passengerDropDownMenu = new Select(driver.findElement(By.name("passCount")));

		passengerDropDownMenu.selectByIndex(1);

		Thread.sleep(1000);

		Select fromPortDropDownMenu = new Select(driver.findElement(By.name("fromPort")));
		fromPortDropDownMenu.selectByVisibleText("London");


		Select airlinesOptions = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		airlinesOptions.selectByVisibleText("Blue Skies Airlines");

		driver.findElement(By.cssSelector("input[name=findFlights]")).click();

		driver.findElement(By.name("reserveFlights")).click();

		// Enter flight info and purchase
		Select meanPreferenceDropDown = new Select(driver.findElement(By.name("pass.0.meal")));
		List<WebElement> allMealOptions = meanPreferenceDropDown.getOptions();

		// select all meal options
		for (WebElement meal : allMealOptions) {
			meal.click();
		}

		driver.findElement(By.name("buyFlights")).click();
		
		System.out.println("Mercury Tours Test B");
	}

	@Test(enabled = true)
	public void bookFlightFomNewYork() throws Exception {
		
		Select passengerDropDownMenu = new Select(driver.findElement(By.name("passCount")));

		passengerDropDownMenu.selectByIndex(1);

		Thread.sleep(1000);

		Select fromPortDropDownMenu = new Select(driver.findElement(By.name("fromPort")));
		fromPortDropDownMenu.selectByVisibleText("New York");


		Select airlinesOptions = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		airlinesOptions.selectByVisibleText("Unified Airlines");

		driver.findElement(By.cssSelector("input[name=findFlights]")).click();

		driver.findElement(By.name("reserveFlights")).click();

		// Enter flight info and purchase
		Select meanPreferenceDropDown = new Select(driver.findElement(By.name("pass.0.meal")));
		List<WebElement> allMealOptions = meanPreferenceDropDown.getOptions();

		// select all meal options
		for (WebElement meal : allMealOptions) {
			meal.click();
		}

		driver.findElement(By.name("buyFlights")).click();
		
		System.out.println("Mercury Tours Test C");
	}

}
