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
import testframe.application.premier.pages.Premier_LinesNewLine;
import testframe.application.premier.pages.Premier_LoansChangeAccount;
import testframe.application.premier.pages.Premier_LoansNewNote;
import testframe.application.premier.pages.Premier_LogOff;
import testframe.application.premier.pages.Premier_Login;
import testframe.application.premier.pages.Premier_NewCollateral;
import testframe.application.premier.pages.Premier_PortfolioNew;
import testframe.application.premier.pages.Premier_SafeDepositBox;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;

public class PremierTest extends ApplicationBase {
	String pathToAppConfigPropFolder,pathToApplicationTestDataFolder,appConfigPropertyFilePath,testdataFile,
	testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder
	,sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;

	int iIteration_count,iPortfolioCustomerCount;
	String sDepositRelationship,sDepositStatement;
	String sSDBRelationship,sSDBStatement;
	String sUserID,sPassword,sCompanyID ,sPassword_Encrypt,sSecretKey,sInstitution,sGroup,sEnvType;
	String sName,sFName,sLName,sDOB,sTaxIDCode,sTaxIdentification,sAltName,sAltFirstName,sAltLastName,sPhoneNumber,sEmail,
	sGender,sAddress1,sAddress2,sZipCode,sPortfolioRelationship,sPortfolioNameFormatCode,strPortfolioTaxNumber,sLineName;
	String strName;
	String[] strName_Split,strPortfolioTaxNumber_Split;
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
	static  Premier_LinesNewLine premierLinesNewLine;
	static  Premier_LoansNewNote premierLoansNewNote;
	static  Premier_LoansChangeAccount premierLoansChange;
	static  Premier_SafeDepositBox premierSafeDepositBox;
	static  Premier_NewCollateral premierNewCollateral;

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
		premierLinesNewLine = new Premier_LinesNewLine(driver);
		premierLoansNewNote = new Premier_LoansNewNote(driver);
		premierLoansChange = new Premier_LoansChangeAccount(driver);
		premierSafeDepositBox = new Premier_SafeDepositBox(driver);
		premierNewCollateral = new Premier_NewCollateral(driver);
		
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
		sEnvType = pr.readProperties(appConfigPropertyFilePath,"Env_Type");
		
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

			String sAccountNumber;
			switch(sTestCase.toUpperCase()){
			
			case "PREMIER_POC":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC002":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC003":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();

				break;
			case "PREMIER_TC004":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC005":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC006":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC007":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC008":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC009":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"Y");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC010":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String sChangeSSN = tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN");
				if (sChangeSSN.equals("")){
					new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");
					sChangeSSN = tc_Test_Data.get(iTDRow).get("Name_TaxIdentification");
				}else{
					premierHomeMenuPage.customerMenu();
					premierHomeMenuPage.goToNames();
				}

				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer("", sChangeSSN);
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

				new PremierCommonNavigation().customerInquiry("",  sChangeSSN,tc_Test_Data.get(iTDRow).get("ChangeName_Name"), tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_Email"),
						tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");


				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC011":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String strChangeSSN = tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN");
				if (strChangeSSN.equals("")){
					new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");
					strChangeSSN = tc_Test_Data.get(iTDRow).get("Name_TaxIdentification");
				}else{
					premierHomeMenuPage.customerMenu();
					premierHomeMenuPage.goToNames();
				}
				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer("",strChangeSSN);
				driver.switchTo().frame("Main");
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

				new PremierCommonNavigation().customerInquiry("",  strChangeSSN,tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("Name_LastName"), tc_Test_Data.get(iTDRow).get("ChangeContact_AddPhoneNumber"),tc_Test_Data.get(iTDRow).get("ChangeContact_AddEmail"),
						tc_Test_Data.get(iTDRow).get("Address_Address1"), tc_Test_Data.get(iTDRow).get("Address_Address2"), tc_Test_Data.get(iTDRow).get("Address_Zipcode"),"","");

				premierLogOff.logoffApplication();

				break;


			case "PREMIER_TC012":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String changeSSN = tc_Test_Data.get(iTDRow).get("ChangeName_SearchSSN");
				if (changeSSN.equals("")){
					new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");
					changeSSN = tc_Test_Data.get(iTDRow).get("Name_TaxIdentification");
				}else{
					premierHomeMenuPage.customerMenu();
					premierHomeMenuPage.goToNames();
				}
				premierHomeMenuPage.changeName();
				premierCustomerChangeName.searchCustomer("", changeSSN);
				driver.switchTo().frame("Main");
				//premierCustomerChangeName.updateNameDetails(tc_Test_Data.get(iTDRow).get("ChangeName_Name"),tc_Test_Data.get(iTDRow).get("ChangeName_LastName"));
				premierCustomerChangeName.goToContactMethodTab();
				premierCustomerChangeName.updateContactMethods(tc_Test_Data.get(iTDRow).get("ChangeContact_PhoneNumber"), tc_Test_Data.get(iTDRow).get("ChangeContact_Email"), tc_Test_Data.get(iTDRow).get("ChangeContact_WebAddress"));
				premierCustomerChangeName.goToRelationshipsTab();
				premierCustomerChangeName.deleteLastBeneficiary();
				premierCustomerChangeName.saveDetails();

				new PremierCommonNavigation().customerInquiry("", changeSSN,tc_Test_Data.get(iTDRow).get("Name_FirstName") +" "+ tc_Test_Data.get(iTDRow).get("Name_LastName"), "",	"",
						"", "","","","");

				premierLogOff.logoffApplication();

				break;	

			case "PREMIER_TC013":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);				
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");

