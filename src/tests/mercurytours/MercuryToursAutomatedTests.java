package tests.mercurytours;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import tests.util.Utility;



public class MercuryToursAutomatedTests extends Utility {
	
	static WebDriver driver;
	
	final static String expectedWebUrl = "http://newtours.demoaut.com";

	public static void main(String[] args) throws Exception {
		
		final String InitDriver = "webdriver.chrome.driverr";
        final String startDriver = "lib" + File.separator + "chromedriver";
        
      
        System.setProperty(InitDriver, startDriver);
        
        driver = new ChromeDriver();
        
        driver.get(expectedWebUrl);
        
        //verifies that URL = http://newtours.demoaut.com
        String webUrlActual = driver.getCurrentUrl();
        
        System.out.println("Expected URL: " + expectedWebUrl);
        System.out.println("Actual URL: " + webUrlActual);
        
        if(webUrlActual.contains(expectedWebUrl)) {
        	System.out.println("Checkpoint passed: for Mercury Tours URL");
        }else {
        	throw new Exception("Invalid URL");
        }
        
        
        loginToMercuryTours("aeendale", "Postal12Postal12");
        
        //Test 1
        List<String> fromPorts = new ArrayList<>();
        List<String> fromAirlines = new ArrayList<>();
        
        fromPorts.add("Frankfurt");
        fromPorts.add("London");
        fromPorts.add("New York");
        
        fromAirlines.add("No Preference");
        fromAirlines.add("Blue Skies Airlines");
        fromAirlines.add("Unified Airlines");
        
      
        for(int i = 0; i <= 2; i++) {
        	bookFlights(fromPorts.get(i), fromAirlines.get(i));
        }

        
        driver.quit();
        
        System.out.println("Test Execution Completed");
        
	}
	
	
	public static void loginToMercuryTours(String username, String password) {
		//Login to Mercury Tours
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@alt='Sign-In']")).click();
	}
	
	public static void bookFlights(String fromPort, String airlineText) throws Exception {
        //Find Flights
        driver.findElement(By.xpath("//input[@value='oneway']")).click();
        
        Select passengerDropDownMenu = new Select(driver.findElement(By.name("passCount")));
        
        passengerDropDownMenu.selectByIndex(1);
        
        Thread.sleep(1000);
        
        Select fromPortDropDownMenu = new Select(driver.findElement(By.name("fromPort")));
        fromPortDropDownMenu.selectByVisibleText(fromPort);
        
//        List<WebElement> fromPorts = driver.findElements(By.xpath("//select[@name='fromPort']/option"));
//
//        for(WebElement fromPort: fromPorts) {
//        	fromPort.click();
//        	Thread.sleep(500);
//        	System.out.println("available from ports: " + fromPort.getText());
//        }
        
        
        Select airlinesOptions = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
        airlinesOptions.selectByVisibleText(airlineText);
        
        driver.findElement(By.cssSelector("input[name=findFlights]")).click();
        
        driver.findElement(By.name("reserveFlights")).click();
        
      //Enter flight info and purchase
        Select meanPreferenceDropDown = new Select(driver.findElement(By.name("pass.0.meal")));
        List<WebElement> allMealOptions = meanPreferenceDropDown.getOptions();
        
        //select all meal options
        for(WebElement meal: allMealOptions) {
        	meal.click();
        }
        
        driver.findElement(By.name("buyFlights")).click();
        
        driver.findElement(By.xpath("//a[@href='mercuryreservation.php']")).click();
        
        System.out.println("Flight booked for fromPort: " + fromPort);
	}

}
