package helper.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import helper.logger.LoggerHelper;

public class RetryListener implements IAnnotationTransformer {
	private Logger log = LoggerHelper.getLogger(Retry.class);
	
	public void transform(ITestAnnotation arg0,Class arg1,Constructor arg2,Method arg3)
	{
		IRetryAnalyzer	retry=arg0.getRetryAnalyzer();
		if(retry==null)
		{
			arg0.setRetryAnalyzer(Retry.class);
		}
	}


}
