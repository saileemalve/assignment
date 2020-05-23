package helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import helper.logger.LoggerHelper;

public class Retry  implements IRetryAnalyzer{

	private int retryCount = 0;
	private int maxRetryCount = 3;

	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult args) {

		if (retryCount < maxRetryCount) {
			log.info("Retrying Test "+ args.getName()+" with STATUS "+getResultStatusName(args.getStatus())+" for the "+(retryCount+1)+" times");
			retryCount++;
			return true;

		}
		return false;

	}
	public String getResultStatusName(int status)
	{
		String resultName=null;
		if(status==1)
		{
			resultName="SUCCCESS";
			
		}
		if(status==2)
		{
			resultName="FAILURE";
		}
		if(status==3)
		{
			resultName="SKIP";
		}
		return resultName;
	}

}
