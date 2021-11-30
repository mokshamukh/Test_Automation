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
import testframe.application.premier.pages.Premier_CustomerChangeName;
import testframe.application.premier.pages.Premier_CustomerContact;
import testframe.application.premier.pages.Premier_CustomerInquiry;
import testframe.application.premier.pages.Premier_CustomerNewName;
import testframe.application.premier.pages.Premier_HomeMenu;
import testframe.application.premier.pages.Premier_LogOff;
import testframe.application.premier.pages.Premier_Login;
import testframe.application.premier.pages.Premier_PortfolioNew;
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
	String sName,sFName,sLName,sDOB,sTaxIDCode,sTaxIdentification,sAltName,sAltFirstName,sAltLastName,sPhoneNumber,sEmail,
	sGender,sAddress1,sAddress2,sZipCode;
	String strName;
	String[] strName_Split;

	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver,String sApplicationName, String sURL,String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration, String sHTMLFileName) throws Exception{

		Premier_Login premierLoginPage = new Premier_Login(driver);
		Premier_HomeMenu premierHomeMenuPage = new Premier_HomeMenu(driver);
		Premier_CustomerInquiry premierCustomerInquiryPage = new Premier_CustomerInquiry(driver);
		Premier_CustomerNewName premierCustomerNewName = new Premier_CustomerNewName(driver);
		Premier_CustomerChangeName premierCustomerChangeName = new Premier_CustomerChangeName(driver);
		Premier_CustomerAddress premierCustomerAddress = new Premier_CustomerAddress(driver);
		Premier_CustomerContact premierCustomerContact = new Premier_CustomerContact(driver);
		Premier_PortfolioNew premierPortfolioNew = new Premier_PortfolioNew(driver);
		Premier_LogOff premierLogOff = new Premier_LogOff(driver);

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
			System.setProperty("testcaseid.iteration", sTestCase+"||"+iTDRow);
			fi.createFile(sHTMLFilePath);
			fi.checkAndCreateFolder(sScreenShotFolder);
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);

			new HTMLReportHelper().HTMLReportHeader("Premier", sTestCase, sTestDescription);


			switch(sTestCase.toUpperCase()){

			case "PREMIER_POC":
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
				premierLogOff.logoffApplication();
				break;


			case "PREMIER_TC001":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC002":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC003":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC004":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC005":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC006":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();
				break;
			case "PREMIER_TC007":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));
				premierLogOff.logoffApplication();
				break;
			case "PREMIER_TC008":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC009":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				strName  = tc_Test_Data.get(iTDRow).get("Name_Name");
				strName_Split = strName.split("\\|\\|"); 
				for (int i = 0; i<strName_Split.length-1;i++) {
					sName = strName_Split[i];
					sFName = (tc_Test_Data.get(iTDRow).get("Name_FirstName").split("\\|\\|"))[i];
					sLName = (tc_Test_Data.get(iTDRow).get("Name_LastName").split("\\|\\|"))[i];
					sDOB = (tc_Test_Data.get(iTDRow).get("Name_DOB").split("\\|\\|"))[i];
					sTaxIDCode = (tc_Test_Data.get(iTDRow).get("Name_TaxIDCode").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Name_TaxIdentification").split("\\|\\|"))[i];
					sAltName = (tc_Test_Data.get(iTDRow).get("Name_Alt_Name").split("\\|\\|"))[i];
					sAltFirstName = (tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName").split("\\|\\|"))[i];
					sAltLastName = (tc_Test_Data.get(iTDRow).get("Name_Alt_LastName").split("\\|\\|"))[i];
					if ((tc_Test_Data.get(iTDRow).get("Name_PhoneNumber")).contains("||")) {
						sPhoneNumber = (tc_Test_Data.get(iTDRow).get("Name_PhoneNumber").split("\\|\\|"))[i];
					}else{
						sPhoneNumber = tc_Test_Data.get(iTDRow).get("Name_PhoneNumber");
					}
					if ((tc_Test_Data.get(iTDRow).get("Name_Email")).contains("||")) {
						sEmail = (tc_Test_Data.get(iTDRow).get("Name_Email").split("\\|\\|"))[i];
					}else{
						sEmail = tc_Test_Data.get(iTDRow).get("Name_Email");
					}
					if ((tc_Test_Data.get(iTDRow).get("Name_Gender")).contains("||")) {
						sGender = (tc_Test_Data.get(iTDRow).get("Name_Gender").split("\\|\\|"))[i];
					}else{
						sGender = tc_Test_Data.get(iTDRow).get("Name_Gender");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Address1")).contains("||")) {
						sAddress1 = (tc_Test_Data.get(iTDRow).get("Address_Address1").split("\\|\\|"))[i];
					}else{
						sAddress1 = tc_Test_Data.get(iTDRow).get("Address_Address1");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Address2")).contains("||")) {
						sAddress2 = (tc_Test_Data.get(iTDRow).get("Address_Address2").split("\\|\\|"))[i];
					}else{
						sAddress2 = tc_Test_Data.get(iTDRow).get("Address_Address2");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					////////////to be updated
					if ((tc_Test_Data.get(iTDRow).get("Name_NameFormatCode")).contains("||")) {
						//sName_NameFormatCode = (tc_Test_Data.get(iTDRow).get("Name_NameFormatCode").split("\\|\\|"))[i];
					}else{
						//sName_NameFormatCode = tc_Test_Data.get(iTDRow).get("Name_NameFormatCode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Name_WithholdingCode")).contains("||")) {
						//sName_WithholdingCode" = (tc_Test_Data.get(iTDRow).get("Name_WithholdingCode").split("\\|\\|"))[i];
					}else{
						//sName_WithholdingCode" = tc_Test_Data.get(iTDRow).get("Name_WithholdingCode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}
					
					
					
					
					
					
					
					
					
					
					if(i==0) {
						premierHomeMenuPage.clickNewName();
					}
					premierCustomerNewName.createNewName(sName,sFName,sLName,tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
							sDOB,sTaxIDCode,sTaxIdentification,tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),sAltName,sAltFirstName,sAltLastName,tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
							sPhoneNumber,tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),sEmail,tc_Test_Data.get(iTDRow).get("Name_WebAddress"),sGender,tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
							tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
							tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
					if(i==0) {
						premierHomeMenuPage.clickNewContact();
					}
					premierCustomerContact.createNewContact(sTaxIdentification);
					if(i==0) {
						premierHomeMenuPage.clickNewAddress();
					}
					premierCustomerAddress.createNewAddress(sAddress1, sAddress2, sZipCode, sTaxIdentification, tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));				
				}
				
				
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC010":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer(tc_Test_Data.get(iTDRow).get("ChangeName_SearchLastName"), tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerChangeName.updateNameDetails(tc_Test_Data.get(iTDRow).get("ChangeName_Name"),tc_Test_Data.get(iTDRow).get("ChangeName_LastName"));
				premierCustomerChangeName.goToContactMethodTab();
				premierCustomerChangeName.updateContactMethods(tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"), tc_Test_Data.get(iTDRow).get("ChangeContact_Email"), tc_Test_Data.get(iTDRow).get("ChangeContact_WebAddress"));
				if (!tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneNumber").equals("")){
					String[] multiphone = tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneNumber").split("\\|\\|");
					for(int i=0;i<=multiphone.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType").contains("||"))
							premierCustomerChangeName.addPhoneNumber(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType").split("\\|\\|")[i], multiphone[i]);
						else
							premierCustomerChangeName.addPhoneNumber(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType"), multiphone[i]);
					}
				}
				if (!tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmail").equals("")){
					String[] multimail = tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmail").split("\\|\\|");
					for(int i=0;i<=multimail.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType").contains("||"))
							premierCustomerChangeName.addEmail(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType").split("\\|\\|")[i], multimail[i]);
						else
							premierCustomerChangeName.addEmail(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType"), multimail[i]);
					}
				}
				premierCustomerChangeName.goToRelationshipsTab();
				if (!tc_Test_Data.get(iTDRow).get("ChangeRelationship_SearchSSN").equals("")){
					String[] multiRelationshipSSN = tc_Test_Data.get(iTDRow).get("ChangeRelationship_SearchSSN").split("\\|\\|");
					for(int i=0;i<=multiRelationshipSSN.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship").contains("||"))
							premierCustomerChangeName.buildRelationship(multiRelationshipSSN[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship").split("\\|\\|")[i]);
						else
							premierCustomerChangeName.buildRelationship(multiRelationshipSSN[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship"));
					}
				}

				if (!tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddBeneficialOwnerName").equals("")){

					String[] multiBeneficiary = tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddBeneficialOwnerName").split("\\|\\|");
					for(int i=0;i<=multiBeneficiary.length-1;i++){
						premierCustomerChangeName.clickAddBeneficiary();
						if(tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship").contains("||"))
							premierCustomerChangeName.addDetailsOfBeneficiary(multiBeneficiary[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship").split("\\|\\|")[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialPercent").split("\\|\\|")[i]);
						else
							premierCustomerChangeName.addDetailsOfBeneficiary(multiBeneficiary[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship"),tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialPercent").split("\\|\\|")[i]);
					}
				}

				premierCustomerChangeName.saveDetails();

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC011":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer(tc_Test_Data.get(iTDRow).get("ChangeName_SearchLastName"), tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerChangeName.goToContactMethodTab();
				if (!tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneNumber").equals("")){
					String[] multiphone = tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneNumber").split("\\|\\|");
					for(int i=0;i<=multiphone.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType").contains("||"))
							premierCustomerChangeName.addPhoneNumber(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType").split("\\|\\|")[i], multiphone[i]);
						else
							premierCustomerChangeName.addPhoneNumber(tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneType"), multiphone[i]);
					}
				}
				if (!tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmail").equals("")){
					String[] multimail = tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmail").split("\\|\\|");
					for(int i=0;i<=multimail.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType").contains("||"))
							premierCustomerChangeName.addEmail(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType").split("\\|\\|")[i], multimail[i]);
						else
							premierCustomerChangeName.addEmail(tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmailType"), multimail[i]);
					}
				}
				premierCustomerChangeName.goToRelationshipsTab();
				if (!tc_Test_Data.get(iTDRow).get("ChangeRelationship_SearchSSN").equals("")){
					String[] multiRelationshipSSN = tc_Test_Data.get(iTDRow).get("ChangeRelationship_SearchSSN").split("\\|\\|");
					for(int i=0;i<=multiRelationshipSSN.length-1;i++){
						if(tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship").contains("||"))
							premierCustomerChangeName.buildRelationship(multiRelationshipSSN[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship").split("\\|\\|")[i]);
						else
							premierCustomerChangeName.buildRelationship(multiRelationshipSSN[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship"));
					}
				}

				if (!tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddBeneficialOwnerName").equals("")){

					String[] multiBeneficiary = tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddBeneficialOwnerName").split("\\|\\|");
					for(int i=0;i<=multiBeneficiary.length-1;i++){
						premierCustomerChangeName.clickAddBeneficiary();
						if(tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship").contains("||"))
							premierCustomerChangeName.addDetailsOfBeneficiary(multiBeneficiary[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship").split("\\|\\|")[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialPercent").split("\\|\\|")[i]);
						else
							premierCustomerChangeName.addDetailsOfBeneficiary(multiBeneficiary[i], tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialRelationship"),tc_Test_Data.get(iTDRow).get("ChangeRelationship_BeneficialPercent").split("\\|\\|")[i]);
					}
				}

				premierCustomerChangeName.saveDetails();

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();

				break;


			case "PREMIER_TC012":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				premierHomeMenuPage.clickNewName();
				premierCustomerNewName.createNewName(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_FirstName"),tc_Test_Data.get(iTDRow).get("Name_LastName"),tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_DOB"),tc_Test_Data.get(iTDRow).get("Name_TaxIDCode"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),tc_Test_Data.get(iTDRow).get("Name_Alt_Name"),tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName"),tc_Test_Data.get(iTDRow).get("Name_Alt_LastName"),tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
						tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Name_WebAddress"),tc_Test_Data.get(iTDRow).get("Name_Gender"),
						tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
						tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer(tc_Test_Data.get(iTDRow).get("ChangeName_SearchLastName"), tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerChangeName.updateNameDetails(tc_Test_Data.get(iTDRow).get("ChangeName_Name"),tc_Test_Data.get(iTDRow).get("ChangeName_LastName"));
				premierCustomerChangeName.goToContactMethodTab();
				premierCustomerChangeName.updateContactMethods(tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"), tc_Test_Data.get(iTDRow).get("ChangeContact_Email"), tc_Test_Data.get(iTDRow).get("ChangeContact_WebAddress"));
				premierCustomerChangeName.goToRelationshipsTab();
				premierCustomerChangeName.deleteLastBeneficiary();
				premierCustomerChangeName.saveDetails();

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"));
				premierLogOff.logoffApplication();

				break;	

			case "PREMIER_TC014":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				strName  = tc_Test_Data.get(iTDRow).get("Name_Name");
				strName_Split = strName.split("\\|\\|"); 
				for (int i = 0; i<strName_Split.length-1;i++) {
					sName = strName_Split[i];
					sFName = (tc_Test_Data.get(iTDRow).get("Name_FirstName").split("\\|\\|"))[i];
					sLName = (tc_Test_Data.get(iTDRow).get("Name_LastName").split("\\|\\|"))[i];
					sDOB = (tc_Test_Data.get(iTDRow).get("Name_DOB").split("\\|\\|"))[i];
					sTaxIDCode = (tc_Test_Data.get(iTDRow).get("Name_TaxIDCode").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Name_TaxIdentification").split("\\|\\|"))[i];
					sAltName = (tc_Test_Data.get(iTDRow).get("Name_Alt_Name").split("\\|\\|"))[i];
					sAltFirstName = (tc_Test_Data.get(iTDRow).get("Name_Alt_FirstName").split("\\|\\|"))[i];
					sAltLastName = (tc_Test_Data.get(iTDRow).get("Name_Alt_LastName").split("\\|\\|"))[i];
					if ((tc_Test_Data.get(iTDRow).get("Name_PhoneNumber")).contains("||")) {
						sPhoneNumber = (tc_Test_Data.get(iTDRow).get("Name_PhoneNumber").split("\\|\\|"))[i];
					}else{
						sPhoneNumber = tc_Test_Data.get(iTDRow).get("Name_PhoneNumber");
					}
					if ((tc_Test_Data.get(iTDRow).get("Name_Email")).contains("||")) {
						sEmail = (tc_Test_Data.get(iTDRow).get("Name_Email").split("\\|\\|"))[i];
					}else{
						sEmail = tc_Test_Data.get(iTDRow).get("Name_Email");
					}
					if ((tc_Test_Data.get(iTDRow).get("Name_Gender")).contains("||")) {
						sGender = (tc_Test_Data.get(iTDRow).get("Name_Gender").split("\\|\\|"))[i];
					}else{
						sGender = tc_Test_Data.get(iTDRow).get("Name_Gender");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Address1")).contains("||")) {
						sAddress1 = (tc_Test_Data.get(iTDRow).get("Address_Address1").split("\\|\\|"))[i];
					}else{
						sAddress1 = tc_Test_Data.get(iTDRow).get("Address_Address1");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Address2")).contains("||")) {
						sAddress2 = (tc_Test_Data.get(iTDRow).get("Address_Address2").split("\\|\\|"))[i];
					}else{
						sAddress2 = tc_Test_Data.get(iTDRow).get("Address_Address2");
					}
					if ((tc_Test_Data.get(iTDRow).get("Address_Zipcode")).contains("||")) {
						sZipCode = (tc_Test_Data.get(iTDRow).get("Address_Zipcode").split("\\|\\|"))[i];
					}else{
						sZipCode = tc_Test_Data.get(iTDRow).get("Address_Zipcode");
					}

					premierHomeMenuPage.clickNewName();
					premierCustomerNewName.createNewName(sName,sFName,sLName,tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
							sDOB,sTaxIDCode,sTaxIdentification,tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),sAltName,sAltFirstName,sAltLastName,tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
							sPhoneNumber,tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),sEmail,tc_Test_Data.get(iTDRow).get("Name_WebAddress"),sGender,tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
							tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
							tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"));
					premierHomeMenuPage.clickNewContact();
					premierCustomerContact.createNewContact(sTaxIdentification);
					premierHomeMenuPage.clickNewAddress();
					premierCustomerAddress.createNewAddress(sAddress1, sAddress2, sZipCode, sTaxIdentification, tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				}
				premierLogOff.logoffApplication();
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}
