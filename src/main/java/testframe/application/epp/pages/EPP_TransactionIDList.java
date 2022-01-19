package testframe.application.epp.pages;
/**
 * PageName : EPP_TransactionIDList
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

public class EPP_TransactionIDList extends CommonLibrary {

	EPP_CreatePayment eppCreatePayment;
	static String firstTransID;

	public EPP_TransactionIDList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
	}


	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");

	public String eppTransactionIDList = "EPP_TransactionIDList";
	public String transactionIdList = "//div[@id='Refresh_PaymentCreationVerification']//a[@class='linkGeneral'][text()='%s']";
	public String pendingOutgoingRecallReqTransList = "//div[@id='contentBody']//..//a[@class='linkGeneral'][text()='%s']";

	By pendingFirstTransID = By.xpath("//div[@id='contentBody']//..//a[@class='linkGeneral']");
	By outgoingRecallReqReason = By.xpath("//form[@id='actionableForm']//..//td[contains(text(),'RECALL')]");


	public void selectTransactionIDFromList() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppTransactionIDList, "Work Summary List", title);
				if(isElementPresent(title)){
					String transactionID = eppCreatePayment.getTransactionID();
					getDynamicElementClick(eppTransactionIDList, "Work Summary List", transactionIdList, transactionID);
					waitElement(8000);
					stepResult = true;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application", "TransactionID Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application","Could not Select TransactionID Successfully", "Failed", driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void selectPendingOutgoingRecallTransactionIDFromList() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppTransactionIDList, "Work Summary List", title);
				if(isElementPresent(title)){
					String transactionID = eppCreatePayment.getTransactionID();
					if(!(transactionID==null)) {
						getDynamicElementClick(eppTransactionIDList, "Work Summary List", pendingOutgoingRecallReqTransList, transactionID);
					}else {
						String firstTransID = getElementText(eppTransactionIDList, "First PendingOutgoing Transaction ID", pendingFirstTransID);
						eppCreatePayment.setTransactionID(firstTransID);
						clickOnElement(eppTransactionIDList, "First Transaction ID", pendingFirstTransID);
					}
					//getDynamicElementClick(eppTransactionIDList, "Work Summary List", pendingOutgoingRecallReqTransList, transactionID);
					validateTextContains(eppTransactionIDList, "Outgoing Recall TransactionID", outgoingRecallReqReason, "RECALL");
					waitElement(8000);
					stepResult = true;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application", "TransactionID Selected Successfully from Pending Outgoing Recall Request ","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application","Could not Select TransactionID Successfully from Pending Outgoing Recall Request", "Failed", driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
