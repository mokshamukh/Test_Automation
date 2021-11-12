package testframe.application.epp.pages;
/**
 * PageName : EPP_ApprovePayment
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_ApprovePayment extends CommonLibrary{

	public EPP_ApprovePayment(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppApprovePayment = "EPP_ApprovePayment";
	public String paymentTabs = "//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'approval')]//..//..//a[text()='%s']";
	
	By screenTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Verify Payment')]");
	By paymentBanner = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'approval')]");
	By transactionvalue = By.xpath("//span[@id='TransactionIDReadOnly']");
	By templateName = By.xpath("//form[@id='FormPayment']//td//b");
	By approvalAmount = By.xpath("//input[@class='validationBlindRekey']");
	By valueDate = By.xpath("//input[@id='Value_Date']");
	By approveButton = By.xpath("//div[@id='img_button_approve']");
	By repairButton = By.xpath("//div[@id='img_button_repair']");
	By editButton = By.xpath("//div[@id='img_button_edit']");
	By deleteButton = By.xpath("//div[@id='img_button_delete']");
	By paymentApprovedMsg = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD'][@name='Payment.approved']");
	By backutton = By.xpath("//div[@class='titleBarBackButton']");
	
	
	public void verifyAndApprovePayments(String eppTemplateName,String amountApproval,String dateField) {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppApprovePayment, "Approve Payment", screenTitle);
			if(isElementPresent(screenTitle)) {
				validateTextContains(eppApprovePayment,  "Payment Details Banner", paymentBanner, "This transaction has been submitted for approval following manual creation");
				getDynamicElement("Payment Details Tab", paymentTabs, "Payment Details" );
				isElementPresent(transactionvalue);
				validateTextEquals(eppApprovePayment, "Template Name", templateName, eppTemplateName);
				waitElement(2000);
				enterText(eppApprovePayment, "Approval Amount", approvalAmount, amountApproval);
				waitElement(2000);
				enterText(eppApprovePayment, "Value Date Field", valueDate, dateField);
				waitElement(2000);
				clickOnElement(eppApprovePayment, "Approve Payment", approveButton);
				waitElement(7000);
				isElementPresent(paymentApprovedMsg);
				waitElement(3000);
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("Approve EPP Payment- EPP application", "Approved Successfully", "Passed", driver, "Y");
			}else {
				System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Approve EPP Payment- EPP application", "Could not Approve Successfully", "Failed", driver, "Y");
			}
		}
	}	
	
}
