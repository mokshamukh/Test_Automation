package testframe.application.common;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import testframe.application.commercialcenter.businessflow.AdminTest;
import testframe.common.webdrivermanager.BrowserFactory;

public class SelectApplicationFlow extends ApplicationTestBase  {
	
	String strSelectFlow,testdataFile,testdataFile_Path,strHTMLFileName;
	private WebDriver driver;
	ITestResult result;
		
	public void executeApplicationFlow(String Browser,String ApplicationName, String ModuleName,
			String Sub_Module, String URL,String TestCase, String TestDescription,
			String ApplicationTDFolder, String Iteration, String Manual_TSID) throws Exception{
		
		driver =new BrowserFactory().getDriver(Browser);
		strHTMLFileName = ApplicationName;
		if(!ModuleName.equals(""))
			strHTMLFileName = strHTMLFileName +"_"+ModuleName;
		if(!Sub_Module.equals(""))
			strHTMLFileName = strHTMLFileName +"_"+Sub_Module;
		
		System.setProperty("testcaseid.app.module.submod.testdesc", TestCase+"||"+ApplicationName+"||"+ModuleName+"||"+Sub_Module+"||"+TestDescription+"||"+Manual_TSID);
		switch(ApplicationName.toUpperCase()){

		case "DDF":
			
			break;
			
		case "COMMERCIALCENTER":
			if (ModuleName.toUpperCase().equals("ADMIN")){
				admintest.executeTestCase(driver,ApplicationName,URL,TestCase,TestDescription,ApplicationTDFolder,Iteration,strHTMLFileName,Manual_TSID);
			}
			else if(ModuleName.toUpperCase().equals("CORPORATE")){
				corporatetest.executeTestCase(driver, ApplicationName,URL,TestCase,TestDescription,ApplicationTDFolder,Iteration,strHTMLFileName,Manual_TSID);
			}
			break;
			
		case "EPP":
			epptest.executeTestCase(driver,ApplicationName,URL,TestCase,TestDescription,ApplicationTDFolder,Iteration,strHTMLFileName,Manual_TSID);
			break;
			
		case "PREMIER":
			premiertest.executeTestCase(driver,ApplicationName,URL,TestCase,TestDescription,ApplicationTDFolder,Iteration,strHTMLFileName,Manual_TSID);
			break;
			
		}
		//return status;

	}

}
