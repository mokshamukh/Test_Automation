package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_CurrentPaymentActivity
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_CurrentPaymentActivity extends CommonLibrary {

	String dropdown = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td[contains(@class,'edit-splitter')]//i[text()='expand_more']";
	String cancelButton = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td[contains(@class,'edit-splitter')]//i[text()='close']";
	By paymentActivityTitle = By.xpath("//h3[contains(text(),'Current Activity Summary')]");
	By cancelWarningMsg = By.xpath("//p[contains(text(),'Are you sure that you want to cancel payment')]");
	By approveWarningMsg = By.xpath("//p[contains(text(),'Are you sure you want to approve payment ')]");
	By searchButton = By.xpath("//button[@aria-label='Search']");
	By typeDropArrow = By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[2]");
	By transactionNumField = By.xpath("//input[@id='transactionNumberdesk']");
	By statusDopArrow = By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[3]");
	By nameField = By.xpath("//input[@id='transactionNamedesk']");
	By amountField = By.xpath("//input[@id='transactionAmountdesk']");
	By searchSymbol = By.xpath("//button[@type='submit']/i");
	String warningButton = "//button[text()='%s']";
	String approveButton = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td[contains(@class,'edit-splitter')]//i[text()='check']";
	String fromAcc_field = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[@aria-label='From Account']/../span";
	String toAcc_field = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[@aria-label='To Account']/../span";
	String initiator_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[text()='Initiator']/../span";
	String transferDate_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../..//td[2]";
	String typeList = "//li[@class='ui-dropdown-item ui-corner-all']/span[text()='%s']";
	String statusList = "//li[contains(@class,'ui-dropdown-item ui-corner-all')]/span[contains(text(),'%s')]";
	String amount_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/div)[1]";
	String status_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span";
	Corporate_AccountTransferDetails corporateAccountTransferDetails;
	static String transactionID; 
	public Corporate_CurrentPaymentActivity(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		corporateAccountTransferDetails = new Corporate_AccountTransferDetails(driver);
	}

	//cancel By user
	public void clickCancelButton(String transactionID,String warningButtonVal) {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(paymentActivityTitle)) {
				Thread.sleep(2000);
				clickOnElement("Corporate Current Payment Activity", "Dropdown",
						getDynamicElement("dropdown", dropdown, transactionID));
				clickOnElement("Corporate Current Payment Activity", "Cancel Button",
						getDynamicElement("Cancel Button", cancelButton, transactionID));
				if(isElementPresent(cancelWarningMsg)){
					clickOnElement("Corporate Current Payment Activity", "Warning Message", getDynamicElement("Warning Message", warningButton, warningButtonVal));
					Thread.sleep(4000);
					verifyCancelPaymentMessage(transactionID);
				}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass -Current Payment Activity - Cancel button");
			else
				System.out.println("fail");
		}
	}
	
	//cancel By user
	public void verifyCancelPaymentMessage(String transactionID) {
		boolean stepResult = false;
		try {
			String cancelPaymentMsg = "//div[text()='The payment "+transactionID+" has been successfully canceled.']";
			isElementPresent(returnByElement("Cancel Payment alert Msg", cancelPaymentMsg));
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass -Current Payment Activity - Cancel Payment Msg");
			else
				System.out.println("fail");
		}
	}
	
	public void viewCurretPaymentDetails(String date,String transactionID,String amount, String status,String fromAccount,String toAccount,String initiator){
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(paymentActivityTitle)) {
				if(!date.equals("")){
				validateTextContains("Corporate Current Payment Activity", "Date", getDynamicElement("Date", transferDate_field, transactionID), date);
				}
				if(!amount.equals("")){
					validateTextContains("Corporate Current Payment Activity", "Amount", getDynamicElement("Amount", amount_field, transactionID), amount);
				}
				if(!status.equals("")){
					validateTextContains("Corporate Current Payment Activity", "Status", getDynamicElement("Status", status_field, transactionID), status);
					
				}
				if(!fromAccount.equals("")){
					validateTextContains("Corporate Current Payment Activity", "From Account", getDynamicElement("From Account", fromAcc_field, transactionID), fromAccount);
					}
				if(!toAccount.equals("")){
					validateTextContains("Corporate Current Payment Activity", "To Account", getDynamicElement("To Account", toAcc_field, transactionID), toAccount);
					}
				if(!initiator.equals("")){
					validateTextContains("Corporate Current Payment Activity", "Initiator", getDynamicElement("Initiator", initiator_field, transactionID), initiator);
					}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass -Current Payment Activity - validate transactions");
			else
				System.out.println("fail");
		}

		
	}
	
	public void clickApproveButton(String transactionID,String approveButtonVal) {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(paymentActivityTitle)) {
				Thread.sleep(2000);
				clickOnElement("Corporate Current Payment Activity", "Approve Button",
						getDynamicElement("Approve Button", approveButton, transactionID));
				if(isElementPresent(approveWarningMsg)){
					clickOnElement("Corporate Current Payment Activity", "Warning Message", getDynamicElement("Warning Message", warningButton, approveButtonVal));
					Thread.sleep(4000);
					verifyApprovePaymentMessage(transactionID);
				}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass -Current Payment Activity - Approve button");
			else
				System.out.println("fail");
		}
	}
	
	public void verifyApprovePaymentMessage(String transactionID) {
		boolean stepResult = false;
		try {
			String approvePaymentMsg = "//div[text()='Payment "+transactionID+" successfully approved.']";
			isElementPresent(returnByElement("Cancel Payment alert Msg", approvePaymentMsg));
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass -Current Payment Activity - Approve Payment Msg");
			new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
					"Approve payment Msg Successfully", "Passed", driver, "Y");}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
						"Could not approve payment msg Successfully", "Failed", driver, "Y");}
		}
	}
	
	public void filterCurrentActivityDetails(String typeVal, String transNum, String status, String nameVal, String amtVal){
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(paymentActivityTitle)) {
				clickOnElement("Current Payment Activity", "Search Button", searchButton);
				if (!typeVal.equals("")) {
					selectElementFromListbox("Current Payment Activity", "Type List", typeDropArrow, typeList,typeVal);
				}
				if (!transNum.equals("")) {
					enterText("Current Payment Activity", "Transaction Number Field", transactionNumField, transNum);
				}
				if (!status.equals("")) {
					selectElementFromListbox("Current Payment Activity", "Status List", statusDopArrow,
							statusList, status);
				}
				if (!nameVal.equals("")) {
					enterText("Current Payment Activity", "Name Field", nameField, nameVal);
				}
				if (!amtVal.equals("")) {
					enterText("Current Payment Activity", "Amount Field", amountField, amtVal);
				}
				clickOnElement("Current Payment Activity", "Search Symbol", searchSymbol);
				Thread.sleep(5000);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Current Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
						"Filter transactions Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
						"Could not Filter transactions Successfully", "Failed", driver, "Y");
			}
		}
	}
	
}

