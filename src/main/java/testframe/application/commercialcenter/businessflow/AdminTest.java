package testframe.application.commercialcenter.businessflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testframe.application.commercialcenter.pages.Admin_CloneUser;
import testframe.application.commercialcenter.pages.Admin_CompanyDetails;
import testframe.application.commercialcenter.pages.Admin_CreateCompany;
import testframe.application.commercialcenter.pages.Admin_CreateUser;
import testframe.application.commercialcenter.pages.Admin_DeleteCompany;
import testframe.application.commercialcenter.pages.Admin_EditCompany;
import testframe.application.commercialcenter.pages.Admin_EditUser;
import testframe.application.commercialcenter.pages.Admin_HomeMenu;
import testframe.application.commercialcenter.pages.Admin_LogOff;
import testframe.application.commercialcenter.pages.Admin_Login;
import testframe.application.commercialcenter.pages.Admin_SearchCompanies;
import testframe.application.commercialcenter.pages.Admin_SearchUsers;
import testframe.application.common.ApplicationBase;
import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;
import testframe.runmanager.RunDriver;

public class AdminTest extends ApplicationBase {
	String pathToAppConfigPropFolder,pathToApplicationTestDataFolder,appConfigPropertyFilePath,testdataFile,
			testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder
			,sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;
	int iIteration_count;
	String sUserID,sPassword,sCompanyID ,sPassword_Encrypt,sSecretKey;
	
	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver,String sApplicationName, String sURL,String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration, String sHTMLFileName) throws Exception{
		
		Admin_Login adminLoginPage = new Admin_Login(driver);
		Admin_HomeMenu adminHomePage = new Admin_HomeMenu(driver);
		Admin_SearchCompanies adminSearchCompanies = new Admin_SearchCompanies(driver);
		Admin_CreateCompany adminCreateCompany =new Admin_CreateCompany(driver);
		Admin_CompanyDetails adminCompanyDetails = new Admin_CompanyDetails(driver);
		Admin_EditCompany editCompany = new Admin_EditCompany(driver);
		Admin_DeleteCompany deleteCompany = new Admin_DeleteCompany(driver);
		Admin_LogOff adminlogOffPage = new Admin_LogOff(driver);
		Admin_CreateUser adminCreateUser = new Admin_CreateUser(driver);
		Admin_SearchUsers adminSearchUsers = new Admin_SearchUsers(driver);
		Admin_EditUser adminEditUser = new Admin_EditUser(driver);
		Admin_CloneUser adminCloneUser = new Admin_CloneUser(driver);
		
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
		testdataFile = pr.readProperties(appConfigPropertyFilePath,"TestData_Admin_File");
		testdataFile_Path = pathToApplicationTestDataFolder + testdataFile;
		
		sCompanyID = pr.readProperties(appConfigPropertyFilePath,"Admin_CompanyID");
		sUserID = pr.readProperties(appConfigPropertyFilePath,"Admin_UserID");
		sPassword_Encrypt = pr.readProperties(appConfigPropertyFilePath,"Admin_Password");
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
			System.setProperty("testcaseid.iteration", sTestCase+"||"+iTDRow);
			fi.createFile(sHTMLFilePath);
			System.setProperty("runStep","Y");
			fi.checkAndCreateFolder(sScreenShotFolder);
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);
			
			new HTMLReportHelper().HTMLReportHeader("Admin", sTestCase, sTestDescription);
			
			
			switch(sTestCase.toUpperCase()){
			
			case "CC_ADMIN_TC001":
				adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword);
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSubMenuBar();
				adminSearchCompanies.clickCreateCompany();
				adminCreateCompany.createAndSaveCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("BusinessUnit"), tc_Test_Data.get(iTDRow).get("Address"), tc_Test_Data.get(iTDRow).get("City"),
						tc_Test_Data.get(iTDRow).get("State"), tc_Test_Data.get(iTDRow).get("ZipCode"), tc_Test_Data.get(iTDRow).get("Country"), tc_Test_Data.get(iTDRow).get("MarketSegment"),  tc_Test_Data.get(iTDRow).get("BillingAccount"), 
						tc_Test_Data.get(iTDRow).get("TimeZone"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("ProcessingCenter"), tc_Test_Data.get(iTDRow).get("IsBank"), tc_Test_Data.get(iTDRow).get("ReVerification"),
						tc_Test_Data.get(iTDRow).get("AdditionaIDType"), tc_Test_Data.get(iTDRow).get("AdditionaIDValue"), tc_Test_Data.get(iTDRow).get("AddIdentifier"), tc_Test_Data.get(iTDRow).get("Labels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyName"));
				adminCompanyDetails.searchCompaniesSideLink();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyID"), tc_Test_Data.get(iTDRow).get("SearchAccountNumber"), tc_Test_Data.get(iTDRow).get("SearchCompanyName"), tc_Test_Data.get(iTDRow).get("SearchMarketSegment"), tc_Test_Data.get(iTDRow).get("SearchLabel"), tc_Test_Data.get(iTDRow).get("SearchShowLabels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("CompanyID"));
				adminlogOffPage.logoffApplication();
				break;
				
			case "CC_ADMIN_TC002":
				adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword);
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSubMenuBar();
				adminSearchCompanies.clickCreateCompany();
				adminCreateCompany.createAndSaveCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("BusinessUnit"), tc_Test_Data.get(iTDRow).get("Address"), tc_Test_Data.get(iTDRow).get("City"),
						tc_Test_Data.get(iTDRow).get("State"), tc_Test_Data.get(iTDRow).get("ZipCode"), tc_Test_Data.get(iTDRow).get("Country"), tc_Test_Data.get(iTDRow).get("MarketSegment"),  tc_Test_Data.get(iTDRow).get("BillingAccount"), 
						tc_Test_Data.get(iTDRow).get("TimeZone"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("ProcessingCenter"), tc_Test_Data.get(iTDRow).get("IsBank"), tc_Test_Data.get(iTDRow).get("ReVerification"),
						tc_Test_Data.get(iTDRow).get("AdditionaIDType"), tc_Test_Data.get(iTDRow).get("AdditionaIDValue"), tc_Test_Data.get(iTDRow).get("AddIdentifier"), tc_Test_Data.get(iTDRow).get("Labels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyName"));
				adminCompanyDetails.searchCompaniesSideLink();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyID"), tc_Test_Data.get(iTDRow).get("SearchAccountNumber"), tc_Test_Data.get(iTDRow).get("SearchCompanyName"), tc_Test_Data.get(iTDRow).get("SearchMarketSegment"), tc_Test_Data.get(iTDRow).get("SearchLabel"), tc_Test_Data.get(iTDRow).get("SearchShowLabels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("CompanyID"));
				adminCompanyDetails.actionClick();
				adminCompanyDetails.editCompany();
				editCompany.editAndSaveCompany(tc_Test_Data.get(iTDRow).get("Edit_CompanyName"), tc_Test_Data.get(iTDRow).get("Edit_BusinessUnit"), tc_Test_Data.get(iTDRow).get("Edit_Address"), tc_Test_Data.get(iTDRow).get("Edit_City"),
						tc_Test_Data.get(iTDRow).get("Edit_State"), tc_Test_Data.get(iTDRow).get("Edit_ZipCode"), tc_Test_Data.get(iTDRow).get("Edit_Country"), tc_Test_Data.get(iTDRow).get("Edit_MarketSegment"),  tc_Test_Data.get(iTDRow).get("Edit_BillingAccount"), 
						tc_Test_Data.get(iTDRow).get("Edit_TimeZone"), tc_Test_Data.get(iTDRow).get("Edit_EnableDate"), tc_Test_Data.get(iTDRow).get("Edit_ProcessingCenter"), tc_Test_Data.get(iTDRow).get("Edit_IsBank"), tc_Test_Data.get(iTDRow).get("Edit_ReVerification"),
						tc_Test_Data.get(iTDRow).get("Edit_AdditionaIDType"), tc_Test_Data.get(iTDRow).get("Edit_AdditionaIDValue"), tc_Test_Data.get(iTDRow).get("Edit_AddIdentifier"), tc_Test_Data.get(iTDRow).get("Edit_Labels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("Edit_CompanyName"));
				adminCompanyDetails.searchCompaniesSideLink();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("Edit_SearchCompanyID"), tc_Test_Data.get(iTDRow).get("Edit_SearchAccountNumber"), tc_Test_Data.get(iTDRow).get("Edit_SearchCompanyName"), tc_Test_Data.get(iTDRow).get("Edit_SearchMarketSegment"), tc_Test_Data.get(iTDRow).get("Edit_SearchLabel"), tc_Test_Data.get(iTDRow).get("Edit_SearchShowLabels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("Edit_SearchCompanyName"));
				adminlogOffPage.logoffApplication();		
			
			case "CC_ADMIN_TC003_TBD":
				/*adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				adminHomePage.clickOnMenuBar(tc_Test_Data.get(iTDRow).get("MenuBar"));
				adminHomePage.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenuBar"));
				adminSearchCompanies.clickCreateCompany();
				adminCreateCompany.createAndSaveCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("BusinessUnit"), tc_Test_Data.get(iTDRow).get("Address"), tc_Test_Data.get(iTDRow).get("City"),
						tc_Test_Data.get(iTDRow).get("State"), tc_Test_Data.get(iTDRow).get("ZipCode"), tc_Test_Data.get(iTDRow).get("Country"), tc_Test_Data.get(iTDRow).get("MarketSegment"),  tc_Test_Data.get(iTDRow).get("BillingAccount"), 
						tc_Test_Data.get(iTDRow).get("TimeZone"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("ProcessingCenter"), tc_Test_Data.get(iTDRow).get("IsBank"), tc_Test_Data.get(iTDRow).get("ReVerification"),
						tc_Test_Data.get(iTDRow).get("AdditionaIDType"), tc_Test_Data.get(iTDRow).get("AdditionaIDValue"), tc_Test_Data.get(iTDRow).get("AddIdentifier"), tc_Test_Data.get(iTDRow).get("Labels"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateSearchCompany"));
				adminCompanyDetails.searchCompaniesSideLink();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyID"),tc_Test_Data.get(iTDRow).get("SearchCompanyName"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateSearchCompany"));
				adminCompanyDetails.actionClick();
				adminCompanyDetails.deleteCompany();
				deleteCompany.deleteCompany();
				adminCompanyDetails.searchCompaniesSideLink();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyID"),tc_Test_Data.get(iTDRow).get("SearchCompanyName"));
				adminSearchCompanies.noResults();
				adminlogOffPage.logoffApplication();*/
				break;
				
				
				//Create User and Search User	
			case "CC_ADMIN_TC003":
				adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword);
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSubMenuBar();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("AccountNumber"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("MarketSegment"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				//adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateCompanyNameCreation"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("CompanyName")+ " ("+ tc_Test_Data.get(iTDRow).get("CompanyID") + ")");
				adminCompanyDetails.addCompanyUser();
				adminCreateUser.enterUserDetails(tc_Test_Data.get(iTDRow).get("NewUserID"), tc_Test_Data.get(iTDRow).get("FirstName"), tc_Test_Data.get(iTDRow).get("LastName"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("EmailAddress"), tc_Test_Data.get(iTDRow).get("ZipCodeCompanyResides"), tc_Test_Data.get(iTDRow).get("MothersName"), tc_Test_Data.get(iTDRow).get("TemporaryPassword"), tc_Test_Data.get(iTDRow).get("ReEnterTemporaryPassword"));
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSearchUsers();
				adminSearchUsers.searchUser(tc_Test_Data.get(iTDRow).get("User_ID"), tc_Test_Data.get(iTDRow).get("Destination"), tc_Test_Data.get(iTDRow).get("User_Name"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				adminlogOffPage.logoffApplication();
				break;
			
			//Create User and Edit User
			case "CC_ADMIN_TC004":
				adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword);
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSubMenuBar();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("AccountNumber"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("MarketSegment"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				//adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateCompanyNameCreation"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("CompanyName")+ " ("+ tc_Test_Data.get(iTDRow).get("CompanyID") + ")");
				adminCompanyDetails.addCompanyUser();
				adminCreateUser.enterUserDetails(tc_Test_Data.get(iTDRow).get("NewUserID"), tc_Test_Data.get(iTDRow).get("FirstName"), tc_Test_Data.get(iTDRow).get("LastName"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("EmailAddress"), tc_Test_Data.get(iTDRow).get("ZipCodeCompanyResides"), tc_Test_Data.get(iTDRow).get("MothersName"), tc_Test_Data.get(iTDRow).get("TemporaryPassword"), tc_Test_Data.get(iTDRow).get("ReEnterTemporaryPassword"));
				
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSearchUsers();
				adminSearchUsers.searchUser(tc_Test_Data.get(iTDRow).get("NewUserID"), tc_Test_Data.get(iTDRow).get("Destination"), tc_Test_Data.get(iTDRow).get("FirstName")+" "+tc_Test_Data.get(iTDRow).get("LastName"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				adminSearchUsers.clickActionButton(tc_Test_Data.get(iTDRow).get("NewUserID"));
				adminSearchUsers.clickEditButton(tc_Test_Data.get(iTDRow).get("NewUserID"));
				adminEditUser.editUser(tc_Test_Data.get(iTDRow).get("NewUserID"),tc_Test_Data.get(iTDRow).get("CompanyID") +" / "+tc_Test_Data.get(iTDRow).get("NewUserID") ,tc_Test_Data.get(iTDRow).get("EditFirstName"), tc_Test_Data.get(iTDRow).get("EditLastName"), tc_Test_Data.get(iTDRow).get("EditEnableDate"), tc_Test_Data.get(iTDRow).get("EditEmailAddress"), tc_Test_Data.get(iTDRow).get("EditZipCodeCompanyResides"), tc_Test_Data.get(iTDRow).get("EditMothersName"), tc_Test_Data.get(iTDRow).get("EditTemporaryPassword"), tc_Test_Data.get(iTDRow).get("EditReEnterTemporaryPassword"));
				adminlogOffPage.logoffApplication();
				break;
			
			// Create User and Clone User	
			case "CC_ADMIN_TC005":
				adminLoginPage.launchApplication(sURL);
				adminLoginPage.logInToApplication(sCompanyID, sUserID, sPassword);
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSubMenuBar();
				adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("AccountNumber"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("MarketSegment"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				//adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateCompanyNameCreation"));
				adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("CompanyName")+ " ("+ tc_Test_Data.get(iTDRow).get("CompanyID") + ")");
				adminCompanyDetails.addCompanyUser();
				adminCreateUser.enterUserDetails(tc_Test_Data.get(iTDRow).get("NewUserID"), tc_Test_Data.get(iTDRow).get("FirstName"), tc_Test_Data.get(iTDRow).get("LastName"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("EmailAddress"), tc_Test_Data.get(iTDRow).get("ZipCodeCompanyResides"), tc_Test_Data.get(iTDRow).get("MothersName"), tc_Test_Data.get(iTDRow).get("TemporaryPassword"), tc_Test_Data.get(iTDRow).get("ReEnterTemporaryPassword"));
				
				adminHomePage.clickOnMenuBar();
				adminHomePage.clickOnSearchUsers();
				adminSearchUsers.searchUser(tc_Test_Data.get(iTDRow).get("NewUserID"), tc_Test_Data.get(iTDRow).get("Destination"), tc_Test_Data.get(iTDRow).get("FirstName")+" "+tc_Test_Data.get(iTDRow).get("LastName"), tc_Test_Data.get(iTDRow).get("Label"), tc_Test_Data.get(iTDRow).get("ShowLabels"));
				adminSearchUsers.clickActionButton(tc_Test_Data.get(iTDRow).get("NewUserID"));
				adminSearchUsers.clickCloneButton(tc_Test_Data.get(iTDRow).get("NewUserID"));
				adminCloneUser.cloneUserDetails(tc_Test_Data.get(iTDRow).get("CloneUserID"), tc_Test_Data.get(iTDRow).get("CloneFirstName"), tc_Test_Data.get(iTDRow).get("CloneLastName"), tc_Test_Data.get(iTDRow).get("CloneEnableDate"), tc_Test_Data.get(iTDRow).get("CloneEmailAddress"), tc_Test_Data.get(iTDRow).get("CloneZipCodeCompanyResides"), tc_Test_Data.get(iTDRow).get("CloneMothersName"), tc_Test_Data.get(iTDRow).get("CloneTemporaryPassword"), tc_Test_Data.get(iTDRow).get("CloneReEnterTemporaryPassword"));
				adminlogOffPage.logoffApplication();
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}

}

/*adminCreateCompany.createAndSaveCompany(tc_Test_Data.get(iTDRow).get("CompanyID"), tc_Test_Data.get(iTDRow).get("CompanyName"), tc_Test_Data.get(iTDRow).get("BusinessUnit"), tc_Test_Data.get(iTDRow).get("Address"), tc_Test_Data.get(iTDRow).get("City"),
tc_Test_Data.get(iTDRow).get("State"), tc_Test_Data.get(iTDRow).get("ZipCode"), tc_Test_Data.get(iTDRow).get("Country"), tc_Test_Data.get(iTDRow).get("MarketSegment"),  tc_Test_Data.get(iTDRow).get("BillingAccount"), 
tc_Test_Data.get(iTDRow).get("TimeZone"), tc_Test_Data.get(iTDRow).get("EnableDate"), tc_Test_Data.get(iTDRow).get("ProcessingCenter"), tc_Test_Data.get(iTDRow).get("IsBank"), tc_Test_Data.get(iTDRow).get("ReVerification"),
tc_Test_Data.get(iTDRow).get("AdditionaIDType"), tc_Test_Data.get(iTDRow).get("AdditionaIDValue"), tc_Test_Data.get(iTDRow).get("AddIdentifier"), tc_Test_Data.get(iTDRow).get("Labels"));
adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateSearchCompany"));
adminCompanyDetails.searchCompaniesSideLink();
adminSearchCompanies.searchCompany(tc_Test_Data.get(iTDRow).get("SearchCompanyID"), tc_Test_Data.get(iTDRow).get("SearchAccountNumber"), tc_Test_Data.get(iTDRow).get("SearchCompanyName"), tc_Test_Data.get(iTDRow).get("SearchMarketSegment"), tc_Test_Data.get(iTDRow).get("SearchLabel"), tc_Test_Data.get(iTDRow).get("SearchShowLabels"));
adminCompanyDetails.validateSearchCompany(tc_Test_Data.get(iTDRow).get("ValidateSearchCompany"));*/
