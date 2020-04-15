package solid.testdesignpattern.factorypattern;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private WebDriver driver;
	
	//Factory for creating WebDriver classes
	public WebDriver initDriver(String browser) throws Exception {
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver_win32.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			throw new Exception("Invalid Browser Type");
		}
		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void shutdownDriver() {
		driver.quit();
	}

}
