package solid.dip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManageDriver {
	
	public static WebDriver driver;
	
	public static WebDriver startDriver(String browser) {
		
		switch(browser) {
		case "Chrome Browser":
			driver = new ChromeDriver();
			break;
			
		case "Firefox Browser":
			driver = new FirefoxDriver();
			break;
			
		default:
			driver = new ChromeDriver();
			break;
		}
		
		return driver;
		
	}
	
	public static void stopDriver(WebDriver driver) {
		driver.close();
		driver.quit();
	}

}
