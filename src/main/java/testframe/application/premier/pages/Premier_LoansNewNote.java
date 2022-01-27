package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

/**
 * PageNage : Premier_LoansNewNote
 * 
 * @author shilpa.thangapalam
 */

public class Premier_LoansNewNote extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_LoansNewNote(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}
	String sCollateralRecordNumber;
	By customerPageTitle =  By.xpath("//a[text()='Step 2 - Customer']");
	public By productList =  By.xpath("//select[contains(@name,'ProductNumber')]");
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	By codesPageTitle =  By.xpath("//a[contains(text(),'- Codes')]");
	By noteNumber = By.xpath("//td[contains(text(),'Note Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	By cashProcceds = By.xpath("//td[contains(text(),'Cash Proceeds:')]/following-sibling::td/input[contains(@id,'OrigCashProceeds')]");
	By maximumCredit = By.xpath("(//input[contains(@name,'MaximumCredit')])");
	By maximumCreditCode = By.xpath("(//select[contains(@name,'MaximumCreditCode')])");
	By noteDate = By.xpath("//td[contains(text(),'Note Date:')]/following-sibling::td/input[contains(@id,'OrigNoteDate')]");
	By contractDate = By.xpath("//td[contains(text(),'Contract Date:')]/following-sibling::td/input[contains(@id,'OrigContractDate')]");
	By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	By accountOpenMethodInput = By.xpath("(//input[contains(@name,'AccountOpenMethod')])[1]");
	By accountOpenMethodButton = By.xpath("(//input[contains(@name,'AccountOpenMethod')])[3]");
	By originalCreditScore = By.xpath("//td[contains(text(),'Original Credit Score:')]/following-sibling::td/input[contains(@id,'OrigCreditScore')]");
	By paymentReserveOPtion = By.xpath("(//select[contains(@name,'PymtReserveOption')])");
	By originalPaymentReserve = By.xpath("//td[contains(text(),'Original Payment Reserve:')]/following-sibling::td/input[contains(@id,'OrigPymtReserve')]");
	By internalPaymentOption = By.xpath("(//select[contains(@name,'InternalPymtOption')])");
	By responsibilityCodeInput =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");	
	By nextButton = By.xpath("//button[@value='Next']");
	By paymentPageTitle =  By.xpath("//a[contains(text(),'- Payment')]");
	By interestMethod = By.xpath("(//select[contains(@name,'OrigIntMethod')])");
	By firstPaymentDate = By.xpath("//td[contains(text(),'First Payment Date:')]/following-sibling::td/input[contains(@id,'OrigFirstPaymentDate')]");
	By paymentFrequency = By.xpath("(//select[contains(@name,'OrigPaymentFrequency')])");
	By firstPaymentInterestDate = By.xpath("//td[contains(text(),'First Interest Payment Date:')]/following-sibling::td/input[contains(@id,'OrigFirstIntPymtDate')]");
	By interestPaymentFrequency = By.xpath("(//select[contains(@name,'OrigIntPymtFrequency')])");
	By purposeCodeInput = By.xpath("(//input[contains(@name,'PurposeCode')])[1]");
	By purposeCodeButton = By.xpath("(//input[contains(@name,'PurposeCode')])[3]");
	By paymentCode = By.xpath("(//select[contains(@name,'PaymentCode')])");
	By chargeAccount = By.xpath("//td[contains(text(),'Charge Account:')]/following-sibling::td/input[contains(@id,'ChargeAccount')]");
	By rate = By.xpath("//td[contains(text(),'Rate:')]/following-sibling::td/input[contains(@id,'OrigRateOverSplit')]");
	By rateAdjuster1 = By.xpath("//td[contains(text(),'Rate Adjuster 1:')]/following-sibling::td/input[contains(@id,'RateAdjuster')]");
	By rateAdjuster2 = By.xpath("//td[contains(text(),'Rate Adjuster 2:')]/following-sibling::td/input[contains(@id,'RateAdjuster')]");
	By percentPrimeCode = By.xpath("(//select[contains(@name,'PercentOfPrimeCode')])");
	By totalInterest = By.xpath("//td[contains(text(),'Total Interest:')]/following-sibling::td/input[contains(@id,'OrigTotalInterest')]");
	By insurancePageTitle =  By.xpath("//a[text()='Step 5 - Insurance']");
	By plan1_Textbox =  By.xpath("//td[contains(text(),'Insurance 1:')]/following-sibling::td/input[contains(@id,'InsuranceTable')]");
	By premium1_Textbox =  By.xpath("//td[contains(text(),'Insurance 1:')]/following-sibling::td/input[contains(@id,'Premium')]");
	By lineLifeInsuranceOption =  By.xpath("//td[contains(text(),'Line Life Insurance Option:')]/following-sibling::td/select[contains(@id,'LineLifeInsurCode')]')]");
	By simpleInsuranceBillingDay =  By.xpath("//td[contains(text(),'Simple Insurance Billing Day:')]/following-sibling::td/select[contains(@id,'SimpleInsBillingDay')]");
	By schedulePageTitle =  By.xpath("//a[contains(text(),'- Schedule')]");
	By scheduleStartDate =  By.xpath("(//input[contains(@id,'PymtSchedStartDate')])[1]");
	By scheduleFrequency =  By.xpath("(//select[contains(@id,'PymtSchedFrequency')])[1]");
	By scheduleNumber =  By.xpath("(//input[contains(@id,'NumberOfPayments')])[1]");
	By schedulePIAmount =  By.xpath("(//input[contains(@id,'AmountOfPayment')])[1]");
	By scheduleEscrow =  By.xpath("(//input[contains(@id,'EscrowPayment')])[1]");
	By scheduleRate =  By.xpath("(//input[contains(@id,'PymtSchedRate')])[1]");
	By scheduleSuppressPaymentChangeNotice=  By.xpath("(//input[contains(@id,'AltPymtChgNotifOv')])[1]");
	By scheduleOtherEscrow =  By.xpath("(//input[contains(@id,'OtherEscrowPayment')])[1]");
	By finishButtonLoan = By.xpath("//button[@value='Finish Loan']");
	By finishLoanAddCollateralButton = By.xpath("//button[text()='Finish Loan Add Collateral']");
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warning1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]");
	By warningCheckBox1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]/../..//input");
	By warning2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]");
	By warningCheckBox2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]/../..//input");
	By warning3 = By.xpath("//td/u[contains(text(),'Payment Frequency Does Not Match Product Default (1)')]");
	By warningCheckBox3 = By.xpath("//td/u[contains(text(),'Payment Frequency Does Not Match Product Default (1)')]/../..//input");
	By saveBtn = By.xpath("//*[@title='Save']");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By paymentRestrictionCode =  By.xpath("//select[contains(@id,'/PymtRestrictionCode')]");
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By paymentTab = By.xpath("//li//a[text()='Payment']");
	public By paymentFrequencyInquiryPage =  By.xpath("//td[text()='Payment Frequency:']/following-sibling::td[1]");
	public By paymentRestrictionCodeInquiryPage =  By.xpath("//td[text()='Payment Restriction Code:']/following-sibling::td[1]");
	public By collateralAfterLoanTitle = By.xpath("//label[contains(text(),'Collateral for Loan')]");
	public By buildNewCollateralLink = By.xpath("//a[text()='Build New Collateral']");
	public By finishButtoncollateral = By.xpath("//button[@id='SubmitButton']");
	public By collateralrelationshipPageTitle = By.xpath("//label[contains(text(),'Step 4 - Relationships')]");
	
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	String accountOpenMethodCodeList =  "//select[contains(@name,'AccountOpenMethod')]/option[contains(text(),'%s')]";
	String purposeCodeList =  "//select[contains(@name,'PurposeCode')]/option[contains(text(),'%s')]";
	String loansInquiryHeader = "//td[contains(@id,'%s')]";
	String custLineName = "//u[contains(text(),'%s')]";
	String loanChangeHeader = "//a[contains(text(),'%s')]";
	String loanChangeHeaderInquiry = "//td[contains(text(),'%s')]";

	public void newNoteLoanAcc_CodesScreen(String sNoteAccntNo,String scashProceeds,String sMaximumCredit,String sMaximumCreditCode,
			String sNoteDate,String sContractDate,String sAccountOpenMethod,String sOriginalCreditScore,String sPaymentReserveOption,
			String sOriginalPaymentReserve,String sInternalPaymentOption,String sResponsibilityCode) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(codesPageTitle)) {
					if (!sNoteAccntNo.equals("")) {
						enterText("New Note Codes Page", "Note Number", noteNumber, sNoteAccntNo);
					}	
					if(!scashProceeds.equals("")) {
						enterText("New Note Codes Page", "Cash Proceeds Field", cashProcceds, scashProceeds);
					}				
					if (!sMaximumCredit.equals("")) {
						enterText("New Note Codes Page", "Maximum Credit Field", maximumCredit, sMaximumCredit);
					}
					if (!sMaximumCreditCode.equals("")) {
						selectElementByVisibleText("New Note Codes Page", "Maximum Credit Code Field", maximumCreditCode, sMaximumCreditCode);
					}
					if (!sNoteDate.equals("")) {
						enterText("New Note Codes Page", "Note Date Field", noteDate, sNoteDate);
					}
					if (!sContractDate.equals("")) {
						enterText("New Note Codes Page", "Contract Date Field", contractDate, sContractDate);
					}
					if (!sAccountOpenMethod.equals("")) {
						clickOnElement("New Note Codes Page", "Account openMethod Text Box",accountOpenMethodInput);
						Thread.sleep(1000);
						clickOnElement("New Note Codes Page", "Account openMethod Button",accountOpenMethodButton);
						Thread.sleep(1000);
						clickOnElement("New Note Codes Page", "AccountOpenMethod Code list",getDynamicElement("AccountOpenMethod Code list",accountOpenMethodCodeList,sAccountOpenMethod));
					}
					if (!sOriginalCreditScore.equals("")) {
						enterText("New Note Codes Page", "Original CreditScore Field", originalCreditScore, sOriginalCreditScore);
					}
					if (!sPaymentReserveOption.equals("")) {
						selectElementByVisibleText("New Line Codes Page", "Maximum Credit Code", paymentReserveOPtion, sPaymentReserveOption);
					}
					if (!sOriginalPaymentReserve.equals("")) {
						enterText("New Note Codes Page", "Original PaymentReserve Field", originalPaymentReserve, sOriginalPaymentReserve);
					}
					if (!sInternalPaymentOption.equals("")) {
						selectElementByVisibleText("New Line Codes Page", "Internal Payment option", internalPaymentOption, sInternalPaymentOption);
					}
					if (!sResponsibilityCode.equals("")) {
						clickOnElement("New Line Codes Page", "Responsibility Text Box",responsibilityCodeInput);
						Thread.sleep(1000);
						clickOnElement("New Line Codes Page", "Responsibility Code Button",responsibilityCodeButton);
						Thread.sleep(1000);
						clickOnElement("New Line Codes Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
					}
					clickOnElement("New Line Page", "Next Button", nextButton);
					waitElement(2000);
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


	public void newNoteLoan_PaymentScreen(String sinterestMethod,String sFirstPaymentDate,String sPaymentFrequency,String sFirstInterestPaymentDate,
			String sInterestPaymentFrequency,String sPurposeCode,String sPaymentCode,String sChargeAccount,String sRate,String sRateAdjuster1,
			String sRateAdjuster2,String sPercentOfPrimeCode,String sTotalInterest) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(paymentPageTitle)) {
					if (!sinterestMethod.equals("")) {
						selectElementByVisibleText("New Note Payment Page", "Interest Method option", interestMethod, sinterestMethod);
					}
					if (!sFirstPaymentDate.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", firstPaymentDate, sFirstPaymentDate);
					}
					if (!sPaymentFrequency.equals("")) {
						selectElementByVisibleText("New Note Payment Page", "Interest Method option", paymentFrequency, sPaymentFrequency);
					}
					if (!sFirstInterestPaymentDate.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", firstPaymentInterestDate, sFirstInterestPaymentDate);
					}
					if (!sInterestPaymentFrequency.equals("")) {
						selectElementByVisibleText("New Note Payment Page", "Interest Method option", interestPaymentFrequency, sInterestPaymentFrequency);
					}
					if (!sPurposeCode.equals("")) {
						//clickOnElement("New Note Payment Page", "Purpose TextBox",purposeCodeInput);
						Thread.sleep(1000);
						clickOnElement("New Note Payment Page", "Purpose Code Button",purposeCodeButton);
						Thread.sleep(1000);
						clickOnElement("New Note Payment Page", "Purpose Code list",getDynamicElement("Purpose Code list",purposeCodeList,sPurposeCode));
					}
					if (!sPaymentCode.equals("")) {
						selectElementByVisibleText("New Note Payment Page", "Interest Method option", paymentCode, sPaymentCode);
					}
					if (!sChargeAccount.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", chargeAccount, sChargeAccount);
					}
					waitElement(1000);
					if (!sRate.equals("")) {
						enterText("New Note Payment Page", "Rate Field", rate, sRate);
					}
					if (!sRateAdjuster1.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", rateAdjuster1, sRateAdjuster1);
					}
					if (!sRateAdjuster2.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", rateAdjuster2, sRateAdjuster2);
					}
					if (!sPercentOfPrimeCode.equals("")) {
						selectElementByVisibleText("New Note Payment Page", "Interest Method option", percentPrimeCode, sPercentOfPrimeCode);
					}
					if (!sTotalInterest.equals("")) {
						enterText("New Note Payment Page", "Original PaymentReserve Field", totalInterest, sTotalInterest);
					}
					clickOnElement("New Line Page", "Next Button", nextButton);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Payment Screen", "Details Entered on Payment Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Payment Screen", "Could not entered details on Payment Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void newNoteLoan_InsuranceScreen(String sPlan, String sPremium,String slineLifeInsuranceOption,String sSimpleInsuranceBillingDay) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(insurancePageTitle)) {
					if (!sPlan.equals("")) {
						enterText("New Note Insurance Page", "Insurance Plan Field", plan1_Textbox, sPlan);
					}
					if (!sPremium.equals("")) {
						enterText("New Note Insurance Page", "Insurance Premium Field", premium1_Textbox, sPremium);
					}
					if (!slineLifeInsuranceOption.equals("")) {
						selectElementByVisibleText("New Note Insurance Page", "line Life Insurance Option Field", lineLifeInsuranceOption, slineLifeInsuranceOption);
					}
					if (!sSimpleInsuranceBillingDay.equals("")) {
						selectElementByVisibleText("New Note Insurance Page", "Simple Insurance Billing Day Field", simpleInsuranceBillingDay, sSimpleInsuranceBillingDay);
					}
					clickOnElement("New Loan Page", "Next Button", nextButton);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Insurance Screen", "Details Entered on Insurance Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Insurance Screen", "Could not entered details on Insurance Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void newNoteLoan_ScheduleScreen(String sStartDate, String sFrequency,String sNumber,String sPIAmount,String sEscrow, String sRate,String sSuppressPaymentChangeNotice,String sOtherEscrow) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(schedulePageTitle)) {
					if (!sStartDate.equals("")) {
						enterText("New Note Schedule Page", "Start Date Field", scheduleStartDate, sStartDate);
					}
					if (!sFrequency.equals("")) {
						selectElementByVisibleText("New Note Schedule Page", "Frequency Field", scheduleFrequency, sFrequency);
					}
					if (!sNumber.equals("")) {
						clearText("New Note Schedule Page", "Number Field", scheduleNumber);
						enterText("New Note Schedule Page", "Number Field", scheduleNumber, sNumber);
					}
					if (!sPIAmount.equals("")) {
						enterText("New Note Schedule Page", "PIAmount Field", schedulePIAmount, sPIAmount);
					}
					if (!sEscrow.equals("")) {
						enterText("New Note Schedule Page", "Escrow Field", scheduleEscrow, sEscrow);
					}
					if (!sRate.equals("")) {
						enterText("New Note Schedule Page", "Rate Field", scheduleRate, sRate);
					}
					if (sSuppressPaymentChangeNotice.equals("Yes")) {
						clickOnElement("New Note Schedule Page", "Suppress Payment Change Notice Field", scheduleSuppressPaymentChangeNotice);
					}
					if (!sOtherEscrow.equals("")) {
						enterText("New Note Schedule Page", "Other Escrow Field", scheduleOtherEscrow, sOtherEscrow);
					}
					//clickOnElement("New Loan Page", "Next Button", nextButton);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Schedule Screen", "Details Entered on Schedule Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Schedule Screen", "Could not entered details on Schedule Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void loanFinishButton() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("New Loan Page", "Finish Button", finishButtonLoan);
				Thread.sleep(5000);
				if(isElementPresent(warningHeader)) {
					if (isElementPresent(warning2)) {
						clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
					}
					if (isElementPresentZeroWait(warning1)) {
						clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
					}					
					if (isElementPresentZeroWait(warning3)) {
						clickOnElement("New Loan Page", "Warning 3 Checkbox", warningCheckBox3);
					}
					clickOnElement("New Loan Page", "Save Button", saveBtn);
					waitElement(2000);
				}
				validateElementPresent("New Loan Page", "Search Title", searchTitle2);
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
					System.setProperty("runStep","N");
				}	
			}
		}
	}

	public void validateDetailsInLoansInquiry(String sNoteNumber,String sLineName) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if(isElementPresent(getDynamicElement("Note Number Header field", loansInquiryHeader, sNoteNumber))){ 				
				validateTextContains("Loan Inquiry" , "Name Field", getDynamicElement("Name Field",custLineName,sLineName), sLineName);
				switchToDefaultContent();
				switchToWithinFrameWithName("Main");
				stepResult = true;
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Validated Line Details on Loan Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Could not Validated Loan Details on Line Inquiry page" , "Failed", driver, "Y");
			}
		}
	}

	public void finishLoanAddCollateralButton() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("New Loan Page", "Finish Loan Add Collateral Button", finishLoanAddCollateralButton);
				Thread.sleep(5000);
				if(isElementPresent(warningHeader)) {
					if (isElementPresent(warning2)) {
						clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
					}
					if (isElementPresentZeroWait(warning1)) {
						clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
					}
					if (isElementPresentZeroWait(warning3)) {
						clickOnElement("New Loan Page", "Warning 3 Checkbox", warningCheckBox3);
					}
					clickOnElement("New Loan Page", "Save Button", saveBtn);
					waitElement(8000);
				}
				validateElementPresent("New Collateral Page", "Collateral Title",collateralAfterLoanTitle);
				clickOnElement("New Collateral Page", "Build New Collateral", buildNewCollateralLink);
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
					System.setProperty("runStep","N");
				}	
			}
		}
	}
	
	public void finishCollateralwithLoan(String excelFilePath, String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			sCollateralRecordNumber=getElementText("New Collateral Page", "Collateral No",  collateralrelationshipPageTitle);
			
			String[] temp = sCollateralRecordNumber.split("Step 4 - Relationships - Collateral Record ");
			sCollateralRecordNumber = temp[1];
			temp = sCollateralRecordNumber.split(" For Loan");
			sCollateralRecordNumber = temp[0];
			if(sCollateralRecordNumber != "")
				new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "Collateral_RecordNumber", rowNo, sCollateralRecordNumber);							
			clickOnElement("New Collateral Page", "Finish Button", finishButtoncollateral);
			Thread.sleep(5000);
			validateElementPresent("New Collateral Page", "collateral Definition", collateralAfterLoanTitle);
			clickOnElement("Change Loan Page", "Save Button", saveButton);
			waitElement(4000);
			validateElementPresent("New Loan Page", "Search Title", searchTitle2);
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
				System.setProperty("runStep","N");
			}	
		}
	}
 }
	
}



