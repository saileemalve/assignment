package helper.browserConfiguration;

import org.apache.log4j.lf5.util.Resource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import helper.resource.ResourceHelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		DesiredCapabilities chrome=DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		return option;
		
	}
	public WebDriver getChromeDriver(ChromeOptions cap)
	{
		if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("\\src\\main\\resources\\driver\\chromedriver.exe"));
		}return new ChromeDriver(cap);
	}
}
