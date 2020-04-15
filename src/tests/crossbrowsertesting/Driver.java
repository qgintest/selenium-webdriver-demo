package tests.crossbrowsertesting;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {

	private WebDriver driver;
	WebDriverWait wait;
	

	public WebDriver initDriver(String browser) throws Exception {
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "lib" + File.separator + "chromedriver_win32.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "lib" + File.separator + "geckodriver.exe");
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
