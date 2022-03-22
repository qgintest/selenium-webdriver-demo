import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class DemoQaSampleTests {
	
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		final String initiDriver = "webdriver.chrome.driver";
		final String startDriver = "lib" + File.separator + "chromedriver.exe";
		
		System.setProperty(initiDriver, startDriver);
		
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[contains (text(), 'Interactions')]")).click();
		
		
		//sortItems();
		//SelectMultipleElementsWithClickAndHold();
		//SelectMultipleElementsUsingMouseAndKeyboardControlOperations();
		//ResizeElementAndGetNewWithAndLength();
		//DragAndDropWebElementUsingXYcoordinates();
		//datePicker();
		//menuWithSubMenuHover();
		//sliderClickAndHoldAndDrag();
		
		driver.quit();
		
		System.out.println("******End of Test Suite Excution******");
	}
	
	public static void SelectMultipleElementsWithClickAndHold() throws Exception{
		
		driver.findElement(By.linkText("Selectable")).click();
		Thread.sleep(3000);
		
		List<WebElement> list = driver.findElements(By.cssSelector("ol#selectable *"));
		Actions actions = new Actions(driver);
		
		actions.clickAndHold(list.get(0)).clickAndHold(list.get(4)).release().build().perform();
	}
}