package testframe.application.epp.pages;
/**
 * PageName : EPP_Templates
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_Templates extends CommonLibrary{

	public EPP_Templates(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppPoolOptions = "EPP Templates";
	public String poolTemplateOptions = "//a[text()='%s']";
	public String blockName = "//div[@id='headerBar']//table//td[contains(text(),'%s')]";


	By manualPayment = By.xpath("//h2[text()='Manual Payments']");
	By paymentTemplate = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Payment Template')]");
	By workSummary = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Work Summary')]");
	By outgoingBankFRB = By.xpath("//a[text()='Outgoing High Value Bank Payment (FRB)']");
	By outgoingCustFRB = By.xpath("//a[text()='Outgoing High Value Customer Payment (FRB)']");
	By incomingCustFRB = By.xpath("//a[text()='Incoming High Value Customer Payment (FRB)']");
	By incomingBankFRB = By.xpath("//a[text()='Incoming High Value Bank Payment (FRB)']");
	By paymentCreationVerificationOption = By.xpath("//a[text()='Payment Creation Verification']");
	By paymentActionVerificationOption = By.xpath("//a[text()='Payment Action Verification']");
	By paymentRepair = By.xpath("//a[text()='Payment Repair']");
	By duplicatePayment = By.xpath("//a[text()='Duplicate Payments']");
	By paymentRepairVerification = By.xpath("//a[text()='Payment Repair Verification']");
	By internalFilter = By.xpath("//a[text()='Internal Filter']");
	By notification = By.xpath("//a[text()='Notification']");	
	By pendingOutgoingRecallReq = By.xpath("//a[text()='Pending Outgoing Recall Requests Pool']");
	By authorizationExceptions = By.xpath("//a[text()='Authorization Exceptions']");
	String workSummaryPool = "//a[text()='%s']";
	By recordDropdown = By.xpath("//select[@name='start2']");

	public void selectTemplate(String blockHeaderName,String poolValue) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				getDynamicElement("Template",blockName,blockHeaderName); 
				waitForPresenceOfElement(eppPoolOptions, "Template", getDynamicElement("Template",poolTemplateOptions, poolValue));
				getDynamicElementClick(eppPoolOptions, "Template", poolTemplateOptions, poolValue);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("'" + poolValue +"' template", "Successfully clicked on '" + poolValue +"' template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("'" + poolValue +"' template", "Could not clicked on '" + poolValue +"' template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyPaymentCreationPool() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				isElementPresent(paymentTemplate);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Verify Payment template", "Successfully Verified Payment template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify Payment template", "Could not verify Payment template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyWorkSummaryPool() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				isElementPresent(workSummary);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Verify Work Summary template", "Successfully verified Work Summary template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify Work Summary template", "Could not verified Work Summary template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectOutgoingHVBankPaymentFRBOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", outgoingBankFRB);
				clickOnElement(eppPoolOptions, "Pool Value", outgoingBankFRB);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Outgoing High Value Bank Payment (FRB) template", "Successfully clicked on Outgoing High Value Bank Payment (FRB) template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Outgoing High Value Bank Payment (FRB) template", "Could not clicked on Outgoing High Value Bank Payment (FRB) template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectOutgoingHVCustomerPaymentFRBOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", outgoingCustFRB);
				clickOnElement(eppPoolOptions, "Pool Value", outgoingCustFRB);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Outgoing High Value Customer Payment (FRB) template", "Successfully clicked on Outgoing High Value Customer Payment (FRB) template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Outgoing High Value Customer Payment (FRB) template", "Could not clicked on Outgoing High Value Customer Payment (FRB) template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectIncomingHVCustomerPaymentFRBOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", incomingCustFRB);
				clickOnElement(eppPoolOptions, "Pool Value", incomingCustFRB);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Pool option Outgoing High Value Customer Payment (FRB) template", "Successfully clicked on Outgoing High Value Customer Payment (FRB) template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Pool option Outgoing High Value Customer Payment (FRB) template", "Could not clicked on Outgoing High Value Customer Payment (FRB) template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectIncomingHVBankPaymentFRBOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", incomingBankFRB);
				clickOnElement(eppPoolOptions, "Pool Value", incomingBankFRB);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Incoming High Value Customer Payment (FRB) template", "Successfully clicked on Incoming High Value Customer Payment (FRB) template", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Incoming High Value Customer Payment (FRB) template", "Could not clicked on Incoming High Value Customer Payment (FRB) template", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectDuplicatePaymentOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", duplicatePayment);
				clickOnElement(eppPoolOptions, "Pool Value", duplicatePayment);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Duplicate Payment Pool", "Successfully clicked on Duplicate Payment pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Duplicate Payment Pool", "Could not clicked on Duplicate Payment pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectPaymentActionVerificationOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentActionVerificationOption);
				clickOnElement(eppPoolOptions, "Pool Value", paymentActionVerificationOption);
				Thread.sleep(4000);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Action Verification Pool", "Successfully clicked on Payment Action Verification pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Action Verification Pool", "Could not clicked on Payment Action Verification pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectPaymentCreationVerificationOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentCreationVerificationOption);
				clickOnElement(eppPoolOptions, "Pool Value", paymentCreationVerificationOption);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Creation Verification Pool", "Successfully clicked on Payment Creation Verification pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Creation Verification Pool", "Could not clicked on Payment Creation Verification pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectPaymentRepairOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentRepair);
				clickOnElement(eppPoolOptions, "Pool Value", paymentRepair);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Repair pool", "Successfully clicked on Payment Repair pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Repair pool", "Could not clicked on Payment Repair pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public void selectPaymentRepairVerificationOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				//Thread.sleep(4000);
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentRepairVerification);
				clickOnElement(eppPoolOptions, "Pool Value", paymentRepairVerification);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Repair Verification pool", "Successfully clicked on Payment Repair Verification pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Repair Verification pool", "Could not clicked on Payment Repair Verification pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectInternalFilterOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", internalFilter);
				clickOnElement(eppPoolOptions, "Pool Value", internalFilter);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Pool option Internal Filter", "Successfully clicked on Internal Filter", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Pool option Internal Filter", "Could not clicked on Internal Filter", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectNotificationPoolOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", notification);
				clickOnElement(eppPoolOptions, "Pool Value", notification);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Pool option Notification", "Successfully clicked on Notification", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Pool option Notification", "Could not clicked on Notification", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectPendingOutgoingRequestPoolOption() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", pendingOutgoingRecallReq);
				clickOnElement(eppPoolOptions, "Pool Value", pendingOutgoingRecallReq);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Pending Outgoing Recall Requests Pool", "Successfully clicked on Pending Outgoing Recall Request pool", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Pending Outgoing Recall Requests Pool", "Could not clicked on Pending Outgoing Recall Requests Pool", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectAuthorizationExceptions() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", authorizationExceptions);
				clickOnElement(eppPoolOptions, "Pool Value", authorizationExceptions);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Authorization Exceptions Pool", "Successfully clicked on Authorization Exceptions", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Authorization Exceptions Pool", "Could not clicked on Authorization Exceptions", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public void selectWorkSummaryPool(String sPoolName) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				//Thread.sleep(4000);
				waitForPresenceOfElement(eppPoolOptions, "Pool Value", getDynamicElement("Pool Name",workSummaryPool,sPoolName));
				clickOnElement(eppPoolOptions, "Pool Value", getDynamicElement("Pool Name",workSummaryPool,sPoolName));
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Pool option - " + sPoolName, "Successfully clicked on Pool option - " + sPoolName, "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Pool option - " + sPoolName, "Could not clicked on Pool option - " + sPoolName, "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void goToLastRecordPage() throws Exception {


		if(isElementPresentZeroWait(recordDropdown)) {
			selectLastValueFromList(eppPoolOptions, "Last Record",recordDropdown);
		}

	}

}
