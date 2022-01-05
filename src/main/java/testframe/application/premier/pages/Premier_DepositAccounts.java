package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

public class Premier_DepositAccounts extends CommonLibrary{
	public String sAccountNo;
	
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By nextButton = By.xpath("//button[@value='Next']");
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	String search1 = "(//img[@title='Search'])[%s]";
	
	public By newDDHeader =  By.xpath("//td[text()='New Demand Deposit']");
	public By customerPageTitle =  By.xpath("//a[text()='Step 2 - Customer']");	
	String accountNameList =  "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	String relationshipList =  "(//select[contains(@name,'RelationshipCode')])[%s]";
	String eStatementList =  "(//select[contains(@name,'EmailAddrIndicator1')])[%s]";
	public By productList =  By.xpath("//select[contains(@name,'ProductNumber')]");
	public By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By accountNumberTextbox =  By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By initialDepositTextbox =  By.xpath("//td[contains(text(),'Initial Deposit:')]/following-sibling::td/input[contains(@id,'InitialDeposit')]");
	public By responsibilityCodeInput =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	public By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	public By accountTitlePrintOptionList = By.xpath("//select[contains(@name,'AccountTitleOption')]");
	public By accountTitleTextbox =  By.xpath("//td[contains(text(),'Account Title:')]/following-sibling::td/input[contains(@id,'AccountTitle')]");
	//public By depositInquiryHeader = By.xpath("//td[contains(text(),'Demand Deposit')]");
	String depositInquiryHeader =  "//td[contains(text(),'%s')]";
	public By productInquiryPage = By.xpath("//td[contains(text(),'Product:')]/following-sibling::td[1]");
	String accountNameInquiryPage =  "//td//u[contains(text(),'%s')]";
	String relationshipInquiryPage =  "//td[contains(text(),'%s')]";
	
	String depositChangeHeader = "//a[contains(text(),'%s')]";
	public By warningTextbox =  By.xpath("//td[contains(text(),'Warning:')]/following-sibling::td/input[contains(@name,'Warning')]");
	public By statusCodeList =  By.xpath("//td[contains(text(),'Status Code:')]/following-sibling::td/select[contains(@name,'/StatusCode')]");
	public By transactionRestrictionCodeInput =  By.xpath("(//input[contains(@name,'TranRestrictionCode')])[1]");
	public By transactionRestrictionCodeButton =  By.xpath("(//input[contains(@name,'TranRestrictionCode')])[3]");
	String transactionRestrictionCodeList =  "//select[contains(@name,'TranRestrictionCode')]/option[contains(text(),'%s')]";
	public By statementCycleList =  By.xpath("//td[contains(text(),'Statement Cycle:')]/following-sibling::td/select[contains(@name,'/StatementCycle')]");
	public By alternateCycleOptionList =  By.xpath("//td[contains(text(),'Alternate Cycle Option:')]/following-sibling::td/select[contains(@name,'/AlternateCycleOption')]");
	public By alternateCycleTextInput =  By.xpath("(//input[contains(@id,'AlternateCycle')])[1]");
	public By alternateCycleInput =  By.xpath("(//input[contains(@id,'AlternateCycle')])[2]");
	public By alternateCycleBtn =  By.xpath("(//input[contains(@id,'AlternateCycle')])[3]");
	String alternateCycleList = "(//select[contains(@id,'AlternateCycle')])[2]/option[contains(text(),'%s')]";
	public By notificationOptionList = By.xpath("//td[contains(text(),'Notification Option:')]/following-sibling::td/select[contains(@name,'NotificationCode')]");
	public By suspendedInterestList = By.xpath("//td[contains(text(),'Interest Cycle:')]/following-sibling::td/select[contains(@name,'SuspendInterestCycle')]");
	public By suspendedDepositRateIndexInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[2]");
	public By suspendedDepositRateIndexTextInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[1]");
	public By suspendedDepositRateIndexBtn = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[3]");
	String suspendedDepositRateIndexList = "//select[contains(@id,'SuspendDepRateCode')]/option[contains(text(),'%s')]";
	public By suspendedStatementCycleList = By.xpath("//select[contains(@id,'SuspendStatementCycle')]");
	
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By statusCodeInquiryPage =  By.xpath("//td[text()='Status Code:']/following-sibling::td[1]");
	public By statementCycleInquiryPage =  By.xpath("//td[text()='Statement Cycle:']/following-sibling::td[1]");
	public By expandWarningInquiryPage =  By.xpath("//img[@id='WarningsArrow']");
	public By warningInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	public By transRestrictionCodeInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Transaction Restriction Code:')]");
	public By suspendFieldCheckBox=  By.xpath("//tr[@class='dataRow']//td//u[contains(text(),'Suspend Fields will be Cleared')]/../..//input");
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
	String verifyHoldData =  "//table[@name='Holds']//td[contains(text(),'%s')]";
	public By ticklerExpand = By.xpath("//table[@name='Ticklers']//img[@class='csr-hand']");
	String verifyTicklerData =  "//table[@name='Ticklers']//td[contains(text(),'%s')]";
	
	
	
	public Premier_DepositAccounts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void newDepositAccount_CustomerScreen(String sName, String sDepositRelationship, String sDepositStatement, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
				if(isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Deposit Page", "Name Field", getDynamicElement("Name Field",accountNameList,Integer.toString(CustomerCount)), sName);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field", getDynamicElement("eStatement Field",eStatementList,Integer.toString(CustomerCount)), sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Deposit Account Customer Screen", "Customer Details entered on New Deposit Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Deposit Account Customer Screen", "Could not entered Customer details", "Failed",
						driver, "Y");
			}
		}}
	public void newDepositAccount_CustomerScreenSearch(String sSN,String sName, String sDepositRelationship, String sDepositStatement, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
				if(isElementPresent(customerPageTitle)) {
					clickOnElement("New Deposit Page", "Search Icon", getDynamicElement("Search Icon",search1,Integer.toString(CustomerCount)));
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);
					
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					
					selectElementByVisibleText("New Deposit Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field", getDynamicElement("eStatement Field",eStatementList,Integer.toString(CustomerCount)), sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen", "Customer Details Searched on New Deposit Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen", "Could not Searched Customer details", "Failed",
						driver, "Y");
			}
		}}
	public void newDepositAccount_CustomerScreenDetails(String sProduct) throws Exception{
		boolean stepResult = false;
		try {
				if(isElementPresent(customerPageTitle)) {
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
				new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account", "Details entered on New Deposit Account Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account ", "Could not entered details", "Failed",
						driver, "Y");
			}
		}}
	public void newDepositAccount_CodesScreen(String sDepositAccntNo, String sInitialDeposit,String sResponsibilityCode,String sAccountTitlePrintOption,String sAccountTitle,String excelFilePath, String sheetName, int rowNo) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(codesPageTitle)) {
				/*
				clickOnElement("New DD Account Page", "Next Available Link",nextAvailableLink);
				Thread.sleep(2000);
				sAccountNo=getElementAttribute("New DD Account Page", "Account No",  accountNumberTextbox,"value");
				if(sAccountNo != "")
					new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "Deposit_AccountNumber", rowNo, sAccountNo);				
				*/
				if (!sDepositAccntNo.equals("")) {
					enterText("New Deposit Account Page", "Account Number", accountNumberTextbox, sDepositAccntNo);
				}				
				if (!sInitialDeposit.equals("")) {
					enterText("New Deposit Account Page", "Initial Deposit Type", initialDepositTextbox, sInitialDeposit);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Deposit Account Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Deposit Account Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sAccountTitlePrintOption.equals("")) {
					selectElementByVisibleText("New Deposit Account Page", "Account Title Print Option Field", accountTitlePrintOptionList, sAccountTitlePrintOption);
				}
				if (!sAccountTitle.equals("")) {
					enterText("New Deposit Account Page", "Account Title Code", accountTitleTextbox, sAccountTitle);
				}
				waitElement(5000);
				//clickOnElement("New DD Account Page", "Finish Button", finishButton);
				//Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				//switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Details Entered on Codes Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Could not entered details on Codes Screen", "Failed",driver, "Y");
			}
			
		}}
	public void depositFinishButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Deposit Page", "Finish Button", finishButton);
			Thread.sleep(5000);
			validateElementPresent("New Deposit Page", "Search Title", searchTitle2);
			driver.switchTo().defaultContent();
			//switchToWindowWithTitleContaining("Institution");
			stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Clicked on Finish Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Could not clicked on Finish Button", "Failed",driver, "Y");
			}	
		}}
	public void searchAccount(String accountNo) throws Exception{
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
				new HTMLReportHelper().HtmlReportBody("Search Account", "Search Account on Account page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Account", "Could not Search Account on Account page Successfully", "Failed",
						driver, "Y");
			}
		}}
	public void validateAccountDetails(String sAccountNumber,String customerName, String sCustomerRelationship, String sProduct) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",depositInquiryHeader,sAccountNumber))){
				validateTextContains("Account Inquiry" , "Name field", getDynamicElement("Name field",accountNameInquiryPage,customerName), customerName);
				validateTextContains("Account Inquiry" , "Relationship field", getDynamicElement("Relationship field",relationshipInquiryPage,sCustomerRelationship), sCustomerRelationship);
				//validateTextContains("Account Inquiry" , "Product field", productInquiryPage, sProduct);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation", "Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Could not Validated Customer Details on Customer Inquiry page" , "Failed", driver, "Y");
			}
		}}
	public void closeScreen_Image() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
			Thread.sleep(5000);
			validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution");
			stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Clicked on Close Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Could not clicked on Close Button", "Failed",driver, "Y");
			}	
		}}
	public void saveButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Change Page", "Save Button", saveButton2);
			Thread.sleep(1000);
			if (isElementPresent(suspendFieldCheckBox)){
				clickOnElement("Change Page", "	Suspend Fields will be Cleared CheckBox", suspendFieldCheckBox);
				clickOnElement("Change Page", "Save Button", saveButton2);
			}
			validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution");
			stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Clicked on Save Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Could not clicked on Save Button", "Failed",driver, "Y");
			}	
		}}
	public void changeAccountCodeDetails(String sAccountNumber,String sAccountWarning, String sAccountStatusCode, 
			String sAccntsTransRestrictionCode, String statementCycle,String sAlternateCycleOption,String sAlternateCycle, 
			String sNotificationOption,String sSuspendedStatementCycle,String sSuspendedInterestList,String sSuspendedDepositRateIndex ) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(getDynamicElement("Account Number Header field",depositChangeHeader,sAccountNumber))){
				
				if (!sAccountWarning.equals("")) {
					enterText("Change Account Page", "Warning field", warningTextbox, sAccountWarning);
				}
				if (!sAccountStatusCode.equals("")) {
					selectElementByVisibleText("Change Account Page", "Status Code Field", statusCodeList, sAccountStatusCode);
				}
				if (!sAccntsTransRestrictionCode.equals("")) {
					clickOnElement("Change Account Page", "Trans Restriction Code Input",transactionRestrictionCodeInput);
					Thread.sleep(1000);
					clickOnElement("Change Account Page", "Trans Restriction Code Button",transactionRestrictionCodeButton);
					Thread.sleep(1000);
					clickOnElement("Change Account Page", "Trans Restriction Code list",getDynamicElement("Trans Restriction Code list",transactionRestrictionCodeList,sAccntsTransRestrictionCode));
				}
				if (!statementCycle.equals("")) {
					selectElementByVisibleText("Change Account Page", "statement Cycle Field", statementCycleList, statementCycle);
				}
				
				if (!sAlternateCycleOption.equals("")) {
					selectElementByVisibleText("Change Account Page", "Alternate Cycle Option Field", alternateCycleOptionList, sAlternateCycleOption);
				}
				
				if (!sAlternateCycle.equals("")) {
					if(isElementPresent(alternateCycleTextInput)){
						clickOnElement("Change Account Page", "Alternate Cycle Input",alternateCycleTextInput);
					}
					clickOnElement("Change Account Page", "Alternate Cycle Input",alternateCycleInput);
					//Thread.sleep(1000);
					clickOnElement("Change Account Page", "Alternate Cycle Button",alternateCycleBtn);
					//Thread.sleep(1000);
					clickOnElement("Change Account Page", "Alternate Cycle list",getDynamicElement("Alternate Cycle list",alternateCycleList,sAlternateCycle));
				}
				
				if (!sNotificationOption.equals("")) {
					selectElementByVisibleText("Change Account Page", "Notification Option Field", notificationOptionList, sNotificationOption);
				}
				
				if (!sSuspendedStatementCycle.equals("")) {
					selectElementByVisibleText("Change Account Page", "Suspended Statement Cycle Field", suspendedStatementCycleList, sSuspendedStatementCycle);
				}
				
				if (!sSuspendedInterestList.equals("")) {
					selectElementByVisibleText("Change Account Page", "Suspended Interest Field", suspendedInterestList, sSuspendedInterestList);
				}
				
				if (!sSuspendedDepositRateIndex.equals("")) {
					if(isElementPresent(suspendedDepositRateIndexTextInput)){
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",suspendedDepositRateIndexTextInput);
					}
					clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",suspendedDepositRateIndexInput);
					//Thread.sleep(1000);
					clickOnElement("Change Account Page", "Suspended Deposit Rate Index Button",suspendedDepositRateIndexBtn);
					//Thread.sleep(1000);
					clickOnElement("Change Account Page", "Suspended Deposit Rate Index list",getDynamicElement("Suspended Deposit Rate Index list",suspendedDepositRateIndexList,sSuspendedDepositRateIndex));
				}
				
				stepResult = true;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Change Account Details", "Account Details changed Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details" , "Failed", driver, "Y");
			}
		}}
	public void validateAccountDetailsAfterChange(String sAccountNumber,String sAccountWarning, String sAccountStatusCode, String sAccntsTransRestrictionCode, String statementCycle) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field",codesTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",depositInquiryHeader,sAccountNumber))){			
				if (!statementCycle.equals(""))
					validateTextContains("Account Inquiry" , "Statement Cycle field", statementCycleInquiryPage, statementCycle);
				if (!sAccountStatusCode.equals(""))
					validateTextContains("Account Inquiry" , "Status Code field",statusCodeInquiryPage, sAccountStatusCode);
				//waitElement(2000);
				if (!sAccountWarning.equals("")){
					clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field",expandWarningInquiryPage);
					//waitElement(1000);
					validateTextContains("Account Inquiry" , "Warning field",warningInquiryPage, sAccountWarning);
				}
				if (!sAccntsTransRestrictionCode.equals("")){
					sAccntsTransRestrictionCode = ((sAccntsTransRestrictionCode.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry" , "Trans Restriction Code field",transRestrictionCodeInquiryPage, sAccntsTransRestrictionCode);							
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation", "Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation", "Could not Validated Account Details on Account Inquiry page" , "Failed", driver, "Y");
			}
		}}
	
	public void changeAccountHold(String sAccountNumber,String sHoldReason, String sHoldAmount, 
			String sExpirationDate, String sAccountPledgedOnLoan,String sPledgedNoteNum,String sMaximumPledge, 
			String sHoldDate,String sPendingStartDate,String sPendingAmount,String sHoldAmountOption ) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(getDynamicElement("Account Number Header field",depositChangeHeader,sAccountNumber))){
				mouseHoverCickOnElement("Change Account Page", "Hold Menu Field", fileMenu, holdMenu);
				if (isElementPresent(holdTitle)){
					
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
						selectElementByVisibleText("Change Account Page", "Account Pledged on Loan Field", accountPledgedOnLoanSelect, sAccountPledgedOnLoan);
					}
					
					if (!sPledgedNoteNum.equals("")) {
						enterText("Change Account Page", "Pledged Note Number field", pledgedNoteNum, sPledgedNoteNum);
					}
					
					if (!sMaximumPledge.equals("")) {
						enterText("Change Account Page", "Maximum Pledge field", maxPledge, sMaximumPledge);
					}
					
					if (!sHoldDate.equals("")) {
						enterText("Change Account Page", "Hold Date field", holdDate, sHoldDate);
					}
					
					if (!sPendingStartDate.equals("")) {
						enterText("Change Account Page", "Pendig Start Date field", holdPendigStrtDate, sPendingStartDate);
					}
					
					if (!sPendingAmount.equals("")) {
						enterText("Change Account Page", "Pending Amount field", holdPendingAmt, sPendingAmount);
					}
					
					if (!sHoldAmountOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Hold Amount Option Field", holdAmtOption, sHoldAmountOption);
					}
					stepResult = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details", "Account - Hold Details changed Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details", "Could not change account - Hold Details" , "Failed", driver, "Y");
			}
		}}
	
	public void validateAccountHoldDetailsAfterChange(String sAccountNumber,String sVerifyHoldAmount, String sVerifyHoldReason,
			String sVerifyExpirationDate, String sVerifyHoldDate,  String sVerifyPendingAmount) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",depositInquiryHeader,sAccountNumber))){
				if (isElementPresent(holdslabel)){
					clickOnElement("Change Account Page", "Hold Expand Button",holdExpand);
					
					if (!sVerifyHoldAmount.equals(""))
						validateElementPresent("Account Inquiry" , "Hold Amount field", getDynamicElement("Hold Amount field",verifyHoldData,sVerifyHoldAmount));
					
					if (!sVerifyHoldReason.equals(""))
						validateElementPresent("Account Inquiry" , "Hold Reason field", getDynamicElement("Hold Amount field",verifyHoldData,sVerifyHoldReason));
					
					if (!sVerifyExpirationDate.equals(""))
						validateElementPresent("Account Inquiry" , "Hold Expiration Date field", getDynamicElement("Hold Amount field",verifyHoldData,sVerifyExpirationDate));
					
					if (!sVerifyHoldDate.equals(""))
						validateElementPresent("Account Inquiry" , "Hold Date field", getDynamicElement("Hold Amount field",verifyHoldData,sVerifyHoldDate));
					
					if (!sVerifyPendingAmount.equals(""))
						validateElementPresent("Account Inquiry" , "Hold Pending Amount", getDynamicElement("Hold Amount field",verifyHoldData,sVerifyPendingAmount));
				
					
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation", "Validated Account Details - Hold on Account Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation", "Could not Validated Account Details - Hold on Account Inquiry page" , "Failed", driver, "Y");
			}
		}}
	
	public void changeAccountTickler(String sAccountNumber,String sTicklerDecription, String sTicklerAdditionalMsg, 
			String sTicklerNextDate, String sTicklerFrequencyList,String sTicklerExpDate ) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(getDynamicElement("Account Number Header field",depositChangeHeader,sAccountNumber))){
				mouseHoverCickOnElement("Change Account Page", "Tickler Menu Field", fileMenu, ticklerMenu);
				if (isElementPresent(ticklerTitle)){
					
					if (!sTicklerDecription.equals("")) {
						enterText("Change Account Page", "Tickler Description field", ticklerDecription, sTicklerDecription);
					}
					
					if (!sTicklerAdditionalMsg.equals("")) {
						enterText("Change Account Page", "Tickler Additional Message field", ticklerAdditionalMsg, sTicklerAdditionalMsg);
					}
					
					if (!sTicklerNextDate.equals("")) {
						enterText("Change Account Page", "Tickler Next Date field", ticklerNextDate, sTicklerNextDate);
					}
					
					if (!sTicklerFrequencyList.equals("")) {
						selectElementByVisibleText("Change Account Page", "Tickler Frequency Field", ticklerFrequencyList, sTicklerFrequencyList);
					}
					
					if (!sTicklerExpDate.equals("")) {
						enterText("Change Account Page", "Tickler Expiration Date field", ticklerExpDate, sTicklerExpDate);
					}
					
					
					stepResult = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details", "Account Details - Tickler changed Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details", "Could not change account Details- Tickler" , "Failed", driver, "Y");
			}
		}}
	
	public void validateAccountTickerDetailsAfterChange(String sAccountNumber,String sVerifyTicklerDescription, String sVerifyTicklerDate,
			String sVerifyTicklerFrequency,String sVerifyTicklerExpDate) throws Exception {
		boolean stepResult = false;
		try {
			
			
			mouseHoverCickOnElement("Account Inquiry Page", "Tickler Menu Field", activityMenu, ticklerMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",depositInquiryHeader,sAccountNumber))){
				if (isElementPresent(ticklerlabel)){
					clickOnElement("Change Account Page", "Tickler Expand Button",ticklerExpand);
					
					if (!sVerifyTicklerDescription.equals(""))
						validateElementPresent("Account Inquiry" , "Tickler Description field", getDynamicElement("Tickler Description field",verifyTicklerData,sVerifyTicklerDescription));
					
					if (!sVerifyTicklerDate.equals(""))
						validateElementPresent("Account Inquiry" , "Tickler Next Date field", getDynamicElement("Tickler Next Date field",verifyTicklerData,sVerifyTicklerDate));
					
					if (!sVerifyTicklerExpDate.equals(""))
						validateElementPresent("Account Inquiry" , "Tickler Expiration Date field", getDynamicElement("Tickler Expiration Date field",verifyTicklerData,sVerifyTicklerExpDate));
					
					if (!sVerifyTicklerFrequency.equals(""))
						validateElementPresent("Account Inquiry" , "Tickler Frequency field", getDynamicElement("Tickler Frequency field",verifyTicklerData,sVerifyTicklerFrequency));
					
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation", "Validated Account Details - Tickler on Account Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation", "Could not Validated Account Details - Tickler on Account Inquiry page" , "Failed", driver, "Y");
			}
		}}
	
	
}
