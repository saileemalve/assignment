package helper.resource;

import org.apache.log4j.Logger;

import helper.logger.LoggerHelper;

public class ResourceHelper {
	//private static Logger log = LoggerHelper.getLogger(ResourceHelper.class);

	public static String getResourcePath(String path) {
		String basepath = System.getProperty("user.dir");
		//log.info("basepath : " + basepath + "path: " + path);

		return basepath + path;

	}

}
