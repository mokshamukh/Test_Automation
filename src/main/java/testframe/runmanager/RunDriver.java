package testframe.runmanager;

import java.util.List;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import testframe.application.common.SelectApplicationFlow;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;
import testframe.common.utilities.ExcelReader;
import testframe.common.utilities.PropertyReader;

public class RunDriver {
	public  String strApplication_Name,strModule_Name,strSubModule_Name,strURL,strTCModule_Name
						 ,strTCNum,strTCSubModule_Name,strManualTSID,strTestDescription,strTCIterations
						 ,strTD_filePath,strTD_sheetName;
	
	String strMasterfilePath,strpathToAppTestDataFolder,strRunOnBrowser,strResult;
	String strAppFlag ="N", strTCFlag ="N";
	
	PropertyReader pr =new PropertyReader();
	ExcelReader er = new ExcelReader();
	SelectApplicationFlow af =new SelectApplicationFlow();
	
	static{
		String sCurrentDateTime = new DateTimeHelper().CurrentDateTime("MM-dd-yyyy-hh-mm-ss");
		System.setProperty("current.date.time",sCurrentDateTime);
		System.setProperty("runStep","Y");
	}
	 
	@Test()
	public void navigateToTest() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		Log.info("<<<<<<<<<<<<<         Execution Kick Off - Reading Master file         >>>>>>>>>>>>>"); 
		strMasterfilePath = pr.pathToMasterFromFrameworkPropFile();
		strpathToAppTestDataFolder =pr.pathToApplicationTestDataFolderFromFrameworkPropFile();
		strRunOnBrowser = pr.getParamfromConfigProperties("BrowserToUse");
		List<Map<String, String>> app_Data = er.getData(strMasterfilePath,"APP_INFO");
		for(int iAppRow =0; iAppRow<=app_Data.size()-1;iAppRow++){
			if((app_Data.get(iAppRow).get("Execute")).equalsIgnoreCase("Y")){
				System.setProperty("runStep","Y");
				strAppFlag ="Y";
				strApplication_Name= app_Data.get(iAppRow).get("Application_Name");
				Log.info("$$           Test Execution for Application : " + strApplication_Name.toUpperCase() +"           $$");
				strModule_Name = app_Data.get(iAppRow).get("Module");
				strSubModule_Name = app_Data.get(iAppRow).get("Sub_Module");
				strURL = app_Data.get(iAppRow).get("URL");
				strTD_filePath = strMasterfilePath;
				strTD_sheetName = strApplication_Name;
				new HTMLReportHelper().setMasterFilePath(strMasterfilePath);
				new HTMLReportHelper().setExecutionStart(new DateTimeHelper().CurrentDateTime("yyyy/MM/dd HH:mm:ss"));
				List<Map<String, String>> tc_App_Data = er.getData(strMasterfilePath,strApplication_Name);
				Log.info("$$           Reading Test Case Details from '"+ strApplication_Name.toUpperCase() + "' sheet of Master file           $$");
				for(int iTCAppRow =0; iTCAppRow<=tc_App_Data.size()-1;iTCAppRow++){
					if((tc_App_Data.get(iTCAppRow).get("Execute")).equalsIgnoreCase("Y")){
						strTCFlag ="Y";
						strTCModule_Name = tc_App_Data.get(iTCAppRow).get("Module");
						strTCNum = tc_App_Data.get(iTCAppRow).get("TC#");
						strTCSubModule_Name = tc_App_Data.get(iTCAppRow).get("Sub_Module");
						strManualTSID = tc_App_Data.get(iTCAppRow).get("Manual_TS#");
						strTestDescription = tc_App_Data.get(iTCAppRow).get("TestDescription");
						strTCIterations = tc_App_Data.get(iTCAppRow).get("Iterations");
						//strTCModule_Name = tc_App_Data.get(iTCAppRow).get("ExexutionStatus");
						//strTCModule_Name = tc_App_Data.get(iTCAppRow).get("Date");
						Log.startTestCase(strTCNum,strTestDescription);
						af.executeApplicationFlow(strRunOnBrowser, strApplication_Name, strModule_Name, strSubModule_Name, strURL, strTCNum,strTestDescription,strpathToAppTestDataFolder,strTCIterations,strManualTSID);
						Log.endTestCase(strTCNum);
					}
					
				}
				
			}
			
		}
		if(strAppFlag.equals("N")){
			System.out.println("No Application is marked as 'Y' for execution in 'APP_IFO' sheet of Master file");
			Log.info("<<<<<<<<<<<<<         No Application is marked as 'Y' for execution in 'APP_IFO' sheet of Master file         >>>>>>>>>>>>>");
		}else{
			if(strTCFlag.equals("N")){
				System.out.println("No Test Case is marked as 'Y' for execution in Master file");
				Log.info("<<<<<<<<<<<<<         No Test Case is marked as 'Y' for execution in Master file         >>>>>>>>>>>>>");
			}
		}
	}
	
		
	@AfterMethod
	public void tearDown(ITestResult result) {
	   if (result.getStatus() == ITestResult.FAILURE) {
	      //your screenshooting code goes here
		   System.out.println("FAIL");
		   
	   }   
	   if (result.getStatus() == ITestResult.SUCCESS) {
		      //your screenshooting code goes here
			   System.out.println("Pass");
			   
	   } 
	}
	
	
	
}
