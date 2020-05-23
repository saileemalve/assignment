package helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.logger.LoggerHelper;

public class FrameHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(FrameHelper.class); 
	
	public FrameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * this method will switch to frame
	 * @param index
	 */
	
	public  void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
		log.info("switched to : "+index +" frame");
	}
	/**
	 * this method will switch to , index
	 */
	public  void switchToFrame(String name)
	{
		driver.switchTo().frame(name);
		log.info("switched to : "+name +" frame");
	}
	/**
	 * this method will switch to element
	 * @param index
	 */
	public  void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("switched to : frame"+element.toString());
	}

}
