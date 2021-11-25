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
	
	public String eppVerifyDetails = "EPP_VerifyDetails";
	
	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Repair Verification')]");
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Verify Payment')]");
	By displayMsg = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p[contains(text(),'submitted for approval following repair ')]");
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
    
	public void approvePaymentRepairAction(String valueDate) throws Exception {
		 boolean stepResult = false;
			try {
				if(isElementPresent(title)){
					String transactionID = eppCreatePayment.getTransactionID();
					getDynamicElementClick(eppVerifyDetails, "Work Summary List", transactionIdList, transactionID);
				}
				waitElement(3000);
				waitForPresenceOfElement(eppVerifyDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					enterText(eppVerifyDetails, "Value Date", date, valueDate);
					}
				clickOnElement(eppVerifyDetails, "Approve Button", approveBtn);
				waitElement(8000);
				validateElementPresent(eppVerifyDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppVerifyDetails, "Clicked on Transaction ID", transIdSaved);
				waitElement(1000);
				if(isElementPresent(paymentDetails)) {
				validateElementPresent(eppVerifyDetails, "Status Message", transactionStatus);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Verify Payment Details EPP - EPP application", "Transaction Approved Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify Payment Details EPP - EPP application","Could not approve Transaction Successfully", "Failed", driver, "Y");
				}
			}
	}
	
	
	public void rejectPaymentRepairAction(String valueDate) throws Exception {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppVerifyDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					enterText(eppVerifyDetails, "Value Date", date, valueDate);
					}
				clickOnElement(eppVerifyDetails, "Approve Button", cancelBtn);
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
					new HTMLReportHelper().HtmlReportBody("Verify Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
				}
			}
	}
	
	
}
