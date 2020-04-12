package tests.sync;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlowTests {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		
		final String InitDriver = "webdriver.chrome.driver";
		final String startDriver = "lib" + File.separator + "chromedriver";

		System.setProperty(InitDriver, startDriver);
		
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.DAYS);
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.HOURS);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.HOURS);

		//selenium waits x seconds (check every half a second)
		
		driver.get("http://slowwly.robertomurray.co.uk/delay/1000/url/http://www.google.co.uk");
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("a");
		
		//Thread.sleep(5000);
		
		//WebElement searchButton = driver.findElement(By.name("btnK"));
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		driver.findElement(By.name("btnK")).click();
		
		
		driver.quit();

	}

}
