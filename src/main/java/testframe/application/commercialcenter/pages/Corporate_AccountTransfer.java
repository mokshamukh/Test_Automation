package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_CorporateAccountTransfer
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_AccountTransfer extends CommonLibrary {

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
	// By daily_EachBusiDay =
	// By.xpath("//p-radiobutton[@formcontrolname='everyDay']/div/div/input[@id='opt1']");
	// By daily_SpeciDay =
	// By.xpath("//p-radiobutton[@formcontrolname='everyDay']/div/div/input[@id='opt2']");
	
	String freq = "//ul[@class='nav nav-pills flex-column']/li/a[@id='%s']";
	String daily_opt = "//label[contains(text(),'%s')]/preceding-sibling::div/div/span";
	String daily_subOpt = "//label[text()='%s']/..//p-checkbox/div//input";
	String daily_subOptions = "//span[@class='ui-chkbox-icon ui-clickable']/../preceding-sibling::div/../..//label[contains(text(),'%s')]";
	String accList = "//ul[@role='listbox']/li/span[text()='%s']";
	String paymentInstrField = "(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[1]/parent::div/following-sibling::div//span[text()='%s']";
	String durationOpt = "//p-radiobutton[@name='duration']/label[contains(text(),'%s')]/preceding-sibling::div/div[@role='radio']";
	String daysOfWeek = "//label[text()='%s']/../div[@class='ui-radiobutton ui-widget']";
	
	
	String memo;
	String amt;

	public Corporate_AccountTransfer(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFromAccount(String fromAcc, String fromAccAmt) {
		boolean stepResult = false;
		try {
			Thread.sleep(8000);
			if (isElementPresent(accountTransferTitle)) {
				scrollToElement(fromAccountField);
				enterText("Corporate Account Transfer", "From Account", fromAccountField, fromAcc);
				if (!fromAccAmt.equals("")) {
					Thread.sleep(2000);
					enterText("Corporate Account Transfer", "From Account Amount", fromAccountAmt, fromAccAmt);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - From acc");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter From acc field Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter From acc field Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void addAndEnterFromAccDetails(String addFromAccountVal1, String fromAcMemo, String fromAcc1,
			String fromAccAmt1, String fromAccMemo1, String addFromAccountVal2, String fromAcc2, String fromAccAmt2,
			String fromAccMemo2, String addFromAccountVal3, String fromAcc3, String fromAccAmt3, String fromAccMemo3) {
		boolean stepResult = false;
		try {
			if (addFromAccountVal1.equals("Yes")) {
				clickOnElement("Corporate Account Transfer", "From Account1", addAccount_frmAcc);
				if (!fromAcMemo.equals("")) {
					enterText("Corporate Account Transfer", "From Account Memo", fromAccMemo, fromAcMemo);
				}
				if (!fromAcc1.equals("")) {
					enterText("Corporate Account Transfer", "From Account1", fromAccountField, fromAcc1);
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter multiple from acc field Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter multiple from acc field Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void enterToAccount(String toAcc, String toAccAmt, String toAccAmtVal, String toAccMemo, String toAccMemoVal,
			String toAccPayInstr) {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(accountTransferTitle)) {
				if(!toAcc.equals("")){
				enterText("Corporate Account Transfer", "To Account", toAccountField, toAcc);
				}
				if (!toAccAmt.equals("")) {
					Thread.sleep(2000);
					enterText("Corporate Account Transfer", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(toAccAmt)), toAccAmtVal);
				}
				if (!toAccMemo.equals("")) {
					Thread.sleep(2000);
					enterText("Corporate Account Transfer", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo)), toAccMemoVal);
				}
				if (!toAccPayInstr.equals("")) {
					Thread.sleep(4000);
					clickOnElement("Corporate Account Transfer", "To Account Payment Instruction", toAccPayInstruction);
					Thread.sleep(4000);
					getDynamicElementClick("Corporate Account Transfer", "To Account Payment Instruction", paymentInstrField, toAccPayInstr);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass -- to acc");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter to acc field Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter to acc field Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void addAndEnterToAccDetails(String addToAccountVal1, String toAcc1, String toAccAmt1, String toAccAmtVal1,
			String toAccMemo1, String toAccMemoVal1, String toAccPayInstr1, String addToAccountVal2, String toAcc2,
			String toAccAmt2, String toAccAmtVal2, String toAccMemo2, String toAccMemoVal2, String toAccPayInstr2,
			String addToAccountVal3, String toAcc3, String toAccAmt3, String toAccAmtVal3, String toAccMemo3,
			String toAccMemoVal3, String toAccPayInstr3) {
		boolean stepResult = false;
		try {
			if (addToAccountVal1.equals("Yes")) {
				clickOnElement("Corporate Account Transfer", "Add Account1", addAccount_toAcc);
				if (!toAcc1.equals("")) {
					enterText("Corporate Account Transfer", "To Account1", toAccField1, toAcc1);
				}
				if (!toAccAmt1.equals("")) {
					enterText("Corporate Account Transfer", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(toAccAmt1)), toAccAmtVal1);
				}
				if (!toAccMemoVal1.equals("")) {
					enterText("Corporate Account Transfer", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo1)), toAccMemoVal1);
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
				}
				if (!toAccAmt2.equals("")) {
					enterText("Corporate Account Transfer", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(toAccAmt2)), toAccAmtVal2);
				}
				if (!toAccMemoVal2.equals("")) {
					enterText("Corporate Account Transfer", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo2)), toAccMemoVal2);
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
				}
				if (!toAccAmt3.equals("")) {
					enterText("Corporate Account Transfer", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(toAccAmt3)), toAccAmtVal3);
				}
				if (!toAccMemoVal3.equals("")) {
					enterText("Corporate Account Transfer", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo3)), toAccMemoVal3);
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter multiple to acc field Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter multiple to acc field Successfully", "Failed", driver, "Y");
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

	public void enterTransferDate(String transferDates) {
		boolean stepResult = false;
		try {
			Thread.sleep(2000);
			if (!transferDates.equals("")) {
				for (int i = 1; i <= 10; i++) {
					driver.findElement(transferDate).sendKeys(Keys.BACK_SPACE);
				}
				Thread.sleep(7000);
				enterText("Corporate Account Transfer", "Transfer Date", transferDate, transferDates);
				clickOnElement("Corporate Account Transfer", "Transfer Date Title", transferDateTitle);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass -- transfer date");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter transfer date field Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter transfer date field Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickReqTransfer() {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(accountTransferTitle)) {
				doubleClickOnElement("Corporate Account Transfer", "Transfer Date", reqTransferButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - click transfer req");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Click transfer Request Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Click transfer Request Successfully", "Failed", driver, "Y");
			}
		}
	}

	/*
	 Freq : Daily,Weekly,Bi-Weekly,Semi-Monthly,Monthly,Anually 
	 Daily opt :Business, Specific Daily 
	 Sub Opt : Select All, Monday,Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
	
	
	 */
	public void selectRecurringOption(String recurringOpt, String frequency, String dailyopt, String dailySubOpt,String day) {
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Select recurring option Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Select recurring option Successfully", "Failed", driver, "Y");
			}
		}
	}

	// Duration :Indefinitely,Until End Date,Fixed Number
	public void selectDuration(String duration, String transDate, String fixedNumTrans) {
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Select duration option Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Select duration option Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void enterSeriesDetails(String seriesDate){
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter series date Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter series date Successfully", "Failed", driver, "Y");
			}
		}

	}
	
	public void clickRecurringOptButton(){
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Click save button Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Click save button Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void enterSeriesName(String name){
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
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Enter series name Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Transfer CC- Corporate application", "Could not Enter series name Successfully", "Failed", driver, "Y");
			}
		}
	}
	
}
