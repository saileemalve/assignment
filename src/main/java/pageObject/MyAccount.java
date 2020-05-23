package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.browserConfiguration.config.ObjectReader;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import testbase.TestBase;

public class MyAccount {

	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(MyAccount.class);

	WaitHelper waithelper;

	@FindBy(xpath = "//p[@class='info-account']")
	public WebElement yourAccountPageMessage;
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	public WebElement orderHistoryAndDetails;
	@FindBy(xpath = "//span[contains(text(),'My personal information')]")
	public WebElement myPersonalInformation;
	@FindBy(xpath = "//span[contains(text(),'My personal information')]")
	public WebElement wishLists;
	@FindBy(xpath = "//h1[@class='page-heading']")
	public WebElement myAccount;

	public MyAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(orderHistoryAndDetails, ObjectReader.reader.getExplicitWait());
		TestBase.test.log(Status.INFO,"MyAccountPage object created");
		new TestBase().getNavigationScreen(driver);
	}
	public void clickOnWishList()
	{
		wishLists.click();
		log.info("clicked on "+wishLists.getText());
		TestBase.test.log(Status.INFO,wishLists.getText());
	}
	public void clickOnOrderHistory()
	{
		orderHistoryAndDetails.click();
		log.info("clicked on "+orderHistoryAndDetails.getText());
		TestBase.test.log(Status.INFO,orderHistoryAndDetails.getText());
	}
}
