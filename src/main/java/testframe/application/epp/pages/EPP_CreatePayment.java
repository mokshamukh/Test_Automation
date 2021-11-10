package testframe.application.epp.pages;

/**
 * PageName : EPP_CreatePayment
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_CreatePayment extends CommonLibrary {

	static String transactionID;
	String savedtransactionID;

	public EPP_CreatePayment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	By orderingBankaccNum = By.xpath("//input[@id='OrderInstID']");
	By orderBankSystemCode = By.xpath("//select[@id='OrderInstIDType']");
	By orderBankLookUp = By.xpath("//span[@id='OrderInstIDTypeWrapper']//..//div[@id='img_button_lookUp']");
	By debitAcc = By.xpath("//input[@id='Debit_Account_Override']");
	By amountTxtBox = By.xpath("//input[@id='Amount']");
	By beneBankAccount = By.xpath("//input[@id='BenBankAccount']");
	By beneBankLookUp = By.xpath(
			"//table[@id='BeneficiaryBankTable']//input[@id='BenBankAccountType']//..//div[@id='img_button_lookUp']");
	By beneBankName = By.xpath("//input[@id='BenBankName']");
	By beneBankAddress = By.xpath("//input[@id='BenBankAddress1']");
	By accWithBankNum = By.xpath("//input[@id='AcctWInstID']");
	By accSystemCode = By.xpath("//select[@id='AcctWInstIDType']");
	By accWithBankLookup = By.xpath("//span[@id='AcctWInstIDTypeWrapper']//..//div[@id='img_button_lookUp']");
	By validateBttn = By.xpath("//a[@id='Validate']");
	By abanbonBttn = By.xpath("//a[@id='Abandon']");
	By validateSubmitBttn = By.xpath("//div[@id='img_button_validate&Submit']");
	By confirmWindow = By.xpath("//div[@id='confirmWindow']");
	By submitPayment = By.xpath("//input[@id='SubmitPayment']");
	By cancelBtn = By.xpath("//input[@id='Cancel']");
	By paymentSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By bicTxtBox = By.xpath("//input[@id='OrderCustBIC']");
	By custaccountNum = By.xpath("//input[@id='OrderCustAccount']");
	By custLookup = By.xpath("//input[@name='OrderCustBIC']//..//div[@id='img_button_lookUp']");
	By beneCustAccount = By.xpath("//input[@id='BenCustAccount']");
	By beneCustName = By.xpath("//input[@id='BenCustName']");
	By beneCustAddress = By.xpath("//input[@id='BenCustAddress1']");
	By incomngOrderBankExpand = By.xpath("//table[@id='OrderingBankTable']//..//td[contains(text(),'Ordering Bank')]");
	By beneCustLookUp = By.xpath("//input[@id='BenCustAccount']//..//div[@id='img_button_lookUp']");
	By creditAcc = By.xpath("//input[@id='Credit_Account_Override']");

	public String eppCreatePayment = "EPP_CreatePayment";
	public String createPaymentTitle = "//div[@id='headerBar']//td[contains(text(),'%s')]";
	public String PaymentTemplate = "Payment Template";

	public void createOutgoingHVBankPaymentFRB(String value, String accNum, String systemCode, String debitAccount,
			String amount, String benAccount, String beneName, String beneAddress, String accWithBankNo,
			String accWithSysCode) {
		boolean stepResult = false;
		try {
			getDynamicElement(eppCreatePayment, createPaymentTitle, value);
			enterText(eppCreatePayment, "Ordering Bank Account", orderingBankaccNum, accNum);
			waitElement(3000);
			selectElementByVisibleText(eppCreatePayment, "System Code", orderBankSystemCode, systemCode);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Ordering Bank_LookUp", orderBankLookUp);
			waitElement(3000);
			enterText(eppCreatePayment, "Debit Account", debitAcc, debitAccount);
			waitElement(3000);
			enterText(eppCreatePayment, "Amount", amountTxtBox, amount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Bank Account", beneBankAccount, benAccount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Name", beneBankName, beneName);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Address", beneBankAddress, beneAddress);
			waitElement(3000);
			enterText(eppCreatePayment, "Account With Bank", accWithBankNum, accWithBankNo);
			waitElement(3000);
			enterText(eppCreatePayment, "Account With Bank System Code", accSystemCode, accWithSysCode);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Account With Bank_LookUp", accWithBankLookup);
			waitElement(5000);
			clickOnElement(eppCreatePayment, "Validate Button", validateBttn);
			waitElement(8000);
			waitForPresenceOfElement(eppCreatePayment, "Validation Successfull Window", confirmWindow);
			waitElement(5000);
			clickOnElement(eppCreatePayment, "Submit Payment Button", submitPayment);
			waitElement(4000);
			if (isElementPresent(paymentSaved)) {
				savedtransactionID = getElementText(PaymentTemplate, "Transaction ID", paymentSaved);
			}
			getTransactionID();
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				//new HTMLReportHelper().HtmlReportBody("TransactionID - EPP application", "Created Successfully","Passed", driver, "Y");
				new HTMLReportHelper().HtmlReportBody("TransactionID no'" + transactionID +"' is", "Created Successfully on '" + value +"' Create Payment", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application","Could not Create Successfully", "Failed", driver, "Y");
			}
		}
	}

	public String getTransactionID() {
		boolean stepResult = false;
		try {
			if (!(savedtransactionID == null)) {
				transactionID = savedtransactionID;
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
		return transactionID;

	}

	public void createOutgoingHVCustomerPaymentFRB(String value, String custAccNum, String debitAccount, String amount,
			String benCustAccount, String benecustName, String benecustAddress, String accWithBankNo,
			String accWithSysCode) {
		boolean stepResult = false;
		try {
			getDynamicElement(eppCreatePayment, createPaymentTitle, value);
			enterText(eppCreatePayment, "Ordering Customer Account", custaccountNum, custAccNum);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Ordering Customer_LookUp", custLookup);
			waitElement(8000);
			enterText(eppCreatePayment, "Debit Account", debitAcc, debitAccount);
			waitElement(3000);
			enterText(eppCreatePayment, "Customer_Amount", amountTxtBox, amount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Customer Account", beneCustAccount, benCustAccount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Name", beneCustName, benecustName);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Address", beneCustAddress, benecustAddress);
			waitElement(3000);
			enterText(eppCreatePayment, "Account With Bank", accWithBankNum, accWithBankNo);
			waitElement(3000);
			enterText(eppCreatePayment, "Account With Bank System Code", accSystemCode, accWithSysCode);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Account With Bank_LookUp", accWithBankLookup);
			waitElement(5000);
			clickOnElement(eppCreatePayment, "Validate Button", validateBttn);
			waitElement(8000);
			waitForPresenceOfElement(eppCreatePayment, "Validation Successfull Window", confirmWindow);
			waitElement(4000);
			clickOnElement(eppCreatePayment, "Submit Payment Button", submitPayment);
			waitElement(4000);
			if (isElementPresent(paymentSaved)) {
				savedtransactionID = getElementText(PaymentTemplate, "Transaction ID", paymentSaved);
			}
			getTransactionID();
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application", "Created Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application",
						"Could not Create Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void createIncomingHVCustomerPaymentFRB(String value, String custAccNum, String bankAccNum,
			String bankSystemCode, String amount, String benCustAccount, String creditAccNum, String accWithBankNo,
			String accWithSysCode) {
		boolean stepResult = false;
		try {
			getDynamicElement(eppCreatePayment, createPaymentTitle, value);
			enterText(eppCreatePayment, "Ordering Customer Account", custaccountNum, custAccNum);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Ordering Bank Expand Button", incomngOrderBankExpand);
			waitElement(3000);
			enterText(eppCreatePayment, "Ordering Bank Account", orderingBankaccNum, bankAccNum);
			waitElement(3000);
			selectElementByVisibleText(eppCreatePayment, "System Code", orderBankSystemCode, bankSystemCode);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Ordering Bank_LookUp", orderBankLookUp);
			waitElement(8000);
			enterText(eppCreatePayment, "Customer_Amount", amountTxtBox, amount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Customer Account", beneCustAccount, benCustAccount);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Bene Customer_LookUp", beneCustLookUp);
			waitElement(8000);
			enterText(eppCreatePayment, "Credit Account", creditAcc, creditAccNum);
			waitElement(5000);
			clickOnElement(eppCreatePayment, "Validate Button", validateBttn);
			waitElement(8000);
			waitForPresenceOfElement(eppCreatePayment, "Validation Successfull Window", confirmWindow);
			waitElement(4000);
			clickOnElement(eppCreatePayment, "Submit Payment Button", submitPayment);
			waitElement(4000);
			if (isElementPresent(paymentSaved)) {
				savedtransactionID = getElementText(PaymentTemplate, "Transaction ID", paymentSaved);
			}
			getTransactionID();
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application", "Created Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application",
						"Could not Create Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void createIncomingHVBankPaymentFRB(String value, String bankAccNum, String bankSystemCode, String amount,
			String benCustAccount, String creditAccNum, String accWithBankNo, String accWithSysCode) {
		boolean stepResult = false;
		try {
			getDynamicElement(eppCreatePayment, createPaymentTitle, value);
			enterText(eppCreatePayment, "Ordering Bank Account", orderingBankaccNum, bankAccNum);
			waitElement(3000);
			selectElementByVisibleText(eppCreatePayment, "System Code", orderBankSystemCode, bankSystemCode);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Ordering Bank_LookUp", orderBankLookUp);
			waitElement(8000);
			enterText(eppCreatePayment, "Customer_Amount", amountTxtBox, amount);
			waitElement(3000);
			enterText(eppCreatePayment, "Benificiary Customer Account", beneBankAccount, benCustAccount);
			waitElement(3000);
			clickOnElement(eppCreatePayment, "Bene Customer_LookUp", beneBankLookUp);
			waitElement(8000);
			enterText(eppCreatePayment, "Credit Account", creditAcc, creditAccNum);
			waitElement(5000);
			clickOnElement(eppCreatePayment, "Validate Button", validateBttn);
			waitElement(8000);
			waitForPresenceOfElement(eppCreatePayment, "Validation Successfull Window", confirmWindow);
			waitElement(4000);
			clickOnElement(eppCreatePayment, "Submit Payment Button", submitPayment);
			waitElement(4000);
			if (isElementPresent(paymentSaved)) {
				savedtransactionID = getElementText(PaymentTemplate, "Transaction ID", paymentSaved);
			}
			getTransactionID();
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application", "Created Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create EPP Payment- EPP application",
						"Could not Create Successfully", "Failed", driver, "Y");
			}
		}

	}

}