				premierHomeMenuPage.portfolioMenu();
				premierHomeMenuPage.portfolioNew();
				Thread.sleep(6000);
				premierPortfolioNew.portfolioSearchCustomer(tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1"),1);
				if (!tc_Test_Data.get(iTDRow).get("Portfolio_Address1").equals("")) {
					premierPortfolioNew.portfolioSearchAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"));
				}
				premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
				premierPortfolioNew.portfolioNew_NameScreen(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship"),1);
				premierPortfolioNew.clickOnNextButton();
				premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierPortfolioNew.portfolioFinishButton();
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC015":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");

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
				break;

			case "PREMIER_TC016":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().customerCreationAndInquire(tc_Test_Data, iTDRow,"N");
				new PremierCommonNavigation().portfolioCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC017":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC018":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC019":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				new PremierCommonNavigation().portfolioCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC020":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					premierHomeMenuPage.portfolioMenu();
				}
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}			
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.newDemandDeposits();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
				String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}	
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);			
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"Y");				
				premierLogOff.logoffApplication();				
				break;

			case "PREMIER_TC024":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.demandDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),"","","","","","","","","");
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),"","","");
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;

			case "PREMIER_TC025":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				new PremierCommonNavigation().savingAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"Y");	
				premierLogOff.logoffApplication();				
				break;

			case "PREMIER_TC028":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().savingAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.savingsDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.savingsDepositsSubMenu();
				premierHomeMenuPage.changeAccountSavings();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"),"","","","","","");
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();

				break;

			case "PREMIER_TC029":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.certificatesDepositsSubMenu();
				premierHomeMenuPage.newAccountCertificates();
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
				premierDepositAccounts.depositFinishButton();

				premierHomeMenuPage.accountInquiryCertificates();
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.certificatesDepositsSubMenu();
				premierHomeMenuPage.newAccountCertificates();
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

				premierHomeMenuPage.accountInquiryCertificates();
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
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				new PremierCommonNavigation().certificateAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"Y");	
				premierLogOff.logoffApplication();				
				break;

			case "PREMIER_TC032":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().certificateAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.certificatesDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}

				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.certificatesDepositsSubMenu();
				premierHomeMenuPage.changeAccountCertificates();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),"","",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"),"","","","","","");
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryCertificates();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),"","",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;

			case "PREMIER_TC033":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectLinesMenu();
				premierHomeMenuPage.selectNewLine();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
					String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
					premierLinesNewLine.newLine_CustomerScreen(sLineName,sLineRelationship,sLineStatement,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierLinesNewLine.newLineAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Line_FinancialStatementNotify"),
						tc_Test_Data.get(iTDRow).get("Line_NextFinDate"),tc_Test_Data.get(iTDRow).get("Line_NextReviewDate"),
						tc_Test_Data.get(iTDRow).get("Line_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Line_MaximumCreditCode"),
						tc_Test_Data.get(iTDRow).get("Line_ResponsibiliytCode"));
				premierLinesNewLine.newLinesFinishButton();
				premierHomeMenuPage.selectLineInquiry();
				premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					premierLinesNewLine.validateDetailsInLineInquiry(tc_Test_Data.get(iTDRow).get("Portfolio_No"), sLineName);
				}
				premierLinesNewLine.closeScreen_Image();

				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.selectNewNote();
				premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
					String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
					premierLinesNewLine.newLine_CustomerScreen(sLineName,sLineRelationship,sLineStatement,i+1);
				}
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("Loan_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), tc_Test_Data.get(iTDRow).get("Loan_CashProceeds"), tc_Test_Data.get(iTDRow).get("Loan_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Loan_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("Loan_NoteDate"), tc_Test_Data.get(iTDRow).get("Loan_ContractDate"), tc_Test_Data.get(iTDRow).get("Loan_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("Loan_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("Loan_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("Loan_OriginalPaymentReserve"), tc_Test_Data.get(iTDRow).get("Loan_InternalPaymentOption"),tc_Test_Data.get(iTDRow).get("Loan_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("Loans_InterestMethod"), tc_Test_Data.get(iTDRow).get("Loans_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_PaymentFrequency"),tc_Test_Data.get(iTDRow).get("Loans_FirstInterestPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_InterestPaymentFrequency"), tc_Test_Data.get(iTDRow).get("Loans_PurposeCode"), tc_Test_Data.get(iTDRow).get("Loans_PaymentCode"), tc_Test_Data.get(iTDRow).get("Loans_ChargeAccount"),tc_Test_Data.get(iTDRow).get("Loans_Rate"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("Loans_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("Loans_TotalInterest"));
				premierLoansNewNote.newNoteLoan_InsuranceScreen(tc_Test_Data.get(iTDRow).get("Loans_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("Loans_Insurance_SimpleInsuranceBillingDay"));
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("Loan_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Number"),tc_Test_Data.get(iTDRow).get("Loan_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"));
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					premierLoansNewNote.validateDetailsInLoansInquiry(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), sLineName);
				}
				premierLinesNewLine.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;

			case "PREMIER_TC034":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectLinesMenu();
				premierHomeMenuPage.selectNewLine();
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
					String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
					premierLinesNewLine.newLine_CustomerScreen(sLineName,sLineRelationship,sLineStatement,i+1);
				}
				premierPortfolioNew.clickOnNextButton();
				premierLinesNewLine.newLineAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Line_FinancialStatementNotify"),
						tc_Test_Data.get(iTDRow).get("Line_NextFinDate"),tc_Test_Data.get(iTDRow).get("Line_NextReviewDate"),
						tc_Test_Data.get(iTDRow).get("Line_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Line_MaximumCreditCode"),
						tc_Test_Data.get(iTDRow).get("Line_ResponsibiliytCode"));
				premierLinesNewLine.newLinesFinishButton();
				premierHomeMenuPage.selectLineInquiry();
				premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					premierLinesNewLine.validateDetailsInLineInquiry(tc_Test_Data.get(iTDRow).get("Portfolio_No"), sLineName);
				}
				premierLinesNewLine.closeScreen_Image();

				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.selectNewNote();
				premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
					String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
					premierLinesNewLine.newLine_CustomerScreen(sLineName,sLineRelationship,sLineStatement,i+1);
				}
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("Loan_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), tc_Test_Data.get(iTDRow).get("Loan_CashProceeds"), tc_Test_Data.get(iTDRow).get("Loan_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Loan_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("Loan_NoteDate"), tc_Test_Data.get(iTDRow).get("Loan_ContractDate"), tc_Test_Data.get(iTDRow).get("Loan_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("Loan_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("Loan_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("Loan_OriginalPaymentReserve"), tc_Test_Data.get(iTDRow).get("Loan_InternalPaymentOption"),tc_Test_Data.get(iTDRow).get("Loan_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("Loans_InterestMethod"), tc_Test_Data.get(iTDRow).get("Loans_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_PaymentFrequency"),tc_Test_Data.get(iTDRow).get("Loans_FirstInterestPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_InterestPaymentFrequency"), tc_Test_Data.get(iTDRow).get("Loans_PurposeCode"), tc_Test_Data.get(iTDRow).get("Loans_PaymentCode"), tc_Test_Data.get(iTDRow).get("Loans_ChargeAccount"),tc_Test_Data.get(iTDRow).get("Loans_Rate"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("Loans_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("Loans_TotalInterest"));
				premierLoansNewNote.newNoteLoan_InsuranceScreen(tc_Test_Data.get(iTDRow).get("Loans_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("Loans_Insurance_SimpleInsuranceBillingDay"));
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("Loan_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Number"),tc_Test_Data.get(iTDRow).get("Loan_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"));
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
					premierLoansNewNote.validateDetailsInLoansInquiry(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), sLineName);
				}
				premierLinesNewLine.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC035":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"Y");	
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC036":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeLoanAccountDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateLoanAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC037":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeLoanAccountDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateLoanAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC038":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeLoanAccountDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateLoanAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC039":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeLoanAccountDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateLoanAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC040":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeLoanAccountDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateLoanAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_Class"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_BranchRegion"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Codes_AccountingMethod"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Warning"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentFrequency"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_StatusCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_WriteDownStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_Status_LoanRatingCode1"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentRestrictionCodeOverride"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyChapter"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyStatus"), tc_Test_Data.get(iTDRow).get("ChangeLoan_BankruptcyPetitionFileDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC041":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeAccountDetails_AddRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddName"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddSSN"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddEstatement"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountDetailsAfterChange_AddRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddName"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddSSN"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddRelationship"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_AddEstatement"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC042":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeAccountDetails_UpdateRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_Name"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_UpdateRelationship"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountDetailsAfterChange_UpdateRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_Name"), tc_Test_Data.get(iTDRow).get("ChangeRelationship_UpdateRelationship"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC043":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeAccountDetails_RemoveRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_RemoveName"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountDetailsAfterChange_RemoveRelationship(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeRelationship_RemoveName"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC044":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeLoan_NoteNumber");
				if(sAccountNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().loanCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");	
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Loan_NoteNumber");
					premierHomeMenuPage.selectLoansMenu();
				}
				premierHomeMenuPage.selectLoansMenu();
				premierHomeMenuPage.changeAccountLoans();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.changeAccountDetails_Balances(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualCode"),tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualLateChargeOption"),tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticRecoveryOverride"),tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountDetailsAfterChange_Balances(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualCode"),tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualLateChargeOption"),tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticRecoveryOverride"),tc_Test_Data.get(iTDRow).get("ChangeLoan_NonAccrualDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC046":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectCollateralMenu();
				premierHomeMenuPage.newCollateralSubMenu();
				premierNewCollateral.enterCollateralDefInitionPageDetail(tc_Test_Data.get(iTDRow).get("CollateralType"),tc_Test_Data.get(iTDRow).get("Collateral_BranchRegion"),tc_Test_Data.get(iTDRow).get("CollateralCode"));
				premierNewCollateral.enterCollateralCodePageDetail_RealEstate(tc_Test_Data.get(iTDRow).get("Collateral_ParcelID"),tc_Test_Data.get(iTDRow).get("Collateral_BuildingStatus"),tc_Test_Data.get(iTDRow).get("Collateral_PrimaryResidence"),tc_Test_Data.get(iTDRow).get("Collateral_CollateralValue"),tc_Test_Data.get(iTDRow).get("Collateral_PropertyType"),tc_Test_Data.get(iTDRow).get("Collateral_NumberOfUnits"),
						tc_Test_Data.get(iTDRow).get("Collateral_MarketValue"),tc_Test_Data.get(iTDRow).get("Collateral_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberValue"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberExpirationDate"),tc_Test_Data.get(iTDRow).get("Collateral_MarginPercent"),tc_Test_Data.get(iTDRow).get("Collateral_MarginAmount"));
				premierNewCollateral.enterCollateralRelationshipPageDetail(tc_Test_Data.get(iTDRow).get("Collateral_SearchSSN"),tc_Test_Data.get(iTDRow).get("Collateral_SSNRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAddress"),tc_Test_Data.get(iTDRow).get("Collateral_AddressRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountType"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountNumber"),tc_Test_Data.get(iTDRow).get("Collateral_AccountPledgeRule"));
				premierNewCollateral.finishCollateral(testdataFile_Path, sTestCase, iTDRow+1);
				break;
				
			case "PREMIER_TC047":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectCollateralMenu();
				premierHomeMenuPage.newCollateralSubMenu();
				premierNewCollateral.enterCollateralDefInitionPageDetail(tc_Test_Data.get(iTDRow).get("CollateralType"),tc_Test_Data.get(iTDRow).get("Collateral_BranchRegion"),tc_Test_Data.get(iTDRow).get("CollateralCode"));
				premierNewCollateral.enterCollateralCodePageDetail_LifeInsurance(tc_Test_Data.get(iTDRow).get("Collateral_PolicyDescription"),tc_Test_Data.get(iTDRow).get("Collateral_CashValue"),tc_Test_Data.get(iTDRow).get("Collateral_CollateralValue"),tc_Test_Data.get(iTDRow).get("Collateral_PolicyNumber"),tc_Test_Data.get(iTDRow).get("Collateral_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Collateral_FaceValue"),
						tc_Test_Data.get(iTDRow).get("Collateral_PolicyEffectiveDate"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberValue"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberExpirationDate"),tc_Test_Data.get(iTDRow).get("Collateral_MarginPercent"),tc_Test_Data.get(iTDRow).get("Collateral_MarginAmount"));
				premierNewCollateral.enterCollateralRelationshipPageDetail(tc_Test_Data.get(iTDRow).get("Collateral_SearchSSN"),tc_Test_Data.get(iTDRow).get("Collateral_SSNRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAddress"),tc_Test_Data.get(iTDRow).get("Collateral_AddressRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountType"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountNumber"),tc_Test_Data.get(iTDRow).get("Collateral_AccountPledgeRule"));
				premierNewCollateral.finishCollateral(testdataFile_Path, sTestCase, iTDRow+1);				
				break;
				
			case "PREMIER_TC048":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectCollateralMenu();
				premierHomeMenuPage.newCollateralSubMenu();
				premierNewCollateral.enterCollateralDefInitionPageDetail(tc_Test_Data.get(iTDRow).get("CollateralType"),tc_Test_Data.get(iTDRow).get("Collateral_BranchRegion"),tc_Test_Data.get(iTDRow).get("CollateralCode"));
				premierNewCollateral.enterCollateralCodePageDetail_Investment(tc_Test_Data.get(iTDRow).get("Collateral_NumberofShares"),tc_Test_Data.get(iTDRow).get("Collateral_AccountNumber"),tc_Test_Data.get(iTDRow).get("Collateral_Type"),tc_Test_Data.get(iTDRow).get("Collateral_CUSIP"),tc_Test_Data.get(iTDRow).get("Collateral_TickerSymbol"),tc_Test_Data.get(iTDRow).get("Collateral_FundName"),
						tc_Test_Data.get(iTDRow).get("Collateral_CollateralValue"),tc_Test_Data.get(iTDRow).get("Collateral_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberValue"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberExpirationDate"),tc_Test_Data.get(iTDRow).get("Collateral_MarginPercent"),tc_Test_Data.get(iTDRow).get("Collateral_MarginAmount"));
				premierNewCollateral.enterCollateralRelationshipPageDetail(tc_Test_Data.get(iTDRow).get("Collateral_SearchSSN"),tc_Test_Data.get(iTDRow).get("Collateral_SSNRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAddress"),tc_Test_Data.get(iTDRow).get("Collateral_AddressRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountType"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountNumber"),tc_Test_Data.get(iTDRow).get("Collateral_AccountPledgeRule"));
				premierNewCollateral.finishCollateral(testdataFile_Path, sTestCase, iTDRow+1);				
				break;
				
			case "PREMIER_TC049":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectCollateralMenu();
				premierHomeMenuPage.newCollateralSubMenu();
				premierNewCollateral.enterCollateralDefInitionPageDetail(tc_Test_Data.get(iTDRow).get("CollateralType"),tc_Test_Data.get(iTDRow).get("Collateral_BranchRegion"),tc_Test_Data.get(iTDRow).get("CollateralCode"));
				premierNewCollateral.enterCollateralCodePageDetail_Basic(tc_Test_Data.get(iTDRow).get("Collateral_Description"),tc_Test_Data.get(iTDRow).get("Collateral_CollateralIdentification"),tc_Test_Data.get(iTDRow).get("Collateral_DateLastStatusChange"),tc_Test_Data.get(iTDRow).get("Collateral_CollateralStatus"),tc_Test_Data.get(iTDRow).get("Collateral_PurchasePrice"),tc_Test_Data.get(iTDRow).get("Collateral_NumberOfUnits"),
						tc_Test_Data.get(iTDRow).get("Collateral_CollateralValue"),tc_Test_Data.get(iTDRow).get("Collateral_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberValue"),tc_Test_Data.get(iTDRow).get("Collateral_AdditionalInfoParcelNumberExpirationDate"),tc_Test_Data.get(iTDRow).get("Collateral_MarginPercent"),tc_Test_Data.get(iTDRow).get("Collateral_MarginAmount"));
				premierNewCollateral.enterCollateralRelationshipPageDetail(tc_Test_Data.get(iTDRow).get("Collateral_SearchSSN"),tc_Test_Data.get(iTDRow).get("Collateral_SSNRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAddress"),tc_Test_Data.get(iTDRow).get("Collateral_AddressRelationship"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountType"),tc_Test_Data.get(iTDRow).get("Collateral_SearchAccountNumber"),tc_Test_Data.get(iTDRow).get("Collateral_AccountPledgeRule"));
				premierNewCollateral.finishCollateral(testdataFile_Path, sTestCase, iTDRow+1);			
				break;
				
			case "PREMIER_TC050":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.goToSafeDepositBox();
				premierHomeMenuPage.goToNewAccountSafeDepositBox();
				
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				
				String portfolioCustName  = tc_Test_Data.get(iTDRow).get("SDB_Name");
				String[] portfolioCustName_Split = portfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = portfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
					sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
					
					
					premierSafeDepositBox.newSDBAccount_CustomerScreen(sName,sSDBRelationship,i+1);
				}
				premierSafeDepositBox.newSDB_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("SDB_Product"));
				//premierSafeDepositBox.clickOnNext();
				premierSafeDepositBox.newSDBAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),
						tc_Test_Data.get(iTDRow).get("SDB_RentCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierSafeDepositBox.newSDBAccount_PaymentScreen(tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"),
						tc_Test_Data.get(iTDRow).get("SDB_ChargeAccount"),tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),
						tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),testdataFile_Path, sTestCase, iTDRow+1);
				premierSafeDepositBox.sdbFinishButton();

				premierHomeMenuPage.accountInquirySDB();
				premierSafeDepositBox.searchAccount(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"));	

				portfolioCustName  = tc_Test_Data.get(iTDRow).get("SDB_Name");
				portfolioCustName_Split = portfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = portfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
					sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
					//new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy");
					premierSafeDepositBox.validateAccountDetails(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),sName,
							sSDBRelationship,new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy"),
							tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"));
				}
				premierSafeDepositBox.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			
			case "PREMIER_TC051":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);

				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}			
				premierHomeMenuPage.goToSafeDepositBox();
				premierHomeMenuPage.goToNewAccountSafeDepositBox();
				
				premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
				
				String busPortfolioCustName  = tc_Test_Data.get(iTDRow).get("SDB_Name");
				String[] busPortfolioCustName_Split = busPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = busPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
					sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
					
					
					premierSafeDepositBox.newSDBAccount_CustomerScreen(sName,sSDBRelationship,i+1);
				}
				premierSafeDepositBox.newSDB_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("SDB_Product"));
				//premierSafeDepositBox.clickOnNext();
				premierSafeDepositBox.newSDBAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),
						tc_Test_Data.get(iTDRow).get("SDB_RentCode"),testdataFile_Path, sTestCase, iTDRow+1);
				premierSafeDepositBox.newSDBAccount_PaymentScreen(tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"),
						tc_Test_Data.get(iTDRow).get("SDB_ChargeAccount"),tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),
						tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),testdataFile_Path, sTestCase, iTDRow+1);
				premierSafeDepositBox.sdbFinishButton();

				premierHomeMenuPage.accountInquirySDB();
				premierSafeDepositBox.searchAccount(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"));	

				busPortfolioCustName  = tc_Test_Data.get(iTDRow).get("SDB_Name");
				busPortfolioCustName_Split = busPortfolioCustName.split("\\|\\|"); 
				iPortfolioCustomerCount = busPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
					sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
					sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
					//new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy");
					premierSafeDepositBox.validateAccountDetails(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),sName,
							sSDBRelationship,new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy"),
							tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"));
				}
				premierSafeDepositBox.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
			
			case "PREMIER_TC052":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);			
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				new PremierCommonNavigation().safeDepositBoxCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"Y");				
				premierLogOff.logoffApplication();				
				break;
							
			case "PREMIER_TC053":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String sAccountNumberUpdate = tc_Test_Data.get(iTDRow).get("ChangeSDB_AccountNumber");
				if(sAccountNumberUpdate.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().safeDepositBoxCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumberUpdate = tc_Test_Data.get(iTDRow).get("SDB_AccountNumber");
					premierHomeMenuPage.goToSafeDepositBox();
					
				}
				premierHomeMenuPage.goToSafeDepositBox();
				premierHomeMenuPage.goToChangeSDBAccount();
				premierSafeDepositBox.searchAccount(sAccountNumberUpdate);	
				premierSafeDepositBox.changeAccountCodesDetails(sAccountNumberUpdate, tc_Test_Data.get(iTDRow).get("ChangeSDB_CurrentRentDue"), 
						tc_Test_Data.get(iTDRow).get("ChangeSDB_LastBillingDate"), tc_Test_Data.get(iTDRow).get("ChangeSDB_BillingFrequency"),
						tc_Test_Data.get(iTDRow).get("ChangeSDB_BillingMethod"), tc_Test_Data.get(iTDRow).get("ChangeSDB_ChargeAccountNumber"), 
						"","");
				premierSafeDepositBox.saveButton();
				
				premierHomeMenuPage.accountInquirySDB();
				premierSafeDepositBox.searchAccount(sAccountNumberUpdate);
				premierSafeDepositBox.validateAccountBalancesAfterChange(sAccountNumberUpdate,tc_Test_Data.get(iTDRow).get("ChangeSDB_CurrentRentDue"),new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeSDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy"),tc_Test_Data.get(iTDRow).get("ChangeSDB_BillingFrequency"),tc_Test_Data.get(iTDRow).get("ChangeSDB_BillingMethod"));
				premierSafeDepositBox.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC054":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String sAccntNumberUpdate = tc_Test_Data.get(iTDRow).get("ChangeSDB_AccountNumber");
				if(sAccntNumberUpdate.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().safeDepositBoxCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccntNumberUpdate = tc_Test_Data.get(iTDRow).get("SDB_AccountNumber");
					premierHomeMenuPage.goToSafeDepositBox();
					
				}
				premierHomeMenuPage.goToSafeDepositBox();
				premierHomeMenuPage.goToChangeSDBAccount();
				premierSafeDepositBox.searchAccount(sAccntNumberUpdate);	
				premierSafeDepositBox.changeAccountCodesDetails(sAccntNumberUpdate, "","","","","",tc_Test_Data.get(iTDRow).get("ChangeSDB_BoxRentCode"),"");
				premierSafeDepositBox.saveButton();
				
				premierHomeMenuPage.accountInquirySDB();
				premierSafeDepositBox.searchAccount(sAccntNumberUpdate);
				premierSafeDepositBox.validateAccountCodesAfterChange(sAccntNumberUpdate,"",tc_Test_Data.get(iTDRow).get("ChangeSDB_BoxRentCode"));
				premierSafeDepositBox.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC055":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				String sAccntNumUpdate = tc_Test_Data.get(iTDRow).get("ChangeSDB_AccountNumber");
				if(sAccntNumUpdate.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().safeDepositBoxCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccntNumUpdate = tc_Test_Data.get(iTDRow).get("SDB_AccountNumber");
					premierHomeMenuPage.goToSafeDepositBox();
					
				}
				premierHomeMenuPage.goToSafeDepositBox();
				premierHomeMenuPage.goToChangeSDBAccount();
				premierSafeDepositBox.searchAccount(sAccntNumUpdate);	
				premierSafeDepositBox.changeAccountCodesDetails(sAccntNumUpdate, "","","","","","",tc_Test_Data.get(iTDRow).get("ChangeSDB_EscheatDate"));
				premierSafeDepositBox.saveButton();
				
				premierHomeMenuPage.accountInquirySDB();
				premierSafeDepositBox.searchAccount(sAccntNumUpdate);
				premierSafeDepositBox.validateAccountCodesAfterChange(sAccntNumUpdate,
						new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeSDB_EscheatDate"),"MM/dd/yyyy","MMM dd, yyyy"),"");
				premierSafeDepositBox.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC060":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data, iTDRow,testdataFile_Path,sTestCase,"N");
					}
					new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.demandDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountHold(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldReason"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldAmount"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldExpirationDate"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldAccountPledgedOnLoan"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldPledgedNoteNum"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldMaxPledge"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldDate"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldPendingStartDate"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldPendingAmount"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldAmountOption"));
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountHoldDetailsAfterChange(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldAmount"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldReason"),new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldExpirationDate"),"MM/dd/yyyy","MMM dd, yyyy"),
						new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldDate"),"MM/dd/yyyy","MMM dd, yyyy"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_HoldPendingAmount"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
			
			
			
			case "PREMIER_TC065":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.demandDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,"",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransactionRestrictionCode"),"","","","","","","");
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,"",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransactionRestrictionCode"),"");
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC066":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.demandDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,"","","","","","","",tc_Test_Data.get(iTDRow).get("ChangeDeposit_SuspendedStatementCycle")
						,tc_Test_Data.get(iTDRow).get("ChangeDeposit_SuspendedInterest"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_SuspendedDepositRateIndex"));
				premierDepositAccounts.saveButton();
				/*premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_warning"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransactionRestrictionCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();*/
				premierLogOff.logoffApplication();				
				break;

				
			case "PREMIER_TC067":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAccountNumber = tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountNumber");
				if(sAccountNumber.equals("")) {					
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {						
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().demandDepositAccountCreationAndInquire(tc_Test_Data, iTDRow,sTestCase,"N");
					sAccountNumber = tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber");
					premierHomeMenuPage.demandDepositsSubMenu();
					premierHomeMenuPage.depositsMenu();
				}
				premierHomeMenuPage.depositsMenu();
				premierHomeMenuPage.demandDepositsSubMenu();
				premierHomeMenuPage.changeAccountDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);	
				premierDepositAccounts.changeAccountCodeDetails(sAccountNumber,"","","",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"),
						tc_Test_Data.get(iTDRow).get("ChangeDeposit_AlternateCycleOption"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_AlternateCycle")
						,tc_Test_Data.get(iTDRow).get("ChangeDeposit_NotificationOption"),"","","");
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange(sAccountNumber,"","","",tc_Test_Data.get(iTDRow).get("ChangeDeposit_StatementCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;

			}
			
			
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}
