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
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By statusCodeInquiryPage =  By.xpath("//td[text()='Status Code:']/following-sibling::td[1]");
	public By statementCycleInquiryPage =  By.xpath("//td[text()='Statement Cycle:']/following-sibling::td[1]");
	public By expandWarningInquiryPage =  By.xpath("//img[@id='WarningsArrow']");
	public By warningInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	public By transRestrictionCodeInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Transaction Restriction Code:')]");
	
	
	
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
					
					switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
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
				new HTMLReportHelper().HtmlReportBody("Enter Details on New Deposit Account Customer Screen", "Details entered on New Deposit Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details on New Deposit Account Customer Screen", "Could not entered details", "Failed",
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
				//switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
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
			//switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
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
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
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
			switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
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
			Thread.sleep(5000);
			validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
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
	public void changeAccountDetails(String sAccountNumber,String sAccountWarning, String sAccountStatusCode, String sAccntsTransRestrictionCode, String statementCycle) throws Exception {
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
			waitElement(5000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field",codesTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",depositInquiryHeader,sAccountNumber))){			
				validateTextContains("Account Inquiry" , "Statement Cycle field", statementCycleInquiryPage, statementCycle);
				validateTextContains("Account Inquiry" , "Status Code field",statusCodeInquiryPage, sAccountStatusCode);
				waitElement(2000);
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field",expandWarningInquiryPage);
				waitElement(1000);
				validateTextContains("Account Inquiry" , "Warning field",warningInquiryPage, sAccountWarning);
				sAccntsTransRestrictionCode = ((sAccntsTransRestrictionCode.split("\\["))[0]).trim();
				validateTextContains("Account Inquiry" , "Trans Restriction Code field",transRestrictionCodeInquiryPage, sAccntsTransRestrictionCode);							
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Could not Validated Customer Details on Customer Inquiry page" , "Failed", driver, "Y");
			}
		}}
}
