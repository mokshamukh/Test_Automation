package testframe.application.epp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_PaymentActionVerificationList extends CommonLibrary{
	
	EPP_ActionPrompts eppActionPrompts;

	public EPP_PaymentActionVerificationList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppActionPrompts = new EPP_ActionPrompts(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String eppPaymentActionList = "EPP_PaymentActionVerificationList";
	public String actionOntransactionIdList = "//div[@id='Refresh_PaymentActionVerification']//a[@class='linkGeneral'][text()='%s']";
	

	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");
	
	
	
	public void selectPaymentActionOnTransactionID() {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPaymentActionList, "Work Summary List", title);
			if (isElementPresent(title)) {
				String transID = eppActionPrompts.getTransactionIDOnAction();
				getDynamicElementClick(eppPaymentActionList, "Work Summary List", actionOntransactionIdList, transID);
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
