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
	
	int longWait = 180;
	By actionPrompts = By.xpath("//div[@id='headerBar']//td[contains(text(),'Action Prompts')]");
	By cancelPaymentTxtBox = By.xpath("//form[@name='paymentActionForm']//td[contains(text(),'Additional Comments:')]//..//*[@name='CancelPaymentReason']");
	By cancelByBankBtn = By.xpath("//input[@name='CancelInitiator'][@value='BANK']");
	By cancelByCustBtn = By.xpath("//input[@name='CancelInitiator'][@value='CUST']");
	By submitButton = By.xpath("//a[@id='Submit']");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By internalFilterAction = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD'][contains(text(),'The action was executed successfully')]");
	By businessFilterAction = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD'][contains(text(),'The action was executed successfully')]");
	By releaseReason = By.xpath("//form[@name='paymentActionForm']//td[contains(text(),'Release Reason:')]//..//*[@name='ReleasePaymentReason']"); 
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By repairReason = By.xpath("//input[@name='RepairPaymentReason']");
	By noteComments = By.xpath("//textarea[@name='Note']");
	By recallComments = By.xpath("//textarea[@name='RecallPaymentReason']");
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By recallTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Awaiting Approval')]");
	By recallBannerMsg = By.xpath("//p[contains(text(),' This transaction has been submitted for approval following recalled  with Reason:')]");
	By repairReasonSelect = By.xpath("//select[@name='RepairPaymentReasonText']");//Amend Amount/Currency
	By releaseReasonNote = By.xpath("//textarea[@name='Note']");
	By backLink = By.xpath("//div[@class='titleBarBackButton']/a");

	public void performActionForCancelPayment(String cancelInitiator) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
				if (isElementPresentZeroWait(transIdSaved)) {
					actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
					System.out.println(actionOntransactionID);
				}
				if(isElementPresentZeroWait(paymentTitle)){
					clickOnElement(eppActionPrompts, "Back Link",backLink);
					/*switchToWindowWithTitleContaining("Enterprise Payments Platform");
					driver.switchTo().frame("mainmenu");
					waitElement(1500);
					getDynamicElementClick(eppActionPrompts, "Menu Selected", menuOPtion, "Payment Tracking");
					getDynamicElementClick(eppActionPrompts, "SubMenu Selected", subMenuOption, "Work Summary");
					waitElement(2500);*/
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on Payment", "The action for Cancelled payment executed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on Payment","Could not execute action for Cancel payment", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
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
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(actionPrompts)) {
					enterText(eppActionPrompts, "Additional Comments", releaseReason, "Testing");
					clickOnElement(eppActionPrompts, "Submit Button", submitButton);
					waitElement(1500);
					if (isElementPresent(transIdSaved)) {
						actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
					}
				}
				clickOnElement(eppActionPrompts, "Action saved Successfully", transIdSaved);
				waitForPresenceOfElementTillTime(eppActionPrompts, "Transaction Status", transactionStatus,longWait);
				validateElementPresent(eppActionPrompts, "Transaction Status", transactionStatus);
				
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on transaction", "The action for Release Transaction executed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on transaction","Could not execute the action for Release Transaction", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}		
			}
		}
	}


	public void VerifyAndPerformPaymentRepair(String commentTxtBox,String cancelInitiator) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Action on transaction", "The execute action on transaction completed successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on transaction","Could not execute action on Transaction", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void performActionForRepairPayment(String commentTxtBox) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Action on transaction", "Action Performed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on transaction","Could not Perform Action Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyAndSubmitINFilterAction() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(actionPrompts)) {
					if(isElementPresentZeroWait(By.xpath("//select[@name='FilterKeysList']//option[contains(.,'IFlimit')]")))
						driver.findElement(By.xpath("//select[@name='FilterKeysList']//option[contains(.,'IFlimit')]")).click();
					else if(isElementPresentZeroWait(By.xpath("//select[@name='FilterKeysList']//option[1]")))
						driver.findElement(By.xpath("//select[@name='FilterKeysList']//option[1]")).click();
					clickOnElement(eppActionPrompts, "Submit Button", submitButton);
					waitElement(2000);
					if(isElementPresent(internalFilterAction)) 
						stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on transaction", "The action on Internal Filter Performed  Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on transaction","Could not Perform Action on Internal Filter Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyAndSubmitBIFilterAction() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(actionPrompts)) {
					enterText(eppActionPrompts, "Note", noteComments, "Test");
					clickOnElement(eppActionPrompts, "Submit Button", submitButton);
					waitElement(5000);
					isElementPresent(transIdSaved);
					//clickOnElement(eppActionPrompts, "Action Executed Successfully", transIdSaved);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Submit Payment", "The payment in Business Filter pool submitted Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Submit Payment","Could not submit payment in Business Filter pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void performActionForINFilterCancelPayment(String cancelInitiator) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
				isElementPresent(internalFilterAction);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on Payment", "The action for Cancel payment in Internal Filter executed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on Payment","Could not execute action for Cancel payment in Internal Filter", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void performActionOnRecallPayment() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(actionPrompts)) {
					driver.findElement(By.xpath("//select[@id='RecallInitiator']//option[contains(.,'Customer')]")).click();
					waitElement(1000);
					driver.findElement(By.xpath("//select[@id='RecallPaymentReasonCode']//option[contains(.,'RECALL')]")).click();
					enterText(eppActionPrompts, "Additional Comments on Recall Payment", recallComments, "Testing");
					clickOnElement(eppActionPrompts, "Submit Button", submitButton);
					waitElement(5000);
					if(isElementPresent(recallBannerMsg)) {
						validateElementExist(eppActionPrompts, "Transaction Status", recallTransStatus,
								"Awaiting Approval");
						stepResult = true;
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on Transaction", "The action for Recall Payment executed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on Transaction","Could not execute action for Recall Payment Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void VerifyAndPerformActionForRelease(String sReleaseReason) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(actionPrompts)) {
					if(isElementPresentZeroWait(releaseReason))
						enterText(eppActionPrompts, "Additional Comments", releaseReason, sReleaseReason);
					else if(isElementPresentZeroWait(releaseReasonNote))
						enterText(eppActionPrompts, "Additional Comments", releaseReasonNote, sReleaseReason);
					clickOnElement(eppActionPrompts, "Submit Button", submitButton);
					waitElement(1500);
					if (isElementPresentZeroWait(transIdSaved)) {
						actionOntransactionID = getElementText(eppActionPrompts, "Transaction ID", transIdSaved);
						clickOnElement(eppActionPrompts, "Action saved Successfully", transIdSaved);
						if(isElementPresentZeroWait(transactionStatus)) {
							validateElementPresent(eppActionPrompts, "Transaction Status", transactionStatus);
						}
					}

					if(isElementPresentZeroWait(paymentTitle)){
						clickOnElement(eppActionPrompts, "Back Link",backLink);
					/*switchToWindowWithTitleContaining("Enterprise Payments Platform");
					driver.switchTo().frame("mainmenu");
					waitElement(1500);
					getDynamicElementClick(eppActionPrompts, "Menu Selected", menuOPtion, "Payment Tracking");
					getDynamicElementClick(eppActionPrompts, "SubMenu Selected", subMenuOption, "Work Summary");
					waitElement(2500);	
					 */		
					}
					stepResult = true;
				}


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Action on Payment", "The action for Release Transaction executed Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Action on Payment","Could not execute the action for Release Transaction", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}		
			}
		}
	}


}

