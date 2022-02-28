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
	static String firstTransID;



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
	By limitINFilter = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Internal Filter')]");
	By limitBIFilter = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'BI filter')]");
	By validateBttn = By.xpath("//a[@id='Validate']");
	By abanbonBttn = By.xpath("//a[@id='Abandon']");
	By confirmWindow = By.xpath("//div[@id='confirmWindow']");
	By submitPayment = By.xpath("//input[@id='SubmitPayment']");
	By cancelBtn = By.xpath("//input[@id='Cancel']");
	By valuedate = By.xpath("//input[@id='Value_Date']");
	By actionPrompts = By.xpath("//div[@id='headerBar']//td[contains(text(),'Action Prompts')]");
	By paymentRepairFisrtTransID = By.xpath("//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral']");	

	public String eppPaymentRepair = "EPP_PaymentRepair";
	//public String actionOntransactionIdList = "//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral'][text()='%s']";
	public String transactionIdList = "//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral'][text()='%s']";
	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";



	public void selectPaymentRepair(String updatedAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
				if (isElementPresent(title)) {
					String transID = eppActionPrompts.getTransactionIDOnAction();
					//String transID = "201300000509";
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
					new HTMLReportHelper().HtmlReportBody("Payment Repair", "Payment submitted Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Repair","Could not submit payment", "Failed", driver,"Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}



	public void validateAndApproveBIPaymentRepair(String updatedAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Payment Repair", "Payment repaired Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Repair","Could not repair payment", "Failed", driver,"Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void validateAndCancelBIPaymentRepair(String valueDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Cancel Payment Repair", "Repair Payment cancelled Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Cancel Payment Repair","Could not cancel Repair Payment", "Failed", driver,"Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void validateAndApproveINPaymentRepair(String updatedAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPaymentRepair, "Filter", limitINFilter);
				if (isElementPresent(repairPaymentTitle)) {
					clearAndType(eppPaymentRepair, "Amount", amountTxtBox, updatedAmount);
					waitElement(3000);
					clickOnElement(eppPaymentRepair, "Validate Button", validateBttn);
					waitElement(3000);
					waitForPresenceOfElement(eppPaymentRepair, "Validation Successfull Window", confirmWindow);
					waitElement(3000);
					clickOnElement(eppPaymentRepair, "Submit Payment Button", submitPayment);
					waitElement(5000);
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
					new HTMLReportHelper().HtmlReportBody("Repair and Verify payment", "Payment Repaired and Verified payment Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Repair and Verify payment","Could not Repair and Verify payment", "Failed", driver,"Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void selectTransIDFromPaymentRepair(String strTransID) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
				if (isElementPresent(title)) {
					if(!strTransID.equals("")){
						getDynamicElementClick(eppPaymentRepair, "Work Summary List", transactionIdList, strTransID);
					}
					else{
						String transactionID = eppCreatePayment.getTransactionID();
						if(!(transactionID==null)) {
							getDynamicElementClick(eppPaymentRepair, "Work Summary List", transactionIdList, transactionID);
						}else {
							String firstTransID = getElementText(eppPaymentDetails, "First Internal Transaction ID", paymentRepairFisrtTransID);
							eppCreatePayment.setTransactionID(firstTransID);
							clickOnElement(eppPaymentRepair, "First Transaction ID", paymentRepairFisrtTransID);
						}
					}
					waitElement(8000);
					//waitForPresenceOfElement(eppPaymentRepair, "Filter", limitINFilter);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Transaction from list",
							"Transaction Selected Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Transaction from list",
							"Could not select Transaction ", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAndCancelINPaymentRepair(String valueDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
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
					new HTMLReportHelper().HtmlReportBody("Cancel Payment", "Payment cancelled uccessfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Cancel Payment","Could not Cancel Payment", "Failed", driver,"Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
