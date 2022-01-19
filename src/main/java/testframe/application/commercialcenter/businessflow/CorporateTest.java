package testframe.application.commercialcenter.businessflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import testframe.application.commercialcenter.pages.Corporate_ACHBatchTemplate;
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
import testframe.application.commercialcenter.pages.Corporate_ManageWireTemplates;
import testframe.application.commercialcenter.pages.Corporate_NewACHBatchTemplate;
import testframe.application.commercialcenter.pages.Corporate_NewPayee;
import testframe.application.commercialcenter.pages.Corporate_NewWireTransfer;
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
	static Corporate_ACHBatchTemplate corporateACHBatchTemplate;
	static Corporate_NewACHBatchTemplate corporateNewACHBatchTemplate;
	static Corporate_NewPayee corporate_NewPayee;
	static Corporate_NewWireTransfer corporate_NewWireTransfer;
	
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
		corporateNewACHBatchTemplate = new Corporate_NewACHBatchTemplate(driver);
		corporateACHBatchTemplate = new Corporate_ACHBatchTemplate(driver);
		CorporateCommonNavigation corporateCommonNavigation = new CorporateCommonNavigation();
		Corporate_NewPayee corporateNewPayee = new Corporate_NewPayee(driver);
		Corporate_NewWireTransfer corporateNewWireTransfer = new Corporate_NewWireTransfer(driver);
		Corporate_ManageWireTemplates corporateManageWireTemplates = new Corporate_ManageWireTemplates(driver);

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
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), 
						tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				//corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), 
						tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), 
						tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;
			case "CC_CORP_TC002":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), 
						tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), 
						tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), 
						tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;
			case "CC_CORP_TC003":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC004":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID = corporateAccountTransferDetails.getAccTransaction();
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				corporateHomeMenu.clickOnCurrentPaymentActivity();
				corporateCurrentPaymentActivity.clickCancelButton(transactionID);
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC005":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), 
						tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),
						tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),
						tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),
						tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),
						tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),
						tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),
						tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),
						tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),
						tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),
						tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),
						tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),
						tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),
						tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC006":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				corporateAccountTransferDetails.getAccTransaction();
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC007":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.addAndEnterFromAccDetails(tc_Test_Data.get(iTDRow).get("AddFromAccount1"),tc_Test_Data.get(iTDRow).get("FromAccountMemo"),tc_Test_Data.get(iTDRow).get("FromAccount1"),tc_Test_Data.get(iTDRow).get("FromAccountAmount1"),tc_Test_Data.get(iTDRow).get("FromAccountMemo1"),tc_Test_Data.get(iTDRow).get("AddFromAccount2"),tc_Test_Data.get(iTDRow).get("FromAccount2"),tc_Test_Data.get(iTDRow).get("FromAccountAmount2"),tc_Test_Data.get(iTDRow).get("FromAccountMemo2"),tc_Test_Data.get(iTDRow).get("AddFromAccount3"),tc_Test_Data.get(iTDRow).get("FromAccount3"),tc_Test_Data.get(iTDRow).get("FromAccountAmount3"),tc_Test_Data.get(iTDRow).get("FromAccountMemo3"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
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
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"),
						tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), 
						tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), 
						tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
			    corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				//transactionID= "ATR-00001101";
				transactionID = corporateAccountTransferDetails.getAccTransaction();
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				corporateHomeMenu.clickOnfuturePaymentActivity();
				corporateFuturePaymentActivity.filterTransaction(new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("TransferDate"),"MM/dd/yyyy","yyyy-MM-dd"));
