package tests.crossbrowsertesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testframework.mercurytours.pages.MercuryToursPageRepository;

public class MercuryToursTestSuite {

	private WebDriver driver;
	private Driver manageDriver = new Driver();
	
	MercuryToursPageRepository mercuryToursPage;

	@Parameters({ "MercuryToursURL", "Browser" })
	@BeforeClass
	public void setup(String Url, String browser) throws Exception {
		
		driver = manageDriver.initDriver(browser);

		driver.get(Url);

		long id = Thread.currentThread().getId();
		System.out.println("Mercury Tours Before Test for thread: " + id);
	}


	@AfterClass
	public void teardown() {
		long id = Thread.currentThread().getId();
		System.out.println("Mercury Tours After Test for thread: " + id);
		
		driver.quit();
	}

	/*
	 * @BeforeMethod public void beforeEachTest() {
	 * System.out.println("Landed on Flight Finder Page"); }
	 * 
	 * @AfterMethod public void afterEachTest() {
	 * System.out.println("After each test"); }
	 */
	
	@Test
	public void runLoginTest() {
		LoginPage loginPage = new LoginPage(this.driver);
		loginPage.loginToMercuryTours();
		
		
		
	}
}
