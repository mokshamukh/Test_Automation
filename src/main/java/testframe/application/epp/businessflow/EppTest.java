package testframe.application.epp.businessflow;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import testframe.application.common.ApplicationBase;
import testframe.application.common.CommonLibrary;
import testframe.application.epp.pages.EPP_ActionPrompts;
import testframe.application.epp.pages.EPP_ApprovePayment;
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
import testframe.application.epp.pages.EPP_VerifyPayment;
import testframe.application.epp.pages.EPP_WorkSummaryList;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.reporting.Log;
import testframe.common.utilities.DateTimeHelper;

public class EppTest extends ApplicationBase {
	String pathToAppConfigPropFolder, pathToApplicationTestDataFolder, appConfigPropertyFilePath, testdataFile,
			testdataFile_Path,sPathToAppReportFolder, strpathToAppReportFile,sHTMLFilePath,sScreenShotFolder
			,sScreenShotFolder_Itr,strpathToAppReportFileDateTimeStamp;
	int iIteration_count;
	String sUserID1, sUserID2, sPassword1, sPassword2, sCompanyID, sPassword_Encrypt1, sPassword_Encrypt2, sSecretKey;
	//private WebDriver driver;
	
	
	@SuppressWarnings("unused")
	public void executeTestCase(WebDriver driver,String sApplicationName, String sURL, String sTestCase, String sTestDescription,
			String sApplicationTDFolder, String sIteration,String sHTMLFileName) throws Exception {
		
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
		
		
		if (sIteration == "")
			iIteration_count = 0;
		else if (sIteration == "1")
			iIteration_count = 0;
		else if (Integer.parseInt(sIteration) > 1)
			iIteration_count = Integer.parseInt(sIteration) - 1;

		List<Map<String, String>> tc_Test_Data = er.getData(testdataFile_Path, sTestCase);

		for (int iTDRow = 0; iTDRow <= iIteration_count; iTDRow++) {
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
			
			new HTMLReportHelper().HTMLReportHeader("EPP", sTestCase, sTestDescription);
			System.setProperty("testcaseid.iteration", sTestCase+"||"+iIteration_count);
			
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
			  eppMenuOPtions.selectMenuOptions(menuValue);
			  eppMenuOPtions.selectSubMenuOptions(subMenuValue);
			  eppTemplates.selectTemplate(templateHeader, template);
			  eppCreatePayment.createOutgoingHVBankPaymentFRB(accNum,
			  systemCode, debitAccount, amount, benAccount, beneName, beneAddress,
			  accWithBankNo, accWithSysCode);
			  driver.close();
			  eppLogOff.logOffEPPApplication();
			  eppLoginPage.loginEppApplication(sUserID2, sPassword2);
			  eppSecurityQuestions.enterSecurityQuestions(securityQuestionTD, securityAnswerTD);
			  eppProductSelection.selectProductEPP();
			  eppTemplates.selectTemplate(workSummaryTemplate, worktemplate);
			  eppTransactionIDList.selectTransactionIDFromList();
			  eppApprovePayment.verifyAndApprovePayments("Outgoing High Value Bank Payment (FRB)",
						amountApproval, dateField);
			  eppMenuOPtions.selectMenuOptions(paymentMenuValue);
			  eppMenuOPtions.selectSubMenuOptions(paymentSubMenuValue);
			  eppTransactionInquiry.searchTransaction(instAmount, valueDateField);
			  eppPaymentDetails.verifyPaymentTransaction();
			  driver.close();
			  eppLogOff.logOffEPPApplication();
			  break;

			case "EPP_TC002":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectMenuOptions(tc_Test_Data.get(iTDRow).get("Menu"));
				eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("SubMenu"));
				eppTemplates.selectTemplate(tc_Test_Data.get(iTDRow).get("TemplateHeader"),
						tc_Test_Data.get(iTDRow).get("PaymentTemplate"));
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
				eppTemplates.selectTemplate(tc_Test_Data.get(iTDRow).get("WorkSummaryHeader"),
						tc_Test_Data.get(iTDRow).get("WorkSummaryTemplate"));
				eppTransactionIDList.selectTransactionIDFromList();
				eppApprovePayment.verifyAndApprovePayments(tc_Test_Data.get(iTDRow).get("PaymentTemplate"), tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectMenuOptions(tc_Test_Data.get(iTDRow).get("PaymentMenu"));
				eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("PaymentSubMenu"));
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppPaymentDetails.verifyPaymentTransaction();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;

			case "EPP_TC003":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectMenuOptions("Manual Payments");
				eppMenuOPtions.selectSubMenuOptions("Payment Creation");
				eppTemplates.selectTemplate("Payment Creation","Incoming High Value Customer Payment (FRB)");
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
				eppTemplates.selectTemplate("Work Summary","Payment Creation Verification");
				eppTransactionIDList.selectTransactionIDFromList();
				eppApprovePayment.verifyAndApprovePayments("Incoming High Value Customer Payment (FRB)",
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("ValueDate"));

				eppMenuOPtions.selectMenuOptions("Payment Tracking");
				eppMenuOPtions.selectSubMenuOptions("Transaction Inquiry");
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppPaymentDetails.verifyPaymentTransaction();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;
				
				
			case "EPP_TC004":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectMenuOptions("Manual Payments");
				eppMenuOPtions.selectSubMenuOptions("Payment Creation");
				eppTemplates.selectTemplate("Payment Creation","Incoming High Value Bank Payment (FRB)");
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
				eppTemplates.selectTemplate("Work Summary","Payment Creation Verification");
				eppTransactionIDList.selectTransactionIDFromList();
				eppApprovePayment.verifyAndApprovePayments("Incoming High Value Bank Payment (FRB)",
						tc_Test_Data.get(iTDRow).get("Amount"), tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectMenuOptions("Payment Tracking");
				eppMenuOPtions.selectSubMenuOptions("Transaction Inquiry");
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppPaymentDetails.verifyPaymentTransaction();
				eppLogOff.logOffEPPApplication();
				break;
			
			case "EPP_TC005":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate(tc_Test_Data.get(iTDRow).get("TemplateHeader"),
						tc_Test_Data.get(iTDRow).get("TemplateOption"));
				eppDuplicatePayments.selectCancelDuplicatePayment();
				eppActionPrompts.performActionForCancelPayment(tc_Test_Data.get(iTDRow).get("CommentBox"),
						tc_Test_Data.get(iTDRow).get("CancelInitiator"));
				driver.close();
				eppLogOff.logOffEPPApplication();
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate(tc_Test_Data.get(iTDRow).get("WorkSummaryHeader"),
						tc_Test_Data.get(iTDRow).get("WorkSummayOption"));
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID();
				eppPaymentDetails.submitActionOnTransactionWithApproval(tc_Test_Data.get(iTDRow).get("DuplicateTransactionStaus"),
						tc_Test_Data.get(iTDRow).get("ApprovalStaus"));
			    driver.close();
			    eppLogOff.logOffEPPApplication();
			    break;
			    
			case "EPP_TC006":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate("Work Summary","Duplicate Payments");
				eppDuplicatePayments.selectReleaseHoldPayment();
				eppActionPrompts.VerifyAndPerformActionForReleaseHold("Testing");
				driver.close();
				eppLogOff.logOffEPPApplication();
			    break;
			    
			case "EPP_TC007":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate(tc_Test_Data.get(iTDRow).get("TemplateHeader"),
						tc_Test_Data.get(iTDRow).get("TemplateOption"));
				eppDuplicatePayments.selectRepairPayment();
				eppActionPrompts.performActionForRepairPayment(tc_Test_Data.get(iTDRow).get("RepairCommentBox"));
				//eppMenuOPtions.selectMenuOptions(tc_Test_Data.get(iTDRow).get("Menu"));
				//eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("SubMenu"));
				eppTemplates.selectTemplate("Work Summary","Payment Repair");
				eppPaymentRepair.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				//eppActionPrompts.VerifyAndPerformPaymentRepair(tc_Test_Data.get(iTDRow).get("RepairCommentBox"), tc_Test_Data.get(iTDRow).get("CancelInitiator"));
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate("Work Summary","Payment Repair Verification");
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID();
				eppVerifyPayment.approvePaymentRepairAction(tc_Test_Data.get(iTDRow).get("ApprovalDate"));
			    driver.close();
			    eppLogOff.logOffEPPApplication();
			    break;
			    
			    
			    
			case "EPP_TC008":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate("Work Summary","Duplicate Payments");
				eppDuplicatePayments.selectRepairPayment();
				eppActionPrompts.performActionForRepairPayment("Testing");
				//eppMenuOPtions.selectMenuOptions(tc_Test_Data.get(iTDRow).get("Menu"));
				//eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("SubMenu"));
				eppTemplates.selectTemplate("Work Summary","Payment Repair");
				eppPaymentRepair.selectPaymentRepairOnTransactionID(tc_Test_Data.get(iTDRow).get("UpdatedAmount"));
				//eppActionPrompts.VerifyAndPerformPaymentRepair(tc_Test_Data.get(iTDRow).get("RepairCommentBox"), tc_Test_Data.get(iTDRow).get("CancelInitiator"));
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID2, sPassword2);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate("Work Summary","Payment Repair Verification");
				eppPaymentRepairVerificationList.selectPaymentRepairOnTransactionID();
				eppVerifyPayment.rejectPaymentRepairAction(tc_Test_Data.get(iTDRow).get("ApprovalDate"));
				eppActionPrompts.VerifyAndPerformPaymentRepair("Testing","CUST");
				driver.close();
				eppLogOff.logOffEPPApplication();	
				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppTemplates.selectTemplate("Work Summary","Payment Action Verification");
				eppPaymentActionVerificationList.selectPaymentActionOnTransactionID();
				eppPaymentDetails.approveRepairPayment();
			    driver.close();
			    eppLogOff.logOffEPPApplication();
			    break;

			case "EPP_TC009":

				eppLoginPage.launchApplication(sURL);
				eppLoginPage.loginEppApplication(sUserID1, sPassword1);
				eppSecurityQuestions.enterSecurityQuestions(tc_Test_Data.get(iTDRow).get("SecurityQuestion1"),
						tc_Test_Data.get(iTDRow).get("SecurityAnswer1"));
				eppProductSelection.selectProductEPP();
				eppMenuOPtions.selectMenuOptions("Manual Payments");
				eppMenuOPtions.selectSubMenuOptions("Payment Creation");
				eppTemplates.selectTemplate("Payment Creation","Outgoing High Value Customer Payment (FRB)");
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
				eppTemplates.selectTemplate("Work Summary","Payment Creation Verification");
				eppTransactionIDList.selectTransactionIDFromList();
				eppApprovePayment.verifyAndApprovePayments("Outgoing High Value Customer Payment (FRB)", tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppMenuOPtions.selectMenuOptions("Payment Tracking");
				eppMenuOPtions.selectSubMenuOptions(tc_Test_Data.get(iTDRow).get("Transaction Inquiry"));
				eppTransactionInquiry.searchTransaction(tc_Test_Data.get(iTDRow).get("Amount"),
						tc_Test_Data.get(iTDRow).get("ValueDate"));
				eppPaymentDetails.verifyPaymentTransaction();
				driver.close();
				eppLogOff.logOffEPPApplication();
				break;
			    
			    
			}			new HTMLReportHelper().HtmlReportFooter();

		}
		driver.close();
	}

}
