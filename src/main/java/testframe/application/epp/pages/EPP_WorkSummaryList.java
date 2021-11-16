package testframe.application.epp.pages;
/**
 * PageName : EPP_WorkSummaryList
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import testframe.application.epp.pages.EPP_CreatePayment;
import testframe.common.reporting.HTMLReportHelper;
import testframe.application.common.CommonLibrary;

public class EPP_WorkSummaryList extends CommonLibrary {

	EPP_CreatePayment eppCreatePayment;

	public EPP_WorkSummaryList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
	}
	
	
	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");
	
	public String eppWorkSummary = "EPP_WorkSummary";
	public String transactionIdList = "//div[@id='Refresh_PaymentCreationVerification']//a[@class='linkGeneral'][text()='%s']";
	
	
	public void selectTransactionIDFromList() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppWorkSummary, "Work Summary List", title);
			if(isElementPresent(title)){
			String transactionID = eppCreatePayment.getTransactionID();
			getDynamicElementClick(eppWorkSummary, "Work Summary List", transactionIdList, transactionID);
			waitElement(8000);
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	} finally {
		if (stepResult == true) {
			System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application", "TransactionID Selected Successfully","Passed", driver, "Y");
		} else {
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application","Could not Select TransactionID Successfully", "Failed", driver, "Y");
		}
	}
		
	}
	
	
}
