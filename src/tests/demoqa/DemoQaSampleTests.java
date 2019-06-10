package tests.demoqa;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoQaSampleTests {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		final String InitDriver = "webdriver.chrome.driver";
		final String startDriver = "lib" + File.separator + "chromedriver";

		System.setProperty(InitDriver, startDriver);

		driver = new ChromeDriver();

		driver.get("https://demoqa.com/");

		
		//sortItems();
		 //SelectMultipleElementsWithClickAndHold();
		//SelectMultipleElementsUsingMouseAndKeyboardControlOperations();
		//ResizeElementAndGetNewWithAndLength();
		//DragAndDropWebElementUsingXYcoordinates();
		//datePicker();
		//menuWithSubMenuHover();
		//sliderClickAndHoldAndDrag();

		driver.quit();

		System.out.println("*********End of Test Suite Execution*******");

	}
	
	//Click and Hold Slider then drag it
	public static void sliderClickAndHoldAndDrag() throws Exception{ 
		 
		 
		 driver.findElement(By.linkText("Slider")).click();
		 Thread.sleep(2000);
		 
		 
		 Actions action = new Actions(driver);
		 WebElement sliderPoint = driver.findElement(By.id("slider"));
		
		
		 action.clickAndHold(sliderPoint).perform();
	     action.dragAndDropBy(sliderPoint, 250, 0).build().perform();
	     
	 }
	
	public static void menuWithSubMenuHover() throws Exception {
		
		 driver.findElement(By.linkText("Menu")).click();
		 Thread.sleep(2000);
		 
		 //driver.findElement(By.linkText("Electronics")).click();
		 //Thread.sleep(2000);
		 
		 Actions action = new Actions(driver);
		 WebElement hoverElement = driver.findElement(By.id("ui-id-4"));
		
		 action.moveToElement(hoverElement).perform();
		 Thread.sleep(2000);
		 WebElement subMenuElement = driver.findElement(By.id("ui-id-6"));
		 action.moveToElement(subMenuElement).click().perform();
	}
	
	public static void datePicker() throws Exception {
		 driver.findElement(By.linkText("Datepicker")).click();
		 Thread.sleep(3000);
		 
		 driver.findElement(By.id("datepicker")).click();
		 driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[1][@data-month='5']")).click();
		 Thread.sleep(3000);
	}
	
	public static void DragAndDropWebElementUsingXYcoordinates() throws Exception {
		
		driver.findElement(By.linkText("Draggable")).click();
		 Thread.sleep(3000);
		 
		 Actions actions = new Actions(driver);
	     WebElement elementToDrag = driver.findElement(By.xpath(".//*[@id='draggable']/p"));

	     //drag and drop a webelement vertically by 100 pixels.
	     //new Actions(driver).dragAndDropBy(elementToDrag, 0, 100).build().perform();
	     actions.dragAndDropBy(elementToDrag, 0, 100).build().perform();
	     Thread.sleep(1000);
	   
	     //drag and drop a webelement horizontally by 100 pixels.
	     actions.dragAndDropBy(elementToDrag, 100, 0).build().perform();
	     //(new Actions(driver)).dragAndDrop(elementToDrag, destinationToDrag).perform();
	     Thread.sleep(1000);
	 
	   //To drag and drop element by -100 pixel offset In horizontal and -100 pixel offset In Vertical direction.
	     actions.dragAndDropBy(elementToDrag, -100, -100).build().perform();
	     Thread.sleep(1000);
		
	}

	public static void ResizeElementAndGetNewWithAndLength() throws Exception {
		
		driver.findElement(By.linkText("Resizable")).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		WebElement resizeableElement = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));

		// Get width of element.
		int ImageWidth = resizeableElement.getSize().getWidth();
		System.out.println("Image width Is " + ImageWidth + " pixels");

		// Get height of element.
		int ImageHeight = resizeableElement.getSize().getHeight();
		System.out.println("Image height Is " + ImageHeight + " pixels");

		// Used points class to get x and y coordinates of element.
		Point point = resizeableElement.getLocation();
		int xcord = point.getX();
		System.out.println("Element's Position from left side Is " + xcord + " pixels.");
		int ycord = point.getY();
		System.out.println("Element's Position from top side Is " + ycord + " pixels.");

		// drag and drop a webelement horizontally by 100 pixels.
		actions.clickAndHold(resizeableElement).moveByOffset(500, 200).release().build().perform();
		Thread.sleep(1000);

		// Used to get new points class to get x and y coordinates of element.
		point = resizeableElement.getLocation();
		xcord = point.getX();
		System.out.println("Element's NEW Position from left side Is " + xcord + " pixels.");
		ycord = point.getY();
		System.out.println("Element's NEW Position from top side Is " + ycord + " pixels.");
	}

	public static void SelectMultipleElementsWithClickAndHold() throws Exception {

		driver.findElement(By.linkText("Selectable")).click();
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.cssSelector("ol#selectable *"));
		Actions actions = new Actions(driver);

		
		actions.clickAndHold(list.get(0)).clickAndHold(list.get(4)).release().build().perform();

		System.out.println("***Test Case sortItems Executed***");

	}

	public static void SelectMultipleElementsUsingMouseAndKeyboardControlOperations() throws Exception {
		driver.findElement(By.linkText("Selectable")).click();
		Thread.sleep(3000);

		List<WebElement> list = driver.findElements(By.cssSelector("ol#selectable *"));
		Actions actions = new Actions(driver);

		actions.keyDown(Keys.COMMAND).click(list.get(0)).click(list.get(4)).keyUp(Keys.COMMAND).build().perform();

		System.out.println("***Test Case mouseAndKeyboard Executed***");
	}

	// Not working with demoqa site
	public static void sortItems() throws Exception {

		driver.findElement(By.linkText("Sortable")).click();

		String pageLoaded = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();

		if (pageLoaded.contentEquals("Sortable")) {
			System.out.println("Page loaded");
		} else {
			throw new Exception("Unknown page");
		}

		Thread.sleep(3000);

		WebElement item1 = driver.findElement(By.xpath("//ul[@id='sortable']"));
		WebElement item2 = driver.findElement(By.xpath("//ul[@id='sortable']/li[2]/span"));

		Actions actions = new Actions(driver);

		// reorder item 1 to item 2
		actions.dragAndDrop(item1, item2);

		Thread.sleep(3000);

		System.out.println("***Test Case sortItems Executed***");
	}
}
