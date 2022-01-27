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
 * @author Onkar.Narlawar
 */

public class Premier_MasterAgreement extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_MasterAgreement(WebDriver driver) {
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
	By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
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
	By paymentPageTitle =  By.xpath("//a[text()='Step 4 - Payment']");
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
	By insurancePageTitle =  By.xpath("//a[contains(text(),'- Insurance')]");
	By plan1_Textbox =  By.xpath("//td[contains(text(),'Insurance 1:')]/following-sibling::td/input[contains(@id,'InsuranceTable')]");
	By premium1_Textbox =  By.xpath("//td[contains(text(),'Insurance 1:')]/following-sibling::td/input[contains(@id,'Premium')]");
	By lineLifeInsuranceOption =  By.xpath("//td[contains(text(),'Line Life Insurance Option:')]/following-sibling::td/select[contains(@id,'LineLifeInsurCode')]')]");
	By simpleInsuranceBillingDay =  By.xpath("//td[contains(text(),'Simple Insurance Billing Day:')]/following-sibling::td/select[contains(@id,'SimpleInsBillingDay')]");
	By schedulePageTitle =  By.xpath("//a[text()='Step 6 - Schedule']");
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
	public By si1_startDateInput = By.xpath("//input[contains(@id,'SimpleIns1BillToDate')]");
	public By si1_MethodList = By.xpath("//select[contains(@id,'SimpleIns1Method')]");
	public By si1_RateInput = By.xpath("//input[contains(@id,'SimpleIns1Rate1')]");
	public By si1_AmountInput = By.xpath("//input[contains(@id,'SimpleIns1Rate2')]");
	public By si1CodeInput =  By.xpath("(//input[contains(@name,'SimpleIns1Code')])[1]");
	public By si1_CompanyInput = By.xpath("//input[contains(@id,'SimpleIns1Company')]");
	public By si1CodeButton =  By.xpath("(//input[contains(@name,'SimpleIns1Code')])[3]");
	public By unUsedCreditTitle =  By.xpath("//a[contains(text(),'- Unused Credit')]");
	public By agreementNumberInput =  By.xpath("//td[text()='Agreement Number:']/../td/input");
	By submitSearch = By.xpath("//button[text()='Submit']");
	
	String si1CodeList =  "//select[contains(@name,'SimpleIns1Code')]/option[contains(text(),'%s')]";
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	String accountOpenMethodCodeList =  "//select[contains(@name,'AccountOpenMethod')]/option[contains(text(),'%s')]";
	String purposeCodeList =  "//select[contains(@name,'PurposeCode')]/option[contains(text(),'%s')]";
	String loansInquiryHeader = "//td[contains(@id,'%s')]";
	String custLineName = "//u[contains(text(),'%s')]";
	String loanChangeHeader = "//a[contains(text(),'%s')]";
	String loanChangeHeaderInquiry = "//td[contains(text(),'%s')]";
	String masterAgreementInquiryHeader = "//td[contains(@id,'%s')]";
	String masterAgreementcustLineName = "(//u[contains(text(),'%s')])[1]";
	String letterOfcreditInquiry = "//td[text()='Letter Of Credit']/../td/u[contains(text(),'%s')]";
	String lineOfcreditInquiry = "//td[text()='Line Of Credit']/../td/u[contains(text(),'%s')]";
	String masterAgreementInquiry = "//td[text()='Master Agreement']/../td/u[contains(text(),'%s')]";
	String masterCommitmentInquiry = "//td[text()='Master Commitment']/../td/u[contains(text(),'%s')]";
	String subLoanInquiry = "//td[contains(text(),'Sub Loan')]/../td/u[contains(text(),'%s')]";
	String masterMortgageInquiry = "//td[text()='Master Mortgage']/../td/u[contains(text(),'%s')]";
	
