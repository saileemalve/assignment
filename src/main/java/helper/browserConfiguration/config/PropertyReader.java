package helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import helper.browserConfiguration.BrowserConfiguration.BrowserType;
import helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties or;
	static {

		String filepath = ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\config.properties");

		try {
			file = new FileInputStream(new File(filepath));
			or = new Properties();
			or.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(or.getProperty("impliciteWait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(or.getProperty("expliciteWait"));
	}

	public int pageLoadType() {
		// TODO Auto-generated method stub
		return Integer.parseInt(or.getProperty("pageLoadTime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(or.getProperty("browserType"));
		// TODO Auto-generated method stub

	}

	public String getUrl() {
		if(System.getProperty("url")!=null)
			{
			return System.getProperty("url");
			};
		//System.out.println(or.getProperty("applicationUrl"));
		return or.getProperty("applicationUrl");
	}
	public String getUsername() {
		if(System.getProperty("userName")!=null)
		{
		return System.getProperty("userName");
		};
		System.out.println(or.getProperty("userName"));
		return or.getProperty("userName");
	}
	public String getPassword() {
		if(System.getProperty("password")!=null)
		{
		return System.getProperty("password");
		};
		System.out.println(or.getProperty("password"));
		return or.getProperty("password");
	}

	

}
