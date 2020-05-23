package testScript.loginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helper.assertion.AssertionHelper;
import helper.browserConfiguration.config.ObjectReader;
import helper.logger.LoggerHelper;
import pageObject.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {
	private final Logger log=LoggerHelper.getLogger(LoginTest.class);
	@Test(description="Login test with valid credentials", priority=0)
	public void testLoginToApplication()
	{
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginpage=new LoginPage(driver);
		loginpage.loginToApplication(ObjectReader.reader.getUsername(), ObjectReader.reader.getPassword());
		boolean status =loginpage.verifySuccessLoginMsg();
		AssertionHelper.updateTestSatus(status);
	}

}
