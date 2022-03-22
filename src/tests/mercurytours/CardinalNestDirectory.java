package tests.mercurytours;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVWriter;

import tests.util.Utility;
import util.Util;



public class CardinalNestDirectory extends Utility {
	
	static WebDriver driver;
	
	final static String expectedWebUrl = "https://cardinalnest.net/directory/?_special_roles=realtor&_company=samson-properties&_states_licensed=washington-dc";

	public static void main(String[] args) throws Exception {
		
		String status = "Sphere";
		String dealType = "Agent";
		String opt_In_Call = "TRUE";
		String opt_In_Email = "TRUE";
		String opt_In_Sms = "TRUE";
		String hashtags = "sp|dc"; 
		//String hashtags = "sp|vawestsouth"; includes tysons, mclean, vienna, stafford, reston, lessburg, montclair, culpeper, bel air, and bealeton 
		StringBuilder sb = null;
		
//		String fullname = "Donnie Anderson Jr.";
//		
//		String lastnName = fullname.substring(fullname.lastIndexOf(" ") + 1);
//		String firstname = fullname.substring(0, fullname.indexOf(' '));;
//		
//		System.out.println(firstname + " " + lastnName);
		
		final String InitDriver = "webdriver.chrome.driver";
        final String startDriver = "lib" + File.separator + "chromedriver_94.exe";
        
        
        
        //Setup CSV ///////////////////////////////////////////////////
        File file = new File("lib" + File.separator + "output.csv");
        
        FileWriter outputfile = new FileWriter(file);
  	  
        CSVWriter writer = new CSVWriter(outputfile);
  
        List<String[]> data = new ArrayList<String[]>();
        
        
        data.add(new String[] { "First Name", "Last Name", "Email", "Status", "Deal Type",  
        		"Cell Phone 1", "Primary Phone For SMS", "Opt in Call", "Opt in Email", "Opt in SMS", "Hashtags" });
        ///////////////////////////////////////////////////////////
      
        System.setProperty(InitDriver, startDriver);
        
        driver = new ChromeDriver();
        
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
//		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));

        
        driver.get(expectedWebUrl);
        
        
      loginToCardinalNest("aendalerealtor@gmail.com", "DM3&d%LwpL@(8mx2");
        
      List<WebElement> rows = null;
      //int rows = null;
      ////tbody//tr//td[2]//a   NAME
      ////tbody//tr//td[3]//dd   PHONE
    //tbody//tr//td[3]//dd[2]//a[@href]    EMAIL
      
      String fullName = null;
      String firstName = null;
      String lastName = null;
      String phone = null;
      String email = null;
      int i = 1;
      
      
      //pages - hardcoded for now
      
      for(int p = 1; p <= 11; p++) {
    	  
    	  if(p !=1) {
    		  driver.findElement(By.xpath("//button[contains (text(), 'Next')]")).click();
    	  }
    	  
	      Thread.sleep(8000);
	      
	      rows = driver.findElements(By.xpath("//tbody//tr"));
	      
//    	  if(p == 11) {
//    		  System.out.println("Number of rows: " + rows.size()); 
//    	  }
    	  
	      for(WebElement row: rows) {
	    	  
	    	  try {
	    		  fullName = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[2]//a")).getText();
	    	  }catch( NoSuchElementException e) {
	    		  System.out.println("Could not find name");
	    		  fullName = "no name found";
	    	  }
	    	
	    	
	    	lastName = fullName.substring(fullName.lastIndexOf(" ") + 1);
	    	firstName = fullName.substring(0, fullName.indexOf(' '));;
	    	
	    	  try {
	    		  email = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[3]//dd[2]//a")).getAttribute("href");
	    	  }catch( NoSuchElementException e) {
	    		  System.out.println("Could not find email");
	    		  email = "no-email-found";
	    	  }
	    	
	      	      	
	      	email = email.replace("mailto:", "");
	      	
	    	  try {
	    		  phone = driver.findElement(By.xpath("//tbody//tr[" + i + "]//td[3]//dd")).getText();
	    	  }catch( NoSuchElementException e) {
	    		  System.out.println("Could not find phone");
	    		  phone = "no-phone-found";
	    	  }
	      	
	      	
	      	//phone = phone.replaceAll("[^()\\? ]", "");
	      	phone = phone.replace("(", "");
	      	phone = phone.replace(")", "");
	      	phone = phone.replace(" ", "");
	      	
	      	sb = new StringBuilder(phone);
	      	sb.deleteCharAt(phone.length()-5);
	      	
	      	phone = sb.toString();
	      	
	      	
	        data.add(new String[] { firstName, lastName, email, status, dealType, phone, phone, opt_In_Call, opt_In_Email, opt_In_Sms, hashtags });  
	      	//System.out.print(fullName + "," + phone + "," + email);
	      	i++;
	      }
	      
	      
	      i = 1;
	      
      }   
      
        
      writer.writeAll(data);
      writer.close();  
    
      driver.quit();
       System.out.println("Test Execution Completed");
        
	}
	
	
	public static void loginToCardinalNest(String username, String password) throws Exception {
		//Login to Mercury Tours
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        
        Thread.sleep(5000);
	}

}
