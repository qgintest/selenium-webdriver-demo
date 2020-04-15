package solid.testdesignpattern.facadepattern;

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

	private WebDriver driver;
	private Driver manageDriver = new Driver();
	
	MercuryToursPageRepository mercuryToursPage;

	@Parameters({ "MercuryToursURL", "Browser" })
	@BeforeClass
	public void setup(String Url, String browser) throws Exception {
		
		driver = manageDriver.initDriver(browser);

		driver.get(Url);

		System.out.println("Mercury Tours Before Test");
	}


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
		System.out.println("After each test");
	}
	
	@Test
	public void runLoginTest() {
		LoginPage loginPage = new LoginPage(this.driver);
		loginPage.loginToMercuryTours();
		
	}
}
