package testframe.application.epp.pages;
/**
 * PageName : EPP_PaymentDetails
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_PaymentDetails extends CommonLibrary {

	EPP_CreatePayment eppCreatePayment;
	EPP_ActionPrompts eppActionPrompts;
	
	public EPP_PaymentDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
		eppActionPrompts = new EPP_ActionPrompts(driver);
	}
	
	public String eppPaymentDetails = "EPP_PaymentDetails";
	String approveTransID;
	String approveDuplicateTransID;
	String approveRepairTransID;
	String rejectRepairTransID;
	
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By bypassON = By.xpath("//div[@id='Refresh_UserResponse']//..//td[contains(text(),'Bypass Flag is currently ON')]");
    By transactionId = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Transaction ID')]//..//..//td[@class='valueCell'][1]");
    By selectAmount = By.xpath("//select[@name='AmountCCY']");
    By refTransID = By.xpath("//div[@class='lightShadedBackground']//..//..//input[@name='ReferenceValue']");
    By displayMsg = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p");
    By dupTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Duplicate Content')]");
    By selectCancelPaymentAction = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Cancel Payment')]");// selectByValue(	//*[@value='CancelPayment'])
	By paymentActionButton = By.xpath("//select[@id='ActionSelect']");
	By executeButton = By.xpath("//div[@id='img_button_execute']");	
    By actionSuccessfull = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']");
	By repairStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Status')]//..//..//td[contains(text(),'Repair')]");
	By approveRepairPayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Approve Payment Action')]");
	By rejectRepairPayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Reject Payment Action')]");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By cancelDuplicateReqBanner = By.xpath("//div[contains(@id,'Refresh_PaymentDetails')]//p[contains(.,'Cancel requested while in Duplicate Content: (HV001) Amend Amount/Currency. testing')]");
	By stageDetails = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Stage')]//..//..//td[contains(text(),'Complete')]");
	By cancelRepairBanner = By.xpath("//div[contains(@id,'Refresh_PaymentDetails')]//p[contains(.,'Cancel requested while in Repair')]");
	By paymentSentRepairBanner = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Payment sent to repair from Duplicate Content')]");
	
	public void verifyPaymentTransaction() {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", transactionStatus, "Completed");
				validateElementPresent(eppPaymentDetails, "Transaction Status", transactionStatus);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
			}
		}

		}
	
	public void submitActionOnTransactionWithApproval(String duplicateTransactionStatus,String approvalAction) {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					validateElementPresent(eppPaymentDetails, "Transaction Status", dupTransStatus);
					validateTextContains(eppPaymentDetails,  "Transaction Status", dupTransStatus, duplicateTransactionStatus);
					String duplicatetransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveDuplicateTransID = eppActionPrompts.getTransactionIDOnAction();
					if(duplicatetransID.equalsIgnoreCase(approveDuplicateTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", selectCancelPaymentAction, approvalAction);
				    waitElement(2000);
				    //ApprovePayment
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				 waitElement(1000);
				if(isElementPresent(cancelDuplicateReqBanner)) {
					validateElementPresent(eppPaymentDetails, "Status Message", stageDetails);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Repair Transaction Status verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Repair Transaction Status Successfully", "Failed", driver, "Y");
				}
			}
	}
	
	
	public void approveRepairPayment() {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					validateElementPresent(eppPaymentDetails, "Transaction Status", repairStatus);
					String repairtransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveRepairTransID = eppActionPrompts.getTransactionIDOnAction();
					if(repairtransID.equalsIgnoreCase(approveRepairTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", approveRepairPayment, "Approve Payment Action");
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Action executed Successfully", transIdSaved);
				waitElement(1000);
				if(isElementPresent(cancelRepairBanner)) {
				validateElementPresent(eppPaymentDetails, "Status Message", stageDetails);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
				}
			}
	}
	
//	public void rejectPaymentRepairAction(String repairTransactionStatus) {
//		 boolean stepResult = false;
//			try {
//				waitElement(3000);
//				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
//				if(isElementPresent(displayMsg)) {
//					validateElementPresent(eppPaymentDetails, "Transaction Status", repairStatus);
//					//validateTextContains(eppPaymentDetails,  "Transaction Status", dupTransStatus, repairTransactionStatus);
//					String repairtransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
//					rejectRepairTransID = eppActionPrompts.getTransactionIDOnAction();
//					if(repairtransID.equalsIgnoreCase(rejectRepairTransID)) {
//						System.out.println("Pass");
//						stepResult = true;
//					}else {
//						System.out.println("fail");
//					}
//					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Reject Payment Action')]")).click();
//					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", rejectRepairPayment, "Reject Payment Action");
//				    waitElement(2000);
//				    //ApprovePayment
//				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
//				}
//			validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
//			waitElement(2000);
//			clickOnElement(eppPaymentDetails, "Action executed Successfully", transIdSaved);
//			waitForPresenceOfElement(eppPaymentDetails, "Payment Details Banner", paymentSentRepairBanner);
//			waitElement(1000);
//			if (isElementPresent(paymentSentRepairBanner)) {
//				validateElementPresent(eppPaymentDetails, "Status Message", repairStatus);
//			}
//				stepResult = true;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				if (stepResult == true) {
//					System.out.println("Pass");
//					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
//				} else {
//					System.out.println("fail");
//					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
//				}
//			}
//	}
	

}

