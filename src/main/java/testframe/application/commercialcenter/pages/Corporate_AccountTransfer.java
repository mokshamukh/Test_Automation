package testframe.application.commercialcenter.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

/**
 * PageNage : CommercialCenter_CorporateAccountTransfer
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_AccountTransfer extends CommonLibrary {

	String currentBalanceField;
	public String sAfterTransBalance;
	public double iAfterTransAccountBalance;
	public double iInitialBalance;
	public double totalAmount;

	By accountTransferTitle = By.xpath("//button[contains(text(),'Account Transfer')]");
	By fromAccountField = By.xpath(
			"//label[@class='d-lg-none'][text()='From Account']/../../../..//button[contains(@aria-label,'add account')]/parent::div/preceding-sibling::div[1]//input[@id='fromAccount']");
	// By toAccountField = By.xpath("//label[@class='d-lg-none'][text()='To
	// Account']/../../../..//button[contains(@aria-label,'add
	// account')]/parent::div[1]/preceding-sibling::div[1]//input[contains(@id,'toAccount')]");
	By toAccountField = By.xpath("//input[@id='toAccount0']");
	By fromAccountAmt = By.xpath("//input[@id='fromAmount']");
	By fromAccountAmt1 = By.xpath("(//input[@id='fromAmount'])[2]");
	By fromAccountAmt2 = By.xpath("(//input[@id='fromAmount'])[3]");
	By fromAccountAmt3 = By.xpath("(//input[@id='fromAmount'])[4]");
	By fromAccMemo = By.xpath("(//input[@id='fromMemo'])[1]");
	By addAccount_frmAcc = By.xpath(
			"//label[@class='d-lg-none'][text()='From Account']/../../../..//button[@aria-label='Click to add account']");
	By addAccount_toAcc = By.xpath(
			"//label[@class='d-lg-none'][text()='To Account']/../../../..//button[@aria-label='Click to add account']");

	By fromAccountMemo = By.xpath(
			"//label[@class='d-lg-none'][text()='From Account']/../../../..//button[contains(@aria-label,'add account')]/parent::div/preceding-sibling::div[1]//input[@id='fromMemo']");
	By transferDate = By.xpath("//input[@id='transferDate']");
	By reqTransferButton = By.xpath("//button[@aria-label='Request Transfer']");

	// By toAccPayInstruction = By.xpath("//label[@class='d-lg-none'][text()='To
	// Account']/../../../..//button[contains(@aria-label,'add
	// account')]/parent::div[1]/preceding-sibling::div[1]//span[contains(@class,'expand_more')]/parent::div/following-sibling::div//span[text()='%s']");
	By toAccPayInstruction = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[1]");
	By toAccPayInstruction1 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])");
	By toAccPayInstruction2 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[2]");
	By toAccPayInstruction3 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[3]");
	By toAccField1 = By.xpath("//input[@id='toAccount1']");
	By toAccField2 = By.xpath("//input[@id='toAccount2']");
	By toAccField3 = By.xpath("//input[@id='toAccount3']");
	By transferDateTitle = By.xpath("//h3[contains(text(),'Transfer Details')]");
	By recurringOptAcc = By.xpath("(//div[@class='card-header'])[2]/a/i[text()='keyboard_arrow_right']");
	By transactionUntilEndDate = By.xpath("//div[contains(@class,'required end-date calendar')]//input");
	By fixedDateNum = By.xpath("//div[@class='required fixed-range']//input");
	By seriesDetailsDate = By.xpath("//input[@id='defaultStartDate']");
	By saveButton = By.xpath("//button[text()='Save'][contains(@aria-label,'recurring options')]");
	By seriesName= By.xpath("//input[@formcontrolname='seriesName']");
	By fromAccField = By.xpath("//p-autocomplete//input[@id='fromAccount']");
	By accountNumberField = By.xpath("//input[@name='accountNumberId']");
	By accountSearchButton = By.xpath("//button//span[text()='ui-btn']");
	By accountBalanceHeader = By.xpath("//h1[text()='Account Balances']");
	By accountTransactionHeader = By.xpath("//h1[contains(text(),'Transaction Search')]");
	By searchAccountNumber = By.xpath("//button[contains(@aria-label,'To get the list matching the search criteria')]//i[text()='search']");
	By currentBalance = By.xpath("//div[text()='Current Balance ']//..//span[@class='card-value']");
	By closeBalanceTab = By.xpath("//a[@title='Balances']//i[text()='close']");
	By transactionSearchAccNum = By.xpath("//input[@id='accountNumber']");
	By transSearchButton = By.xpath("(//div[@class='transaction-search']//button[contains(@aria-label,'To get the list matching the search criteria')]//i[text()='search'])[1]");
	By showingTransactions = By.xpath("(//div//span[@class='details'])[1]");
	By fromDate = By.xpath("(//input[@id='fromDate'])[1]");
	By toDate = By.xpath("(//input[@id='toDate'])[1]");
	By amountfield = By.xpath("//input[@name='transactionAmountFrom']");
	By transactionFromAmtField = By.xpath("//input[@id='transactionAmountFrom']");
	By transactionToAmtField = By.xpath("//input[@id='transactionAmountTo']");
	


	// By daily_EachBusiDay =
	// By.xpath("//p-radiobutton[@formcontrolname='everyDay']/div/div/input[@id='opt1']");
	// By daily_SpeciDay =
	// By.xpath("//p-radiobutton[@formcontrolname='everyDay']/div/div/input[@id='opt2']");

	String freq = "//ul[@class='nav nav-pills flex-column']/li/a[@id='%s']";
	String daily_opt = "//label[contains(text(),'%s')]/preceding-sibling::div/div/span";
	String daily_subOpt = "//label[text()='%s']/..//p-checkbox/div//input";
	String daily_subOptions = "//span[@class='ui-chkbox-icon ui-clickable']/../preceding-sibling::div/../..//label[contains(text(),'%s')]";
	String accList = "//ul[@role='listbox']/li/span[contains(text(),'%s')]";
	String paymentInstrField = "(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[1]/parent::div/following-sibling::div//span[text()='%s']";
	String durationOpt = "//p-radiobutton[@name='duration']/label[contains(text(),'%s')]/preceding-sibling::div/div[@role='radio']";
	String daysOfWeek = "//label[text()='%s']/../div[@class='ui-radiobutton ui-widget']";
	String fromAccList = "//li[@role='option']/span[contains(text(),'%s')]";
	String memoReviewField = "(//div[contains(@class,'transaction-search-description')]//div//span[contains(text(),'%s')])[1]";

	String memo;
	String amt;

	public Corporate_AccountTransfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFromAccount(String fromAcc, String fromAccAmt) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountTransferTitle)) {
					waitElement(3000);
					enterText("Corporate Account Transfer", "From Account", fromAccountField, fromAcc);
					waitElement(3000);
					//selectElementFromListbox("Corporate Account Transfer", "From Account", fromAccountField, fromAccList, fromAcc);
					clickOnElement("Corporate Account Transfer", "From Account",getDynamicElement("From Account", fromAccList, fromAcc));
					waitElement(3000);
					if (!fromAccAmt.equals("")) {
						waitElement(3000);
						enterText("Corporate Account Transfer", "From Account Amount", fromAccountAmt, fromAccAmt);
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Enter from account field", "Enter from account field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter from account field", "Could not enter from account field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void addAndEnterFromAccDetails(String addFromAccountVal1, String fromAcMemo, String fromAcc1,
			String fromAccAmt1, String fromAccMemo1, String addFromAccountVal2, String fromAcc2, String fromAccAmt2,
			String fromAccMemo2, String addFromAccountVal3, String fromAcc3, String fromAccAmt3, String fromAccMemo3) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (addFromAccountVal1.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "From Account1", addAccount_frmAcc);
					if (!fromAcMemo.equals("")) {
						enterText("Corporate Account Transfer", "From Account Memo", fromAccMemo, fromAcMemo);
					}
					if (!fromAcc1.equals("")) {
						enterText("Corporate Account Transfer", "From Account1", fromAccountField, fromAcc1);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "From Account1", getDynamicElement("From Account1", fromAccList, fromAcc1));
					}
					if (!fromAccAmt1.equals("")) {
						enterText("Corporate Account Transfer", "From Account Amount", fromAccountAmt1, fromAccAmt1);
					}
					if (!fromAccMemo1.equals("")) {
						enterText("Corporate Account Transfer", "From Account Memo", fromAccountMemo, fromAccMemo1);
					}

				}
				if (addFromAccountVal2.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "From Account2", addAccount_frmAcc);
					if (!fromAcc2.equals("")) {
						enterText("Corporate Account Transfer", "From Account2", fromAccountField, fromAcc2);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "From Account",getDynamicElement("From Account", fromAccList, fromAcc2));
					}
					if (!fromAccAmt2.equals("")) {
						enterText("Corporate Account Transfer", "From Account Amount", fromAccountAmt2, fromAccAmt2);
					}
					if (!fromAccMemo2.equals("")) {
						enterText("Corporate Account Transfer", "From Account Memo", fromAccountMemo, fromAccMemo2);
					}
				}
				if (addFromAccountVal3.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "From Account3", addAccount_frmAcc);
					if (!fromAcc3.equals("")) {
						enterText("Corporate Account Transfer", "From Account3", fromAccountField, fromAcc3);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "From Account",getDynamicElement("From Account", fromAccList, fromAcc2));
					}
					if (!fromAccAmt3.equals("")) {
						enterText("Corporate Account Transfer", "From Account Amount", fromAccountAmt3, fromAccAmt3);
					}
					if (!fromAccMemo3.equals("")) {
						enterText("Corporate Account Transfer", "From Account Memo", fromAccountMemo, fromAccMemo3);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter multiple from account field", "Enter multiple from account field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter multiple from account field ", "Could not enter multiple from account field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void enterToAccount(String toAcc, String toAccAmt, String toAccMemo,
			String toAccPayInstr) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountTransferTitle)) {
					if(!toAcc.equals("")){
						waitElement(3000);
						enterText("Corporate Account Transfer", "To Account", toAccountField, toAcc);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "To Account", getDynamicElement("To Account", fromAccList, toAcc));
						//selectElementFromListbox("Corporate Account Transfer", "To Account", toAccountField, fromAccList, toAcc);
						waitElement(3000);
					}
					if (!toAccAmt.equals("")) {
						enterText("Corporate Account Transfer", "To Account Amount",
								returnByElement("To Account Amount", getToAccAmt("Amt_0")), toAccAmt);
					}
					if (!toAccMemo.equals("")) {
						enterText("Corporate Account Transfer", "To Account Memo",
								returnByElement("To Account Memo", getToAccMemo("Memo_0")) ,toAccMemo);
					}
					if (!toAccPayInstr.equals("")) {
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction", toAccPayInstruction);
						waitElement(3000);
						getDynamicElementClick("Corporate Account Transfer", "To Account Payment Instruction", paymentInstrField, toAccPayInstr);
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- to acc");
					new HTMLReportHelper().HtmlReportBody("Enter to account field", "Enter to account field successfully", "Passed", driver, "Y");

				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter to account field", "Could not enter to account field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void addAndEnterToAccDetails(String addToAccountVal1, String toAcc1, String toAccAmt1, 
			String toAccMemo1, String toAccPayInstr1, String addToAccountVal2, String toAcc2,
			String toAccAmt2, String toAccMemo2, String toAccPayInstr2,
			String addToAccountVal3, String toAcc3, String toAccAmt3,  String toAccMemo3, String toAccPayInstr3) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (addToAccountVal1.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "Add Account1", addAccount_toAcc);
					if (!toAcc1.equals("")) {
						enterText("Corporate Account Transfer", "To Account1", toAccField1, toAcc1);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "To Account", getDynamicElement("To Account", fromAccList, toAcc1));
					}
					if (!toAccAmt1.equals("")) {
						enterText("Corporate Account Transfer", "To Account Amount",
								returnByElement("To Account Amount", getToAccAmt("Amt_1")), toAccAmt1);
					}
					if (!toAccMemo1.equals("")) {
						enterText("Corporate Account Transfer", "To Account Memo",
								returnByElement("To Account Memo", getToAccMemo("Memo_1")), toAccMemo1);
					}
					if (!toAccPayInstr1.equals("")) {
						Thread.sleep(2000);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction1",
								toAccPayInstruction1);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction1",
								getDynamicElement("To Account Payment Instruction", paymentInstrField, toAccPayInstr1));
					}
				}
				if (addToAccountVal2.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "Add Account1", addAccount_toAcc);
					if (!toAcc2.equals("")) {
						enterText("Corporate Account Transfer", "From Account2", toAccField2, toAcc2);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "To Account", getDynamicElement("To Account", fromAccList, toAcc2));
					}
					if (!toAccAmt2.equals("")) {
						enterText("Corporate Account Transfer", "To Account Amount",
								returnByElement("To Account Amount", getToAccAmt("Amt_2")), toAccAmt2);
					}
					if (!toAccMemo2.equals("")) {
						enterText("Corporate Account Transfer", "To Account Memo",
								returnByElement("To Account Memo", getToAccMemo("Memo_2")), toAccMemo2);
					}
					if (!toAccPayInstr2.equals("")) {
						Thread.sleep(2000);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction2",
								toAccPayInstruction2);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction2",
								getDynamicElement("To Account Payment Instruction", paymentInstrField, toAccPayInstr2));
					}
				}
				if (addToAccountVal3.equals("Yes")) {
					clickOnElement("Corporate Account Transfer", "Add Account1", addAccount_toAcc);
					if (!toAcc3.equals("")) {
						enterText("Corporate Account Transfer", "To Account3", toAccField3, toAcc3);
						waitElement(3000);
						clickOnElement("Corporate Account Transfer", "To Account", getDynamicElement("To Account", fromAccList, toAcc3));

					}
					if (!toAccAmt3.equals("")) {
						enterText("Corporate Account Transfer", "To Account Amount",
								returnByElement("To Account Amount", getToAccAmt("Amt_3")), toAccAmt3);
					}
					if (!toAccMemo3.equals("")) {
						enterText("Corporate Account Transfer", "To Account Memo",
								returnByElement("To Account Memo", getToAccMemo("Memo_3")), toAccMemo3);
					}
					if (!toAccPayInstr3.equals("")) {
						Thread.sleep(2000);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction3",
								toAccPayInstruction3);
						clickOnElement("Corporate Account Transfer", "To Account Payment Instruction3",
								getDynamicElement("To Account Payment Instruction", paymentInstrField, toAccPayInstr3));
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - multiple to acc");
					new HTMLReportHelper().HtmlReportBody("Enter multiple to account field", "Enter multiple to account field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter multiple to account field", "Could not enter multiple to account field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public String getToAccMemo(String field) {
		switch (field) {
		case "Memo_0":
			memo = "//input[@id='toMemo0']";
			break;
		case "Memo_1":
			memo = "//input[@id='toMemo1']";
			break;
		case "Memo_2":
			memo = "//input[@id='toMemo2']";
			break;
		case "Memo_3":
			memo = "//input[@id='toMemo3']";
			break;
		default:
			break;
		}
		return memo;

	}

	public String getToAccAmt(String field) {

		switch (field) {
		case "Amt_0":
			amt = "//input[@id='toAmount0']";
			break;
		case "Amt_1":
			amt = "//input[@id='toAmount1']";
			break;
		case "Amt_2":
			amt = "//input[@id='toAmount2']";
			break;
		case "Amt_3":
			amt = "//input[@id='toAmount3']";
			break;
		default:
			break;
		}
		return amt;

	}

	public void enterTransferDate(String transferDates) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!transferDates.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(transferDate).sendKeys(Keys.BACK_SPACE);
					}
					enterText("Corporate Account Transfer", "Transfer Date", transferDate, transferDates);
					clickOnElement("Corporate Account Transfer", "Transfer Date Title", transferDateTitle);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date field", "Enter transfer date field successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter transfer date field", "Could not enter transfer date field successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickReqTransfer() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountTransferTitle)) {
					clickOnELementUsingJS(driver.findElement(By.xpath("//button[@aria-label='Request Transfer']")));
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - click transfer req");
					new HTMLReportHelper().HtmlReportBody("Click transfer request", "Click transfer request successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click transfer request", "Could not click transfer request successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	/*
	 Freq : Daily,Weekly,Bi-Weekly,Semi-Monthly,Monthly,Anually 
	 Daily opt :Business, Specific Daily 
	 Sub Opt : Select All, Monday,Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday


	 */
	public void selectRecurringOption(String recurringOpt, String frequency, String dailyopt, String dailySubOpt,String day) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!recurringOpt.equals("")) {
					clickOnElement("Corporate Account Transfer", "Recurring Option Accordion", recurringOptAcc);
					Thread.sleep(8000);
					getDynamicElementClick("Corporate Account Transfer", "Frequency Option", freq, frequency.toUpperCase());
					if (frequency.equalsIgnoreCase("Daily")) {
						getDynamicElementClick("Corporate Account Transfer", "Daily Option", daily_opt, dailyopt);
						if (dailyopt.contains("Specific")) {
							if (!dailySubOpt.equals("Select All")) {
								// dailySubOptArr = Monday|Saturday|Sunday
								String[] dailySubOptArr = dailySubOpt.trim().split("\\|");
								for (int i = 0; i < dailySubOptArr.length; i++) {
									Thread.sleep(4000);
									getDynamicElementClick("Corporate Account Transfer", "Daily Option", daily_subOptions,
											dailySubOptArr[i]);
								}
							} else {
								getDynamicElementClick("Corporate Account Transfer", "Daily Option", daily_subOpt,dailySubOpt);
							}
						}
					}
					if(frequency.equalsIgnoreCase("Weekly")){
						getDynamicElementClick("Corporate Account Transfer", "Weekly Option", daysOfWeek, day);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select recurring option", "Select recurring option successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select recurring option", "Could not select recurring option successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	// Duration :Indefinitely,Until End Date,Fixed Number
	public void selectDuration(String duration, String transDate, String fixedNumTrans) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!duration.equals("")) {
					if (duration.contains("Until End Date")) {
						getDynamicElementClick("Corporate Account Transfer", "Duration Option", durationOpt, duration);
						if (!transDate.equals("")) {
							for (int i = 1; i <= 10; i++) {
								driver.findElement(transferDate).sendKeys(Keys.BACK_SPACE);
							}
							Thread.sleep(10000);
							enterText("Corporate Account Transfer", "Transaction Repeats Until End Date ",
									transactionUntilEndDate, transDate);
						}
					}
					if (duration.contains("Fixed Number")) {
						getDynamicElementClick("Corporate Account Transfer", "Duration Option", durationOpt, duration);
						clearAndType("Corporate Account Transfer", "Fixed Number of Transaction", fixedDateNum,
								fixedNumTrans);
					}
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select duration option ", "Select duration option successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select duration option ", "Could not select duration option successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterSeriesDetails(String seriesDate) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				if (!seriesDate.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(seriesDetailsDate).sendKeys(Keys.BACK_SPACE);
					}
					Thread.sleep(10000);
					enterText("Corporate Account Transfer", "Series Details Date", seriesDetailsDate, seriesDate);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter series date ", "Enter series date successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter series date ", "Could not Enter series date successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void clickRecurringOptButton() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				clickOnElement("Corporate Account Transfer", "Save Button", saveButton);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass - Acc Transfer -- transfer date");
					new HTMLReportHelper().HtmlReportBody("Click save button ", "Click save button successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click save button ", "Could not click save button successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void enterSeriesName(String name) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				enterText("Corporate Account Transfer", "Series Name", seriesName, name);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass - Acc Transfer -- Series Name");
					new HTMLReportHelper().HtmlReportBody("Enter series name", "Enter series name successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter series name", "Could not Enter series name successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void searchAccountBalances(String fromAccountNumber,String excelFilePath,String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountBalanceHeader)) {
					if(!fromAccountNumber.equals("")){
						waitElement(2000);
						enterText("Corporate Account Transfer", "Account Number", accountNumberField, fromAccountNumber);
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Account Number", getDynamicElement("Account Number", fromAccList, fromAccountNumber));
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Search button", searchAccountNumber);
						waitElement(2000);
					}
					currentBalanceField = getElementText("Corporate Account Transfer", "Current Balance", currentBalance);
					System.out.println(currentBalanceField);
					if(currentBalanceField != "") {
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "CurrentBalance", rowNo+1, currentBalanceField);				
						System.out.println(currentBalanceField);
					}
				//	clickOnElement("Corporate Account Transfer", "Balance close button",  closeBalanceTab);

					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- to acc");
					new HTMLReportHelper().HtmlReportBody("search account balance", "search account balance successfully", "Passed", driver, "Y");

				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("search account balance", "Could not search account balance successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void closeBalanceTab()throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				clickOnElement("Corporate Account Transfer", "Balance close button",  closeBalanceTab);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass - Acc Transfer -- Balance tab closed");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyAccountBalanceAfterTransaction(String date,String fromAccountNumber,String balanceBeforeTransaction,String amount) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountBalanceHeader)) {
					if(!fromAccountNumber.equals("")){
						waitElement(2000);
						enterText("Corporate Account Transfer", "Account Number", accountNumberField, fromAccountNumber);
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Account Number", getDynamicElement("Account Number", fromAccList, fromAccountNumber));
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Search button", searchAccountNumber);
						waitElement(2000);
					}
					if(!date.equals("")){
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
						LocalDateTime now = LocalDateTime.now();  
						String currentDate = dtf.format(now);
						System.out.println(dtf.format(now)); 
						
						if(currentDate.compareTo(date) == 0) {

//							if(!fromAccountNumber.equals("")){
//								waitElement(2000);
//								clearAndType("Corporate Account Transfer", "Account Number", accountNumberField, fromAccountNumber);
//								waitElement(2000);
//								clickOnElement("Corporate Account Transfer", "Account Number", getDynamicElement("Account Number", fromAccList, fromAccountNumber));
//								waitElement(2000);
//								clickOnElement("Corporate Account Transfer", "Search button", searchAccountNumber);
//								waitElement(2000);
//							}
							if (!balanceBeforeTransaction.equals("")) {
								sAfterTransBalance = getElementText("Corporate Account Transfer", "Current Balance", currentBalance);
								sAfterTransBalance = sAfterTransBalance.replace("$", "");
								sAfterTransBalance = sAfterTransBalance.replace(",", "");
								iAfterTransAccountBalance =  Double.parseDouble(sAfterTransBalance);
								balanceBeforeTransaction = balanceBeforeTransaction.replace("$", "");
								balanceBeforeTransaction = balanceBeforeTransaction.replace(",", "");
								iInitialBalance =  Double.parseDouble(balanceBeforeTransaction);
								amount = amount.replace("$", "");
								amount = amount.replace(",", "");
								totalAmount =  Double.parseDouble(amount);
								if(iInitialBalance - totalAmount == iAfterTransAccountBalance ) {
									stepResult = true;
								}
							}
						}else if(currentDate.compareTo(date) < 0){
							sAfterTransBalance = getElementText("Corporate Account Transfer", "Current Balance", currentBalance);
							sAfterTransBalance = sAfterTransBalance.replace("$", "");
							sAfterTransBalance = sAfterTransBalance.replace(",", "");
							iAfterTransAccountBalance = Double.parseDouble(sAfterTransBalance);
							balanceBeforeTransaction = balanceBeforeTransaction.replace("$", "");
							balanceBeforeTransaction = balanceBeforeTransaction.replace(",", "");
							iInitialBalance =  Double.parseDouble(balanceBeforeTransaction);
							System.out.println("Future date");
							if(iInitialBalance == iAfterTransAccountBalance ) {
								stepResult = true;
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- to acc");
					new HTMLReportHelper().HtmlReportBody("Account balance after transaction", "Account balance after transaction verified successfully", "Passed", driver, "Y");

				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Account balance after transaction", "Could not verify account balance after Transaction successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyTransactinSearch(String fromAccountNumber,String fromDateField,String toDateField,
			String fromAmtField,String toAmtField,String memoReview) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accountTransactionHeader)) {
					if(!fromAccountNumber.equals("")){
						waitElement(2000);
						clearAndType("Corporate Account Transfer", "Account Number", transactionSearchAccNum, fromAccountNumber);
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Account Number", getDynamicElement("Account Number", fromAccList, fromAccountNumber));
						waitElement(2000);
						clickOnElement("Corporate Account Transfer", "Search button", transSearchButton);
						waitElement(2000);
					}
					if (!fromDateField.equals("")) {
						waitElement(2000);
						enterFromDate(fromDateField);
					}
					if (!toDateField.equals("")) {
						waitElement(2000);
						enterToDate(toDateField);
					}
					if (!fromAmtField.equals("")) {
						waitElement(2000);
						clearAndType("Corporate Account Transfer", "From Account Amount", transactionFromAmtField, fromAmtField);
					}
					if (!toAmtField.equals("")) {
						waitElement(2000);
						clearAndType("Corporate Account Transfer", "To Account Amount", transactionToAmtField, toAmtField);
					}
					clickOnElement("Corporate Account Transfer", "Search button", transSearchButton);
					isElementPresent(showingTransactions);
					verifySearchData(memoReview);
					stepResult = true;
				}
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- to acc");
					new HTMLReportHelper().HtmlReportBody("Verify the transaction search", "Verify the transaction search is successfully", "Passed", driver, "Y");

				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Verify the transaction search", "Could not verify the transaction search successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void enterFromDate(String fromDateField) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!fromDateField.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(fromDate).sendKeys(Keys.BACK_SPACE);
					}
					enterText("Corporate Account Transfer", "From Date", fromDate, fromDateField);
					clickOnElement("Corporate Account Transfer", "From Date Title", amountfield);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void enterToDate(String toDateField) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!toDateField.equals("")) {
					for (int i = 1; i <= 10; i++) {
						driver.findElement(toDate).sendKeys(Keys.BACK_SPACE);
					}
					enterText("Corporate Account Transfer", "From Date", toDate, toDateField);
					driver.findElement(toDate).sendKeys(Keys.ENTER);
					//clickOnElement("Corporate Account Transfer", "From Date Title", amountfield);
				}
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void verifySearchData(String memoReview) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (!memoReview.equals("")) {
					getDynamicElement("Transaction Search", memoReviewField, memoReview);
					stepResult = true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass -- transfer date");
				}
				else{
					System.out.println("fail");
					System.setProperty("runStep","N");
				}
			}
		}
	}




}
