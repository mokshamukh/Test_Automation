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
import testframe.application.premier.pages.Premier_MasterAgreement;
import testframe.application.premier.pages.Premier_Modeling;
import testframe.application.premier.pages.Premier_NewCollateral;
import testframe.application.premier.pages.Premier_NewSweeps;
import testframe.application.premier.pages.Premier_PortfolioNew;
import testframe.application.premier.pages.Premier_SafeDepositBox;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;
import testframe.common.utilities.ExcelReader;

public class PremierTestSet2 extends ApplicationBase {
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
	static  Premier_MasterAgreement premierMasterAgreement;
	static  Premier_NewSweeps premierNewSweeps;
	static  Premier_Modeling premierModeling;
	
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
		premierMasterAgreement = new Premier_MasterAgreement(driver);
		premierNewSweeps = new Premier_NewSweeps(driver);
		premierModeling = new Premier_Modeling (driver);
		
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
			System.setProperty("runStep","Y");
			fi.createFile(sHTMLFilePath);
			fi.checkAndCreateFolder(sScreenShotFolder);
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);

			new HTMLReportHelper().HTMLReportHeader("Premier", sTestCase, sTestDescription);

			String sAccountNumber,sLoanAccountNumber,sCollateralRecordNumber,sAgreementNumber;
			switch(sTestCase.toUpperCase()){

			case "PREMIER_TC081":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAgreementNumber = tc_Test_Data.get(iTDRow).get("Existing_MasterAgreement");
				if(sAgreementNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().lineCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					new PremierCommonNavigation().agreementCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					sAgreementNumber = tc_Test_Data.get(iTDRow).get("Agreement_NoteNumber");
					premierHomeMenuPage.selectMasterAgreementsMenu();
				}
				premierHomeMenuPage.selectMasterAgreementsMenu();
				premierHomeMenuPage.selectNewLineOfCredit();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				/*strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
		        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
		        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
		             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
		             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
		             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
		         }*/
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("LineOfCredit_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("LineOfCredit_NoteNumber"), tc_Test_Data.get(iTDRow).get("LineOfCredit_CashProceeds"), tc_Test_Data.get(iTDRow).get("LineOfCredit_MaximumCredit"),tc_Test_Data.get(iTDRow).get("LineOfCredit_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("LineOfCredit_NoteDate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_ContractDate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("LineOfCredit_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("LineOfCredit_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("LineOfCredit_OriginalPaymentReserve"), "",tc_Test_Data.get(iTDRow).get("LineOfCredit_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("LineOfCredit_InterestMethod"), tc_Test_Data.get(iTDRow).get("LineOfCredit_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_PaymentFrequency"),"", "", tc_Test_Data.get(iTDRow).get("LineOfCredit_PurposeCode"), tc_Test_Data.get(iTDRow).get("LineOfCredit_PaymentCode"), tc_Test_Data.get(iTDRow).get("LineOfCredit_ChargeAccount"),tc_Test_Data.get(iTDRow).get("LineOfCredit_Rate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("LineOfCredit_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("LineOfCredit_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("LineOfCredit_TotalInterest"));
				premierMasterAgreement.newAgreement_InsuranceScreen(tc_Test_Data.get(iTDRow).get("LineOfCredit_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("LineOfCredit_Insurance_SimpleInsuranceBillingDay"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_StartDate"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_Code"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_Company"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_Method"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_Rate"),tc_Test_Data.get(iTDRow).get("LineOfCredit_SimpleInsurance1_Amount"));
				premierMasterAgreement.unUsedCreditScreen();
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_Number"),tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("LineOfCredit_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				
				premierHomeMenuPage.masterAgreementInquire();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				premierMasterAgreement.validateDetailsInMasterAgreementInquiry(sAgreementNumber,"Line Of Credit",tc_Test_Data.get(iTDRow).get("LineOfCredit_NoteNumber"));
				premierLinesNewLine.closeScreen_Image();
				
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC082":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAgreementNumber = tc_Test_Data.get(iTDRow).get("Existing_MasterAgreement");
				if(sAgreementNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().lineCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					new PremierCommonNavigation().agreementCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					sAgreementNumber = tc_Test_Data.get(iTDRow).get("Agreement_NoteNumber");
					premierHomeMenuPage.selectMasterAgreementsMenu();
				}
				premierHomeMenuPage.selectMasterAgreementsMenu();
				premierHomeMenuPage.selectNewLetterOfCredit();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				/*strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
		        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
		        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
		             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
		             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
		             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
		         }*/
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("LetterOfCredit_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("LetterOfCredit_NoteNumber"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_CashProceeds"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_MaximumCredit"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_NoteDate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_ContractDate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_OriginalPaymentReserve"), "",tc_Test_Data.get(iTDRow).get("LetterOfCredit_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("LetterOfCredit_InterestMethod"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_PaymentFrequency"),"", "", tc_Test_Data.get(iTDRow).get("LetterOfCredit_PurposeCode"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_PaymentCode"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_ChargeAccount"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_Rate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_TotalInterest"));
				premierMasterAgreement.newAgreement_InsuranceScreen(tc_Test_Data.get(iTDRow).get("LetterOfCredit_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_Insurance_SimpleInsuranceBillingDay"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_StartDate"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_Code"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_Company"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_Method"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_Rate"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_SimpleInsurance1_Amount"));
				premierMasterAgreement.unUsedCreditScreen();
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_Number"),tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("LetterOfCredit_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				
				premierHomeMenuPage.masterAgreementInquire();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				premierMasterAgreement.validateDetailsInMasterAgreementInquiry(sAgreementNumber,"Letter Of Credit",tc_Test_Data.get(iTDRow).get("LetterOfCredit_NoteNumber"));
				premierLinesNewLine.closeScreen_Image();
				
				premierLogOff.logoffApplication();
				break;
			
			case "PREMIER_TC083":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAgreementNumber = tc_Test_Data.get(iTDRow).get("Existing_MasterAgreement");
				if(sAgreementNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().lineCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					new PremierCommonNavigation().agreementCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					sAgreementNumber = tc_Test_Data.get(iTDRow).get("Agreement_NoteNumber");
					premierHomeMenuPage.selectMasterAgreementsMenu();
				}
				premierHomeMenuPage.selectMasterAgreementsMenu();
				premierHomeMenuPage.selectNewSubLoan();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				/*strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
		        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
		        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
		             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
		             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
		             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
		         }*/
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("SubLoan_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("SubLoan_NoteNumber"), tc_Test_Data.get(iTDRow).get("SubLoan_CashProceeds"), tc_Test_Data.get(iTDRow).get("SubLoan_MaximumCredit"),tc_Test_Data.get(iTDRow).get("SubLoan_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("SubLoan_NoteDate"), tc_Test_Data.get(iTDRow).get("SubLoan_ContractDate"), tc_Test_Data.get(iTDRow).get("SubLoan_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("SubLoan_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("SubLoan_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("SubLoan_OriginalPaymentReserve"), "",tc_Test_Data.get(iTDRow).get("SubLoan_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("SubLoan_InterestMethod"), tc_Test_Data.get(iTDRow).get("SubLoan_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("SubLoan_PaymentFrequency"),"", "", tc_Test_Data.get(iTDRow).get("SubLoan_PurposeCode"), tc_Test_Data.get(iTDRow).get("SubLoan_PaymentCode"), tc_Test_Data.get(iTDRow).get("SubLoan_ChargeAccount"),tc_Test_Data.get(iTDRow).get("SubLoan_Rate"), tc_Test_Data.get(iTDRow).get("SubLoan_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("SubLoan_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("SubLoan_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("SubLoan_TotalInterest"));
				premierMasterAgreement.newAgreement_InsuranceScreen(tc_Test_Data.get(iTDRow).get("SubLoan_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("SubLoan_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("SubLoan_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("SubLoan_Insurance_SimpleInsuranceBillingDay"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_StartDate"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_Code"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_Company"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_Method"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_Rate"),tc_Test_Data.get(iTDRow).get("SubLoan_SimpleInsurance1_Amount"));
				premierMasterAgreement.unUsedCreditScreen();
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_Number"),tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("SubLoan_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				
				premierHomeMenuPage.masterAgreementInquire();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				premierMasterAgreement.validateDetailsInMasterAgreementInquiry(sAgreementNumber,"Sub Loan",tc_Test_Data.get(iTDRow).get("SubLoan_NoteNumber"));	
				premierLinesNewLine.closeScreen_Image();
				
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC084":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				sAgreementNumber = tc_Test_Data.get(iTDRow).get("Existing_MasterAgreement");
				if(sAgreementNumber.equals("")) {
					if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
						new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
						tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
					}
					new PremierCommonNavigation().lineCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					new PremierCommonNavigation().agreementCreationAndInquire(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					sAgreementNumber = tc_Test_Data.get(iTDRow).get("Agreement_NoteNumber");
					premierHomeMenuPage.selectMasterAgreementsMenu();
				}
				premierHomeMenuPage.selectMasterAgreementsMenu();
				premierHomeMenuPage.selectMasterMortgage();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				/*strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
				strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
				iPortfolioCustomerCount = strPortfolioCustName_Split.length;
				for (int i = 0; i<iPortfolioCustomerCount;i++) {
		        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
		        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
		             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
		             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
		             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
		         }*/
				premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("MasterMortgage_Product"));
				premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("MasterMortgage_NoteNumber"), tc_Test_Data.get(iTDRow).get("MasterMortgage_CashProceeds"), tc_Test_Data.get(iTDRow).get("MasterMortgage_MaximumCredit"),tc_Test_Data.get(iTDRow).get("MasterMortgage_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("MasterMortgage_NoteDate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_ContractDate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("MasterMortgage_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("MasterMortgage_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("MasterMortgage_OriginalPaymentReserve"), "",tc_Test_Data.get(iTDRow).get("MasterMortgage_ResponsibilityCode"));
				premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("MasterMortgage_InterestMethod"), tc_Test_Data.get(iTDRow).get("MasterMortgage_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_PaymentFrequency"),"", "", tc_Test_Data.get(iTDRow).get("MasterMortgage_PurposeCode"), tc_Test_Data.get(iTDRow).get("MasterMortgage_PaymentCode"), tc_Test_Data.get(iTDRow).get("MasterMortgage_ChargeAccount"),tc_Test_Data.get(iTDRow).get("MasterMortgage_Rate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("MasterMortgage_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("MasterMortgage_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("MasterMortgage_TotalInterest"));
				premierMasterAgreement.newAgreement_InsuranceScreen(tc_Test_Data.get(iTDRow).get("MasterMortgage_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("MasterMortgage_Insurance_SimpleInsuranceBillingDay"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_StartDate"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_Code"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_Company"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_Method"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_Rate"),tc_Test_Data.get(iTDRow).get("MasterMortgage_SimpleInsurance1_Amount"));
				premierMasterAgreement.unUsedCreditScreen();
				premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_Number"),tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("MasterMortgage_Schedule_OtherEscrow"));
				premierLoansNewNote.loanFinishButton();
				
				premierHomeMenuPage.masterAgreementInquire();
				premierMasterAgreement.searchAgreement(sAgreementNumber);
				premierMasterAgreement.validateDetailsInMasterAgreementInquiry(sAgreementNumber,"Master Mortgage",tc_Test_Data.get(iTDRow).get("MasterMortgage_NoteNumber"));
				premierLinesNewLine.closeScreen_Image();			
				premierLogOff.logoffApplication();
				break;
			
			case "PREMIER_TC085":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectSweeps();
				premierHomeMenuPage.selectNewSweep();
				premierNewSweeps.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				premierNewSweeps.newSweep_SelectAccount(tc_Test_Data.get(iTDRow).get("Sweep_NickName"),tc_Test_Data.get(iTDRow).get("Sweep_Frequency"),testdataFile_Path, sTestCase, iTDRow+1);
				premierNewSweeps.newSweep_FundingAccount(tc_Test_Data.get(iTDRow).get("Sweep_DDAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountNumber"));
				premierNewSweeps.newSweep_SweepFlow();
				premierNewSweeps.newSweep_CodesScreen(tc_Test_Data.get(iTDRow).get("FromAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("FromAccount_MaximumBalance"),tc_Test_Data.get(iTDRow).get("ToAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("ToAccount_MaximumBalance"),tc_Test_Data.get(iTDRow).get("SweepMinimumBalance_From"),
						tc_Test_Data.get(iTDRow).get("BalanceType_From"),tc_Test_Data.get(iTDRow).get("Increment_From"),tc_Test_Data.get(iTDRow).get("TargetBalance_From"),tc_Test_Data.get(iTDRow).get("ChargeCode_From"),tc_Test_Data.get(iTDRow).get("NotificationOption_From"),tc_Test_Data.get(iTDRow).get("SweepFrequency_From"),tc_Test_Data.get(iTDRow).get("SweepFromTransferOption_From")
						,tc_Test_Data.get(iTDRow).get("SweepMaximumBalance_To"),tc_Test_Data.get(iTDRow).get("BalanceType_To"),tc_Test_Data.get(iTDRow).get("Increment_To"),tc_Test_Data.get(iTDRow).get("ChargeCode_To"),tc_Test_Data.get(iTDRow).get("NotificationOption_To"),tc_Test_Data.get(iTDRow).get("SweepFrequency_To"));
				premierNewSweeps.sweepFinishButton();
				
				tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				premierHomeMenuPage.sweepInquire();			
				premierNewSweeps.searchSweep(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"));
				premierNewSweeps.validateDetailsInSweepInquiry(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"));
				premierNewSweeps.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
			
			case "PREMIER_TC086":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectSweeps();
				premierHomeMenuPage.selectNewSweep();
				premierNewSweeps.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				premierNewSweeps.newSweep_SelectAccount(tc_Test_Data.get(iTDRow).get("Sweep_NickName"),tc_Test_Data.get(iTDRow).get("Sweep_Frequency"),testdataFile_Path, sTestCase, iTDRow+1);
				premierNewSweeps.newSweep_FundingAccount(tc_Test_Data.get(iTDRow).get("Sweep_DDAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountNumber"));
				premierNewSweeps.newSweep_SweepFlow();
				premierNewSweeps.newSweep_CodesScreen(tc_Test_Data.get(iTDRow).get("FromAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("FromAccount_MaximumBalance"),tc_Test_Data.get(iTDRow).get("ToAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("ToAccount_MaximumBalance"),tc_Test_Data.get(iTDRow).get("SweepMinimumBalance_From"),
						tc_Test_Data.get(iTDRow).get("BalanceType_From"),tc_Test_Data.get(iTDRow).get("Increment_From"),tc_Test_Data.get(iTDRow).get("TargetBalance_From"),tc_Test_Data.get(iTDRow).get("ChargeCode_From"),tc_Test_Data.get(iTDRow).get("NotificationOption_From"),tc_Test_Data.get(iTDRow).get("SweepFrequency_From"),tc_Test_Data.get(iTDRow).get("SweepFromTransferOption_From")
						,tc_Test_Data.get(iTDRow).get("SweepMaximumBalance_To"),tc_Test_Data.get(iTDRow).get("BalanceType_To"),tc_Test_Data.get(iTDRow).get("Increment_To"),tc_Test_Data.get(iTDRow).get("ChargeCode_To"),tc_Test_Data.get(iTDRow).get("NotificationOption_To"),tc_Test_Data.get(iTDRow).get("SweepFrequency_To"));
				premierNewSweeps.sweepFinishButton();
				
				tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				premierHomeMenuPage.sweepInquire();			
				premierNewSweeps.searchSweep(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"));
				premierNewSweeps.validateDetailsInSweepInquiry(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"));
				premierNewSweeps.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC087":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectSweeps();
				premierHomeMenuPage.selectNewSweep();
				premierNewSweeps.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				premierNewSweeps.newSweep_SelectAccount(tc_Test_Data.get(iTDRow).get("Sweep_NickName"),tc_Test_Data.get(iTDRow).get("Sweep_Frequency"),testdataFile_Path, sTestCase, iTDRow+1);
				premierNewSweeps.newSweep_FundingAccount(tc_Test_Data.get(iTDRow).get("Sweep_DDAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountNumber"));
				premierNewSweeps.newSweep_SweepFlow();
				premierNewSweeps.newSweep_CodesScreen(tc_Test_Data.get(iTDRow).get("FromAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("FromAccount_MaximumBalance"),"","",tc_Test_Data.get(iTDRow).get("SweepMinimumBalance_From"),
						tc_Test_Data.get(iTDRow).get("BalanceType_From"),tc_Test_Data.get(iTDRow).get("Increment_From"),tc_Test_Data.get(iTDRow).get("TargetBalance_From"),tc_Test_Data.get(iTDRow).get("ChargeCode_From"),tc_Test_Data.get(iTDRow).get("NotificationOption_From"),tc_Test_Data.get(iTDRow).get("SweepFrequency_From"),tc_Test_Data.get(iTDRow).get("SweepFromTransferOption_From")
						,tc_Test_Data.get(iTDRow).get("SweepMaximumBalance_To"),tc_Test_Data.get(iTDRow).get("BalanceType_To"),tc_Test_Data.get(iTDRow).get("Increment_To"),tc_Test_Data.get(iTDRow).get("ChargeCode_To"),tc_Test_Data.get(iTDRow).get("NotificationOption_To"),tc_Test_Data.get(iTDRow).get("SweepFrequency_To"));
				premierNewSweeps.sweepFinishButton();
				
				tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				premierHomeMenuPage.sweepInquire();			
				premierNewSweeps.searchSweep(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"));
				premierNewSweeps.validateDetailsInSweepInquiry(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"));
				premierNewSweeps.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC088":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				
				if((tc_Test_Data.get(iTDRow).get("Portfolio_No")).equals("")) {
					new PremierCommonNavigation().portfolioCreationWithCustomer(tc_Test_Data,iTDRow,testdataFile_Path,sTestCase,"N");
					tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				}
				premierHomeMenuPage.selectSweeps();
				premierHomeMenuPage.selectNewSweep();
				premierNewSweeps.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
				premierNewSweeps.newSweep_SelectAccount(tc_Test_Data.get(iTDRow).get("Sweep_NickName"),tc_Test_Data.get(iTDRow).get("Sweep_Frequency"),testdataFile_Path, sTestCase, iTDRow+1);
				premierNewSweeps.newSweep_FundingAccount(tc_Test_Data.get(iTDRow).get("Sweep_DDAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepFromAccountNumber"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountType"),tc_Test_Data.get(iTDRow).get("Sweep_SweepToAccountNumber"));
				premierNewSweeps.newSweep_SweepFlow();
				premierNewSweeps.newSweep_CodesScreen(tc_Test_Data.get(iTDRow).get("FromAccount_MinimumBalance"),tc_Test_Data.get(iTDRow).get("FromAccount_MaximumBalance"),"","",tc_Test_Data.get(iTDRow).get("SweepMinimumBalance_From"),
						tc_Test_Data.get(iTDRow).get("BalanceType_From"),tc_Test_Data.get(iTDRow).get("Increment_From"),tc_Test_Data.get(iTDRow).get("TargetBalance_From"),tc_Test_Data.get(iTDRow).get("ChargeCode_From"),tc_Test_Data.get(iTDRow).get("NotificationOption_From"),tc_Test_Data.get(iTDRow).get("SweepFrequency_From"),tc_Test_Data.get(iTDRow).get("SweepFromTransferOption_From")
						,tc_Test_Data.get(iTDRow).get("SweepMaximumBalance_To"),tc_Test_Data.get(iTDRow).get("BalanceType_To"),tc_Test_Data.get(iTDRow).get("Increment_To"),tc_Test_Data.get(iTDRow).get("ChargeCode_To"),tc_Test_Data.get(iTDRow).get("NotificationOption_To"),tc_Test_Data.get(iTDRow).get("SweepFrequency_To"));
				premierNewSweeps.sweepFinishButton();
				
				tc_Test_Data = er.getData(testdataFile_Path,sTestCase);
				premierHomeMenuPage.sweepInquire();			
				premierNewSweeps.searchSweep(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"));
				premierNewSweeps.validateDetailsInSweepInquiry(tc_Test_Data.get(iTDRow).get("Sweep_RelationshipNumber"),tc_Test_Data.get(iTDRow).get("Sweep_DDAccountNumber"));
				premierNewSweeps.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC089":
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
				premierLoansChange.changeAccountDetails_Payments(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticPaymentOption"), tc_Test_Data.get(iTDRow).get("ChangeLoan_ChargeAccount"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticDraftAmount"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticDraftPaymentOption"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutoDraftPaymentDate"));
				//premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountDetailsAfterChange_Payments(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticPaymentOption"), tc_Test_Data.get(iTDRow).get("ChangeLoan_ChargeAccount"), tc_Test_Data.get(iTDRow).get("ChangeLoan_PaymentCode"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticDraftAmount"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutomaticDraftPaymentOption"), tc_Test_Data.get(iTDRow).get("ChangeLoan_AutoDraftPaymentDate"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC090":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.noteCalculator_Modeling();
				premierModeling.selectLoanProduct(tc_Test_Data.get(iTDRow).get("LoanProduct_Description"),tc_Test_Data.get(iTDRow).get("LoanProduct_Number"));
				premierModeling.selectNoteModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("UseSplitRates"),tc_Test_Data.get(iTDRow).get("IncludeFees"),tc_Test_Data.get(iTDRow).get("IncludeEscrow"),tc_Test_Data.get(iTDRow).get("IncludeInsurance"),tc_Test_Data.get(iTDRow).get("IncludeSimpleInsurance"),tc_Test_Data.get(iTDRow).get("IncludeDealerInterest"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.noteModelPage("", tc_Test_Data.get(iTDRow).get("PrincipalAdvance"), tc_Test_Data.get(iTDRow).get("InterestRateOverSplit"), 
						tc_Test_Data.get(iTDRow).get("SplitRateAmount"), tc_Test_Data.get(iTDRow).get("InterestRateUnderSplit"), tc_Test_Data.get(iTDRow).get("ExpensesFinanced"), 
						tc_Test_Data.get(iTDRow).get("TotalInsurance"), tc_Test_Data.get(iTDRow).get("FeesFinanced"), tc_Test_Data.get(iTDRow).get("FeesPrepaid"), 
						tc_Test_Data.get(iTDRow).get("FeesCharged"), "", tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"),"","");
				premierModeling.verifyNoteModelStatement(tc_Test_Data.get(iTDRow).get("PrincipalAdvance"),tc_Test_Data.get(iTDRow).get("PaymentNumber"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC091":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.noteCalculator_Modeling();
				premierModeling.selectLoanProduct(tc_Test_Data.get(iTDRow).get("LoanProduct_Description"),tc_Test_Data.get(iTDRow).get("LoanProduct_Number"));
				premierModeling.selectNoteModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("UseSplitRates"),tc_Test_Data.get(iTDRow).get("IncludeFees"),tc_Test_Data.get(iTDRow).get("IncludeEscrow"),tc_Test_Data.get(iTDRow).get("IncludeInsurance"),tc_Test_Data.get(iTDRow).get("IncludeSimpleInsurance"),tc_Test_Data.get(iTDRow).get("IncludeDealerInterest"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.noteModelPage(tc_Test_Data.get(iTDRow).get("NoteDate"), tc_Test_Data.get(iTDRow).get("PrincipalAdvance"), tc_Test_Data.get(iTDRow).get("InterestRateOverSplit"), 
						tc_Test_Data.get(iTDRow).get("SplitRateAmount"), tc_Test_Data.get(iTDRow).get("InterestRateUnderSplit"), tc_Test_Data.get(iTDRow).get("ExpensesFinanced"), 
						tc_Test_Data.get(iTDRow).get("TotalInsurance"), tc_Test_Data.get(iTDRow).get("FeesFinanced"), tc_Test_Data.get(iTDRow).get("FeesPrepaid"), 
						tc_Test_Data.get(iTDRow).get("FeesCharged"), tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"),"");
				premierModeling.verifyNoteModelStatement(tc_Test_Data.get(iTDRow).get("PrincipalAdvance"),tc_Test_Data.get(iTDRow).get("PaymentNumber"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC092":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.noteCalculator_Modeling();
				premierModeling.selectLoanProduct(tc_Test_Data.get(iTDRow).get("LoanProduct_Description"),tc_Test_Data.get(iTDRow).get("LoanProduct_Number"));
				premierModeling.selectNoteModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("UseSplitRates"),tc_Test_Data.get(iTDRow).get("IncludeFees"),tc_Test_Data.get(iTDRow).get("IncludeEscrow"),tc_Test_Data.get(iTDRow).get("IncludeInsurance"),tc_Test_Data.get(iTDRow).get("IncludeSimpleInsurance"),tc_Test_Data.get(iTDRow).get("IncludeDealerInterest"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.noteModelPage(tc_Test_Data.get(iTDRow).get("NoteDate"), tc_Test_Data.get(iTDRow).get("PrincipalAdvance"), tc_Test_Data.get(iTDRow).get("InterestRateOverSplit"), 
						tc_Test_Data.get(iTDRow).get("SplitRateAmount"), tc_Test_Data.get(iTDRow).get("InterestRateUnderSplit"), tc_Test_Data.get(iTDRow).get("ExpensesFinanced"), 
						tc_Test_Data.get(iTDRow).get("TotalInsurance"), tc_Test_Data.get(iTDRow).get("FeesFinanced"), tc_Test_Data.get(iTDRow).get("FeesPrepaid"), 
						tc_Test_Data.get(iTDRow).get("FeesCharged"), tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"),tc_Test_Data.get(iTDRow).get("BalloonPaymentDate"));
				premierModeling.verifyNoteModelStatement(tc_Test_Data.get(iTDRow).get("PrincipalAdvance"),tc_Test_Data.get(iTDRow).get("PaymentNumber"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC093":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.noteCalculator_Modeling();
				premierModeling.selectLoanProduct(tc_Test_Data.get(iTDRow).get("LoanProduct_Description"),tc_Test_Data.get(iTDRow).get("LoanProduct_Number"));
				premierModeling.selectNoteModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("UseSplitRates"),tc_Test_Data.get(iTDRow).get("IncludeFees"),tc_Test_Data.get(iTDRow).get("IncludeEscrow"),tc_Test_Data.get(iTDRow).get("IncludeInsurance"),tc_Test_Data.get(iTDRow).get("IncludeSimpleInsurance"),tc_Test_Data.get(iTDRow).get("IncludeDealerInterest"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.noteModelPage(tc_Test_Data.get(iTDRow).get("NoteDate"), tc_Test_Data.get(iTDRow).get("PrincipalAdvance"), tc_Test_Data.get(iTDRow).get("InterestRateOverSplit"), 
						tc_Test_Data.get(iTDRow).get("SplitRateAmount"), tc_Test_Data.get(iTDRow).get("InterestRateUnderSplit"), tc_Test_Data.get(iTDRow).get("ExpensesFinanced"), 
						tc_Test_Data.get(iTDRow).get("TotalInsurance"), tc_Test_Data.get(iTDRow).get("FeesFinanced"), tc_Test_Data.get(iTDRow).get("FeesPrepaid"), 
						tc_Test_Data.get(iTDRow).get("FeesCharged"), tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"),"");
				premierModeling.verifyNoteModelStatement(tc_Test_Data.get(iTDRow).get("PrincipalAdvance"),tc_Test_Data.get(iTDRow).get("PaymentNumber"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC094":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.noteCalculator_Modeling();
				premierModeling.selectLoanProduct(tc_Test_Data.get(iTDRow).get("LoanProduct_Description"),tc_Test_Data.get(iTDRow).get("LoanProduct_Number"));
				premierModeling.selectNoteModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("UseSplitRates"),tc_Test_Data.get(iTDRow).get("IncludeFees"),tc_Test_Data.get(iTDRow).get("IncludeEscrow"),tc_Test_Data.get(iTDRow).get("IncludeInsurance"),tc_Test_Data.get(iTDRow).get("IncludeSimpleInsurance"),tc_Test_Data.get(iTDRow).get("IncludeDealerInterest"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.noteModelPage(tc_Test_Data.get(iTDRow).get("NoteDate"), tc_Test_Data.get(iTDRow).get("PrincipalAdvance"), tc_Test_Data.get(iTDRow).get("InterestRateOverSplit"), 
						tc_Test_Data.get(iTDRow).get("SplitRateAmount"), tc_Test_Data.get(iTDRow).get("InterestRateUnderSplit"), tc_Test_Data.get(iTDRow).get("ExpensesFinanced"), 
						tc_Test_Data.get(iTDRow).get("TotalInsurance"), tc_Test_Data.get(iTDRow).get("FeesFinanced"), tc_Test_Data.get(iTDRow).get("FeesPrepaid"), 
						tc_Test_Data.get(iTDRow).get("FeesCharged"), tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"),"");
				premierModeling.verifyNoteModelStatement(tc_Test_Data.get(iTDRow).get("PrincipalAdvance"),tc_Test_Data.get(iTDRow).get("PaymentNumber"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC095":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.depositCalculator_Modeling();
				premierModeling.selectDepositProduct(tc_Test_Data.get(iTDRow).get("Application"),tc_Test_Data.get(iTDRow).get("DepositProduct_Description"),tc_Test_Data.get(iTDRow).get("DepositProduct_Number"));
				premierModeling.selectDepositModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.depositModelPage(tc_Test_Data.get(iTDRow).get("InitialDepositDate"), tc_Test_Data.get(iTDRow).get("InitialDeposit"),"", 
						tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"));
				premierModeling.verifyDepositModelStatement(tc_Test_Data.get(iTDRow).get("InitialDeposit"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC096":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.depositCalculator_Modeling();
				premierModeling.selectDepositProduct(tc_Test_Data.get(iTDRow).get("Application"),tc_Test_Data.get(iTDRow).get("DepositProduct_Description"),tc_Test_Data.get(iTDRow).get("DepositProduct_Number"));
				premierModeling.selectDepositModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.depositModelPage(tc_Test_Data.get(iTDRow).get("InitialDepositDate"), "", tc_Test_Data.get(iTDRow).get("MaturityValue"), 
						tc_Test_Data.get(iTDRow).get("PaymentActivity"), tc_Test_Data.get(iTDRow).get("PaymentDate"), 
						tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"), tc_Test_Data.get(iTDRow).get("PaymentAmount"));
				premierModeling.verifyDepositModelStatement(tc_Test_Data.get(iTDRow).get("InitialDeposit"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC097":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.depositCalculator_Modeling();
				premierModeling.selectDepositProduct(tc_Test_Data.get(iTDRow).get("Application"),tc_Test_Data.get(iTDRow).get("DepositProduct_Description"),tc_Test_Data.get(iTDRow).get("DepositProduct_Number"));
				premierModeling.selectDepositModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.depositModelPage(tc_Test_Data.get(iTDRow).get("InitialDepositDate"), tc_Test_Data.get(iTDRow).get("InitialDeposit"), tc_Test_Data.get(iTDRow).get("MaturityValue"), 
						"", tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"),"");
				premierModeling.verifyDepositModelStatement(tc_Test_Data.get(iTDRow).get("InitialDeposit"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC098":
				premierLoginPage.launchApplication(sURL);
				premierLoginPage.selectGroup(sGroup,sEnvType);
				premierLoginPage.logInToApplication(sUserID,sPassword,sInstitution);
				premierHomeMenuPage.selectModelingMenu();
				premierHomeMenuPage.depositCalculator_Modeling();
				premierModeling.selectDepositProduct(tc_Test_Data.get(iTDRow).get("Application"),tc_Test_Data.get(iTDRow).get("DepositProduct_Description"),tc_Test_Data.get(iTDRow).get("DepositProduct_Number"));
				premierModeling.selectDepositModelingPreference(tc_Test_Data.get(iTDRow).get("Product_SolveFor"),tc_Test_Data.get(iTDRow).get("IncludeCustomerInformation"),tc_Test_Data.get(iTDRow).get("IncludeMessage"));
				premierModeling.depositModelPage(tc_Test_Data.get(iTDRow).get("InitialDepositDate"), tc_Test_Data.get(iTDRow).get("InitialDeposit"), tc_Test_Data.get(iTDRow).get("MaturityValue"), 
						"", tc_Test_Data.get(iTDRow).get("PaymentDate"), tc_Test_Data.get(iTDRow).get("PaymentFrequency"), tc_Test_Data.get(iTDRow).get("PaymentNumber"),"");
				premierModeling.verifyDepositModelStatement(tc_Test_Data.get(iTDRow).get("InitialDeposit"),tc_Test_Data.get(iTDRow).get("PaymentFrequency"));
				premierModeling.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC099":
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
				
			case "PREMIER_TC100":
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
				premierDepositAccounts.changeAccountIRADetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_DateLastRollover"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRAPlan"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRAStatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRADefaultContributionCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRADefaultDistributionCode"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryCertificates();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsIRAafterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRAPlan"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRAStatusCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRADefaultContributionCode"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_IRADefaultDistributionCode"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC101":
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
				premierDepositAccounts.changeAccountProduct(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountProductAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC102":
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
				premierDepositAccounts.changeAccountPortfolio(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountPortfolioAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC103":
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
				premierDepositAccounts.changeAccountProduct(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountProductAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC104":
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
				premierDepositAccounts.changeAccountPortfolio(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquirySavings();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountPortfolioAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC105":
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
				premierDepositAccounts.changeAccountProduct(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryCertificates();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountProductAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_ProductDescription"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC106":
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
				premierDepositAccounts.changeAccountPortfolio(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryCertificates();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountPortfolioAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_Portfolio"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();				
				break;
				
			case "PREMIER_TC107":
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
				premierLoansChange.changeAccountProduct(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_LoanProduct"));		
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountProductAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_LoanProduct"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC108":
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
				premierLoansChange.changeAccountLine(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Line"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.loanAccountInquiry();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierLoansChange.validateAccountLineAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeLoan_Line"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC109":
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
				premierDepositAccounts.changeAccountAnalysisItem(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RecurringFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_ItemType"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CreditBackOverride"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_PerItemAmount"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RefreshOption"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransDate"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransQuantity"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransAmount"),"");
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountAnalysisItemAfterChange(sAccountNumber,  tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC110":
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
				premierDepositAccounts.changeAccountAnalysisItem(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RecurringFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_ItemType"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CreditBackOverride"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_PerItemAmount"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RefreshOption"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransDate"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransQuantity"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransAmount"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_ServiceChargeCycle"));
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountAnalysisItemServiceChargeAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_ServiceChargeCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC111":
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
				premierDepositAccounts.changeAccountCodeDetails2(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_BranchRegion"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountingMethod"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_CostCenter"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountOpenedMethod"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_RetentionCodeOverride"));
				premierDepositAccounts.saveButton();
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountDetailsAfterChange2(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_BranchRegion"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountingMethod"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_CostCenter"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_AccountOpenedMethod"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_RetentionCodeOverride"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC112":
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
				premierDepositAccounts.changeAccountAnalysisItem(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RecurringFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_ItemType"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CreditBackOverride"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_PerItemAmount"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RefreshOption"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransDate"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransQuantity"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransAmount"),"");
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountAnalysisItemAfterChange(sAccountNumber,  tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC113":
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
				premierDepositAccounts.changeAccountAnalysisItem(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RecurringFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_ItemType"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CreditBackOverride"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_PerItemAmount"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_RefreshOption"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransDate"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransQuantity"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransAmount"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_ServiceChargeCycle"));
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountAnalysisItemServiceChargeAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_SelectCharge"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_ServiceChargeCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC114":
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
				premierDepositAccounts.changeAccountBalanceDetails(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_DepositRateIndex"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_InterestCycle"));
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountBalanceDetailsAfterChange(sAccountNumber,tc_Test_Data.get(iTDRow).get("ChangeDeposit_DepositRateIndex"),tc_Test_Data.get(iTDRow).get("ChangeDeposit_InterestCycle"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();
				break;
				
			case "PREMIER_TC117":
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
				premierDepositAccounts.changeAccountTransfer(sAccountNumber, tc_Test_Data.get(iTDRow).get("ChangeDeposit_NextTransferDate"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_NextTransferAmount"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CredittoAccountType"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_CredittoAccount"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_ExpirationDate"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferDay"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferCycle"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_NotificationCode"));
				premierDepositAccounts.saveButton();
				
				premierHomeMenuPage.accountInquiryDemandDeposits();
				premierDepositAccounts.searchAccount(sAccountNumber);
				premierDepositAccounts.validateAccountTransferAfterChange(sAccountNumber, new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeDeposit_NextTransferDate"),"MM/dd/yyyy","MMM dd, yyyy"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_NextTransferAmount"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_CredittoAccountType"), 
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_CredittoAccount"),new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("ChangeDeposit_ExpirationDate"),"MM/dd/yyyy","MMM dd, yyyy"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferFrequency"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferDay"),
						 tc_Test_Data.get(iTDRow).get("ChangeDeposit_TransferCycle"), tc_Test_Data.get(iTDRow).get("ChangeDeposit_NotificationCode"));
				premierDepositAccounts.closeScreen_Image();
				premierLogOff.logoffApplication();		
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}