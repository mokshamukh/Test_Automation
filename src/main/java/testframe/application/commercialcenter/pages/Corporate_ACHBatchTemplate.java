package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Corporate_ACHBatchTemplate
 * 
 * @author shilpa.thangapalam
 */



public class Corporate_ACHBatchTemplate extends CommonLibrary{

	public By achBatchTitle = By.xpath("//h1[contains(text(),'ACH Batch Templates')]");
	public By createTemplateButton = By.xpath("//button[contains(@aria-label,'New ACH Template screen')]/i[text()='add']");
	public By newACHTemplate = By.xpath("//h1[text()='New ACH Template']");
	public By achCompanyField = By.xpath("//p-dropdown[@inputid='achCompany-input']");
	public By debitCreditField = By.xpath("//p-dropdown[@inputid='debitCredit-input']");
	public By batchTypeField = By.xpath("//p-dropdown[@inputid='batchType-input']");
	public By searchBatchTypField = By.xpath("(//p-dropdown[@inputid='batchType-input'])[1]");
	public By nextButton = By.xpath("//button[text()='Next']");
	public By cancelButton = By.xpath("//button[text()='Cancel']");
	public By achBatchDeailsTitle = By.xpath("//h3[text()='ACH Batch Details']");
	public By templateNameField = By.xpath("//input[@id='templateName']");
	public By companyDiscretionaryDataField = By.xpath("//input[@id='companyDiscretionaryData']");
	public By companyEntryDescription = By.xpath("//input[@id='companyEntryDescription']");
	public By offsetAccount = By.xpath("//label[text()='Offset Account']/..//input[@id='label']");
	public By offsetAccountField = By.xpath("//p-autocomplete[@inputid='label']/..//..//span[contains(@class,'ui-autocomplete')]");
	public By newPayeeButton  = By.xpath("//button[contains(@aria-label,'add new payee')]//i");
	public By payeeNameField = By.xpath("//input[@id='payeeNameFld']");
	public By payeeIDField = By.xpath("//input[@id='payeeIdFld']");
	public By payeeTypeField = By.xpath("//p-dropdown[@inputid='payeeTypeFld-input']");
	public By addAccount = By.xpath("//div[@class='card-header']//button//i[text()='add']");
	public By accountNameField = By.xpath("//input[@id='accountName']");
	public By accountNumberField = By.xpath("//input[@id='accountNumber']");
	public By bankLookUp = By.xpath("//button[@id='bankLookup']");
	public By bankIDField = By.xpath("//input[@id='bankId']");
	public By bankNameField = By.xpath("//input[@id='bankName']");
	public By debitAuthoTypeField = By.xpath("//p-dropdown//input[@id='debitAuthorizationType-input']/..//..//span[contains(@class,'expand_more')]");
	public By addButton = By.xpath("//button[@aria-label='To save the added account details for the payee'][text()='Add']");
	public By alertMsg = By.xpath("//div[contains(text(),'An account has been added')]");
	public By saveButton = By.xpath("//button[text()='Save'][contains(@aria-label,'To save the template and return to the ACH')]");
	public By payeeSaveBtn = By.xpath("//button[text()='Save'][contains(@aria-label,'To save the added payee details')]");
	public By autoSaveMsg = By.xpath("//div[contains(text(),'An auto-saved')]");
	public By searchExistingtemplate = By
			.xpath("//button[contains(@aria-label,'search an existing template')]/i[text()='search']");
	public By existPayeeID = By.xpath("//input[@id='searchPayeeId']");
	public By existNameField = By.xpath("//input[@id='searchPayeeName']");
	public By existPayeeId = By.xpath("//input[@id='payeeId']");
	public By searchSymbol = By.xpath("//button[contains(@aria-label,'get the list matching the search criteria')]");
	public By searchExistingPayee = By
			.xpath("//button[contains(@aria-label,'search an existing payee')]/i[text()='search']");
	public By existPayee = By.xpath("//input[@id='payeeName'][@placeholder='Search Payee']");
	public By existAmount = By.xpath("//input[@id='payeeAmountAdd']|(//input[@id='newPayeeAmoountAdd'])[1]");
	public By existingNewAmount = By.xpath("//input[@id='newPayeeAmoountAdd']");
	public By addPayee = By.xpath("//button[contains(@aria-label,'add payee')]//i|//button[contains(@aria-label,'To add another payee')]");
	public By searchPayeeType = By.xpath("//p-autocomplete[@inputid='payeeName']//input[@id='payeeName']/..//..//span[contains(@class,'ng-star-inserted')]");
	public By successTemplateMsg = By.xpath("//div[contains(text(),'Successfully created the template.')]");
	public By editbatchTemplate = By.xpath("//button[contains(@aria-label,'make changes to this template')]//i[text()='mode_edit']");
	public By editHeader = By.xpath("//h1[contains(text(),'Edit')]");
	public By existingBatchType = By.xpath("(//td[@class='ng-star-inserted'])[2]");
	public By existingAccount = By.xpath("//p-dropdown[@inputid='newPayeeAccount-input']");
	public By removeExistingPayee = By.xpath("//div[@id='payeeNameValue0']//../parent::div/following-sibling::div//button[@aria-label='clear Payee field']");
	public By confidentialCheckBox = By.xpath("//p-checkbox[@inputid='confidential']//span[contains(@class,'ui-clickable')]");
	public By confidentialLock = By.xpath("//span[contains(@class,'confidential-badge')]//span[text()='Confidential']");
	public By addendaField = By.xpath("//input[@id='payeeAddenda']");
	public By sendRemittanceEmail = By.xpath("//p-checkbox[@name='excludeCheckbox']");
	public By addRemittanceField = By.xpath("//button[contains(text(),'Add Remittance Email to Payee')]//i");
	public By remittanceHeader = By.xpath("//p-sidebar//div//h3[text()='Remittance Info']");
	public By searchTemplate = By.xpath("//button[contains(@aria-label,'To expand the section with fields to filter and search an existing template.')]");
	public By debitorCreditField = By.xpath("//p-dropdown//input[@id='payeeDebitCredit-input']/..//..//span[contains(@class,'expand_more')]");
	public By addAddendaText = By.xpath("//input[@id='newPayeeAmoountAdd']//..//..//..//..//..//..//button[@aria-label='To open and add a note as addenda for the ACH batch']");
	public By addendaHeader = By.xpath("//div[@class='card-body']//label[text()='Addenda']");
	public By textArea = By.xpath("//textarea[@id='extAddenda']");
	public By okButton = By.xpath("//button[text()='OK']");
	public By searchExpand = By.xpath("//button[contains(@aria-label,'To expand the section with fields to filter and search an existing template.')][@aria-expanded='false']");
	public By payeeEmail = By.xpath("//input[@id='payeeEmail']");
	public By memoField = By.xpath("//textarea[@id='genericText']");
	public By saveRemittanceInfo = By.xpath("//button[contains(@aria-label,'To save the added remittance information')]");


