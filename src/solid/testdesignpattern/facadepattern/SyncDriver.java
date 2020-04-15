package solid.testdesignpattern.facadepattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncDriver {
	
	static WebDriverWait wait;
	
	//Below Selenium based methods are created as facades///////////////////////////////////
	public static void waitUntilElementIsVisible(WebDriver driver, WebElement element, int waitTime) {
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitUntilElementIsClickable(WebDriver driver, WebElement element, int waitTime) {
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
