package solid.testdesignpattern.singletonpattern;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	
	//instance of singleton class
	private static Driver singleInstanceDriver = null;
	
	private WebDriver driver;
	
	//Constructor
	private Driver() {
		System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver_win32.exe");
		driver = new ChromeDriver();
	}
	
	//To create the instance of the class
	
	public static Driver getInstanceOfSingleBrowserClass() {
		if(singleInstanceDriver == null) {
			singleInstanceDriver = new Driver();
		}
		return singleInstanceDriver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	
	public void shutdownDriver() {
		driver.quit();
	}

}
