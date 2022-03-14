package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Corporate_ManageWireTemplates
 * 
 * @author shilpa.thangapalam
 */

//public class Corporate_ManageWireTemplates extends CommonLibrary{
//
//	Corporate_NewWireTransfer corporate_NewWireTransfer;
//	
//	public Corporate_ManageWireTemplates(WebDriver driver) {
//		super(driver);
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		corporate_NewWireTransfer = new  Corporate_NewWireTransfer(driver);
//		
//	}
//	
//	By manageWireTemplatesHeader = By.xpath("//h1[text()='Manage Wire Templates']");
//	By createTempalte = By.xpath("//button[contains(@aria-label,'To create a new template')]");
//	By startWireTransfer = By.xpath("//h3[@id='selectWireHeading']");
//	By selectPayeeButton =By.xpath("//label[text()='Select Payee']//..//div[contains(@class,'ui-state')]");
//	By freeFormTemplateButton = By.xpath("//label[text()='Free-Form Template']//..//div[contains(@class,'ui-state')]");
//	By nextButton = By.xpath("//button[contains(text(),'Next')]");
//	By templateSettingsHeader = By.xpath("//h3[text()='Template Settings ']");
//	By beneInformation = By.xpath("//h3[text()='Beneficiary Information ']");
//	By repetitiveField = By.xpath("//p-radiobutton[@inputid='asc']//div//span[contains(@class,'ui-radiobutton')]");
//	By semiRepetitiveField = By.xpath("//p-radiobutton[@inputid='desc']//div//span[contains(@class,'ui-radiobutton')]");
//    By templateNameField = By.xpath("//input[@id='templateName']");
//	By debitAccountField = By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']");
//	By payeeName = By.xpath("//input[@id='payeeName']");
//	By beneIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryIdType']");
//	By beneIDField = By.xpath("//input[@id='beneficiaryId']");
//	By beneAddressField1 = By.xpath("//input[@id='beneficiaryAddress1']");
//	By beneAddressField2 = By.xpath("//input[@id='beneficiaryAddress2']");
//	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry']");
//	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']");
//	By beneBankIdField = By.xpath("//input[@id='beneficiaryBankId']");
//	By beneBankAddress1Field = By.xpath("//input[@id='beneficiaryBankAddress1']");
//	By beneBankAddress2Field = By.xpath("//input[@id='beneficiaryBankAddress2']");
//	By beneBankCountry = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry']");
//	By benePhoneNumber = By.xpath("//input[@id='phoneNumber']");
//	By paymentCurrencyField = By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']");
//	By purposeOfPaymentField = By.xpath("//input[@id='purposeOfPay']");
//	By amountField = By.xpath("//input[@id='amount']");
//	By searchAmount = By.xpath("//input[@id='primaryAmount']");
//	By requestTransferButton = By.xpath("//button[contains(@aria-label,'To proceed with the transfer')]");
//	By payeeField = By.xpath("//input[@id='selectPayeeSearch']");
//	By createTemplateButton = By.xpath("//button//span[text()='Create Template']");
//	By templateSavedMsg = By.xpath("//div[text()='Template successfully saved.']");
//	By searchButton = By.xpath("//button[contains(@aria-label,'To get the list matching the search criteria')]//i[text()='search']");
//	By accountInfoDetails = By.xpath("//h3[contains(text(),'Account Information')]");
//	By reviewDetails = By.xpath("//div[text()='Debit Account']//..//span[@id='debitAccount'][text()]");
//	By reviewAmount = By.xpath("//h4[@role='heading']//..//..//..//div[@id='Payment Amount']");
//	By confirmButton = By.xpath("//button[text()='Confirm']");
//	By editHeader = By.xpath("//h1[contains(text(),'Edit')]");
//	By editIcon = By.xpath("//button[@aria-label='To edit the template, click the icon']");
//	By saveTemplate = By.xpath("//button//span[text()='Save Template']");
//	By searchExpand =By.xpath("//button[contains(@aria-label,'To get the list of templates matching the search')]//i[text()='expand_more']");
//	
//	
//	String list = "//li[@role='option']/span[contains(text(),'%s')]";
//	String searchData = "//td[@class='ng-star-inserted']//span[contains(text(),'%s')]";
//	
//	public void createWireTemplateForFreeForm(String freeFormTemplate, String repetitiveButton, String templateName,
//			String payee,String debitAccount,String beneIdType,
//			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
//			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
//			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2)throws Exception {
//		boolean stepResult = false;
//		try {
//			waitElement(2000);
//			if (isElementPresent(manageWireTemplatesHeader)) {
//				clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
//			    waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);
//			    if (!freeFormTemplate.equals("NA")) {
//			    	clickOnElement("Manage Wire Template", "Free Form Template", freeFormTemplateButton);
//				waitElement(500);
//				clickOnElement("Manage Wire Template", "Next Button", nextButton);
//				waitForPresenceOfElement("Manage Wire Template", "Tempalte Header", templateSettingsHeader);
//				if (!repetitiveButton.equals("Yes")) {
//					clickOnElement("Manage Wire Template", "RepetitiveField", repetitiveField);
//				} else {
//					clickOnElement("Manage Wire Template", "Semi-RepetitiveField", semiRepetitiveField);
//				}
//				if (!templateName.equals("")) {
//					enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
//				}
//				if(!debitAccount.equals("")) {
//					scrollToElement(debitAccountField);
//					driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
//					selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
//				}
//				scrollToElement(beneInformation);
//				if (!payee.equals("")) {
//					enterText("Manage Wire Template", "Payee Field", payeeName, payee);
//				}
//				if(!beneIdType.equals("")) {
//					scrollToElement(beneIDTypeField);
//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
//				}
//				if(!beneID.equals("")) {
//					scrollToElement(beneIDField);
//					enterText("Manage Wire Templater", "Beneficiary Id", beneIDField, beneID);
//				}
//				if(!beneAddress1.equals("")) {
//					enterText("Manage Wire Template", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
//				}
//				if(!beneAddress2.equals("")) {
//					enterText("Manage Wire Template", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
//				}
//				if(!beneCountry.equals("")) {
//					scrollToElement(beneCountryField);
//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryCountry']")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Country", beneCountryField, list, beneCountry);
//				}
//				if(!paymentCurrency.equals("")) {
//					scrollToElement(paymentCurrencyField);
//					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
//				    selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
//				}
//				if(!amount.equals("")) {
//					enterText("Manage Wire Template", "Amount Field", amountField, amount);
//				}
//				if(!beneBankIDType.equals("")) {
//					scrollToElement(beneBankIDTypeField);
//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
//				}
//				if(!beneBankID.equals("")) {
//					enterText("Manage Wire Template", "Bene Bank ID", beneBankIdField, beneBankID);
//				}
//				if(!purposeOfPayment.equals("")) {
//					scrollToElement(purposeOfPaymentField);
//					enterText("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
//				}
//				if(!beneBankAddress1.equals("")) {
//					enterText("Manage Wire Template", "Beneficiary Bank Address1 Field", beneBankAddress1Field, beneBankAddress1);
//				}
//				if(!beneBankAddress2.equals("")) {
//					enterText("Manage Wire Template", "Beneficiary Bank Address2 Field", beneBankAddress2Field, beneBankAddress2);
//				}
//				
//				clickOnElement("Manage Wire Template", "Create Tempalte Button", createTemplateButton);
//				waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
//				stepResult = true;
//             }
//			} else {
//				createWireTemplateForSelectPayee(payee, repetitiveButton, templateName, debitAccount, paymentCurrency,
//						purposeOfPayment, amount);
//				stepResult = true;
//				}
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (stepResult == true) {
//				System.out.println("Pass - Menu");
//				new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
//						"Created New Wire Template successfully", "Passed", driver, "Y");
//			} else {
//				System.out.println("fail");
//				new HTMLReportHelper().HtmlReportBody("ACH Batch Template- Corporate application",
//						"Could not Created New Wire Template successfully", "Failed", driver, "Y");
//			}
//		}
//
//	}
//			public void createWireTemplateForSelectPayee(String payee,String repetitiveButton,String templateName,
//					String debitAccount,String paymentCurrency,String purposeOfPayment,String amount) throws Exception {
//				boolean stepResult = false;
//				try {
//					waitElement(2000);
//					if (isElementPresent(manageWireTemplatesHeader)) {
//						clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
//						 waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);
//					
//						clickOnElement("Manage Wire Template", "Select Payee Template", selectPayeeButton);
//					if (!payee.equals("")) {
//						enterText("Manage Wire Template", "Payee Field", payeeField, payee);
//						waitElement(1000);
//						clickOnElement("Manage Wire Template", "payee List", getDynamicElement("Corporate New Wire Transfer", list, payee));
//					}
//					clickOnElement("Manage Wire Template", "Next Button", nextButton);
//					if (!repetitiveButton.equals("Yes")) {
//						clickOnElement("Manage Wire Template", "RepetitiveField", repetitiveField);
//					} else {
//						clickOnElement("Manage Wire Template", "Semi-RepetitiveField", semiRepetitiveField);
//					}
//					if (!templateName.equals("")) {
//						enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
//					}
//					if(!debitAccount.equals("")) {
//						scrollToElement(debitAccountField);
//						driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
//						selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
//					}
//					if(!paymentCurrency.equals("")) {
//						scrollToElement(paymentCurrencyField);
//						driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
//					    selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
//					}
//					if(!purposeOfPayment.equals("")) {
//						scrollToElement(purposeOfPaymentField);
//						enterText("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
//					}
//					if(!amount.equals("")) {
//						enterText("Manage Wire Template", "Amount Field", amountField, amount);
//					}
//					clickOnElement("Manage Wire Template", "Create Tempalte Button", createTemplateButton);
//					waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
//					
//					stepResult = true;
//			}	
//				} catch (Exception e) {
//					e.printStackTrace();
//				} finally {
//					if (stepResult == true) {
//						System.out.println("Pass - Menu");
//						new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
//								"Created New Wire Template successfully", "Passed", driver, "Y");
//					} else {
//						System.out.println("fail");
//						new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
//								"Could not Created New Wire Template successfully", "Failed", driver, "Y");
//					}
//				}
//
//			}
//
//			
//	public void searchWireTemplate(String templateName,String amount) throws Exception {
//				boolean stepResult = false;
//				try {
//					waitElement(2000);
//					if (isElementPresent(manageWireTemplatesHeader)) {
//						if(isElementPresent(searchExpand)) {
//							clickOnElement("Manage Wire Template", "Search Field", searchExpand);
//						}
//						if (!templateName.equals("")) {
//							enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
//						}
//						if(!amount.equals("")) {
//							enterText("Manage Wire Template", "Amount Field", searchAmount, amount);
//						}
//						clickOnElement("Manage Wire Template", "Search Button", searchButton);
//		                isElementPresent(getDynamicElement("Corporate New Template", searchData, templateName));
//				stepResult = true;
//			 }
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				if (stepResult == true) {
//					System.out.println("Pass - Menu");
//					new HTMLReportHelper().HtmlReportBody("Search Wire Template- Corporate application",
//							"Search Wire Template successfully", "Passed", driver, "Y");
//				} else {
//					System.out.println("fail");
//					new HTMLReportHelper().HtmlReportBody("Search Wire Template- Corporate application",
//							"Could not Search Wire Template successfully", "Failed", driver, "Y");
//				}
//			}
//			
//	}		
//	
//	public void reviewManageWireTempaltes(String debitAccount, String amount) throws Exception {
//		boolean stepResult = false;
//		boolean flag = false;
//		try {
//			if (isElementPresent(accountInfoDetails)) {
////				List<WebElement> element = findElements(reviewDetails);
////				for (WebElement ele : element) {
////					if (ele.getText().contains(debitAccount)) {
////						flag = true;
////					} else {
////						flag = false;
////					}
////				}
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
//	
//	public void editExistingWireTemplate(String update_Payee,String update_BeneIdType,
//			String update_BeneID,String update_BeneAddress1,String update_BeneAddress2,String update_BeneCountry,
//			String update_BeneBankIDType,String update_PaymentCurrency,String update_Amount,String update_BeneBankID,
//			String update_PurposeOfPayment,String update_BeneBankAddress1,String update_BeneBankAddress2) throws Exception {
//		boolean stepResult = false;
//		try {
//			waitElement(2000);
//			if (isElementPresent(manageWireTemplatesHeader)) {
//				clickOnElement("Manage Wire Templates", "Edit Wire Template", editIcon);
//				waitForPresenceOfElement("Manage Wire Templates", "Edit Wire Template", editHeader);
//				clickOnELementUsingActions(beneInformation);
//				//scrollToElement(beneInformation);
//				if (!update_Payee.equals("")) {
//					clearAndType("Manage Wire Template", "Payee Field", payeeName, update_Payee);
//				}
//				if(!update_BeneIdType.equals("")) {
//					clickOnELementUsingActions(beneIDTypeField);
////					scrollToElement(beneIDTypeField);
////					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField, list, update_BeneIdType);
//				}
//				if(!update_BeneID.equals("")) {
//					scrollToElement(beneIDField);
//					clearAndType("Manage Wire Templater", "Beneficiary Id", beneIDField, update_BeneID);
//				}
//				if(!update_BeneAddress1.equals("")) {
//					clearAndType("Manage Wire Template", "Beneficiary Address1 Field", beneAddressField1, update_BeneAddress1);
//				}
//				if(!update_BeneAddress2.equals("")) {
//					clearAndType("Manage Wire Template", "Beneficiary Address2 Field", beneAddressField2, update_BeneAddress2);
//				}
//				if(!update_BeneCountry.equals("")) {
//					clickOnELementUsingActions(beneCountryField);
////					scrollToElement(beneCountryField);
////					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryCountry']")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Country", beneCountryField, list, update_BeneCountry);
//				}
//				if(!update_PaymentCurrency.equals("")) {
//					clickOnELementUsingActions(paymentCurrencyField);
////					scrollToElement(paymentCurrencyField);
////					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
//				    selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, update_PaymentCurrency);
//				}
//				if(!update_Amount.equals("")) {
//					clearAndType("Manage Wire Template", "Amount Field", amountField, update_Amount);
//				}
//				if(!update_BeneBankIDType.equals("")) {
//					clickOnELementUsingActions(beneBankIDTypeField);
////					scrollToElement(beneBankIDTypeField);
////					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
//				    selectElementFromListbox("Manage Wire Template", "Beneficiary Bank ID Type", beneBankIDTypeField, list, update_BeneBankIDType);
//				}
//				if(!update_BeneBankID.equals("")) {
//					clearAndType("Manage Wire Template", "Bene Bank ID", beneBankIdField, update_BeneBankID);
//				}
//				if(!update_PurposeOfPayment.equals("")) {
//					scrollToElement(purposeOfPaymentField);
//					clearAndType("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, update_PurposeOfPayment);
//				}
//				if(!update_BeneBankAddress1.equals("")) {
//					clearAndType("Manage Wire Template", "Beneficiary Bank Address1 Field", beneBankAddress1Field, update_BeneBankAddress1);
//				}
//				if(!update_BeneBankAddress2.equals("")) {
//					clearAndType("Manage Wire Template", "Beneficiary Bank Address2 Field", beneBankAddress2Field, update_BeneBankAddress2);
//				}
//				
//				clickOnElement("Manage Wire Template", "Save Tempalte Button", saveTemplate);
//				waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
//				stepResult = true;
//             }
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		if (stepResult == true) {
//			System.out.println("Pass - Menu");
//			new HTMLReportHelper().HtmlReportBody("Edit Wire Template- Corporate application",
//					"Edit Wire Template successfully", "Passed", driver, "Y");
//		} else {
//			System.out.println("fail");
//			new HTMLReportHelper().HtmlReportBody("Edit Wire Template- Corporate application",
//					"Could not Edit Wire Template successfully", "Failed", driver, "Y");
//		}
//	}
//	
//}		
//	
//	
//			
//		}
//=======

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
	By beneIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//span[contains(@class,'expand_more')]");
	By beneIDField = By.xpath("//input[@id='beneficiaryId']");
	By beneAddressField1 = By.xpath("//input[@id='beneficiaryAddress1']");
	By beneAddressField2 = By.xpath("//input[@id='beneficiaryAddress2']");
	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry']//span[contains(@class,'expand_more')]");
	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//span[contains(@class,'expand_more')]");
	By beneBankIdField = By.xpath("//input[@id='beneficiaryBankId']");
	By beneBankAddress1Field = By.xpath("//input[@id='beneficiaryBankAddress1']");
	By beneBankAddress2Field = By.xpath("//input[@id='beneficiaryBankAddress2']");
	By beneBankCountry = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry']//span[contains(@class,'expand_more')]");
	By benePhoneNumber = By.xpath("//input[@id='phoneNumber']");
	By paymentCurrencyField = By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']");
	By purposeOfPaymentField = By.xpath("//input[@id='purposeOfPay']");
	By amountField = By.xpath("//input[@id='amount']");
	By payeeAmountField = By.xpath("//input[@id='wireAmountId']");
	By searchAmount = By.xpath("//input[@id='primaryAmount']");
	By requestTransferButton = By.xpath("//button[contains(@aria-label,'To proceed with the transfer')]");
	By payeeField = By.xpath("//input[@id='selectPayeeSearch']");
	By createTemplateButton = By.xpath("//button//span[text()='Create Template']");
	By templateSavedMsg = By.xpath("//div[text()='Template successfully saved.']");
	By searchButton = By.xpath("//button[contains(@aria-label,'To get the list matching the search criteria')]//i[text()='search']");
	By accountInfoDetails = By.xpath("//h3[contains(text(),'Account Information')]");
	By reviewDetails = By.xpath("//div[text()='Debit Account']//..//span[@id='debitAccount'][text()]");
	By reviewAmount = By.xpath("//h4[@role='heading']//..//..//..//div[@id='Payment Amount']");
	By confirmButton = By.xpath("//button[text()='Confirm']");
	By editHeader = By.xpath("//h1[contains(text(),'Edit')]");
	By editIcon = By.xpath("//button[@aria-label='To edit the template, click the icon']");
	By saveTemplate = By.xpath("//button//span[text()='Save Template']");
	By searchExpand =By.xpath("//button[contains(@aria-label,'To get the list of templates matching the search')]//i[text()='expand_more']");


	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String searchData = "//td[@class='ng-star-inserted']//span[contains(text(),'%s')]";

	public void createWireTemplateForFreeForm(String freeFormTemplate, String repetitiveButton, String templateName,
			String payee,String debitAccount,String beneIdType,
			String beneID,String beneAddress1,String beneAddress2,String beneCountry,
			String beneBankIDType,String paymentCurrency,String amount,String beneBankID,
			String purposeOfPayment,String beneBankAddress1,String beneBankAddress2)throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitElement(2000);
				if (isElementPresent(manageWireTemplatesHeader)) {
					clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
					waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);
					if (!freeFormTemplate.equals("NA")) {
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
							enterText("Manage Wire Template", "Debit Account Field",debitAccountField, debitAccount);
							clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement("Debit Account Field", list, debitAccount));
//							driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
//							selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
						}
						scrollToElement(beneInformation);
						if (!payee.equals("")) {
							enterText("Manage Wire Template", "Payee Field", payeeName, payee);
						}
						if(!beneIdType.equals("")) {
							scrollToElement(beneIDTypeField);
							//enterText("Manage Wire Template", "Beneficiary Id Type",beneIDTypeField, debitAccount);
							clickOnElement("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField);
							clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement("Beneficiary Id Type", list, beneIdType));
//							driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
//							selectElementFromListbox("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField, list, beneIdType);
						}
						if(!beneID.equals("")) {
							scrollToElement(beneIDField);
							enterText("Manage Wire Templater", "Beneficiary Id", beneIDField, beneID);
						}
						if(!beneAddress1.equals("")) {
							enterText("Manage Wire Template", "Beneficiary Address1 Field", beneAddressField1, beneAddress1);
						}
						if(!beneAddress2.equals("")) {
							enterText("Manage Wire Template", "Beneficiary Address2 Field", beneAddressField2, beneAddress2);
						}
						if(!beneCountry.equals("")) {
							scrollToElement(beneCountryField);
							clickOnElement("Manage Wire Template", "Debit Account Field", beneCountryField);
							clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement( "Beneficiary Country", list, beneCountry));
//							driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryCountry']")).click();
//							selectElementFromListbox("Manage Wire Template", "Beneficiary Country", beneCountryField, list, beneCountry);
						}
						if(!paymentCurrency.equals("")) {
							scrollToElement(paymentCurrencyField);
							enterText("Manage Wire Template","Payment Currency",paymentCurrencyField, paymentCurrency);
							clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement("Payment Currency", list, paymentCurrency));
//							driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
//							selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
						}
						if(!amount.equals("")) {
							enterText("Manage Wire Template", "Amount Field", amountField, amount);
						}
						if(!beneBankIDType.equals("")) {
							scrollToElement(beneBankIDTypeField);
							//enterText("Manage Wire Template","Beneficiary Bank ID Type",beneBankIDTypeField, beneBankIDType);
							clickOnElement("Manage Wire Template","Beneficiary Bank ID Type", beneBankIDTypeField);
							clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement("Beneficiary Bank ID Type", list, beneBankIDType));
