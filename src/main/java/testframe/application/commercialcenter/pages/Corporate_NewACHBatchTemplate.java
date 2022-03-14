package testframe.application.commercialcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

/**
 * PageNage : Corporate_NewACHBatchTemplate
 * 
 * @author Ketki.Badalwar
 */


public class Corporate_NewACHBatchTemplate extends CommonLibrary {

	Corporate_ACHBatchTemplate corporateACHBatchTemplate;

	public By newAchBatchTitle = By.xpath("//h1[text()='New ACH Batch']");
	public By editNewAchBatchTitle = By.xpath("//h1[contains(text(),'ACH Batch')]");
	public By freeFormField = By.xpath("//input[@value='Free-Form']");
	public By templateField = By.xpath("//input[@value='Template']");
	public By achCompanyField = By.xpath("//p-dropdown[@inputid='achCompany-input']");
	public By debitCreditField = By.xpath("//p-dropdown[@inputid='debitCreditOptions-input']//div/span[contains(@class,'expand_more')]");
	public By batchTypeField = By.xpath("//p-dropdown[@inputid='batchTypeOptions-input']//div/span[contains(@class,'expand_more')]");
	public By nextButton = By.xpath("//button[contains(text(),'Next')]");
	public By achBatchDeailsTitle = By.xpath("//h3[text()='ACH Batch Details']");
	public By paymentDateField = By.xpath("//input[@id='paymentDate']");
	public By paymentDateTitle = By.xpath("//h3[contains(text(),'ACH Batch Details')]");
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
	public By addPayee = By.xpath("//button[contains(@aria-label,'add payee')]//i|//button[contains(@aria-label,'To add another payee')]");
	public By existPayee = By.xpath("//input[@id='displayName'][@placeholder='Search Payee']");
	public By searchPayee = By.xpath("//p-autocomplete[@inputid='displayName']//input[@id='displayName']/..//..//span[contains(@class,'pi-caret-down')]");
	public By existAccount = By.xpath("//input[@id='account']");
	public By existAmount = By.xpath("//input[@id='payeeAmountAdd']|(//input[@id='newPayeeAmoountAdd'])[1]");
	public By existPayeeId = By.xpath("//input[@id='payeeId']");
	public By searchSymbol = By.xpath("//button[contains(@aria-label,'get the list matching the search criteria')]");
	public By reviewDetails = By.xpath("//th[contains(text(),'Payee')][@role='columnheader']//..//..//..//td[@class='ng-star-inserted']//div[1]");
	public By reviewAmt = By.xpath("//td[contains(@class,'bordered-last-column ng-star')]");
	public By confirmButton = By.xpath("//button[text()='Confirm']");
	public By pleaseReverifyTitle = By.xpath("//h4[contains(text(),'Please Reverify')]");
	public By confirmPassword = By.xpath("//input[@id='confirmPassword']");
	public By submitButton = By.xpath("//button[text()='Submit']");
	public By msg = By.xpath("//div[@class='alert-message-title']/strong");
	public By existTemplateName = By.xpath("//input[@id='templateName']");
	public By existTemplateField = By.xpath("(//input[contains(@class,'ui-autocomplete-input')])");
	public By autoSaveMsg = By.xpath("//div[contains(text(),'An auto-saved draft created')]");
	public By requestBatchButton = By.xpath("//button[contains(@aria-label,'ACH batch details and proceed to the review screen.')]");
	public By alertmsg = By.xpath("//div[contains(text(),'Please correct the errors shown below')]");
	public By editAchbatchTemplate = By.xpath("//button[contains(@aria-label,'make changes to the ACH details.')]//i[text()='mode_edit']");
	public By existingNewAmount = By.xpath("(//input[@id='newPayeeAmoountAdd'])[2]");
	public By paymentAmount = By.xpath("//label[@for='payeeAmount1']//..//input[@id='newPayeeAmoountAdd']");
	public By recurringOption = By.xpath("(//div[@class='card-header'])[2]/a/i[text()='keyboard_arrow_right']");
	public By freq = By.xpath("//ul[@class='nav nav-pills flex-column']/li/a[@id='DAILY']");
	public By seriesDetailsDate = By.xpath("//input[@id='defaultStartDate']");
	public By saveButton = By.xpath("//button[text()='Save'][contains(@aria-label,'recurring options')]");
	public By seriesNameField= By.xpath("//input[@formcontrolname='seriesName']");
	public By paymentActivityTitle = By.xpath("//h3[contains(text(),'Current Activity Summary')]|//button[contains(text(),'Payment Activity')]");
    public By reviewBatchType = By.xpath("//div[@class='form-group']//div[@id='batchType'][contains(text(),'')]");
    public By reviewOffsetAccount = By.xpath("//div[@class='form-group ng-star-inserted']//div[@id='offsetAccount']");
	
	
	String list = "//li[@role='option']/span[contains(text(),'%s')]";
	String amount_field = "(//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/div)[1]";
	String status_field ="//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/span";
	String transactionID;
	//ul[contains(@class,'ui-autocomplete')][@role='listbox']

