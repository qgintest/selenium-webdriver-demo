package testframework.mercurytours.testsuite2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MercuryToursTestSuite2 {


	
	@BeforeClass
	public void setup() {
		System.out.println("@Before Class - MercuryToursTestSuite2");
	}
	
	@Test(enabled = false)
	public void TestCaseA() {
		System.out.println("Mercury Tours Test A - MercuryToursTestSuite2");
	}
	
}
