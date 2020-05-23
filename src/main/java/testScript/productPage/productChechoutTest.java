package testScript.productPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import helper.assertion.AssertionHelper;
import helper.browserConfiguration.config.ObjectReader;
import helper.logger.LoggerHelper;
import pageObject.LoginPage;
import pageObject.ProductCategoryPage;
import testScript.loginPage.LoginTest;
import testbase.TestBase;

public class productChechoutTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	

	/*
	 * @Test(description="Login test with valid credentials",priority = 0) public
	 * void testLoginToApplication() {
	 * getApplicationUrl(ObjectReader.reader.getUrl()); LoginPage loginpage=new
	 * LoginPage(driver);
	 * loginpage.loginToApplication(ObjectReader.reader.getUsername(),
	 * ObjectReader.reader.getPassword()); boolean status
	 * =loginpage.verifySuccessLoginMsg(); AssertionHelper.updateTestSatus(status);
	 * }
	 */

	@Test(description = "Add product to cart", priority = 1)
	public void testProductCheckout() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginToApplication(ObjectReader.reader.getUsername(), ObjectReader.reader.getPassword());
		boolean status = loginpage.verifySuccessLoginMsg();
		AssertionHelper.updateTestSatus(status);
		ProductCategoryPage prodCatg = new ProductCategoryPage(driver);
		prodCatg.clickonWomenLink();
		prodCatg.selectFirstProduct();
		boolean msg = prodCatg.verifySuccessLoginMsg();
		AssertionHelper.updateTestSatus(status);		
		prodCatg.clickonQuickView();
		prodCatg.clickonprodQuntUp();
		prodCatg.clickonAddToCart();
		prodCatg.clickonProceedToCheckOut();
		prodCatg.clickonOrderProToCheckOut();
		prodCatg.clickonAddrProToCheckOut();
		prodCatg.clickoncarrProToCheckOut();
		prodCatg.clickontermCondition();
		prodCatg.clickonconfirmOrder();
		prodCatg.verifyTotalAmount();		
		prodCatg.clickonBankWire();
		prodCatg.clickonIConfirm();
		prodCatg.clickonAacct_profile();
		String acctText = prodCatg.verifymyAccountText();
		log.info(acctText);
		prodCatg.clickonOrderHostory();
		prodCatg.verifyorderHisAmt();
	}

	/*
	 * @Test(description = "Verify amount of of order in order history", priority =
	 * 2) public void testAmountInOrderHistoty() { prodCatg.clickonAacct_profile();
	 * String acctText = prodCatg.verifymyAccountText(); log.info(acctText);
	 * prodCatg.clickonOrderHostory();
	 * 
	 * }
	 */
}
