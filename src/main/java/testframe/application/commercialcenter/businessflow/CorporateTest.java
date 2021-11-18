package testframe.application.commercialcenter.businessflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testframe.application.commercialcenter.pages.Corporate_AccountTransfer;
import testframe.application.commercialcenter.pages.Corporate_AccountTransferDetails;
import testframe.application.commercialcenter.pages.Corporate_AccountTransferReview;
import testframe.application.commercialcenter.pages.Corporate_CurrentPaymentActivity;
import testframe.application.commercialcenter.pages.Corporate_Dashboard;
import testframe.application.commercialcenter.pages.Corporate_EditTransaction;
import testframe.application.commercialcenter.pages.Corporate_FuturePaymentActivity;
//import testframe.application.commercialcenter.pages.Corporate_CurrentPaymentActivity;
import testframe.application.commercialcenter.pages.Corporate_HomeMenu;
import testframe.application.commercialcenter.pages.Corporate_LogOff;
import testframe.application.commercialcenter.pages.Corporate_Login;
import testframe.application.common.ApplicationBase;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;


public class CorporateTest extends ApplicationBase  {


	String pathToAppConfigPropFolder,pathToApplicationTestDataFolder,appConfigPropertyFilePath,testdataFile,
	testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder,
	sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;
	int iIteration_count;
	String cUserID,cPassword,cCompanyID ,cPassword_Encrypt,cSecretKey,cUserID1,cPassword1,cCompanyID1 ,cPassword_Encrypt1;
	String transactionID;

	public void executeTestCase(WebDriver driver,String sApplicationName, String cURL,String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration, String sHTMLFileName) throws IOException, Exception{

		Corporate_Login corporateLogin = new Corporate_Login(driver);
		Corporate_LogOff corporateLogOff = new Corporate_LogOff(driver);
		Corporate_HomeMenu corporateHomeMenu = new Corporate_HomeMenu(driver);
		Corporate_AccountTransfer corporateAccountTransfer = new Corporate_AccountTransfer(driver);
		Corporate_AccountTransferReview corporateAccountTransferReview = new Corporate_AccountTransferReview(driver);
		Corporate_AccountTransferDetails corporateAccountTransferDetails = new Corporate_AccountTransferDetails(driver);
		Corporate_CurrentPaymentActivity corporateCurrentPaymentActivity = new Corporate_CurrentPaymentActivity(driver);
		Corporate_FuturePaymentActivity corporateFuturePaymentActivity = new Corporate_FuturePaymentActivity(driver);
		Corporate_EditTransaction corporateEditTransaction =  new Corporate_EditTransaction(driver);
		Corporate_Dashboard corporateDashboard = new Corporate_Dashboard(driver);

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
		appConfigPropertyFilePath = pathToAppConfigPropFolder + File.separator + sApplicationName +"_config.properties";
		testdataFile = pr.readProperties(appConfigPropertyFilePath,"TestData_Corporate_File");
		testdataFile_Path = pathToApplicationTestDataFolder + testdataFile;

		cCompanyID = pr.readProperties(appConfigPropertyFilePath,"Corporate_CompanyID");
		cUserID = pr.readProperties(appConfigPropertyFilePath,"Corporate_UserID");
		cPassword_Encrypt = pr.readProperties(appConfigPropertyFilePath,"Corporate_Password");
		cSecretKey = pr.readProperties(appConfigPropertyFilePath,"Secret_Key");
		cPassword = ed.decrypt(cPassword_Encrypt, cSecretKey);
		cCompanyID1 = pr.readProperties(appConfigPropertyFilePath,"Corporate_CompanyID1");
		cUserID1 = pr.readProperties(appConfigPropertyFilePath,"Corporate_UserID1");
		cPassword_Encrypt1 = pr.readProperties(appConfigPropertyFilePath,"Corporate_Password1");
		cPassword1 = ed.decrypt(cPassword_Encrypt, cSecretKey);

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
			System.setProperty("testcaseid.iteration", sTestCase+"||"+iIteration_count);
			fi.createFile(sHTMLFilePath);
			fi.checkAndCreateFolder(sScreenShotFolder);
			
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);

			new HTMLReportHelper().HTMLReportHeader("Corporate", sTestCase, sTestDescription);
			


