package solid.isp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumInterfaces {
	
	static WebDriver driver;
	
	public static void WebElementInterface() {
		
		Select meanPreferenceDropDown = new Select(driver.findElement(By.name("pass.0.meal")));
		List<WebElement> allMealOptions = meanPreferenceDropDown.getOptions();

		// select all meal options
		for (WebElement meal : allMealOptions) {
			meal.click();
		}
		
	}
	
	public static void WebDriveInteface() {
	   driver = new ChromeDriver();	
	}

}
