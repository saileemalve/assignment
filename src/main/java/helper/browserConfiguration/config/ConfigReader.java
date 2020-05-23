package helper.browserConfiguration.config;

import helper.browserConfiguration.BrowserConfiguration.BrowserType;

public interface ConfigReader {
	
	public int getImpliciteWait();
	public int getExplicitWait();
	public int pageLoadType();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUsername();
	public String getPassword();
	
	

}