	public Corporate_NewACHBatchTemplate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		corporateACHBatchTemplate = new Corporate_ACHBatchTemplate(driver);
	}

	public void startAchPaymentWithFreeForm(String achCompany, String cardType, String batchType) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2500);
				if (isElementPresent(newAchBatchTitle)) {
					clickOnElement("New ACH Batch Template", "free form field", freeFormField);
					if (!achCompany.equals("")) {
						selectElementFromListbox("New ACH Batch Template", "ACH Company", achCompanyField, list,
								achCompany);
					}
					if (!cardType.equals("")) {
						waitElement(3000);
						scrollToBottomOfThePage();
						waitElement(3000);
						//	driver.findElement(By.xpath("//p-dropdown[@inputid='debitCreditOptions-input']//div/span[contains(@class,'expand_more')]")).click();
						selectElementFromListbox("New ACH Batch Templ6ate", "Debit/redit", debitCreditField, list,
								cardType);
						Thread.sleep(2000);
					}
					if (!batchType.equals("")) {
						//driver.findElement(By.xpath("//p-dropdown[@inputid='batchTypeOptions-input']//div/span[text()='Select']")).click();
						//waitElement(1000);
						selectElementFromListbox("New ACH Batch Template", "Batch Type", batchTypeField, list,batchType);
					}
					clickOnElement("New ACH Batch Template", "Next Button", nextButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Create ach with free form",
							"Created ach  with free form successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create ach with free form",
							"Could not create start ach payment with free form successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void startAchPaymentWithTemplate(String existAchBatchTemplate) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				if (isElementPresent(newAchBatchTitle)) {
					clickOnElement("New ACH Batch Template", "Template field", templateField);
					if (!existAchBatchTemplate.equals("")) {
						enterText("New ACH Batch Template", "Exist Template Name", existTemplateField, existAchBatchTemplate);
						clickOnElement("New ACH Batch Template",  "Exist Template Name", getDynamicElement("Exist Template Name", list, existAchBatchTemplate));
					}
					clickOnElement("New ACH Batch Template", "Next Button", nextButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Create ach payment",
							"Created ach payment successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create ach payment",
							"Could not create ach payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void enterACHPaymentDetails(String paymentDate, String cmpDiscretionary, String cmpEntryDiscretionary,
			String offsetAcc,String amount,String new_CreatePayeeName,String new_CreatePayeeID,String new_CreateAccountNumber,
			String new_CreateBankID,String new_CreateBankName,String new_CreateDebitAuthType,String new_Amount,
			String new_CreateMixedDebitorCredit,String new_addenda,String new_sendRemittanceToPayee) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchDeailsTitle)) {
					if (!paymentDate.equals("")) {
						waitElement(2000);
						enterPaymentDate(paymentDate);
						//clearAndType("New ACH Batch Template", "Payment Date", paymentDateField, paymentDate);
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
					if(!amount.equals("")) {
						clearAndType("New ACH Batch Template", "Amount Field", paymentAmount, amount);
					}
					//					if(!new_CreatePayeeName.equals("")) {
					//						corporateACHBatchTemplate.createNewPayee(new_CreatePayeeName, new_CreatePayeeID,new_CreateAccountNumber,
					//								new_CreateBankID,new_CreateBankName,new_CreateDebitAuthType,new_CreateMixedDebitorCredit,new_Amount,new_addenda,new_sendRemittanceToPayee);
					//						//searchPayee(existPayeeName, existPayeeAmt);
					//						//verifyPayeeandAddAmount(displaName, displayyAcc, amt, addenda);
					//						//				}else {
					//						//					searchPayee(existPayeeName, existPayeeAmt);
					//						//				}
					//					}
					String[] multiPayee;
					if (!new_CreatePayeeName.equals("")) {
						multiPayee = new_CreatePayeeName.split("\\|\\|");
						for(int i=0;i<=multiPayee.length-1;i++){
							corporateACHBatchTemplate.createNewPayee(new_CreatePayeeName.split("\\|\\|")[i],new_CreatePayeeID.split("\\|\\|")[i],
									new_CreateAccountNumber.split("\\|\\|")[i],new_CreateBankID.split("\\|\\|")[i],
									new_CreateBankName.split("\\|\\|")[i],new_CreateDebitAuthType.split("\\|\\|")[i],
									new_Amount.split("\\|\\|")[i],new_CreateMixedDebitorCredit.split("\\|\\|")[i],new_addenda.split("\\|\\|")[i],new_sendRemittanceToPayee.split("\\|\\|")[i]);
						}
					}
					waitElement(5000);
					waitForPresenceOfElement("New ACH Batch Template", "Auto Save Message", autoSaveMsg);
					//			clickOnElement("New ACH Batch Template", "Request Batch Button", requestBatchButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Entered ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
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
					clickOnElement("New ACH Batch Template", "Search Existing payees", existPayee);
					if (!existPayeeName.equals("")) {
						enterText("New ACH Batch Template", "Existing Payee", existPayee, existPayeeName);
						selectElementFromListbox("ACH Batch Template", "Payee List", searchPayee, list,existPayeeName);
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
					clickOnElement("ACH Batch Template", "Add Existing payees", addPayee);
					waitElement(1000);
					waitElement(5000);
					//				clickOnElement("New ACH Batch Template", "Request Batch Button", requestBatchButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Enter ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyPayeeandAddAmount(String displaName, String displayyAcc, String amt, String addenda) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					//clickOnElement("New ACH Batch Template", "Request Batch", reqBatchButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Enter ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void reviewAchBatchDetails(String payeeName, String amount,String batchType) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			boolean flag = false;
			try {
				if (isElementPresent(achBatchDeailsTitle)) {
//					String[] payee = payeeName.trim().split("\\|\\|");
//					for (int i = 0; i < payee.length; i++) {
//						List<WebElement> element = findElements(reviewDetails);
//						for (WebElement ele : element) {
//							if (ele.getText().contains(payee[i])) {
//								flag = true;
//							} else {
//								flag = false;
//							}
//						}
//					}
				validateElementExist("New ACH Batch Template", "Batch Type", reviewBatchType, batchType);
//				validateElementExist("New ACH Batch Template", "AmountField", reviewAmt, amount);
					clickOnElement("New ACH Batch Template", "Confirm Button", confirmButton);
					stepResult = true;
				}		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Review ach payment details",
							"Review ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Review ach payment details",
							"Could not review ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void verifyPassword(String psw) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Enter ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public String getTransaction(String excelFilePath,String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achBatchDeailsTitle)) {
					transactionID = getElementText("New ACH Batch Template", "Alert Message", msg);
					transactionID = transactionID.replaceAll("\\.", "");
					if(transactionID != "") {
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "TransactionID", rowNo+1, transactionID);				
						System.out.println(transactionID);
					}

					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Enter ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter ach payment details",
							"Could not enter ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
		return transactionID;

	}


	public void clickOnRequestBatchButton() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				clickOnElement("New ACH Batch Template", "Request Batch Button", requestBatchButton);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Click on request batch button",
							"Clicked on request batch button successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on request batch buttons",
							"Could not clicked on request batch button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterPaymentDate(String paymentDates) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!paymentDates.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(paymentDateField).sendKeys(Keys.BACK_SPACE);
					}
					enterText("Corporate ACH Payment", "Payment Date", paymentDateField, paymentDates);
					waitElement(2000);
					clickOnElement("Corporate ACH Payment", "Payment Date Title", paymentDateTitle);
					waitElement(2000);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date field", "Enter transfer date field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date field", "Could not enter transfer date field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void editBatchTemplate(String paymentDate,String cmpDiscretionary,
			String cmpEntryDiscretionary,String offsetAcc,String amount,
			String searchPayee,String createPayee,String createPayeeID,String createAccountNumber,String createBankID,
			String createBankName,String createDebitAuthType,String mixedDebitCredit,String addenda,String sendRemittanceToPayee) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(editNewAchBatchTitle)) {
					if(isElementPresent(editAchbatchTemplate )) {
						clickOnElement("ACH Batch Template", "Edit Button", editAchbatchTemplate);
					}
					if (!paymentDate.equals("")) {
						enterPaymentDate(paymentDate);
					}
					if (!cmpDiscretionary.equals("")) {
						clearAndType("ACH Batch Template", "Company Discretionary Data", companyDiscretionaryDataField,
								cmpDiscretionary);
					}
					if (!cmpEntryDiscretionary.equals("")) {
						clearAndType("ACH Batch Template", "Company Entry Description", companyEntryDiscretion,
								cmpEntryDiscretionary);
					}
					if (!offsetAcc.equals("")) {
						clearAndType("New ACH Batch Template", "Offset Account", offsetAccount, offsetAcc);
						driver.findElement(By.xpath("//input[@id='offsetAccount']")).sendKeys(Keys.TAB);
					}
					if (!amount.equals("")) {
						clearAndType("ACH Batch Template", "Amount Field", existingNewAmount, amount);
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
							corporateACHBatchTemplate.createNewPayee(createPayee.split("\\|\\|")[i],createPayeeID.split("\\|\\|")[i],
									createAccountNumber.split("\\|\\|")[i],createBankID.split("\\|\\|")[i],
									createBankName.split("\\|\\|")[i],createDebitAuthType.split("\\|\\|")[i],
									mixedDebitCredit.split("\\|\\|")[i],amount.split("\\|\\|")[i],addenda.split("\\|\\")[i],sendRemittanceToPayee.split("\\|\\")[i]);
						}
					}
				}
				stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Menu");
					new HTMLReportHelper().HtmlReportBody("Edit ach payment details",
							"Edit ach payment details successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Edit ach payment details",
							"Could not edit ach payment details successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectRecurringOption(String recurringOpt) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!recurringOpt.equals("")) {
					clickOnElement("Corporate Wire Transfer", "Recurring Option Accordion", recurringOption);
					waitForPresenceOfElement("Corporate Wire Transfer", "Frequency", freq);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select recurring option", "Select recurring option successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select recurring option", "Could not select recurring option successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterSeriesDetails(String seriesDate) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				if (!seriesDate.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(seriesDetailsDate).sendKeys(Keys.BACK_SPACE);
					}
					Thread.sleep(10000);
					enterText("Corporate Account Transfer", "Series Details Date", seriesDetailsDate, seriesDate);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter series date", "Enter series date successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter series date", "Could not enter series date successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickRecurringSaveButtonForACH() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				clickOnElement("Corporate Account Transfer", "Save Button", saveButton);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Click save button", "Click save button successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click save button", "Could not click save button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterACHSeriesName(String name) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				enterText("Corporate Account Transfer", "Series Name", seriesNameField, name);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass - Acc Transfer -- Series Name");
					new HTMLReportHelper().HtmlReportBody("Enter series name", "Enter series name successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter series name", "Could not enter series name successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void verifyInitiatorRecurringPaymentDetailsForACH(String seriesName,String amount, String editStatus) throws Exception {
		//String initiator){
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if (isElementPresent(paymentActivityTitle)) {
					if(!amount.equals("")){
						validateTextContains("Corporate Current Payment Activity", "Amount", getDynamicElement("Amount", amount_field, seriesName),amount);
					}
					if(!"Scheduled".equals("")){
						validateTextContains("Corporate Current Payment Activity", "Status", getDynamicElement("Status", status_field, seriesName), "Scheduled");
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass -Recurring Payment Activity -Approved");
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details",
							"Validate payment details successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Validate Payment Details",
							"Could not validate payment details  successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}



}





