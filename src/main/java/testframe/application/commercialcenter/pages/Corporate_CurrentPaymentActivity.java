package testframe.application.commercialcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	By paymentActivityTitle = By.xpath("//h3[contains(text(),'Current Activity Summary')]|//button[contains(text(),'Payment Activity')]");
	By cancelWarningMsg = By.xpath("//p[contains(text(),'Are you sure that you want to cancel')]");
	By approveWarningMsg = By.xpath("//p[contains(text(),'Are you sure you want to approve')]");
	By searchButton = By.xpath("//button[@aria-label='Search']");
	By typeDropArrow = By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[2]");
	By transactionNumField = By.xpath("//input[@id='transactionNumberdesk']");
	By statusDopArrow = By.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[3]");
	By nameField = By.xpath("//input[@id='transactionNamedesk']");
	By amountField = By.xpath("//input[@id='transactionAmountdesk']");
	By searchSymbol = By.xpath("//button[@type='submit']/i");
	By warningYesButton = By.xpath("//button[text()='Yes']");
	By approveButton = By.xpath("//div[contains(@class,'action-panel')]//button//i[text()='check']");
	By rejectButton = By.xpath("//button[contains(.,'Reject')]");
	By rejectReason = By.xpath("//label[contains(text(),'Enter the rejection reason for payment :')]");
	By rejectReasonTextField = By.xpath("//input[contains(@class,'form-control')][@formcontrolname='rejectReason']");
	By okButton = By.xpath("//button[text()='OK']");
	By editAddenda = By.xpath("//input[@id='payeeAddenda0']");
	By saveEditBatch = By.xpath("//button[contains(text(),'Save Batch')]");
	By achCurrentActivity = By.xpath("//div//a[text()='ACH Payments']");
	By wireCurrentActivity = By.xpath("//div//a[text()='Wire Transfers']");
	By recurringApproveButton = By.xpath("//div[contains(@class,'btn-splitter')]//button//i[text()='check']");
	By closeButton = By.xpath("//div[contains(@class,'wire-action-panel')]//button//i[text()='close']");

	String warningButton = "//button[text()='%s']";
	String approveViewButton = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]//..//..//..//button[@aria-label='Click To View']//i[text()='chevron_right']";
	String cancelEditButton = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td[contains(@class,'edit-splitter')]//..//..//button[contains(@class,'dropdown-toggle')]//i[text()='expand_more']";
	String fromAcc_field = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[@aria-label='From Account']/../span";
	String toAcc_field = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[@aria-label='To Account']/../span";
	String initiator_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div[text()='Initiator']/../span";
	String transferDate_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../..//td[2]";
	String typeList = "//li[@class='ui-dropdown-item ui-corner-all']/span[text()='%s']";
	String statusList = "//li[contains(@class,'ui-dropdown-item ui-corner-all')]/span[contains(text(),'%s')]";
	String amount_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/div)[1]";
	String status_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span";
	String editButton = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]//..//..//..//button//i[text()='mode_edit']";
	String amount1_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div)[1]";
	String amount2_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div)[11]";
	String amount3_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td//div)[22]";
	String status1_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span[1]";
	String status2_field ="(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span)[2]";
	String status3_field ="(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span)[3]";

	Corporate_AccountTransferDetails corporateAccountTransferDetails;
	Corporate_NewACHBatchTemplate corporate_NewACHBatchTemplate;
	Corporate_NewWireTransfer corporate_NewWireTransfer;

	static String transactionID; 
	static String transID;
	public Corporate_CurrentPaymentActivity(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		corporateAccountTransferDetails = new Corporate_AccountTransferDetails(driver);
		corporate_NewACHBatchTemplate = new Corporate_NewACHBatchTemplate(driver);
	}

	//cancel By user
	public void clickCancelButton(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
						clickOnElement("Corporate Current Payment Activity", "Warning Message", warningYesButton);
						Thread.sleep(4000);
						verifyCancelPaymentMessage(transactionID);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Cancel button");
					new HTMLReportHelper().HtmlReportBody("Click on cancel payment","Payment cancelled successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
					new HTMLReportHelper().HtmlReportBody("Click on cancel payment","Could not click on cancel payment successfully", "Failed", driver, "Y");
				}
			}
		}
	}

	//cancel By user
	public void verifyCancelPaymentMessage(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				String cancelPaymentMsg = "//div[text()='The payment "+transactionID+" has been successfully canceled.']";
				isElementPresent(returnByElement("Cancel Payment alert Msg", cancelPaymentMsg));
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Cancel Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Verify cancel payment message",
							"Verify cancel payment message successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify cancel payment message",
							"Could not verify cancel payment message successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}

			}
		}
	}


	public void viewCurretPaymentDetails(String date,String transactionID,String amount, String status,String fromAccount,String toAccount,String initiator) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					if(!date.equals("")) {
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
					//				if(!initiator.equals("")){
					//					validateTextContains("Corporate Current Payment Activity", "Initiator", getDynamicElement("Initiator", initiator_field, transactionID), "FGS_ACH04");
					//					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - validate transactions");
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Validated payment details successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Could not Validate payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void clickApproveButton(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Approve Button",
							getDynamicElement("Approve Button", approveViewButton, transactionID));
					if(isElementPresent(approveButton)) { 
						clickOnElement("Corporate Current Payment Activity", "Approve Button", approveButton);
						if(isElementPresent(approveWarningMsg)){
							clickOnElement("Corporate Current Payment Activity", "Warning Message", warningYesButton);
							Thread.sleep(4000);
							verifyApprovePaymentMessage(transactionID);
						}
					}
				}	stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve button");
					new HTMLReportHelper().HtmlReportBody("Click on approve payment button","Click on approve payment button successfully", "Passed", driver, "Y");
				}else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on approve payment button","Could not click on approve payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyApprovePaymentMessage(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				//			String approvePaymentMsg = "//div[text()='Payment "+transactionID+" successfully approved.']";
				//			isElementPresent(returnByElement("Cancel Payment alert Msg", approvePaymentMsg);
				String approvePaymentSuccessMsg = "//div[text()='This payment has been approved successfully.']";
				isElementPresent(returnByElement("Payment alert Msg", approvePaymentSuccessMsg));
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Verify approve payment message",
							"Verify approve payment message successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify approve payment message",
							"Could not verify approve payment message successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void verifyApproveACHPaymentMessage(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				String approvePaymentMsg = "//div[text()='Payment "+transactionID+" successfully approved.']";
				isElementPresent(returnByElement("Approve Payment alert Msg", approvePaymentMsg));
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Verify approve payment message",
							"Verify approve payment message successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify approve payment message",
							"Could not verify approve payment message successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void filterCurrentActivityDetails(String typeVal, String transNum, String status, String nameVal, String amtVal) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Verify current filter transactions",
							"Verify current filter transactions successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify current filter transactions",
							"Could not verify current filter transactions successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void viewCurretPaymentDetailsForACH(String date,String transactionID,String amount, String status) throws Exception {
		//String initiator){
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					if(!date.equals("")) {
						validateTextContains("Corporate Current Payment Activity", "Date", getDynamicElement("Date", transferDate_field, transactionID), date);
					}
					if(!amount.equals("")){
						validateTextContains("Corporate Current Payment Activity", "Amount", getDynamicElement("Amount", amount_field, transactionID),amount);
					}
					if(!status.equals("")){
						validateTextContains("Corporate Current Payment Activity", "Status", getDynamicElement("Status", status_field, transactionID), status);
					}
					//				if(!initiator.equals("")){
					//					validateTextContains("Corporate Current Payment Activity", "Initiator", getDynamicElement("Initiator", initiator_field, transactionID), initiator);
					//					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - validate transactions");
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Validated payment details successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Could not validate payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void clickApproveButtonForACHPayment(String transactionID,String psw) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Approve Button",
							getDynamicElement("Approve Button", approveViewButton, transactionID));
					if(isElementPresent(approveButton)) 
						clickOnElement("Corporate Current Payment Activity", "Approve Button", approveButton);
					if(isElementPresent(approveWarningMsg)){
						clickOnElement("Corporate Current Payment Activity", "Warning Message", warningYesButton);
						Thread.sleep(4000);
						corporate_NewACHBatchTemplate.verifyPassword(psw);
						Thread.sleep(4000);
						verifyApproveACHPaymentMessage(transactionID);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve button");
					new HTMLReportHelper().HtmlReportBody("Click on approve payment button","Click on approve payment button successfully", "Passed", driver, "Y");
				}else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on approve payment button","Could not click on approve payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickRejectButtonForACHPayment(String transactionID,String reason) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Reject Button",
							getDynamicElement("Reject Button", approveViewButton, transactionID));
					if(isElementPresent(rejectButton)) 
						clickOnElement("Corporate Current Payment Activity", "Reject Button", rejectButton);
					if(isElementPresent(rejectReason)){
						enterText("Corporate Current Payment Activity", "Reject Reason Field", rejectReasonTextField, reason);
						clickOnElement("Corporate Current Payment Activity", "Ok Button", okButton);
						Thread.sleep(4000);
						verifyRejectACHPaymentMessage(transactionID);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve button");
					new HTMLReportHelper().HtmlReportBody("Click on reject payment button","Click on reject payment button successfully", "Passed", driver, "Y");
				}else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on reject payment button","Could not click on reject payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickCancelButtonForACHPayment(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Cancel Button",
							getDynamicElement("Cancel Button", cancelEditButton, transactionID));
					if(isElementPresent(getDynamicElement("Cancel Button", cancelButton, transactionID))) 
						clickOnElement("Corporate Current Payment Activity", "Cancel Button",
								getDynamicElement("Cancel Button", cancelButton, transactionID));
					if(isElementPresent(cancelWarningMsg)){
						clickOnElement("Corporate Current Payment Activity", "Yes Button", warningYesButton);
						Thread.sleep(4000);
						verifyCancelPaymentMessage(transactionID);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Cancel Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on cancel payment button",
							"Click on cancel payment button successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on cancel payment button",
							"Could not click on cancel payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void verifyRejectACHPaymentMessage(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				String rejectPaymentMsg = "//div[text()='Payment "+transactionID+" has been successfully rejected.']";
				isElementPresent(returnByElement("Reject Payment alert Msg", rejectPaymentMsg));
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Reject Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Reject payment message",
							"Reject payment message successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Reject payment message",
							"Could not reject payment message successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public void clickEditButtonFromInitiatorACH(String transactionID,String updatedAddenda) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Edit Button",
							getDynamicElement("Edit Button", editButton, transactionID));
					waitElement(1000);
					enterText("Corporate Current Payment Activity", "Addenda Field", editAddenda, updatedAddenda);
					clickOnElement("Corporate Current Payment Activity", "Save Batch", saveEditBatch);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Edit Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on edit payment button",
							"Click on edit payment button successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on edit payment button",
							"Could not click on edit payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnCurrentACHActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "ACH Button",achCurrentActivity);
					waitElement(2000);
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Edit Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on current payment",
							"Clicked on current payment successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on current payment",
							"Could not click on payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public void viewInitiatorCurretPaymentDetailsForACH(String date,String transactionID,String amount, String editStatus) throws Exception {
		//String initiator){
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					//			if(!date.equals("")) {
					//			validateTextContains("Corporate Current Payment Activity", "Date", getDynamicElement("Date", transferDate_field, transactionID), date);
					//			}
					if(!amount.equals("")){
						validateTextContains("Corporate Current Payment Activity", "Amount", getDynamicElement("Amount", amount_field, transactionID),amount);
					}
					if(!editStatus.equals("")){
						validateTextContains("Corporate Current Payment Activity", "Status", getDynamicElement("Status", status_field, transactionID), editStatus);
					}
					//			if(!initiator.equals("")){
					//				validateTextContains("Corporate Current Payment Activity", "Initiator", getDynamicElement("Initiator", initiator_field, transactionID), initiator);
					//				}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Edit Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Validate payment details",
							"Validate payment details successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate payment details",
							"Could not validated payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}



	public void clickOnCurrentWireTransferActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Wire Transfer Button",wireCurrentActivity);
					waitElement(2000);
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Edit Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on current wire payment",
							"Clicked on current wire payment successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on current wire payment",
							"Could not click on current wire payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickEditButtonFromInitiatorWire(String transactionID) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Edit Button",
							getDynamicElement("Edit Button", editButton, transactionID));
					waitElement(1000);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Current Payment Activity - Edit Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on edit payment button",
							"Click on edit payment button successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on edit payment button",
							"Could not click on edit payment button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickRecurringApproveButton(String seriesName,String psw) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(paymentActivityTitle)) {
					Thread.sleep(2000);
					clickOnElement("Corporate Current Payment Activity", "Approve Button",
							getDynamicElement("Approve Button", approveViewButton, seriesName));
					if(isElementPresent(recurringApproveButton)) { 
						for (int i = 1; i <= 10; i++) {
							clickOnElement("Corporate Current Payment Activity", "Approve Button", recurringApproveButton);
							if(isElementPresent(approveWarningMsg)){
								clickOnElement("Corporate Current Payment Activity", "Warning Message", warningYesButton);
								corporate_NewACHBatchTemplate.verifyPassword(psw);
							}
						}
					}
				}	
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Click on recurring approve payment","Click on recurring approve payment successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on recurring approve payment","Could not click on recurring approve payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public void viewCurretStatusDetailsForMultipleWires(String transID,String status1Review) throws Exception {
		//			,String amount2Review,String status2Review,String amount3Review,String status3Review 
		//String initiator){
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					String[] newtrans=transID.split("\\|\\|");
					for (int i=0; i<newtrans.length; i++) {

						if(!status1Review.equals("")){
							validateTextContains("Corporate Current Payment Activity", "Status1_review", getDynamicElement("Status", status1_field, newtrans[i].trim()), status1Review);
						}
					}

				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - validate transactions");
					new HTMLReportHelper().HtmlReportBody("Validate payment status","Validated payment status successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate payment status","Could not Validate payment status successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void clickMultipleWireApproveButton(String transID,String psw) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(paymentActivityTitle)) {
					String[] newtrans =transID.split("\\|\\|");
					for (int i=0; i<newtrans.length; i++)  {
						if(newtrans[i].contains("DWR-")){
							clickOnElement("Corporate Current Payment Activity", "Approve Button",
									getDynamicElement("Approve Button", approveViewButton, newtrans[i].trim()));
							if(isElementPresent(approveButton)) 
								clickOnElement("Corporate Current Payment Activity", "Approve Button", approveButton);
							if(isElementPresent(approveWarningMsg)){
								clickOnElement("Corporate Current Payment Activity", "Warning Message", warningYesButton);
								Thread.sleep(4000);
								corporate_NewACHBatchTemplate.verifyPassword(psw);
								Thread.sleep(4000);
								verifyApproveACHPaymentMessage(newtrans[i].trim());
							}
							clickOnElement("Corporate Current Payment Activity", "Close Button", closeButton);
						}
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -Current Payment Activity - Approve Payment Msg");
					new HTMLReportHelper().HtmlReportBody("Click on multiple wire transfer approve payment",
							"Click on multiple wire transfer approve payment successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on multiple wire transfer approve payment",
							"Could not click on multiple wire transfer approve payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}



}

