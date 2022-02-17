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

public class Premier_Modeling extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_Modeling(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}
	String sSweepNo,sTotalAmount,sPrincipalAdvanceAmt,sMaturityAmount,sInitialDepositAmt;
	int iTotalAmount,iPrincipalAdvanceAmt,iPrincipalAdvance,iMaturityAmount,iInitialDepositAmt,iInitialDeposit; 
	boolean CheckboxFlag;
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By nextButton = By.xpath("//button[@value='Next']");
	public By nextButton2 = By.xpath("//button[@id='NextButton']");	
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By finishButton2 = By.xpath("//button[@id='SubmitButton']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	public By cancelButton = By.xpath("//button[text()='Cancel']");
	public By recordSuccessfulMsg = By.xpath("//*[text()='The record was updated successfully.']");
	
	public By warningHeader = By.xpath("//strong[text()='Select the checkbox to override the associated warning:']");
	public By warning1 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]");
	public By warningCheckBox1 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]/../../input");
	public By warning2 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[2]");
	public By warningCheckBox2 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Maximum Balance changes')])[1]/../../input");
	public By warning3 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]");
	public By warningCheckBox3 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]/../../input");
	public By warning4 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[2]");
	public By warningCheckBox4 = By.xpath("(//a[contains(text(),'All sweep relationships will reflect Sweep Funding Minimum Balance changes')])[1]/../../input");	
	public By saveBtn = By.xpath("//*[@title='Save']");
	
	public By loanProductTitle = By.xpath("//td/a[contains(text(),'Select a Loan Product to Model')]");
	String loanProductDescription = "//u[text()='%s']/..//preceding-sibling::td/u";
	public By selectNoteModelingPreferenceTitle = By.xpath("//td/a[contains(text(),'Select Note Modeling Preferences')]");
	public By solveForeList = By.xpath("//select[@id='SolveFor']");
	public By useSplitRatesCheckBox = By.xpath("//input[@id='UseSplitRates']");
	public By includeFeesCheckBox = By.xpath("//input[@id='IncludeFees']");
	public By includeEscrowCheckBox = By.xpath("//input[@id='IncludeEscrow']");
	public By includeInsuranceCheckBox = By.xpath("//input[@id='IncludeInsurance']");
	public By includeSimpleInsuranceCheckBox = By.xpath("//input[@id='IncludeSimpleIns']");
	public By includeDealerInterestCheckBox = By.xpath("//input[@id='IncludeDealerInt']");
	public By includeCustomerInformationCheckBox = By.xpath("//input[@id='IncludeCustomerInfo']");
	public By includeMessageCheckBox = By.xpath("//input[@id='IncludeMessage']");
	public By modelTitle = By.xpath("//td/a[text()='Model']");
	public By noteDateInput = By.xpath("//input[contains(@id,'InitialLoanDate')]");
	public By principalAdvanceInput = By.xpath("//input[contains(@id,'InitialLoanValue')]");
	public By interestRateOverSplitInput = By.xpath("//input[contains(@id,'RateOverSplit')]");
	public By splitRateAmountInput = By.xpath("//input[contains(@id,'SplitRateAmount')]");
	public By interestRateUnderSplitInput = By.xpath("//input[contains(@id,'RateUnderSplit')]");
	public By expensesFinancedInput = By.xpath("//input[contains(@id,'ExpensesFinanced')]");
	public By totalInsuranceInput = By.xpath("//input[contains(@id,'TotalInsurance')]");
	public By feesFinancedInput = By.xpath("//input[contains(@id,'TotalFeesFinanced')]");
	public By feesPrepaidInput = By.xpath("//input[contains(@id,'TotalFeesPrepaid')]");
	public By feesChargedInput = By.xpath("//input[contains(@id,'TotalFeesCharged')]");
	public By paymentActivityList = By.xpath("//b[text()='Number']/../../following-sibling::tr//select[contains(@id,'ActivityType')]");
	public By paymentDateInput = By.xpath("(//b[text()='Date']/../../following-sibling::tr//input[contains(@id,'Date')])[1]");
	public By paymentFrequencyList = By.xpath("//b[text()='Frequency']/../../following-sibling::tr//select[contains(@id,'Frequency')]");
	public By paymentNumberInput = By.xpath("(//b[text()='Number']/../../following-sibling::tr//input[contains(@id,'Number')])[2]");
	public By paymentAmountInput = By.xpath("//b[text()='Number']/../../following-sibling::tr//input[contains(@id,'Amount')]");
	public By noteModelStatementTitle = By.xpath("//td[contains(text(),'Note Model Statement')]");
	public By principalAdvanceStatement = By.xpath("//td[contains(text(),'Principal Advance:')]/following-sibling::td[contains(text(),'$')]");
	public By balloonPaymentDateInput = By.xpath("(//b[text()='Date']/../../following-sibling::tr//input[contains(@id,'Date')])[2]");
	String paymentfrequencyStatement = "(//td/b[text()='Frequency']/../../following-sibling::tr/td[contains(text(),'%s')])[1]";
	public By totalAmountStatement = By.xpath("//td[contains(text(),'Total of Payments:')]/following-sibling::td[contains(text(),'$')]");
	public By applicationList = By.xpath("//select[@id='Application']");
	String depositProductDescription = "//u[text()='%s']/..//preceding-sibling::td/u";
	public By depositProductTitle = By.xpath("//td/a[contains(text(),'Product Search')]");
	public By selectDepositModelingPreferenceTitle = By.xpath("//td/a[contains(text(),'Select Deposit Modeling Preferences')]");
	public By initialDepositDateInput = By.xpath("//input[contains(@id,'InitialDate')]");
	public By initialDepositInput = By.xpath("//input[contains(@id,'InitialDeposit')]");
	public By maturityValueInput = By.xpath("//input[contains(@id,'MaturityValue')]");
	public By depositModelStatementTitle = By.xpath("//td[contains(text(),'Deposit Model Statement')]");
	public By maturityValue = By.xpath("//td[contains(text(),'Maturity Value:')]/following-sibling::td[contains(text(),'$')]");
	public By initialDeposit = By.xpath("//td[contains(text(),'Initial Deposit:')]/following-sibling::td[contains(text(),'$')]");
	
	public void selectLoanProduct(String sLoanProductDesc, String sLoanProductNumber) throws Exception{
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
					driver.switchTo().frame("Main");
					if (isElementPresent(loanProductTitle)) {
						clickOnElement("Loan Product Page", "Loan Product Description", getDynamicElement("Loan Product Description",loanProductDescription,sLoanProductNumber));
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("select Loan Product", "Loan Product Selected Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("select Loan Product", "Could not Select Loan Product Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void selectNoteModelingPreference(String sProduct_SolveFor, String sUseSplitRates, String sIncludeFees, String sIncludeEscrow, String sIncludeInsurance, String sIncludeSimpleInsurance, String sIncludeDealerInterest, String sIncludeCustomerInformation, String sIncludeMessage) throws Exception{
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				Thread.sleep(5000);
					if (isElementPresent(selectNoteModelingPreferenceTitle)) {
						if (!sProduct_SolveFor.equals("")) {
							selectElementByVisibleText("New Modeling Preference Page", "Solve For Field", solveForeList, sProduct_SolveFor);
						}
						checkboxClick(sUseSplitRates,useSplitRatesCheckBox);
						checkboxClick(sIncludeFees,includeFeesCheckBox);
						checkboxClick(sIncludeEscrow,includeEscrowCheckBox);
						checkboxClick(sIncludeInsurance,includeInsuranceCheckBox);
						checkboxClick(sIncludeSimpleInsurance,includeSimpleInsuranceCheckBox);
						checkboxClick(sIncludeDealerInterest,includeDealerInterestCheckBox);
						checkboxClick(sIncludeCustomerInformation,includeCustomerInformationCheckBox);
						checkboxClick(sIncludeMessage,includeMessageCheckBox);
						
						clickOnElement("New Modeling Preference Page", "Submit Button", submitSearch);
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("select Note Modeling Preference", "select Note Modeling Preference selected Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("select Note Modeling Preference", "Could not Select select Note Modeling Preference Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void noteModelPage(String sNoteDate, String sPrincipalAdvance, String sInterestRateOverSplit, String sSplitRateAmount, String sInterestRateUnderSplit, String sExpensesFinanced, String sTotalInsurance, String sFeesFinanced, String sFeesPrepaid, String sFeesCharged, String sPaymentActivity, String sPaymentDate, String sPaymentFrequency, String sPaymentNumber, String sPaymentAmount,String sBalloonPaymentDate) throws Exception{
			if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
					//driver.switchTo().frame("Main");
					if (isElementPresent(modelTitle)) {
						if (!sNoteDate.equals("")) {
							enterText("New Modeling Page", "Note Date Field", noteDateInput, sNoteDate);
						}
						if (!sPrincipalAdvance.equals("")) {
							enterText("New Modeling Page", "Principal Advance Field", principalAdvanceInput, sPrincipalAdvance);
						}
						if (!sInterestRateOverSplit.equals("")) {
							enterText("New Modeling Page", "Interest Rate Over Split Field", interestRateOverSplitInput, sInterestRateOverSplit);
						}
						if (!sSplitRateAmount.equals("")) {
							enterText("New Modeling Page", "Split Rate Amount Field", splitRateAmountInput, sSplitRateAmount);
						}
						if (!sInterestRateUnderSplit.equals("")) {
							enterText("New Modeling Page", "Interest Rate Under Split Field", interestRateUnderSplitInput, sInterestRateUnderSplit);
						}
						if (!sExpensesFinanced.equals("")) {
							enterText("New Modeling Page", "Expenses Financed Field", expensesFinancedInput, sExpensesFinanced);
						}
						if (!sTotalInsurance.equals("")) {
							enterText("New Modeling Page", "Total Insurance Field", totalInsuranceInput, sTotalInsurance);
						}
						if (!sFeesFinanced.equals("")) {
							enterText("New Modeling Page", "Fees Financed Field", feesFinancedInput, sFeesFinanced);
						}
						if (!sFeesPrepaid.equals("")) {
							enterText("New Modeling Page", "Fees Prepaid Field", feesPrepaidInput, sFeesPrepaid);
						}
						if (!sFeesCharged.equals("")) {
							enterText("New Modeling Page", "Fees Charged Field", feesChargedInput, sFeesCharged);
						}
						if (!sPaymentActivity.equals("")) {
							selectElementByVisibleText("New Modeling Page", "Payment Activity option", paymentActivityList, sPaymentActivity);
						}
						if (!sPaymentDate.equals("")) {
							enterText("New Modeling Page", "Payment Date Field", paymentDateInput, sPaymentDate);
						}
						if (!sPaymentFrequency.equals("")) {
							selectElementByVisibleText("New Modeling Page", "Payment Frequency option", paymentFrequencyList, sPaymentFrequency);
						}
						if (!sPaymentNumber.equals("")) {
							enterText("New Modeling Page", "Payment Number Field", paymentNumberInput, sPaymentNumber);
						}
						if (!sPaymentAmount.equals("")) {
							enterText("New Modeling Page", "Payment Amount Field", paymentAmountInput, sPaymentAmount);
						}
						if (!sBalloonPaymentDate.equals("")) {
							enterText("New Modeling Page", "Balloon Payment Date Field", balloonPaymentDateInput, sBalloonPaymentDate);
						}
						
						clickOnElement("New Modeling Page", "Save Button", saveButton2);
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter Model details", "Details Enetered Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter Model details", "Could not enter details Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void verifyNoteModelStatement(String sPrincipalAdvance, String sPaymentNumber,String sPaymentFrequency) throws Exception{
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				if (isElementPresent(noteModelStatementTitle)) {	
					if (!sPaymentFrequency.equals("")) {
						validateTextContains("Note Calculator Modeling Page" , "Payment Frequency Value Field",getDynamicElement("Payment Frequency",paymentfrequencyStatement,sPaymentFrequency), sPaymentFrequency);
					}
					stepResult = true;
					sTotalAmount = getElementText("Note Model Statement Page","Total of Payments Field",totalAmountStatement);
					sTotalAmount = sTotalAmount.replace("$", "");
					sTotalAmount = sTotalAmount.replace(",", "");
					iTotalAmount = (int) Double.parseDouble(sTotalAmount);
					if(!(iTotalAmount>0)) {
						stepResult = false;
					}
					if (!sPrincipalAdvance.equals("")) {
						sPrincipalAdvanceAmt = getElementText("Note Model Statement Page","Principal Advance Value Field",principalAdvanceStatement);
						sPrincipalAdvanceAmt = sPrincipalAdvanceAmt.replace("$", "");
						sPrincipalAdvanceAmt = sPrincipalAdvanceAmt.replace(",", "");
						//iPrincipalAdvanceAmt = Float.valueOf(sPrincipalAdvanceAmt);
						iPrincipalAdvanceAmt = (int) Double.parseDouble(sPrincipalAdvanceAmt);
						iPrincipalAdvance = Integer.valueOf(sPrincipalAdvance);
						if(!(iPrincipalAdvance == iPrincipalAdvanceAmt)) {
							stepResult = false;
						}
					}									
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Values on Note Model Statement Page", "Values verified on Note Model Statement Page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Values on Note Model Statement Page", "Could not verify values on Note Model Statement Page Successfully", "Failed",
						driver, "Y");
				System.setProperty("runStep","N");
			}
		}
	}
}
	
	public void closeScreen_Image() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Modeling Page", "Close Button", closeScreenImg);
				Thread.sleep(2000);
				clickOnElement("Modeling Page", "Close Button", closeScreenImg);
				Thread.sleep(1000);
				clickOnElement("Modeling Page", "Cancel Button", cancelButton);				
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
	
	public void checkboxClick(String sFlag,By by) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				String checkFlag = sFlag;
				if (checkFlag.equals("Yes")) {
					CheckboxFlag = true;
				}else {
					CheckboxFlag = false;
				}			
				if (!(driver.findElement(by).isSelected()) == CheckboxFlag ){
						clickOnElement("New Modeling Preference Page", "CheckBox Field", by);
				}
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Checkbox","Clicked on Checkbox Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Checkbox", "Could not clicked on Checkbox","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void selectDepositProduct(String sApplication, String sDepositProductDesc, String sDepositProductNumber) throws Exception{
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
				Thread.sleep(4000);
					driver.switchTo().frame("Main");
					if (isElementPresent(depositProductTitle)) {
						if (!sApplication.equals("")) {
							selectElementByVisibleText("New Modeling Page", "Application Field", applicationList, sApplication);
						}
						clickOnElement("New Modeling Product Search Page", "Submit Button", submitSearch);
						waitElement(3000);
						if (!sDepositProductNumber.equals("")) {
							clickOnElement("Deposit Product Page", "Deposit Product Description", getDynamicElement("Deposit Product Description",depositProductDescription,sDepositProductNumber));
						}
						
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("select Deposit Product", "Deposit Product Selected Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("select Deposit Product", "Could not Select Deposit Product Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void selectDepositModelingPreference(String sProduct_SolveFor, String sIncludeCustomerInformation, String sIncludeMessage) throws Exception{
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
				Thread.sleep(5000);
					if (isElementPresent(selectDepositModelingPreferenceTitle)) {
						if (!sProduct_SolveFor.equals("")) {
							selectElementByVisibleText("New Modeling Preference Page", "Solve For Field", solveForeList, sProduct_SolveFor);
						}
						checkboxClick(sIncludeCustomerInformation,includeCustomerInformationCheckBox);
						checkboxClick(sIncludeMessage,includeMessageCheckBox);
						
						clickOnElement("New Modeling Preference Page", "Submit Button", submitSearch);
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("select Deposit Modeling Preference", "select Deposit Modeling Preference selected Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("select Deposit Modeling Preference", "Could not Select select Deposit Modeling Preference Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void depositModelPage(String sInitialDepositDate, String sInitialDeposit, String sMaturityValue, String sPaymentActivity, String sPaymentDate, String sPaymentFrequency, String sPaymentNumber, String sPaymentAmount) throws Exception{
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
				Thread.sleep(4000);
					//driver.switchTo().frame("Main");
					if (isElementPresent(modelTitle)) {
						if (!sInitialDepositDate.equals("")) {
							clearAndType("New Modeling Page", "Initial Deposit Date Field", initialDepositDateInput, sInitialDepositDate);
						}
						if (!sInitialDeposit.equals("")) {
							enterText("New Modeling Page", "Initial Deposit Field", initialDepositInput, sInitialDeposit);
						}
						if (!sMaturityValue.equals("")) {
							enterText("New Modeling Page", "Maturity Value Field", maturityValueInput, sMaturityValue);
						}
						if (!sPaymentActivity.equals("")) {
							selectElementByVisibleText("New Modeling Page", "Payment Activity option", paymentActivityList, sPaymentActivity);
						}
						if (!sPaymentDate.equals("")) {
							enterText("New Modeling Page", "Payment Date Field", paymentDateInput, sPaymentDate);
						}
						if (!sPaymentFrequency.equals("")) {
							selectElementByVisibleText("New Modeling Page", "Payment Frequency option", paymentFrequencyList, sPaymentFrequency);
						}
						if (!sPaymentNumber.equals("")) {
							enterText("New Modeling Page", "Payment Number Field", paymentNumberInput, sPaymentNumber);
						}
						if (!sPaymentAmount.equals("")) {
							enterText("New Modeling Page", "Payment Amount Field", paymentAmountInput, sPaymentAmount);
						}
						
						clickOnElement("New Modeling Page", "Save Button", saveButton2);
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter Model details", "Details Enetered Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter Model details", "Could not enter details Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void verifyDepositModelStatement(String sInitialDeposit,String sPaymentFrequency) throws Exception{
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				if (isElementPresent(depositModelStatementTitle)) {	
					if (!sPaymentFrequency.equals("")) {
						validateTextContains("Deposit Calculator Modeling Page" , "Payment Frequency Value Field",getDynamicElement("Payment Frequency",paymentfrequencyStatement,sPaymentFrequency), sPaymentFrequency);
					}
					stepResult = true;
					sMaturityAmount = getElementText("Deposit Model Statement Page","Maturity Value Field",maturityValue);
					sMaturityAmount = sMaturityAmount.replace("$", "");
					sMaturityAmount = sMaturityAmount.replace(",", "");
					iMaturityAmount = (int) Double.parseDouble(sMaturityAmount);
					if(!(iMaturityAmount>0)) {
						stepResult = false;
					}
					if (!sInitialDeposit.equals("")) {
						sInitialDepositAmt = getElementText("Deposit Model Statement Page","Initial Deposit Field",initialDeposit);
						sInitialDepositAmt = sInitialDepositAmt.replace("$", "");
						sInitialDepositAmt = sInitialDepositAmt.replace(",", "");
						//iPrincipalAdvanceAmt = Float.valueOf(sPrincipalAdvanceAmt);
						iInitialDepositAmt = (int) Double.parseDouble(sInitialDepositAmt);
						iInitialDeposit = Integer.valueOf(sInitialDeposit);
						if(!(iInitialDeposit == iInitialDepositAmt)) {
							stepResult = false;
						}
					}									
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Values on Deposit Model Statement Page", "Values verified on Deposit Model Statement Page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Values on Deposit Model Statement Page", "Could not verify values on Deposit Model Statement Page Successfully", "Failed",
						driver, "Y");
				System.setProperty("runStep","N");
			}
		}
	}
}
	
}



