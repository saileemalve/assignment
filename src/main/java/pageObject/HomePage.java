package pageObject;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.browserConfiguration.config.ObjectReader;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import testbase.TestBase;

public class HomePage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);

	WaitHelper waithelper;

	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	WebElement Women;
	@FindBy(xpath = "//li[@class='sfHover']//a[@class='sf-with-ul'][contains(text(),'Dresses')]")
	WebElement Dresses;
	@FindBy(xpath = "//li[@class='sfHoverForce sfHover']//a[contains(text(),'T-shirts')]")
	WebElement TShirts;
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchTextbox;
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement searchButton;
	@FindBy(xpath = "//*[@id='email_create']")
	WebElement emailRegistration;
	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAnaccount;
	@FindBy(xpath = "//*[@id='center_column']/p")
	WebElement successMsgObject;
	@FindBy(xpath = "//*[@id='center_column']/h1")
	WebElement AuthenticationText;
	@FindBy(xpath = "//*[@id='create-account_form']/div/p")
	WebElement createAnAccountMessage;
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		waithelper.waitForElement(Women, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("Home Page Object created");
		//new TestBase().getNavigationScreen(driver);

	}

	public void mouseOver(String data) {
		log.info("doing mouse over on :" + data);
		TestBase.logExtentReport("doing mouse over on :" + data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();
	}

	public ProductCategoryPage clickOnItem(String data) {
		log.info("cliking on" + data);
		TestBase.logExtentReport("doing mouse over on :" + data);
		driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"));
		return new ProductCategoryPage(driver);
	}
	public ProductCategoryPage clickOnMenu(WebElement element) {
		log.info("cliking on" + element.getText());
		element.click();
		return new ProductCategoryPage(driver);
	}


	public void logExtentReport(String s1) {
		TestBase.test.log(Status.INFO, s1);
	}

}
