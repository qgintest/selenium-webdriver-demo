package solid.ocp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
This is the theoretical Login Page used by Admins on MercuryTours. Admin maybe able to see additional elements as the login page page such as
1. Manage Users Link
2. View User Stats

In addition, admin can also use the functionality from the base LoginPage class

*/

public class AdminLoginPage extends LoginPage {
	
	
	@FindBy(name="manageUsers") WebElement fieldAdminUserName;
	@FindBy(name="viewUserStats") WebElement fieldAdminStat;

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public void clickAdminUserLink() {
		fieldAdminUserName.click();
	}
	
	public void clickAdminUserStats() {
		fieldAdminStat.click();
	}

}
