package testframe.application.epp.businessflow;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import testframe.application.common.ApplicationBase;
import testframe.application.epp.pages.EPP_ActionPrompts;
import testframe.application.epp.pages.EPP_ApprovePayment;
import testframe.application.epp.pages.EPP_AuthorizationExceptionsList;
import testframe.application.epp.pages.EPP_CreatePayment;
import testframe.application.epp.pages.EPP_DuplicatePayments;
import testframe.application.epp.pages.EPP_LogOff;
import testframe.application.epp.pages.EPP_Login;
import testframe.application.epp.pages.EPP_MenuOptions;
import testframe.application.epp.pages.EPP_PaymentActionVerificationList;
import testframe.application.epp.pages.EPP_PaymentDetails;
import testframe.application.epp.pages.EPP_PaymentRepair;
import testframe.application.epp.pages.EPP_PaymentRepairVerificationList;
import testframe.application.epp.pages.EPP_ProductSelection;
import testframe.application.epp.pages.EPP_SecurityQuestions;
import testframe.application.epp.pages.EPP_Templates;
import testframe.application.epp.pages.EPP_TransactionIDList;
import testframe.application.epp.pages.EPP_TransactionInquiry;
import testframe.application.epp.pages.EPP_TransactionListSelection;
import testframe.application.epp.pages.EPP_VerifyPayment;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;