	public void newAgreement_InsuranceScreen(String sPlan, String sPremium,String slineLifeInsuranceOption,String sSimpleInsuranceBillingDay,String si1_StartDate,String si1_Code,String si1_Company,String si1_Method,String si1_Rate,String si1_Amount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(insurancePageTitle)) {
					if (!sPlan.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance Plan Field", plan1_Textbox, sPlan);
					}
					if (!sPremium.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance Premium Field", premium1_Textbox, sPremium);
					}
					if (!slineLifeInsuranceOption.equals("")) {
						selectElementByVisibleText("New Agreement Insurance Page", "line Life Insurance Option Field", lineLifeInsuranceOption, slineLifeInsuranceOption);
					}
					if (!sSimpleInsuranceBillingDay.equals("")) {
						selectElementByVisibleText("New Agreement Insurance Page", "Simple Insurance Billing Day Field", simpleInsuranceBillingDay, sSimpleInsuranceBillingDay);
					}
					if (!si1_StartDate.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance si1_StartDate Field", si1_startDateInput, si1_StartDate);
					}
					if (!si1_Code.equals("")) {
						Thread.sleep(1000);
						clickOnElement("New Agreement Insurance Page", "SI1 Code Button",si1CodeButton);
						Thread.sleep(1000);
						clickOnElement("New Agreement Insurance Page", "SI1 Code list",getDynamicElement("SI1 Code list",si1CodeList,si1_Code));	
					}
					if (!si1_Company.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance si1_Company Field",si1_CompanyInput , si1_Company);
					}
					if (!si1_Method.equals("")) {
						selectElementByVisibleText("New Agreement Insurance Page", "Insurance si1_Method Field", si1_MethodList, si1_Method);
					}
					if (!si1_Rate.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance si1_Rate Field",si1_RateInput , si1_Rate);
					}
					if (!si1_Amount.equals("")) {
						enterText("New Agreement Insurance Page", "Insurance si1_Amount Field", si1_AmountInput, si1_Amount);
					}
					clickOnElement("New Agreement Page", "Next Button", nextButton);
					waitElement(1500);
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
	
	public void unUsedCreditScreen() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(isElementPresent(unUsedCreditTitle)) {
					
					clickOnElement("New Unused Credit Page", "Next Button", nextButton);
					waitElement(2000);
					stepResult = true;
				}					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Unused Credit Screen", "Details Entered on Unused Credit Screen Successfully", "Passed",driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Unused Credit Screen", "Could not entered details on Unused Credit Screen", "Failed",driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void searchAgreement(String agreementNo) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitElement(6000);
				driver.switchTo().frame("Main");
				if (isElementPresent(searchTitle2)) {
					clickOnElement("Search Agreement Page", "Agreement Number", agreementNumberInput);
					enterText("Search Agreement Page", "Agreement Number", agreementNumberInput, agreementNo);
					clickOnElement("Search Agreement Page", "Submit", submitSearch);
					stepResult = true;
				}	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Agreement", "Search Agreement on Agreement page Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Agreement", "Could not Search Agreement on Agreement page Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void validateDetailsInMasterAgreementInquiry(String agreementNo,String sMasterAgreementType,String sMasterAgreementTypeNo) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if(isElementPresent(getDynamicElement("Agreement Number Header field", masterAgreementInquiryHeader, agreementNo))){
				clickOnElement("Agreement Inquiry Page", "Agreement Number Header field", getDynamicElement("Agreement Number Header field", masterAgreementInquiryHeader, agreementNo));
				//validateTextContains("Agreement Inquiry" , "Name Field", getDynamicElement("Name Field",masterAgreementcustLineName,sLineName), sLineName);
				if (sMasterAgreementType.contains("Master Agreement")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",masterAgreementInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				if (sMasterAgreementType.contains("Master Commitment")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",masterCommitmentInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				if (sMasterAgreementType.contains("Line Of Credit")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",lineOfcreditInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				if (sMasterAgreementType.contains("Letter Of Credit")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",letterOfcreditInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				if (sMasterAgreementType.contains("Sub Loan")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",subLoanInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				if (sMasterAgreementType.contains("Master Mortgage")) {
					validateTextContains("Agreement Inquiry" , "Master Agreement Type Number", getDynamicElement("Master Agreement Type Number",masterMortgageInquiry,sMasterAgreementTypeNo), sMasterAgreementTypeNo);
				}
				switchToDefaultContent();
				switchToWithinFrameWithName("Main");
				stepResult = true;
			}				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Agreement Details Validation", "Validated Agreement Details on Agreement Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Agreement Details Validation", "Could not Validated Agreement Details on Inquiry page" , "Failed", driver, "Y");
			}
		}
	}
}



