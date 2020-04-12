package solid.dip;

import org.openqa.selenium.WebDriver;

public class MercuryToursLoginTest {
	
	public void testDip() {
		
		WebDriver driver;
		
		
		
		driver = ManageDriver.startDriver("Chrome Browser");
		
		driver.getTitle();
		
		ManageDriver.stopDriver(driver);
		
		
	}

}
