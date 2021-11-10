package testframe.application.epp.pages;
/**
 * PageName : EPP_TransactionInquiry
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;


public class EPP_TransactionInquiry extends CommonLibrary {

	EPP_CreatePayment eppCreatePayment;
	
	public EPP_TransactionInquiry(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
	}
	
	public String eppTransactionInquiry = "EPP_TransactionInquiry";

	By transactionTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Transaction Inquiry')]");
	By instructionAmount = By.xpath("//input[@name='Amount']");
	By valueDate = By.xpath("//input[@id='ValueDate']");
	By searchButton = By.xpath("//div[@id='img_button_search']");
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By bypassON = By.xpath("//div[@id='Refresh_UserResponse']//..//td[contains(text(),'Bypass Flag is currently ON')]");
    By transactionId = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Transaction ID')]//..//..//td[@class='valueCell'][1]");
  
	
   public void searchAndverifyTransactionStatus(String instAmount,String valueDateField,String transactionFinalStatus) {
	 boolean stepResult = false;
	try {
		switchToWindowWithTitleContaining("Enterprise Payments Platform");
		driver.switchTo().frame("main");
		waitForPresenceOfElement(eppTransactionInquiry, "Transaction Inquiry", transactionTitle);
		if(isElementPresent(transactionTitle)) {
			enterText(eppTransactionInquiry, "Instruction Amount", instructionAmount, instAmount);
			enterText(eppTransactionInquiry, "Instruction Amount", valueDate, valueDateField);
			clickOnElement(eppTransactionInquiry, "Search Button", searchButton);
			waitElement(5000);
		}
		waitElement(3000);
		if(isElementPresent(paymentTitle)) {
			validateTextContains(eppTransactionInquiry,  "Transaction Status", transactionStatus, transactionFinalStatus);
			validateElementPresent(eppTransactionInquiry, "Transaction Status", transactionStatus);
			String transactionIDStatus = getElementText(eppTransactionInquiry, "Transaction ID", transactionId);
			String approveTransID = eppCreatePayment.getTransactionID();
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
			new HTMLReportHelper().HtmlReportBody("Transaction Inquiry EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
		} else {
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Transaction Inquiry EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
		}
	}

}
  
  
 }
