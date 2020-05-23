package helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.frame.FrameHelper;
import helper.logger.LoggerHelper;

public class VerificationHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(VerificationHelper.class); 
	
	public VerificationHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean isDisplayed(WebElement element)
	{
		try {
			element.isDisplayed();
			log.info(element +" is displayed  "+element.getText());
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("element is not present"+e.getCause());
			return false;
		}
	}
	public String getText(WebElement element)
	{
		if(null==element)
		{
			log.info(element+" is null");
			return null;
		}
		boolean status=isDisplayed(element);
		if(status)
		{
			log.info("element text is "+element.getText());
			return element.getText();
		}
		else
		{
			return null;
		}
		
	}


}
