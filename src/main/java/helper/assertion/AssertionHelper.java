package helper.assertion;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.frame.FrameHelper;
import helper.logger.LoggerHelper;

public class AssertionHelper {
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(AssertionHelper.class); 
	
	public AssertionHelper(WebDriver driver) {
		this.driver=driver;
	}
	public static void verifyText(String actual,String expected) {
		Assert.assertEquals(actual, expected);
		
	}
	public static void verifyTrue() {
		Assert.assertTrue(true);
		
	}
	public static void verifyTrue(String message) {
		Assert.assertTrue(true, message);
		
	}
	public static void verifyFalse( ) {
		Assert.assertTrue(false);
		
	}
	public static void verifyFalse(String message) {
		Assert.assertTrue(false, message);
		
	}

	public static void makeTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	public static void makeFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	public static void verifyNull(String object)
	{
		Assert.assertNull(object);
	}
	public static void pass()
	{
		Assert.assertTrue(true);
	}
	public static void fail()
	{
		Assert.assertTrue(false);
	}

	public static void updateTestSatus(boolean status)
	{
		if(status)
		{
			pass();
		}
		else
		{
			fail();
		}
	}

	

}

