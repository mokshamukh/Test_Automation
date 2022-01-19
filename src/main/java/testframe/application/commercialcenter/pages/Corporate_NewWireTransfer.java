package testframe.application.commercialcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
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

public class Corporate_NewWireTransfer extends CommonLibrary{

	public Corporate_NewWireTransfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	By wireTransferHeader = By.xpath("//h1[text()='Wire Transfer']");
	By startWireTransfer = By.xpath("//h3[@id='selectWireHeading']");
	By searchPayeeField = By.xpath("//label[text()='Payee']//..//div[contains(@class,'ui-state')]");
	By freeFormField = By.xpath("//label[text()='Free-Form']//..//div[contains(@class,'ui-state')]");
	By payeeField = By.xpath("//input[@id='selectPayeeSearch']");
	By nextButton = By.xpath("//button[contains(text(),'Next')]");
	By accountInfoHeader = By.xpath("//h3[text()='Account Information ']");
	By debitAccountField = By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']");
	By paymentCurrencyField = By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']");
	By purposeOfPaymentField = By.xpath("//input[@id='purposeOfPay']");
	By amountFiled = By.xpath("//input[@id='wireAmountId']");
	By requestTransferButton = By.xpath("//button[contains(@aria-label,'To proceed with the transfer')]");
	By accountInfoDetails = By.xpath("//h3[contains(text(),'Account Information')]");
	By reviewDetails = By.xpath("//div[text()='Debit Account']//..//span[@id='debitAccount'][text()]");
	By reviewAmount = By.xpath("//h4[@role='heading']//..//..//..//div[@id='Payment Amount']");
	By confirmButton = By.xpath("//button[text()='Confirm']");
	By pleaseReverifyTitle = By.xpath("//h4[contains(text(),'Please Reverify')]");
	By confirmPassword = By.xpath("//input[@id='confirmPassword']");
	By submitButton = By.xpath("//button[text()='Submit']");
	By msg = By.xpath("//div[@class='alert-message-title']/b");
	By beneInformation = By.xpath("//h3[text()='Beneficiary Information ']");
	By payeeName = By.xpath("//input[@id='payeeName']");
	By beneIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryIdType']");
	By beneIDField = By.xpath("//input[@id='beneficiaryId']");
	By beneAddressField1 = By.xpath("//input[@id='beneficiaryAddress1']");
	By beneAddressField2 = By.xpath("//input[@id='beneficiaryAddress2']");
	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry']");
	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']");
	By beneBankIdField = By.xpath("//input[@id='beneficiaryBankId']");
	By beneBankAddress1Field = By.xpath("//input[@id='beneficiaryBankAddress1']");
	By beneBankAddress2Field = By.xpath("//input[@id='beneficiaryBankAddress2']");
	By beneBankCountry = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry']");
	By benePhoneNumber = By.xpath("//input[@id='phoneNumber']");
	
	
	
	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String transactionID;
	
	public void createNewWireTransferUsingPayee(String payee,String debitAccount,String paymentCurrency,
			String purposeOfPayment,String amount) throws Exception{
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
					scrollToElement(debitAccountField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
					selectElementFromListbox("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, list,debitAccount);      
				}
				if(!paymentCurrency.equals("")) {
					scrollToElement(paymentCurrencyField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
				    selectElementFromListbox("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
				}
				if(!purposeOfPayment.equals("")) {
					scrollToElement(purposeOfPaymentField);
					enterText("Corporate New Wire Transfer", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
				}
				if(!amount.equals("")) {
					enterText("Corporate New Wire Transfer", "Amount Field", amountFiled, amount);
				}
				clickOnElement("Corporate New Wire Transfer", "Request Transfer Button", requestTransferButton);
             }
			
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - From acc");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "New Wire Transfer created Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not create New Wire Transfer Successfully", "Failed", driver, "Y");
			}
		}
	}
		
	public void reviewWireTransferDetails(String debitAccount, String amount) throws Exception {
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
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"review Wire Transfer details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"Could not review Wire Transfer details Successfully", "Failed", driver, "Y");
			}
		}

	}
	
	public void verifyPassword(String password) throws Exception {
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
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"enter password Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"Could not enter password Successfully", "Failed", driver, "Y");
			}
		}

	}
	
	public String getTransaction() throws Exception {
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
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}
		return transactionID;

	}
	
	
	public void createNewWireTransferUsingFreeForm(String payee,String debitAccount,String beneIdType,
			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(wireTransferHeader)) {
				clickOnElement("Corporate New Wire Transfer", "Free Form Field", freeFormField);
			    
				clickOnElement("Corporate New Wire Transfer", "Next Button", nextButton);
				
				waitForPresenceOfElement("Corporate New Wire Transfer","Account Information Header", accountInfoHeader);
				if(!debitAccount.equals("")) {
					scrollToElement(debitAccountField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
					selectElementFromListbox("Corporate New Wire Transfer", "Debit Account Field", debitAccountField, list,debitAccount);      
				}
				scrollToElement(beneInformation);
				if (!payee.equals("")) {
					enterText("Corporate New Wire Transfer", "Payee Field", payeeName, payee);
				}
				if(!beneIdType.equals("")) {
					scrollToElement(beneIDTypeField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
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
					enterText("Corporate New Wire Transfer", "Beneficiary Address2 Field", beneAddressField1, beneAddress2);
				}
				if(!beneCountry.equals("")) {
					scrollToElement(beneCountryField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
				    selectElementFromListbox("Corporate New Wire Transfer", "Beneficiary Country", beneCountryField, list, beneCountry);
				}
				if(!paymentCurrency.equals("")) {
					scrollToElement(paymentCurrencyField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
				    selectElementFromListbox("Corporate New Wire Transfer", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
				}
				if(!amount.equals("")) {
					enterText("Corporate New Wire Transfer", "Amount Field", amountFiled, amount);
				}
				if(!beneBankIDType.equals("")) {
					scrollToElement(beneIDTypeField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
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
             }
			
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - From acc");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "New Wire Transfer created Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Wire Transfer CC- Corporate application", "Could not create New Wire Transfer Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
}
