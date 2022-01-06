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
 * PageNage : Corporate_NewACHBatchTemplate
 * 
 * @author Ketki.Badalwar
 */


public class Corporate_NewACHBatchTemplate extends CommonLibrary {
	
	 Corporate_ACHBatchTemplate corporateACHBatchTemplate;

	public By newAchBatchTitle = By.xpath("//h1[text()='New ACH Batch']");
	public By freeFormField = By.xpath("//input[@value='Free-Form']");
	public By templateField = By.xpath("//input[@value='Template']");
	public By achCompanyField = By.xpath("//p-dropdown[@inputid='achCompany-input']");
	public By debitCreditField = By.xpath("//p-dropdown[@inputid='debitCreditOptions-input']");
	public By batchTypeField = By.xpath("//p-dropdown[@inputid='batchTypeOptions-input']");
	public By nextButton = By.xpath("//button[contains(text(),'Next')]");
	public By achBatchDeailsTitle = By.xpath("//h3[text()='ACH Batch Details']");
	public By paymentDateField = By.xpath("//input[@id='paymentDate']");
	public By companyDiscretionaryDataField = By.xpath("//input[@id='companyDiscretionaryData']");
	public By companyEntryDiscretion = By.xpath("//input[@id='companyEntryDescription']");
	public By offsetAccount = By.xpath("//input[@id='offsetAccount']");
	public By reqBatchButton = By.xpath("//button[contains(text(),'Request Batch')]");
	public By searchExistingPayee = By
			.xpath("//button[contains(@aria-label,'search an existing payee')]/i[text()='search']");
	public By amount = By.xpath("//input[@id='newPayeeAmoountAdd']");
	public By addButton = By.xpath("//button[text()='Add']");
	public By emailCheckbox = By
			.xpath("//span[text()='Send Remittance Email to Payee']/..//p-checkbox[@inputid='excludeCheckbox1']");
	public By addAnotherPayee = By.xpath("//button[contains(@aria-label,'To add another payee')]/i");
	public By payeeName = By.xpath("//input[@id='displayName']");
	public By payeeAccount = By.xpath("//p-dropdown[@inputid='payeeAccount-input']");
	public By addendaField = By.xpath("//textarea[@id='extAddenda']");
	public By okButton = By.xpath("//button[text()='OK']");
	public By existPayee = By.xpath("//input[@id='payee']");
	public By existAccount = By.xpath("//input[@id='account']");
	public By existAmount = By.xpath("//input[@id='searchAmount']");
	public By existPayeeId = By.xpath("//input[@id='payeeId']");
	public By searchSymbol = By.xpath("//button[contains(@aria-label,'get the list matching the search criteria')]");
	public By reviewDetails = By.xpath("//th[contains(text(),'Payee')][@role='columnheader']//..//..//..//td[@class='ng-star-inserted'][1]");
	public By reviewAmt = By.xpath("//td[contains(@class,'bordered-last-column ng-star')]");
	public By confirmButton = By.xpath("//button[text()='Confirm']");
	public By pleaseReverifyTitle = By.xpath("//h4[contains(text(),'Please Reverify')]");
	public By confirmPassword = By.xpath("//input[@id='confirmPassword']");
	public By submitButton = By.xpath("//button[text()='Submit']");
	public By msg = By.xpath("//div[@class='alert-message-title']/strong");
	public By existTemplateName = By.xpath("//input[@id='templateName']");
	public By existTemplateField = By.xpath("(//input[contains(@class,'ui-autocomplete-input')])[2]");
	public By autoSaveMsg = By.xpath("//div[contains(text(),'An auto-saved draft created')]");
    public By requestBatchButton = By.xpath("//button[contains(@aria-label,'ACH batch details and proceed to the review screen.')]");
    public By alertmsg = By.xpath("//div[contains(text(),'Please correct the errors shown below')]");
	
	
	String achCompanyList = "//li[@role='option']/span[text()='%s']";
	String debitcreditList = "//li[@role='option']/span[text()='%s']";
	String batchTypeList = "//li[@role='option']/span[text()='Internet Auth (WEB)']";
	String existTemplateList = "//li[@role='option']/span[text()='%s']";
	String transactionID;
	//ul[contains(@class,'ui-autocomplete')][@role='listbox']

