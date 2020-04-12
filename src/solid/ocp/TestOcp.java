package solid.ocp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOcp {
	
	static WebDriver driver;
	
	public void testOcpConcept() {
		
		driver = new ChromeDriver();
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		
		
		adminLoginPage.clickAdminUserLink();
		adminLoginPage.clickAdminUserStats();
		
		//Admin can also work with Login Page class
		
		adminLoginPage.clickOnSignButton();
		
	}

}
