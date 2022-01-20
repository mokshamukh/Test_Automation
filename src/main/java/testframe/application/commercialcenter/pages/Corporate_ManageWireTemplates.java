package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Corporate_ManageWireTemplates
 * 
 * @author shilpa.thangapalam
 */

public class Corporate_ManageWireTemplates extends CommonLibrary{

	Corporate_NewWireTransfer corporate_NewWireTransfer;
	
	public Corporate_ManageWireTemplates(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		corporate_NewWireTransfer = new  Corporate_NewWireTransfer(driver);
		
	}
	
	By manageWireTemplatesHeader = By.xpath("//h1[text()='Manage Wire Templates']");
	By createTempalte = By.xpath("//button[contains(@aria-label,'To create a new template')]");
	By startWireTransfer = By.xpath("//h3[@id='selectWireHeading']");
	By selectPayeeButton =By.xpath("//label[text()='Select Payee']//..//div[contains(@class,'ui-state')]");
	By freeFormTemplateButton = By.xpath("//label[text()='Free-Form Template']//..//div[contains(@class,'ui-state')]");
	By nextButton = By.xpath("//button[contains(text(),'Next')]");
	By templateSettingsHeader = By.xpath("//h3[text()='Template Settings ']");
	By beneInformation = By.xpath("//h3[text()='Beneficiary Information ']");
	By repetitiveField = By.xpath("//p-radiobutton[@inputid='asc']//div//span[contains(@class,'ui-radiobutton')]");
	By semiRepetitiveField = By.xpath("//p-radiobutton[@inputid='desc']//div//span[contains(@class,'ui-radiobutton')]");
    By templateNameField = By.xpath("//input[@id='templateName']");
	By debitAccountField = By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']");
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
	By paymentCurrencyField = By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']");
	By purposeOfPaymentField = By.xpath("//input[@id='purposeOfPay']");
	By amountFiled = By.xpath("//input[@id='wireAmountId']");
	By requestTransferButton = By.xpath("//button[contains(@aria-label,'To proceed with the transfer')]");
	By payeeField = By.xpath("//input[@id='selectPayeeSearch']");
	By createTemplateButton = By.xpath("//button//span[text()='Create Template']");
	By templateSavedMsg = By.xpath("//div[text()='Template successfully saved.']");
	By searchButton = By.xpath("//button[contains(@aria-label,'To get the list matching the search criteria')]//i[text()='search']");
	
	
	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String searchData = "//td[@class='ng-star-inserted']//span[contains(text(),'%s')]";
	
