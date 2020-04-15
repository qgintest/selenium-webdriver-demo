package solid.testdesignpattern.singletonpattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testframework.mercurytours.pages.MercuryToursPageRepository;

public class MercuryToursTestSuite {

	private WebDriver driver1;
	private WebDriver driver2;
	
	
	MercuryToursPageRepository mercuryToursPage;

	@Parameters({ "MercuryToursURL", "Browser" })
	@BeforeClass
	public void setup(String Url, String browser) throws Exception {
		
		Driver driverClass = Driver.getInstanceOfSingleBrowserClass();
		driver1 = driverClass.getDriver();

		driver1.get(Url);
		
		driver2 = driverClass.getDriver();
		driver2.get("https://www.google.com");
		

		System.out.println("Mercury Tours Test Suite 1");
	}


	/*
	 * @AfterClass public void teardown() {
	 * 
	 * driver.quit(); System.out.println("Mercury Tours After Test"); }
	 */

	/*
	 * @BeforeMethod public void beforeEachTest() {
	 * System.out.println("Landed on Flight Finder Page"); }
	 */

	/*
	 * @AfterMethod public void afterEachTest() {
	 * System.out.println("After each test"); }
	 */
	
	@Test
	public void runLoginTest() {
		//LoginPage loginPage = new LoginPage(this.driver);
		//loginPage.loginToMercuryTours();
		System.out.println("some Test");
		
	}
}
