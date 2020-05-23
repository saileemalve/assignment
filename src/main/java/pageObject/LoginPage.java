package pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import helper.assertion.VerificationHelper;
import helper.browserConfiguration.config.ObjectReader;
import helper.javascript.JavascriptHelper;
import helper.logger.LoggerHelper;
import helper.wait.WaitHelper;
import testbase.TestBase;

public class LoginPage {
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);

	WaitHelper waithelper;
	VerificationHelper verify;
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;
	@FindBy(xpath = "//*[@id='email']")
	WebElement emailAddress;
	@FindBy(xpath = "//*[@id='passwd']")
	WebElement password;
	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitLogin;
	@FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
	WebElement forgotPassword;
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
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;
	@FindBy(xpath="//i[@class='icon-home']")
	WebElement HomeLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		 verify = new VerificationHelper(driver);
		waithelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
		
	}

	public void clickOnsignInLink() {
		log.info("click on sign in link");
		logExtentReport("clicked on sign n link");
		signin.click();
	}

	public void enterEmaiAddress(String emailAddress) {
		log.info("enter email");
		this.emailAddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		log.info("enter passwordS");
		this.password.sendKeys(password);
	}

	public ProductCategoryPage clickOnSubmitButton() {
		log.info("clicking on submit button");
		new JavascriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new ProductCategoryPage(driver);
	}

	public boolean verifySuccessLoginMsg() {
		return  verify.isDisplayed(successMsgObject);
	}

	public void enterRegistrationEmail() {
		String email = System.currentTimeMillis() + "gmail.com";
		log.info("enter registreing email " + email);
		emailRegistration.sendKeys(email);
	}
	public RegistrationPage clickOnCreateAnAccount()
	{
		createAnaccount.click();
		return new RegistrationPage(driver);
	}
	public void loginToApplication(String emailAddress,String password)
	{
		clickOnsignInLink();
		enterEmaiAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}
	public ForgotPassword clickOnForgotPasswordLink()
	{
		forgotPassword.click();
		return new ForgotPassword(driver);
	}
	public void logout()
	{
		logout.click();
		waithelper.waitForElement(signin, ObjectReader.reader.getExplicitWait());
	}
	public void logExtentReport(String s1)
	{
		TestBase.test.log(Status.INFO, s1);
	}
}
