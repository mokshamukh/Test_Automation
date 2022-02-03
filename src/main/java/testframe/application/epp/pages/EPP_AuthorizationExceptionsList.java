package testframe.application.epp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_AuthorizationExceptionsList extends CommonLibrary{
	
	EPP_CreatePayment eppCreatePayment;
	EPP_ActionPrompts eppActionPrompts;
	static String firstTransID;
	
	public EPP_AuthorizationExceptionsList(WebDriver driver) {
		super(driver);
		this.driver = driver;
		eppCreatePayment = new EPP_CreatePayment(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		// TODO Auto-generated constructor stub
	}
	

	public String eppAuthorizationExceptions = "EPP_AuthorizationExceptionsList";
	//*********************************
	public String transactionIdList = "//div[@id='']//a[@class='linkGeneral'][text()='%s']";
	
	
	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");
//	***************************************************
	By firstPaymentActionID = By.xpath("//div[@id='']//a[@class='linkGeneral']");
	public String transactionIdAEList = "//a[@class='linkGeneral'][text()='%s']";
	By firstAETransactionID = By.xpath("//a[@class='linkGeneral']");
	
	public void selectAuthorizationExceptionsTransID(String strTransID) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppAuthorizationExceptions, "Work Summary List", title);
				if(isElementPresent(title)){
					String transactionID = eppCreatePayment.getTransactionID();
					//String transactionID_Act = eppActionPrompts.getTransactionIDOnAction();
					if(!strTransID.equals("")){
						getDynamicElementClick(eppAuthorizationExceptions, "Transaction ID List", transactionIdAEList, strTransID);
					}else{
						if(!(transactionID==null)) {
							getDynamicElementClick(eppAuthorizationExceptions, "Transaction ID List", transactionIdAEList, transactionID);
							
						}
						else {
							String firstTransID = getElementText(eppAuthorizationExceptions, "First Authorization Exceptions Transaction ID", firstAETransactionID);
							eppCreatePayment.setTransactionID(firstTransID);
							clickOnElement(eppAuthorizationExceptions, "First Authorization Exceptions Transaction ID", firstAETransactionID);
						}
						waitElement(2000);
					}
					//String transactionID = eppCreatePayment.getTransactionID();

					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application", "TransactionID Selected Successfully from Payment Action Verification","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("TransactionID List EPP - EPP application","Could not Select TransactionID Successfully from Payment Action Verification", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}
	
	
	
	
}
