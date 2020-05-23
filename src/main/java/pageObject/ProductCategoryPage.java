package pageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import helper.browserConfiguration.config.ObjectReader;
import helper.frame.FrameHelper;
import helper.javascript.JavascriptHelper;
import helper.wait.WaitHelper;

import testbase.TestBase;

public class ProductCategoryPage extends TestBase {

	private WebDriver driver;
	private final Logger log = Logger.getLogger(ProductCategoryPage.class);
	WaitHelper waitHelper;
	FrameHelper frame;
	JavascriptHelper js;
	AssertionHelper asserth;
	VerificationHelper verifyh;
	String totalAmount;
	String histAmount;

	@FindBy(xpath = "//table[@id='order-list']//td[3]")
	public WebElement orderHisAmt;
	@FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	public WebElement womenLink;
	@FindBy(xpath = "//*[@id='center_column']/ul/li")
	public WebElement totalProducts;
	@FindBy(xpath = "//ul[@class='product_list grid row']/li[1]//div[@class='product-image-container']//a[@class='quick-view']")
	public WebElement quickView;
	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	public WebElement frameId;
	@FindBy(xpath = "//div[@class='product_attributes clearfix']/p[1]/a[2]")
	public WebElement prodQuntUp;
	@FindBy(xpath = "//p[text(),'Quantity'")
	public WebElement textQuant;
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	public WebElement addToCart;
	@FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
	public WebElement proceedToCheckOut;
	@FindBy(xpath = "//span[@id='total_price']")
	public WebElement totalPrice;
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	public WebElement orderProToCheckOut;
	@FindBy(xpath = "//button[@name='processAddress']")
	public WebElement addrProToCheckOut;
	@FindBy(xpath = "//button[@name='processCarrier']")
	public WebElement carrProToCheckOut;
	@FindBy(xpath = "//input[@id='cgv']")
	public WebElement termCondition;
	@FindBy(xpath = "//a[@class='bankwire']")
	public WebElement bankWire;
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	public WebElement confirmOrder;
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	public WebElement iConfirm;
	@FindBy(xpath = "//a[@class='account']")
	public WebElement acct_profile;
	@FindBy(xpath = "//h1[@class='page-heading']")
	public WebElement myAccountText;
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	public WebElement orderHostory;
	@FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_price']")
	public WebElement historyPrice;

	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		frame = new FrameHelper(driver);
		js = new JavascriptHelper(driver);
		asserth = new AssertionHelper(driver);
		waitHelper = new WaitHelper(driver);
		verifyh = new VerificationHelper(driver);
		waitHelper.waitForElement(womenLink, ObjectReader.reader.getExplicitWait());
		TestBase.logExtentReport("ProductCategoryPage object created");
	}

	public void clickonQuickView() {
		log.info("clicking on quick view");
		Actions act = new Actions(driver);
		act.moveToElement(quickView);
		quickView.click();
		TestBase.logExtentReport("clicked on quick view");
	}

	public boolean verifySuccessLoginMsg() {
		return verifyh.isDisplayed(womenLink);
	}

	public void clickonWomenLink() {
		log.info("clicking on WomenLink");
		womenLink.click();
		TestBase.logExtentReport("clicked on quick Women link");
	}

	public void clickonprodQuntUp() {

		waitHelper.setImplicitWait(30, TimeUnit.SECONDS);

		frame.switchToFrame(frameId);
		verifyh.getText(textQuant);
		log.info("clicking on to quantity increase button");
		prodQuntUp.click();
		TestBase.logExtentReport("clicked on quntity increase icon");
	}

	public void clickonAddToCart() {
		log.info("clicking on Add to cart");
		addToCart.click();
	}

	public void clickonProceedToCheckOut() {

		log.info("clicking on to proceed to checkout");
		waitHelper.setImplicitWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		proceedToCheckOut.click();
		TestBase.logExtentReport("clicked on proceed to checkout");
	}

	public void clickonOrderProToCheckOut() {
		log.info("clicking on to orderProToCheckOut");
		orderProToCheckOut.click();
		TestBase.logExtentReport("clicked on order proceed to checkout");
	}

	public void clickonAddrProToCheckOut() {
		log.info("clicking on to addrProToCheckOut");
		addrProToCheckOut.click();
		TestBase.logExtentReport("clicked on address proceed to checkout");
	}

	public void clickoncarrProToCheckOut() {
		log.info("clicking on to carrProToCheckOut");
		carrProToCheckOut.click();
		TestBase.logExtentReport("clicked on career proceed to checkout");
	}

	public void clickontermCondition() {
		log.info("clicking on to termCondition");
		js.clickElement(termCondition);
		TestBase.logExtentReport("clicked on ccheckbox of term condition");
	}

	public void clickonconfirmOrder() {
		log.info("clicking on to confirmOrder");
		js.clickElement(confirmOrder);
		TestBase.logExtentReport("clicked on confirmation order");
	}

	public void clickonBankWire() {
		log.info("clicking on to bankWire");
		bankWire.click();
		TestBase.logExtentReport("clicked on bankwire");
	}

	public void clickonIConfirm() {
		// TODO Auto-generated method stub
		log.info("clicking on to I confirm my order");
		js.clickElement(iConfirm);
		TestBase.logExtentReport("clicked on confirm order button");
	}

	public void clickonAacct_profile() {
		log.info("clicking on to acct_profile");
		acct_profile.click();
		TestBase.logExtentReport("clicked on profile");
	}

	public void clickonOrderHostory() {
		log.info("clicking on to orderHostory");
		orderHostory.click();
		TestBase.logExtentReport("clicked on order history");
	}

	public void clickonhistoryPrice() {
		log.info("clicking on to historyPrice");
		historyPrice.click();
		TestBase.logExtentReport("clicked on history price");
	}

	public void selectFirstProduct() {
		Actions act = new Actions(driver);
		log.info("performaning mouse over on first product  of page");
		act.moveToElement(totalProducts).build().perform();
		TestBase.logExtentReport("performed mouse hover");

	}

	public void verifyTotalAmount() {
		log.info("verify total amount before payment");
		totalAmount = verifyh.getText(totalPrice);
		AssertionHelper.verifyText(totalAmount, "$35.02");
		TestBase.logExtentReport("verified actual amount " + totalAmount + "with expected amount" + "$35.02");
	}

	public String verifymyAccountText() {
		log.info("verify total amount before payment");
		waitHelper.waitForElement(womenLink, ObjectReader.reader.getExplicitWait());
		return verifyh.getText(myAccountText);

	}

	
	  public void verifyorderHisAmt() {
	  log.info("verify total amount orderHisAmt");
	  //waitHelper.waitForElement(orderHisAmt,ObjectReader.reader.getExplicitWait()); 
	  histAmount =verifyh.getText(orderHisAmt);
	  AssertionHelper.verifyText(histAmount,totalAmount);
	  TestBase.logExtentReport("verified acount history amount " + histAmount  + "with expected amount" + totalAmount);	  
	  }
	 

}
