package testframe.application.commercialcenter.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_AccountTransferDetails
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_AccountTransferDetails extends CommonLibrary {

	By accountTransferDetailsTitle = By.xpath("//h3[text()='Account Transfer Details']");
	By accStatus = By.xpath("//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[3]");
	By transID1 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6])[1]");
	By transID2 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6])[2]");
	By transID3 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6])[3]");
	By transID4 = By.xpath("(//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6])[4]");
	
	By transacID  = By.xpath("//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td");
	public String transactionID;
	//, transactionID1, transactionID2, transactionID3;
	
	
	public Corporate_AccountTransferDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyAccStatus(String accountStatus) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
		boolean stepResult = false;
		try {
			if (isElementPresent(accountTransferDetailsTitle)) {
				if (!accStatus.equals("")) {
					validateElementExist("Account Transfer Details", "accStatus", accStatus, accountStatus);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass - Acc Transfer Review");
			new HTMLReportHelper().HtmlReportBody("verify account status", "verify account status successfully", "Passed", driver, "Y");
		}
		else{
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("verify account status", "Could not verify account status successfully", "Failed", driver, "Y");
			System.setProperty("runStep","N");
		}
		}
		}
	}
	

	public String getAccTransaction() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
		boolean stepResult = false;
		try {
			if (isElementPresent(accountTransferDetailsTitle)) {
				List<WebElement> element = findElements(transacID);
				for (WebElement ele : element) {
					if(ele.getText().contains("ATR-")){
						transactionID = ele.getText();
					}
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass. Transaction Id is : " + transactionID);
			new HTMLReportHelper().HtmlReportBody("Captured transactionId ", "get transactionId successfully", "Passed", driver, "Y");
		}
		else{
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Captured transactionId", "Could not get transactionId successfully", "Failed", driver, "Y");
			System.setProperty("runStep","N");
		}
		}
	}
		return transactionID;

	}

	public String getMultiAccTransaction(String field, String field1, String field2, String field3) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
		boolean stepResult = false;
		try {
			if (isElementPresent(accountTransferDetailsTitle)) {
				if (!field.equals("")) {
					transactionID = getElementText("Account Transfer Details", "Transaction Details", transID1);
				}
				if (!field1.equals("")) {
					transactionID = getElementText("Account Transfer Details", "Transaction Details", transID2);
				}
				if (!field2.equals("")) {
					transactionID = getElementText("Account Transfer Details", "Transaction Details", transID3);
				}
				if (!field3.equals("")) {
					transactionID = getElementText("Account Transfer Details", "Transaction Details", transID4);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass.Multi Transaction Id is : " + transactionID);
				new HTMLReportHelper().HtmlReportBody("get multiple transactionId", "get multiple transactionId successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("get multiple transactionId", "Could not get multiple transactionId successfully", "Failed", driver, "Y");
				System.setProperty("runStep","N");
			}
			}
		
		}
		return transactionID;

	}

	public String getTransactionID(String field) {
		switch (field) {
		case "Checking":
			transactionID = "//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6]";
			break;
		case "Saving":
			transactionID = "//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[7]";
			break;
		case "Loan":
			transactionID = "//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[7]";
			break;
		case "Money Market":
			transactionID = "//td[@class='bordered-last-column']/../../preceding-sibling::tbody/tr/td[6]";
			break;

		default:
			break;
		}
		return transactionID;

	}

}
