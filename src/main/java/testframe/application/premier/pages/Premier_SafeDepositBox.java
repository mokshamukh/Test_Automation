package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.DateTimeHelper;
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


	public By customerPageTitle =  By.xpath("//a[text()='Step 2 - Customer']");	
	String accountNameList =  "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	String relationshipList =  "(//select[contains(@name,'RelationshipCode')])[%s]";
	public By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
	public By paymentPageTitle =  By.xpath("//a[text()='Step 4 - Payment']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By accountNumberTextbox =  By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By boxRentCodeInput =  By.xpath("(//td/input[contains(@id,'BoxRentCode')])[1]");
	public By updateBoxRentCodeInput =  By.xpath("(//td/input[contains(@id,'BoxRentCode')])[2]");
	public By rentCodeButton =  By.xpath("(//td/input[contains(@id,'BoxRentCode')])[3]");
	public String selectRentCode =  "//select[contains(@id,'BoxRentCode')]/option[contains(text(),'%s')]";
	public By selectBillingMethod =  By.xpath("//select[contains(@id,'BillingCode')]");
	public By chargeAccount =  By.xpath("//input[contains(@id,'ChargeAccountNumber')]");
	public By selectBillingFrequency =  By.xpath("//select[contains(@id,'BillingFrequency')]");
	public By nextBillingDate =  By.xpath("//input[contains(@id,'NextBillingDate')]");
	String accountNameInquiryPage =  "//td//u[contains(text(),'%s')]";
	String relationshipInquiryPage =  "//td[contains(text(),'%s')]";
	public By productList =  By.xpath("//select[contains(@name,'ProductNumber')]");


	//public By depositInquiryHeader = By.xpath("//td[contains(text(),'Demand Deposit')]");
	String sdbInquiryHeader =  "//td[contains(text(),'%s')]";

	public By lastBillingDateText = By.xpath("//td[text()='Last Billing Date:']/following-sibling::td");
	public By billingFrequencyText = By.xpath("//td[text()='Billing Frequency:']/following-sibling::td");
	public By billingMethodText = By.xpath("//td[text()='Billing Method:']/following-sibling::td");
	String sdbChangeHeader = "//a[contains(text(),'%s')]";
	public By updateCurrentRentDue =  By.xpath("//input[contains(@id,'CurrRentDue')]");
	public By updateNextBillingDate =  By.xpath("//input[contains(@id,'NextBillingDate')]");
	public By updateBillingFrequency =  By.xpath("//select[contains(@id,'BillingFrequency')]");
	public By updateBillingCode =  By.xpath("//select[contains(@id,'BillingCode')]");
	public By updateChargeAccount =  By.xpath("//input[contains(@id,'ChargeAccountNumber')]");
	public By updateBranchNumInput =  By.xpath("(//td/input[contains(@id,'BranchNumber')])[1]");
	public By updateBranchNumBtn =  By.xpath("(//td/input[contains(@id,'BranchNumber')])[3]");
	public By updateEscheatDate =  By.xpath("//input[contains(@id,'EscheatDate')]");
	//public By updateBoxRentCode =  By.xpath("//input[contains(@id,'BoxRentCode')]");
	public By balancesTab = By.xpath("//li//a[text()='Balances']");
	//public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By verifyCurrentRentDue =  By.xpath("(//td[text()='Current Rent Due:']/following-sibling::td)[1]");
	public By verifyLastBillingDate =  By.xpath("(//td[text()='Last Billing Date:']/following-sibling::td)[1]");
	public By verifyBillingFrequency =  By.xpath("(//td[text()='Billing Frequency:']/following-sibling::td)[1]");
	public By verifyBillingMethod =  By.xpath("(//td[text()='Billing Method:']/following-sibling::td)[1]");
	public By verifyRentCode =  By.xpath("(//td[text()='Rent Code:']/following-sibling::td)[1]");
	public By verifyEscheatDate =  By.xpath("(//td[text()='Escheat Date:']/following-sibling::td)[1]");

	public By statusCodeList =  By.xpath("//td[contains(text(),'Status Code:')]/following-sibling::td/select[contains(@name,'/StatusCode')]");
	public By transactionRestrictionCodeInput =  By.xpath("(//input[contains(@name,'TranRestrictionCode')])[1]");
	public By transactionRestrictionCodeButton =  By.xpath("(//input[contains(@name,'TranRestrictionCode')])[3]");
	String transactionRestrictionCodeList =  "//select[contains(@name,'TranRestrictionCode')]/option[contains(text(),'%s')]";
	public By statementCycleList =  By.xpath("//td[contains(text(),'Statement Cycle:')]/following-sibling::td/select[contains(@name,'/StatementCycle')]");
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By statusCodeInquiryPage =  By.xpath("//td[text()='Status Code:']/following-sibling::td[1]");
	public By statementCycleInquiryPage =  By.xpath("//td[text()='Statement Cycle:']/following-sibling::td[1]");
	public By warningInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	public By transRestrictionCodeInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Transaction Restriction Code:')]");
	public By searchBoxNumber = By.xpath("//input[contains(@id,'BoxNumber')]/../img");
	public By boxSizeButton =  By.xpath("//input[contains(@id,'bBoxSize')]");
	String boxSizeList =  "//select[contains(@id,'dBoxSize')]/option[contains(text(),'%s')]";
	public By sdbInventoryTitle = By.xpath("//td/a[text()='Safe Deposit Box Inventory Search']");
	public By searchedBoxNumberLink = By.xpath("(//td/u)[1]");
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warning1 = By.xpath("//td/u[contains(text(),'Accounting Branch Does Not Match Product Default (0)')]");
	By warningCheckBox1 = By.xpath("//td/u[contains(text(),'Accounting Branch Does Not Match Product Default (0)')]/../..//input");
	By warning2 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]");
	By warningCheckBox2 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]/../..//input");
	By saveBtn = By.xpath("//*[@title='Save']");
	
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
				switchToWindowWithTitleContaining("Institution");
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
	public void newSDBAccount_CodesScreen(String sAccountNum, String sBoxSize,String excelFilePath, String sheetName, int rowNo) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(codesPageTitle)) {
				if (!sAccountNum.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Account Number", accountNumberTextbox, sAccountNum);
				}				
				/*if (!sRentCode.equals("")) {
					clickOnElement("New Safe Deposit Box Account Page", "Rent Code Button",rentCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Safe Deposit Box Account Page", "Rent Code list",getDynamicElement("Rent Code list",selectRentCode,sRentCode));
				}*/
				if (!sBoxSize.equals("")) {
					clickOnElement("New Safe Deposit Box Account Page", "Box Number Search Icon", searchBoxNumber);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Safe Deposit Box Inventory Search");
					Thread.sleep(4000);
					driver.switchTo().frame("bottom");
					searchBoxSize(sBoxSize);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					waitElement(2000);
				}
				waitElement(1500);
				clickOnElement("New SDB Page", "Next Button", nextButton);
				waitElement(1500);
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
	
	public void newSDBAccount_PaymentScreen(String sBillingMethod,String sChargeAccount,
			String sBillingFrequency,String sNextBillingDate,String excelFilePath, String sheetName, int rowNo) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(paymentPageTitle)) {
				
				if (!sBillingMethod.equals("")) {
					selectElementByVisibleText("New Deposit Account Page", "Billing Method Field", selectBillingMethod, sBillingMethod);
				}

				if (!sChargeAccount.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Charge Account Number", chargeAccount, sChargeAccount);
				}
				if (!sBillingFrequency.equals("")) {
					selectElementByVisibleText("New Safe Deposit Box Account Page", "Billing Frequency Field", selectBillingFrequency, sBillingFrequency);
				}
				if (!sNextBillingDate.equals("")) {
					enterText("New Safe Deposit Box Account Page", "Account Title Code", nextBillingDate, sNextBillingDate);
				}
				waitElement(1500);
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
			if(isElementPresent(warningHeader)) {
				if (isElementPresent(warning1)) {
					clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
				}
				clickOnElement("New Loan Page", "Save Button", saveBtn);
				waitElement(2000);
			}
			validateElementPresent("New Safe Deposit Box Page", "Search Title", searchTitle2);
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
		}
	}
	public void searchAccount(String accountNo) throws Exception{
		boolean stepResult = false;
		try {
			waitElement(2500);
			driver.switchTo().frame("Main");
			if (isElementPresent(searchTitle2)) {
				//clickOnElement("Search Account Page", "Account Number", accountSearch);
				enterText("Search Account Page", "Account Number", accountSearch, accountNo);
				waitElement(1000);
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
	public void validateAccountDetails(String sAccountNumber,String customerName,String sCustomerRelationship, String sBillingFrequency,
			String sBillingMethod) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbInquiryHeader,sAccountNumber))){

				validateTextContains("Account Inquiry" , "Name field", getDynamicElement("Name field",accountNameInquiryPage,customerName), customerName);
				validateTextContains("Account Inquiry" , "Relationship field", getDynamicElement("Relationship field",relationshipInquiryPage,sCustomerRelationship), sCustomerRelationship);

				//if (!sNextBillingDate.equals(""))
				//	validateTextEquals("Account Inquiry" , "Last Billing Date field", lastBillingDateText, sNextBillingDate);
				if (!sBillingFrequency.equals(""))
					validateTextEquals("Account Inquiry" , "Billing Frequency field", billingFrequencyText, sBillingFrequency);
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
			//Thread.sleep(2500);
			if(isElementPresent(warningHeader)) {
				if (isElementPresent(warning2)) {
					clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
				}
				clickOnElement("New Loan Page", "Save Button", saveBtn);
				waitElement(2000);
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
	public void changeAccountCodesDetails(String sAccountNumber,String sCurrentRentDue,String sNextBillingDate, 
			String sBillingFrequency,String sBillingCode, String sChargeAccountNumber, String sBoxRentCode,
			String sEscheatDate) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbChangeHeader,sAccountNumber))){
				
				clickOnElement("Change Account Page", "Balances Tab Field",balancesTab);
				waitElement(2000);
				if (!sCurrentRentDue.equals("")) {
					clearAndType("Change Account Page", "Current Rent Due field", updateCurrentRentDue, sCurrentRentDue);
				}

				if (!sNextBillingDate.equals("")) {
					clearAndType("Change Account Page", "Last Billing Date field", updateNextBillingDate, sNextBillingDate);
				}

				if (!sBillingFrequency.equals("")) {
					selectElementByVisibleText("Change Account Page", "Billing Frequency Field", updateBillingFrequency, sBillingFrequency);
				}

				if (!sBillingCode.equals("")) {
					selectElementByVisibleText("Change Account Page", "Billing Method Field", updateBillingCode, sBillingCode);
				}

				if (!sChargeAccountNumber.equals("")) {
					clearAndType("Change Account Page", "Charge Account Number field", updateChargeAccount, sChargeAccountNumber);
				}
				clickOnElement("Change Account Page", "Codes Tab Field",codesTab);
				waitElement(2000);
				if (!sBoxRentCode.equals("")) {
					clickOnElement("Change Account Page", "Rent Code field",  boxRentCodeInput);
					clearText("Change Account Page", "Rent Code field", updateBoxRentCodeInput);
					Thread.sleep(1000);
					//clickAfterWaitForElementToBeClickable("Change Account Page", "Rent Code Button",rentCodeButton);
					clickOnElement("Change Account Page", "Rent Code Button",rentCodeButton);
					Thread.sleep(1000);
					clickOnElement("Change Account Page", "Rent Code list",getDynamicElement("Rent Code list",selectRentCode,sBoxRentCode));
				}
				if (!sEscheatDate.equals("")) {
					clearAndType("Change Account Page", "Escheat Date field", updateEscheatDate, sEscheatDate);
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
	public void validateAccountBalancesAfterChange(String sAccountNumber,String sVerifyCurrentRentDue, String sVerifyLastBillingDate, String sVerifyBillingFrequency, String sVerifyBillingMethod) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(3500);
			//clickOnElement("Account Inquiry Page", "Codes Tab Field",codesTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbInquiryHeader,sAccountNumber))){			
				if (!sVerifyCurrentRentDue.equals(""))
					validateTextContains("Account Inquiry" , "Current Rent Due field", verifyCurrentRentDue, sVerifyCurrentRentDue);
				if (!sVerifyLastBillingDate.equals("")) {
					sVerifyLastBillingDate = new DateTimeHelper().getDateTime(sVerifyLastBillingDate,"MM/dd/yyyy","MMM dd, yyyy");
					validateTextEquals("Account Inquiry" , "Last Billing Date field", verifyLastBillingDate, sVerifyLastBillingDate);
				}
				if (!sVerifyBillingFrequency.equals(""))
					validateTextEquals("Account Inquiry" , "Billing Frequency field", verifyBillingFrequency, sVerifyBillingFrequency);
				if (!sVerifyBillingMethod.equals(""))
					validateTextEquals("Account Inquiry" , "Billing Method field", verifyBillingMethod, sVerifyBillingMethod);
					
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
	
	public void validateAccountCodesAfterChange(String sAccountNumber,String sVerifyEscheatDate, String sVerifyRentCode) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(2500);
			clickOnElement("Account Inquiry Page", "Codes Tab Field",codesTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",sdbInquiryHeader,sAccountNumber))){			
				
				if (!sVerifyEscheatDate.equals(""))
					validateTextEquals("Account Inquiry" , "Escheat Date field", verifyEscheatDate, sVerifyEscheatDate);
				if (!sVerifyRentCode.equals(""))
					validateTextContains("Account Inquiry" , "Rent Code field", verifyRentCode, ((sVerifyRentCode.split("\\["))[0]).trim());
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
	public void newSDB_CustomerProductDetails(String sProduct) throws Exception{
		boolean stepResult = false;
		try {
				if(isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New SDB Page", "Product Field", productList, sProduct);
					Thread.sleep(1000);
					clickOnElement("New SDB Page", "Next Button", nextButton);
					stepResult = true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Details on New SDB Customer Screen", "Details entered on New SDB Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details on New SDB Customer Screen", "Could not entered details", "Failed",
						driver, "Y");
			}
		}
	}
	
	public void searchBoxSize(String sBoxSize) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			//switchToWithinFrameWithName("Main");
			if (isElementPresent(sdbInventoryTitle)) {
				Thread.sleep(2000);
				clickOnElement("New SDB Inventory Page", "Box Size Button",boxSizeButton);
				Thread.sleep(2000);
				clickOnElement("New SDB Inventory Page", "Box Size list",getDynamicElement("Box Size list",boxSizeList,sBoxSize));
				clickOnElement("Search Account Page", "Submit button", submitSearch);
				waitElement(3000);
				clickOnElement("Search SDB Inventory Page", "Search Account Link", searchedBoxNumberLink);
				Thread.sleep(2000);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Account", "Search Account  Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Account", "Could not search the Account","Failed", driver, "Y");
				System.setProperty("runStep","N");
			}
		}
	}
}
}
