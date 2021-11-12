package testframe.application.epp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_PaymentRepairVerificationList extends CommonLibrary {

	EPP_ActionPrompts eppActionPrompts;

	public EPP_PaymentRepairVerificationList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppActionPrompts = new EPP_ActionPrompts(driver);
	}

	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");

	public String eppPaymentRepairList = "EPP_PaymentRepairVerificationList";
	public String actionOntransactionIdList = "//div[@id='Refresh_MEPaymentVerify']//a[@class='linkGeneral'][text()='%s']";

	public void selectPaymentRepairOnTransactionID() {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPaymentRepairList, "Work Summary List", title);
			if (isElementPresent(title)) {
				String transID = eppActionPrompts.getTransactionIDOnAction();
				getDynamicElementClick(eppPaymentRepairList, "Work Summary List", actionOntransactionIdList, transID);
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
