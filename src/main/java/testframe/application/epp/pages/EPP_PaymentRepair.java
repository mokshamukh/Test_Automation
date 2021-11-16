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

	EPP_ActionPrompts eppActionPrompts;
	static String actionOntransactionID;
	static String transactionIDWithAction;
	
	public EPP_PaymentRepair(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppActionPrompts = new EPP_ActionPrompts(driver);
	}
	
	
	By title = By.xpath("//div[@id='headerBar']//td[contains(text(),'Work Summary')]");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By amountTxtBox = By.xpath("//input[@id='Amount']");
	By repairPaymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Repair Payment')]");
	By paymentActionButton = By.xpath("//select[@id='ActionSelect']");
    By cancelPaymentRepair = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Cancel Payment')]");
    By executeButton = By.xpath("//div[@id='img_button_execute']");	
    By validateSubmitBtn = By.xpath("//div[@id='img_button_validate&Submit']");
    By filterBanner = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Payment sent to repair from Internal Filter')]");
    By validateBttn = By.xpath("//a[@id='Validate']");
	By abanbonBttn = By.xpath("//a[@id='Abandon']");
	By confirmWindow = By.xpath("//div[@id='confirmWindow']");
	By submitPayment = By.xpath("//input[@id='SubmitPayment']");
	By cancelBtn = By.xpath("//input[@id='Cancel']");
		
	
	public String eppPaymentRepair = "EPP_PaymentRepair";
	public String actionOntransactionIdList = "//div[@id='Refresh_MEPaymentRepair']//a[@class='linkGeneral'][text()='%s']";
	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";

	
	public void selectPaymentRepair(String updatedAmount) throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPaymentRepair, "Work Summary List", title);
			if (isElementPresent(title)) {
				String transID = eppActionPrompts.getTransactionIDOnAction();
				getDynamicElementClick(eppPaymentRepair, "Work Summary List", actionOntransactionIdList, transID);
				waitElement(2000);
				waitForPresenceOfElement(eppPaymentRepair, "Filter", filterBanner);
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
	
	
}