public class EppTest extends ApplicationBase {
	String pathToAppConfigPropFolder, pathToApplicationTestDataFolder, appConfigPropertyFilePath, testdataFile,
	testdataFile_Path, sPathToAppReportFolder, strpathToAppReportFile, sHTMLFilePath, sScreenShotFolder,
	sScreenShotFolder_Itr, strpathToAppReportFileDateTimeStamp;
	int iIteration_count;
	String sUserID1, sUserID2, sUserID3, sPassword1, sPassword2,sPassword3, sCompanyID, sPassword_Encrypt1, sPassword_Encrypt2,sPassword_Encrypt3, sSecretKey;
	// private WebDriver driver;

	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver, String sApplicationName, String sURL, String sTestCase,
			String sTestDescription, String sApplicationTDFolder, String sIteration, String sHTMLFileName, String sManual_TSID)
					throws Exception {

		EPP_Login eppLoginPage = new EPP_Login(driver);
		EPP_SecurityQuestions eppSecurityQuestions = new EPP_SecurityQuestions(driver);
		EPP_ProductSelection eppProductSelection = new EPP_ProductSelection(driver);
		EPP_MenuOptions eppMenuOPtions = new EPP_MenuOptions(driver);
		EPP_Templates eppTemplates = new EPP_Templates(driver);
		EPP_CreatePayment eppCreatePayment = new EPP_CreatePayment(driver);
		EPP_LogOff eppLogOff = new EPP_LogOff(driver);
		EPP_TransactionIDList eppTransactionIDList = new EPP_TransactionIDList(driver);
		EPP_ApprovePayment eppApprovePayment = new EPP_ApprovePayment(driver);
		EPP_TransactionInquiry eppTransactionInquiry = new EPP_TransactionInquiry(driver);
		EPP_PaymentDetails eppPaymentDetails = new EPP_PaymentDetails(driver);
		EPP_DuplicatePayments eppDuplicatePayments = new EPP_DuplicatePayments(driver);
		EPP_ActionPrompts eppActionPrompts = new EPP_ActionPrompts(driver);
		EPP_PaymentRepairVerificationList eppPaymentRepairVerificationList = new EPP_PaymentRepairVerificationList(driver);
		EPP_PaymentActionVerificationList eppPaymentActionVerificationList = new EPP_PaymentActionVerificationList(driver);
		EPP_PaymentRepair eppPaymentRepair = new EPP_PaymentRepair(driver);
		EPP_VerifyPayment eppVerifyPayment = new EPP_VerifyPayment(driver);
		EPP_AuthorizationExceptionsList eppAuthorizationExceptionsList = new EPP_AuthorizationExceptionsList(driver);
		EPP_TransactionListSelection eppTransactionListSelection = new EPP_TransactionListSelection(driver);

		sPathToAppReportFolder = pr.pathToAppReportFolderFromFrameworkPropFile();
		strpathToAppReportFile = sPathToAppReportFolder + "/" + sApplicationName;
		fi.checkAndCreateFolder(strpathToAppReportFile);

		strpathToAppReportFileDateTimeStamp = strpathToAppReportFile + "/" + System.getProperty("current.date.time");
		fi.checkAndCreateFolder(strpathToAppReportFileDateTimeStamp);

		sScreenShotFolder = strpathToAppReportFileDateTimeStamp + "/Screenshots";
		fi.checkAndCreateFolder(sScreenShotFolder);

		sScreenShotFolder = sScreenShotFolder + "/" + sTestCase.toUpperCase() + "_" + sHTMLFileName;
		fi.checkAndCreateFolder(sScreenShotFolder);
		sScreenShotFolder_Itr = sScreenShotFolder;

		pathToAppConfigPropFolder = pr.pathToAppConfigPropFolderFromFrameworkPropFile();
		pathToApplicationTestDataFolder = pr.pathToApplicationTestDataFolderFromFrameworkPropFile();
		appConfigPropertyFilePath = pathToAppConfigPropFolder + File.separator + sApplicationName
				+ "_config.properties";
		testdataFile = pr.readProperties(appConfigPropertyFilePath, "TestData_File");
		testdataFile_Path = pathToApplicationTestDataFolder + testdataFile;

		sUserID1 = pr.readProperties(appConfigPropertyFilePath, "UserID1");
		sPassword_Encrypt1 = pr.readProperties(appConfigPropertyFilePath, "Password1");
		sSecretKey = pr.readProperties(appConfigPropertyFilePath, "Secret_Key");
		sPassword1 = ed.decrypt(sPassword_Encrypt1, sSecretKey);
		sUserID2 = pr.readProperties(appConfigPropertyFilePath, "UserID2");
		sPassword_Encrypt2 = pr.readProperties(appConfigPropertyFilePath, "Password2");
		sSecretKey = pr.readProperties(appConfigPropertyFilePath, "Secret_Key");
		sPassword2 = ed.decrypt(sPassword_Encrypt2, sSecretKey);
		sUserID3 = pr.readProperties(appConfigPropertyFilePath, "UserID3");
		sPassword_Encrypt3 = pr.readProperties(appConfigPropertyFilePath, "Password3");
		sSecretKey = pr.readProperties(appConfigPropertyFilePath, "Secret_Key");
		sPassword3 = ed.decrypt(sPassword_Encrypt3, sSecretKey);

		if (sIteration == "")
			iIteration_count = 0;
		else if (sIteration == "1")
			iIteration_count = 0;
		else if (Integer.parseInt(sIteration) > 1)
			iIteration_count = Integer.parseInt(sIteration) - 1;

		List<Map<String, String>> tc_Test_Data = er.getData(testdataFile_Path, sTestCase);

		for (int iTDRow = 0; iTDRow <= iIteration_count; iTDRow++) {
			if (iIteration_count == 0) {
				sHTMLFilePath = strpathToAppReportFileDateTimeStamp + "/" + sTestCase.toUpperCase() + "_"
						+ sHTMLFileName + "_" + new DateTimeHelper().CurrentDateTime() + ".html";
				Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "Iteration - 1"
						+ "             XXXXXXXXXXXXXXXXXXXXXX");
			} else {
				sScreenShotFolder = sScreenShotFolder_Itr;
				sHTMLFilePath = strpathToAppReportFileDateTimeStamp + "/" + sTestCase.toUpperCase() + "_"
						+ sHTMLFileName + "_" + "Iterations-" + (iTDRow + 1) + "_"
						+ new DateTimeHelper().CurrentDateTime() + ".html";
				sScreenShotFolder = sScreenShotFolder + "/" + "Iterations-" + (iTDRow + 1);
				Log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "Iteration - " + (iTDRow + 1)
						+ "             XXXXXXXXXXXXXXXXXXXXXX");
			}
			System.setProperty("testcaseid.iteration", sTestCase + "||" + iIteration_count);
			fi.createFile(sHTMLFilePath);
			System.setProperty("runStep","Y");
			fi.checkAndCreateFolder(sScreenShotFolder);
			new HTMLReportHelper().setHTMLReportFilePath(sHTMLFilePath);
			new HTMLReportHelper().setScreenShotFolder(sScreenShotFolder);

			new HTMLReportHelper().HTMLReportHeader("EPP", sTestCase, sTestDescription,sManual_TSID);


			switch (sTestCase.toUpperCase()) {

			case "EPP_TC001":
				String securityQuestionTD = tc_Test_Data.get(iTDRow).get("SecurityQuestion1");
				String securityAnswerTD = tc_Test_Data.get(iTDRow).get("SecurityAnswer1");
				//String title = tc_Test_Data.get(iTDRow).get("Title");
				String menuValue = tc_Test_Data.get(iTDRow).get("Menu");
				String subMenuValue = tc_Test_Data.get(iTDRow).get("SubMenu");
				String templateHeader = tc_Test_Data.get(iTDRow).get("TemplateHeader");
				String template = tc_Test_Data.get(iTDRow).get("PaymentTemplate");
				String createPayTitle = tc_Test_Data.get(iTDRow).get("CreatePayTitle");
				String accNum = tc_Test_Data.get(iTDRow).get("AccountNumber");
				String systemCode = tc_Test_Data.get(iTDRow).get("OrderingSystemCode");
				String orderingBankName = tc_Test_Data.get(iTDRow).get("OrderingBankName");
				String debitAccount = tc_Test_Data.get(iTDRow).get("DebitAccount");
				String amount = tc_Test_Data.get(iTDRow).get("Amount");
				String benAccount = tc_Test_Data.get(iTDRow).get("BeneAccountNumber");
				String beneName = tc_Test_Data.get(iTDRow).get("BeneName");
				String beneAddress = tc_Test_Data.get(iTDRow).get("BeneAddress");
				String accWithBankNo = tc_Test_Data.get(iTDRow).get("AccountWithBank");
				String accWithSysCode = tc_Test_Data.get(iTDRow).get("AccountWithBankCode");
				String workSummaryTemplate = tc_Test_Data.get(iTDRow).get("WorkSummaryHeader");
				String worktemplate = tc_Test_Data.get(iTDRow).get("WorkSummaryTemplate");
				String bannerDetails = tc_Test_Data.get(iTDRow).get("BannerMessage");
				String paymentDetailstab = tc_Test_Data.get(iTDRow).get("PaymentDetailsTab");
				String eppTemplateName = tc_Test_Data.get(iTDRow).get("PaymentTemplate");
				String amountApproval = tc_Test_Data.get(iTDRow).get("Amount");
				String dateField = tc_Test_Data.get(iTDRow).get("ValueDate");
				String paymentMenuValue = tc_Test_Data.get(iTDRow).get("PaymentMenu");
				String paymentSubMenuValue = tc_Test_Data.get(iTDRow).get("PaymentSubMenu");
				String instAmount = tc_Test_Data.get(iTDRow).get("Amount");
				String valueDateField = tc_Test_Data.get(iTDRow).get("ValueDate");
				String transactionFinalStatus = tc_Test_Data.get(iTDRow).get("TransactionStaus");


				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(securityQuestionTD,securityAnswerTD); 
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectManualPaymentOptions();
				eppMenuOPtions.selectPaymentCreationSubMenu();
				eppTemplates.verifyPaymentCreationPool();
				eppTemplates.selectOutgoingHVBankPaymentFRBOption();
				eppCreatePayment.createOutgoingHVBankPaymentFRB(accNum,systemCode,orderingBankName, debitAccount, amount, valueDateField,
						benAccount, beneName, beneAddress,accWithBankNo, accWithSysCode);
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(securityQuestionTD, securityAnswerTD);
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentCreationVerificationOption();
				eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppApprovePayment.verifyAndApprovePayments(amountApproval, dateField);
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(instAmount, valueDateField,"");
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC002":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectManualPaymentOptions();
				eppMenuOPtions.selectPaymentCreationSubMenu();
				eppTemplates.verifyPaymentCreationPool();
				eppTemplates.selectOutgoingHVCustomerPaymentFRBOption();
				eppCreatePayment.createOutgoingHVCustomerPaymentFRB(tc_Test_Data.get(iTDRow).get("CustAccountNumber"), 
						tc_Test_Data.get(iTDRow).get("DebitAccount"),tc_Test_Data.get(iTDRow).get("Amount"), 
						tc_Test_Data.get(iTDRow).get("BeneCustAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneCustName"), 
						tc_Test_Data.get(iTDRow).get("BeneCustAddress"),
						tc_Test_Data.get(iTDRow).get("AccountWithBank"),
						tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentCreationVerificationOption();
				eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"),"");
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC003":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectManualPaymentOptions();
				eppMenuOPtions.selectPaymentCreationSubMenu();
				eppTemplates.verifyPaymentCreationPool();
				eppTemplates.selectIncomingHVCustomerPaymentFRBOption();
				eppCreatePayment.createIncomingHVCustomerPaymentFRB(tc_Test_Data.get(iTDRow).get("OrderingCustAcctNumber"), tc_Test_Data.get(iTDRow).get("OrderingBankAccount"),
						tc_Test_Data.get(iTDRow).get("OrderingSystemCode"), tc_Test_Data.get(iTDRow).get("Amount"), 
						tc_Test_Data.get(iTDRow).get("BeneCustAccountNumber"),tc_Test_Data.get(iTDRow).get("CreditAccount"),
						tc_Test_Data.get(iTDRow).get("AccountWithBank"),tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentCreationVerificationOption();
				eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"),"");
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;


			case "EPP_TC004":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectManualPaymentOptions();
				eppMenuOPtions.selectPaymentCreationSubMenu();
				eppTemplates.verifyPaymentCreationPool();
				eppTemplates.selectIncomingHVBankPaymentFRBOption();
				eppCreatePayment.createIncomingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("OrderingBankAccount"),
						tc_Test_Data.get(iTDRow).get("OrderingSystemCode"), tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("BeneCustAccountNumber"), tc_Test_Data.get(iTDRow).get("CreditAccount"),
						tc_Test_Data.get(iTDRow).get("AccountWithBank"),tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentCreationVerificationOption();
				eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"),"");
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword2);
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC005":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectDuplicatePaymentOption();
				eppDuplicatePayments.selectCancelDuplicatePayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.performActionForCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				/*eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.submitActionOnTransactionWithApproval(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();*/
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveCancelledPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC006":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectDuplicatePaymentOption();
				eppDuplicatePayments.selectReleaseHoldPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.VerifyAndPerformActionForReleaseHold();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC007":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectDuplicatePaymentOption();
				eppDuplicatePayments.selectRepairPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.performActionForRepairPayment("Testing");
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectPaymentRepair(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairVerificationOption();
				//eppTemplates.selectTemplate("Work Summary","Payment Repair Verification");
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ApprovalDate"),tc_Test_Data.get(iTDRow).get("TransactionID"),sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();	

				break;



			case "EPP_TC008":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectDuplicatePaymentOption();
				eppDuplicatePayments.selectRepairPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.performActionForRepairPayment("Testing");
				//eppMenuOPtions.selectMenuOptions(tc_Test_Data.get(iTDRow).get("Menu"));
				//eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("SubMenu"));
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				//eppTemplates.selectTemplate("Work Summary","Payment Repair");
				eppPaymentRepair.selectPaymentRepair(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				//eppActionPrompts.VerifyAndPerformPaymentRepair(tc_Test_Data.get(iTDRow).get("RepairCommentBox"), tc_Test_Data.get(iTDRow).get("CancelInitiator"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectTemplate("Work Summary","Payment Repair Verification");
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppVerifyPayment.rejectPaymentRepairAction(tc_Test_Data.get(iTDRow).get("ApprovalDate"));
				eppActionPrompts.VerifyAndPerformPaymentRepair("Testing","CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveRepairPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC009":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectManualPaymentOptions();
				eppMenuOPtions.selectPaymentCreationSubMenu();
				eppTemplates.verifyPaymentCreationPool();
				eppTemplates.selectOutgoingHVBankPaymentFRBOption();
				//eppTemplates.selectTemplate("Payment Creation","Outgoing High Value Customer Payment (FRB)");
				eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
						tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
						tc_Test_Data.get(iTDRow).get("DebitAccount"),
						tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
						tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
						tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
						tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentCreationVerificationOption();
				eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppApprovePayment.verifyAndApproveOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppPaymentDetails.verifyFutureDatedPaymentTransaction();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC010":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyRepairPaymentTransStatus("");
					//eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectTransIDFromPaymentRepair(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentRepair.validateAndApproveBIPaymentRepair(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				eppPaymentDetails.verifyRepairPaymentTransStatus(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairVerificationOption();
				eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"),sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC011":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyRepairPaymentTransStatus("");
					//eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectTransIDFromPaymentRepair(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentRepair.validateAndCancelBIPaymentRepair(tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppActionPrompts.performActionForCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveRepairPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC012":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyRepairPaymentTransStatus("");
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectTransIDFromPaymentRepair(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentRepair.validateAndApproveINPaymentRepair(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				eppPaymentDetails.verifyRepairPaymentTransStatus(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairVerificationOption();
				eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"),sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC013":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyRepairPaymentTransStatus("");
					//eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectTransIDFromPaymentRepair(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentRepair.validateAndCancelINPaymentRepair(tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppActionPrompts.performActionForCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveRepairPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC014":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyInternalFilterPaymentTransStatus();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectInternalFilterOption();
				eppPaymentDetails.selectReleaseFromInternalFilterPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.verifyAndSubmitINFilterAction();
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword1);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC015":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyInternalFilterPaymentTransStatus();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectInternalFilterOption();
				eppPaymentDetails.selectCancelPaymentForInternalFilter(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.performActionForINFilterCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveInternalFilterPayment();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC016":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyBusinessFilterPaymentTransStatus();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID3, sPassword3);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectNotificationPoolOption();
				eppPaymentDetails.selectReleaseFromBusinessFilterPayment(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppActionPrompts.verifyAndSubmitBIFilterAction();
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectTransactionInquirySubMenu();
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword3);
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;	

			case "EPP_TC017":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppMenuOPtions.selectPaymentTrackingOptions();
					eppMenuOPtions.selectTransactionInquirySubMenu();
					eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppPaymentDetails.verifyCompletedPaymentTransaction(sPassword2);
					eppPaymentDetails.selectRecallPayment();
					eppActionPrompts.performActionOnRecallPayment();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveRecallPaymentTransaction();
				eppMenuOPtions.selectPaymentTrackingOptions();
				eppMenuOPtions.selectWorkSummarySubMenu();

				eppTemplates.selectPendingOutgoingRequestPoolOption();
				eppTransactionIDList.selectPendingOutgoingRecallTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;



			case "EPP_TC018":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyFundsReleasePaymentTransaction();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}	
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectAuthorizationExceptions();
				eppAuthorizationExceptionsList.selectAuthorizationExceptionsTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.selectPaymentActions("Cancel Payment");
				eppActionPrompts.performActionForCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveCancelPayments(tc_Test_Data.get(iTDRow).get("TransactionID"),"Funds Release");
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;


			case "EPP_TC019":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyFundsReleasePaymentTransaction();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();

				}	
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectAuthorizationExceptions();
				eppAuthorizationExceptionsList.selectAuthorizationExceptionsTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.selectPaymentActions("Release From GFC Hold");
				eppActionPrompts.VerifyAndPerformActionForRelease(tc_Test_Data.get(iTDRow).get("ReleaseReason"));
				driver.close();
				eppLogOff.logOffEPPApplication();

				break;

			case "EPP_TC020":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyFundsReleasePaymentTransaction();
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
				}	
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectAuthorizationExceptions();
				eppAuthorizationExceptionsList.selectAuthorizationExceptionsTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.selectPaymentActions("Repair Payment");
				eppActionPrompts.performActionForRepairPayment("Testing");
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairOption();
				eppPaymentRepair.selectPaymentRepair(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentRepairVerificationOption();
				//eppTemplates.selectTemplate("Work Summary","Payment Repair Verification");
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ValueDate"),tc_Test_Data.get(iTDRow).get("TransactionID"),sPassword2);
				driver.close();
				eppLogOff.logOffEPPApplication();	


				break;


			case "EPP_TC021":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyTransaction("Regulatory Filter",tc_Test_Data.get(iTDRow).get("TransactionID"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();


				}	
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectWorkSummaryPool("Regulatory Check");
				eppTransactionListSelection.selectTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.selectPaymentActions("Release From OFC Hold");
				eppActionPrompts.VerifyAndPerformActionForRelease(tc_Test_Data.get(iTDRow).get("ReleaseReason"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.performAction(tc_Test_Data.get(iTDRow).get("TransactionID"),"approval","Approve Release From OFC","Regulatory Filter","Completed");
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC022":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				if(!(tc_Test_Data.get(iTDRow).get("AccountNumber").equals("NA"))) {
					eppMenuOPtions.selectManualPaymentOptions();
					eppMenuOPtions.selectPaymentCreationSubMenu();
					eppTemplates.verifyPaymentCreationPool();
					eppTemplates.selectOutgoingHVBankPaymentFRBOption();
					eppCreatePayment.createOutgoingHVBankPaymentFRB(tc_Test_Data.get(iTDRow).get("AccountNumber"),
							tc_Test_Data.get(iTDRow).get("OrderingSystemCode"),tc_Test_Data.get(iTDRow).get("OrderingBankName"),
							tc_Test_Data.get(iTDRow).get("DebitAccount"),
							tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("ValueDate"),
							tc_Test_Data.get(iTDRow).get("BeneAccountNumber"),tc_Test_Data.get(iTDRow).get("BeneName"),
							tc_Test_Data.get(iTDRow).get("BeneAddress"),tc_Test_Data.get(iTDRow).get("AccountWithBank"),
							tc_Test_Data.get(iTDRow).get("AccountWithBankCode"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.loginEppApplication(sUserID2, sPassword2);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();
					eppTemplates.verifyWorkSummaryPool();
					eppTemplates.selectPaymentCreationVerificationOption();
					eppTransactionIDList.selectTransactionIDFromList(tc_Test_Data.get(iTDRow).get("TransactionID"));
					eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("Amount"),
							tc_Test_Data.get(iTDRow).get("ValueDate"));
					eppPaymentDetails.verifyTransaction("Regulatory Filter",tc_Test_Data.get(iTDRow).get("TransactionID"));
					driver.close();
					eppLogOff.logOffEPPApplication();
					eppLoginPage.launchApplication(sURL);
					eppLoginPage.loginEppApplication(sUserID1, sPassword1);
					eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
							tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
					eppProductSelection.selectProductEPP();


				}	
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectWorkSummaryPool("Regulatory Check");
				eppTransactionListSelection.selectTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.selectPaymentActions("Cancel Payment");
				eppActionPrompts.performActionForCancelPayment("CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.verifyWorkSummaryPool();
				eppTemplates.selectPaymentActionVerificationOption();
				eppPaymentActionVerificationList.selectPaymentActionVerificationTransID(tc_Test_Data.get(iTDRow).get("TransactionID"));
				eppPaymentDetails.approveCancelPayments(tc_Test_Data.get(iTDRow).get("TransactionID"),"Regulatory Filter");
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;
			}
			new HTMLReportHelper().HtmlReportFooter();

		}
		driver.close();
	}

}