	//button[contains(@aria-label,'To save the template')]
	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String existingTemplateName = "(//td[@class='ng-star-inserted'])[1]//span[contains(text(),'%s')]";
	String removeExistPayee = "//div[contains(@id,'payeeNameValue')]//span[contains(text(),'%s')]//..//../parent::div/following-sibling::div//button[@aria-label='clear Payee field']";

	public Corporate_ACHBatchTemplate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void createBatchTemplate(String achCompany,String cardType,String batchType) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitElement(4000);
				if (isElementPresent(achBatchTitle)) {
					clickOnElement("ACH Batch Template", "Create Template Button", createTemplateButton);
				}
				waitForPresenceOfElement("ACH Batch Template", "New ACH Template", newACHTemplate);
				if (!achCompany.equals("")) {
					selectElementFromListbox("ACH Batch Template", "ACH Company", achCompanyField, list,achCompany);
				}
				if (!cardType.equals("")) {
					clickOnElement("ACH Batch Template", "Debit/credit",  debitCreditField);
					//driver.findElement(By.xpath("//p-dropdown[@inputid='debitCredit-input']//div/span[text()='Select']")).click();
					selectElementFromListbox("ACH Batch Template", "Debit/credit", debitCreditField, list,cardType);
					//waitElement(2000);
				}
				if (!batchType.equals("")) {
					waitElement(3000);
					clickOnElement("ACH Batch Template", "Batch Type", batchTypeField);
					//driver.findElement(By.xpath("//p-dropdown[@inputid='batchType-input']//div/span[text()='Select']")).click();
					waitElement(1000);
					selectElementFromListbox("ACH Batch Template", "Batch Type", batchTypeField, list,batchType);
				}
				clickOnElement("ACH Batch Template", "Next Button", nextButton);
				waitElement(2000);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Create ach payment","Created ach payment successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create ach payment","Could not Create new ach payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void enterACHBatchDetails(String templateName, String cmpDiscretionary, String cmpEntryDiscretionary,String offsetAcc,String confidential) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchDeailsTitle)) {

					if (!templateName.equals("")) {
						enterText("ACH Batch Template", "Payment Date", templateNameField, templateName);
					}
					if (!cmpDiscretionary.equals("")) {
						enterText("ACH Batch Template", "Company Discretionary Data", companyDiscretionaryDataField,
								cmpDiscretionary);
					}
					if (!cmpEntryDiscretionary.equals("")) {
						enterText("ACH Batch Template", "Company Entry Description", companyEntryDescription,
								cmpEntryDiscretionary);
					}
					if (!offsetAcc.equals("")) {
						waitElement(2000);
						enterText("ACH Batch Template", "Offset Account", offsetAccount, offsetAcc);
						waitElement(2000);
						clickOnElementWithText("ACH Batch Template", "Offset Account", getDynamicElement("Offset Account", list, offsetAcc), offsetAcc);
						//selectElementFromListbox("ACH Batch Template", "Offset Account", offsetAccountField, offsetFieldList, offsetAcc);
					}
					if(confidential.equals("Yes")) {
						clickOnElement("ACH Batch Template", "Confidential CheckBox", confidentialCheckBox);
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("enter ach batch details",
							"enter ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("enter ach batch details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void createNewPayee(String payeeName,String payeeID,String accountNumber,
			String bankID,String bankName,String debitType,String existPayeeAmt,String mixedDebitCredit,
			String addenda,String sendRemittanceToPayee) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(newPayeeButton)) {
					waitElement(3000);
					clickOnELementUsingJS(driver.findElement(By.xpath("//button[contains(@aria-label,'add new payee')]//i")));
					waitElement(3000);
					//clickOnElement("ACH Batch Template", "Create New Payee Button", newPayeeButton);
				}
				if(!payeeName.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Payee Name", payeeNameField, payeeName);
				}
				if(!payeeID.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Payee ID", payeeIDField, payeeID);
				}
				if(isElementPresent(addAccount)) {
					waitElement(2000);
					clickOnElement("ACH Batch Template", "Add Account", addAccount);
				}
				//			if(!accountName.equals("")) {
				//				enterText("ACH Batch Template", "Account Name", accountNameField, accountName);
				//			}
				if(!accountNumber.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Account Name", accountNumberField, accountNumber);
				}
				if(!bankID.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Bank Id", bankIDField, bankID);
				}
				if(!bankName.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Bank Id", bankNameField, bankName);
				}
				if (debitType.equals("")||debitType.equals("No")) {
					
				}else {
					waitElement(2000);
					selectElementFromListbox("ACH Batch Template", "Debit Authorization Type", debitAuthoTypeField, list,debitType);
				}
				clickOnElement("ACH Batch Template", "Add Button", addButton);
				waitElement(2000);
				waitForPresenceOfElement("ACH Batch Template", "Alert Message", alertMsg);
				waitElement(2000);
				clickOnElement("ACH Batch Template", "Save Button", payeeSaveBtn);
				waitElement(5000);
				if(mixedDebitCredit.equals("No")) {
					
				}else {
					selectElementFromListbox("ACH Batch Template", "Mixed Debit and Credit", debitorCreditField, list,mixedDebitCredit);
					waitElement(1000);
				}
				if (!existPayeeAmt.equals("")) {
					waitElement(2000);
					enterText("ACH Batch Template", "Existing Amount", existAmount, existPayeeAmt);
					waitElement(2000);
					if(existPayeeAmt.equals("0")) {
						clickOnElement("ACH Batch Template", "AddAddenda", addAddendaText);
						waitForPresenceOfElement("ACH Batch Template", "AddAddenda", addendaHeader);
						enterText("ACH Batch Template", "AddAddenda",textArea, addenda);
						clickOnElement("ACH Batch Template", "AddAddenda OK button", okButton);
					}
				}
				if(addenda.equals("No")) {
					
				}else {
					waitElement(2000);
						enterText("ACH Batch Template", "Addenda Field", addendaField, addenda);
				}
				if(sendRemittanceToPayee.equals("No")||sendRemittanceToPayee.equals("")) {

				}
				else {

					sendRemittanceEmailToPayee(sendRemittanceToPayee);
				}
				waitElement(4000);
				clickOnElement("ACH Batch Template", "Add Existing payees", addPayee);
				waitElement(4000);

				//validateElementPresent("ACH Batch Template", "Auto Save Message", autoSaveMsg);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Create payee for ach payment",
							"Created payee for ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create payee for ach payment",
							"Could not create payee for ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void searchTemplate(String existTemplateName, String existbatchType) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchTitle)) {
					if(isElementPresent(searchExpand)) {
						clickOnElement("ACH Batch Template", "Search Template", searchTemplate);
					}
					waitForPresenceOfElement("ACH Batch Template", "Search Existing payees", searchExistingtemplate);
					if (!existTemplateName.equals("")) {
						clearAndType("ACH Batch Template", "Existing Payee", templateNameField, existTemplateName);
					}
//					if (!existbatchType.equals("")) {
//						clickOnElement("ACH Batch Template", "Batch Type", searchBatchTypField);
//						//driver.findElement(By.xpath("(//p-dropdown[@inputid='batchType-input']//div//span[contains(@class,'expand_more')])[1]")).click();
//						waitElement(1000);
//						selectElementFromListbox("ACH Batch Template", "Batch Type", searchBatchTypField, list,existbatchType);
//					}

					clickOnElement("ACH Batch Template", "Search Existing payees", searchSymbol);
					validateTextContains("ACH Batch Template", "Tempalte Name", getDynamicElement("Tempalte Name", existingTemplateName, existTemplateName), existTemplateName);
					validateTextContains("ACH Batch Template", "Tempalte Name",existingBatchType,existbatchType);   
					//validateElementPresent("ACH Batch Template", "Confidential Lock", confidentialLock);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Search ach payment",
							" Search ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search ach payment",
							"Could not Search ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void searchPayee(String existPayeeName, String existPayeeAmt) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchDeailsTitle)) {
					waitForPresenceOfElement("ACH Batch Template", "Search Existing payees", searchExistingPayee);
					if (!existPayeeName.equals("")) {
						clearAndType("ACH Batch Template", "Existing Payee", existPayee, existPayeeName);
						selectElementFromListbox("ACH Batch Template", "Payee List", searchPayeeType, list,existPayeeName);
					}
					if (!existPayeeAmt.equals("")) {
						clearAndType("ACH Batch Template", "Existing Amount", existAmount, existPayeeAmt);
					}
					clickOnElement("ACH Batch Template", "Add Existing payees", addPayee);
					waitElement(2000);
					//				clickOnElement("ACH Batch Template", "Save Button", saveButton);
					//				validateElementPresent("ACH Batch Template", "successfully Complete Message", successTemplateMsg);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Search ach payment details",
							"search ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search ach payment details",
							"Could not search ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void editBatchTemplate(String templateName,String cmpDiscretionary,
			String cmpEntryDiscretionary,String offsetAcc,String amount,String removePayee,
			String searchPayee,String createPayee,String createPayeeID,String createAccountNumber,String createBankID,
			String createBankName,String createDebitAuthType,String createMixedDebitCredit,String addenda,String sendRemittanceToPayee) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchTitle)) {
					if(isElementPresent(editbatchTemplate)) {
						clickOnElement("ACH Batch Template", "Edit Button", editbatchTemplate);
					}
					waitForPresenceOfElement("ACH Batch Template", "Edit ", editHeader);
					if (!templateName.equals("")) {
						clearAndType("ACH Batch Template", "Payment Date", templateNameField, templateName);
					}
					if (!cmpDiscretionary.equals("")) {
						clearAndType("ACH Batch Template", "Company Discretionary Data", companyDiscretionaryDataField,
								cmpDiscretionary);
					}
					if (!cmpEntryDiscretionary.equals("")) {
						clearAndType("ACH Batch Template", "Company Entry Description", companyEntryDescription,
								cmpEntryDiscretionary);
					}
					if (!offsetAcc.equals("")) {
						clearAndType("ACH Batch Template", "Offset Account", offsetAccount, offsetAcc);
					}
					if (!amount.equals("")) {
						clearAndType("ACH Batch Template", "Amount Field", existingNewAmount, amount);
					}
					//				if (!account.equals("")) {
					//					selectElementFromListbox("ACH Batch Template", "Account Field", existingAccount, existingAccField, account);
					//				}
					if (!removePayee.equals("")) {
						clickOnElement("ACH Batch Template", "Remove Payee Button", getDynamicElement("Remove Payee Button", removeExistPayee, removePayee));
					}
					String[] multiPayee;
					if (!searchPayee.equals("")) {
						multiPayee =searchPayee.split("\\|\\|");
						for(int i=0;i<=multiPayee.length-1;i++){
							searchPayee(multiPayee[i],amount.split("\\|\\|")[i]);
						}
					}
					if (!createPayee.equals("")) {
						multiPayee = createPayee.split("\\|\\|");
						for(int i=0;i<=multiPayee.length-1;i++){
							createNewPayee(createPayee.split("\\|\\|")[i],createPayeeID.split("\\|\\|")[i],
									createAccountNumber.split("\\|\\|")[i],createBankID.split("\\|\\|")[i],
									createBankName.split("\\|\\|")[i],createDebitAuthType.split("\\|\\|")[i],
									createMixedDebitCredit.split("\\|\\|")[i],amount.split("\\|\\|")[i],
									addenda.split("\\|\\")[i],sendRemittanceToPayee.split("\\|\\")[i]);
						}
					}
				}
				clickOnElement("ACH Batch Template", "Save Button", saveButton);
				stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Edit ach payment details",
							"edit ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Edit ach payment details",
							"Could not edit ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void saveBatchTemplate() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				clickOnElement("ACH Batch Template", "Save Button", saveButton);
				validateElementPresent("ACH Batch Template", "successfully Complete Message", successTemplateMsg);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Save template for ach payment details",
							"save template for ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Save template for ach payment details",
							"Could not save template for ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void sendRemittanceEmailToPayee(String sendRemittanceToPayee) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				clickOnElement("ACH Batch Template", "Send Remittance Email to Payee", sendRemittanceEmail);
				waitElement(1000);
				clickOnElement("ACH Batch Template", "ADD Remittance Email to Payee", addRemittanceField);
				waitElement(1000);
				validateElementPresent("ACH Batch Template", "Remittance Header" , remittanceHeader);
				enterText("ACH Batch Template", "Remittance Email", payeeEmail, sendRemittanceToPayee);
				enterText("ACH Batch Template", "Memo Field", memoField, sendRemittanceToPayee);
				clickOnElement("ACH Batch Template", "Save Button", saveRemittanceInfo);

				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Save template for ach payment details",
							"save template for ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Save template for ach payment details",
							"Could not save template for ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

}
