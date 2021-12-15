package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

public class Premier_SafeDepositBox extends CommonLibrary{
	public String sAccountNo;


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
	public By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By accountNumberTextbox =  By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By rentCodeButton =  By.xpath("(//td/input[contains(@id,'BoxRentCode')])[3]");
	public String selectRentCode =  "//select[contains(@id,'BoxRentCode')]/option[contains(text(),'%s')]";
	public By selectBillingMethod =  By.xpath("//select[contains(@id,'BillingCode')]");
	public By chargeAccount =  By.xpath("//input[contains(@id,'ChargeAccountNumber')]");
	public By selectBillingFrequency =  By.xpath("//select[contains(@id,'BillingFrequency')]");
	public By lastBillingDate =  By.xpath("//input[contains(@id,'NextBillingDate')]");
	String accountNameInquiryPage =  "//td//u[contains(text(),'%s')]";
	String relationshipInquiryPage =  "//td[contains(text(),'%s')]";



	//public By depositInquiryHeader = By.xpath("//td[contains(text(),'Demand Deposit')]");
	String sdbInquiryHeader =  "//td[contains(text(),'%s')]";

	public By lastBillingDateText = By.xpath("//td[text()='Last Billing Date:']/following-sibling::td");
	public By billingFrequencyText = By.xpath("//td[text()='Billing Frequency:']/following-sibling::td");
	public By billingMethodText = By.xpath("td[text()='Billing Method:']/following-sibling::td");



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



	public Premier_SafeDepositBox(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void newSDBAccount_CustomerScreen(String sName, String sRelationship,  int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(customerPageTitle)) {
				selectElementByVisibleText("New Safe Deposit Box Page", "Name Field", getDynamicElement("Name Field",accountNameList,Integer.toString(CustomerCount)), sName);
				//Thread.sleep(2000);
				selectElementByVisibleText("New Safe Deposit Box Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sRelationship);
				//Thread.sleep(2000);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Safe Deposit Box Account Customer Screen", "Customer Details entered on New Safe Deposit Box Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Safe Deposit Box Account Customer Screen", "Could not entered Customer details", "Failed",
						driver, "Y");
			}
		}
	}

	public void newSDBAccount_CustomerScreenSearch(String sSN,String sName, String sRelationship, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(customerPageTitle)) {
				clickOnElement("New Safe Deposit Box Page", "Search Icon", getDynamicElement("Search Icon",search1,Integer.toString(CustomerCount)));
				switchToWindowWithTitleContaining("Name Search");
				driver.switchTo().frame("bottom");
				new Premier_CustomerContact(driver).searchSSN(sSN);

				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				driver.switchTo().frame("Main");

				selectElementByVisibleText("New Safe Deposit Box Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sRelationship);
				Thread.sleep(1500);

				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Customer on New Safe Deposit Box Account Customer Screen", "Customer Details Searched on New Safe Deposit Box Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Customer on New Safe Deposit Box Account Customer Screen", "Could not Searched Customer details", "Failed",
						driver, "Y");
			}
		}
	}

	public void clickOnNext() throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(customerPageTitle)) {
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
	public void newSDBAccount_CodesScreen(String sAccountNum, String sRentCode,String sBillingMethod,String sChargeAccount,
			String sBillingFrequency,String sLastBillingDate,String excelFilePath, String sheetName, int rowNo) throws Exception {
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
				if (!sAccountNum.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Account Number", accountNumberTextbox, sAccountNum);
				}				
				if (!sRentCode.equals("")) {
					clickOnElement("New Safe Deposit Box Account Page", "Rent Code Button",rentCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Safe Deposit Box Account Page", "Rent Code list",getDynamicElement("Responsibility Code list",selectRentCode,sRentCode));
				}

				if (!sBillingMethod.equals("")) {
					selectElementByVisibleText("New Deposit Account Page", "Billing Method Field", selectBillingMethod, sBillingMethod);
				}

				if (!sChargeAccount.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Charge Account Number", chargeAccount, sChargeAccount);
				}
				if (!sBillingFrequency.equals("")) {
					selectElementByVisibleText("New Safe Deposit Box Account Page", "Billing Frequency Field", selectBillingFrequency, sBillingFrequency);
				}
				if (!sLastBillingDate.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Account Title Code", lastBillingDate, sLastBillingDate);
				}
				waitElement(1500);
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

		}
	}

	public void sdbFinishButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Safe Deposit Box Page", "Finish Button", finishButton);
			Thread.sleep(5000);
			validateElementPresent("New Safe Deposit Box Page", "Search Title", searchTitle2);
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
		}
	}
	public void searchAccount(String accountNo) throws Exception{
		boolean stepResult = false;
		try {
			waitElement(2500);
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
	public void validateAccountDetails(String sAccountNumber,String customerName,String sCustomerRelationship,String sLastBillingDate, String sBillingFrequency,
			String sBillingMethod) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbInquiryHeader,sAccountNumber))){

				validateTextContains("Account Inquiry" , "Name field", getDynamicElement("Name field",accountNameInquiryPage,customerName), customerName);
				validateTextContains("Account Inquiry" , "Relationship field", getDynamicElement("Relationship field",relationshipInquiryPage,sCustomerRelationship), sCustomerRelationship);

				if (!sLastBillingDate.equals(""))
					validateTextEquals("Account Inquiry" , "Last Billing Date field", lastBillingDateText, sBillingMethod);
				if (!sBillingFrequency.equals(""))
					validateTextEquals("Account Inquiry" , "Billing Frequency field", billingFrequencyText, sBillingMethod);
				if (!sBillingMethod.equals(""))
					validateTextEquals("Account Inquiry" , "Billing Method field", billingMethodText, sBillingMethod);
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
				new HTMLReportHelper().HtmlReportBody("Account Details Validation", "Could not Validate Account Details on Account Inquiry page" , "Failed", driver, "Y");
			}
		}}
	public void closeScreen_Image() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
			Thread.sleep(1500);
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
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbInquiryHeader,sAccountNumber))){			
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