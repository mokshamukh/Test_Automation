package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

public class Premier_DepositAccounts extends CommonLibrary {
	public String sAccountNo, tempVar;

	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	// public By nameLink =
	// By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By nameLink = By.xpath("//a[starts-with(@onclick, 'ModalClose')]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By nextButton = By.xpath("//button[@v/alue='Next']");
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	String search1 = "(//img[@title='Search'])[%s]";

	public By newDDHeader = By.xpath("//td[text()='New Demand Deposit']");
	public By customerPageTitle = By.xpath("//a[text()='Step 2 - Customer']");
	String accountNameList = "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	String relationshipList = "(//select[contains(@name,'RelationshipCode')])[%s]";
	String eStatementList = "(//select[contains(@name,'EmailAddrIndicator1')])[%s]";
	public By productList = By.xpath("//select[contains(@name,'ProductNumber')]");
	public By codesPageTitle = By.xpath("//a[text()='Step 3 - Codes']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By accountNumberTextbox = By.xpath(
			"//td[contains(text(),'Account Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By initialDepositTextbox = By.xpath(
			"//td[contains(text(),'Initial Deposit:')]/following-sibling::td/input[contains(@id,'InitialDeposit')]");
	public By responsibilityCodeInput = By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	public By responsibilityCodeButton = By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	String responsibilityCodeList = "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	public By accountTitlePrintOptionList = By.xpath("//select[contains(@name,'AccountTitleOption')]");
	public By accountTitleTextbox = By
			.xpath("//td[contains(text(),'Account Title:')]/following-sibling::td/input[contains(@id,'AccountTitle')]");
	// public By depositInquiryHeader = By.xpath("//td[contains(text(),'Demand
	// Deposit')]");
	String depositInquiryHeader = "//td[contains(text(),'%s')]";
	public By productInquiryPage = By.xpath("//td[contains(text(),'Product:')]/following-sibling::td[1]");
	String accountNameInquiryPage = "//td//u[contains(text(),'%s')]";
	String relationshipInquiryPage = "//td[contains(text(),'%s')]";

	String depositChangeHeader = "//a[contains(text(),'%s')]";
	public By warningTextbox = By
			.xpath("//td[contains(text(),'Warning:')]/following-sibling::td/input[contains(@name,'Warning')]");
	public By statusCodeInput = By.xpath("(//input[contains(@name,'/StatusCode')])[1]");
	public By statusCodeBtn = By.xpath("(//input[contains(@name,'/StatusCode')])[3]");
	String statusCodeDropDown = "//select[contains(@name,'StatusCode')]/option[contains(text(),'%s')]";
	public By statusCodeList = By
			.xpath("//td[contains(text(),'Status Code:')]/following-sibling::td/select[contains(@name,'/StatusCode')]");
	public By transactionRestrictionCodeInput = By.xpath("(//input[contains(@name,'TranRestrictionCode')])[1]");
	public By transactionRestrictionCodeButton = By.xpath("(//input[contains(@name,'TranRestrictionCode')])[3]");
	String transactionRestrictionCodeList = "//select[contains(@name,'TranRestrictionCode')]/option[contains(text(),'%s')]";
	public By statementCycleList = By.xpath(
			"//td[contains(text(),'Statement Cycle:')]/following-sibling::td/select[contains(@name,'/StatementCycle')]");
	public By alternateCycleOptionList = By.xpath(
			"//td[contains(text(),'Alternate Cycle Option:')]/following-sibling::td/select[contains(@name,'/AlternateCycleOption')]");
	public By alternateCycleTextInput = By.xpath("(//input[contains(@id,'AlternateCycle')])[1]");
	public By alternateCycleInput = By.xpath("(//input[contains(@id,'AlternateCycle')])[2]");
	public By alternateCycleBtn = By.xpath("(//input[contains(@id,'AlternateCycle')])[3]");
	String alternateCycleList = "(//select[contains(@id,'AlternateCycle')])[2]/option[contains(text(),'%s')]";
	public By notificationOptionList = By.xpath(
			"//td[contains(text(),'Notification Option:')]/following-sibling::td/select[contains(@name,'NotificationCode')]");
	public By suspendedInterestList = By.xpath(
			"//td[contains(text(),'Interest Cycle:')]/following-sibling::td/select[contains(@name,'SuspendInterestCycle')]");
	public By suspendedDepositRateIndexInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[2]");
	public By suspendedDepositRateIndexTextInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[1]");
	public By suspendedDepositRateIndexBtn = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[3]");
	String suspendedDepositRateIndexList = "//select[contains(@id,'SuspendDepRateCode')]/option[contains(text(),'%s')]";
	public By suspendedStatementCycleList = By.xpath("//select[contains(@id,'SuspendStatementCycle')]");

	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By statusCodeInquiryPage = By.xpath("//td[text()='Status Code:']/following-sibling::td[1]");
	public By statementCycleInquiryPage = By.xpath("//td[text()='Statement Cycle:']/following-sibling::td[1]");
	public By expandWarningInquiryPage = By.xpath("//img[@id='WarningsArrow']");
	public By warningInquiryPage = By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	public By transRestrictionCodeInquiryPage = By
			.xpath("//table[@name='Warnings']//td[contains(text(),'Transaction Restriction Code:')]");
	public By suspendFieldCheckBox = By
			.xpath("//tr[@class='dataRow']//td//u[contains(text(),'Suspend Fields will be Cleared')]/../..//input");
	public By fileMenu = By.xpath("//a[text()='File']");
	public By holdMenu = By.xpath("//a[contains(text(),'Hold')]");
	public By holdTitle = By.xpath("//a[contains(text(),'Hold - New')]");
	public By holdReason = By.xpath("//input[contains(@id,'HoldReason')]");
	public By holdAMount = By.xpath("//input[contains(@id,'HoldAmount')]");
	public By holdExpDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By accountPledgedOnLoanSelect = By.xpath("//select[contains(@id,'PledgedCode')]");
	public By pledgedNoteNum = By.xpath("//input[contains(@id,'NoteNumber')]");
	public By maxPledge = By.xpath("//input[contains(@id,'MaximumPledgedAmount')]");
	public By holdDate = By.xpath("//input[contains(@id,'HoldDate')]");
	public By holdPendigStrtDate = By.xpath("//input[contains(@id,'PendingHoldDate')]");
	public By holdPendingAmt = By.xpath("//input[contains(@id,'PendingHoldAmount')]");
	public By holdAmtOption = By.xpath("//select[contains(@id,'HoldAmountOption')]");
	public By holdslabel = By.xpath("//td[text()='Holds']");
	public By holdExpand = By.xpath("//table[@name='Holds']//img[@class='csr-hand']");
	public By ticklerMenu = By.xpath("//a[contains(text(),'Tickler')]");
	public By ticklerTitle = By.xpath("//a[contains(text(),'Tickler - New')]");
	public By ticklerDecription = By.xpath("//input[contains(@id,'Description')]");
	public By ticklerAdditionalMsg = By.xpath("//input[contains(@id,'AdditionalMessage')]");
	public By ticklerNextDate = By.xpath("//input[contains(@id,'NextTicklerDate')]");
	public By ticklerFrequencyList = By.xpath("//select[contains(@id,'RecurringFrequency')]");
	public By ticklerExpDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By activityMenu = By.xpath("//a[text()='Activity']");
	public By ticklerlabel = By.xpath("//td[text()='Ticklers']");
	String verifyHoldData = "//table[@name='Holds']//td[contains(text(),'%s')]";
	String ticklerExpand = "//table[@name='Ticklers']//td[text()='%s']//..//img";
	// public By ticklerExpand =
	// By.xpath("//table[@name='Ticklers']//img[@class='csr-hand']");
	String verifyTicklerData = "//table[@name='Ticklers']//td[contains(text(),'%s')]";

	public By overdraftsMenu = By.xpath("//a[text()='Overdrafts']");
	public By overdraftsSectionLabel = By.xpath("(//a[text()='Overdrafts'])[2]");
	public By overdraftLimit = By.xpath("//input[contains(@id,'OverdraftLimit')]");
	public By overdraftLimitPriorityList = By.xpath("//select[contains(@id,'OverdraftLimitPriority')]");
	public By ddBaseAccount = By.xpath("//input[contains(@id,'BaseAccount')]");
	String warningsCheckbox = "(//table[@class='advisoryTable']//input[@type='checkbox'])[%s]";
	public By warningsCheckbox_1 = By.xpath("//table[@class='advisoryTable']//input[@type='checkbox']");
	public By overdraftslabel = By.xpath("//td[text()='Overdrafts']");
	String verifyOverdraftsData = "//table[@name='Overdrafts']//td[contains(text(),'%s')]";

	public By newStopPayAddImg = By.xpath("//img[@alt='New']");
	public By stopPayMenu = By.xpath("//a[contains(text(),'Stop Pay')]");
	public By stopPayLabel = By.xpath("//a[text()='Stop Pay - New']");
	public By stopPayTypeInput = By.xpath("(//input[contains(@id,'ItemType')])[2]");
	public By stopPayTypeSelect = By.xpath("(//input[contains(@id,'ItemType')])[3]");
	String stopPayTypeList = "//select[contains(@id,'ItemType')]/option[contains(text(),'%s')]";
	public By stopPayItemDescription = By.xpath("//input[contains(@id,'ItemTypeDescription')]");
	public By stopPayDate = By.xpath("(//input[contains(@id,'StopItemDate')])[1]");
	public By stopPayItemDate = By.xpath("(//input[contains(@id,'ItemDate')])[2]");
	public By stopPayExpireDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By stopPayFromNum = By.xpath("//input[contains(@id,'FromNumber')]");
	public By stopPayThruNum = By.xpath("//input[contains(@id,'ThruNumber')]");
	public By stopPayFromAmt = By.xpath("//input[contains(@id,'FromAmount')]");
	public By stopPayThruAmt = By.xpath("//input[contains(@id,'ThruAmount')]");
	public By stopPayFromTransCode = By.xpath("//input[contains(@id,'FromTranCode')]");
	public By stopPayThruTransCode = By.xpath("//input[contains(@id,'ThruTranCode')]");
	public By stopPayACHCompanyID = By.xpath("//input[contains(@id,'AchCompanyId')]");
	public By stopPayPayee = By.xpath("//input[contains(@id,'Payee')]");
	public By stopPayPayeeReason = By.xpath("//input[contains(@id,'Reason')]");
	public By stopPayPayeeComments = By.xpath("//input[contains(@id,'Comments')]");
	public By stopPayInquirylabel = By.xpath("//td[text()='Stop Pays']");
	String verifyStopPayData = "//table[@name='Stop Pays']//td[contains(text(),'%s')]";
	String expandStopPayInquiry = "//table[@name='Stop Pays']//td[contains(text(),'%1$s')]/following-sibling::td[text()='%2$s']//..//img";

	public By relationshipTab = By.xpath("//li//a[text()='Relationships']");
	public By searchIconName = By.xpath("(//img[@title='Search'])[1]");
	String relationshipAddName = "//u[text()='%s']/../../td/select[contains(@id,'RelationshipCode')]";
	String newName = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'RelatedToIdTMP')])[%s]";
	String newEstatement = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'EmailAddrIndicator1')])[%s]";
	String newNameInquiryPage = "//table[@name='Relationships']//u[text()='%s']";
	String updateName = "//b[text()='Name']/../../..//u[text()='%s']";
	String newNameRelationshipInquiryPage = "//table[@name='Relationships']//u[text()='%s']/../../td[10]";
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warning1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]");
	By warningCheckBox1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]/../..//input");
	By warning2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]");
	By warningCheckBox2 = By
			.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]/../..//input");
	By warning3 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]");
	By warningCheckBox3 = By
			.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]/../..//input");
	By warning4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]");
	By warningCheckBox4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]/../..//input");
	//By saveBtn = By.xpath("//*[@title='Save']");
	By maturityTab = By.xpath("//li/a[text()='Maturity']");
	By maturityLabel = By.xpath("//td/a[text()='Maturity']");
	By maturityDate = By.xpath("//input[contains(@id,'MaturityDate')]");
	By maturityTerm = By.xpath("(//input[contains(@id,'Term')])[1]");
	By maturityTermCodeList = By.xpath("//select[contains(@id,'TermCode')]");
	By maturityInitialDeposit = By.xpath("//input[contains(@id,'InitialDeposit')]");
	By maturityIssueDate = By.xpath("//input[contains(@id,'OrigIssueDate')]");
	By maturityContractDateList = By.xpath("//select[contains(@id,'ContractCode')]");
	By maturityRateDateList = By.xpath("//select[contains(@id,'MaturityRateCode')]");
	
	String verifyMaturityData = "//table[@name='Maturity']//td[contains(text(),'%s')]";
	
	String removeNameIcon = "//u[text()='%s']/../../td/img[contains(@title,'Delete')]";

	public Premier_DepositAccounts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void newDepositAccount_CustomerScreen(String sName, String sDepositRelationship, String sDepositStatement,
			int CustomerCount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Deposit Page", "Name Field",
							getDynamicElement("Name Field", accountNameList, Integer.toString(CustomerCount)), sName);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "Relationship Field",
							getDynamicElement("Relationship Field", relationshipList, Integer.toString(CustomerCount)),
							sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field",
							getDynamicElement("eStatement Field", eStatementList, Integer.toString(CustomerCount)),
							sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody(
							"Enter Customer Details on New Deposit Account Customer Screen",
							"Customer Details entered on New Deposit Account Customer screen Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody(
							"Enter Customer Details on New Deposit Account Customer Screen",
							"Could not entered Customer details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CustomerScreenSearch(String sSN, String sName, String sDepositRelationship,
			String sDepositStatement, int CustomerCount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					clickOnElement("New Deposit Page", "Search Icon",
							getDynamicElement("Search Icon", search1, Integer.toString(CustomerCount)));
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);

					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");

					selectElementByVisibleText("New Deposit Page", "Relationship Field",
							getDynamicElement("Relationship Field", relationshipList, Integer.toString(CustomerCount)),
							sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field",
							getDynamicElement("eStatement Field", eStatementList, Integer.toString(CustomerCount)),
							sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen",
							"Customer Details Searched on New Deposit Account Customer screen Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen",
							"Could not Searched Customer details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CustomerScreenDetails(String sProduct) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Deposit Page", "Product Field", productList, sProduct);
					Thread.sleep(1000);
					clickOnElement("New Deposit Page", "Next Button", nextButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account",
							"Details entered on New Deposit Account Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account ",
							"Could not entered details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CodesScreen(String sDepositAccntNo, String sInitialDeposit,
			String sResponsibilityCode, String sAccountTitlePrintOption, String sAccountTitle, String excelFilePath,
			String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(codesPageTitle)) {
					/*
					 * clickOnElement("New DD Account Page",
					 * "Next Available Link",nextAvailableLink);
					 * Thread.sleep(2000);
					 * sAccountNo=getElementAttribute("New DD Account Page",
					 * "Account No", accountNumberTextbox,"value");
					 * if(sAccountNo != "") new
					 * ExcelReader().setValueInColumnforRow(excelFilePath,
					 * sheetName.toUpperCase(), "Deposit_AccountNumber", rowNo,
					 * sAccountNo);
					 */
					if (!sDepositAccntNo.equals("")) {
						enterText("New Deposit Account Page", "Account Number", accountNumberTextbox, sDepositAccntNo);
					}
					if (!sInitialDeposit.equals("")) {
						enterText("New Deposit Account Page", "Initial Deposit Type", initialDepositTextbox,
								sInitialDeposit);
					}
					if (!sResponsibilityCode.equals("")) {
						clickOnElement("New Deposit Account Page", "Responsibility Code Button",
								responsibilityCodeButton);
						Thread.sleep(1000);
						clickOnElement("New Deposit Account Page", "Responsibility Code list", getDynamicElement(
								"Responsibility Code list", responsibilityCodeList, sResponsibilityCode));
					}
					if (!sAccountTitlePrintOption.equals("")) {
						selectElementByVisibleText("New Deposit Account Page", "Account Title Print Option Field",
								accountTitlePrintOptionList, sAccountTitlePrintOption);
					}
					if (!sAccountTitle.equals("")) {
						enterText("New Deposit Account Page", "Account Title Code", accountTitleTextbox, sAccountTitle);
					}
					waitElement(5000);
					// clickOnElement("New DD Account Page", "Finish Button",
					// finishButton);
					// Thread.sleep(2000);
					// driver.switchTo().defaultContent();
					// switchToWindowWithTitleContaining("Institution");
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen",
							"Details Entered on Codes Screen Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen",
							"Could not entered details on Codes Screen", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void depositFinishButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("New Deposit Page", "Finish Button", finishButton);
				Thread.sleep(5000);
				validateElementPresent("New Deposit Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				// switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Finish Button",
							"Clicked on Finish Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Finish Button",
							"Could not clicked on Finish Button", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void searchAccount(String accountNo) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				waitElement(6000);
				driver.switchTo().frame("Main");
				if (isElementPresent(searchTitle2)) {
					clickOnElement("Search Account Page", "Account Number", accountSearch);
					enterText("Search Account Page", "Account Number", accountSearch, accountNo);
					clickOnElement("Search Account Page", "Submit", submitSearch);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Account",
							"Search Account on Account page Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Account",
							"Could not Search Account on Account page Successfully", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetails(String sAccountNumber, String customerName, String sCustomerRelationship,
			String sProduct) throws Exception {

		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				validateTextContains("Account Inquiry", "Name field",
						getDynamicElement("Name field", accountNameInquiryPage, customerName), customerName);
				validateTextContains("Account Inquiry", "Relationship field",
						getDynamicElement("Relationship field", relationshipInquiryPage, sCustomerRelationship),
						sCustomerRelationship);
				// validateTextContains("Account Inquiry" , "Product field",
				// productInquiryPage, sProduct);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation",
						"Could not Validated Customer Details on Customer Inquiry page", "Failed", driver, "Y");

			}

		}
	}

	public void closeScreen_Image() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
				Thread.sleep(5000);
				validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button",
							"Clicked on Close Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Could not clicked on Close Button",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void saveButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Page", "Save Button", saveButton2);
				Thread.sleep(1000);
				if (isElementPresentZeroWait(suspendFieldCheckBox)) {
					clickOnElement("Change Page", "	Suspend Fields will be Cleared CheckBox", suspendFieldCheckBox);
					clickOnElement("Change Page", "Save Button", saveButton2);
				}

				if (isElementPresentZeroWait(warningsCheckbox_1)) {
					int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
					for (int i = 1; i <= count; i++) {
						clickOnElement("Change Page", "Warning CheckBox",
								getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(1500);
				}

				validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Clicked on Save Button Successfully",
							"Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Could not clicked on Save Button",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void changeAccountCodeDetails(String sAccountNumber, String sAccountWarning, String sAccountStatusCode,
			String sAccntsTransRestrictionCode, String statementCycle, String sAlternateCycleOption,
			String sAlternateCycle, String sNotificationOption, String sSuspendedStatementCycle,
			String sSuspendedInterestList, String sSuspendedDepositRateIndex) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {

					if (!sAccountWarning.equals("")) {
						enterText("Change Account Page", "Warning field", warningTextbox, sAccountWarning);
					}
					if (!sAccountStatusCode.equals("")) {
						if (isElementPresentZeroWait(statusCodeList))
							selectElementByVisibleText("Change Account Page", "Status Code Field", statusCodeList,
								sAccountStatusCode);
						else
							if (isElementPresentZeroWait(statusCodeInput))
								clickOnElement("Change Account Page", "Status Code Input",
										statusCodeInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Status Code Button",
								statusCodeBtn);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Status Code list",
								getDynamicElement("Status Code list", statusCodeDropDown,
										sAccountStatusCode));
					}
					if (!sAccntsTransRestrictionCode.equals("")) {
						clickOnElement("Change Account Page", "Trans Restriction Code Input",
								transactionRestrictionCodeInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Trans Restriction Code Button",
								transactionRestrictionCodeButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Trans Restriction Code list",
								getDynamicElement("Trans Restriction Code list", transactionRestrictionCodeList,
										sAccntsTransRestrictionCode));
					}
					if (!statementCycle.equals("")) {
						selectElementByVisibleText("Change Account Page", "statement Cycle Field", statementCycleList,
								statementCycle);
					}

					if (!sAlternateCycleOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Alternate Cycle Option Field",
								alternateCycleOptionList, sAlternateCycleOption);
					}

					if (!sAlternateCycle.equals("")) {
						if (isElementPresentZeroWait(alternateCycleTextInput)) {
							clickOnElement("Change Account Page", "Alternate Cycle Input", alternateCycleTextInput);
						}
						//clickOnElement("Change Account Page", "Alternate Cycle Input", alternateCycleInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Alternate Cycle Button", alternateCycleBtn);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Alternate Cycle list",
								getDynamicElement("Alternate Cycle list", alternateCycleList, sAlternateCycle));
					}

					if (!sNotificationOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Notification Option Field",
								notificationOptionList, sNotificationOption);
					}

					if (!sSuspendedStatementCycle.equals("")) {
						selectElementByVisibleText("Change Account Page", "Suspended Statement Cycle Field",
								suspendedStatementCycleList, sSuspendedStatementCycle);
					}

					if (!sSuspendedInterestList.equals("")) {
						selectElementByVisibleText("Change Account Page", "Suspended Interest Field",
								suspendedInterestList, sSuspendedInterestList);
					}

					if (!sSuspendedDepositRateIndex.equals("")) {
						if (isElementPresentZeroWait(suspendedDepositRateIndexTextInput)) {
							clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",
									suspendedDepositRateIndexTextInput);
						}
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",
								suspendedDepositRateIndexInput);
						// Thread.sleep(1000);
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index Button",
								suspendedDepositRateIndexBtn);
						// Thread.sleep(1000);
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index list",
								getDynamicElement("Suspended Deposit Rate Index list", suspendedDepositRateIndexList,
										sSuspendedDepositRateIndex));
					}

					stepResult = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details",
							"Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange(String sAccountNumber, String sAccountWarning,
			String sAccountStatusCode, String sAccntsTransRestrictionCode, String statementCycle) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!statementCycle.equals(""))
					validateTextContains("Account Inquiry", "Statement Cycle field", statementCycleInquiryPage,
							statementCycle);
				if (!sAccountStatusCode.equals(""))
					if (sAccountStatusCode.contains("]")){
						String[] sAccountStatusCode_split = sAccountStatusCode.split("]");
						sAccountStatusCode=sAccountStatusCode_split[1].trim();
					}
					validateTextContains("Account Inquiry", "Status Code field", statusCodeInquiryPage,
							sAccountStatusCode);
				// waitElement(2000);
				if (!sAccountWarning.equals("")) {
					
					// waitElement(1000);
					validateTextContains("Account Inquiry", "Warning field", warningInquiryPage, sAccountWarning);
				}
				if (!sAccntsTransRestrictionCode.equals("")) {
					sAccntsTransRestrictionCode = ((sAccntsTransRestrictionCode.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry", "Trans Restriction Code field",
							transRestrictionCodeInquiryPage, sAccntsTransRestrictionCode);
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountHold(String sAccountNumber, String sHoldReason, String sHoldAmount, String sExpirationDate,
			String sAccountPledgedOnLoan, String sPledgedNoteNum, String sMaximumPledge, String sHoldDate,
			String sPendingStartDate, String sPendingAmount, String sHoldAmountOption) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Hold Menu Field", fileMenu, holdMenu);
					if (isElementPresent(holdTitle)) {

						if (!sHoldReason.equals("")) {
							enterText("Change Account Page", "Hold Reason field", holdReason, sHoldReason);
						}

						if (!sHoldAmount.equals("")) {
							enterText("Change Account Page", "Hold Amount field", holdAMount, sHoldAmount);
						}

						if (!sExpirationDate.equals("")) {
							enterText("Change Account Page", "Expiration Date field", holdExpDate, sExpirationDate);
						}

						if (!sAccountPledgedOnLoan.equals("")) {
							selectElementByVisibleText("Change Account Page", "Account Pledged on Loan Field",
									accountPledgedOnLoanSelect, sAccountPledgedOnLoan);
						}

						if (!sPledgedNoteNum.equals("")) {
							enterText("Change Account Page", "Pledged Note Number field", pledgedNoteNum,
									sPledgedNoteNum);
						}

						if (!sMaximumPledge.equals("")) {
							enterText("Change Account Page", "Maximum Pledge field", maxPledge, sMaximumPledge);
						}

						if (!sHoldDate.equals("")) {
							enterText("Change Account Page", "Hold Date field", holdDate, sHoldDate);
						}

						if (!sPendingStartDate.equals("")) {
							enterText("Change Account Page", "Pendig Start Date field", holdPendigStrtDate,
									sPendingStartDate);
						}

						if (!sPendingAmount.equals("")) {
							enterText("Change Account Page", "Pending Amount field", holdPendingAmt, sPendingAmount);
						}

						if (!sHoldAmountOption.equals("")) {
							selectElementByVisibleText("Change Account Page", "Hold Amount Option Field", holdAmtOption,
									sHoldAmountOption);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details",
							"Account - Hold Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details",
							"Could not change account - Hold Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountHoldDetailsAfterChange(String sAccountNumber, String sVerifyHoldAmount,
			String sVerifyHoldReason, String sVerifyExpirationDate, String sVerifyHoldDate, String sVerifyPendingAmount)
					throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(holdslabel)) {
					clickOnElement("Change Account Page", "Hold Expand Button", holdExpand);

					if (!sVerifyHoldAmount.equals(""))
						validateElementPresent("Account Inquiry", "Hold Amount field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldAmount));

					if (!sVerifyHoldReason.equals(""))
						validateElementPresent("Account Inquiry", "Hold Reason field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldReason));

					if (!sVerifyExpirationDate.equals(""))
						validateElementPresent("Account Inquiry", "Hold Expiration Date field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyExpirationDate));

					if (!sVerifyHoldDate.equals(""))
						validateElementPresent("Account Inquiry", "Hold Date field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldDate));

					if (!sVerifyPendingAmount.equals(""))
						validateElementPresent("Account Inquiry", "Hold Pending Amount",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyPendingAmount));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Validated Account Details - Hold on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Could not Validated Account Details - Hold on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountTickler(String sAccountNumber, String sTicklerDecription, String sTicklerAdditionalMsg,
			String sTicklerNextDate, String sTicklerFrequencyList, String sTicklerExpDate) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Tickler Menu Field", fileMenu, ticklerMenu);
					if (isElementPresent(ticklerTitle)) {

						if (!sTicklerDecription.equals("")) {
							clearAndType("Change Account Page", "Tickler Description field", ticklerDecription,
									sTicklerDecription);
						}

						if (!sTicklerAdditionalMsg.equals("")) {
							clearAndType("Change Account Page", "Tickler Additional Message field",
									ticklerAdditionalMsg, sTicklerAdditionalMsg);
						}

						if (!sTicklerNextDate.equals("")) {
							clearAndType("Change Account Page", "Tickler Next Date field", ticklerNextDate,
									sTicklerNextDate);
						}

						if (!sTicklerFrequencyList.equals("")) {
							selectElementByVisibleText("Change Account Page", "Tickler Frequency Field",
									ticklerFrequencyList, sTicklerFrequencyList);
						}

						if (!sTicklerExpDate.equals("")) {
							clearAndType("Change Account Page", "Tickler Expiration Date field", ticklerExpDate,
									sTicklerExpDate);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details",
							"Account Details - Tickler changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details",
							"Could not change account Details- Tickler", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountTickerDetailsAfterChange(String sAccountNumber, String sVerifyTicklerDescription,
			String sVerifyTicklerDate, String sVerifyTicklerFrequency, String sVerifyTicklerExpDate) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Account Inquiry Page", "Tickler Menu Field", activityMenu, ticklerMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(ticklerlabel)) {
					getDynamicElementClick("Change Account Page", "Tickler Expand Button", ticklerExpand,
							sVerifyTicklerDescription);

					if (!sVerifyTicklerDescription.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Description field", getDynamicElement(
								"Tickler Description field", verifyTicklerData, sVerifyTicklerDescription));

					if (!sVerifyTicklerDate.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Next Date field",
								getDynamicElement("Tickler Next Date field", verifyTicklerData, sVerifyTicklerDate));

					if (!sVerifyTicklerExpDate.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Expiration Date field", getDynamicElement(
								"Tickler Expiration Date field", verifyTicklerData, sVerifyTicklerExpDate));

					if (!sVerifyTicklerFrequency.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Frequency field", getDynamicElement(
								"Tickler Frequency field", verifyTicklerData, sVerifyTicklerFrequency));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation",
						"Validated Account Details - Tickler on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation",
						"Could not Validated Account Details - Tickler on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountOverDrafts(String sAccountNumber, String sODLimit, String sOverdraftLimitPriority,
			String sDDBaseAccount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu,
							overdraftsMenu);
					if (isElementPresent(overdraftsSectionLabel)) {

						if (!sODLimit.equals("")) {
							clearAndType("Change Account Page", "Overdrafts Limit field", overdraftLimit, sODLimit);
						}

						if (!sOverdraftLimitPriority.equals("")) {
							selectElementByVisibleText("Change Account Page", "Overdraft Limit Priority Field",
									overdraftLimitPriorityList, sOverdraftLimitPriority);
						}

						if (!sDDBaseAccount.equals("")) {
							clearAndType("Change Account Page", "Demand Deposit Base Account field", ddBaseAccount,
									sDDBaseAccount);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Overdrafts Details",
							"Account Details - Overdrafts changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Overdrafts Details",
							"Could not change account Details- Overdrafts", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountODDetailsAfterChange(String sAccountNumber, String sVerifyODLimit,
			String sVerifyODLimitPriority) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, overdraftsMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(overdraftslabel)) {
					// clickOnElement("Change Account Page", "Tickler Expand
					// Button",ticklerExpand);

					if (!sVerifyODLimit.equals(""))
						validateElementPresent("Account Inquiry", "Overdrafts Limit field", getDynamicElement(
								"Overdrafts Limit field field", verifyOverdraftsData, sVerifyODLimit));

					if (!sVerifyODLimitPriority.equals(""))
						validateElementPresent("Account Inquiry", "Overdrafts Limit Priority field", getDynamicElement(
								"Overdrafts Limit Priority field", verifyOverdraftsData, sVerifyODLimitPriority));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Overdrafts Validation",
						"Validated Account Details - Overdrafts on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Overdrafts Validation",
						"Could not Validated Account Details - Overdrafts on Account Inquiry page", "Failed", driver,
						"Y");
			}
		}
	}

	public void changeAccountStopPay(String sAccountNumber, String sStopPayType, String sStopPayDate,
			String sStopPayExpireDate, String sStopPayItemDate, String sStopPayFromNum, String sStopPayThruNum,
			String sStopPayFromAmt, String sStopPayThruAmt, String sStopPayFromTransCode, String sStopPayThruTransCode,
			String sStopPayACHCompanyID, String sStopPayPayee, String sStopPayPayeeReason, String sStopPayPayeeComments)
					throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Stop Pay Menu Field", fileMenu, stopPayMenu);
					if (isElementPresent(stopPayLabel)) {

						if (!sStopPayType.equals("")) {
							clickOnElement("Change Account Page", "Stop Pay Type input field", stopPayTypeInput);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Type Dropdown Btn field",
									stopPayTypeSelect);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Type Option list",
									getDynamicElement("Stop Pay Type Option list", stopPayTypeList, sStopPayType));
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Description field", stopPayItemDescription);
						}

						if (!sStopPayDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Date field", stopPayDate, sStopPayDate);
						}

						if (!sStopPayExpireDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Expiration Date field", stopPayExpireDate,
									sStopPayExpireDate);
						}

						if (!sStopPayItemDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Item Date field", stopPayItemDate,
									sStopPayItemDate);
						}

						if (!sStopPayFromNum.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Number From field", stopPayFromNum,
									sStopPayFromNum);
						}

						if (!sStopPayThruNum.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Number Through field", stopPayThruNum,
									sStopPayThruNum);
						}

						if (!sStopPayFromAmt.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Amount From field", stopPayFromAmt,
									sStopPayFromAmt);
						}

						if (!sStopPayThruAmt.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Amount Through field", stopPayThruAmt,
									sStopPayThruAmt);
						}

						if (!sStopPayFromTransCode.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Transaction Code From field",
									stopPayFromTransCode, sStopPayFromTransCode);
						}

						if (!sStopPayThruTransCode.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Transaction Code Through field",
									stopPayThruTransCode, sStopPayThruTransCode);
						}

						if (!sStopPayACHCompanyID.equals("")) {
							clearAndType("Change Account Page", "Stop Pay ACH Company ID field", stopPayACHCompanyID,
									sStopPayACHCompanyID);
						}

						if (!sStopPayPayee.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee field", stopPayPayee, sStopPayPayee);
						}

						if (!sStopPayPayeeReason.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee Reason field", stopPayPayeeReason,
									sStopPayPayeeReason);
						}

						if (!sStopPayPayeeComments.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee Comments field", stopPayPayeeComments,
									sStopPayPayeeComments);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Stop Pay Details",
							"Account Details - Stop Pay changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Stop Pay Details",
							"Could not change account Details- Stop Pay", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountStopPayAfterChange(String sAccountNumber, String sStopPayType, String sStopPayItemDate,
			String sStopPayFromNum, String sStopPayThruNum, String sStopPayFromAmt, String sStopPayThruAmt,
			String sStopPayACHCompanyID, String sStopPayPayee, String sStopPayPayeeReason, String sStopPayDate,
			String sStopPayExpireDate) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, stopPayMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(stopPayInquirylabel)) {

					expandStopPayInquiry = String.format(expandStopPayInquiry, sStopPayType, sStopPayItemDate);
					clickOnElement("Change Account Page", "Stop Pay Expand Button",
							getDynamicElement("Stop Pay Expand field", expandStopPayInquiry, ""));

					if (!sStopPayType.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Type field",
								getDynamicElement("Stop Pay Type field", verifyStopPayData, sStopPayType));

					if (!sStopPayItemDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Item Date field",
								getDynamicElement("Stop Pay Item Date field", verifyStopPayData, sStopPayItemDate));

					if (!sStopPayFromNum.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay From Number field",
								getDynamicElement("Stop Pay From Number field", verifyStopPayData, sStopPayFromNum));

					if (!sStopPayThruNum.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Through Number field",
								getDynamicElement("Stop Pay Through Number field", verifyStopPayData, sStopPayThruNum));

					if (!sStopPayFromAmt.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay From Amount field",
								getDynamicElement("Stop Pay From Amount field", verifyStopPayData, sStopPayFromAmt));

					if (!sStopPayThruAmt.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Through Amount field",
								getDynamicElement("Stop Pay Through Amount field", verifyStopPayData, sStopPayThruAmt));

					if (!sStopPayACHCompanyID.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay ACH Comapny ID field", getDynamicElement(
								"Stop Pay ACH Comapny ID field", verifyStopPayData, sStopPayACHCompanyID));

					if (!sStopPayPayee.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Payee field",
								getDynamicElement("Stop Pay Payee field", verifyStopPayData, sStopPayPayee));

					/*
					 * if (!sStopPayPayeeReason.equals(""))
					 * validateElementPresent("Account Inquiry" ,
					 * "Stop Pay Payee Reason field",
					 * getDynamicElement("Stop Pay Payee Reason field"
					 * ,verifyStopPayData,sStopPayPayeeReason));
					 */

					if (!sStopPayDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Date field",
								getDynamicElement("Stop Pay Date field", verifyStopPayData, sStopPayDate));

					if (!sStopPayExpireDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Expiration Date field", getDynamicElement(
								"Stop Pay Expiration Date field", verifyStopPayData, sStopPayExpireDate));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay Validation",
						"Validated Account Details - Stop Pay on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay  Validation",
						"Could not Validated Account Details - Stop Pay on Account Inquiry page", "Failed", driver,
						"Y");
			}
		}
	}

	public void submitButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Page", "Submit Button", submitSearch);
				Thread.sleep(1000);
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Submit Button",
							"Clicked on Submit Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Submit Button",
							"Could not clicked on Submit Button", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void changeAccountDetails_UpdateAddRelationship(String sAccountNumber, String sUpdateName,
			String sUpdateRelationship, String sName, String sSN, String sRelationship, String sEStatement)
					throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field", relationshipTab);
				waitElement(2000);

				if (!sName.equals(""))  {
					clickOnElement("Change Account Page", "Search Icon", searchIconName);
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					searchSSN(sSN);
					waitElement(1500);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");


					selectElementByVisibleText("Change Account Page", "Add Relationship Field",
							getDynamicElement("Add Relationship list", relationshipAddName, sName), sRelationship);
					waitElement(1500);


					tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field",
							getDynamicElement("Relationship list", newName, Integer.toString(2)));
					if (tempVar.equals("(None)")) {
						selectElementByVisibleText("Change Account Page", "Account info Name Field",
								getDynamicElement("Account info Name Field", newName, Integer.toString(2)), sName);
						waitElement(1000);
						selectElementByVisibleText("Change Account Page", "Mailing info Name Field",
								getDynamicElement("Mailing info Name Field", newName, Integer.toString(5)), sName);
						waitElement(1000);
						if (!sEStatement.equals("")) {
							selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field",
									getDynamicElement("Mailing info E Statement Field", newEstatement,
											Integer.toString(2)),
									sEStatement);
						}
					} else {
						selectElementByVisibleText("Change Account Page", "Account info Name Field",
								getDynamicElement("Account info Name Field", newName, Integer.toString(3)), sName);
						waitElement(1000);
						selectElementByVisibleText("Change Account Page", "Mailing info Name Field",
								getDynamicElement("Mailing info Name Field", newName, Integer.toString(6)), sName);
						waitElement(1000);
						if (!sEStatement.equals("")) {
							selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field",
									getDynamicElement("Mailing info E Statement Field", newEstatement,
											Integer.toString(3)),
									sEStatement);
						}
					}



				}

				if (isElementPresent(getDynamicElement("Relationship Name", updateName, sUpdateName))) {
					selectElementByVisibleText("Change Account Page", "Update Relationship Field",
							getDynamicElement("Update Relationship list", relationshipAddName, sUpdateName),
							sUpdateRelationship);
					waitElement(1000);
				}

				clickOnElement("Change Page", "Save Button", saveButton2);
				Thread.sleep(2000);
				/*
				 * if(isElementPresent(warningHeader)) { if
				 * (isElementPresentZeroWait(warning2)) {
				 * clickOnElement("New Loan Page", "Warning 2 Checkbox",
				 * warningCheckBox2); } if
				 * (isElementPresentZeroWait(warning1)) {
				 * clickOnElement("New Loan Page", "Warning 1 Checkbox",
				 * warningCheckBox1); } if
				 * (isElementPresentZeroWait(warning3)) {
				 * clickOnElement("New Loan Page", "Warning 3 Checkbox",
				 * warningCheckBox3); } clickOnElement("New Loan Page",
				 * "Save Button", saveBtn); waitElement(2000); }
				 */

				if (isElementPresentZeroWait(warningsCheckbox_1)) {
					int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
					for (int i = 1; i <= count; i++) {
						clickOnElement("Change Page", "Warning CheckBox",
								getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(1500);
				}
				validateElementPresent("Change Account Page", "Search Title", searchTitle2);
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add/Update Relationship Details",
							"Relationship Add/Update Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add/Update Relationship Details",
							"Could not Add/Update Relationship Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_AddRelationship(String sAccountNumber, String sUpdateName,
			String sName, String sSN, String sUpdateRelationship, String sEStatement) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field", relationshipTab);
			switchToWithinFrameWithName("bottom");

			if (!sName.equals(""))
				validateElementPresent("Account Inquiry Page", "New Relationship Name Field",
						getDynamicElement("New Relationship Name Field", newNameInquiryPage, sName));

			if (!sUpdateName.equals("")) {
				validateElementPresent("Account Inquiry Page", "Update Relationship Name Field",
						getDynamicElement("Update Relationship Name Field", newNameInquiryPage, sUpdateName));
				validateTextContains("Account Inquiry", "Update Relationship field",
						getDynamicElement("Update Relationship Field", newNameRelationshipInquiryPage, sUpdateName),
						sUpdateRelationship);

			}
			stepResult = true;
			switchToDefaultContent();
			driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Could not Validated Relationship Details on Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountDetails_UpdateRelationship(String sAccountNumber, String sName, String sRelationship)
			throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field", relationshipTab);
				waitElement(2000);
				if (isElementPresent(getDynamicElement("Relationship Name", updateName, sName))) {
					selectElementByVisibleText("Change Account Page", "Relationship Field",
							getDynamicElement("Relationship list", relationshipAddName, sName), sRelationship);
					waitElement(2000);

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					/*
					 * if(isElementPresent(warningHeader)) { if
					 * (isElementPresentZeroWait(warning2)) {
					 * clickOnElement("New Loan Page", "Warning 2 Checkbox",
					 * warningCheckBox2); } if
					 * (isElementPresentZeroWait(warning1)) {
					 * clickOnElement("New Loan Page", "Warning 1 Checkbox",
					 * warningCheckBox1); } if
					 * (isElementPresentZeroWait(warning3)) {
					 * clickOnElement("New Loan Page", "Warning 3 Checkbox",
					 * warningCheckBox3); } clickOnElement("New Loan Page",
					 * "Save Button", saveBtn); waitElement(2000); }
					 */
					if (isElementPresentZeroWait(warningsCheckbox_1)) {
						int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
						for (int i = 1; i <= count; i++) {
							clickOnElement("Change Page", "Warning CheckBox",
									getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
						}
						clickOnElement("Change Page", "Save Button", saveButton2);
						Thread.sleep(1500);
					}

					validateElementPresent("New Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details",
							"Relationship details Updated Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details",
							"Could not Update Relationship Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_UpdateRelationship(String sAccountNumber, String sName,
			String sRelationship) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field", relationshipTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("New Relationship Name", newNameInquiryPage, sName))) {
				validateTextContains("Account Inquiry", "Relationship field",
						getDynamicElement("New Relationship Name", newNameRelationshipInquiryPage, sName),
						sRelationship);
				stepResult = true;
			}
			switchToDefaultContent();
			driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Could not Validated Relationship Details on Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void searchSSN(String sSN) throws Exception {
		if (System.getProperty("runStep") == "Y") {

			boolean stepResult = false;
			try {
				Thread.sleep(7000);
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN);
					clickOnElement("Add Name Page", "Submit", submitSearch);
					Thread.sleep(3000);
					if (isElementPresent(nameLink)) {
						clickAfterWaitForElementToBeClickable("Add Name Page", "Name link", nameLink);
						//clickOnEnterELementUsingJS(findElement(nameLink));
						Thread.sleep(4000);
					}
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search SSN", "Search SSN on Contact page Successfully",
							"Passed", driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search SSN",
							"Could not Search SSN on Contact page Successfully", "Failed", driver, "N");
					System.setProperty("runStep", "N");
				}
			}
		}

	}
	
	public void changeAccountDetails_RemoveRelationship(String sAccountNumber,String sName) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {			
				clickOnElement("Change Account Page", "Relationship Tab Field",relationshipTab);
				waitElement(1500);
				if (isElementPresent(getDynamicElement("Relationship Name",updateName,sName))) {					
					if (isElementPresentZeroWait((getDynamicElement("Remove Name Icon",removeNameIcon,sName)))) {
						clickOnElement("Change Account Page", "Remove Name Icon", (getDynamicElement("Remove Name Icon",removeNameIcon,sName)));
						waitElement(1500);
					}
					for (int i = 2; i<=6;i++) {
						tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field", getDynamicElement("Relationship list",newName,Integer.toString(i)));
						if (tempVar.equals(sName)) {
							selectElementByVisibleText("Change Account Page", "Account info Name Field", getDynamicElement("Account info Name Field",newName,Integer.toString(i)), "(None)");
							waitElement(1000);
						}
					}
					
					if (isElementPresentZeroWait((getDynamicElement("Remove Name Icon",removeNameIcon,sName)))) {
						clickOnElement("Change Account Page", "Remove Name Icon", (getDynamicElement("Remove Name Icon",removeNameIcon,sName)));
						waitElement(1500);
					}

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					if (isElementPresentZeroWait(warningsCheckbox_1)) {
						int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
						for (int i = 1; i <= count; i++) {
							clickOnElement("Change Page", "Warning CheckBox",
									getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
						}
						clickOnElement("Change Page", "Save Button", saveButton2);
						Thread.sleep(1500);
					}
					validateElementPresent("New Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Remove Relationship Details", "Relationship details removed Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Remove Relationship Details", "Could not remove Relationship Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_RemoveRelationship(String sAccountNumber,String sName) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(2000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);	
			switchToWithinFrameWithName("bottom");			
			if (!sName.equals("")) {
				validateElementIsNotPresent("Account Inquiry Page","Remove Relationship Name",getDynamicElement("Remove Relationship Name",newNameInquiryPage,sName));
				stepResult = true;
			}
			switchToDefaultContent();
			driver.switchTo().frame("Main");									
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation", "Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation", "Could not Validated Relationship Details on Inquiry page" , "Failed", driver, "Y");
			}
		}}

	public void changeAccountMaturityDetails(String sAccountNumber, String sMaturityDate, String sMaturityTerm,
			String sMaturityTermCode, String sMaturityInitialDeposit, String sMaturityIssueDate,
			String sMaturityContractCode, String sMaturityRateMethod) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					 if (isElementPresent(maturityLabel)){

						if (!sMaturityDate.equals("")) {
							clearAndType("Change Account Page", "Maturity Date", maturityDate, sMaturityDate);
						}
						if (!sMaturityTerm.equals("")) {
							clearAndType("Change Account Page", "Maturity Term", maturityTerm, sMaturityTerm);
						}
						if (!sMaturityTermCode.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Term Code", maturityTermCodeList,
									sMaturityTermCode);
						}
						if (!sMaturityInitialDeposit.equals("")) {
							clearAndType("Change Account Page", "Maturity Initial Deposit", maturityInitialDeposit, sMaturityInitialDeposit);
						}
						if (!sMaturityIssueDate.equals("")) {
							clearAndType("Change Account Page", "Maturity Issue Date", maturityIssueDate, sMaturityIssueDate);
						}
						if (!sMaturityContractCode.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Contract Date", maturityContractDateList,
									sMaturityContractCode);
						}
						if (!sMaturityRateMethod.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Rate Date", maturityRateDateList,
									sMaturityRateMethod);
						}
						
						stepResult = true;
					 }

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details - Maturity",
							"Account Details - Maturity changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details - Maturity", "Could not change account Details - Maturity",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	
	public void validateAccountDetailsMaturityAfterChange(String sAccountNumber, String sMaturityDate, String sMaturityTerm,
			String sMaturityTermCode, String sMaturityInitialDeposit, String sMaturityIssueDate,
			String sMaturityContractCode, String sMaturityRateMethod) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Maturity Tab Field", maturityTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (!sMaturityDate.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Date",
							getDynamicElement("Maturity Date", verifyMaturityData, sMaturityDate));
				if (!sMaturityTerm.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Term Code",
							getDynamicElement("Maturity Term Code", verifyMaturityData, sMaturityTerm+" "+sMaturityTermCode));
				if (!sMaturityInitialDeposit.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Initial Deposit",
							getDynamicElement("Maturity Initial Deposit", verifyMaturityData, sMaturityInitialDeposit));
				if (!sMaturityIssueDate.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Issue Date",
							getDynamicElement("Maturity Issue Date", verifyMaturityData, sMaturityIssueDate));
				if (!sMaturityContractCode.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Contract Code",
							getDynamicElement("Maturity Contract Code", verifyMaturityData, sMaturityContractCode));
				if (!sMaturityRateMethod.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Rate Method",
							getDynamicElement("Maturity Rate Method", verifyMaturityData, sMaturityRateMethod));
				
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Maturity Validation",
						"Validated Account Details - Maturity on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Maturity Validation",
						"Could not Validated Account Details - Maturity on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}


}
