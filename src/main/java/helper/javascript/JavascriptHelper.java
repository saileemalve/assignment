package helper.javascript;

import org.apache.commons.exec.ExecuteStreamHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class JavascriptHelper {

	WebDriver driver;
	
	private Logger log = LoggerHelper.getLogger(JavascriptHelper.class);

	public JavascriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("it is javascriptexecutor");
	}

	public Object javascriptExecutor(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		return js.executeScript(script);
	}

	public Object javascriptExecutor(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script, args);
	}

	public void scrolltoElement(WebElement element) {
		javascriptExecutor("window.scrollTo(arguments[0],arguments[1]", element.getLocation().x,
				element.getLocation().y);

	}

	public void scrollToElementAndClick(WebElement element) {
		scrolltoElement(element);
		element.click();
	}

	public void scrollToIntoView(WebElement element) {
		javascriptExecutor("arguments[0].scrollIntoView()", element);
	}

	public void scrollToIntoViewAndClick(WebElement element) {
		scrollToIntoView(element);
		element.click();
	}

	public void scrollDownVertically() {
		javascriptExecutor("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollUpVertically() {
		javascriptExecutor("window.scrollTo(0,-document.body.scrollHeight)");
	}
	public void scrollDownPixel(int pixel) {
		javascriptExecutor("window.scrollBY(0,"+pixel+")");
	}
	public void scrollUpPixel(int pixel) {
		javascriptExecutor("window.scrollBY(0,-"+pixel+")");
	}
	public void zoomInBy100Percent() {
		javascriptExecutor("document.body.style.zoom=100%");
	}
	public void zoomInBy60Percent() {
		javascriptExecutor("document.body.style.zoom=60%");
	}
	public void clickElement(WebElement element) {
		javascriptExecutor("arguments[0].click();",element);
	}
}