	public void createWireTemplateForFreeForm(String freeFormTempalte, String repetitiveButton, String templateName,
			String payee,String debitAccount,String beneIdType,
			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2)throws Exception {
		boolean stepResult = false;
		try {
			waitElement(2000);
			if (isElementPresent(manageWireTemplatesHeader)) {
				clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
			    waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);
			    if (!freeFormTempalte.equals("Yes")) {
			    	clickOnElement("Manage Wire Template", "Free Form Template", freeFormTemplateButton);
				waitElement(500);
				clickOnElement("Manage Wire Template", "Next Button", nextButton);
				waitForPresenceOfElement("Manage Wire Template", "Tempalte Header", templateSettingsHeader);
				if (!repetitiveButton.equals("Yes")) {
					clickOnElement("Manage Wire Template", "RepetitiveField", repetitiveField);
				} else {
					clickOnElement("Manage Wire Template", "Semi-RepetitiveField", semiRepetitiveField);
				}
				if (!templateName.equals("")) {
					enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
				}
				if(!debitAccount.equals("")) {
					scrollToElement(debitAccountField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
					selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
				}
				scrollToElement(beneInformation);
				if (!payee.equals("")) {
					enterText("Manage Wire Template", "Payee Field", payeeName, payee);
				}
				if(!beneIdType.equals("")) {
					scrollToElement(beneIDTypeField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
				    selectElementFromListbox("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
				}
				if(!beneID.equals("")) {
					scrollToElement(beneIDField);
					enterText("Manage Wire Templater", "Beneficiary Id", beneIDField, beneID);
				}
				if(!beneAddress1.equals("")) {
					enterText("Manage Wire Template", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
				}
				if(!beneAddress2.equals("")) {
					enterText("Manage Wire Template", "Beneficiary Address2 Field", beneAddressField1, beneAddress2);
				}
				if(!beneCountry.equals("")) {
					scrollToElement(beneCountryField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
				    selectElementFromListbox("Manage Wire Template", "Beneficiary Country", beneCountryField, list, beneCountry);
				}
				if(!paymentCurrency.equals("")) {
					scrollToElement(paymentCurrencyField);
					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
				    selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
				}
				if(!amount.equals("")) {
					enterText("Manage Wire Template", "Amount Field", amountFiled, amount);
				}
				if(!beneBankIDType.equals("")) {
					scrollToElement(beneIDTypeField);
					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
				    selectElementFromListbox("Manage Wire Template", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
				}
				if(!beneBankID.equals("")) {
					enterText("Manage Wire Template", "Bene Bank ID", beneBankIdField, beneBankID);
				}
				if(!purposeOfPayment.equals("")) {
					scrollToElement(purposeOfPaymentField);
					enterText("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
				}
				if(!beneBankAddress1.equals("")) {
					enterText("Manage Wire Template", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
				}
				if(!beneBankAddress2.equals("")) {
					enterText("Manage Wire Template", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
				}
				
				clickOnElement("Manage Wire Template", "Create Tempalte Button", createTemplateButton);
				waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
             }
			} else {
				createWireTemplateForPayee(payee, repetitiveButton, templateName, debitAccount, paymentCurrency,
						purposeOfPayment, amount);
				}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
						"Created New Wire Template Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("ACH Batch Template- Corporate application",
						"Could not Created New Wire Template Successfully", "Failed", driver, "Y");
			}
		}

	}
			public void createWireTemplateForPayee(String payee,String repetitiveButton,String templateName,
					String debitAccount,String paymentCurrency,String purposeOfPayment,String amount) throws Exception {
				boolean stepResult = false;
				try {
					waitElement(2000);
					if (isElementPresent(manageWireTemplatesHeader)) {
						clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
						 waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);
					
						clickOnElement("Manage Wire Template", "Select Payee Template", selectPayeeButton);
					if (!payee.equals("")) {
						enterText("Manage Wire Template", "Payee Field", payeeField, payee);
						waitElement(1000);
						clickOnElement("Manage Wire Template", "payee List", getDynamicElement("Corporate New Wire Transfer", list, payee));
					}
					clickOnElement("Manage Wire Template", "Next Button", nextButton);
					if (!repetitiveButton.equals("Yes")) {
						clickOnElement("Manage Wire Template", "RepetitiveField", repetitiveField);
					} else {
						clickOnElement("Manage Wire Template", "Semi-RepetitiveField", semiRepetitiveField);
					}
					if (!templateName.equals("")) {
						enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
					}
					if(!debitAccount.equals("")) {
						scrollToElement(debitAccountField);
						driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
						selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
					}
					if(!paymentCurrency.equals("")) {
						scrollToElement(paymentCurrencyField);
						driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
					    selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
					}
					if(!purposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						enterText("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
					}
					if(!amount.equals("")) {
						enterText("Manage Wire Template", "Amount Field", amountFiled, amount);
					}
					clickOnElement("Manage Wire Template", "Create Tempalte Button", createTemplateButton);
					waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
					
					stepResult = true;
			}	
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (stepResult == true) {
						System.out.println("Pass - Menu");
						new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
								"Created New Wire Template Successfully", "Passed", driver, "Y");
					} else {
						System.out.println("fail");
						new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
								"Could not Created New Wire Template Successfully", "Failed", driver, "Y");
					}
				}

			}

			
	public void searchWireTemplate(String templateName,String amount,String payeeName) throws Exception {
				boolean stepResult = false;
				try {
					waitElement(2000);
					if (isElementPresent(manageWireTemplatesHeader)) {
						if (!templateName.equals("")) {
							enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
						}
						if(!amount.equals("")) {
							enterText("Manage Wire Template", "Amount Field", amountFiled, amount);
						}
						clickOnElement("Manage Wire Template", "Search Button", searchButton);
		                isElementPresent(getDynamicElement("Corporate New Payee", searchData, payeeName));
				stepResult = true;
			 }
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Search Wire Template- Corporate application",
							"Search Wire Template Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("ACH Batch Template- Corporate application",
							"Could not Search Wire Template Successfully", "Failed", driver, "Y");
				}
			}
			
	}		
			
		}
