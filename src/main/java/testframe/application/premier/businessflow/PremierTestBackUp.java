package testframe.application.premier.businessflow;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import testframe.application.common.ApplicationBase;
import testframe.application.premier.pages.Premier_CustomerAddress;
import testframe.application.premier.pages.Premier_CustomerChangeName;
import testframe.application.premier.pages.Premier_CustomerContact;
import testframe.application.premier.pages.Premier_CustomerInquiry;
import testframe.application.premier.pages.Premier_CustomerNewName;
import testframe.application.premier.pages.Premier_DepositAccounts;
import testframe.application.premier.pages.Premier_HomeMenu;
import testframe.application.premier.pages.Premier_LogOff;
import testframe.application.premier.pages.Premier_Login;
import testframe.application.premier.pages.Premier_PortfolioNew;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;

public class PremierTestBackUp extends ApplicationBase {
	String pathToAppConfigPropFolder,pathToApplicationTestDataFolder,appConfigPropertyFilePath,testdataFile,
	testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder
	,sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;
	int iIteration_count,iPortfolioCustomerCount;
	String sDepositRelationship,sDepositStatement;
	String sUserID,sPassword,sCompanyID ,sPassword_Encrypt,sSecretKey,sInstitution,sGroup;
	String sName,sFName,sLName,sDOB,sTaxIDCode,sTaxIdentification,sAltName,sAltFirstName,sAltLastName,sPhoneNumber,sEmail,
	sGender,sAddress1,sAddress2,sZipCode,sPortfolioRelationship,sPortfolioNameFormatCode;
	String strName;
	String[] strName_Split;
	String sName_NameFormatCode,sName_WithholdingCode,sName_Alt_NameFormatCode,sName_WebAddress,sName_RiskRanking,sName_CreditScore,
	sName_NAICSCodes_EconomicSector,sName_CustomerType,sName_BranchRegion,sName_BuildRelationship_SSN,sName_BeneficialOwnerName,sName_Build_Relationship,
	sName_Beneficial_Relationship,sName_Beneficial_Percent,sAddress_BuildRelationship,sAlt_MiddleInitial,sName_AddEmailType,sName_AddPhoneType;
	
	
	static Premier_Login premierLoginPage;
	static	Premier_HomeMenu premierHomeMenuPage;
	static	Premier_CustomerInquiry premierCustomerInquiryPage;
	static Premier_CustomerNewName premierCustomerNewName;
	static Premier_CustomerChangeName premierCustomerChangeName;
	static Premier_CustomerAddress premierCustomerAddress;
	static Premier_CustomerContact premierCustomerContact;
	static Premier_PortfolioNew premierPortfolioNew;
	static Premier_LogOff premierLogOff;
	static  Premier_DepositAccounts premierDepositAccounts;
	
	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver,String sApplicationName, String sURL,String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration, String sHTMLFileName) throws Exception{



		premierLoginPage = new Premier_Login(driver);
		premierHomeMenuPage = new Premier_HomeMenu(driver);
		premierCustomerInquiryPage = new Premier_CustomerInquiry(driver);
		premierCustomerNewName = new Premier_CustomerNewName(driver);
		premierCustomerChangeName = new Premier_CustomerChangeName(driver);
		premierCustomerAddress = new Premier_CustomerAddress(driver);
		premierCustomerContact = new Premier_CustomerContact(driver);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
		premierLogOff = new Premier_LogOff(driver);
		premierDepositAccounts = new Premier_DepositAccounts(driver);

		
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				
				premierHomeMenuPage.customerInquiry();
				premierCustomerInquiryPage.searchCustomer("", tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierCustomerInquiryPage.seeAdditionalAddresses();
				premierCustomerInquiryPage.customerExpand();
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_Name"),tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),tc_Test_Data.get(iTDRow).get("Name_PhoneNumber"),tc_Test_Data.get(iTDRow).get("Name_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
				premierLogOff.logoffApplication();
				
				break;

			case "PREMIER_TC009":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
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
				premierCustomerInquiryPage.validateCustomerDetails(tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("ChangeName_LastName"),tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN"),tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");
				premierLogOff.logoffApplication();

				break;	

			case "PREMIER_TC013":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				if((tc_Test_Data.get(iTDRow).get("Address_UpdateExistingAddress1")).equals(""))	
					new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");
				else{
					premierHomeMenuPage.customerMenu();
					premierHomeMenuPage.goToAddress();
				}
				premierHomeMenuPage.goToChangeAddress();
				premierCustomerAddress.searchAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"));
				premierCustomerAddress.updateAddress(tc_Test_Data.get(iTDRow).get("Address_UpdateAddress1"), tc_Test_Data.get(iTDRow).get("Address_UpdateAddress2"),
						tc_Test_Data.get(iTDRow).get("Address_UpdateZipCode"),tc_Test_Data.get(iTDRow).get("Address_UpdateBranchRegion"), 
						tc_Test_Data.get(iTDRow).get("Address_UpdateSeasonalAddress1"), tc_Test_Data.get(iTDRow).get("Address_UpdateSeasonalAddress2"), 
						tc_Test_Data.get(iTDRow).get("Address_UpdateSeasonalZipCode"));
				premierCustomerAddress.saveAddress();
				new PremierCommonNavigation().customerInquiry("",  tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"),"", "",	"",
						tc_Test_Data.get(iTDRow).get("Address_UpdateAddress1"), tc_Test_Data.get(iTDRow).get("Address_UpdateAddress2"),
						tc_Test_Data.get(iTDRow).get("Address_UpdateZipCode"),"","");
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC014":
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				premierPortfolioNew.portfolioSearchCustomer(tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1"),1);
				if (!tc_Test_Data.get(iTDRow).get("Portfolio_Address1").equals("")) {
					premierPortfolioNew.portfolioSearchAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"));
				}
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				//premierPortfolioNew.portfolioNew_PossibleDuplicate();
				premierPortfolioNew.portfolioNew_NameScreen(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship"),1);
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC015":
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
						tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
				premierHomeMenuPage.clickNewContact();
				premierCustomerContact.createNewContact(tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"));
				premierHomeMenuPage.clickNewAddress();
				premierCustomerAddress.createNewAddress(tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"), tc_Test_Data.get(iTDRow).get("Name_TaxIdentification"), tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));

				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				premierPortfolioNew.portfolioCustomerName(tc_Test_Data.get(iTDRow).get("Portfolio_Name1"),tc_Test_Data.get(iTDRow).get("Portfolio_TaxCode1"),tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1"),tc_Test_Data.get(iTDRow).get("Portfolio_DOB1"),1);
				premierPortfolioNew.portfolioCustomerAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"),tc_Test_Data.get(iTDRow).get("Portfolio_Address2"),tc_Test_Data.get(iTDRow).get("Portfolio_CityStateZip"));
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				premierPortfolioNew.portfolioNew_PossibleDuplicate();
				premierPortfolioNew.portfolioNew_NameScreen(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship"),1);
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();

			case "PREMIER_TC016":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.customerMenu();

				String strName  = tc_Test_Data.get(iTDRow).get("Name_Name");
				String[] strName_Split = strName.split("\\|\\|"); 
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
					if(i==0) {
						premierHomeMenuPage.clickNewName();
					}
					premierCustomerNewName.createNewName(sName,sFName,sLName,tc_Test_Data.get(iTDRow).get("Name_NameFormatCode"),
							sDOB,sTaxIDCode,sTaxIdentification,tc_Test_Data.get(iTDRow).get("Name_WithholdingCode"),sAltName,sAltFirstName,sAltLastName,tc_Test_Data.get(iTDRow).get("Name_Alt_MiddleInitial"),tc_Test_Data.get(iTDRow).get("Name_Alt_NameFormatCode"),
							sPhoneNumber,tc_Test_Data.get(iTDRow).get("Name_BranchRegion"),sEmail,tc_Test_Data.get(iTDRow).get("Name_WebAddress"),sGender,tc_Test_Data.get(iTDRow).get("Name_RiskRanking"),tc_Test_Data.get(iTDRow).get("Name_CreditScore"),tc_Test_Data.get(iTDRow).get("Name_NAICSCodes_EconomicSector"),tc_Test_Data.get(iTDRow).get("Name_CustomerType"),tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_SSN"),
							tc_Test_Data.get(iTDRow).get("Name_Build_Relationship"),tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship"),tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent"),
							tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BuildRelationship_2_SSN"), tc_Test_Data.get(iTDRow).get("Name_Build_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwner_2_Flag"), tc_Test_Data.get(iTDRow).get("Name_BeneficialOwnerName_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Relationship_2"), tc_Test_Data.get(iTDRow).get("Name_Beneficial_Percent_2"),"","");
					if(i==0) {
						premierHomeMenuPage.clickNewContact();
					}
					premierCustomerContact.createNewContact(sTaxIdentification);
					if(i==0) {
						premierHomeMenuPage.clickNewAddress();
					}
					premierCustomerAddress.createNewAddress(sAddress1, sAddress2, sZipCode, sTaxIdentification, tc_Test_Data.get(iTDRow).get("Address_BuildRelationship"),tc_Test_Data.get(iTDRow).get("Name_BranchRegion"));				
				}
				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				String strPortfolioTaxNumber  = tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1");
				String[] strPortfolioTaxNumber_Split = strPortfolioTaxNumber.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioTaxNumber_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
					if (i>2) {
						premierPortfolioNew.clickAddNameLink();
					}
					premierPortfolioNew.portfolioSearchCustomer(sTaxIdentification,i+1);
				}
				if (!tc_Test_Data.get(iTDRow).get("Portfolio_Address1").equals("")) {
					premierPortfolioNew.portfolioSearchAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"));
				}
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				//premierPortfolioNew.portfolioNew_PossibleDuplicate();
				for (int i = 0; i<iPortfolioCustomerCount;i++) {	
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
						sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
					}else {
						sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
					}
					premierPortfolioNew.portfolioNew_NameScreen(sPortfolioRelationship,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();
				break;
			case "PREMIER_TC017":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Portfolio_Name1");
				String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = strPortfolioCustName_Split[i];
					sTaxIDCode = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxCode1").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
					sDOB = (tc_Test_Data.get(iTDRow).get("Portfolio_DOB1").split("\\|\\|"))[i];
					if (i>2) {
						premierPortfolioNew.clickAddNameLink();
					}
					premierPortfolioNew.portfolioCustomerName(sName,sTaxIDCode,sTaxIdentification,sDOB,i+1);
				}
				premierPortfolioNew.portfolioCustomerAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"),tc_Test_Data.get(iTDRow).get("Portfolio_Address2"),tc_Test_Data.get(iTDRow).get("Portfolio_CityStateZip"));
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				premierPortfolioNew.portfolioNew_PossibleDuplicate_NewCustomer();

				for (int i = 0; i<iPortfolioCustomerCount;i++) {	
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
						sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
					}else {
						sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").contains("||")) {
						sPortfolioNameFormatCode = (tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").split("\\|\\|"))[i];
					}else {
						sPortfolioNameFormatCode = tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").contains("||")) {
						sPhoneNumber = (tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").split("\\|\\|"))[i];
					}else {
						sPhoneNumber = tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Email").contains("||")) {
						sEmail = (tc_Test_Data.get(iTDRow).get("Portfolio_Email").split("\\|\\|"))[i];
					}else {
						sEmail = tc_Test_Data.get(iTDRow).get("Portfolio_Email");
					}
					premierPortfolioNew.portfolioNew_NameScreenMultipleCust(sPortfolioRelationship,sPortfolioNameFormatCode,sPhoneNumber,sEmail,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_AddressScreen();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC018":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Portfolio_Name1");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = strPortfolioCustName_Split[i];
					sTaxIDCode = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxCode1").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
					sDOB = (tc_Test_Data.get(iTDRow).get("Portfolio_DOB1").split("\\|\\|"))[i];
					if (i>2) {
						premierPortfolioNew.clickAddNameLink();
					}
					premierPortfolioNew.portfolioCustomerName(sName,sTaxIDCode,sTaxIdentification,sDOB,i+1);
				}
				premierPortfolioNew.portfolioCustomerAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"),tc_Test_Data.get(iTDRow).get("Portfolio_Address2"),tc_Test_Data.get(iTDRow).get("Portfolio_CityStateZip"));
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				premierPortfolioNew.portfolioNew_PossibleDuplicate_NewCustomer();
				
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
						sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
					}else {
						sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").contains("||")) {
						sPortfolioNameFormatCode = (tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").split("\\|\\|"))[i];
					}else {
						sPortfolioNameFormatCode = tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").contains("||")) {
						sPhoneNumber = (tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").split("\\|\\|"))[i];
					}else {
						sPhoneNumber = tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber");
					}
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Email").contains("||")) {
						sEmail = (tc_Test_Data.get(iTDRow).get("Portfolio_Email").split("\\|\\|"))[i];
					}else {
						sEmail = tc_Test_Data.get(iTDRow).get("Portfolio_Email");
					}
					premierPortfolioNew.portfolioNew_NameScreenMultipleCust(sPortfolioRelationship,sPortfolioNameFormatCode,sPhoneNumber,sEmail,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_AddressScreen();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC019":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				strPortfolioTaxNumber  = tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1");
				strPortfolioTaxNumber_Split = strPortfolioTaxNumber.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioTaxNumber_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
					if (i>2) {
						premierPortfolioNew.clickAddNameLink();
					}
					premierPortfolioNew.portfolioSearchCustomer(sTaxIdentification,i+1);
				}
				if (!tc_Test_Data.get(iTDRow).get("Portfolio_Address1").equals("")) {
					premierPortfolioNew.portfolioSearchAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"));
				}
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				//premierPortfolioNew.portfolioNew_PossibleDuplicate();
				for (int i = 0; i<iPortfolioCustomerCount;i++) {	
					if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
						sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
					}else {
						sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
					}
					premierPortfolioNew.portfolioNew_NameScreen(sPortfolioRelationship,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();
				break;
			case "PREMIER_TC020":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioChange();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				premierPortfolioNew.changePortfolioDetails(tc_Test_Data.get(iTDRow).get("PortfolioChange_BranchRegion"),tc_Test_Data.get(iTDRow).get("PortfolioChange_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("PortfolioChange_Relationship"));

				strPortfolioTaxNumber  = tc_Test_Data.get(iTDRow).get("PortfolioChange_SSN");
				strPortfolioTaxNumber_Split = strPortfolioTaxNumber.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioTaxNumber_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("PortfolioChange_SSN").split("\\|\\|"))[i];
					sName = (tc_Test_Data.get(iTDRow).get("PortfolioChange_NewName").split("\\|\\|"))[i];
					sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("PortfolioChange_RelationshipNewName").split("\\|\\|"))[i];
					premierPortfolioNew.addCustomer(sTaxIdentification,sName,sPortfolioRelationship,i+2);
				}
				premierPortfolioNew.portfolioSaveButton();
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC021":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.newDemandDeposits();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC022":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.newDemandDeposits();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
				
			case "PREMIER_TC023":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.newDemandDeposits();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC024":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				premierDepositAccounts.changeAccountCodeDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));
				premierDepositAccounts.validateAccountDetailsAfterChange(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			
			case "PREMIER_TC025":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC026":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
				
			case "PREMIER_TC027":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC028":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.changeAccountSavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				premierDepositAccounts.changeAccountCodeDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));
				premierDepositAccounts.validateAccountDetailsAfterChange(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			
			case "PREMIER_TC029":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));				
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC030":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreen(sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));					
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
				
			case "PREMIER_TC031":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.newAccountSavings();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
					premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
				}
				premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
				premierDepositAccounts.depositFinishButton();//need to update
				
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));					
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
					sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
					premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
				}
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			case "PREMIER_TC032":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.changeAccountSavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
				premierDepositAccounts.changeAccountCodeDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));
				premierDepositAccounts.validateAccountDetailsAfterChange(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_warning"),tc_Test_Data.get(iTDRow).get("Deposit_StatusCode"),tc_Test_Data.get(iTDRow).get("Deposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("Deposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}
