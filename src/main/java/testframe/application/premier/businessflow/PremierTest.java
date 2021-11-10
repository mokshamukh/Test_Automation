package testframe.application.premier.businessflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import testframe.application.common.ApplicationBase;
import testframe.application.common.CommonLibrary;
import testframe.application.premier.pages.Premier_CustomerAddress;
import testframe.application.premier.pages.Premier_CustomerContact;
import testframe.application.premier.pages.Premier_CustomerInquiry;
import testframe.application.premier.pages.Premier_CustomerNewName;
import testframe.application.premier.pages.Premier_HomeMenu;
import testframe.application.premier.pages.Premier_LogOff;
import testframe.application.premier.pages.Premier_Login;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;
import testframe.runmanager.RunDriver;

public class PremierTest extends ApplicationBase {
	String pathToAppConfigPropFolder,pathToApplicationTestDataFolder,appConfigPropertyFilePath,testdataFile,
			testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder
			,sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;
	int iIteration_count;
	String sUserID,sPassword,sCompanyID ,sPassword_Encrypt,sSecretKey,sInstitution,sGroup;
	
	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver,String sApplicationName, String sURL,String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration, String sHTMLFileName) throws Exception{
		
		Premier_Login premierLoginPage = new Premier_Login(driver);
		Premier_HomeMenu premierHomeMenuPage = new Premier_HomeMenu(driver);
		Premier_CustomerInquiry premierCustomerInquiryPage = new Premier_CustomerInquiry(driver);
		Premier_CustomerNewName premierCustomerNewName = new Premier_CustomerNewName(driver);
		Premier_CustomerAddress premierCustomerAddress = new Premier_CustomerAddress(driver);
		Premier_CustomerContact premierCustomerContact = new Premier_CustomerContact(driver);
		
		
		sPathToAppReportFolder = pr.pathToAppReportFolderFromFrameworkPropFile();
		strpathToAppReportFile = sPathToAppReportFolder + "/" + sApplicationName;
		fi.checkAndCreateFolder(strpathToAppReportFile);
		
		strpathToAppReportFileDateTimeStamp = strpathToAppReportFile+"/" +  System.getProperty("current.date.time");
		fi.checkAndCreateFolder(strpathToAppReportFileDateTimeStamp);
		
		sScreenShotFolder= strpathToAppReportFileDateTimeStamp +"/Screenshots";
		fi.checkAndCreateFolder(sScreenShotFolder);
		
		sScreenShotFolder = sScreenShotFolder +"/" + sTestCase.toUpperCase()+ "_" +  sHTMLFileName;
		fi.checkAndCreateFolder(sScreenShotFolder);
		sScreenShotFolder_Itr = sScreenShotFolder;
		
		pathToAppConfigPropFolder = pr.pathToAppConfigPropFolderFromFrameworkPropFile();
		pathToApplicationTestDataFolder = pr.pathToApplicationTestDataFolderFromFrameworkPropFile();
		appConfigPropertyFilePath = pathToAppConfigPropFolder + "/" + sApplicationName +"_config.properties";
		testdataFile = pr.readProperties(appConfigPropertyFilePath,"TestData_Premier_File");
		testdataFile_Path = pathToApplicationTestDataFolder + testdataFile;
		
		sGroup = pr.readProperties(appConfigPropertyFilePath,"Group");
		sUserID = pr.readProperties(appConfigPropertyFilePath,"Premier_UserID");
		sPassword_Encrypt = pr.readProperties(appConfigPropertyFilePath,"Premier_Password");
		sInstitution = pr.readProperties(appConfigPropertyFilePath,"Institution");
		sSecretKey = pr.readProperties(appConfigPropertyFilePath,"Secret_Key");
		sPassword = ed.decrypt(sPassword_Encrypt, sSecretKey);
		
		if(sIteration == "")
			iIteration_count =0;
		else if(sIteration == "1")
			iIteration_count =0;
		else if(Integer.parseInt(sIteration) > 1)
			iIteration_count = Integer.parseInt(sIteration) -1;
		
		List<Map<String, String>> tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
		for(int iTDRow =0; iTDRow<=iIteration_count;iTDRow++){
			
			if (iIteration_count == 0){
				sHTMLFilePath= strpathToAppReportFileDateTimeStamp +"/" + sTestCase.toUpperCase()+ "_" +  sHTMLFileName+"_"+ new DateTimeHelper().CurrentDateTime()+".html" ;
				Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"Iteration - 1"+"             XXXXXXXXXXXXXXXXXXXXXX");
			}	
			else {
				sScreenShotFolder=sScreenShotFolder_Itr;
				sHTMLFilePath= strpathToAppReportFileDateTimeStamp +"/" + sTestCase.toUpperCase()+ "_" +  sHTMLFileName+"_"+"Iterations-"+ (iTDRow+1) +"_" + new DateTimeHelper().CurrentDateTime()+".html" ;
				sScreenShotFolder = sScreenShotFolder +"/" +"Iterations-"+ (iTDRow+1);
				Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"Iteration - " + (iTDRow+1)+"             XXXXXXXXXXXXXXXXXXXXXX");
			}
			fi.createFile(sHTMLFilePath);
			fi.checkAndCreateFolder(sScreenShotFolder);
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);
			
			new HTMLReportHelper().HTMLReportHeader("Premier", sTestCase, sTestDescription);
			System.setProperty("testcaseid.iteration", sTestCase+"||"+iTDRow);
			
			switch(sTestCase.toUpperCase()){
			
			case "PREMIER_TC001":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();
				
				
				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("SSN_Search"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.getCustomer(testdataFile_Path, sTestCase, iTDRow+1);
				
				
				
				/*premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name"),tc_Test_Data.get(iTDRow).get("FirstName"),tc_Test_Data.get(iTDRow).get("LastName"),tc_Test_Data.get(iTDRow).get("DOB"),tc_Test_Data.get(iTDRow).get("TaxIdentification"),tc_Test_Data.get(iTDRow).get("PhoneNumber"),tc_Test_Data.get(iTDRow).get("BranchRegion"),tc_Test_Data.get(iTDRow).get("Email"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address1"), tc_Test_Data.get(iTDRow).get("Address2"), tc_Test_Data.get(iTDRow).get("Zipcode"), tc_Test_Data.get(iTDRow).get("TaxIdentification"), tc_Test_Data.get(iTDRow).get("Relationship"),tc_Test_Data.get(iTDRow).get("BranchRegion"));
				*/
				break;
				
				
				
				
				
				
						
			}
			
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
	
	
		
	
	

}
