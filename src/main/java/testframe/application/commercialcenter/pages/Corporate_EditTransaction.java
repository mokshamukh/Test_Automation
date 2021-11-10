package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_EditTransaction
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_EditTransaction extends CommonLibrary {

	By editTransactionTitle = By.xpath("//h1[contains(text(),'Edit')]");
	By fromAccountField = By.xpath("(//input[@id='fromAccount'])[1]");
	By fromAccountAmt = By.xpath("(//input[@id='fromAmount'])[1]");
	By toAccountField = By.xpath("//input[@id='toAccount0']");
	By toAccPayInstruction = By.xpath("(//p-dropdown[@formcontrolname='toPaymentInstruction']//span)[2]");
	By reqTransferButton = By.xpath("//button[@aria-label='Request Transfer']");
	By transferDateTitle = By.xpath("//h3[contains(text(),'Transfer Details')]");
	By accTransferDeatilsTitle = By.xpath("//h3[text()='Account Transfer Details']");
	By paymentInstructionTitle = By.xpath("//th[text()='Payment Instruction']");
	By fromAccVerify = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1]/span)[1]");
	By toAccVerify = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[2]/span)[1]");
	By toAccMemoVerify = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3])[1]");
	By toAccPayInstr = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[1]");
	By amountVerify = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[1]");
	By amtVerify = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[5])[1]");
	By closeButton = By.xpath("//button[text()='Close']");
	By editFromAccountAmt1 = By.xpath("(//input[@id='fromAmount'])[2]");
	By editFromAccountAmt2 = By.xpath("(//input[@id='fromAmount'])[3]");
	By editFromAccountAmt3 = By.xpath("(//input[@id='fromAmount'])[4]");
	By editFromAccMemo = By.xpath("(//input[@id='fromMemo'])[1]");
	By editFromAccountMemo = By.xpath(
			"//label[@class='d-lg-none'][text()='From Account']/../../../..//button[contains(@aria-label,'add account')]/parent::div/preceding-sibling::div[1]//input[@id='fromMemo']");
	By editAddAccount_frmAcc = By.xpath(
			"//label[@class='d-lg-none'][text()='From Account']/../../../..//button[@aria-label='Click to add account']");
	By addAccount_toAcc = By.xpath(
			"//label[@class='d-lg-none'][text()='To Account']/../../../..//button[@aria-label='Click to add account']");
	By editToAccField1 = By.xpath("//input[@id='toAccount1']");
	By editToAccField2 = By.xpath("//input[@id='toAccount2']");
	By editToAccField3 = By.xpath("//input[@id='toAccount3']");
	By editToAccPayInstruction1 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])");
	By editToAccPayInstruction2 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[2]");
	By editToAccPayInstruction3 = By.xpath("(//p-dropdown[@inputid='toPaymentInstruction']//span[text()='Select'])[3]");

	String paymentInstrField = "//li[@role='option']/span[text()='%s']";
	By transferDate = By.xpath("//input[@id='transferDate']");
	String amt, memo;

	public Corporate_EditTransaction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void editFromAccount(String fromAcc, String fromAccAmt) {
		boolean stepResult = false;
		try {
			Thread.sleep(8000);
			if (isElementPresent(editTransactionTitle)) {
				clearAndType("Corporate Edit Transaction", "From Account", fromAccountField, fromAcc);
				if (!fromAccAmt.equals("")) {
					Thread.sleep(2000);
					clearAndType("Corporate Edit Transaction", "From Account Amount", fromAccountAmt, fromAccAmt);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Edit From acc field Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not Edit From acc field Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void enterToAccount(String toAcc, String toAccAmt, String toAccAmtVal, String toAccMemo, String toAccMemoVal,
			String toAccPayInstr) {
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
			if (isElementPresent(editTransactionTitle)) {
				if (!toAcc.equals("")) {
					enterText("Corporate Edit Transaction", "To Account", toAccountField, toAcc);
				}
				if (!toAccAmt.equals("")) {
					Thread.sleep(2000);
					enterText("Corporate Edit Transaction", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(toAccAmt)), toAccAmtVal);
				}
				if (!toAccMemo.equals("")) {
					Thread.sleep(2000);
					clearAndType("Corporate Edit Transaction", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo)), toAccMemoVal);
					/*
					 * enterText("Corporate Edit Transaction",
					 * "To Account Memo", returnByElement("To Account Memo",
					 * getToAccMemo(toAccMemo)), toAccMemoVal);
					 */
				}
				if (!toAccPayInstr.equals("")) {
					Thread.sleep(4000);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction", toAccPayInstruction);
					Thread.sleep(4000);
					getDynamicElementClick("Corporate Edit Transaction", "To Account Payment Instruction",
							paymentInstrField, toAccPayInstr);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Edit Acc Transfer - enter to acc");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Edit to acc field Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not to From acc field Successfully", "Failed", driver, "Y");
			}
		}
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

	public void enterTransferDate(String transferDates) {
		boolean stepResult = false;
		try {
			Thread.sleep(2000);
			if (!transferDates.equals("")) {
				for (int i = 1; i <= 10; i++) {
					driver.findElement(transferDate).sendKeys(Keys.BACK_SPACE);
				}
				Thread.sleep(7000);
				enterText("Corporate Edit Transaction", "Transfer Date", transferDate, transferDates);
				clickOnElement("Corporate Edit Transaction", "Transfer Date Title", transferDateTitle);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Acc Transfer -- transfer date");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Edit transfer date Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not Edit transfer date Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickReqTransfer() {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(editTransactionTitle)) {
				doubleClickOnElement("Corporate Edit Transaction", "Transfer Date", reqTransferButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Acc Transfer - req button");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Click tranfer request Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not Click tranfer request Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void verifyAccountTransferDetails(String fromAcc_verify, String toAcc_verify, String memo_verify,
			String payInstr_verify, String amt_verify) {
		boolean stepResult = false;
		try {
			if (isElementPresent(accTransferDeatilsTitle)) {
				clickOnElement("Account Transfer Review", "Account Review Title", accTransferDeatilsTitle);
				if (!fromAcc_verify.equals("")) {
					validateElementExist("Account Transfer Review", "fromAcc Verify", fromAccVerify, fromAcc_verify);
				}
				if (!toAcc_verify.equals("")) {
					validateElementExist("Account Transfer Review", "toAcc Verify", toAccVerify, toAcc_verify);
				}
				if (!memo_verify.equals("")) {
					validateElementExist("Account Transfer Review", "toAccMemo Verify", toAccMemoVerify, memo_verify);
				}
				if (!payInstr_verify.equals("")) {
					validateElementExist("Account Transfer Review", "toAccMemo Verify", toAccPayInstr, payInstr_verify);
				}
				if (!amt_verify.equals("")) {
					if (isElementPresent(paymentInstructionTitle)) {
						validateElementExist("Account Transfer Review", "amt verify", amtVerify, amt_verify);
					} else {
						validateElementExist("Account Transfer Review", "amt verify", amountVerify, amt_verify);
					}

				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Acc Transfer Verify");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"verify edited acc transfer details Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not verify edited acc transfer details Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void editAddAndEnterFromAccDetails(String editAddFromAccountVal1, String editFromAcMemo, String editFromAcc1,
			String editFromAccAmt1, String editFromAccMemo1, String editAddFromAccountVal2, String editFromAcc2,
			String editFromAccAmt2, String editFromAccMemo2, String editAddFromAccountVal3, String editFromAcc3,
			String editFromAccAmt3, String editFromAccMemo3) {
		boolean stepResult = false;
		try {
			if (editAddFromAccountVal1.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "From Account1", editAddAccount_frmAcc);
				if (!editFromAcMemo.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Memo", editFromAccMemo, editFromAcMemo);
				}
				if (!editFromAcc1.equals("")) {
					enterText("Corporate Edit Transaction", "From Account1", fromAccountField, editFromAcc1);
				}
				if (!editFromAccAmt1.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Amount", editFromAccountAmt1,
							editFromAccAmt1);
				}
				if (!editFromAccMemo1.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Memo", editFromAccountMemo, editFromAccMemo1);
				}

			}
			if (editAddFromAccountVal2.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "From Account2", editAddAccount_frmAcc);
				if (!editFromAcc2.equals("")) {
					enterText("Corporate Edit Transaction", "From Account2", fromAccountField, editFromAcc2);
				}
				if (!editFromAccAmt2.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Amount", editFromAccountAmt2,
							editFromAccAmt2);
				}
				if (!editFromAccMemo2.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Memo", editFromAccountMemo, editFromAccMemo2);
				}
			}
			if (editAddFromAccountVal3.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "From Account3", editAddAccount_frmAcc);
				if (!editFromAcc3.equals("")) {
					enterText("Corporate Edit Transaction", "From Account3", fromAccountField, editFromAcc3);
				}
				if (!editFromAccAmt3.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Amount", editFromAccountAmt3,
							editFromAccAmt3);
				}
				if (!editFromAccMemo3.equals("")) {
					enterText("Corporate Edit Transaction", "From Account Memo", editFromAccountMemo, editFromAccMemo3);
				}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Acc Transfer");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"verify edited mutliple from acc transfer  Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not verify edited multiple from acc transfer Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void editAddAndEnterToAccDetails(String editAddToAccountVal1, String editToAcc1, String editToAccAmt1,
			String toAccAmtVal1, String toAccMemo1, String editToAccMemoVal1, String editToAccPayInstr1,
			String editAddToAccountVal2, String editToAcc2, String editToAccAmt2, String toAccAmtVal2,
			String toAccMemo2, String editToAccMemoVal2, String editToAccPayInstr2, String editAddToAccountVal3,
			String editToAcc3, String editToAccAmt3, String toAccAmtVal3, String toAccMemo3, String editToAccMemoVal3,
			String editToAccPayInstr3) {
		boolean stepResult = false;
		try {
			if (editAddToAccountVal1.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "Add Account1", addAccount_toAcc);
				if (!editToAcc1.equals("")) {
					enterText("Corporate Edit Transaction", "To Account1", editToAccField1, editToAcc1);
				}
				if (!editToAccAmt1.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(editToAccAmt1)), toAccAmtVal1);
				}
				if (!editToAccMemoVal1.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo1)), editToAccMemoVal1);
				}
				if (!editToAccPayInstr1.equals("")) {
					Thread.sleep(2000);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction1",
							editToAccPayInstruction1);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction1",
							getDynamicElement("To Account Payment Instruction", paymentInstrField, editToAccPayInstr1));
				}
			}
			if (editAddToAccountVal2.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "Add Account1", addAccount_toAcc);
				if (!editToAcc2.equals("")) {
					enterText("Corporate Edit Transaction", "From Account2", editToAccField2, editToAcc2);
				}
				if (!editToAccAmt2.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(editToAccAmt2)), toAccAmtVal2);
				}
				if (!editToAccMemoVal2.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo2)), editToAccMemoVal2);
				}
				if (!editToAccPayInstr2.equals("")) {
					Thread.sleep(2000);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction2",
							editToAccPayInstruction2);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction2",
							getDynamicElement("To Account Payment Instruction", paymentInstrField, editToAccPayInstr2));
				}
			}
			if (editAddToAccountVal3.equals("Yes")) {
				clickOnElement("Corporate Edit Transaction", "Add Account1", addAccount_toAcc);
				if (!editToAcc3.equals("")) {
					enterText("Corporate Edit Transaction", "To Account3", editToAccField3, editToAcc3);
				}
				if (!editToAccAmt3.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Amount",
							returnByElement("To Account Amount", getToAccAmt(editToAccAmt3)), toAccAmtVal3);
				}
				if (!editToAccMemoVal3.equals("")) {
					enterText("Corporate Edit Transaction", "To Account Memo",
							returnByElement("To Account Memo", getToAccMemo(toAccMemo3)), editToAccMemoVal3);
				}
				if (!editToAccPayInstr3.equals("")) {
					Thread.sleep(2000);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction3",
							editToAccPayInstruction3);
					clickOnElement("Corporate Edit Transaction", "To Account Payment Instruction3",
							getDynamicElement("To Account Payment Instruction", paymentInstrField, editToAccPayInstr3));
				}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Acc Transfer");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"verify edited mutliple to acc transfer  Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Edit Account Transaction CC- Corporate application",
						"Could not verify edited multiple to acc transfer Successfully", "Failed", driver, "Y");
			}
		}

	}

}
