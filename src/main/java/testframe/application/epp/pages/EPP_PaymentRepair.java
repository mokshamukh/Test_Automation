package testframe.application.epp.pages;
/**
 * PageName : EPP_PaymentRepair
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;


public class EPP_PaymentRepair extends CommonLibrary{

	EPP_CreatePayment eppCreatePayment;
	EPP_ActionPrompts eppActionPrompts;
	
	
	
	public EPP_PaymentRepair(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
		eppActionPrompts = new EPP_ActionPrompts(driver);
	}
	
	public String eppPaymentDetails = "EPP_PaymentDetails";
	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By amountTxtBox = By.xpath("//input[@id='Amount']");
	By repairPaymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Repair Payment')]");
	By paymentActionButton = By.xpath("//select[@id='ActionSelect']");
    By cancelPaymentRepair = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Cancel Payment')]");
    By executeButton = By.xpath("//div[@id='img_button_execute']");	
    By validateSubmitBtn = By.xpath("//div[@id='img_button_validate&Submit']");
    By limitINFilter = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Payment sent to repair from Internal Filter')]");
    By limitBIFilter = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Payment sent to Repair from BI filter')]");
    By validateBttn = By.xpath("//a[@id='Validate']");
	By abanbonBttn = By.xpath("//a[@id='Abandon']");
	By confirmWindow = By.xpath("//div[@id='confirmWindow']");
	By submitPayment = By.xpath("//input[@id='SubmitPayment']");
	By cancelBtn = By.xpath("//input[@id='Cancel']");
	By valuedate = By.xpath("//input[@id='Value_Date']");
	By actionPrompts = By.xpath("//div[@id='headerBar']//td[contains(text(),'Action Prompts')]");
		
	
	public String eppPaymentRepair = "EPP_PaymentRepair";
	//public String actionOntransactionIdList = "//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral'][text()='%s']";
	public String transactionIdList = "//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral'][text()='%s']";
	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";

	
	
	public void selectPaymentRepair(String updatedAmount) throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
			if (isElementPresent(title)) {
				String transID = eppActionPrompts.getTransactionIDOnAction();
				getDynamicElementClick(eppPaymentRepair, "Work Summary List", transactionIdList, transID);
				waitElement(2000);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Amount", amountTxtBox, updatedAmount);
					waitElement(3000);
					clickOnElement(eppPaymentRepair, "Validate Button", validateBttn);
					waitElement(8000);
					waitForPresenceOfElement(eppPaymentRepair, "Validation Successfull Window", confirmWindow);
					waitElement(5000);
					clickOnElement(eppPaymentRepair, "Submit Payment Button", submitPayment);
					waitElement(20000);
					//driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					waitForPresenceOfElement(eppPaymentRepair, "Payment Saved with Transaction", transIdSaved);
					stepResult = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application", "Payment Saved with TransactionID Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				 new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application","Could not save Payment TransactionID Successfully", "Failed", driver,"Y");
			}
		}

	}
	
	
	
	public void validateAndApproveBIPaymentRepair(String updatedAmount) throws Exception {
		boolean stepResult = false;
		try {
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitBIFilter);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Amount", amountTxtBox, updatedAmount);
					waitElement(3000);
					clickOnElement(eppPaymentRepair, "Validate Button", validateBttn);
					waitElement(8000);
					waitForPresenceOfElement(eppPaymentRepair, "Validation Successfull Window", confirmWindow);
					waitElement(5000);
					clickOnElement(eppPaymentRepair, "Submit Payment Button", submitPayment);
					waitElement(20000);
					//driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					waitForPresenceOfElement(eppPaymentRepair, "Payment Saved with Transaction", transIdSaved);
					stepResult = true;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application", "Payment Saved with TransactionID Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				 new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application","Could not save Payment TransactionID Successfully", "Failed", driver,"Y");
			}
		}
	}
	
	
	public void validateAndCancelBIPaymentRepair(String valueDate) throws Exception {
		boolean stepResult = false;
		try {
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitBIFilter);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Value Date", valuedate, valueDate);
					waitElement(3000);
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					waitElement(1000);
					clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
					waitElement(5000);
					waitForPresenceOfElement(eppPaymentDetails, "Action Prompt", actionPrompts);
					stepResult = true;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application", "Payment Saved with TransactionID Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				 new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application","Could not save Payment TransactionID Successfully", "Failed", driver,"Y");
			}
		}

	}
	
	public void validateAndApproveINPaymentRepair(String updatedAmount) throws Exception {
		boolean stepResult = false;
		try {
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitINFilter);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Amount", amountTxtBox, updatedAmount);
					waitElement(3000);
					clickOnElement(eppPaymentRepair, "Validate Button", validateBttn);
					waitElement(8000);
					waitForPresenceOfElement(eppPaymentRepair, "Validation Successfull Window", confirmWindow);
					waitElement(5000);
					clickOnElement(eppPaymentRepair, "Submit Payment Button", submitPayment);
					waitElement(20000);
					//driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					waitForPresenceOfElement(eppPaymentRepair, "Payment Saved with Transaction", transIdSaved);
					stepResult = true;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application", "Payment Saved with TransactionID Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				 new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application","Could not save Payment TransactionID Successfully", "Failed", driver,"Y");
			}
		}

	}
	
	public void selectTransIDFromPaymentRepair() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
			if (isElementPresent(title)) {
				String transactionID = eppCreatePayment.getTransactionID();
				getDynamicElementClick(eppPaymentRepair, "Work Summary List", transactionIdList, transactionID);
				waitElement(8000);
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitINFilter);
				stepResult = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application",
						"TransactionID Successfully Selected", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application",
						"Could not select TransactionID ", "Failed", driver, "Y");
			}
		}
	}

	public void validateAndCancelINPaymentRepair(String valueDate) throws Exception {
		boolean stepResult = false;
		try {
//			waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
//			if (isElementPresent(title)) {
//				String transactionID = eppCreatePayment.getTransactionID();
//				getDynamicElementClick(eppPaymentRepair, "Work Summary List", transactionIdList, transactionID);
//				waitElement(8000);
//			}
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitINFilter);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Value Date", valuedate, valueDate);
					waitElement(3000);
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					waitElement(1000);
					clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
					waitElement(5000);
					waitForPresenceOfElement(eppPaymentDetails, "Action Prompt", actionPrompts);
					stepResult = true;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application", "Payment Saved with TransactionID Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				 new HTMLReportHelper().HtmlReportBody("Payment Repair EPP - EPP application","Could not save Payment TransactionID Successfully", "Failed", driver,"Y");
			}
		}

	}
	
}
