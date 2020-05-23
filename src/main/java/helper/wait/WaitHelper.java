package helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.logger.LoggerHelper;

public class WaitHelper {

	WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("waitHelper object is created ");
	}

	

	public void setImplicitWait(long timeout, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	public WebDriverWait getWait(int timeoutInSec, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotSelectableException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);

		return wait;
	}

	public void waitForElementVisible(WebElement element, int timeoutInSec, int pollingEveryInMiliSec) {
		WebDriverWait wait = getWait(timeoutInSec, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visisble now");
	}

	public void waitForElementClickable(WebElement element, int timeoutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is visisble now");
	}

	public void waitForElementSelectable(WebElement element, int timeoutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		log.info("element is visisble now");
	}

	public boolean waitForElementNotPresent(WebElement element, int timeoutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is visisble now");
		return status;
	}

	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, int timeoutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("element is visisble now");

	}

	private Wait<WebDriver> getfluentWait(int timeoutInSec, int polliingevryinmilisec) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(timeoutInSec))
				.pollingEvery(Duration.ofMillis(polliingevryinmilisec)).ignoring(NoSuchElementException.class);
		return fwait;
	}

	public WebElement waitForElement(WebElement element, int timeoutInSec, int polliingevryinmilisec) {
		Wait<WebDriver> fwait = getfluentWait(timeoutInSec, polliingevryinmilisec);
		WebElement status = fwait.until(ExpectedConditions.visibilityOf(element));
		return element;

	}
	public void	 waitForElement(WebElement element, int timeoutInSec) {
		log.info("waiting for "+element.toString()+timeoutInSec+" seconds");
		WebDriverWait wait=new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element id present now");

	}
	public void pageLoadTime(long timeout,TimeUnit unit)
	{
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
	}
}
