package helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import helper.frame.FrameHelper;
import helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper() {
		this.driver = driver;
	}

	/**
	 * switch to window given name
	 * 
	 * @param name
	 */
	public void switchToWindow(String name) {
		driver.switchTo().window(name);
		log.info("switched to : " + name + " window");
	}

	/**
	 * switch to window parent
	 * 
	 * @param name
	 */
	public void switchToParentWindow() {
		driver.switchTo().defaultContent();
		log.info("switched to : " + "parent");
	}

	/**
	 * switch to perticular window
	 * 
	 * @param name
	 */

	public void switchToWindows(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;

		for (String window : windows) {
			log.info("switched to : " + "parent");
			if (i == index) {
				driver.switchTo().window(window);
			} else
				i++;

		}
	}

	public void closeAllTabsAndSwitchToParentWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();
		log.info("switched to : " + "parent and close tabs");
		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

	public void navigateback()

	{
		driver.navigate().back();
	}
	public void navigateforwad()

	{
		driver.navigate().forward();
	}
}
