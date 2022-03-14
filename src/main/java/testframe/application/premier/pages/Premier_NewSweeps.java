package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

/**
 * PageNage : Premier_NewSweeps
 * 
 * @author Onkar.Narlawar
 */

public class Premier_NewSweeps extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_NewSweeps(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}
	String sSweepNo; 
	String sFromAcctType,sFromAcctNo,sToAcctType,sToAcctNo;
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By warningsCheckbox_1 = By.xpath("//table[@class='advisoryTable']//input[@type='checkbox']");
	String warningsCheckbox = "(//table[@class='advisoryTable']//input[@type='checkbox'])[%s]";
	public By nextButton = By.xpath("//button[@value='Next']");
	public By nextButton2 = By.xpath("//button[@id='NextButton']");	
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By finishButton2 = By.xpath("//button[@id='SubmitButton']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	public By recordSuccessfulMsg = By.xpath("//*[text()='The record was updated successfully.']");
	String search1 = "(//img[@title='Search'])[%s]";
	public By portfolioSearch = By.xpath("//*[contains(text(),'Portfolio Number:')]/../following-sibling::td/input");
	public By selectAccountsTitle =  By.xpath("//label[contains(text(),'- Select Accounts')]");
	public By sweepNickNameInput = By.xpath("//input[contains(@id,'SweepNickname')]");
	public By sweepFrequency = By.xpath("//select[contains(@id,'SweepRecordType')]");
	public By sweepRelationshipNumber = By.xpath("//input[contains(@id,'SweepRelationship')]");
	public By fundingAccountsTitle =  By.xpath("//label[contains(text(),'Funding Accounts')]");
	public By searchDDAccountimg =  By.xpath("(//select[contains(@id,'AccountNumber')]/../img[@title='Search'])[1]");
	public By searchSweepFromAccountimg =  By.xpath("(//select[contains(@id,'AccountNumber')]/../img[@title='Search'])[2]");
	public By searchSweepToAccountimg =  By.xpath("(//select[contains(@id,'AccountNumber')]/../img[@title='Search'])[3]");
	String searchSweepFromAccountimgMultiple =  "(//select[contains(@id,'AccountNumber')]/../img[@title='Search'])[%s]";
	String searchSweepToAccountimgMultiple =  "(//select[contains(@id,'AccountNumber')]/../img[@title='Search'])[%s]";
	public By accountTypeList = By.xpath("//select[@name='SearchNewSweepAccountType']");
	public By accountNumberList = By.xpath("//input[@name='SearchNewSweepAccountNumber']");
	String searchAccountLink = "(//a[contains(text(),'%s')])[1]";
	public By sweepFlowTitle =  By.xpath("//label[contains(text(),'- Sweep Flow')]");
	public By codesTitle =  By.xpath("//label[contains(text(),'- Codes')]");
	public By addAccountLink =  By.xpath("//a[text()='Add Account']");
	
	public By fromSweepFundingMinBalance = By.xpath("(//input[contains(@id,'AccountMinBalance')])[1]");
	public By fromSweepFundingMaxBalance = By.xpath("(//input[contains(@id,'AccountMaxBalance')])[1]");
	public By ToSweepFundingMinBalance = By.xpath("(//input[contains(@id,'AccountMinBalance')])[2]");
	public By ToSweepFundingMaxBalance = By.xpath("(//input[contains(@id,'AccountMaxBalance')])[2]");
	public By sweepMinBalance = By.xpath("//label[text()='Sweep Minimum Balance:']/../following-sibling::td/input[contains(@id,'SweepMinMaxBalance')]");
	public By fromBalanceType = By.xpath("(//select[contains(@id,'BalanceType')])[1]");
	public By fromIncrement = By.xpath("(//input[contains(@id,'Increment')])[1]");
	public By fromTargetBalance = By.xpath("//input[contains(@id,'TargetBalance')]");
	public By fromChargeCode = By.xpath("(//input[contains(@id,'ChargeCode')])[1]");
	public By fromNotificationOption = By.xpath("(//select[contains(@id,'NotifOption')])[1]");
	public By fromSweepFrequency = By.xpath("(//select[contains(@id,'SweepFrequency')])[1]");
	public By fromSweepFromTransferOption = By.xpath("//select[contains(@id,'SweepFromTransferOpt')]");
	public By sweepMaxBalance = By.xpath("//label[text()='Sweep Maximum Balance:']/../following-sibling::td/input[contains(@id,'SweepMinMaxBalance')]");
	public By toBalanceType = By.xpath("(//select[contains(@id,'BalanceType')])[2]");	
	public By toIncrement = By.xpath("(//input[contains(@id,'Increment')])[2]");	
	public By toChargeCode = By.xpath("(//input[contains(@id,'ChargeCode')])[2]");	
	public By toNotificationOption = By.xpath("(//select[contains(@id,'NotifOption')])[2]");	
	public By toSweepFrequency = By.xpath("(//select[contains(@id,'SweepFrequency')])[2]");
	By warningHeader = By.xpath("//strong[text()='Select the checkbox to override the associated warning:']");
	By warning1 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]");
	By warningCheckBox1 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]/../../input");
	By warning2 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[2]");
	By warningCheckBox2 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]/../../input");
	By warning3 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]");
	By warningCheckBox3 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]/../../input");
	By warning4 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[2]");
	By warningCheckBox4 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]/../../input");	
	By saveBtn = By.xpath("//*[@title='Save']");
	public By sweepRelationshipInput =  By.xpath("//*[text()='Sweep Relationship Number:']/../following-sibling::td/input");
	String sweepRelationshipNoInquiry = "//label[text()='Sweep Relationship Number:']/../following-sibling::td/label[text()='%s']";
	String  ddAccountNumberInquiryPage = "(//label[contains(text(),'%s')])[1]";
	String  fromAccountNumberInquiryPage = "(//label[contains(text(),'%s')])[1]";
	String  toAccountNumberInquiryPage = "(//label[contains(text(),'%s')])[1]";
	
	public void searchPortfolio(String portfolioNo) throws Exception{
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
					driver.switchTo().frame("Main");
					if (isElementPresent(searchTitle)) {
						clickOnElement("Search Portfolio Page", "Portfolio Number", portfolioSearch);
						enterText("Search Portfolio Page", "Portfolio Number", portfolioSearch, portfolioNo);
						clickOnElement("Search Portfolio Page", "Submit", submitSearch);
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Portfolio", "Search Portfolio on Portfolio page Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Portfolio", "Could not Search Portfolio on Portfolio page Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void newSweep_SelectAccount(String sNickName,String sFrequency,String excelFilePath, String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(selectAccountsTitle)) {
					sSweepNo=getElementAttribute("New Sweep Page", "Sweep Relationship Number",  sweepRelationshipNumber,"value");
					if(sSweepNo != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "Sweep_RelationshipNumber", rowNo, sSweepNo);				
					
					if (!sNickName.equals("")) {
						enterText("New Sweep Page", "Sweep Nick Name Field", sweepNickNameInput, sNickName);
					}
					if (!sFrequency.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep Frequency option", sweepFrequency, sFrequency);
					}
					clickOnElement("New Sweep Page", "Next Button", nextButton2);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Select Account Screen", "Details Entered on Select Account Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Select Account Screen", "Could not entered details on Select Account Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void newSweep_FundingAccount(String sSearchDDAccountType,String sSearchDDAccountNumber,String sSearchSweepfromAccountType,String sSearchSweepfromAccountNumber,String sSearchSweepToAccountType,String sSearchSweepToAccountNumber) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(fundingAccountsTitle)) {
					if (!sSearchDDAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchDDAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchDDAccountType,sSearchDDAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					if (!sSearchSweepfromAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepFromAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepfromAccountType,sSearchSweepfromAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					if (!sSearchSweepToAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepToAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepToAccountType,sSearchSweepToAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					clickOnElement("New Sweep Page", "Next Button", nextButton2);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Details Entered on Funding Account Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Could not entered details on Funding Account Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void searchAccount(String accountType, String accountNumber) throws Exception {
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				//switchToWithinFrameWithName("Main");
				if (isElementPresent(searchTitle)) {
					selectElementByVisibleText("Searh Account Page", "Account Type Field ",accountTypeList, accountType);
					enterText("Searh Account Page", "Account field", accountNumberList, accountNumber);
					clickOnElement("Search Account Page", "Submit button", submitSearch);
					waitElement(3000);
					/*if (isElementPresent(getDynamicElement("Search Account Link",searchAccountLink,accountNumber))){
						clickOnElement("Search Account Page", "Search Account Link", getDynamicElement("Search Account Link",searchAccountLink,accountNumber));
					}*/
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Account", "Search Account  Successfully","Passed", driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Account", "Could not search the Account","Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void newSweep_SweepFlow() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(sweepFlowTitle)) {
					clickOnElement("New Sweep Page", "Next Button", nextButton2);
					waitElement(2000);
					stepResult = true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Sweep Flow Screen", "Details Entered on Sweep Flow Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Sweep Flow Screen", "Could not entered details on Sweep Flow Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void newSweep_CodesScreen(String sFromAccount_MinimumBalance, String sFromAccount_MaximumBalance, String sToAccount_MinimumBalance, String sToAccount_MaximumBalance, 
			String sSweepMinimumBalance_From, String sBalanceType_From, String sIncrement_From, String sTargetBalance_From, String sChargeCode_From, String sNotificationOption_From, 
			String sSweepFrequency_From, String sSweepFromTransferOption_From, String sSweepMaximumBalance_To, String sBalanceType_To, String sIncrement_To, String sChargeCode_To, 
			String sNotificationOption_To, String sSweepFrequency_To) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(codesTitle)) {
					if (!sFromAccount_MinimumBalance.equals("")) {
						clearAndType("New Sweep Page", "From Account Minimum Balance Field", fromSweepFundingMinBalance, sFromAccount_MinimumBalance);
					}
					if (!sFromAccount_MaximumBalance.equals("")) {
						clearAndType("New Sweep Page", "From Account Maximum Balance Field", fromSweepFundingMaxBalance, sFromAccount_MaximumBalance);
					}
					if (!sToAccount_MinimumBalance.equals("")) {
						clearAndType("New Sweep Page", "To Account Minimum Balance Field", ToSweepFundingMinBalance, sToAccount_MinimumBalance);
					}
					if (!sToAccount_MaximumBalance.equals("")) {
						clearAndType("New Sweep Page", "To Account Maximum Balance Field", ToSweepFundingMaxBalance, sToAccount_MaximumBalance);
					}
					if (!sSweepMinimumBalance_From.equals("")) {
						enterText("New Sweep Page", "Sweep Minimum Balance_From Field", sweepMinBalance, sSweepMinimumBalance_From);
					}
					if (!sBalanceType_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Balance Type_From Field", fromBalanceType, sBalanceType_From);
					}
					if (!sIncrement_From.equals("")) {
						enterText("New Sweep Page", "Increment_From Field", fromIncrement, sIncrement_From);
					}
					if (!sTargetBalance_From.equals("")) {
						enterText("New Sweep Page", "Target Balance_From Field", fromTargetBalance, sTargetBalance_From);
					}
					if (!sChargeCode_From.equals("")) {
						enterText("New Sweep Page", "Charge Code_From Field", fromChargeCode, sChargeCode_From);
					}
					if (!sNotificationOption_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Notification Option_From Field", fromNotificationOption, sNotificationOption_From);
					}
					if (!sSweepFrequency_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep Frequency_From Field", fromSweepFrequency, sSweepFrequency_From);
					}
					if (!sSweepFromTransferOption_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep From Transfer Option_From Field", fromSweepFromTransferOption, sSweepFromTransferOption_From);
					}
					if (!sSweepMaximumBalance_To.equals("")) {
						enterText("New Sweep Page", "Sweep Maximum Balance_To Field", sweepMaxBalance, sSweepMaximumBalance_To);
					}
					if (!sBalanceType_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Balance Type_To Field", toBalanceType, sBalanceType_To);
					}
					if (!sIncrement_To.equals("")) {
						enterText("New Sweep Page", "Increment_To Field", toIncrement, sIncrement_To);
					}
					if (!sChargeCode_To.equals("")) {
						enterText("New Sweep Page", "Charge Code_To Field", toChargeCode, sChargeCode_To);
					}
					if (!sNotificationOption_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Notification Option_To Field", toNotificationOption, sNotificationOption_To);
					}
					if (!sSweepFrequency_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep Frequency_To Field", toSweepFrequency, sSweepFrequency_To);
					}
					
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void newSweep_CodesScreenMultiple(String sFromAccount_MinimumBalance, String sFromAccount_MaximumBalance, String sToAccount_MinimumBalance, String sToAccount_MaximumBalance, 
			String sSweepMinimumBalance_From, String sBalanceType_From, String sIncrement_From, String sTargetBalance_From, String sChargeCode_From, String sNotificationOption_From, 
			String sSweepFrequency_From, String sSweepFromTransferOption_From, String sSweepMaximumBalance_To, String sBalanceType_To, String sIncrement_To, String sChargeCode_To, 
			String sNotificationOption_To, String sSweepFrequency_To) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(codesTitle)) {
					if (!sFromAccount_MinimumBalance.equals("")) {
						clearAndType("New Sweep Page", "From Account Minimum Balance Field", fromSweepFundingMinBalance, sFromAccount_MinimumBalance);
					}
					if (!sFromAccount_MaximumBalance.equals("")) {
						clearAndType("New Sweep Page", "From Account Maximum Balance Field", fromSweepFundingMaxBalance, sFromAccount_MaximumBalance);
					}
					if (!sToAccount_MinimumBalance.equals("")) {
						clearAndType("New Sweep Page", "To Account Minimum Balance Field", ToSweepFundingMinBalance, sToAccount_MinimumBalance);
					}
					if (!sToAccount_MaximumBalance.equals("")) {
						clearAndType("New Sweep Page", "To Account Maximum Balance Field", ToSweepFundingMaxBalance, sToAccount_MaximumBalance);
					}
					if (!sSweepMinimumBalance_From.equals("")) {
						enterText("New Sweep Page", "Sweep Minimum Balance_From Field", sweepMinBalance, sSweepMinimumBalance_From);
					}
					if (!sBalanceType_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Balance Type_From Field", fromBalanceType, sBalanceType_From);
					}
					if (!sIncrement_From.equals("")) {
						enterText("New Sweep Page", "Increment_From Field", fromIncrement, sIncrement_From);
					}
					if (!sTargetBalance_From.equals("")) {
						enterText("New Sweep Page", "Target Balance_From Field", fromTargetBalance, sTargetBalance_From);
					}
					if (!sChargeCode_From.equals("")) {
						enterText("New Sweep Page", "Charge Code_From Field", fromChargeCode, sChargeCode_From);
					}
					if (!sNotificationOption_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Notification Option_From Field", fromNotificationOption, sNotificationOption_From);
					}
					if (!sSweepFrequency_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep Frequency_From Field", fromSweepFrequency, sSweepFrequency_From);
					}
					if (!sSweepFromTransferOption_From.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep From Transfer Option_From Field", fromSweepFromTransferOption, sSweepFromTransferOption_From);
					}
					if (!sSweepMaximumBalance_To.equals("")) {
						enterText("New Sweep Page", "Sweep Maximum Balance_To Field", sweepMaxBalance, sSweepMaximumBalance_To);
					}
					if (!sBalanceType_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Balance Type_To Field", toBalanceType, sBalanceType_To);
					}
					if (!sIncrement_To.equals("")) {
						enterText("New Sweep Page", "Increment_To Field", toIncrement, sIncrement_To);
					}
					if (!sChargeCode_To.equals("")) {
						enterText("New Sweep Page", "Charge Code_To Field", toChargeCode, sChargeCode_To);
					}
					if (!sNotificationOption_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Notification Option_To Field", toNotificationOption, sNotificationOption_To);
					}
					if (!sSweepFrequency_To.equals("")) {
						selectElementByVisibleText("New Sweep Page", "Sweep Frequency_To Field", toSweepFrequency, sSweepFrequency_To);
					}
					
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void sweepFinishButton() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("New Sweep Page", "Finish Button", finishButton2);
				waitElement(5000);
				if(isElementPresent(warningHeader)) {
					if (isElementPresentZeroWait(warning1)) {
						clickOnElement("New Sweep Page", "Warning 1 Checkbox", warningCheckBox1);
					}
					if (isElementPresentZeroWait(warning2)) {
						clickOnElement("New Sweep Page", "Warning 2 Checkbox", warningCheckBox2);
					}
					if (isElementPresentZeroWait(warning3)) {
						clickOnElement("New Sweep Page", "Warning 3 Checkbox", warningCheckBox3);
					}
					if (isElementPresentZeroWait(warning4)) {
						clickOnElement("New Sweep Page", "Warning 4 Checkbox", warningCheckBox4);
					}
					clickOnElement("New Sweep Page", "Finish Button", finishButton2);
					waitElement(2000);
				}
				validateElementPresent("New Sweep Page", "Successful Record Message", recordSuccessfulMsg);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
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
					//System.setProperty("runStep","N");
				}	
			}
		}
	}
	public void searchSweep(String sSweepNo) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitElement(6000);
				driver.switchTo().frame("Main");
				if (isElementPresent(searchTitle)) {
					clickOnElement("Search Sweep Page", "Sweep Number", sweepRelationshipInput);
					enterText("Search Sweep Page", "Sweep Number", sweepRelationshipInput, sSweepNo);
					clickOnElement("Search Sweep Page", "Submit", submitSearch);
					stepResult = true;
				}	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Sweep", "Search Sweep on Sweep page Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Sweep", "Could not Search Sweep on Sweep page Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void validateDetailsInSweepInquiry(String sSweepNo,String sSearchDDAccountNumber) throws Exception {
		boolean stepResult = false;
		try {
			//switchToWithinFrameWithName("bottom");
			if(isElementPresent(getDynamicElement("Sweep Relationship Number field", sweepRelationshipNoInquiry, sSweepNo))){	
				if (!sSearchDDAccountNumber.equals("")) {
					validateTextContains("Sweep Inquiry" , "DD Account Number", getDynamicElement("DD Account Number",ddAccountNumberInquiryPage,sSearchDDAccountNumber), sSearchDDAccountNumber);
				}			
				//switchToDefaultContent();
				//switchToWithinFrameWithName("Main");
				stepResult = true;
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Sweep Details Validation", "Validated Sweep Details on Sweep Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Sweep Details Validation", "Could not Validated Sweep Details on Inquiry page" , "Failed", driver, "Y");
			}
		}
	}
	
	public void closeScreen_Image() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
				Thread.sleep(5000);
				validateElementPresent("Inquiry Page", "Search Title", searchTitle);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			}
			catch(Exception e){
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Clicked on Close Button Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Could not clicked on Close Button", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}      
			}
		}
	}
	
	public void changeAccountDetails(String sSearchDDAccountType,String sSearchDDAccountNumber,String sSearchSweepfromAccountType,String sSearchSweepfromAccountNumber,String sSearchSweepToAccountType,String sSearchSweepToAccountNumber) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(fundingAccountsTitle)) {
					if (!sSearchDDAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchDDAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchDDAccountType,sSearchDDAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					if (!sSearchSweepfromAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepFromAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepfromAccountType,sSearchSweepfromAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					if (!sSearchSweepToAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepToAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepToAccountType,sSearchSweepToAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					//clickOnElement("New Sweep Page", "Next Button", nextButton2);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Details Entered on Funding Account Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Could not entered details on Funding Account Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
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
				if (isElementPresentZeroWait(warningsCheckbox_1)) {
					int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
					for (int i = 1; i <= count; i++) {
						clickOnElement("Change Page", "Warning CheckBox",
								getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(1500);
				}

				validateElementPresent("Change Page", "Search Title", searchTitle);
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
	
	public void validateDetailsInSweepInquiryAfterChange(String sSweepNo,String sSearchDDAccountNumber,String sSearchSweepfromAccountNumber,String sSearchSweepToAccountNumber) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(getDynamicElement("Sweep Relationship Number field", sweepRelationshipNoInquiry, sSweepNo))){	
				if (!sSearchDDAccountNumber.equals("")) {
					validateTextContains("Sweep Inquiry" , "DD Account Number", getDynamicElement("DD Account Number",ddAccountNumberInquiryPage,sSearchDDAccountNumber), sSearchDDAccountNumber);
				}
				if (!sSearchSweepfromAccountNumber.equals("")) {
					validateTextContains("Sweep Inquiry" , "From Account Number", getDynamicElement("From Account Number",fromAccountNumberInquiryPage,sSearchSweepfromAccountNumber), sSearchSweepfromAccountNumber);
				}	
				if (!sSearchSweepToAccountNumber.equals("")) {
					validateTextContains("Sweep Inquiry" , "To Account Number", getDynamicElement("To Account Number",toAccountNumberInquiryPage,sSearchSweepToAccountNumber), sSearchSweepToAccountNumber);
				}	
				//switchToDefaultContent();
				//switchToWithinFrameWithName("Main");
				stepResult = true;
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Sweep Details Validation", "Validated Sweep Details on Sweep Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Sweep Details Validation", "Could not Validated Sweep Details on Inquiry page" , "Failed", driver, "Y");
			}
		}
	}
	
	public void newSweep_FundingAccount_Multiple(String sSearchDDAccountType,String sSearchDDAccountNumber,String sSearchSweepfromAccountType,String sSearchSweepfromAccountNumber,String sSearchSweepToAccountType,String sSearchSweepToAccountNumber) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(fundingAccountsTitle)) {
					if (!sSearchDDAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchDDAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchDDAccountType,sSearchDDAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					
					String[] sSearchSweepToAccountNumber_Split = sSearchSweepToAccountNumber.split("\\|\\|");
					int iSearchSweepToAccountNumberCount = sSearchSweepToAccountNumber_Split.length;
					int j=2;
					for (int i = 0; i<iSearchSweepToAccountNumberCount;i++) {
						if(i>0 && !(sSearchSweepfromAccountNumber.contains("||"))) {
							  sFromAcctType = "";
				        	  sFromAcctNo = "";
				        	  sToAcctType = (sSearchSweepToAccountType.split("\\|\\|"))[i];
				        	  sToAcctNo = (sSearchSweepToAccountNumber.split("\\|\\|"))[i];
						}else {
				        	  sFromAcctType = (sSearchSweepfromAccountType.split("\\|\\|"))[i];
				        	  sFromAcctNo = (sSearchSweepfromAccountNumber.split("\\|\\|"))[i];
				        	  sToAcctType = (sSearchSweepToAccountType.split("\\|\\|"))[i];
				        	  sToAcctNo = (sSearchSweepToAccountNumber.split("\\|\\|"))[i];
						}
			        	 if (!sFromAcctNo.equals("")) {
								clickOnElement("New Sweep Page", "Search from Account Icon", getDynamicElement("Search From Account Icon",searchSweepFromAccountimgMultiple,Integer.toString(j)));
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Search");
								Thread.sleep(4000);
								driver.switchTo().frame("bottom");
								searchAccount(sFromAcctType,sFromAcctNo);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Institution");
								driver.switchTo().frame("Main");
								waitElement(2000);
							}
			        	 	j=j+1;
			        	 if (!sToAcctNo.equals("")) {
								clickOnElement("New Sweep Page", "Search To Account Icon", getDynamicElement("Search To Account Icon",searchSweepToAccountimgMultiple,Integer.toString(j)));
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Search");
								Thread.sleep(4000);
								driver.switchTo().frame("bottom");
								searchAccount(sToAcctType,sToAcctNo);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Institution");
								driver.switchTo().frame("Main");
								waitElement(2000);	
							}
			        	 	j=j+1;
			        	 if (i>(iSearchSweepToAccountNumberCount-1)) {
			        		 clickOnElement("New Sweep Page", "Click on Add Account Link", addAccountLink);
			        	 }
			         }
					/*
					if (!sSearchSweepfromAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepFromAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepfromAccountType,sSearchSweepfromAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					if (!sSearchSweepToAccountNumber.equals("")) {
						clickOnElement("New Sweep Page", "Search DD Account Icon", searchSweepToAccountimg);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Search");
						Thread.sleep(4000);
						driver.switchTo().frame("bottom");
						searchAccount(sSearchSweepToAccountType,sSearchSweepToAccountNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}*/
					clickOnElement("New Sweep Page", "Next Button", nextButton2);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Details Entered on Funding Account Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Funding Account Screen", "Could not entered details on Funding Account Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
}