	public Corporate_NewACHBatchTemplate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		corporateACHBatchTemplate = new Corporate_ACHBatchTemplate(driver);
	}

	public void startAchPaymentWithFreeForm(String achCompany, String cardType, String batchType) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(newAchBatchTitle)) {
				clickOnElement("New ACH Batch Template", "free form field", freeFormField);
				if (!achCompany.equals("")) {
					selectElementFromListbox("New ACH Batch Template", "ACH Company", achCompanyField, achCompanyList,
							achCompany);
				}
				if (!cardType.equals("")) {
					driver.findElement(By.xpath("//p-dropdown[@inputid='debitCreditOptions-input']//div/span[text()='Select']")).click();
					selectElementFromListbox("New ACH Batch Templ6ate", "Debit/redit", debitCreditField, debitcreditList,
							cardType);
					Thread.sleep(2000);
				}
				if (!batchType.equals("")) {
					driver.findElement(By.xpath("//p-dropdown[@inputid='batchTypeOptions-input']//div/span[text()='Select']")).click();
					waitElement(1000);
					selectElementFromListbox("New ACH Batch Template", "Batch Type", batchTypeField, batchTypeList,
							batchType);
				}
				clickOnElement("New ACH Batch Template", "Next Button", nextButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Created start ACH  with free form Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not Created start ACH Payment with free form Successfully", "Failed", driver, "Y");
			}
		}

	}

	
	public void startAchPaymentWithTemplate(String existAchBatchTemplate) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(2000);
			if (isElementPresent(newAchBatchTitle)) {
				clickOnElement("New ACH Batch Template", "Template field", templateField);
				if (!existAchBatchTemplate.equals("")) {
					clickOnElement("New ACH Batch Template",  "Exist Template Name", existTemplateField);
					selectElementFromListbox("New ACH Batch Template", "Exist Template Name", existTemplateField, existTemplateList,existAchBatchTemplate);
				}
				clickOnElement("New ACH Batch Template", "Next Button", nextButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Created start ACH Payment Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not Created start ACH Payment Successfully", "Failed", driver, "Y");
			}
		}

	}

	
	public void enterACHPaymentDetails(String paymentDate, String cmpDiscretionary, String cmpEntryDiscretionary,
			String offsetAcc,String new_CreatePayeeName,String new_CreatePayeeID,String new_CreateAccountNumber,
			String new_CreateBankID,String new_CreateBankName,String new_CreateDebitAuthType,
			String new_Amount,String new_addenda,String new_sendRemittanceToPayee) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(achBatchDeailsTitle)) {
				if (!paymentDate.equals("")) {
					clearAndType("New ACH Batch Template", "Payment Date", paymentDateField, paymentDate);
				}
				if (!cmpDiscretionary.equals("")) {
					clearAndType("New ACH Batch Template", "Company Discretionary Data", companyDiscretionaryDataField,
							cmpDiscretionary);
				}
				if (!cmpEntryDiscretionary.equals("")) {
					clearAndType("New ACH Batch Template", "Company Entry Description", companyEntryDiscretion,
							cmpEntryDiscretionary);
				}
				if (!offsetAcc.equals("")) {
					clearAndType("New ACH Batch Template", "Offset Account", offsetAccount, offsetAcc);
					driver.findElement(By.xpath("//input[@id='offsetAccount']")).sendKeys(Keys.TAB);
				}
				if(!new_CreatePayeeName.equals("")) {
				corporateACHBatchTemplate.createNewPayee(new_CreatePayeeName, new_CreatePayeeID,new_CreateAccountNumber,
						new_CreateBankID,new_CreateBankName,new_CreateDebitAuthType,new_Amount,new_addenda,new_sendRemittanceToPayee);
				//searchPayee(existPayeeName, existPayeeAmt);
				//verifyPayeeandAddAmount(displaName, displayyAcc, amt, addenda);
//				}else {
//					searchPayee(existPayeeName, existPayeeAmt);
//				}
	}
			waitElement(5000);
			waitForPresenceOfElement("New ACH Batch Template", "Auto Save Message", autoSaveMsg);
			clickOnElement("New ACH Batch Template", "Request Batch Button", requestBatchButton);
			stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void searchPayee(String existPayeeName, String existPayeeAmt) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(achBatchDeailsTitle)) {
				clickOnElement("New ACH Batch Template", "Search Existing payees", searchExistingPayee);
				if (!existPayeeName.equals("")) {
					enterText("New ACH Batch Template", "Existing Payee", existPayee, existPayeeName);
				}
//				if (!existPayeeAccount.equals("")) {
//					enterText("New ACH Batch Template", "Existing Account", existAccount, existPayeeAccount);
//				}
				if (!existPayeeAmt.equals("")) {
					enterText("New ACH Batch Template", "Existing Amount", existAmount, existPayeeAmt);
				}
//				if (!existPayeeID.equals("")) {
//					enterText("New ACH Batch Template", "Existing Payee Id", existPayeeId, existPayeeID);
//				}
				clickOnElement("New ACH Batch Template", "Search Existing payees", searchSymbol);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void verifyPayeeandAddAmount(String displaName, String displayyAcc, String amt, String addenda) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(achBatchDeailsTitle)) {
				if (!displaName.equals("")) {
					enterText("New ACH Batch Template", "Payee", payeeName, displaName);
				}
				if (!displayyAcc.equals("")) {
					validateElementExist("New ACH Batch Template", "Account", payeeAccount, displayyAcc);
				}
				if (!amt.equals("")) {
					enterText("New ACH Batch Template", "Amount", amount, amt);
				}
				if (!addenda.equals("")) {
					clickOnElement("New ACH Batch Template", "Add Button", addButton);
					enterText("New ACH Batch Template", "Addenda", addendaField, addenda);
					clickOnElement("New ACH Batch Template", "Ok Button", okButton);
				}
				clickOnElement("New ACH Batch Template", "Request Batch", reqBatchButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void reviewAchBatchDetails(String payeeName, String amount) throws Exception {
		boolean stepResult = false;
		boolean flag = false;
		try {
			if (isElementPresent(achBatchDeailsTitle)) {
				List<WebElement> element = findElements(reviewDetails);
				for (WebElement ele : element) {
					if (ele.getText().contains(payeeName)) {
						flag = true;
					} else {
						flag = false;
					}
				}
			}
			validateElementExist("New ACH Batch Template", "AmountField", reviewAmt, amount);
			//validateElementAttributeContains("New ACH Batch Template", "Amount", reviewAmt, "text", amount);
			clickOnElement("New ACH Batch Template", "Confirm Button", confirmButton);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void verifyPassword(String psw) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(pleaseReverifyTitle)) {
				if (!psw.equals("")) {
					enterText("New ACH Batch Template", "Password", confirmPassword, psw);
				}
				clickOnElement("New ACH Batch Template", "Submit Button", submitButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}

	}

	public String getTransaction() throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(achBatchDeailsTitle)) {
				transactionID = getElementText("New ACH Batch Template", "Alert Message", msg);
				transactionID = transactionID.replaceAll("\\.", "");
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"enter ACH Payment details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New ACH Batch Template- Corporate application",
						"Could not enter ACH Payment details Successfully", "Failed", driver, "Y");
			}
		}
		return transactionID;

	}
	
	
	
	
}
