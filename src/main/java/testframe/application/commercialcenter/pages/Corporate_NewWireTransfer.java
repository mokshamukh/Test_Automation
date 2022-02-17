package testframe.application.commercialcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Corporate_NewWireTransfer
 * 
 * @author shilpa.thangapalam
 */

//public class Corporate_NewWireTransfer extends CommonLibrary{
//
//	public Corporate_NewWireTransfer(WebDriver driver) {
//		super(driver);
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//
//
//	
//	String list = "//li[@role='option']/span[contains(text(),'%s')]";
//	String transactionID;
//
//	
//	public void reviewWireTransferDetails(String amount) throws Exception {
//		boolean stepResult = false;
//		boolean flag = false;
//		try {
//			if (isElementPresent(accountInfoDetails)) {
//				//				List<WebElement> element = findElements(reviewDetails);
//				//				for (WebElement ele : element) {
//				//					if (ele.getText().contains(debitAccount)) {
//				//						flag = true;
//				//					} else {
//				//						flag = false;
//				//					}
//				//				}
//			}
//			validateElementExist("Corporate New Wire Transfer", "AmountField", reviewAmount, amount);
//			clickOnElement("Corporate New Wire Transfer", "Confirm Button", confirmButton);
//			stepResult = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult == true) {
//				System.out.println("Pass - Menu");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"review Wire Transfer details successfully", "Passed", driver, "Y");
//			} else {
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Could not review Wire Transfer details successfully", "Failed", driver, "Y");
//			}
//		}
//
//	}
//
//	public void verifyPassword(String password) throws Exception {
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(pleaseReverifyTitle)) {
//				if (!password.equals("")) {
//					enterText("Corporate New Wire Transfer", "Password", confirmPassword, password);
//				}
//				clickOnElement("Corporate New Wire Transfer", "Submit Button", submitButton);
//				stepResult = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult == true) {
//				System.out.println("Pass - Menu");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"enter password successfully", "Passed", driver, "Y");
//			} else {
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Could not enter password successfully", "Failed", driver, "Y");
//			}
//		}
//
//	}
//
//	public String getTransaction() throws Exception {
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(wireTransferHeader)) {
//				transactionID = getElementText("New Wire Transfer", "Alert Message", msg);
//				transactionID = transactionID.replaceAll("\\.", "");
//				stepResult = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult == true) {
//				System.out.println("Pass - Menu");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Captured TransactionID Payment details successfully", "Passed", driver, "Y");
//			} else {
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Could not Capture TransactionID Payment details successfully", "Failed", driver, "Y");
//			}
//		}
//		return transactionID;
//
//	}
//
//
//	public void createNewWireTransferUsingFreeForm(String payee,String debitAccount,String beneIdType,
//			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
//			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
//			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2) throws Exception{
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(wireTransferHeader)) {
//				clickOnElement("Corporate New Wire Transfer", "Free Form Field", freeFormField);
//
//				clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
//
//				waitForPresenceOfElement("Corporate New Wire Transfer","Account Information Header", accountInfoHeader);
//				if(!debitAccount.equals("")) {
//					scrollToTopOfThePage();
//					enterText("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, debitAccount);
//					clickOnElement("Corporate New Wire Transfer", "Debit Account Field", getDynamicElement("Debit Account", list, debitAccount));
//				}
//				scrollToElement(beneInformation);
//				if (!payee.equals("")) {
//					enterText("Corporate New Wire Transfer", "Payee Field", payeeName, payee);
//				}
//				if(!beneIdType.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
//				}
//				if(!beneID.equals("")) {
//					scrollToElement(beneIDField);
//					enterText("Corporate New Wire Transfer", "Beneficiary Id", beneIDField, beneID);
//				}
//				if(!beneAddress1.equals("")) {
//					enterText("Corporate New Wire Transfer", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
//				}
//				if(!beneAddress2.equals("")) {
//					enterText("Corporate New Wire Transfer", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
//				}
//				if(!beneCountry.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Country", beneCountryField, list, beneCountry);
//				}
//				if(!paymentCurrency.equals("")) {
//					enterText("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, paymentCurrency);
//					clickOnElement("Corporate New Wire Transfer", "Payment Currency", getDynamicElement("Payment Currency", list, paymentCurrency));
//				}
//				if(!amount.equals("")) {
//					enterText("Corporate New Wire Transfer", "Amount Field", amountField, amount);
//				}
//				if(!beneBankIDType.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
//				}
//				if(!beneBankID.equals("")) {
//					enterText("Corporate New Wire Transfer", "Bene Bank ID", beneBankIdField, beneBankID);
//				}
//				if(!purposeOfPayment.equals("")) {
//					scrollToElement(purposeOfPaymentField);
//					enterText("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
//				}
//				if(!beneBankAddress1.equals("")) {
//					enterText("Corporate New Wire Transfer", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
//				}
//				if(!beneBankAddress2.equals("")) {
//					enterText("Corporate New Wire Transfer", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
//				}
//
//				clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
//				stepResult = true;
//			}
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (stepResult==true){
//				System.out.println("Pass - From acc");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "New Wire Transfer created successfully", "Passed", driver, "Y");
//			}
//			else{
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not create New Wire Transfer successfully", "Failed", driver, "Y");
//
//			}
//		}
//	}
//
//	public void createNewWireTransferUsingExistingTemplate(String existTemplate,String paymentDate) throws Exception{
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(wireTransferHeader)) {
//				clickOnElement("Corporate New Wire Transfer", "Template Field", templateField);
//				clickOnElement("Corporate New Wire Transfer", "Template Field",templateDropdown);
//				selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", existingTemplateField, list, existTemplate);
//
//				clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
//				waitForPresenceOfElement("Corporate New Wire Transfer", "Wire Transfer Header", selectTemplateHeader);
//
//				if(!paymentDate.equals("")) {
//					enterNewWireTransferPaymentDate(paymentDate);
//				}
//				clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
//				stepResult = true;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (stepResult==true){
//				System.out.println("Pass - From acc");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Existing New Wire Transfer created successfully", "Passed", driver, "Y");
//			}
//			else{
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not create Existing New Wire Transfer successfully", "Failed", driver, "Y");
//			}
//		}
//	}
//
//	public void enterNewWireTransferPaymentDate(String paymentDate) throws Exception {
//		boolean stepResult = false;
//		try {
//			if (!paymentDate.equals("")) {
//				for (int i = 1; i <= 10; i++) {
//					driver.findElement(paymentDateField).sendKeys(Keys.BACK_SPACE);
//				}
//				enterText("Corporate Wires Payment", "Payment Date", paymentDateField, paymentDate);
//				clickOnElement("Corporate Wires Payment", "Payment Date Title", paymentDateTitle);
//			}
//			stepResult = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult==true){
//				System.out.println("Pass -- transfer date");
//				new HTMLReportHelper().HtmlReportBody("Wires CC- Corporate application", "Enter transfer date field successfully", "Passed", driver, "Y");
//			}
//			else{
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Wires CC- Corporate application", "Could not Enter transfer date field successfully", "Failed", driver, "Y");
//			}
//		}
//	}
//
//
//	public void editNewWireTransferUsingFreeForm(String payee,String debitAccount,String beneIdType,
//			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
//			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
//			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2) throws Exception{
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(editTransferHeader)) {
//
//				waitForPresenceOfElement("Corporate New Wire Transfer","Wire Details", wireDetailsHeader);
//				if(!debitAccount.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, debitAccount);
//					clickOnElement("Corporate New Wire Transfer", "Debit Account Field", getDynamicElement("Debit Account", list, debitAccount));
//				}
//				scrollToElement(beneInformation);
//				if (!payee.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Payee Field", payeeName, payee);
//				}
//				if(!beneIdType.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
//
//				}
//				if(!beneID.equals("")) {
//					scrollToElement(beneIDField);
//					clearAndType("Corporate New Wire Transfer", "Beneficiary Id", beneIDField, beneID);
//				}
//				if(!beneAddress1.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
//				}
//				if(!beneAddress2.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
//				}
//				if(!beneCountry.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Country", beneCountryField, list, beneCountry);
//				}
//				if(!paymentCurrency.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, paymentCurrency);
//					clickOnElement("Corporate New Wire Transfer", "Payment Currency", getDynamicElement("Payment Currency", list, paymentCurrency));
//
//				}
//				if(!amount.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Amount Field", amountField, amount);
//				}
//				if(!beneBankIDType.equals("")) {
//					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
//				}
//				if(!beneBankID.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Bene Bank ID", beneBankIdField, beneBankID);
//				}
//				if(!purposeOfPayment.equals("")) {
//					scrollToElement(purposeOfPaymentField);
//					clearAndType("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
//				}
//				if(!beneBankAddress1.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
//				}
//				if(!beneBankAddress2.equals("")) {
//					clearAndType("Corporate New Wire Transfer", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
//				}
//
//				clickOnElement("Corporate New Wire Transfer", "Save Transfer Button", requestTransferButton);
//				stepResult = true;
//			}
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (stepResult==true){
//				System.out.println("Pass - From acc");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "New Wire Transfer created successfully", "Passed", driver, "Y");
//			}
//			else{
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not create New Wire Transfer successfully", "Failed", driver, "Y");
//			}
//		}
//	}
//
//
//
//	public String getTransactionIDFromPayment() throws Exception {
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(paymentActivityTitle)) {
//				transactionID = getElementText("New Wire Transfer Transaction ID", "Current Activity Details", currentActivityTransID);
//				//transactionID = transactionID.replaceAll("\\.", "");
//				stepResult = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult == true) {
//				System.out.println("Pass - Menu");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Transaction ID Payment details captured successfully", "Passed", driver, "Y");
//			} else {
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
//						"Could not get Transaction ID Payment details successfully", "Failed", driver, "Y");
//			}
//		}
//		return transactionID;
//
//	}
//
//
//	public void editNewWireTransferUsingExistingTemplate(String paymentDate) throws Exception{
//		boolean stepResult = false;
//		try {
//			if (isElementPresent(editTransferHeader)) {
//				waitForPresenceOfElement("Corporate New Wire Transfer", "Wire Transfer details Header", wireDetailsHeader);
//
//				if(!paymentDate.equals("")) {
//					enterNewWireTransferPaymentDate(paymentDate);
//				}
//				clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
//				stepResult = true;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (stepResult==true){
//				System.out.println("Pass - From acc");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Existing New Wire Transfer edit successfully", "Passed", driver, "Y");
//			}
//			else{
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not edit Existing New Wire Transfer successfully", "Failed", driver, "Y");
//			}
//		}
//	}
//
//}

public class Corporate_NewWireTransfer extends CommonLibrary{

	public Corporate_NewWireTransfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	By wireTransferHeader = By.xpath("//h1[contains(text(),'Wire Transfer')]");
	By startWireTransfer = By.xpath("//h3[@id='selectWireHeading']");
	By searchPayeeField = By.xpath("//label[text()='Payee']//..//div[contains(@class,'ui-state')]");
	By freeFormField = By.xpath("//label[text()='Free-Form']//..//div[contains(@class,'ui-state')]");
	By payeeField = By.xpath("//input[@id='selectPayeeSearch']");
	By nextButton = By.xpath("//button[contains(text(),'Next')]");
	By accountInfoHeader = By.xpath("//h3[text()='Account Information ']");
	By debitAccountField = By.xpath("//p-autocomplete[@inputid='debitAccount']//button//span[text()='ui-btn']");
	By paymentCurrencyField = By.xpath("//p-autocomplete[@inputid='paymentCurrency']//button//span[text()='ui-btn']");
	By purposeOfPaymentField = By.xpath("//input[@id='purposeOfPay']");
	By amountField = By.xpath("//input[@id='amount']");
	By requestTransferButton = By.xpath("//button[contains(@aria-label,'To proceed with the transfer')]");
	By accountInfoDetails = By.xpath("//h3[contains(text(),'Account Information')]");
	By reviewDetails = By.xpath("//div[text()='Debit Account']//..//span[@id='debitAccount'][text()]");
	By reviewAmount = By.xpath("//h4[@role='heading']//..//..//..//div[@id='Payment Amount']|//div[@id='amount']");
	By confirmButton = By.xpath("//button[text()='Confirm']");
	By pleaseReverifyTitle = By.xpath("//h4[contains(text(),'Please Reverify')]");
	By confirmPassword = By.xpath("//input[@id='confirmPassword']");
	By submitButton = By.xpath("//button[text()='Submit']");
	By msg = By.xpath("//div[@class='alert-message-title']/b|//div[@class='alert-message-title']/strong");
	By beneInformation = By.xpath("//h3[text()='Beneficiary Information ']");
	By payeeName = By.xpath("//input[@id='payeeName']");
	By beneIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//..//div//span[contains(@class,'expand_more')]");
	By beneIDField = By.xpath("//input[@id='beneficiaryId']");
	By beneAddressField1 = By.xpath("//input[@id='beneficiaryAddress1']");
	By beneAddressField2 = By.xpath("//input[@id='beneficiaryAddress2']");
	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry']//..//div//span[contains(@class,'expand_more')]");
	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//..//div//span[contains(@class,'expand_more')]");
	By beneBankIdField = By.xpath("//input[@id='beneficiaryBankId']");
	By beneBankAddress1Field = By.xpath("//input[@id='beneficiaryBankAddress1']");
	By beneBankAddress2Field = By.xpath("//input[@id='beneficiaryBankAddress2']");
	By beneBankCountry = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry']");
	By benePhoneNumber = By.xpath("//input[@id='phoneNumber']");
	By templateField = By.xpath("//p-radiobutton[@inputid='selectTemplate']//div//span");
	By templateDropdown = By.xpath("//p-dropdown//div//span[contains(@class,'expand_more')]");
	By existingTemplateField = By.xpath("//p-dropdown[@inputid='templateData']");
	By selectTemplateHeader = By.xpath("//h1[text()='Wire Transfer: Select Template']");
	By paymentDateField = By.xpath("//input[@id='paymentDate']");
	By paymentDateTitle = By.xpath("//h4[contains(text(),'Amount & Currency')]");
	By existingReviewAmount = By.xpath("//h4[@role='heading']//..//..//..//div[@id='amount']");
	By editTransferHeader= By.xpath("//h1[@id='wireTransferLbl'][contains(text(),'Edit')]");
	By wireDetailsHeader = By.xpath("//h3[text()='Wire Details ']");
	By paymentActivityTitle = By.xpath("//h3[contains(text(),'Current Activity Summary')]|//button[contains(text(),'Payment Activity')]");
	By currentActivityTransID = By.xpath("(//span[@class='d-block'])[1]");
	//	By payee = By.xpath("//label[text()='Payee']//..//div[contains(@class,'ui-state')]");
	By payeeAmountField = By.xpath("//input[@id='wireAmountId']");
	By multipleTemplates = By.xpath("//p-radiobutton[@inputid='templateRadio']//div//span");
	By multiTemplateHeader = By.xpath("//h1[text()='Wire Transfer for Multi-Wire Entry']");
	By multipleAddButton = By.xpath("//p-dropdown[@inputid='add']//div//span[contains(@class,'expand_more')]");
	By addMoreTemplateButton = By.xpath("//button[contains(@aria-label,'To add more template row to select additional templates')]");
	By template1Field = By.xpath("//input[@id='templateName0']");
	By template2Field = By.xpath("//input[@id='templateName1']");
	By template3Field = By.xpath("//input[@id='templateName2']");
	By template4Field = By.xpath("//input[@id='templateName3']");
	By template5Field = By.xpath("//input[@id='templateName4']");
	By multipleAmount = By.xpath("//div[@id='Total Debit Amount'][contains(text(),'USD')]");
	By template1_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1])[1]");
	By template2_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1])[3]");
	By template3_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1])[5]");
	By template4_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1])[7]");
	By template5_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1])[9]");
	By debitAcc1_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[1]");
	By debitAcc2_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[2]");
	By debitAcc3_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[3]");
	By amount1_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td/span)[1]");
	By amount2_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td/span)[2]");
	By amount3_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td/span)[3]");
	By transacID  = By.xpath("//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td");
	By template1SearchBtn = By.xpath("//input[@id='templateName0']//..//button/span[contains(text(),'ui-btn')]");
	By template2SearchBtn = By.xpath("//input[@id='templateName1']//..//button/span[contains(text(),'ui-btn')]");
	By template3SearchBtn = By.xpath("//input[@id='templateName2']//..//button/span[contains(text(),'ui-btn')]");
	By template4SearchBtn = By.xpath("//input[@id='templateName3']//..//button/span[contains(text(),'ui-btn')]");
	By template5SearchBtn = By.xpath("//input[@id='templateName4']//..//button/span[contains(text(),'ui-btn')]");

	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String templateList ="//li[@role='option']";
	String multipleList = "(//p-dropdown[@inputid='add']//div//input[contains(@aria-label,'%s')]//..//..//div)[2]";
	String transactionID;
	String transID = "";
	int iTemplateCount;

	public void createNewWireTransferUsingPayee(String payee,String debitAccount,String paymentCurrency,
			String purposeOfPayment,String amount) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					clickOnElement("Corporate New Wire Transfer", "Payee Field", searchPayeeField);
					if (!payee.equals("")) {
						enterText("Corporate New Wire Transfer", "Payee Field", payeeField, payee);
						waitElement(1000);
						clickOnElement("Corporate New Wire Transfer", "payee List", getDynamicElement("Corporate New Wire Transfer", list, payee));
						//selectElementFromListbox("Corporate New Wire Transfer", "payee List", searchPayeeField, payeeList,payee);
					}
					clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
					waitForPresenceOfElement("Corporate New Wire Transfer","Account Information Header", accountInfoHeader);
					if(!debitAccount.equals("")) {
						clickOnELementUsingActions(debitAccountField);
						//getDynamicElement("Corporate New Wire Transfer", list, debitAccount);
						selectElementFromListbox("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, list,debitAccount);      
					}
					if(!paymentCurrency.equals("")) {
						clickOnELementUsingActions(paymentCurrencyField);
						selectElementFromListbox("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
					}
					if(!purposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						enterText("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
					}
					if(!amount.equals("")) {
						enterText("Corporate New Wire Transfer", "Amount Field", payeeAmountField, amount);
					}
					clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Wire transfer created successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Could not create wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}

			}
		}
	}

	public void reviewWireTransferDetails(String amount) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			boolean flag = false;
			try {
				if (isElementPresent(accountInfoDetails)) {
					//				List<WebElement> element = findElements(reviewDetails);
					//				for (WebElement ele : element) {
					//					if (ele.getText().contains(debitAccount)) {
					//						flag = true;
					//					} else {
					//						flag = false;
					//					}
					//				}
				}
				validateElementExist("Corporate New Wire Transfer", "AmountField", reviewAmount, amount);
				clickOnElement("Corporate New Wire Transfer", "Confirm Button", confirmButton);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details",
							"review wire transfer details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details",
							"Could not review wire transfer details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void verifyPassword(String password) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(pleaseReverifyTitle)) {
					if (!password.equals("")) {
						enterText("Corporate New Wire Transfer", "Password", confirmPassword, password);
					}
					clickOnElement("Corporate New Wire Transfer", "Submit Button", submitButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Enter password",
							"enter password successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter password",
							"Could not enter password successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public String getTransaction() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					transactionID = getElementText("New Wire Transfer", "Alert Message", msg);
					transactionID = transactionID.replaceAll("\\.", "");
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Capture transactionId",
							"Captured transactionID Payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Capture transactionId",
							"Could not Capture transactionID Payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
		return transactionID;

	}


	public void createNewWireTransferUsingFreeForm(String payee,String debitAccount,String beneIdType,
			String beneID,String beneAddress1,String beneAddress2,String beneCountry,String paymentDate,
			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					clickOnElement("Corporate New Wire Transfer", "Free Form Field", freeFormField);

					clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);

					waitForPresenceOfElement("Corporate New Wire Transfer","Account Information Header", accountInfoHeader);
					if(!debitAccount.equals("")) {
						scrollToTopOfThePage();
						clickOnELementUsingActions(debitAccountField);
						selectElementFromListbox("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, list,debitAccount);
						//enterText("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, debitAccount);
						//clickOnElement("Corporate New Wire Transfer", "Debit Account Field", getDynamicElement("Debit Account", list, debitAccount));
					}
					scrollToElement(beneInformation);
					if (!payee.equals("")) {
						enterText("Corporate New Wire Transfer", "Payee Field", payeeName, payee);
					}
					if(!beneIdType.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
					}
					if(!beneID.equals("")) {
						scrollToElement(beneIDField);
						enterText("Corporate New Wire Transfer", "Beneficiary Id", beneIDField, beneID);
					}
					if(!beneAddress1.equals("")) {
						enterText("Corporate New Wire Transfer", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
					}
					if(!beneAddress2.equals("")) {
						enterText("Corporate New Wire Transfer", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
					}
					if(!beneCountry.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Country", beneCountryField, list, beneCountry);
					}
					if(!paymentDate.equals("")) {
						enterNewWireTransferPaymentDate(paymentDate);
					}
					if(!paymentCurrency.equals("")) {
						clickOnELementUsingActions(paymentCurrencyField);
						//enterText("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, paymentCurrency);
						selectElementFromListbox("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
						//clickOnElement("Corporate New Wire Transfer", "Payment Currency", getDynamicElement("Payment Currency", list, paymentCurrency));
					}
					if(!amount.equals("")) {
						enterText("Corporate New Wire Transfer", "Amount Field", amountField, amount);
					}
					if(!beneBankIDType.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
					}
					if(!beneBankID.equals("")) {
						enterText("Corporate New Wire Transfer", "Bene Bank ID", beneBankIdField, beneBankID);
					}
					if(!purposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						enterText("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
					}
					if(!beneBankAddress1.equals("")) {
						enterText("Corporate New Wire Transfer", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
					}
					if(!beneBankAddress2.equals("")) {
						enterText("Corporate New Wire Transfer", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
					}

					clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
					stepResult = true;
				}


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Wire transfer created successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Could not create wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void createNewWireTransferUsingExistingTemplate(String existTemplate,String paymentDate) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					clickOnElement("Corporate New Wire Transfer", "Template Field", templateField);
					clickOnElement("Corporate New Wire Transfer", "Template Field",templateDropdown);
					selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", existingTemplateField, list, existTemplate);

					clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
					waitForPresenceOfElement("Corporate New Wire Transfer", "Wire Transfer Header", selectTemplateHeader);

					if(!paymentDate.equals("")) {
						enterNewWireTransferPaymentDate(paymentDate);
					}
					clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Existing wire transfer created successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Could not create Existing wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterNewWireTransferPaymentDate(String paymentDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!paymentDate.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(paymentDateField).sendKeys(Keys.BACK_SPACE);
					}
					enterText("Corporate Wires Payment", "Payment Date", paymentDateField, paymentDate);
					clickOnElement("Corporate Wires Payment", "Payment Date Title", paymentDateTitle);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date", "Enter transfer date field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date", "Could not enter transfer date field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void editNewWireTransferUsingFreeForm(String payee,String debitAccount,String beneIdType,
			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(editTransferHeader)) {

					waitForPresenceOfElement("Corporate New Wire Transfer","Wire Details", wireDetailsHeader);
					if(!debitAccount.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, debitAccount);
						clickOnElement("Corporate New Wire Transfer", "Debit Account Field", getDynamicElement("Debit Account", list, debitAccount));
					}
					scrollToElement(beneInformation);
					if (!payee.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Payee Field", payeeName, payee);
					}
					if(!beneIdType.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);

					}
					if(!beneID.equals("")) {
						scrollToElement(beneIDField);
						clearAndType("Corporate New Wire Transfer", "Beneficiary Id", beneIDField, beneID);
					}
					if(!beneAddress1.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
					}
					if(!beneAddress2.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
					}
					if(!beneCountry.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Country", beneCountryField, list, beneCountry);
					}
					if(!paymentCurrency.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, paymentCurrency);
						clickOnElement("Corporate New Wire Transfer", "Payment Currency", getDynamicElement("Payment Currency", list, paymentCurrency));

					}
					if(!amount.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Amount Field", amountField, amount);
					}
					if(!beneBankIDType.equals("")) {
						selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
					}
					if(!beneBankID.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Bene Bank ID", beneBankIdField, beneBankID);
					}
					if(!purposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						clearAndType("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
					}
					if(!beneBankAddress1.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
					}
					if(!beneBankAddress2.equals("")) {
						clearAndType("Corporate New Wire Transfer", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
					}

					clickOnElement("Corporate New Wire Transfer", "Save Transfer Button", requestTransferButton);
					stepResult = true;
				}


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "wire transfer created successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Wire transfer created", "Could not create wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}



	public String getTransactionIDFromPayment() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(paymentActivityTitle)) {
					transactionID = getElementText("New Wire Transfer Transaction ID", "Current Activity Details", currentActivityTransID);
					//transactionID = transactionID.replaceAll("\\.", "");
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("TransactionId payment details capture",
							"TransactionId payment details captured successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("TransactionId payment details capture",
							"Could not get TransactionId payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
		return transactionID;

	}


	public void editNewWireTransferUsingExistingTemplate(String paymentDate) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(editTransferHeader)) {
					waitForPresenceOfElement("Corporate New Wire Transfer", "Wire Transfer details Header", wireDetailsHeader);

					if(!paymentDate.equals("")) {
						enterNewWireTransferPaymentDate(paymentDate);
					}
					clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Edit existing wire transfer", "Existing wire transfer edit successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Edit existing wire transfer", "Could not edit Existing wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void createNewWireTransferUsingMultipleTemplates(String template1,String template2,
			String template3,String template4,String template5,String paymentDate) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					clickOnElement("Corporate New Wire Transfer", "Multiple Templates Field", multipleTemplates);
					clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
					waitForPresenceOfElement("Corporate New Wire Transfer", "Multiple Template Header", multiTemplateHeader);

					if(!paymentDate.equals("")) {
						enterNewWireTransferPaymentDate(paymentDate);
					}
					if(!template1.equals("")) {
						enterText("Corporate New Wire Transfer", "Template1 Field", template1Field, template1);
						clickOnElement("Corporate New Wire Transfer", "Template1 Field", getDynamicElement( "Template1 Field", templateList, template1));
						//clickOnELementUsingActions(template1Field);
						//selectElementFromListbox("Corporate New Wire Transfer", "Template1 Field", template1Field, list, template1);
					}
					if(!template2.equals("")) {
						enterText("Corporate New Wire Transfer", "Template2 Field", template2Field, template2);
						clickOnElement("Corporate New Wire Transfer", "Template1 Field", getDynamicElement("Corporate New Wire Transfer", templateList, template2));
					}
					if(!template3.equals("")) {
						enterText("Corporate New Wire Transfer", "Template3 Field", template3Field, template3);
						clickOnElement("Corporate New Wire Transfer", "Template1 Field", getDynamicElement("Corporate New Wire Transfer", templateList, template3));
					}
					if(!template4.equals("")) {
						enterText("Corporate New Wire Transfer", "Template4 Field", template4Field, template4);
						clickOnElement("Corporate New Wire Transfer", "Template1 Field", getDynamicElement("Corporate New Wire Transfer", templateList, template4));
					}
					if(!template5.equals("")) {
						enterText("Corporate New Wire Transfer", "Template5 Field", template5Field, template5);
						clickOnElement("Corporate New Wire Transfer", "Template1 Field", getDynamicElement("Corporate New Wire Transfer", templateList, template5));
					}
				}

				clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
				stepResult = true;
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Create multiple wire transfer", "Multiple wire transfer created successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create multiple wire transfer", "Could not create multiple wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}

		}

	}


	public void reviewMultipleWireTransferDetails(String template1Review,String debitAcc1Review,String amt1Review,
			String template2Review,String debitAcc2Review,String amt2Review,
			String template3Review,String debitAcc3Review,String amt3Review,String totalAmount )throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					if (!template1Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "template1_review", template1_review, template1Review);
					}
					if (!debitAcc1Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "debitAcc1_review", debitAcc1_review, debitAcc1Review);
					}
					if (!amt1Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "amt_review", amount1_review, amt2Review);
					}
					if (!template2Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "template2_review",template2_review, template2Review);
					}
					if (!debitAcc2Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "debitAcc2_review", debitAcc2_review, debitAcc2Review);
					}
					if (!amt2Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "amt2_review", amount2_review, amt2Review);
					}
					if (!template3Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "template3_review", template3_review, template3Review);
					}
					if (!debitAcc3Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "debitAcc3_review", debitAcc3_review, debitAcc3Review);
					}
					if (!amt3Review.equals("")) {
						validateElementExist("New Wire Transfer Review", "amt3_review", amount2_review, amt3Review);
					}

					validateElementExist("Corporate New Wire Transfer", "AmountField", multipleAmount, totalAmount);

					clickOnElement("Corporate New Wire Transfer", "Confirm Button", confirmButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Multiple New Wire Transfer Review");
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details",
							"Review wire transfer details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details",
							"Could not review Wire transfer details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public String getMultipleWireTransaction() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(wireTransferHeader)) {
					List<WebElement> element = findElements(transacID);
					for (WebElement ele : element) {
						if(ele.getText().contains("DWR-")){
							transactionID = ele.getText();
							if(transID.equals("")) {
								transID =  transactionID;
							}else {

								transID = transID + "||" + transactionID;
							}
						}

					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass. Transaction Id is : " + transactionID);
					new HTMLReportHelper().HtmlReportBody("Get multiple wire transfer transacation details", "Get transactionId successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Get multiple wire transfer transacation details", "Could not get transactionId successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
		return transID;

	}








}

//	public void addTemplate(String mutipleTemplate) throws Exception {
//		if (System.getProperty("runStep")=="Y"){	
//			boolean stepResult = false;
//			try {
//				//String[] strmutipleTemplate = mutipleTemplate.length();
//				iTemplateCount = mutipleTemplate.length();
//				for (int i = 0; i<iTemplateCount;i++) {
//					//sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
//					if (i%5==0) {
//						 clickOnElement("Corporate New Wire Transfer", "More Template", addMoreTemplateButton); 
//					}
//					
//				}
//				stepResult = true;
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				if (stepResult==true){
//					System.out.println("Pass -- transfer date");
//					new HTMLReportHelper().HtmlReportBody("Wires CC- Corporate application", "Enter transfer date field successfully", "Passed", driver, "Y");
//				}
//				else{
//					System.out.println("fail");
//					new HTMLReportHelper().HtmlReportBody("Wires CC- Corporate application", "Could not Enter transfer date field successfully", "Failed", driver, "Y");
//					System.setProperty("runStep","N");
//				}
//			}
//		}
//	}
//	



