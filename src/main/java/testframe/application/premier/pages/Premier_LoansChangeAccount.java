package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.DateTimeHelper;

/**
 * PageNage : Premier_LoansNewNote
 * 
 * @author Onkar.Narlawar
 */

public class Premier_LoansChangeAccount extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_LoansChangeAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}
	String tempVar;
	By customerPageTitle =  By.xpath("//a[text()='Step 2 - Customer']");
	public By productList =  By.xpath("//select[contains(@name,'ProductNumber')]");
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By finishButton = By.xpath("//button[@value='Finish']");
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
	By insurancePageTitle =  By.xpath("//a[text()='Step 5 - Insurance']");
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
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warning1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]");
	By warningCheckBox1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]/../..//input");
	By warning2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]");
	By warningCheckBox2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]/../..//input");
	By warning3 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]");
	By warningCheckBox3 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]/../..//input");
	By warning4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]");
	By warningCheckBox4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]/../..//input");
	By saveBtn = By.xpath("//*[@title='Save']");

	public By classCodeInput =  By.xpath("(//input[contains(@name,'ClassCode')])[1]");
	public By classCodeButton =  By.xpath("(//input[contains(@name,'ClassCode')])[3]");
	String classCodeList =  "//select[contains(@name,'ClassCode')]/option[contains(text(),'%s')]";
	public By branchRegionTextbox =  By.xpath("(//input[contains(@id,'BranchNumber')])[1]");
	public By branchRegionButton =  By.xpath("(//input[contains(@id,'BranchNumber')])[3]");
	String branchRegionList =  "//select[contains(@id,'BranchNumber')]/option[contains(text(),'%s')]";
	public By accountingMethodList =  By.xpath("//select[contains(@id,'AccountingMethod')]");
	public By warningTextbox =  By.xpath("//td[contains(text(),'Warning:')]/following-sibling::td/input[contains(@name,'Warning')]");
	public By statusCodeButton =  By.xpath("(//input[contains(@name,'StatusCode')])[3]");
	String statusCodeList =  "//select[contains(@name,'StatusCode')]/option[contains(text(),'%s')]";
	public By writeDownStatusList =  By.xpath("//select[contains(@id,'WriteDownStatus')]");
	public By loanRatingCode1Button =  By.xpath("(//input[contains(@name,'LoanRatingCode1')])[3]");
	String loanRatingCode1List =  "//select[contains(@name,'LoanRatingCode1')]/option[contains(text(),'%s')]";	
	public By paymentRestrictionCode =  By.xpath("//select[contains(@id,'/PymtRestrictionCode')]");
	public By paymentRestrictionOverride =  By.xpath("//select[contains(@id,'/PymtRestrictionOverride')]");
	public By bankruptcyChapter =  By.xpath("//select[contains(@id,'/BankruptcyChapter')]");
	public By bankruptcyStatus =  By.xpath("//select[contains(@id,'/BankruptcyStatus')]");
	public By bankruptcyPetitionDate =  By.xpath("//input[contains(@id,'/BankruptcyPetitionDate')]");
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By paymentTab = By.xpath("//li//a[text()='Payment']");
	public By interestFeesTab = By.xpath("//li//a[text()='Interest/Fees']");
	public By relationshipTab = By.xpath("//li//a[text()='Relationships']");
	public By balancesTab = By.xpath("//li//a[text()='Balances']");
	public By collateralUnderBalancesTab = By.xpath("//li//a[text()='Balances']/following-sibling::div//a[text()='Collateral']");
	public By paymentFrequencyInquiryPage =  By.xpath("//td[text()='Payment Frequency:']/following-sibling::td[1]");
	public By paymentRestrictionCodeInquiryPage =  By.xpath("//td[text()='Payment Restriction Code:']/following-sibling::td[1]");
	public By paymentRestrictionCodeOverrideInquiryPage =  By.xpath("//td[text()='Payment Restriction Code Override:']/following-sibling::td[1]");	
	public By classInquiryPage =  By.xpath("//td[text()='Class:']/following-sibling::td[1]");
	public By branchRegionInquiryPage =  By.xpath("//td[text()='Branch Region:']/following-sibling::td[1]");
	public By accountingMethodInquiryPage =  By.xpath("//td[text()='Accounting Method:']/following-sibling::td[1]");
	public By statusInquiryPage =  By.xpath("//td[text()='Status:']/following-sibling::td[1]");
	public By writeDownStatusInquiryPage =  By.xpath("//td[text()='Write Down Status:']/following-sibling::td[1]");
	public By loanRatingCode1InquiryPage =  By.xpath("//td[text()='Loan Rating Code 1:']/following-sibling::td[1]");
	public By bankruptcyChapterInquiryPage =  By.xpath("//td[text()='Bankruptcy Chapter:']/following-sibling::td[1]");
	public By bankruptcyStatusInquiryPage =  By.xpath("//td[text()='Bankruptcy Status:']/following-sibling::td[1]");
	public By bankruptcyPetitionFileDateInquiryPage =  By.xpath("//td[text()='Bankruptcy Petition File Date:']/following-sibling::td[1]");
	public By expandWarningInquiryPage =  By.xpath("//img[@id='WarningsArrow']");
	public By warningInquiryPage =  By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	public By searchIconName =  By.xpath("(//img[@title='Search'])[1]");
	public By nonAccrualHeader = By.xpath("//a[text()='Non-Accrual']");
	public By paymentsSummaryHeader = By.xpath("//a[text()='Payment Summary']");
	public By nonAccrualCodeList = By.xpath("//select[contains(@id,'NonAccrualCode')]");
	public By nonAccrualLateChargeOptionList = By.xpath("//select[contains(@id,'NonAccrualLateChrgOpt')]");
	public By automaticRecoveryOverrideList = By.xpath("//select[contains(@id,'AutoRecoveryOv')]");
	public By nonAccrualDateInput = By.xpath("(//input[contains(@id,'NonAccrualDate')])[1]");
	public By nonAccrualCodeInquiryPage = By.xpath("//td[text()='Non-Accrual Code:']/following-sibling::td[1]");
	public By nonAccrualLateChargeOptionInquiryPage = By.xpath("//td[text()='Non-Accrual Late Charge Option:']/following-sibling::td[1]");
	public By automaticRecoveryOverrideInquiryPage = By.xpath("//td[text()='Automatic Recovery Override:']/following-sibling::td[1]");
	public By nonAccrualDateInquiryPage = By.xpath("//td[text()='Date Non-Accrual:']/following-sibling::td[1]");
	public By collateralBoxHeader =By.xpath("//td/a[text()='Collateral']");
	public By SearchIConCollateral = By.xpath("//img[@title='Search For Collateral']");
	public By collateralSearch = By.xpath("//label[contains(text(),'Collateral Record Number:')]/../following-sibling::td/input");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By collateralRecordNoInquiryPage = By.xpath("//table[@name='Collateral to Loan Pledge Summary']//td/u");
	public By automaticPaymentOptionList = By.xpath("//select[contains(@id,'AutoPymtOption')]");
	public By paymentCodeList = By.xpath("//select[contains(@id,'PaymentCode')]");
	public By automaticDraftAmountInput = By.xpath("//input[contains(@id,'AutoDraftAmount')]");
	public By chargeAccountInput = By.xpath("//input[contains(@id,'ChargeAccount')]");
	public By automaticDraftPaymentOptionList = By.xpath("//select[contains(@id,'AutoDraftAmountOption')]");
	public By autoDraftPaymentDateInput = By.xpath("//input[contains(@id,'AutoPymtDraftDate')]");
	public By automaticPaymentOptionInquiryPage =  By.xpath("//td[text()='Automatic Payment Option:']/following-sibling::td[1]");
	public By paymentCodeInquiryPage =  By.xpath("//td[text()='Payment Code:']/following-sibling::td[1]");
	public By automaticDraftPaymentOptionInquiryPage =  By.xpath("//td[text()='Automatic Draft Payment Option:']/following-sibling::td[1]");
	public By loanRateIndexInquiryPage =  By.xpath("//td[text()='Loan Rate Index:']/following-sibling::td[1]");
	
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	String accountOpenMethodCodeList =  "//select[contains(@name,'AccountOpenMethod')]/option[contains(text(),'%s')]";
	String purposeCodeList =  "//select[contains(@name,'PurposeCode')]/option[contains(text(),'%s')]";
	String loansInquiryHeader = "//td[contains(@id,'%s')]";
	String custLineName = "//u[contains(text(),'%s')]";
	String loanChangeHeader = "//a[contains(text(),'%s')]";
	String loanChangeHeaderInquiry = "//td[contains(text(),'%s')]";
	String relationshipAddName = "//*[text()='%s']/../../following-sibling::td/select[contains(@id,'RelationshipCode')]";
	String newName = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'RelatedToIdTMP')])[%s]";
	String newEstatement = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'EmailAddrIndicator1')])[%s]";
	String newNameInquiryPage = "//table[@name='Relationships']//u[text()='%s']";
	String updateName = "//b[text()='Name']/../../..//*[text()='%s']";
	String newNameRelationshipInquiryPage = "//table[@name='Relationships']//u[text()='%s']/../../td[10]";
	String removeNameIcon = "//*[text()='%s']/../../following-sibling::td/img[contains(@title,'Delete')]";
	String searchAccountLink = "//td/a[contains(text(),'%s')]";
	public By changeProductImg = By.xpath("//td[contains(text(),'Product:')]/../td/img");
	public By selectProductTitle = By.xpath("//a[text()='Step 1 - Select Product']");
	public By reviewDefaultsTitle = By.xpath("//a[text()='Step 2 - Review Defaults']");
	public By classCheckbox = By.xpath("//input[contains(@id,'ClassCode')]");
	public By checkAllLink = By.xpath("//td/u[text()='Check All']");	
	String changeProductField = "//td/u[text()='%s']";
	public By changePortfolioImg = By.xpath("//td[contains(text(),'Portfolio:')]/../td/img");
	public By changeLineImg = By.xpath("//td[contains(text(),'Line Number:')]/../td/img");
	public By changePortfolioTitle = By.xpath("//td[text()='Change Portfolio']");
	public By changeLineTitle = By.xpath("//td[text()='Change Line']");
	public By lineNoInput = By.xpath("//td[text()='Line Number:']/../td/input");
	public By productInquiryPage = By.xpath("//td[contains(text(),'Product:')]/following-sibling::td[1]");
	public By lineInquiryPage = By.xpath("//td[contains(text(),'Line:')]/following-sibling::td[1]");
	public By loanRateIndexInput =  By.xpath("(//input[contains(@name,'RateIndex')])[1]");
	public By loanRateIndexButton =  By.xpath("(//input[contains(@name,'RateIndex')])[3]");
	String loanRateIndexList =  "//select[contains(@name,'RateIndex')]/option[contains(text(),'%s')]";
	
	public void changeLoanAccountDetails(String sAccountNumber,String sClass, String sBranchRegion, String sAccountingMethod, String sWarning, String sPaymentFrequency, String sStatusCode, String sWriteDownStatus, String sLoanRatingCode1, String sPaymentRestrictionCode, String sPaymentRestrictionCodeOverride, String sBankruptcyChapter, String sBankruptcyStatus, String sBankruptcyPetitionFileDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeader,sAccountNumber))){

					if (!sClass.equals("")) {
						clickOnElement("Change Account Page", "Class Field",classCodeInput);	
						waitElement(1000);
						clickOnElement("Change Account Page", "Class Field",classCodeButton);
						waitElement(1000);
						clickOnElement("Change Account Page", "Class Field", getDynamicElement("Class Field",classCodeList,sClass));
					}
					if (!sBranchRegion.equals("")) {
						clickOnElement("Change Account Page", "Branch Region Input Field",branchRegionTextbox);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Branch Region Button",branchRegionButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Branch Region list",getDynamicElement("Branch Region list",branchRegionList,sBranchRegion));
					}
					if (!sAccountingMethod.equals("")) {
						selectElementByVisibleText("Change Account Page", "Accounting Method List", accountingMethodList, sAccountingMethod);
					}
					if (!sWarning.equals("")) {
						enterText("Change Account Page", "Warning field", warningTextbox, sWarning);
					}
					if (!sPaymentFrequency.equals("")) {
						selectElementByVisibleText("Change Account Page", "Payment Frequency", paymentFrequency, sPaymentFrequency);
					}
					if (!sStatusCode.equals("")) {
						clickOnElement("Change Account Page", "Status Code Field",statusCodeButton);
						waitElement(1000);
						clickOnElement("Change Account Page", "Status Code Field", getDynamicElement("Status Code Field",statusCodeList,sStatusCode));
					}
					if (!sWriteDownStatus.equals("")) {
						selectElementByVisibleText("Change Account Page", "Write Down Status Field", writeDownStatusList, sWriteDownStatus);
					}
					if (!sLoanRatingCode1.equals("")) {
						clickOnElement("Change Account Page", "loan Rating Code 1 List Field",loanRatingCode1Button);
						waitElement(1000);
						clickOnElement("Change Account Page", "loan Rating Code 1 List Field", getDynamicElement("loan Rating Code 1 List Field",loanRatingCode1List,sLoanRatingCode1));
					}
					if (!sPaymentRestrictionCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "Payment Restriction Code", paymentRestrictionCode, sPaymentRestrictionCode);
					}
					if (!sPaymentRestrictionCodeOverride.equals("")) {
						selectElementByVisibleText("Change Account Page", "Payment Restriction Override field", paymentRestrictionOverride, sPaymentRestrictionCodeOverride);
					}
					if (!sBankruptcyChapter.equals("")) {
						selectElementByVisibleText("Change Account Page", "Bankruptcy Chapter field", bankruptcyChapter, sBankruptcyChapter);
					}
					if (!sBankruptcyStatus.equals("")) {
						selectElementByVisibleText("Change Account Page", "bankruptcy Status field", bankruptcyStatus, sBankruptcyStatus);
					}
					if (!sBankruptcyPetitionFileDate.equals("")) {
						enterText("Change Account Page", "bankruptcy Petition Date field", bankruptcyPetitionDate, sBankruptcyPetitionFileDate);
					}/*
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(5000);
					if(isElementPresent(warningHeader)) {
						if (isElementPresent(warning1)) {
							clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
						}
						if (isElementPresent(warning2)) {
							clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
						}
						if (isElementPresent(warning3)) {
							clickOnElement("New Loan Page", "Warning 3 Checkbox", warningCheckBox3);
						}
						clickOnElement("New Loan Page", "Save Button", saveBtn);
						waitElement(2000);
					}
					validateElementPresent("New Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");*/
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateLoanAccountDetailsAfterChange(String sAccountNumber,String sClass, String sBranchRegion, String sAccountingMethod, String sWarning, String sPaymentFrequency, String sStatusCode, String sWriteDownStatus, String sLoanRatingCode1, String sPaymentRestrictionCode, String sPaymentRestrictionCodeOverride, String sBankruptcyChapter, String sBankruptcyStatus, String sBankruptcyPetitionFileDate) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(5000);
			clickOnElement("Account Inquiry Page", "Payment Tab Field",paymentTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeaderInquiry,sAccountNumber))){
				if (!sPaymentFrequency.equals("")) {
					validateTextContains("Account Inquiry" , "Payment Frequency", paymentFrequencyInquiryPage, sPaymentFrequency);
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				waitElement(2000);
				clickOnElement("Account Inquiry Page", "Codes Tab Field",codesTab);	
				switchToWithinFrameWithName("bottom");
				if (!sClass.equals("")) {
					sClass = ((sClass.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry" , "class Code",classInquiryPage, sClass);
				}
				if (!sBranchRegion.equals("")) {
					sBranchRegion = ((sBranchRegion.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry" , "Branch Region Code",branchRegionInquiryPage, sBranchRegion);
				}
				if (!sAccountingMethod.equals("")) {
					validateTextContains("Account Inquiry" , "Accounting Method Code",accountingMethodInquiryPage, sAccountingMethod);
				}
				if (!sPaymentRestrictionCode.equals("")) {
					validateTextContains("Account Inquiry" , "Payment Restriction Code",paymentRestrictionCodeInquiryPage, sPaymentRestrictionCode);
				}				
				if (!sStatusCode.equals("")) {
					sStatusCode = ((sStatusCode.split("\\["))[0]).trim();
					validateTextContains_UCASE("Account Inquiry" , "Status field",statusInquiryPage, sStatusCode);
				}
				if (!sWriteDownStatus.equals("")) {
					validateTextContains("Account Inquiry" , "Write Down Status field",writeDownStatusInquiryPage, sWriteDownStatus);
				}
				if (!sLoanRatingCode1.equals("")) {
					sLoanRatingCode1 = ((sLoanRatingCode1.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry" , "Write Down Status field",loanRatingCode1InquiryPage, sLoanRatingCode1);
				}
				if (!sBankruptcyChapter.equals("")) {
					validateTextContains("Account Inquiry" , "Bankruptcy Chapter field",bankruptcyChapterInquiryPage, sBankruptcyChapter);
				}
				if (!sBankruptcyStatus.equals("")) {
					validateTextContains("Account Inquiry" , "Bankruptcy Status field",bankruptcyStatusInquiryPage, sBankruptcyStatus);
				}				
				if (!sBankruptcyPetitionFileDate.equals("")) {
					sBankruptcyPetitionFileDate = new DateTimeHelper().getDateTime(sBankruptcyPetitionFileDate,"MM/dd/yyyy","MMM dd, yyyy");
					validateTextContains("Account Inquiry" , "Bankruptcy Petition File Date",bankruptcyPetitionFileDateInquiryPage, sBankruptcyPetitionFileDate);
				}
				if (!sWarning.equals("")) {
					waitElement(2000);
					clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field",expandWarningInquiryPage);
					waitElement(1000);
					validateTextContains("Account Inquiry" , "Warning field",warningInquiryPage, sWarning);
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
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Validated Loan Details on Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Could not Validated Loan Details on Inquiry page" , "Failed", driver, "Y");
			}
		}}

	public void changeAccountDetails_AddRelationship(String sAccountNumber,String sName, String sSN, String sRelationship, String sEStatement) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field",relationshipTab);
				waitElement(2000);
				if (isElementPresent(searchIconName)){
					clickOnElement("Change Account Page", "Search Icon",searchIconName);
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");

					if (!sRelationship.equals("")) {
						selectElementByVisibleText("Change Account Page", "Relationship Field", getDynamicElement("Relationship list",relationshipAddName,sName), sRelationship);
						waitElement(2000);
					}
					if (!sName.equals("")) {
						tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field", getDynamicElement("Relationship list",newName,Integer.toString(2)));
						if (tempVar.equals("(None)")) {
							selectElementByVisibleText("Change Account Page", "Account info Name Field", getDynamicElement("Account info Name Field",newName,Integer.toString(2)), sName);
							waitElement(1000);
							selectElementByVisibleText("Change Account Page", "Mailing info Name Field", getDynamicElement("Mailing info Name Field",newName,Integer.toString(5)), sName);
							waitElement(1000);
							if (!sEStatement.equals("")) {
								selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field", getDynamicElement("Mailing info E Statement Field",newEstatement,Integer.toString(2)), sEStatement);
							}
						}else {
							selectElementByVisibleText("Change Account Page", "Account info Name Field", getDynamicElement("Account info Name Field",newName,Integer.toString(3)), sName);
							waitElement(1000);
							selectElementByVisibleText("Change Account Page", "Mailing info Name Field", getDynamicElement("Mailing info Name Field",newName,Integer.toString(6)), sName);
							waitElement(1000);
							if (!sEStatement.equals("")) {
								selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field", getDynamicElement("Mailing info E Statement Field",newEstatement,Integer.toString(3)), sEStatement);
							}
						}
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
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
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;

				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add Relationship Details", "Relationship added Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add Relationship Details", "Could not add Relationship Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_AddRelationship(String sAccountNumber,String sName, String sSN, String sRelationship, String sEStatement) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);	
			switchToWithinFrameWithName("bottom");			
			if (isElementPresent(getDynamicElement("New Relationship Name",newNameInquiryPage,sName))) {
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

	public void changeAccountDetails_UpdateRelationship(String sAccountNumber,String sName, String sRelationship) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field",relationshipTab);
				waitElement(2000);
				if (isElementPresent(getDynamicElement("Relationship Name",updateName,sName))) {
					selectElementByVisibleText("Change Account Page", "Relationship Field", getDynamicElement("Relationship list",relationshipAddName,sName), sRelationship);
					waitElement(2000);				

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					if(isElementPresent(warningHeader)) {
						if (isElementPresent(warning2)) {
							clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
						}
						if (isElementPresent(warning1)) {
							clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
						}
						if (isElementPresent(warning3)) {
							clickOnElement("New Loan Page", "Warning 3 Checkbox", warningCheckBox3);
						}
						clickOnElement("New Loan Page", "Save Button", saveBtn);
						waitElement(2000);
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
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details", "Relationship details Updated Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details", "Could not Update Relationship Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_UpdateRelationship(String sAccountNumber,String sName, String sRelationship) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);	
			switchToWithinFrameWithName("bottom");			
			if (isElementPresent(getDynamicElement("New Relationship Name",newNameInquiryPage,sName))) {
				validateTextContains("Account Inquiry" , "Relationship field",getDynamicElement("New Relationship Name",newNameRelationshipInquiryPage,sName), sRelationship);					
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

	public void changeAccountDetails_RemoveRelationship(String sAccountNumber,String sName) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {			
				clickOnElement("Change Account Page", "Relationship Tab Field",relationshipTab);
				waitElement(2000);
				if (isElementPresent(getDynamicElement("Relationship Name",updateName,sName))) {					
					for (int i = 2; i<=6;i++) {
						tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field", getDynamicElement("Relationship list",newName,Integer.toString(i)));
						if (tempVar.equals(sName)) {
							selectElementByVisibleText("Change Account Page", "Account info Name Field", getDynamicElement("Account info Name Field",newName,Integer.toString(i)), "(None)");
							waitElement(1000);
						}
					}

					if (isElementPresent((getDynamicElement("Remove Name Icon",removeNameIcon,sName)))) {
						clickOnElement("Change Account Page", "Remove Name Icon", (getDynamicElement("Remove Name Icon",removeNameIcon,sName)));
					}

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					if(isElementPresent(warningHeader)) {
						if (isElementPresent(warning2)) {
							clickOnElement("New Loan Page", "Warning 2 Checkbox", warningCheckBox2);
						}
						if (isElementPresent(warning1)) {
							clickOnElement("New Loan Page", "Warning 1 Checkbox", warningCheckBox1);
						}
						if (isElementPresent(warning3)) {
							clickOnElement("New Loan Page", "Warning 3 Checkbox", warningCheckBox3);
						}
						clickOnElement("New Loan Page", "Save Button", saveBtn);
						waitElement(2000);
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
			if (isElementPresent(getDynamicElement("New Relationship Name",newNameInquiryPage,sName))) {
				stepResult = false;	
			}else {
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

	public void changeAccountDetails_Balances(String sAccountNumber,String sNonAccrualCode, String sNonAccrualLateChargeOption, String sAutomaticRecoveryOverride, String sNonAccrualDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {			
				clickOnElement("Change Account Page", "Balances Tab Field",balancesTab);
				waitElement(2000);
				if (isElementPresent(nonAccrualHeader)) {
					if (!sNonAccrualCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "Non-Accrual Code Field",nonAccrualCodeList, sNonAccrualCode);
					}
					if (!sNonAccrualLateChargeOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Non-Accrual Late Charge Option Field",nonAccrualLateChargeOptionList, sNonAccrualLateChargeOption);
					}
					if (!sAutomaticRecoveryOverride.equals("")) {
						selectElementByVisibleText("Change Account Page", "Automatic Recovery Override Field",automaticRecoveryOverrideList, sAutomaticRecoveryOverride);
					}
					if (!sNonAccrualDate.equals("")) {
						enterText("Change Account Page", "Non Accrual Date Input field", nonAccrualDateInput, sNonAccrualDate);
					}

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
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
						if (isElementPresentZeroWait(warning4)) {
							clickOnElement("New Loan Page", "Warning 4 Checkbox", warningCheckBox4);
						}
						clickOnElement("New Loan Page", "Save Button", saveBtn);
						waitElement(2000);
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
					new HTMLReportHelper().HtmlReportBody("Change Account Balances Details", "Balances details updated Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Balances Details", "Could not update Balances Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_Balances(String sAccountNumber,String sNonAccrualCode, String sNonAccrualLateChargeOption, String sAutomaticRecoveryOverride,String sNonAccrualDate) throws Exception {

		boolean stepResult = false;
		try {
			waitElement(2000);
			//clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);	
			switchToWithinFrameWithName("bottom");			
			if (!sNonAccrualCode.equals("")) {
				sNonAccrualCode = ((sNonAccrualCode.split("\\["))[0]).trim();
				validateTextContains("Account Inquiry" , "Non-Accrual Code",nonAccrualCodeInquiryPage, sNonAccrualCode);
			}
			if (!sNonAccrualLateChargeOption.equals("")) {
				validateTextContains("Account Inquiry" , "Branch Region Code",nonAccrualLateChargeOptionInquiryPage, sNonAccrualLateChargeOption);
			}
			if (!sAutomaticRecoveryOverride.equals("")) {
				validateTextContains("Account Inquiry" , "Branch Region Code",automaticRecoveryOverrideInquiryPage, sAutomaticRecoveryOverride);
			}
			if (!sNonAccrualDate.equals("")) {
				sNonAccrualDate = new DateTimeHelper().getDateTime(sNonAccrualDate,"MM/dd/yyyy","MMM dd, yyyy");
				validateTextContains("Account Inquiry" , "Non-Accrual Date Date",nonAccrualDateInquiryPage, sNonAccrualDate);
			}
			stepResult = true;
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
		}
	}
	
	public void addCollateraltoLoanAccount(String sAccountNumber,String sCollateralRecordNumber) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {			
				mouseHoverCickOnElement("Change Account Page", "Collateral Under Balances Tab Field",balancesTab,collateralUnderBalancesTab);
				waitElement(2000);
				if (isElementPresent(collateralBoxHeader)) {
					if (!sCollateralRecordNumber.equals("")) {
						clickOnElement("Change Account Page", "Collateral Search Icon", SearchIConCollateral);		
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Collateral Search");
						Thread.sleep(4000);
						//driver.switchTo().frame("bottom");
						searchCollateral(sCollateralRecordNumber);
						Thread.sleep(4000);
						switchToWindowWithTitleContaining("Institution");
						driver.switchTo().frame("Main");
						waitElement(2000);
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					if(isElementPresent(warningHeader)) {
						if (isElementPresent(warning2)) {
							clickOnElement("Change Loan Page", "Warning 2 Checkbox", warningCheckBox2);
						}
						if (isElementPresentZeroWait(warning1)) {
							clickOnElement("Change Loan Page", "Warning 1 Checkbox", warningCheckBox1);
						}
						if (isElementPresentZeroWait(warning3)) {
							clickOnElement("Change Loan Page", "Warning 3 Checkbox", warningCheckBox3);
						}
						if (isElementPresentZeroWait(warning4)) {
							clickOnElement("Change Loan Page", "Warning 4 Checkbox", warningCheckBox4);
						}
						clickOnElement("Change Loan Page", "Save Button", saveBtn);
						waitElement(2000);
					}
					validateElementPresent("Change Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Add Collateral to Loan Account Details", "Collateral details updated Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Add Collateral to Loan Account Details", "Could not update Collateral Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void searchCollateral(String scollateralNo) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWithinFrameWithName("Main");
				if (isElementPresent(searchTitle)) {
					clickOnElement("Search Collateral Page", "Collateral Number", collateralSearch);
					enterText("Search Collateral Page", "Collateral Number", collateralSearch, scollateralNo);
					clickOnElement("Search Collateral Page", "Submit", submitSearch);
					waitElement(3000);
					if (isElementPresent(getDynamicElement("Search Collateral Link",searchAccountLink,scollateralNo))){
						clickOnElement("Search Collateral Page", "Searched Collateral Link", getDynamicElement("Search Account Link",searchAccountLink,scollateralNo));
					}
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
	public void validateAccountDetailsAfterCollateralAdd(String sAccountNumber,String sCollateralRecordNumber) throws Exception {
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				mouseHoverCickOnElement("Change Account Page", "Collateral Under Balances Tab Field",balancesTab,collateralUnderBalancesTab);
				waitElement(2000);			
				switchToWithinFrameWithName("bottom");			
				if (!sCollateralRecordNumber.equals("")) {
					validateTextContains("Account Inquiry" , "Collateral Record Number",collateralRecordNoInquiryPage, sCollateralRecordNumber);
				}
				stepResult = true;
				switchToDefaultContent();
				driver.switchTo().frame("Main");									
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Collateral Details Validation", "Validated Collateral Details on Inquiry page Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Collateral Details Validation", "Could not Validated Collateral Details on Inquiry page" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void changeAccountDetails_Payments(String sAccountNumber,String sAutomaticPaymentOption, String sChargeAccount, String sPaymentCode, String sAutomaticDraftAmount, String sAutomaticDraftPaymentOption, String sAutoDraftPaymentDate) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Payment Tab Field",paymentTab);
				waitElement(2000);
				if (isElementPresent(paymentsSummaryHeader)) {
					if (!sAutomaticPaymentOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Automatic Payment Option Field",automaticPaymentOptionList, sAutomaticPaymentOption);
					}
					if (!sPaymentCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "Payment Code Field",paymentCodeList, sPaymentCode);
					}
					if (!sChargeAccount.equals("")) {
						enterText("Change Account Page", "Charge Account Field", chargeAccountInput, sChargeAccount);
					}
					if (!sAutomaticDraftAmount.equals("")) {
						enterText("Change Account Page", "Automatic Draft Amount field", automaticDraftAmountInput, sAutomaticDraftAmount);
					}
					if (!sAutomaticDraftPaymentOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Automatic Draft Payment Option Field", automaticDraftPaymentOptionList, sAutomaticDraftPaymentOption);
					}
					if (!sAutoDraftPaymentDate.equals("")) {
						enterText("Change Account Page", "Auto Draft Payment Date field", autoDraftPaymentDateInput, sAutoDraftPaymentDate);
					}
					
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
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
						if (isElementPresentZeroWait(warning4)) {
							clickOnElement("New Loan Page", "Warning 4 Checkbox", warningCheckBox4);
						}
						clickOnElement("New Loan Page", "Save Button", saveBtn);
						waitElement(2000);
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
					new HTMLReportHelper().HtmlReportBody("Change Account Payment Details", "Payment details updated Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Payment Details", "Could not update Payment Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void validateAccountDetailsAfterChange_Payments(String sAccountNumber,String sAutomaticPaymentOption, String sChargeAccount, String sPaymentCode, String sAutomaticDraftAmount, String sAutomaticDraftPaymentOption, String sAutoDraftPaymentDate) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(5000);
			clickOnElement("Account Inquiry Page", "Payment Tab Field",paymentTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeaderInquiry,sAccountNumber))){
				if (!sAutomaticPaymentOption.equals("")) {
					validateTextContains("Account Inquiry" , "Automatic Payment Option", automaticPaymentOptionInquiryPage, sAutomaticPaymentOption);
				}
				if (!sPaymentCode.equals("")) {
					validateTextContains("Account Inquiry" , "Payment Frequency", paymentCodeInquiryPage, sPaymentCode);
				}
				if (!sAutomaticDraftPaymentOption.equals("")) {
					validateTextContains("Account Inquiry" , "Payment Frequency", automaticDraftPaymentOptionInquiryPage, sAutomaticDraftPaymentOption);
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
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Validated Loan Details on Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Could not Validated Loan Details on Inquiry page" , "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountProduct(String sAccountNumber, String sChangeProduct) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeader,sAccountNumber))){

					if (!sChangeProduct.equals("")) {
						if (sChangeProduct.contains("[")){
							String[] sIRAPlan_split = sChangeProduct.split("\\[");
							sChangeProduct=sIRAPlan_split[0].trim();
						}
						clickOnElement("Change Account Page", "Change Product Image Field", changeProductImg);
						waitElement(3000);
						if (isElementPresent(selectProductTitle)) {
							clickOnElement("Change Account Page", "Product Description Field", getDynamicElement("Product field", changeProductField, sChangeProduct));
							waitElement(3000);
						}
						if (isElementPresent(reviewDefaultsTitle)) {
							//clickOnElement("Change Account Page", "Class CheckBox Field", classCheckbox);
							clickOnElement("Change Account Page", "Check All Checkbox Link Field", checkAllLink);							
							clickOnElement("Change Account Page", "Finish Button Field", finishButton);
							waitElement(3000);
						}
					}				
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details","Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountProductAfterChange(String sAccountNumber, String sChangeProduct) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			//clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeaderInquiry,sAccountNumber))){
				//clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!sChangeProduct.equals(""))
					if (sChangeProduct.contains("[")){
						String[] sIRAPlan_split = sChangeProduct.split("\\[");
						sChangeProduct=sIRAPlan_split[0].trim();
					}
					validateTextContains("Account Inquiry", "Product field", productInquiryPage,sChangeProduct);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountLine(String sAccountNumber, String sChangeLine) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeader,sAccountNumber))){
					if (!sChangeLine.equals("")) {
						clickOnElement("Change Account Page", "Change Line Image Field", changeLineImg);
						waitElement(3000);
						if (isElementPresent(changeLineTitle)) {
							enterText("Change Account Page", "Enter Line field", lineNoInput, sChangeLine);
							clickOnElement("Change Account Page", "Submit Button Field", submitSearch);
							waitElement(3000);
						}
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details","Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountLineAfterChange(String sAccountNumber, String sChangeLine) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			//clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", loanChangeHeaderInquiry, sAccountNumber))) {
				//clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!sChangeLine.equals(""))
					validateTextContains("Account Inquiry", "Line field", lineInquiryPage,sChangeLine);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountDetails_InterestFees(String sAccountNumber,String sLoanRateIndex) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Intrest/Fees Tab Field",interestFeesTab);
				waitElement(2000);
					if (!sLoanRateIndex.equals("")) {
						clickOnElement("Change Account Page", "Loan Rate Index Input Field",loanRateIndexInput);	
						waitElement(1000);
						clickOnElement("Change Account Page", "Loan Rate Index Button Field",loanRateIndexButton);
						waitElement(1000);
						clickOnElement("Change Account Page", "Loan Rate Index List Field", getDynamicElement("Loan Rate Index Field",loanRateIndexList,sLoanRateIndex));
					}
					stepResult = true;	
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Intrest/Fees Details", "Intrest/Fees details updated Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Intrest/Fees Details", "Could not update Intrest/Fees Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void validateAccountAfterChangeInterestFees(String sAccountNumber,String sLoanRateIndex) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(5000);
			clickOnElement("Account Inquiry Page", "Intrest/Fees Tab Field",interestFeesTab);	
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field",loanChangeHeaderInquiry,sAccountNumber))){
				if (!sLoanRateIndex.equals("")) {
					sLoanRateIndex = ((sLoanRateIndex.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry" , "Loan Rate Index Option", loanRateIndexInquiryPage, sLoanRateIndex);
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
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Validated Loan Details on Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Loan Details Validation", "Could not Validated Loan Details on Inquiry page" , "Failed", driver, "Y");
			}
		}
	}
	
}