//							driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
//							selectElementFromListbox("Manage Wire Template", "Beneficiary Bank ID Type", beneBankIDTypeField, list, beneBankIDType);
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
						stepResult = true;
					}
				} else {
					createWireTemplateForSelectPayee(payee, repetitiveButton, templateName, debitAccount, paymentCurrency,
							purposeOfPayment, amount);
					stepResult = true;
				}

			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Create wire template",
							"Created new wire template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create wire template",
							"Could not create new wire template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}
	public void createWireTemplateForSelectPayee(String payee,String repetitiveButton,String templateName,
			String debitAccount,String paymentCurrency,String purposeOfPayment,String amount) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitElement(2000);
				if (isElementPresent(manageWireTemplatesHeader)) {
					clickOnElement("Manage Wire Template", "Create Template Button", createTempalte);
					waitForPresenceOfElement("Manage Wire Template", "Start Wire Template", startWireTransfer);

					clickOnElement("Manage Wire Template", "Select Payee Template", selectPayeeButton);
					waitElement(2000);
					if (!payee.equals("")) {
						enterText("Manage Wire Template", "Payee Field", payeeField, payee);
						waitElement(2000);
						clickOnElement("Manage Wire Template", "payee List", getDynamicElement("Corporate New Wire Transfer", list, payee));
						waitElement(2000);
					}
					clickOnElement("Manage Wire Template", "Next Button", nextButton);
					waitElement(2000);
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
						enterText("Manage Wire Template", "Debit Account Field", debitAccountField, debitAccount);
						clickOnElement("Manage Wire Template", "Debit Account Field", getDynamicElement("Debit Account Field", list, debitAccount));
						//driver.findElement(By.xpath("//p-autocomplete[@inputid='debitAccount']//input[@id='debitAccount']")).click();
						//selectElementFromListbox("Manage Wire Template", "Debit Account Field", debitAccountField, list,debitAccount);      
					}
					if(!paymentCurrency.equals("")) {
						scrollToElement(paymentCurrencyField);
						enterText("Manage Wire Template", "Payment Currency", paymentCurrencyField, paymentCurrency);
						clickOnElement("Manage Wire Template", "Payment Currency", getDynamicElement("Payment Currency", list, paymentCurrency));
						//driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
						//selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, paymentCurrency);
					}
					if(!purposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						enterText("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, purposeOfPayment);
					}
					if(!amount.equals("")) {
						enterText("Manage Wire Template", "Amount Field", payeeAmountField, amount);
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
					new HTMLReportHelper().HtmlReportBody("Create wire template",
							"Created wire template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Wire Template- Corporate application",
							"Could not create wire template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void searchWireTemplate(String templateName,String amount) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitElement(2000);
				if (isElementPresent(manageWireTemplatesHeader)) {
					if(!(isElementPresent(searchExpand))) {
					
				}else {
					clickOnElement("Manage Wire Template", "Search Field", searchExpand);
				}
 					if (!templateName.equals("")) {
						enterText("Manage Wire Template", "Template Name", templateNameField, templateName);
					}
					if(!amount.equals("")) {
						enterText("Manage Wire Template", "Amount Field", searchAmount, amount);
					}
					clickOnElement("Manage Wire Template", "Search Button", searchButton);
					isElementPresent(getDynamicElement("Corporate New Template", searchData, templateName));
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Search wire template",
							"Search wire template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search wire template",
							"Could not search wire template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}		

	public void reviewManageWireTempaltes(String debitAccount, String amount) throws Exception {
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
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details ",
							"Review wire transfer details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Review wire transfer details ",
							"Could not review wire transfer details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void editExistingWireTemplate(String update_Payee,String update_BeneIdType,
			String update_BeneID,String update_BeneAddress1,String update_BeneAddress2,String update_BeneCountry,
			String update_BeneBankIDType,String update_PaymentCurrency,String update_Amount,String update_BeneBankID,
			String update_PurposeOfPayment,String update_BeneBankAddress1,String update_BeneBankAddress2) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitElement(2000);
				if (isElementPresent(manageWireTemplatesHeader)) {
					clickOnElement("Manage Wire Templates", "Edit Wire Template", editIcon);
					waitForPresenceOfElement("Manage Wire Templates", "Edit Wire Template", editHeader);
					clickOnELementUsingActions(beneInformation);
					//scrollToElement(beneInformation);
					if (!update_Payee.equals("")) {
						clearAndType("Manage Wire Template", "Payee Field", payeeName, update_Payee);
					}
					if(!update_BeneIdType.equals("")) {
						clickOnELementUsingActions(beneIDTypeField);
						//					scrollToElement(beneIDTypeField);
						//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryIdType']//div[2]")).click();
						selectElementFromListbox("Manage Wire Template", "Beneficiary Id Type", beneIDTypeField, list, update_BeneIdType);
					}
					if(!update_BeneID.equals("")) {
						scrollToElement(beneIDField);
						clearAndType("Manage Wire Templater", "Beneficiary Id", beneIDField, update_BeneID);
					}
					if(!update_BeneAddress1.equals("")) {
						clearAndType("Manage Wire Template", "Beneficiary Address1 Field", beneAddressField1, update_BeneAddress1);
					}
					if(!update_BeneAddress2.equals("")) {
						clearAndType("Manage Wire Template", "Beneficiary Address2 Field", beneAddressField2, update_BeneAddress2);
					}
					if(!update_BeneCountry.equals("")) {
						clickOnELementUsingActions(beneCountryField);
						//					scrollToElement(beneCountryField);
						//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryCountry']")).click();
						selectElementFromListbox("Manage Wire Template", "Beneficiary Country", beneCountryField, list, update_BeneCountry);
					}
					if(!update_PaymentCurrency.equals("")) {
						clickOnELementUsingActions(paymentCurrencyField);
						//					scrollToElement(paymentCurrencyField);
						//					driver.findElement(By.xpath("//p-autocomplete[@inputid='paymentCurrency']//input[@id='paymentCurrency']")).click();
						selectElementFromListbox("Manage Wire Template", "Payment Currency", paymentCurrencyField, list, update_PaymentCurrency);
					}
					if(!update_Amount.equals("")) {
						clearAndType("Manage Wire Template", "Amount Field", amountField, update_Amount);
					}
					if(!update_BeneBankIDType.equals("")) {
						clickOnELementUsingActions(beneBankIDTypeField);
						//					scrollToElement(beneBankIDTypeField);
						//					driver.findElement(By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType']//div[2]")).click();
						selectElementFromListbox("Manage Wire Template", "Beneficiary Bank ID Type", beneBankIDTypeField, list, update_BeneBankIDType);
					}
					if(!update_BeneBankID.equals("")) {
						clearAndType("Manage Wire Template", "Bene Bank ID", beneBankIdField, update_BeneBankID);
					}
					if(!update_PurposeOfPayment.equals("")) {
						scrollToElement(purposeOfPaymentField);
						clearAndType("Manage Wire Template", "Purpose of Payment", purposeOfPaymentField, update_PurposeOfPayment);
					}
					if(!update_BeneBankAddress1.equals("")) {
						clearAndType("Manage Wire Template", "Beneficiary Bank Address1 Field", beneBankAddress1Field, update_BeneBankAddress1);
					}
					if(!update_BeneBankAddress2.equals("")) {
						clearAndType("Manage Wire Template", "Beneficiary Bank Address2 Field", beneBankAddress2Field, update_BeneBankAddress2);
					}

					clickOnElement("Manage Wire Template", "Save Tempalte Button", saveTemplate);
					waitForPresenceOfElement("Manage Wire Template", "Template Saved Banner", templateSavedMsg);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Edit wire template",
							"Edited wire template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Edit wire template",
							"Could not edit wire template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}		

	




}
