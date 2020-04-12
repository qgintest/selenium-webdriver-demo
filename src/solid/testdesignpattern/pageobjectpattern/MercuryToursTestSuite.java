package solid.testdesignpattern.pageobjectpattern;

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

	public WebDriver driver;
	
	MercuryToursPageRepository mercuryToursPage;

	@Parameters({ "MercuryToursURL" })
	@BeforeClass
	public void setup(String Url) {
		
		final String InitDriver = "webdriver.chrome.driver";
		//final String startDriver = "lib" + File.separator + "chromedriver";
		final String startDriver = "C:\\" + "chromedriver_win32.exe";

		System.setProperty(InitDriver, startDriver);

		driver = new ChromeDriver();
		
		driver.get(Url);

		Assert.assertEquals(driver.getCurrentUrl(), Url);

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
