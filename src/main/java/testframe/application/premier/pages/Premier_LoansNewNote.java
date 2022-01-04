package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

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

	By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
	By noteNumber = By.xpath("//td[contains(text(),'Note Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	By cashProcceds = By.xpath("//td[contains(text(),'Cash Proceeds:')]/following-sibling::td/input[contains(@id,'OrigCashProceeds')]");
	By maximumCredit = By.xpath("(//input[contains(@name,'MaximumCredit')])");
	By maximumCreditCode = By.xpath("(//select[contains(@name,'MaximumCreditCode')])");
	By noteDate = By.xpath("//td[contains(text(),'Note Date:')]/following-sibling::td/input[contains(@id,'OrigNoteDate')]");
	By contractDate = By.xpath("//td[contains(text(),'Contract Date:')]/following-sibling::td/input[contains(@id,'OrigContractDate')]");
	By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	By accountOpenMethodButton = By.xpath("(//input[contains(@name,'AccountOpenMethod')])[3]");
	By originalCreditScore = By.xpath("//td[contains(text(),'Original Credit Score:')]/following-sibling::td/input[contains(@id,'OrigCreditScore')]");
	By paymentReserveOPtion = By.xpath("(//select[contains(@name,'PymtReserveOption')])");
	By originalPaymentReserve = By.xpath("//td[contains(text(),'Original Payment Reserve:')]/following-sibling::td/input[contains(@id,'OrigPymtReserve')]");
	By internalPaymentOption = By.xpath("(//select[contains(@name,'InternalPymtOption')])");
	By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");	
	By nextButton = By.xpath("//button[@value='Next']");
	By paymentPageTitle =  By.xpath("//a[text()='Step 4 - Payment']");
	By interestMethod = By.xpath("(//select[contains(@name,'OrigIntMethod')])");
	By firstPaymentDate = By.xpath("//td[contains(text(),'First Payment Date:')]/following-sibling::td/input[contains(@id,'OrigFirstPaymentDate')]");
	By paymentFrequency = By.xpath("(//select[contains(@name,'OrigPaymentFrequency')])");
	By firstPaymentInterestDate = By.xpath("//td[contains(text(),'First Interest Payment Date:')]/following-sibling::td/input[contains(@id,'OrigFirstIntPymtDate')]");
	By interestPaymentFrequency = By.xpath("(//select[contains(@name,'OrigIntPymtFrequency')])");
	By purposeCodeButton = By.xpath("(//input[contains(@name,'PurposeCode')])[3]");
	By paymentCode = By.xpath("(//select[contains(@name,'PaymentCode')])");
	By chargeAccount = By.xpath("//td[contains(text(),'Charge Account:')]/following-sibling::td/input[contains(@id,'ChargeAccount')]");
	By rate = By.xpath("//td[contains(text(),'Rate:')]/following-sibling::td/input[contains(@id,'OrigRateOverSplit')]");
	By rateAdjuster1 = By.xpath("//td[contains(text(),'Rate Adjuster 1:')]/following-sibling::td/input[contains(@id,'RateAdjuster')]");
	By rateAdjuster2 = By.xpath("//td[contains(text(),'Rate Adjuster 2:')]/following-sibling::td/input[contains(@id,'RateAdjuster')]");
	By percentPrimeCode = By.xpath("(//select[contains(@name,'PercentOfPrimeCode')])");
	By totalInterest = By.xpath("//td[contains(text(),'Total Interest:')]/following-sibling::td/input[contains(@id,'OrigTotalInterest')]");

	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	String accountOpenMethodCodeList =  "//select[contains(@name,'AccountOpenMethod')]/option[contains(text(),'%s')]";
	String purposeCodeList =  "//select[contains(@name,'PurposeCode')]/option[contains(text(),'%s')]";

	public void newNoteLoanAcc_CodesScreen(String sNoteAccntNo,String scashProceeds,String sMaximumCredit,String sMaximumCreditCode,
			String sNoteDate,String sContractDate,String sAccountOpenMethod,String sOriginalCreditScore,String sPaymentReserveOption,
			String sOriginalPaymentReserve,String sInternalPaymentOption,String sResponsibilityCode) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(codesPageTitle)) {
				if (!sNoteAccntNo.equals("")) {
					enterText("New Note Codes Page", "Note Number", noteNumber, sNoteAccntNo);
				}	
				if(!scashProceeds.equals("")) {
					selectElementByVisibleText("New Note Codes Page", "Cash Proceeds Field", cashProcceds, scashProceeds);
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
			}

		}
	}


   public void newNoteLoan_PaymentScreen(String sinterestMethod,String sFirstPaymentDate,String sPaymentFrequency,String sFirstInterestPaymentDate,
		   String sInterestPaymentFrequency,String sPurposeCode,String sPaymentCode,String sChargeAccount,String sRateAdjuster1,
		   String sRateAdjuster2,String sPercentOfPrimeCode,String sTotalInterest) throws Exception {
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
			}

		}
   }
	



}


