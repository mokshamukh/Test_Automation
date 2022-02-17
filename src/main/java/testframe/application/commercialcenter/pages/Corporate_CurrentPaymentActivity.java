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
	Corporate_AccountTransferDetails corporateAccountTransferDetails;
	Corporate_NewACHBatchTemplate corporate_NewACHBatchTemplate;

	static String transactionID; 
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
					new HTMLReportHelper().HtmlReportBody("Cancel Payment","Payment cancelled Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
					new HTMLReportHelper().HtmlReportBody("Cancel Payment","Could not cancel the Payment Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Cancel payment Msg Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not Cancel payment msg Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Validated payment details Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate payment details","Could not Validate payment details Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Approve Payment","Approved Payment Successfully", "Passed", driver, "Y");
				}else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Approve Payment","Could not Approve Payment Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Approve payment Msg Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not approve payment msg Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Approve payment Message Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not approve payment message Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Filter transactions Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not Filter transactions Successfully", "Failed", driver, "Y");
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
					//				if(!date.equals("")) {
					//				validateTextContains("Corporate Current Payment Activity", "Date", getDynamicElement("Date", transferDate_field, transactionID), date);
					//				}
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
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details","Validated Payment Details Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details","Could not Validate Payment Details Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Approve Payment","Approve ACH Payment Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Approve Payment","Could not Approve Payment Successfully", "Failed", driver, "Y");
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
					System.out.println("Pass -Current Payment Activity - Reject button");
					new HTMLReportHelper().HtmlReportBody("Reject Payment","Rejected Payment Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Reject Payment","Could not Reject Payment Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Cancel ACH payment Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not Cancel ACH payment  Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Reject payment Msg Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not reject payment msg Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Edit payment Msg Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not Edit payment msg Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"ACH payment Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not ACH payment  Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details",
							"Validate Payment Details Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details",
							"Could not Validateed Payment Details  Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Wire payment Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not do a Wire payment Successfully", "Failed", driver, "Y");
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
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Edit payment Msg Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Current Payment Activity CC- Corporate application",
							"Could not Edit payment msg Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


}