			switch(sTestCase.toUpperCase()){
			case "CC_CORP_TC001":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//corporateAccountTransferDetails.getAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;
			case "CC_CORP_TC002":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//corporateAccountTransferDetails.getAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;
			case "CC_CORP_TC003":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//corporateAccountTransferDetails.getAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC004":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//transactionID = corporateAccountTransferDetails.getAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"));
				transactionID = corporateAccountTransferDetails.getAccTransaction();
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateCurrentPaymentActivity.clickCancelButton(transactionID,tc_Test_Data.get(iTDRow).get("WarningMsgButton"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC005":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));;
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//corporateAccountTransferDetails.getMultiAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"),tc_Test_Data.get(iTDRow).get("AccountType1"),tc_Test_Data.get(iTDRow).get("AccountType2"),tc_Test_Data.get(iTDRow).get("AccountType3"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC006":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));;
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				//corporateAccountTransferDetails.getMultiAccTransaction(tc_Test_Data.get(iTDRow).get("AccountType"),tc_Test_Data.get(iTDRow).get("AccountType1"),tc_Test_Data.get(iTDRow).get("AccountType2"),tc_Test_Data.get(iTDRow).get("AccountType3"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC007":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.addAndEnterFromAccDetails(tc_Test_Data.get(iTDRow).get("AddFromAccount1"),tc_Test_Data.get(iTDRow).get("FromAccountMemo"),tc_Test_Data.get(iTDRow).get("FromAccount1"),tc_Test_Data.get(iTDRow).get("FromAccountAmount1"),tc_Test_Data.get(iTDRow).get("FromAccountMemo1"),tc_Test_Data.get(iTDRow).get("AddFromAccount2"),tc_Test_Data.get(iTDRow).get("FromAccount2"),tc_Test_Data.get(iTDRow).get("FromAccountAmount2"),tc_Test_Data.get(iTDRow).get("FromAccountMemo2"),tc_Test_Data.get(iTDRow).get("AddFromAccount3"),tc_Test_Data.get(iTDRow).get("FromAccount3"),tc_Test_Data.get(iTDRow).get("FromAccountAmount3"),tc_Test_Data.get(iTDRow).get("FromAccountMemo3"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));;
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.selectRecurringOption(tc_Test_Data.get(iTDRow).get("RecurringOptions"),tc_Test_Data.get(iTDRow).get("Frequency"),tc_Test_Data.get(iTDRow).get("DailyOption"),tc_Test_Data.get(iTDRow).get("DailySubOption"),tc_Test_Data.get(iTDRow).get("Day"));
				corporateAccountTransfer.selectDuration(tc_Test_Data.get(iTDRow).get("Duration"),tc_Test_Data.get(iTDRow).get("TransactionDate"),tc_Test_Data.get(iTDRow).get("FixedNumTransaction"));
				corporateAccountTransfer.enterSeriesDetails(tc_Test_Data.get(iTDRow).get("SeriesDetails"));
				corporateAccountTransfer.clickRecurringOptButton();
				corporateAccountTransfer.enterSeriesName(tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC008":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID = corporateAccountTransferDetails.getAccTransaction();
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateFuturePaymentActivity.filterTransaction(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"),tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"));
				corporateFuturePaymentActivity.editPaymentActivity(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateEditTransaction.enterToAccount(tc_Test_Data.get(iTDRow).get("EditToAccount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction"));
				corporateEditTransaction.enterTransferDate(tc_Test_Data.get(iTDRow).get("EditTransferDate"));
				corporateEditTransaction.clickReqTransfer();
				corporateEditTransaction.verifyAccountTransferDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC009":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));;
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.selectRecurringOption(tc_Test_Data.get(iTDRow).get("RecurringOptions"),tc_Test_Data.get(iTDRow).get("Frequency"),tc_Test_Data.get(iTDRow).get("DailyOption"),tc_Test_Data.get(iTDRow).get("DailySubOption"),tc_Test_Data.get(iTDRow).get("Day"));
				corporateAccountTransfer.selectDuration(tc_Test_Data.get(iTDRow).get("Duration"),tc_Test_Data.get(iTDRow).get("TransactionDate"),tc_Test_Data.get(iTDRow).get("FixedNumTransaction"));
				corporateAccountTransfer.enterSeriesDetails(tc_Test_Data.get(iTDRow).get("SeriesDetails"));
				corporateAccountTransfer.clickRecurringOptButton();
				corporateAccountTransfer.enterSeriesName(tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateFuturePaymentActivity.filterTransaction(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"),tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"));
				corporateFuturePaymentActivity.editPaymentActivity(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateEditTransaction.enterToAccount(tc_Test_Data.get(iTDRow).get("EditToAccount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction"));
				//corporateEditTransaction.editAddAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("EditAddToAccount1"),tc_Test_Data.get(iTDRow).get("EditToAccount1"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount1"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo1"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("EditAddToAccount2"),tc_Test_Data.get(iTDRow).get("EditToAccount2"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount2"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo2"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("EditAddToAccount3"),tc_Test_Data.get(iTDRow).get("EditToAccount3"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount3"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo3"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction3"));
				corporateEditTransaction.enterTransferDate(tc_Test_Data.get(iTDRow).get("EditTransferDate"));
				corporateEditTransaction.clickReqTransfer();
				corporateEditTransaction.verifyAccountTransferDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC010":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID = corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));
				corporateCurrentPaymentActivity.viewCurretPaymentDetails(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("TransactionStatus"), tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), cUserID);
				corporateCurrentPaymentActivity.clickApproveButton(transactionID, tc_Test_Data.get(iTDRow).get("WarningMsgButton"));
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateCurrentPaymentActivity.filterCurrentActivityDetails(tc_Test_Data.get(iTDRow).get("Type"), transactionID, tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("Name"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateCurrentPaymentActivity.viewCurretPaymentDetails(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), cUserID);
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC011":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("CorpMenu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("CorpSubMenu"),tc_Test_Data.get(iTDRow).get("SubOption"));
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountMemoValue"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));;
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID=corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateFuturePaymentActivity.filterTransaction(transactionID, tc_Test_Data.get(iTDRow).get("SeriesName"),tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"));
				corporateFuturePaymentActivity.clickOnRightArrow(transactionID);
				corporateFuturePaymentActivity.clickRejectButton(tc_Test_Data.get(iTDRow).get("RejectReason"));
				corporateFuturePaymentActivity.verifyRjectedMsg(transactionID);
				corporateLogOff.logoffApplication();
				/*corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword,tc_Test_Data.get(iTDRow).get("ValidateLogin"));
				corporateHomeMenu.clickOnMenu(tc_Test_Data.get(iTDRow).get("Menu"));
				corporateHomeMenu.clickOnSubMenuBar(tc_Test_Data.get(iTDRow).get("SubMenu"),tc_Test_Data.get(iTDRow).get("SubOpt"));
				corporateCurrentPaymentActivity.filterCurrentActivityDetails(tc_Test_Data.get(iTDRow).get("Type"), transactionID, tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("Name"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateCurrentPaymentActivity.viewCurretPaymentDetails(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), cUserID);
				corporateLogOff.logoffApplication();*/
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}