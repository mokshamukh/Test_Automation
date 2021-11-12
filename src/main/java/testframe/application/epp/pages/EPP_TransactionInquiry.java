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
	String approveTransID;

	By transactionTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Transaction Inquiry')]");
	By instructionAmount = By.xpath("//input[@name='Amount']");
	By valueDate = By.xpath("//input[@id='ValueDate']");
	By searchButton = By.xpath("//div[@id='img_button_search']");
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
    By selectAmount = By.xpath("//select[@name='AmountCCY']");
    By refTransID = By.xpath("//div[@class='lightShadedBackground']//..//..//input[@name='ReferenceValue']");
    
	
   public void searchTransaction(String instAmount,String valueDateField) {
	 boolean stepResult = false;
	try {
		switchToWindowWithTitleContaining("Enterprise Payments Platform");
		driver.switchTo().frame("main");
		waitForPresenceOfElement(eppTransactionInquiry, "Transaction Inquiry", transactionTitle);
		if(isElementPresent(transactionTitle)) {
			approveTransID = eppCreatePayment.getTransactionID();
			enterText(eppTransactionInquiry, "Instruction Amount", refTransID, approveTransID);
			selectElementByVisibleText(eppTransactionInquiry, "Instruction Amount", selectAmount, "USD");
			waitElement(3000);
			enterText(eppTransactionInquiry, "Instruction Amount", instructionAmount, instAmount);
			enterText(eppTransactionInquiry, "Value Date", valueDate, valueDateField);
			clickOnElement(eppTransactionInquiry, "Search Button", searchButton);
			waitElement(5000);
		}
		stepResult = true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (stepResult == true) {
			System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("Transaction Inquiry EPP - EPP application", "Transaction searched Successfully","Passed", driver, "Y");
		} else {
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Transaction Inquiry EPP - EPP application","Could not search Transaction Successfully", "Failed", driver, "Y");
		}
	}

}
  
  
 }