//				corporateFuturePaymentActivity.filterTransaction(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"),
//						tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),
//						tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"),
//						tc_Test_Data.get(iTDRow).get("TransactionDate"));
				corporateFuturePaymentActivity.editPaymentActivity(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateEditTransaction.enterToAccount(tc_Test_Data.get(iTDRow).get("EditToAccount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount"),
						tc_Test_Data.get(iTDRow).get("EditToAccountMemo"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction"));
				corporateEditTransaction.enterTransferDate(tc_Test_Data.get(iTDRow).get("EditTransferDate"));
				corporateEditTransaction.clickReqTransfer();
				corporateEditTransaction.verifyAccountTransferDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), 
						tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoEditReview"),
						tc_Test_Data.get(iTDRow).get("PaymentIstructionEditReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC009":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				////corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
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
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				corporateHomeMenu.clickOnRecurringPaymentActivity();
//				corporateFuturePaymentActivity.filterTransaction(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"),
//						tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),
//						tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"),
//						tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateFuturePaymentActivity.editPaymentActivity(transactionID,tc_Test_Data.get(iTDRow).get("SeriesName"));
				corporateEditTransaction.enterToAccount(tc_Test_Data.get(iTDRow).get("EditToAccount"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction"));
				//corporateEditTransaction.editAddAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("EditAddToAccount1"),tc_Test_Data.get(iTDRow).get("EditToAccount1"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount1"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo1"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("EditAddToAccount2"),tc_Test_Data.get(iTDRow).get("EditToAccount2"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount2"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo2"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("EditAddToAccount3"),tc_Test_Data.get(iTDRow).get("EditToAccount3"),tc_Test_Data.get(iTDRow).get("EditToAccountAmount3"),tc_Test_Data.get(iTDRow).get("EditToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("EditToAccountMemo3"),tc_Test_Data.get(iTDRow).get("EditToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("EditToAccountPaymentInstruction3"));
				corporateEditTransaction.enterTransferDate(tc_Test_Data.get(iTDRow).get("EditTransferDate"));
				corporateEditTransaction.clickReqTransfer();
				corporateEditTransaction.verifyAccountTransferDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("EditToAccountMemo"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC010":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), tc_Test_Data.get(iTDRow).get("MemoReview"), tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"), tc_Test_Data.get(iTDRow).get("AmtReview"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID = corporateAccountTransferDetails.getAccTransaction();
//				transactionID = "ATR-00001109";
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				corporateHomeMenu.clickOnfuturePaymentActivity();
				corporateFuturePaymentActivity.filterTransaction(new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("TransferDate"),"MM/dd/yyyy","yyyy-MM-dd"));
//				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));
//				corporateCurrentPaymentActivity.viewCurretPaymentDetails(tc_Test_Data.get(iTDRow).get("TransferDate"), 
//						transactionID, tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("TransactionStatus"), 
//						tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), cUserID);
				corporateCurrentPaymentActivity.clickApproveButton(transactionID);
				corporateLogOff.logoffApplication();
//				corporateLogin.launchApplication(cURL);
//				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
//				corporateHomeMenu.clickOnPaymentMenu();
//				corporateHomeMenu.clickOnPaymentActivity();
//				corporateHomeMenu.clickOnfuturePaymentActivity();
//				corporateFuturePaymentActivity.filterFutureActivityDetails(tc_Test_Data.get(iTDRow).get("Type"), transactionID, tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("Name"), tc_Test_Data.get(iTDRow).get("AmtReview"));
//				corporateFuturePaymentActivity.viewFuturePaymentDetails(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("Status"), tc_Test_Data.get(iTDRow).get("FromAccReview"), tc_Test_Data.get(iTDRow).get("ToAccReview"), cUserID);
//				corporateLogOff.logoffApplication();
				break;

			case "CC_CORP_TC011":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAccountTransfer();
				corporateAccountTransfer.enterFromAccount(tc_Test_Data.get(iTDRow).get("FromAccount"), tc_Test_Data.get(iTDRow).get("FromAccountAmount"));
				corporateAccountTransfer.enterToAccount(tc_Test_Data.get(iTDRow).get("ToAccount"), tc_Test_Data.get(iTDRow).get("ToAccountAmount"), tc_Test_Data.get(iTDRow).get("ToAccountMemo"), tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction"));
				corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				//corporateAccountTransfer.addAndEnterToAccDetails(tc_Test_Data.get(iTDRow).get("AddToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmount1"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal1"),tc_Test_Data.get(iTDRow).get("ToAccountMemo1"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue1"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction1"),tc_Test_Data.get(iTDRow).get("AddToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccount2"),tc_Test_Data.get(iTDRow).get("ToAccountAmount2"),tc_Test_Data.get(iTDRow).get("	ToAccountAmountVal2"),tc_Test_Data.get(iTDRow).get("ToAccountMemo2"),tc_Test_Data.get(iTDRow).get("	ToAccountMemoValue2"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction2"),tc_Test_Data.get(iTDRow).get("AddToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmount3"),tc_Test_Data.get(iTDRow).get("ToAccountAmountVal3"),tc_Test_Data.get(iTDRow).get("ToAccountMemo3"),tc_Test_Data.get(iTDRow).get("ToAccountMemoValue3"),tc_Test_Data.get(iTDRow).get("ToAccountPaymentInstruction3"));
				corporateAccountTransfer.enterTransferDate(tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateAccountTransfer.clickReqTransfer();
				corporateAccountTransferReview.verifyMultipleAccDetails(tc_Test_Data.get(iTDRow).get("FromAccReview"),tc_Test_Data.get(iTDRow).get("ToAccReview"),tc_Test_Data.get(iTDRow).get("MemoReview"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview"),tc_Test_Data.get(iTDRow).get("AmtReview"),tc_Test_Data.get(iTDRow).get("FromAccReview1"),tc_Test_Data.get(iTDRow).get("ToAccReview1"),tc_Test_Data.get(iTDRow).get("MemoReview1"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview1"),tc_Test_Data.get(iTDRow).get("AmtReview1"),tc_Test_Data.get(iTDRow).get("FromAccReview2"),tc_Test_Data.get(iTDRow).get("ToAccReview2"),tc_Test_Data.get(iTDRow).get("MemoReview2"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview2"),tc_Test_Data.get(iTDRow).get("AmtReview2"),tc_Test_Data.get(iTDRow).get("FromAccReview3"),tc_Test_Data.get(iTDRow).get("ToAccReview3"),tc_Test_Data.get(iTDRow).get("MemoReview3"),tc_Test_Data.get(iTDRow).get("PaymentIstructionReview3"),tc_Test_Data.get(iTDRow).get("AmtReview3"));
				corporateAccountTransferReview.clickConfirmButton();
				corporateAccountTransferDetails.verifyAccStatus(tc_Test_Data.get(iTDRow).get("AccountStatus"));
				transactionID=corporateAccountTransferDetails.getAccTransaction();
				//transactionID = "ATR-00001109";
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				//corporateHomeMenu.clickOnCurrentPaymentActivity();
				corporateHomeMenu.clickOnfuturePaymentActivity();
				corporateFuturePaymentActivity.filterTransaction(new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("TransferDate"),"MM/dd/yyyy","yyyy-MM-dd"));
				//corporateFuturePaymentActivity.filterTransaction(transactionID, tc_Test_Data.get(iTDRow).get("SeriesName"),tc_Test_Data.get(iTDRow).get("Product"),tc_Test_Data.get(iTDRow).get("IncludedTransactions"),tc_Test_Data.get(iTDRow).get("EntryMethod"),tc_Test_Data.get(iTDRow).get("ImportFile"),tc_Test_Data.get(iTDRow).get("TransferDate"));
				corporateFuturePaymentActivity.clickOnRightArrow(transactionID);
				corporateFuturePaymentActivity.clickRejectButton(tc_Test_Data.get(iTDRow).get("RejectReason"));
				corporateFuturePaymentActivity.verifyRjectedMsg(transactionID);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC012":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "Y");
				corporateLogOff.logoffApplication();
				break;
//				corporateACHBatchTemplate.createBatchTemplate(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
//				corporateACHBatchTemplate.enterACHBatchDetails(tc_Test_Data.get(iTDRow).get("TemplateName"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"));
//				//corporateACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("SearchPayeeName"),tc_Test_Data.get(iTDRow).get("Amount"));
//				String[] multiPayee;
//				if (!tc_Test_Data.get(iTDRow).get("SearchPayeeName").equals("")){
//					 multiPayee = tc_Test_Data.get(iTDRow).get("SearchPayeeName").split("\\|\\|");
//					for(int i=0;i<=multiPayee.length-1;i++){
//							corporateACHBatchTemplate.searchPayee(multiPayee[i],tc_Test_Data.get(iTDRow).get("Amount").split("\\|\\|")[i]);
//					}
//				}else {
//					 multiPayee = tc_Test_Data.get(iTDRow).get("CreatePayeeName").split("\\|\\|");
//					for(int i=0;i<=multiPayee.length-1;i++){
//					corporateACHBatchTemplate.createNewPayee(tc_Test_Data.get(iTDRow).get("CreatePayeeName").split("\\|\\|")[i], tc_Test_Data.get(iTDRow).get("CreatePayeeID").split("\\|\\|")[i],
//							tc_Test_Data.get(iTDRow).get("CreateAccountNumber").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("CreateBankID").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("CreateBankName").split("\\|\\|")[i],
//							tc_Test_Data.get(iTDRow).get("CreateDebitAuthType").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Amount").split("\\|\\|")[i]);
//				}
//			}
//				
//				corporateACHBatchTemplate.saveBatchTemplate();
//				corporateACHBatchTemplate.searchTemplate(tc_Test_Data.get(iTDRow).get("TemplateName"),tc_Test_Data.get(iTDRow).get("BatchType"));
			
				
			case "CC_CORP_TC013":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				String updateTemplate,batchType;
				if(!tc_Test_Data.get(iTDRow).get("Search_ExistingTemplateName").equals("")){
					updateTemplate = tc_Test_Data.get(iTDRow).get("Update_ExistingTemplateName");
					batchType = tc_Test_Data.get(iTDRow).get("Search_ExistingBatchType");
			     	corporateACHBatchTemplate.searchTemplate(tc_Test_Data.get(iTDRow).get("Search_ExistingTemplateName"),tc_Test_Data.get(iTDRow).get("Search_ExistingBatchType"));
				}else {
					updateTemplate = tc_Test_Data.get(iTDRow).get("TemplateName");
					batchType = tc_Test_Data.get(iTDRow).get("BatchType");
					corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				}
				corporateACHBatchTemplate.editBatchTemplate(updateTemplate,tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
						tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
						tc_Test_Data.get(iTDRow).get("Update_Amount"),tc_Test_Data.get(iTDRow).get("RemoveExistingPayee"),
						tc_Test_Data.get(iTDRow).get("SearchPayeeName"),tc_Test_Data.get(iTDRow).get("Update_CreatePayeeName"),
						tc_Test_Data.get(iTDRow).get("Update_CreatePayeeID"),tc_Test_Data.get(iTDRow).get("Update_CreateAccountNumber"),
						tc_Test_Data.get(iTDRow).get("Update_CreateBankID"),tc_Test_Data.get(iTDRow).get("Update_CreateBankName"),
						tc_Test_Data.get(iTDRow).get("Update_CreateDebitAuthType"),tc_Test_Data.get(iTDRow).get("Update_Addenda"),
						tc_Test_Data.get(iTDRow).get("Update_SendRemittanceToPayee"));
				corporateACHBatchTemplate.searchTemplate(updateTemplate,batchType);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC014":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				//String payeeName;
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
					transactionID = corporateNewACHBatchTemplate.getTransaction();
//					corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
//					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
//							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
//							tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
//							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
//							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
//							tc_Test_Data.get(iTDRow).get("Amount"));
//					corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("PayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
//					corporateNewACHBatchTemplate.verifyPassword(cPassword);
//					transactionID = corporateNewACHBatchTemplate.getTransaction();
					corporateLogOff.logoffApplication();
					corporateLogin.launchApplication(cURL);
					corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
					corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
					corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
							tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
							//cUserID);
				}else {
				//corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
				//payeeName = tc_Test_Data.get(iTDRow).get("CreateNewPayeeName");
				corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
						//cUserID);
			}
				corporateCurrentPaymentActivity.clickApproveButtonForACHPayment(transactionID,cPassword);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC015":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				//String payeeName;
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
					corporateNewACHBatchTemplate.verifyPassword(cPassword);
					transactionID = corporateNewACHBatchTemplate.getTransaction();
					corporateLogOff.logoffApplication();
					corporateLogin.launchApplication(cURL);
					corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
					corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
					corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
							tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
							//cUserID);
				}else {
				//corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
						//cUserID);
			}
				corporateCurrentPaymentActivity.clickRejectButtonForACHPayment(transactionID,"test");
				corporateLogOff.logoffApplication();
				break;
			
			case "CC_CORP_TC016":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				//String payeeName;
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
					corporateNewACHBatchTemplate.verifyPassword(cPassword);
					transactionID = corporateNewACHBatchTemplate.getTransaction();
					corporateLogOff.logoffApplication();
					corporateLogin.launchApplication(cURL);
					corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
					corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
					corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
							tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
							//cUserID);
				}else {
				//corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
			}
				corporateCurrentPaymentActivity.clickCancelButtonForACHPayment(transactionID);
				corporateLogOff.logoffApplication();
				break;		
				
			case "CC_CORP_TC017":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				if(!tc_Test_Data.get(iTDRow).get("ExistPayeeName").equals("")){
				corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
				corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
						tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
						tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
						tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
						tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
						tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
						tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));
				}else {
					corporateNewACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("ExistPayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				}
				corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickApproveButtonForACHPayment(transactionID,cPassword);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC018":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				if(!tc_Test_Data.get(iTDRow).get("ExistPayeeName").equals("")){
					corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));
					corporateNewACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("ExistPayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				    corporateNewACHBatchTemplate.clickOnRequestBatchButton();
				}else {
					corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));			
					corporateNewACHBatchTemplate.clickOnRequestBatchButton();
					}
				corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickRejectButtonForACHPayment(transactionID,"Testing");
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC019":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				if(!tc_Test_Data.get(iTDRow).get("ExistPayeeName").equals("")){
					corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));
					corporateNewACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("ExistPayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				    corporateNewACHBatchTemplate.clickOnRequestBatchButton();
				}else {
					corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));			
					corporateNewACHBatchTemplate.clickOnRequestBatchButton();
					}
				corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickCancelButtonForACHPayment(transactionID);
				corporateLogOff.logoffApplication();
				break;		
				
			case "CC_CORP_TC020":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "Y");
				corporateLogOff.logoffApplication();
				break;	
				
			case "CC_CORP_TC021":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
					corporateNewACHBatchTemplate.verifyPassword(cPassword);
					transactionID = corporateNewACHBatchTemplate.getTransaction();
					corporateLogOff.logoffApplication();
					corporateLogin.launchApplication(cURL);
					corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
					corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
					corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
							tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
							//cUserID);
				}else {
				//corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("TemplateName"));
				corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
						//cUserID);
			}
				corporateCurrentPaymentActivity.clickApproveButtonForACHPayment(transactionID,cPassword);
				corporateLogOff.logoffApplication();
				break;		
			
			case "CC_CORP_TC022":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				String newTemplate,newBatchType;
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					newTemplate = tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate");
					newBatchType = tc_Test_Data.get(iTDRow).get("BatchType");
					corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee"));
					corporateNewACHBatchTemplate.clickOnRequestBatchButton();
				}else {
					corporateHomeMenu.clickOnAchBacthTemplate();
					newTemplate = tc_Test_Data.get(iTDRow).get("TemplateName");
					newBatchType = tc_Test_Data.get(iTDRow).get("BatchType");
					corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				}
				corporateCommonNavigation.editNewAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickApproveButtonForACHPayment(transactionID,cPassword);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC023":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee"));
					corporateNewACHBatchTemplate.clickOnRequestBatchButton();
				}else {
					corporateHomeMenu.clickOnAchBacthTemplate();
					newTemplate = tc_Test_Data.get(iTDRow).get("TemplateName");
					newBatchType = tc_Test_Data.get(iTDRow).get("BatchType");
					corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				}
				corporateCommonNavigation.editNewAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickCancelButtonForACHPayment(transactionID);
				corporateLogOff.logoffApplication();
				break;
			
			case "CC_CORP_TC024":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
					corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
							tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
							tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
							tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
							tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
							tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee"));
					corporateNewACHBatchTemplate.clickOnRequestBatchButton();
				}else {
					corporateHomeMenu.clickOnAchBacthTemplate();
					newTemplate = tc_Test_Data.get(iTDRow).get("TemplateName");
					newBatchType = tc_Test_Data.get(iTDRow).get("BatchType");
					corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				}
				corporateCommonNavigation.editNewAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickRejectButtonForACHPayment(transactionID,"Reject Testing");
				corporateLogOff.logoffApplication();
				break;
			
			case "CC_CORP_TC025":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPayees();
				corporateHomeMenu.clickOnNewPayee();
				corporateCommonNavigation.createNewPayeeAndSearch(tc_Test_Data, iTDRow);
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC026":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				if(!tc_Test_Data.get(iTDRow).get("Payee").equals("")){
					corporateHomeMenu.clickOnWireTransfers();
					corporateHomeMenu.clickOnNewWireTransfer();
					//corporateCommonNavigation.createNewWireTransfer(tc_Test_Data, iTDRow);
					corporate_NewWireTransfer.createNewWireTransferUsingPayee(tc_Test_Data.get(iTDRow).get("Payee"),
			    			   tc_Test_Data.get(iTDRow).get("DebitAccount"),tc_Test_Data.get(iTDRow).get("PaymentCurrency"),
			    			   tc_Test_Data.get(iTDRow).get("PurposeOfPayment"),tc_Test_Data.get(iTDRow).get("Amount"));
						corporate_NewWireTransfer.reviewWireTransferDetails(tc_Test_Data.get(iTDRow).get("DebitAccount"), 
								tc_Test_Data.get(iTDRow).get("Amount"));
				}else {
					corporateHomeMenu.clickOnPayees();
					corporateHomeMenu.clickOnNewPayee();
					corporateCommonNavigation.createNewPayeeAndSearch(tc_Test_Data, iTDRow);
					corporateHomeMenu.clickOnPaymentMenu();
					corporateHomeMenu.clickOnWireTransfers();
					corporateHomeMenu.clickOnNewWireTransfer();
					//corporateCommonNavigation.createNewWireTransfer(tc_Test_Data, iTDRow);
					corporate_NewWireTransfer.createNewWireTransferUsingPayee(tc_Test_Data.get(iTDRow).get("Payee"),
			    			   tc_Test_Data.get(iTDRow).get("DebitAccount"),tc_Test_Data.get(iTDRow).get("PaymentCurrency"),
			    			   tc_Test_Data.get(iTDRow).get("PurposeOfPayment"),tc_Test_Data.get(iTDRow).get("Amount"));
						corporate_NewWireTransfer.reviewWireTransferDetails(tc_Test_Data.get(iTDRow).get("DebitAccount"), 
								tc_Test_Data.get(iTDRow).get("Amount"));
				}
				corporate_NewWireTransfer.verifyPassword(cPassword);
				transactionID = corporate_NewWireTransfer.getTransaction();
				corporateLogOff.logoffApplication();
				break;
			
			case "CC_CORP_TC027":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnWireTransfers();
				corporateHomeMenu.clickOnNewWireTransfer();
				corporate_NewWireTransfer.createNewWireTransferUsingFreeForm(tc_Test_Data.get(iTDRow).get("Payee"),
						tc_Test_Data.get(iTDRow).get("DebitAccount"),tc_Test_Data.get(iTDRow).get("BeneIdType"),
						tc_Test_Data.get(iTDRow).get("BeneId"),tc_Test_Data.get(iTDRow).get("BeneAddress1"),
						tc_Test_Data.get(iTDRow).get("BeneAddress2"),tc_Test_Data.get(iTDRow).get("BeneCountry"),
						tc_Test_Data.get(iTDRow).get("BeneBankIDType"),tc_Test_Data.get(iTDRow).get("PaymentCurrency"),
						tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("BeneBankID"),
						tc_Test_Data.get(iTDRow).get("PurposeOfPayment"),tc_Test_Data.get(iTDRow).get("BeneBankAddress1"),
						tc_Test_Data.get(iTDRow).get("BeneBankAddress2"));
				corporate_NewWireTransfer.verifyPassword(cPassword);
				transactionID = corporate_NewWireTransfer.getTransaction();
				corporateLogOff.logoffApplication();
				break;
				
			case "CC_CORP_TC028":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnWireTransfers();
				corporateHomeMenu.clickOnManageWireTemplates();
				corporateManageWireTemplates.createWireTemplateForFreeForm(tc_Test_Data.get(iTDRow).get("FreeFormTempalte"),
						tc_Test_Data.get(iTDRow).get("RepetitiveButton"),tc_Test_Data.get(iTDRow).get("TemplateName"),
						tc_Test_Data.get(iTDRow).get("Payee"),tc_Test_Data.get(iTDRow).get("DebitAccount"),
						tc_Test_Data.get(iTDRow).get("BeneIdType"),tc_Test_Data.get(iTDRow).get("BeneID"),
						tc_Test_Data.get(iTDRow).get("beneAddress1"),tc_Test_Data.get(iTDRow).get("BeneAddress2"),
						tc_Test_Data.get(iTDRow).get("BeneCountry"),tc_Test_Data.get(iTDRow).get("BeneBankIDType"),
						tc_Test_Data.get(iTDRow).get("PaymentCurrency"),tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("BeneBankID"),tc_Test_Data.get(iTDRow).get("PurposeOfPayment"),
						tc_Test_Data.get(iTDRow).get("BeneBankAddress1"),tc_Test_Data.get(iTDRow).get("BeneBankAddress2"));
				corporate_NewWireTransfer.reviewWireTransferDetails(tc_Test_Data.get(iTDRow).get("DebitAccount"), 
						tc_Test_Data.get(iTDRow).get("Amount"));
				corporate_NewWireTransfer.verifyPassword(cPassword);
				transactionID = corporate_NewWireTransfer.getTransaction();
				corporateManageWireTemplates.searchWireTemplate(tc_Test_Data.get(iTDRow).get("TemplateName"), 
						tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Payee"));
				corporateLogOff.logoffApplication();
				break;	
			
			case "CC_CORP_TC039":
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				if(!tc_Test_Data.get(iTDRow).get("ExistPayeeName").equals("")){
				corporateNewACHBatchTemplate.startAchPaymentWithFreeForm(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
				corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
						tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
						tc_Test_Data.get(iTDRow).get("CreatePayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
						tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
						tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
						tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
						tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee"));
				}else {
					corporateNewACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("ExistPayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				}
				corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
				corporateCurrentPaymentActivity.clickApproveButtonForACHPayment(transactionID,cPassword);
				corporateLogOff.logoffApplication();
				break;	
			
				
			case "CC_CORP_TC038":	
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				//String payeeName;
				if(!tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate").equals("")){
					corporateHomeMenu.clickOnNewAchBacth();
					corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
					corporateNewACHBatchTemplate.verifyPassword(cPassword);
					transactionID = corporateNewACHBatchTemplate.getTransaction();
					corporateLogOff.logoffApplication();
					corporateLogin.launchApplication(cURL);
					corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
					corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
					corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
							tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
							//cUserID);
				}else {
				//corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateHomeMenu.clickOnAchBacthTemplate();
				corporateCommonNavigation.batchTemplateCreationandSearch(tc_Test_Data, iTDRow, "N");
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnAchPayments();
				corporateHomeMenu.clickOnNewAchBacth();
				corporateCommonNavigation.newAchPaymentWithTemplate(tc_Test_Data, iTDRow);
				corporateNewACHBatchTemplate.verifyPassword(cPassword);
				transactionID = corporateNewACHBatchTemplate.getTransaction();
				corporateLogOff.logoffApplication();
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID1, cUserID1, cPassword1);
				corporateDashboard.selectApprovals(tc_Test_Data.get(iTDRow).get("ApprovalType"));//(ACH Payments)
				corporateCurrentPaymentActivity.viewCurretPaymentDetailsForACH(tc_Test_Data.get(iTDRow).get("TransferDate"), transactionID, 
						tc_Test_Data.get(iTDRow).get("AmtReview"), tc_Test_Data.get(iTDRow).get("TransactionStatus"));
						//cUserID);
			}
				corporateCurrentPaymentActivity.clickRejectButtonForACHPayment(transactionID,"test");
				corporateLogin.launchApplication(cURL);
				corporateLogin.logInToApplication(cCompanyID, cUserID, cPassword);
				corporateHomeMenu.clickOnPaymentMenu();
				corporateHomeMenu.clickOnPaymentActivity();
				corporateHomeMenu.clickOnfuturePaymentActivity();
				corporateFuturePaymentActivity.filterTransaction(new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("TransferDate"),"MM/dd/yyyy","yyyy-MM-dd"));
				corporateCurrentPaymentActivity.clickCancelButtonForACHPayment(transactionID);
				corporateLogOff.logoffApplication();
				break;	
				
				
			}	
			new HTMLReportHelper().HtmlReportFooter();
		}
		driver.close();
	}
}



