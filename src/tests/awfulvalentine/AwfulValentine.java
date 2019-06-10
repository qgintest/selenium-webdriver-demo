package tests.awfulvalentine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AwfulValentine {
	
	/*
	 * Demonstrates a site that has multiple iframes. Also need to switch tabs in order to interact with elements
	 */
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		
		final String InitDriver = "webdriver.chrome.driver";
		final String startDriver = "lib" + File.separator + "chromedriver";

		System.setProperty(InitDriver, startDriver);

		driver = new ChromeDriver();

		driver.get("http://ww12.awful-valentine.com/");
		
		//A frame is a webpage embedded within another webpage
		driver.switchTo().frame(0);
		
		
		//driver.findElement(By.xpath("//a//href[1]")).click();
		driver.findElement(By.linkText("Christmas Cards")).click();

		driver.switchTo().frame(0);
		
		//driver.findElement(By.xpath("//a//href[1]")).click();
		driver.findElement(By.id("e4")).click();
		
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		
	    //This switches the first window
		//driver.switchTo().window(tabs2.get(0));
		
		//switches to second window/tab
	    driver.switchTo().window(tabs2.get(1));
	    
	    
	    
	    //List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		//for(WebElement frame: frames) {
		//	System.out.println("Switching to Frame: " + frame.getTagName());
		//	driver.switchTo().frame(frame);
		//}
		
		//driver.switchTo().parentFrame();
	    
	    try {
	    	driver.findElement(By.xpath("blahblah']")).click();
	    }catch(NoSuchElementException e) {
	    	//e.printStackTrace();
	    	System.out.println("Error Dude");
	    }finally {
	    	driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    
		    //forgot to switch frames again
		    driver.switchTo().frame(0);
			driver.findElement(By.id("e37")).click();
	    }
		
		//driver.findElement(By.id("email")).sendKeys("cutie-petootie@nomail.com");
		//driver.findElement(By.xpath("span[class='modal-close']")).click();
		//find specific iframe
		//driver.switchTo().frame("chat-widget-container"); 
		//driver.findElement(By.xpath("//div[id='widget-global-cmcwihlqlms']//button[@class='lc-2xnp29 e1m5b1js0']")).click();
		//driver.findElement(By.id("chat-widget-container")).click();
	    
		
	    
	    

		
		driver.quit();
	}


}
