package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_AccountTransferReview
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_AccountTransferReview extends CommonLibrary {

	By fromAcc_review = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1]/span)[1]");
	By toAcc_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[2]/span)[1]");
	By toAccMemo_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3])[1]");
	By toAccPayInstr = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[1]");
	By amount_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[1]");
	By amt_review = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[5])[1]");
	By fromAcc_review1 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1]/span)[2]");
	By toAcc_review1 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[2]/span)[2]");
	By toAccMemo_review1 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3])[2]");
	By toAccPayInstr1 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[2]");
	By amount_review1 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[2]");
	By amt_review1 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[5])[2]");
	By fromAcc_review2 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1]/span)[3]");
	By toAcc_review2 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[2]/span)[3]");
	By toAccMemo_review2 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3])[3]");
	By toAccPayInstr2 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[3]");
	By amount_review2 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[3]");
	By amt_review2 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[5])[3]");
	By fromAcc_review3 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[1]/span)[4]");
	By toAcc_review3 = By
			.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[2]/span)[4]");
	By toAccMemo_review3 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3])[4]");
	By toAccPayInstr3 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[4]");
	By amount_review3 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[4])[4]");
	By amt_review3 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[5])[4]");
	By confirmButton = By.xpath("//button[text()='Confirm']");
	By cancelButton = By.xpath("//button[text()='Cancel']");
	By editButton = By.xpath("//button[text()='Edit']");
	By accTransferReviewTitle = By.xpath("//h3[text()='Please confirm this transfer']");
	By paymentInstructionTitle = By.xpath("//th[text()='Payment Instruction']");
	By fromAccountTitle = By.xpath("//th[text()='From Account']");

	public Corporate_AccountTransferReview(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyAccDetails(String fromAccReview, String toAccReview, String memoReview, String payInstrReview,
			String amtReview) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(accTransferReviewTitle)) {
					clickOnElement("Account Transfer Review", "Account Review Title", accTransferReviewTitle);
					if (!fromAccReview.equals("")) {
						clickOnElement("Account Transfer Review", "fromAcc_review title", fromAccountTitle);
						validateElementExist("Account Transfer Review", "fromAcc_review", fromAcc_review, fromAccReview);
					}
					if (!toAccReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAcc_review", toAcc_review, toAccReview);
					}
					if (!memoReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccMemo_review, memoReview);
					}
					if (!payInstrReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccPayInstr, payInstrReview);
					}
					if (!amtReview.equals("")) {
						if (isElementPresent(paymentInstructionTitle)) {
							validateElementExist("Account Transfer Review", "amt_review", amt_review, amtReview);
						} else {
							validateElementExist("Account Transfer Review", "amt_review", amount_review, amtReview);
						}

					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - verify acc details");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"verify account details Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"Could not verify account details Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void verifyMultipleAccDetails(String fromAccReview, String toAccReview, String memoReview,
			String payInstrReview, String amtReview, String fromAccReview1, String toAccReview1, String memoReview1,
			String payInstrReview1, String amtReview1, String fromAccReview2, String toAccReview2, String memoReview2,
			String payInstrReview2, String amtReview2, String fromAccReview3, String toAccReview3, String memoReview3,
			String payInstrReview3, String amtReview3) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(accTransferReviewTitle)) {
					if (!fromAccReview.equals("")) {
						validateElementExist("Account Transfer Review", "fromAcc_review", fromAcc_review, fromAccReview);
					}
					if (!toAccReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAcc_review", toAcc_review, toAccReview);
					}
					if (!memoReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccMemo_review, memoReview);
					}
					if (!payInstrReview.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccPayInstr, payInstrReview);
					}
					if (!amtReview.equals("")) {
						if (isElementPresent(toAccPayInstr)) {
							validateElementExist("Account Transfer Review", "amt_review", amt_review, amtReview);
						} else {
							validateElementExist("Account Transfer Review", "amt_review", amount_review, amtReview);
						}

					}
					if (!fromAccReview1.equals("")) {
						validateElementExist("Account Transfer Review", "fromAcc_review", fromAcc_review1, fromAccReview1);
					}
					if (!toAccReview1.equals("")) {
						validateElementExist("Account Transfer Review", "toAcc_review", toAcc_review1, toAccReview1);
					}
					if (!memoReview1.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccMemo_review1, memoReview1);
					}
					if (!payInstrReview1.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccPayInstr1,
								payInstrReview1);
					}
					if (!amtReview1.equals("")) {
						if (isElementPresent(toAccPayInstr)) {
							validateElementExist("Account Transfer Review", "amt_review", amt_review1, amtReview1);
						} else {
							validateElementExist("Account Transfer Review", "amt_review", amount_review1, amtReview1);
						}

					}

					if (!fromAccReview2.equals("")) {
						validateElementExist("Account Transfer Review", "fromAcc_review", fromAcc_review2, fromAccReview2);
					}
					if (!toAccReview2.equals("")) {
						validateElementExist("Account Transfer Review", "toAcc_review", toAcc_review2, toAccReview2);
					}
					if (!memoReview2.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccMemo_review2, memoReview2);
					}
					if (!payInstrReview2.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccPayInstr2,
								payInstrReview2);
					}
					if (!amtReview2.equals("")) {
						if (isElementPresent(toAccPayInstr)) {
							validateElementExist("Account Transfer Review", "amt_review", amt_review2, amtReview2);
						} else {
							validateElementExist("Account Transfer Review", "amt_review", amount_review2, amtReview2);
						}

					}

					if (!fromAccReview3.equals("")) {
						validateElementExist("Account Transfer Review", "fromAcc_review", fromAcc_review3, fromAccReview3);
					}
					if (!toAccReview3.equals("")) {
						validateElementExist("Account Transfer Review", "toAcc_review", toAcc_review3, toAccReview3);
					}
					if (!memoReview3.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccMemo_review3, memoReview3);
					}
					if (!payInstrReview3.equals("")) {
						validateElementExist("Account Transfer Review", "toAccMemo_review", toAccPayInstr3,
								payInstrReview3);
					}
					if (!amtReview3.equals("")) {
						if (isElementPresent(toAccPayInstr)) {
							validateElementExist("Account Transfer Review", "amt_review", amt_review3, amtReview3);
						} else {
							validateElementExist("Account Transfer Review", "amt_review", amount_review3, amtReview3);
						}

					}

					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Multi  Acc Transfer Review");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"verify multiple account details Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"Could not verify multiple account details Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickConfirmButton() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				clickOnElement("Corporate Account Transfer Review", "Confirm Button", confirmButton);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - Acc Transfer review confirm");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"click confirm button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Account Transfer Review CC- Corporate application",
							"Could not click confirm button Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
}
