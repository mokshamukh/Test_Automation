package testframe.application.commercialcenter.pages;

import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_FuturePaymentActivity
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_FuturePaymentActivity extends CommonLibrary {

	By searchButton = By.xpath("//button[@aria-label='Search']");
	By futureTitle = By.xpath("//h1[text()='Future']");
	By importFileText = By.xpath("//input[@id='importFile']");
	By searchSymbol = By.xpath("//button[@type='submit']");
	By productDropArrow = By
			.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[1]");
	By incTransDropArrow = By
			.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[2]");
	By entryMethodDropArrow = By
			.xpath("(//span[contains(@class,'ui-dropdown-trigger-icon ui-clickable material-icons expand_more')])[3]");

	By approveButton = By.xpath("//div[contains(@class,' btn-next-cancel ng-star-inserted')]/button[3]");
	By ApproveTitle = By.xpath("//h4[contains(text(),'Approve Payment')]");
	By rejectButton = By.xpath("//div[contains(@class,' btn-next-cancel ng-star-inserted')]/button[4]");
	By rejectPaymentTitle = By.xpath("//label[contains(text(),'Enter the rejection reason for payment :')]");
	By rejectTextbox = By.xpath("//input[@formcontrolname='rejectReason']");
	By msgButton = By.xpath("//div[@id='modalFooter']/div/button[text()='%s']");

	String productList = "//li[@role='option']/span[text()='%s']";

	String includedTrans = "//li[contains(@class,'ui-dropdown-item ui-corner-all')]/span[contains(text(),'%s')]";
	String entryMethodList = "//li[contains(@class,'ui-dropdown-item ui-corner-all')]/span[contains(text(),'%s')]";
	String dropdown = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td[contains(@class,'edit-splitter')]//i[text()='mode_edit']";
	String date = "(//td[@data-date='%s'])[2]/span";
	// String transactionLink = "//td/a[@title='%s']";
	String transactionLink = "//a[text()='%s']";
	String activityType = "//nav[@id='navbarNav']//li/a[@title='%s']";
	String rightClickArrow = "//div[contains(@class,'tranIdLable')]/span[contains(text(),'%s')]/../../following-sibling::td/button[@aria-label='Click To View']";
	String approvePaymentButton = "//button[text()='%s']";
	public Corporate_FuturePaymentActivity(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void filterTransaction(String transactionID, String seriesName, String product, String inclTrans,
			String entryMethod, String importFile) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(futureTitle)) {
				clickOnElement("Future Payment Activity", "Search Button", searchButton);
				if (!product.equals("")) {
					selectElementFromListbox("Future Payment Activity", "Product List", productDropArrow, productList,
							product);
				}
				if (!inclTrans.equals("")) {
					selectElementFromListbox("Future Payment Activity", "Included Transaction List", incTransDropArrow,
							includedTrans, inclTrans);
				}
				if (!entryMethod.equals("")) {
					selectElementFromListbox("Future Payment Activity", "Entry Method List", entryMethodDropArrow,
							entryMethodList, entryMethod);
				}
				if (!importFile.equals("")) {
					enterText("Future Payment Activity", "Import File Field", importFileText, importFile);
				}
				clickOnElement("Future Payment Activity", "Search Symbol", searchSymbol);
				Thread.sleep(6000);
				if (!seriesName.equals("")) {
					getDynamicElementClick("Future Payment Activity", "Select Series Name", transactionLink,
							seriesName);
				} else {
					if (!transactionID.equals("")) {
						getDynamicElementClick("Future Payment Activity", "Select Transaction Link", transactionLink,
								transactionID);
					}
				}
				Thread.sleep(5000);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Future Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Filter transactions Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not Filter transactions Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void editPaymentActivity(String transactionID, String seriesName) throws Exception {
		boolean stepResult = false;
		try {
			if (!seriesName.equals("")) {
				getDynamicElementClick("Future Payment Activity", "Edit Transaction", dropdown, seriesName);
			} else {
				if (!transactionID.equals("")) {
					getDynamicElementClick("Future Payment Activity", "Edit Transaction", dropdown, transactionID);
				}
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Future Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Edit transaction Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not Edit transaction Successfully", "Failed", driver, "Y");
			}
		}
	}

	public String convertDate(String date) {
		String newDate = null;
		String[] d = date.split("/");
		newDate = d[2] + "-" + d[0] + "-" + d[1];
		System.out.println(newDate);
		return newDate;
	}

	public void selectPaymentActivityTab(String activityTab) throws Exception {
		boolean stepResult = false;
		try {
			if (!activityTab.equals("")) {
				getDynamicElementClick("Future Payment Activity", "Edit Transaction", activityType, activityTab);
			}

			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass -  Payment Activity - Select tab");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Payment Activity Tab selected Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not selected Payment Activity Tab Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickOnRightArrow(String transactionID) throws Exception {
		boolean stepResult = false;
		try {
			if (!transactionID.equals("")) {
				getDynamicElementClick("Future Payment Activity", "Click right Arrow", rightClickArrow, transactionID);
			}

			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Future Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Click on right arrow to view transaction Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not Click on right arrow to view transaction Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void clickApproveButton(String approvePaymentValue) throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Future Payment Activity CC- Corporate application", "Approve Button", approveButton);
			if (isElementPresent(ApproveTitle)) {
				getDynamicElementClick("Future Payment Activity CC- Corporate application", "Approve Payment", approvePaymentButton, approvePaymentValue);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Future Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Click on right arrow to view transaction Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not Click on right arrow to view transaction Successfully", "Failed", driver, "Y");
			}
		}

	}

	public void clickRejectButton(String rejectReason) throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Future Payment Activity CC- Corporate application", "Reject Button", rejectButton);
			if (isElementPresent(rejectPaymentTitle)) {
				enterText("Future Payment Activity CC- Corporate application", "Reject Payment", rejectTextbox,
						rejectReason);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Future Payment Activity - Filter data");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Click on right arrow to view transaction Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not Click on right arrow to view transaction Successfully", "Failed", driver, "Y");
			}
		}

	}
	
	public void verifyRjectedMsg(String transactionID) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
			String rejectPaymentMsg = "//div[text()='The payment "+transactionID+" has been successfully rejected.']";
			isElementPresent(returnByElement("Rejected Payment alert Msg", rejectPaymentMsg));
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass -Future Payment Activity - Reject Payment Msg");
			new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
					"verify rejected msg Successfully", "Passed", driver, "Y");}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Future Payment Activity CC- Corporate application",
						"Could not verify rejected msg  Successfully", "Failed", driver, "Y");
			}
		}
	}
}

// String futureDate = convertDate(transferDate);
/*
 * //getDynamicElementClick("Future Payment Activity", "Select Future date",date
 * , futureDate); String transID = transactionID.substring(5, 12);
 * System.out.println(transID);
 */
// getDynamicElementClick("Future Payment Activity", "Select Transaction Link",
// transactionLink, transID);

/*
 * getDynamicElementActionClick("Future Payment Activity",
 * "Select Transaction Link", transactionLink, transactionID);
 * Thread.sleep(5000);
 */