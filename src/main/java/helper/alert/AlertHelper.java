package helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import helper.assertion.AssertionHelper;
import helper.logger.LoggerHelper;

public class AlertHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper() {
		this.driver = driver;
		log.info("AlertHelper object is created");
	}

	public Alert getAlert() {
		log.info("alert test" + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	public String getAlertText() {
		log.info("alert test" + driver.switchTo().alert().getText());
		String text= getAlert().getText();
		return text	;
		 
	}

	public void acceptAlert()

	{
		getAlert().accept();
		log.info("alert accepted");
	}

	public void DismissAlert()

	{
		getAlert().dismiss();
		log.info("alert Dismiss");
	}
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch (NoAlertPresentException e) {
			// TODO: handle exception
			log.info(e.getCause());
			return false;
		} 
	}
	public void acceptAlerPresent()
	{
		if(isAlertPresent())
		{
			acceptAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	public void dismissAlerPresent()
	{
		if(isAlertPresent())
		{
			DismissAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	public void acceptPrompt(String text)
	{
		if(isAlertPresent())
		{
			Alert alert=getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text "+text);
			
		}
	}
}
