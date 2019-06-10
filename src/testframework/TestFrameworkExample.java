package testframework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFrameworkExample {
	
		
	@Test
	public void TestCaseA() {
		System.out.println("Our first Test");
	}
	
	@Test
	public void TestCaseB() {
		Assert.assertEquals(true, false);
	}
	

}
