package testframe.application.epp.pages;
/**
 * PageName : EPP_VerifyPayment
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_VerifyPayment extends CommonLibrary{

	EPP_CreatePayment eppCreatePayment;

	public EPP_VerifyPayment(WebDriver driver) {
		super(driver);
		eppCreatePayment = new EPP_CreatePayment(driver);
		// TODO Auto-generated constructor stub
	}
	
	int longWait = 200000;
	public String eppVerifyDetails = "EPP_VerifyDetails";

	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Repair Verification')]");
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Verify Payment')]");
	By displayMsgCancel = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p[contains(text(),'submitted for approval following repair ')]");
	By displayMsgApprove = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p[contains(text(),'submitted for approval following repair ')]");
	By repairStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Status')]//..//..//td[contains(text(),'Repair')]");
	By date = By.xpath("//input[@id='Value_Date']");
	By approveBtn = By.xpath("//div[@id='img_button_approve']");
	By cancelBtn = By.xpath("//a[@id='CancelPayment']");
	By actionSuccessfull = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD'][@name='Payment.approved']");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By paymentDetails = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By amount = By.xpath("//input[@id='Amount']");
	public String  transactionIdList = "//div[@id='Refresh_MEPaymentVerify']//a[@class='linkGeneral'][text()='%s']";
	By auditTrail = By.xpath("//a[text()='Audit Trail']");
	By messagesTab = By.xpath("//a[text()='Messages']");
	By sentMessage = By.xpath("//a[text()='Sent']");
	By selectAction = By.xpath("//select[@id='ActionSelect']");
	By password = By.xpath("//input[@name='ValidatePassword']");
	By submit = By.xpath("//a[@id='Submit']");
	String transactionIDLink = "//a[text()='%s']";
	By executeButton = By.xpath("//div[@id='img_button_execute']");	
	By transStatus = By.xpath("(//div[@id='contentBody']//table[@class='outer-table'])[1]//tr[2]//td[@class='valueCell'][2]");

	public void approvePaymentRepairAction(String valueDate, String  strTransactionID,String sPassword) throws Exception {
		if (System.getProperty("runStep")=="Y"){ 
			boolean stepResult = false;
			try {
				
				if(isElementPresentZeroWait(title)){
					if (!strTransactionID.equals("")){
						
						getDynamicElementClick(eppVerifyDetails, "Work Summary List", transactionIdList, strTransactionID);
					}else{
						String transactionID = eppCreatePayment.getTransactionID();
						getDynamicElementClick(eppVerifyDetails, "Work Summary List", transactionIdList, transactionID);
						strTransactionID = transactionID;
					}
					waitElement(3000);
					
				}	
					waitForPresenceOfElement(eppVerifyDetails, "Payment Title", paymentTitle);
					validateElementPresent(eppVerifyDetails, "Approve Message", displayMsgApprove);
					enterText(eppVerifyDetails, "Value Date", date, valueDate);
					
					clickOnElement(eppVerifyDetails, "Approve Button", approveBtn);
					waitElement(3000);
					validateElementPresent(eppVerifyDetails, "Action Successfull Message", actionSuccessfull);
					waitElement(2000);
					clickOnElement(eppVerifyDetails, "Clicked on Transaction ID", transIdSaved);
					waitElement(1000);
					waitForPresenceOfElement(eppVerifyDetails, "Payment Details",paymentDetails);
					waitElement(longWait);
					if (getElementText(eppVerifyDetails,"Transaction Status",transStatus).equals("Clearing")){
						clickOnElement(eppVerifyDetails, "Audit Trail Tab", auditTrail);
						waitElement(1000);
						clickOnElement(eppVerifyDetails, "Messages Tab", messagesTab);
						waitElement(1000);
						clickOnElement(eppVerifyDetails, "Sent", sentMessage);
						waitElement(1000);
						selectElementByVisibleText(eppVerifyDetails, "Select Action", selectAction,"Manual Ack");
						clickOnElement(eppVerifyDetails, "Execute Button", executeButton);
						waitElement(1000);
						enterText(eppVerifyDetails, "Paswword Field", password, sPassword);
						clickOnElement(eppVerifyDetails, "Submit Button", submit);
						waitElement(1000);
						System.out.println(strTransactionID);
						getDynamicElementClick(eppVerifyDetails, "Transaction ID link", transactionIDLink,strTransactionID);
						waitElement(1500);
					}
					
					validateElementPresent(eppVerifyDetails, "Status Message", transactionStatus);
					stepResult = true;
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Approve and Verify Payment Details", "Transaction Approved and verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Approve and Verify Payment Details","Could not approve and verify the transaction", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void rejectPaymentRepairAction(String valueDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){ 
			boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppVerifyDetails, "Payment Title", paymentTitle);
				validateElementPresent(eppVerifyDetails, "Approve Message",displayMsgCancel);
				enterText(eppVerifyDetails, "Value Date", date, valueDate);
				
				clickOnElement(eppVerifyDetails, "Cancel Button", cancelBtn);
				waitElement(8000);
				//				validateElementPresent(eppVerifyDetails, "Action Successfull Message", actionSuccessfull);
				//				waitElement(2000);
				//				clickOnElement(eppVerifyDetails, "Action executed Successfully", transIdSaved);
				//				waitElement(1000);
				//				if(isElementPresent(paymentDetails)) {
				//				validateElementPresent(eppVerifyDetails, "Status Message", transactionStatus);
				//				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Cancel Repair Payment", "Repair Payment cancelled successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Cancel Repair Payment","Could not cancel Repair payment", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


}
