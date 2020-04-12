package solid.lsp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOcp {
	
	static WebDriver driver;
	
	public void testOcpConcept() {
		
		driver = new ChromeDriver();
		
		NewUserViewLoginPage newUserLoginPage = new NewUserViewLoginPage(driver);
		AdminViewLoginPage adminViewLoginPage = new AdminViewLoginPage(driver);
		
		newUserLoginPage.NewnUserButton();
		adminViewLoginPage.adminUserButton();
		
		
	}

}
