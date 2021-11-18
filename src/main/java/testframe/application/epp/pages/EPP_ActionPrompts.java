package testframe.application.epp.pages;
/**
 * PageName : EPP_ActionPrompts
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_ActionPrompts extends CommonLibrary{
	
	static String transactionIDWithAction;
	static String actionOntransactionID;
	
	public EPP_ActionPrompts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String eppActionPrompts = "EPP_ActionPrompts";
	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";
	
	By actionPrompts = By.xpath("//div[@id='headerBar']//td[contains(text(),'Action Prompts')]");
	By cancelPaymentTxtBox = By.xpath("//form[@name='paymentActionForm']//td[contains(text(),'Additional Comments:')]//..//*[@name='CancelPaymentReason']");
	By cancelByBankBtn = By.xpath("//input[@name='CancelInitiator'][@value='BANK']");
	By cancelByCustBtn = By.xpath("//input[@name='CancelInitiator'][@value='CUST']");
	By submitButton = By.xpath("//div[@id='img_button_submit']");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By releaseReason = By.xpath("//form[@name='paymentActionForm']//td[contains(text(),'Release Reason:')]//..//*[@name='ReleasePaymentReason']"); 
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By repairReason = By.xpath("//input[@name='RepairPaymentReason']");
	
	
	public void performActionForCancelPayment(String cancelInitiator) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(actionPrompts)) {
			 enterText(eppActionPrompts, "Additional Comments", cancelPaymentTxtBox, "Testing");
			 if(cancelInitiator.equals("BANK")) {
				 clickOnElement(eppActionPrompts, "Cancel Initiator", cancelByBankBtn);
			 }else {
				 clickOnElement(eppActionPrompts, "Cancel Initiator", cancelByCustBtn);
			 }
		}
			clickOnElement(eppActionPrompts, "Submit Button", submitButton);
			waitElement(4000);
			if (isElementPresent(transIdSaved)) {
				actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
				System.out.println(actionOntransactionID);
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
			    new HTMLReportHelper().HtmlReportBody(" EPP - EPP application", "Transaction Cancelled Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody(" EPP - EPP application","Could not Cancel Transaction Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
	public String getTransactionIDOnAction() {
		boolean stepResult = false;
		try {
			if (!(actionOntransactionID == null)) {
				transactionIDWithAction = actionOntransactionID;
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass");
			else
				System.out.println("fail");
		}
		return transactionIDWithAction;

	}
	
	
	public void VerifyAndPerformActionForReleaseHold() throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(actionPrompts)) {
				enterText(eppActionPrompts, "Additional Comments", releaseReason, "Testing");
				clickOnElement(eppActionPrompts, "Submit Button", submitButton);
				waitElement(4000);
				if (isElementPresent(transIdSaved)) {
					actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
				}
			}
			clickOnElement(eppActionPrompts, "Action saved Successfully", transIdSaved);
			if(isElementPresent(transactionStatus)) {
			validateElementPresent(eppActionPrompts, "Transaction Status", transactionStatus);
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
			    new HTMLReportHelper().HtmlReportBody(" EPP - EPP application", "Release Transaction Completed Successfully","Passed", driver, "Y");
						} else {
							System.out.println("fail");
							new HTMLReportHelper().HtmlReportBody(" EPP - EPP application","Could not Complete Release Transaction", "Failed", driver, "Y");
						}			}
		}
	
	
	public void VerifyAndPerformPaymentRepair(String commentTxtBox,String cancelInitiator) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(actionPrompts)) {
			 enterText(eppActionPrompts, "Additional Comments", cancelPaymentTxtBox, commentTxtBox);
			 if(cancelInitiator.equals("BANK")) {
				 clickOnElement(eppActionPrompts, "Cancel Initiator", cancelByBankBtn);
			 }else {
				 clickOnElement(eppActionPrompts, "Cancel Initiator", cancelByCustBtn);
			 }
		}
			clickOnElement(eppActionPrompts, "Submit Button", submitButton);
			waitElement(6000);
			if (isElementPresent(transIdSaved)) {
				actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
			    new HTMLReportHelper().HtmlReportBody(" EPP - EPP application", "Transaction Completed Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody(" EPP - EPP application","Could not Completed Transaction", "Failed", driver, "Y");
			}
		}
	}
	
	
	public void performActionForRepairPayment(String commentTxtBox) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(actionPrompts)) {
			 enterText(eppActionPrompts, "Additional Comments", repairReason, commentTxtBox);
			clickOnElement(eppActionPrompts, "Submit Button", submitButton);
			waitElement(4000);
			if (isElementPresent(transIdSaved)) {
				actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
			}
		}
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("mainmenu");
			waitElement(3000);
			getDynamicElementClick(eppActionPrompts, "Menu Selected", menuOPtion, "Payment Tracking");
			getDynamicElementClick(eppActionPrompts, "SubMenu Selected", subMenuOption, "Work Summary");
			waitElement(5000);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
			    new HTMLReportHelper().HtmlReportBody(" EPP - EPP application", "Performed Action Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody(" EPP - EPP application","Could not Perform Action Successfully", "Failed", driver, "Y");
			}
		}
	}
	
}

